///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.emerge.ocs.rest.util;
//
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import org.skife.jdbi.v2.DBI;
//
///**
// *
// * @author admin
// */
//public class HistoryJdbiHelper {
//
//    public HistoryJdbiHelper() {
//
//    }
//
//    public static DBI hdbi = null;
//
//    public final static DBI getHDBI() {
//        try {
//            if (HistoryJdbiHelper.hdbi == null) {
//                DriverManager.registerDriver(new org.postgresql.Driver());
//                HistoryJdbiHelper.hdbi = new DBI("jdbc:postgresql://"
//                        + "lx-dev-emea-emerge-rdbms-pg-01:5432/history",
//                        "postgres", "");
//
//                //HistoryJdbiHelper.hdbi = new DBI("jdbc:postgresql://"
//                //      + "localhost:5432/ocs",
//                //       "emerge", "emerge");
//            }
//
//        } catch (SQLException e) {
//        }
//
//        return HistoryJdbiHelper.hdbi;
//    }
//}
