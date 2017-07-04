/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.crud;

import io.swagger.api.impl.BssContractsApiServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author akin
 */
public class DBResource {

    static DataSource dataSource = null;

    static {
        initDataSource();
    }


    /**
     *
     * @return Data source object
     */
    public static DataSource getDataSource() {
        if (dataSource == null) {
            initDataSource();
        }
        return dataSource;
    }
    
    /**
     *
     */
    private static void initDataSource() {
        try {
            Context initialContext = new InitialContext();
            Context environmentContext = (Context) initialContext
                    .lookup("java:comp/env");
            String dataResourceName = "jdbc/bss_db";
            dataSource = (DataSource) environmentContext
                    .lookup(dataResourceName);
        } catch (NamingException ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
