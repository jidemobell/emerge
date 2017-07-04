///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.emerge.bss.test;
//
//import com.jayway.restassured.RestAssured;
//import org.junit.BeforeClass;
//
///**
// *
// * @author akin
// */
//public class FunctionalTest {
//
//    @BeforeClass
//    public static void setup() {
//        String port = System.getProperty("server.port");
//        if (port == null) {
//            RestAssured.port = 8080;
//        } else {
//            RestAssured.port = Integer.parseInt(port);
//        }
//
//        String basePath = System.getProperty("server.base");
//        if (basePath == null) {
//            basePath = "/BssServer";
//        }
//        RestAssured.basePath = basePath;
//
//        String baseHost = System.getProperty("server.host");
//        if (baseHost == null) {
//            baseHost = "http://localhost";
//        }
//        RestAssured.baseURI = baseHost;
//
//    }
//
//}
