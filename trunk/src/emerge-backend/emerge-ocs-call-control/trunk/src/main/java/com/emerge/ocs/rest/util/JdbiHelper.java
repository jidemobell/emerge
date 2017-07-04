package com.emerge.ocs.rest.util;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import java.sql.DriverManager;
import java.sql.SQLException;
//import org.h2.jdbcx.JdbcConnectionPool;

/**
 * @author Edeh Chigozie
 */
public class JdbiHelper {

    public JdbiHelper() {

    }
    
    private static DBI dbi = null;

    public DBI getDBI() {
        try {
            if (JdbiHelper.dbi == null) {
                DriverManager.registerDriver(new org.postgresql.Driver());
                //JdbiHelper.dbi = new DBI(DBResource.getDataSource());
                  JdbiHelper.dbi = new DBI("jdbc:postgresql://"
                        + "lx-dev-emea-emerge-rdbms-pg-01:5432/ocs",
                        "postgres", "");
            }

        } catch (SQLException e) {
        }

        return JdbiHelper.dbi;
    }

//    public DBI get_DBI() {
//        JdbcConnectionPool ds = JdbcConnectionPool.create("jdbc:h2:mem:postgresql://localhost:5432/ocs", "postgres", "EMERGE");
//        DBI dbi = new DBI(ds);
//        return dbi;
//    }
    /**
     * Return a handle suitable for use in a transaction operation, i.e. with
     * autoCommit = false.
     */
    public Handle getTxHandle() {
       final Handle handle = getDBI().open();
        try {
            handle.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new IllegalStateException("Caught an SQLException. errorCode=" + e.getErrorCode());
        }
        return handle;
    }

    public void dropTableIfExist(String something) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
