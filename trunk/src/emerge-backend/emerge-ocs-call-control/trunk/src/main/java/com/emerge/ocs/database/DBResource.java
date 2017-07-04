/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database;

import com.emerge.ocs.rest.impl.OcsApiServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author goodson
 */
public class DBResource {

    /**
     *
     */
    private static DataSource dataSource = null;

    /**
     *
     * @return DataSource
     */
    public static DataSource getDataSource() {
        if (DBResource.dataSource != null) {
            return DBResource.dataSource;
        }

        try {
            Context initialContext = new InitialContext();
            Context environmentContext = (Context) initialContext
                    .lookup("java:comp/env");

            String dataResourceName = "jdbc/ocs_db";
            dataSource = (DataSource) environmentContext
                    .lookup(dataResourceName);

        } catch (NamingException ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return dataSource;
    }
}
