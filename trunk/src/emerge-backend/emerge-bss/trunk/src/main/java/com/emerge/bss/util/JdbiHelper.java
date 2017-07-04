/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.util;

/**
 *
 * @author goodson
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

public class JdbiHelper {

    /**
     *
     */
    public JdbiHelper() {

    }

    private static DBI dbi = null;

    /**
     *
     * @return dbi instance
     */
    public final static DBI getDBI() {
        try {
            if (JdbiHelper.dbi == null) {
                DriverManager.registerDriver(new org.postgresql.Driver());
                JdbiHelper.dbi = new DBI("jdbc:postgresql://"
                        + "lx-dev-emea-emerge-rdbms-pg-01:5432/bss",
                        "postgres", "");
            }

        } catch (SQLException e) {
        }

        return JdbiHelper.dbi;
    }
}
