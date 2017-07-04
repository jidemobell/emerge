package com.emerge.ocs.rest.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import org.skife.jdbi.v2.DBI;
//import org.skife.jdbi.v2.Handle;

/**
 * @author Edeh Chigozie
 */
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
//                JdbiHelper.dbi = new DBI(DBResource.getDataSource());
                JdbiHelper.dbi = new DBI("jdbc:postgresql://"
                        + "lx-dev-emea-emerge-rdbms-pg-01:5432/ocs",
                        "postgres", "");
//                
//                JdbiHelper.dbi = new DBI("jdbc:postgresql://"
//                        + "localhost:5432/ocs",
//                        "postgres", "password");
////                
            }

        } catch (SQLException e) {
        }

        return JdbiHelper.dbi;
    }

    /**
     * Return a handle suitable for use in a transaction operation, i.e. with
     * autoCommit = false.
     *
     * @return dbi handle
     */    
}
