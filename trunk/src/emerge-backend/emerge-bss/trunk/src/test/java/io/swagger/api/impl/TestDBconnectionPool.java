///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package io.swagger.api.impl;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
//
///**
// *
// * @author Yusuf
// */
//public class TestDBconnectionPool {
//
//    public void getConnection() throws NamingException, SQLException {
//
//        Context initialContext = new InitialContext();
//
//        Context environmentContext = (Context) initialContext.lookup("java:comp/env");
//        String dataResourceName = "jdbc/bss";
//
//        DataSource dataSource = (DataSource) environmentContext.lookup(dataResourceName);
//
//        Connection conn = dataSource.getConnection();
//        StringBuilder msg = new StringBuilder();
//
//        try (Statement stm = conn.createStatement()) {
//
//            String query = "select * from users ";
//
//            ResultSet rs = stm.executeQuery(query);
//            // Store and return result of the query
//            while (rs.next()) {
//                msg.append(rs.getString("username"));
//
//            }
//            rs.close();
//        } catch (SQLException e) {
//        } finally {
//            conn.close();
//            conn = null; // prevent any future access
//        }
//
//    }
//
//    public static void main(String args[]) throws NamingException, SQLException {
//
//        TestDBconnectionPool dbcon = new TestDBconnectionPool();
//        dbcon.getConnection();
//
//    }
//
//}
