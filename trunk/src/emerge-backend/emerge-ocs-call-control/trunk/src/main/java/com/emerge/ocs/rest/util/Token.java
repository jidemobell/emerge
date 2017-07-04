/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.rest.util;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.emerge.ocs.rest.config.TokenConfig;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kingsley
 */
public class Token {

    private final static String secret;
    private final static String issuer;
    private final static long iat;
    private final static JWTSigner signer;

    static {
        issuer = TokenConfig.tokenIssuer;
        secret = TokenConfig.tokenSecrete;
        iat = System.currentTimeMillis() / 100000L;
        signer = new JWTSigner(secret);
    }

    private static long setInterval(long interval) {
        long exp = iat + interval;
        return exp;
    }

    private static long getExpirationtime() {
        return setInterval(TokenConfig.sessionExpiringTime);
    }

    public static String getToken(HashMap<String, Object> objectList) {
        long exp = getExpirationtime();
        objectList.put("iss", issuer);
        objectList.put("exp", exp);
        objectList.put("iat", iat);
        final String token = signer.sign(objectList);

        return token;
    }

    public static String validateToken(String token) {
        String result = "";
        try {
            final JWTVerifier verifier = new JWTVerifier(secret, null, issuer);
            final Map<String, Object> claims = verifier.verify(token);
            result = "Validated";
        }catch (NoSuchAlgorithmException | InvalidKeyException | IllegalStateException | IOException | SignatureException ex) {
            result = ex.getMessage();
        } catch (JWTVerifyException ex) {
            result = ex.getMessage();
        }
        return result;
    }
    
    public static Map<String, Object>  getBody(String token) {
        Map<String, Object> claims = null;
        try {
            final JWTVerifier verifier = new JWTVerifier(secret, null, issuer);
            claims = verifier.verify(token);
            
        } catch (NoSuchAlgorithmException ex) {
        } catch (InvalidKeyException ex) {
        } catch (IllegalStateException ex) {
        } catch (IOException ex) {
        } catch (SignatureException ex) {
        } catch (JWTVerifyException ex) {
        }
        return claims;

    }

}
