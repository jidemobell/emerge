///*
// * To change this license header, choose License Headers in Project Properties
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.emerge.ocs;
//
//import com.emerge.ocs.rest.test.TestPreloadedModelProvider;
//import com.emerge.ocs.rest.test.TestPreloadedModelProvider2;
//import com.emerge.ocs.rest.test.TestPreloadedModelProvider4;
//import static com.jayway.restassured.RestAssured.given;
//import static com.jayway.restassured.http.ContentType.JSON;
//import com.jayway.restassured.response.Response;
//import java.math.BigDecimal;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.Matchers.greaterThan;
//import static org.hamcrest.Matchers.lessThan;
//import org.junit.Test;
//
///**
// *
// * @author Adebowale
// */
//public class FunctionalTest {
//   
//    TestPreloadedModelProvider testPreloadedModelProvider = TestPreloadedModelProvider.SingleInstance();
//    TestPreloadedModelProvider2 testPreloadedModelProvider2 = TestPreloadedModelProvider2.SingleInstance();
//    TestPreloadedModelProvider4 testPreloadedModelProvider4 = TestPreloadedModelProvider4.SingleInstance();
//    
////    //Successful Payphone Authentication with changed equipment details
////    @Test
////    public void validPayphoneAuthentication1() {
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider2.getAuthenticationReq2()).
////        when().
////                post("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/authenticate").
////        then().
////                statusCode(200).
////                contentType(JSON).
////                body("message", equalTo("Payphone Authenticated")).
////                body("accessToken.length()", greaterThan(40)).
////                body("sessionID", greaterThan(0)).
////                body("sessionStartTime.length()", greaterThan(10)).
////                body("configData.defaultLanguage", equalTo("PORTUGUESE")).
////                body("configData.keepAliveInterval", is(0)).
////                body("configData.sendErrorsToOCS", is(3)).
////                body("configData.silenceMode", equalTo(Boolean.TRUE)).
////                body("configData.creditButtons.size()", equalTo(0)).
////                body("balance", equalTo("2.1000000000000001"));
////    }
////    
////    //Successful Payphone Authentication with active version status
////    @Test
////    public void validPayphoneAuthentication2() {
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider2.getAuthenticationReq()).
////        when().
////                post("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/authenticate").
////        then().
////                statusCode(200).
////                contentType(JSON).
////                body("message", equalTo("Payphone Authenticated")).
////                body("accessToken.length()", greaterThan(40)).
////                body("sessionID", greaterThan(0)).
////                body("sessionStartTime.length()", greaterThan(10)).
////                body("configData.defaultLanguage", equalTo("PORTUGUESE")).
////                body("configData.keepAliveInterval", is(0)).
////                body("configData.sendErrorsToOCS", is(3)).
////                body("configData.silenceMode", equalTo(Boolean.TRUE)).
////                body("configData.creditButtons.size()", equalTo(0)).
////                body("balance", equalTo("2.1000000000000001"));
////    }
////      
////    //Payphone Authentication fails due to invalid username and password
////    @Test
////    public void InvalidPayphoneAuthentication1() {
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider2.getInvalidAuthenticationReq1()).
////        when().
////                post("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/authenticate").
////        then().
////                contentType(JSON).
////                statusCode(200).
////                body("sessionID", equalTo(0)).
////                body("code", equalTo("400")).
////                body("message", equalTo("Payphone Upgrade Required"));
////    }
////    
////    //Payphone Authentication fails due to invalid SIM1 information
////    @Test
////    public void InvalidPayphoneAuthentication2() {
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider2.getInvalidAuthenticationReq2()).
////        when().
////                post("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/authenticate").
////        then().
////                contentType(JSON).
////                statusCode(200).
////                body("sessionID", equalTo(0)).
////                body("code", equalTo("400")).
////                body("message", equalTo("Payphone Upgrade Required"));
////    }
////    
////    //Payphone Authentication fails due to invalid SIM2 information
////    @Test
////    public void InvalidPayphoneAuthentication3() {
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider2.getInvalidAuthenticationReq3()).
////        when().
////                post("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/authenticate").
////        then().
////                contentType(JSON).
////                statusCode(200).
////                body("sessionID", equalTo(0)).
////                body("code", equalTo("400")).
////                body("message", equalTo("Payphone Upgrade Required"));
////    }
////    
////    //Payphone Authentication fails due to old application version
////    @Test
////    public void InvalidPayphoneAuthentication4() {
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider4.getAuthenticationReq()).
////        when().
////                post("http://localhost:8080/ocs/v1/payphones/callcontrol/authenticate").
////        then().
////                contentType(JSON).
////                statusCode(200).
////                body("sessionID", equalTo(0)).
////                body("code", equalTo("400")).
////                body("message", equalTo("Payphone Upgrade Required"));
////    }
////    
////    //Successful Payphone Session Start with changed equipment details
////    @Test
////    public void validPayphoneSessionStart1() {
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider2.getAuthenticationReq2()).
////        when().
////                post("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/session").
////        then().
////                statusCode(200).
////                contentType(JSON).
////                body("message", equalTo("Payphone Authenticated")).
////                body("accessToken.length()", greaterThan(40)).
////                body("sessionID", greaterThan(0)).
////                body("sessionStartTime.length()", greaterThan(10)).
////                body("configData.defaultLanguage", equalTo("PORTUGUESE")).
////                body("configData.keepAliveInterval", is(0)).
////                body("configData.sendErrorsToOCS", is(3)).
////                body("configData.silenceMode", equalTo(Boolean.TRUE)).
////                body("configData.creditButtons.size()", equalTo(0)).
////                body("balance", equalTo("2.1000000000000001"));
////    }
////    
////    //Successful Payphone Session Start with active version status
////    @Test
////    public void validPayphoneSessionStart2() {
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider2.getAuthenticationReq()).
////        when().
////                post("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/session").
////        then().
////                statusCode(200).
////                contentType(JSON).
////                body("message", equalTo("Payphone Authenticated")).
////                body("accessToken.length()", greaterThan(40)).
////                body("sessionID", greaterThan(0)).
////                body("sessionStartTime.length()", greaterThan(10)).
////                body("configData.defaultLanguage", equalTo("PORTUGUESE")).
////                body("configData.keepAliveInterval", is(0)).
////                body("configData.sendErrorsToOCS", is(3)).
////                body("configData.silenceMode", equalTo(Boolean.TRUE)).
////                body("configData.creditButtons.size()", equalTo(0)).
////                body("balance", equalTo("2.1000000000000001"));
////    }
////    
////    //Payphone Session Start fails due to invalid username and password
////    @Test
////    public void InvalidPayphoneSessionStart1(){
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider2.getInvalidAuthenticationReq1()).
////        when().
////                post("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/session").
////        then().
////                contentType(JSON).
////                statusCode(200).
////                body("sessionID", equalTo(0)).
////                body("code", equalTo("400")).
////                body("message", equalTo("Payphone Upgrade Required"));
////    }
////    
////    //Payphone Session Start fails due to invalid SIM1 information
////    @Test
////    public void InvalidPayphoneSessionStart2() {
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider2.getInvalidAuthenticationReq2()).
////        when().
////                post("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/session").
////        then().
////                contentType(JSON).
////                statusCode(200).
////                body("sessionID", equalTo(0)).
////                body("code", equalTo("400")).
////                body("message", equalTo("Payphone Upgrade Required"));
////    }  
////    
////    //Payphone Session Start fails due to invalid SIM2 information
////    @Test
////    public void InvalidPayphoneSessionStart3() {
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider2.getInvalidAuthenticationReq3()).
////        when().
////                post("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/session").
////        then().
////                contentType(JSON).
////                statusCode(200).
////                body("sessionID", equalTo(0)).
////                body("code", equalTo("400")).
////                body("message", equalTo("Payphone Upgrade Required"));
////    }
////    
////    //Payphone Session Start fails due to old application version
////    @Test
////    public void InvalidPayphoneSessionStart4() {
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider4.getAuthenticationReq()).
////        when().
////                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session").
////        then().
////                contentType(JSON).
////                statusCode(200).
////                body("sessionID", equalTo(0)).
////                body("code", equalTo("400")).
////                body("message", equalTo("Payphone Upgrade Required"));
////    }
////    
////    //Successful Resume Payphone Session
////    @Test
////    public void ResumePayphoneSession(){
////        //Start a session to generate access token and session ID
////        Response sessionResponse = given().
////                contentType(JSON).
////                body(testPreloadedModelProvider2.getAuthenticationReq()).
////        when().
////                post("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/session").
////        then().
////                statusCode(200).
////                contentType(JSON).
////                body("message", equalTo("Payphone Authenticated")).
////        extract().
////                response();
////        
////        String sessionAccessToken = sessionResponse.path("accessToken");
////        int sessionSessionID = sessionResponse.path("sessionID");
////        
////        //Successful Resume Payphone Session
////        given().
////                contentType(JSON).
////                header("accessToken", sessionAccessToken).
////                header("sessionid", sessionSessionID).
////        when().
////                put("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/session").
////        then().
////                contentType(JSON).
////                statusCode(200).
////                body("code", equalTo(200)).
////                body("message", equalTo("Session resumed"));
////        
////        //Session Resume fails due to invalid access token
////        given().
////                contentType(JSON).
////                header("accessToken", "hdfb").
////                header("sessionid", sessionSessionID).
////        when().
////                put("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/session").
////        then().
////                contentType(JSON).
////                statusCode(200).
////                body("code", equalTo(401)).
////                body("type", equalTo("unknown")).
////                body("message", equalTo("unexpected error"));
////        
////        //Session Resume fails due to invalid session ID
////        given().
////                contentType(JSON).
////                header("accessToken", sessionAccessToken).
////                header("sessionid", "555555").
////        when().
////                put("http://192.168.0.31:8080/ocs/v1/payphones/callcontrol/session").
////        then().
////                contentType(JSON).
////                statusCode(200).
////                body("code", equalTo(401)).
////                body("type", equalTo("unknown")).
////                body("message", equalTo("unexpected error"));
////    }
//
//    @Test
//    public void StartService(){
//        Response sessionResponse = given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getAuthenticationReq()).
//        when().
//                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session").
//        then().
//                statusCode(200).
//                contentType(JSON).
//                body("message", equalTo("Payphone Authenticated")).
//        extract().
//                response();
//        
//        String sessionAccessToken = sessionResponse.path("accessToken");
//        int sessionSessionID = sessionResponse.path("sessionID");
//        
//        //Successful Start Service Request
//        testPreloadedModelProvider.getStartServiceRequest().setAccessToken(sessionAccessToken);
//        testPreloadedModelProvider.getStartServiceRequest().sessionId(sessionSessionID);  
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getStartServiceRequest()).
//        when().
//                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(200).
//                contentType(JSON).
//                body("serviceId", greaterThan(0)).
//                body("originMsisdn", equalTo("1234567890")).
//                body("serviceAuthorizedTime", greaterThan(100000000l)).
//                body("maxServiceDuration", is(120f)).
//                body("tariff.id", is(1)).
//                body("tariff.groupId", is(1)).
//                body("tariff.zoneId", is(1)).
//                body("tariff.cost", is(300f));
//        
//        //Start Service request fails due to invalid access token
//        testPreloadedModelProvider.getStartServiceRequest().setAccessToken("hgsfuybedufb");
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getStartServiceRequest()).
//        when().
//                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(200).
//                contentType(JSON);
//        
//        //Start Service request fails due to invalid session id
//        testPreloadedModelProvider.getStartServiceRequest().setAccessToken(sessionAccessToken);
//        testPreloadedModelProvider.getStartServiceRequest().sessionId(99);
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getStartServiceRequest()).
//        when().
//                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(200).
//                contentType(JSON);
//        
//        //Start Service request fails due to service credit = 0
//        testPreloadedModelProvider.getInvalidStartServiceRequest1().setAccessToken(sessionAccessToken);
//        testPreloadedModelProvider.getInvalidStartServiceRequest1().sessionId(sessionSessionID);
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getInvalidStartServiceRequest1()).
//        when().
//                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(200).
//                contentType(JSON);
//        
//        //Start Service request fails due to invalid destination MSISDN
//        testPreloadedModelProvider.getInvalidStartServiceRequest2().setAccessToken(sessionAccessToken);
//        testPreloadedModelProvider.getInvalidStartServiceRequest2().sessionId(sessionSessionID);
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getInvalidStartServiceRequest2()).
//        when().
//                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(500);
//        
//        //Start Service request fails due to invalid payphone id
//        testPreloadedModelProvider.getStartServiceRequest().setAccessToken(sessionAccessToken);
//        testPreloadedModelProvider.getStartServiceRequest().sessionId(sessionSessionID);
//        testPreloadedModelProvider.getStartServiceRequest().setId(2000);
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getStartServiceRequest()).
//        when().
//                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(500);
//    }
//    
//    @Test
//    public void NotifyStartService(){
//        Response sessionResponse = given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getAuthenticationReq()).
//        when().
//                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session").
//        then().
//                statusCode(200).
//                contentType(JSON).
//                body("message", equalTo("Payphone Authenticated")).
//        extract().
//                response();
//        
//        String sessionAccessToken = sessionResponse.path("accessToken");
//        int sessionSessionID = sessionResponse.path("sessionID");
//        
//        //Successful Start Service Request
//        testPreloadedModelProvider.getStartServiceRequest().setAccessToken(sessionAccessToken);
//        testPreloadedModelProvider.getStartServiceRequest().sessionId(sessionSessionID);  
//        Response serviceResponse = given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getStartServiceRequest()).
//        when().
//                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(200).
//                contentType(JSON).
//                body("serviceId", greaterThan(0)).
//        extract().
//                response();
//        
//        int serviceId = serviceResponse.path("serviceId");
//        
//        //Successful Notify Start Service Request
//        testPreloadedModelProvider.getServiceParams().setServiceId(serviceId);
//        testPreloadedModelProvider.getServiceParams().setServiceStartTime(new Date());
//        testPreloadedModelProvider.getServiceParams().setSessionId(sessionSessionID);
//        testPreloadedModelProvider.getServiceParams().setAccessToken(sessionAccessToken);
//        testPreloadedModelProvider.getServiceParams().setCallAnswerTime(new Date());
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getServiceParams()).
//        when().
//                put("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(200).
//                contentType(JSON).
//                body("message", equalTo("Start service notified!"));
//        
//        //Notify Start Service request fails due to invalid access token
//        testPreloadedModelProvider.getServiceParams().setAccessToken("eryyteruu");
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getServiceParams()).
//        when().
//                put("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(200).
//                contentType(JSON);
//        
//        //Notify Start Service request fails due to invalid service ID
//        testPreloadedModelProvider.getServiceParams().setAccessToken(sessionAccessToken);
//        testPreloadedModelProvider.getServiceParams().setServiceId(100000);
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getServiceParams()).
//        when().
//                put("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(500);
//        
//        //Notify Start Service request fails due to invalid session ID
//        testPreloadedModelProvider.getServiceParams().setServiceId(serviceId);
//        testPreloadedModelProvider.getServiceParams().setSessionId(1000000);
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getServiceParams()).
//        when().
//                put("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(200).
//                contentType(JSON);
//        
////        //Notify Start Service request fails due to null value for service start time
////        testPreloadedModelProvider.getServiceParams().setServiceStartTime(null);
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider.getServiceParams()).
////        when().
////                put("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
////        then().
////                statusCode(500);
////        
////        //Notify Start Service request fails due to null value for call answer time
////        testPreloadedModelProvider.getServiceParams().setCallAnswerTime(null);
////        testPreloadedModelProvider.getServiceParams().setServiceStartTime(serviceStartTime);
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider.getServiceParams()).
////        when().
////                put("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
////        then().
////                statusCode(200).
////                contentType(JSON).
////                body("code", equalTo(400));
////        
//        //Notify Start Service request fails due to null value for payphone ID
//        testPreloadedModelProvider.getServiceParams().setCallAnswerTime(new Date());
//        testPreloadedModelProvider.getServiceParams().setPayphoneID(null);
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getServiceParams()).
//        when().
//                put("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(200).
//                contentType(JSON);
//    }
//    
//    @Test
//    public void EndService(){
//        Response sessionResponse = given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getAuthenticationReq()).
//        when().
//                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session").
//        then().
//                statusCode(200).
//                contentType(JSON).
//                body("message", equalTo("Payphone Authenticated")).
//        extract().
//                response();
//        
//        String sessionAccessToken = sessionResponse.path("accessToken");
//        int sessionSessionID = sessionResponse.path("sessionID");
//        
//        //Successful Start Service Request
//        testPreloadedModelProvider.getStartServiceRequest().setAccessToken(sessionAccessToken);
//        testPreloadedModelProvider.getStartServiceRequest().sessionId(sessionSessionID);  
//        Response serviceResponse = given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getStartServiceRequest()).
//        when().
//                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(200).
//                contentType(JSON).
//                body("serviceId", greaterThan(0)).
//        extract().
//                response();
//        
//        int serviceId = serviceResponse.path("serviceId");
//        
//        testPreloadedModelProvider.getServiceParams().setServiceStartTime(new Date());
//        testPreloadedModelProvider.getServiceParams().setCallAnswerTime(new Date());
//        testPreloadedModelProvider.getEndServiceReq().setCallAnswerTime(new Date());
//        testPreloadedModelProvider.getEndServiceReq().setServiceStartTime(new Date());
//        
//        //Successful Notify Start Service Request
//        testPreloadedModelProvider.getServiceParams().setServiceId(serviceId);
//        testPreloadedModelProvider.getServiceParams().setSessionId(sessionSessionID);
//        testPreloadedModelProvider.getServiceParams().setAccessToken(sessionAccessToken);
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getServiceParams()).
//        when().
//                put("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(200).
//                contentType(JSON).
//                body("message", equalTo("Start service notified!"));
//        
//        //Successful End Service Request
//        testPreloadedModelProvider.getEndServiceReq().setAccessToken(sessionAccessToken);
//        testPreloadedModelProvider.getEndServiceReq().setSessionId(sessionSessionID);
//        testPreloadedModelProvider.getEndServiceReq().setServiceId(serviceId);
//        given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getEndServiceReq()).
//        when().
//                delete("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
//        then().
//                statusCode(200).
//                contentType(JSON).
//                body("payphone_device_id", is(1)).
//                body("origin", equalTo("1234567890")).
//                body("destination", equalTo("+2348034609060")).
//                body("tariff_id", is(1)).
//                body("call_authorization_time", greaterThan(1000000l)).
//                body("start_time.length()", greaterThan(6)).
//                body("call_answer_time.length()", greaterThan(6)).
//                body("id", greaterThan(0)).
//                body("destination_group", is("1")).
//                body("call_end_time.length()", greaterThan(6)).
//                body("call_duration", is(120)).
//                body("billed_duration", greaterThan(59)).
//                body("billed_amount", greaterThan(149f)).
//                body("initial_balance", greaterThan(0f));
//        
////        //End Service Request fails due to invalid session ID
////        testPreloadedModelProvider.getEndServiceReq().setSessionId(3100);
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider.getEndServiceReq()).
////        when().
////                delete("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
////        then().
////                statusCode(200).
////                contentType(JSON);
////        
////        //End Service Request fails due to invalid service ID
////        testPreloadedModelProvider.getEndServiceReq().setSessionId(sessionSessionID);
////        testPreloadedModelProvider.getEndServiceReq().setServiceId(2100);
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider.getEndServiceReq()).
////        when().
////                delete("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
////        then().
////                statusCode(200).
////                contentType(JSON);
////        
////        //End Service Request fails due to invalid access token
////        testPreloadedModelProvider.getEndServiceReq().setServiceId(serviceId);
////        testPreloadedModelProvider.getEndServiceReq().setAccessToken("asdasdnn");
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider.getEndServiceReq()).
////        when().
////                delete("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
////        then().
////                statusCode(200).
////                contentType(JSON);
////        
////        //End Service Request fails due to null Call Answer Time
////        testPreloadedModelProvider.getEndServiceReq().setAccessToken(sessionAccessToken);
////        testPreloadedModelProvider.getEndServiceReq().setCallAnswerTime(null);
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider.getEndServiceReq()).
////        when().
////                delete("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
////        then().
////                statusCode(200).
////                contentType(JSON);
////        
////        //End Service Request fails due to null Start Service Time
////        testPreloadedModelProvider.getEndServiceReq().setCallAnswerTime(serviceStartTime);
////        testPreloadedModelProvider.getEndServiceReq().setServiceStartTime(null);
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider.getEndServiceReq()).
////        when().
////                delete("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
////        then().
////                statusCode(200).
////                contentType(JSON);
////        
////        //End Service Request fails due to null Service End Time
////        testPreloadedModelProvider.getEndServiceReq().setServiceStartTime(serviceStartTime);
////        testPreloadedModelProvider.getEndServiceReq().setServiceEndTime(null);
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider.getEndServiceReq()).
////        when().
////                delete("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
////        then().
////                statusCode(200).
////                contentType(JSON);
////        
////        //End Service Request fails due to invalid Service End Time
////        testPreloadedModelProvider.getEndServiceReq().setServiceEndTime(new Date());
////        testPreloadedModelProvider.getEndServiceReq().setServiceDuration(-1);
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider.getEndServiceReq()).
////        when().
////                delete("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
////        then().
////                statusCode(200).
////                contentType(JSON);
////        
////        //End Service Request fails due to empty End Cause string
////        testPreloadedModelProvider.getEndServiceReq().setServiceDuration(60);
////        testPreloadedModelProvider.getEndServiceReq().setEndCause("");
////        given().
////                contentType(JSON).
////                body(testPreloadedModelProvider.getEndServiceReq()).
////        when().
////                delete("http://localhost:8080/ocs/v1/payphones/callcontrol/session/service").
////        then().
////                statusCode(200).
////                contentType(JSON);
//    }
//    
//    @Test
//    public void EndSession(){
//        Response sessionResponse = given().
//                contentType(JSON).
//                body(testPreloadedModelProvider.getAuthenticationReq()).
//        when().
//                post("http://localhost:8080/ocs/v1/payphones/callcontrol/session").
//        then().
//                statusCode(200).
//                contentType(JSON).
//                body("message", equalTo("Payphone Authenticated")).
//        extract().
//                response();
//        
//        String sessionAccessToken = sessionResponse.path("accessToken");
//        int sessionSessionID = sessionResponse.path("sessionID");
//        
//        String sessionStartTimeString = sessionResponse.path("sessionStartTime").toString();
//        int sessionId = sessionResponse.path("sessionID");
//        DateFormat dformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//        Date sessionStartTime = null;
//        try {
//            sessionStartTime = dformat.parse(sessionStartTimeString);
//            testPreloadedModelProvider.getEndSessionReq().setSessionStartTime(sessionStartTime);
//            testPreloadedModelProvider.getEndSessionReq().setSessionEndTime(new Date());
//        } 
//        catch (ParseException e){}
//        
//        //End Session fails due to invalid sessiond ID
//        given().
//                header("accessToken", sessionAccessToken).
//                pathParam("sessionid", 1).
//        when().
//                delete("http://localhost:8080/ocs/v1/payphones/callcontrol/session/{sessionid}").
//        then().
//                statusCode(200).
//                contentType(JSON);
//        
//        //End Session fails due to invalid sessiond ID
//        given().
//                header("accessToken", "invalid").
//                pathParam("sessionid", sessionSessionID).
//        when().
//                delete("http://localhost:8080/ocs/v1/payphones/callcontrol/session/{sessionid}").
//        then().
//                statusCode(200).
//                contentType(JSON);
//    }
//}
