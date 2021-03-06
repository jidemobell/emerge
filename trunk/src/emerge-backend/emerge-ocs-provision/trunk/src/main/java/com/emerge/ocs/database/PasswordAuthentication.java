/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database;

/**
 *
 * @author goodson
 */
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.postgresql.util.Base64;

public final class PasswordAuthentication {
    
    /**
     * Each token produced by this class uses this identifier as a prefix.
     */
    public static final String ID = "$66$";

    /**
     * The minimum recommended cost, used by default
     */
    public static final int DEFAULT_COST = 16;

    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";

    private static final int SIZE = 128;

    private static final Pattern layout = Pattern.compile("\\$66\\$(\\d\\d?)\\$(.{43})");

    private final SecureRandom random;

    private final int cost;

    public PasswordAuthentication() {
        this(DEFAULT_COST);
    }

    /**
     * Create a password manager with a specified cost.
     *
     * @param cost the exponential computational cost of hashing a password, 0
     * to 30
     */
    public PasswordAuthentication(final int cost) {
        iterations(cost);
        /* Validate cost */
        this.cost = cost;
        this.random = new SecureRandom();
    }

    private static int iterations(final int cost) {
        if ((cost & ~0x1F) != 0) {
            throw new IllegalArgumentException("cost: " + cost);
        }
        return 1 << cost;
    }

    /**
     * Hash a password for storage.
     *
     * @return a secure authentication token to be stored for later
     * authentication
     * @password: Password character array
     */
    public String hash(char[] password) {
        byte[] salt = new byte[SIZE / 8];
        random.nextBytes(salt);
        byte[] dk = pbkdf2(password, salt, 1 << cost);
        byte[] hash = new byte[salt.length + dk.length];
        System.arraycopy(salt, 0, hash, 0, salt.length);
        System.arraycopy(dk, 0, hash, salt.length, dk.length);
        return ID + cost + '$' + Base64.encodeBytes(hash);
    }

    /**
     * Authenticate with a password and a stored password token.
     *
     * @return true if the password and token match
     */
    public boolean authenticate(char[] password, String token) {
        Matcher m = layout.matcher(token);
        if (!m.matches()) {
            throw new IllegalArgumentException("Invalid token format");
        }
        
        int iterations = iterations(Integer.parseInt(m.group(1)));
        byte[] hash = Base64.decode(m.group(2));
        byte[] salt = Arrays.copyOfRange(hash, 0, SIZE / 8);
        byte[] check = pbkdf2(password, salt, iterations);
        int zero = 0;
        for (int idx = 0; idx < check.length; ++idx) {
            zero |= hash[salt.length + idx] ^ check[idx];
        }
        return zero == 0;
    }

    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations) {
        KeySpec spec = new PBEKeySpec(password, salt, iterations, SIZE);
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance(ALGORITHM);
            return f.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("Missing algorithm: " + 
                    ALGORITHM, ex);
        } catch (InvalidKeySpecException ex) {
            throw new IllegalStateException("Invalid SecretKeyFactory", ex);
        }
    }

    /**
     * Hash a password in an immutable {@code String}.
     *
     * <p>
     * Passwords should be stored in a {@code char[]} so that it can be filled
     * with zeros after use instead of lingering on the heap and elsewhere.
     *
     * @return String of hashed password.
     * @deprecated Use {@link #hash(char[])} instead
     */
    @Deprecated
    public String hash(String password) {
        return hash(password.toCharArray());
    }

    /**
     * Authenticate with a password in an immutable {@code String} and a stored
     * password token.
     *  
     * @deprecated Use {@link #authenticate(char[],String)} instead.
     * @return String of hashed password.
     * @see #hash(String)
     */
    @Deprecated
    public boolean authenticate(String password, String token) {
        return authenticate(password.toCharArray(), token);
    }

}
