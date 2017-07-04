/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.util.StringMapper;

/**
 *
 * @author akin
 */
public class Server {

    static String testdb() {
        
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","gautam");
//            System.out.println(connection);
//        } catch (SQLException ex) {
//            
//            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
        // using in-memory H2 database
       DBI dbi = new DBI("jdbc:postgresql://localhost:5432/bss",
//                    DBI dbi = new DBI("jdbc:mysql://localhost:3306/bss",
        "postgres", "d4v1doy3");
       String name;
        try (Handle h = dbi.open()) {
//            h.execute("create table something (id int primary key, name varchar(100))");
//            h.execute("insert into something (id, name) values (?, ?)", 1, "Brian");
            name = h.createQuery("select name from something where id = :id")
                    .bind("id", 1)
                    .map(StringMapper.FIRST)
                    .first();
        }

        return name;
    }

}
