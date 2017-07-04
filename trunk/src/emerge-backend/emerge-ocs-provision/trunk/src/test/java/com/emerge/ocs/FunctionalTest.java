/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs;

//mport com.emerge.ocs.rest.test.TestPreloadedModelProvider2;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.http.ContentType.JSON;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

/**
 *
 * @author Adebowale
 */
public class FunctionalTest {
   // TestPreloadedModelProvider2 testPreloadedModelProvider2 = TestPreloadedModelProvider2.SingleInstance();
    public static String searchResponseAsString;
    
    //Payphone Service creation fails due to existing username
//    @Test
//    public void invalidCreatePayphoneService1() {
//        given().
//                contentType(JSON).
//                header("umUserHash", "qweqre").
//                header("umSessionID", "qwrwq").
//                header("umDomain", "ocs.emerge.com").
//                body(testPreloadedModelProvider2.getPayphoneService()).
//        when().
//                post("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(500).
//                contentType(JSON).
//                body("type", equalTo("error"));
//    }
//    
//    //Payphone Service creation fails due to null username
//    @Test
//    public void invalidCreatePayphoneService2() {
//        given().
//                contentType(JSON).
//                header("umUserHash", "qweqre").
//                header("umSessionID", "qwrwq").
//                header("umDomain", "ocs.emerge.com").
//                body(testPreloadedModelProvider2.getInvalidPayphoneService7()).
//        when().
//                post("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(500).
//                contentType(JSON).
//                body("type", equalTo("error"));
//    }
//    
//    //Payphone Service creation fails due to null SIM1 MSISDN
//    @Test
//    public void invalidCreatePayphoneService3() {
//        given().
//                contentType(JSON).
//                header("umUserHash", "qweqre").
//                header("umSessionID", "qwrwq").
//                header("umDomain", "ocs.emerge.com").
//                body(testPreloadedModelProvider2.getInvalidPayphoneService1()).
//        when().
//                post("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(500).
//                contentType(JSON).
//                body("type", equalTo("error"));
//    }
//    
//    //Payphone Service creation fails due to null SIM1 IMSI
//    @Test
//    public void invalidCreatePayphoneService4() {
//        given().
//                contentType(JSON).
//                header("umUserHash", "qweqre").
//                header("umSessionID", "qwrwq").
//                header("umDomain", "ocs.emerge.com").
//                body(testPreloadedModelProvider2.getInvalidPayphoneService2()).
//        when().
//                post("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(500).
//                contentType(JSON).
//                body("type", equalTo("error"));
//    }
//    
//    //Payphone Service creation fails due to null SIM1 ICCID
//    @Test
//    public void invalidCreatePayphoneService5() {
//        given().
//                contentType(JSON).
//                header("umUserHash", "qweqre").
//                header("umSessionID", "qwrwq").
//                header("umDomain", "ocs.emerge.com").
//                body(testPreloadedModelProvider2.getInvalidPayphoneService3()).
//        when().
//                post("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(500).
//                contentType(JSON).
//                body("type", equalTo("error"));
//    }
//    
//    //Payphone Service creation fails due to null SIM2 MSISDN
//    @Test
//    public void invalidCreatePayphoneService6() {
//        given().
//                contentType(JSON).
//                header("umUserHash", "qweqre").
//                header("umSessionID", "qwrwq").
//                header("umDomain", "ocs.emerge.com").
//                body(testPreloadedModelProvider2.getInvalidPayphoneService4()).
//        when().
//                post("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(500).
//                contentType(JSON).
//                body("type", equalTo("error"));
//    }
//    
//    //Payphone Service creation fails due to null SIM2 IMSI
//    @Test
//    public void invalidCreatePayphoneService7() {
//        given().
//                contentType(JSON).
//                header("umUserHash", "qweqre").
//                header("umSessionID", "qwrwq").
//                header("umDomain", "ocs.emerge.com").
//                body(testPreloadedModelProvider2.getInvalidPayphoneService5()).
//        when().
//                post("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(500).
//                contentType(JSON).
//                body("type", equalTo("error"));
//    }
//    
//    //Payphone Service creation fails due to null SIM2 ICCID
//    @Test
//    public void invalidCreatePayphoneService8() {
//        given().
//                contentType(JSON).
//                header("umUserHash", "qweqre").
//                header("umSessionID", "qwrwq").
//                header("umDomain", "ocs.emerge.com").
//                body(testPreloadedModelProvider2.getInvalidPayphoneService6()).
//        when().
//                post("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(500).
//                contentType(JSON).
//                body("type", equalTo("error"));
//    }
//    
//    //Payphone Service creation fails due to null status field
//    @Test
//    public void invalidCreatePayphoneService9() {
//        given().
//                contentType(JSON).
//                header("umUserHash", "qweqre").
//                header("umSessionID", "qwrwq").
//                header("umDomain", "ocs.emerge.com").
//                body(testPreloadedModelProvider2.getInvalidPayphoneService8()).
//        when().
//                post("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(500).
//                contentType(JSON).
//                body("type", equalTo("error"));
//    }
//    
//    @Test
//    public void SearchPayphoneService(){
//        //search by valid username
//        given().
//                queryParam("username", "wecking7").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(1)).
//                body("total", is(1)).
//                body("offset", is(0)).
//                body("data.credentials.username", hasItem("wecking7")).
//                body("data.id", hasItem(8)).
//                body("data.payphoneDeviceId", hasItem(8)).
//                body("data.sim1.iccid", hasItem("qwertyuiop")).
//                body("data.sim1.imsi", hasItem("7410258963")).
//                body("data.sim1.msisdn", hasItem("0022002200")).
//                body("data.sim2.iccid", hasItem("poiuytrewq")).
//                body("data.sim2.imsi", hasItem("9988778899")).
//                body("data.sim2.msisdn", hasItem("8855223366")).
//                body("data.customerId", hasItem(0)).
//                body("data.contractId", hasItem(500)).
//                body("data.profileId", hasItem(2)).
//                body("data.balance", hasItem(2223.98f)).
//                body("data.status.status", hasItem("ACTIVE")).
//                body("data.configData.keepAliveInterval", hasItem(0)).
//                body("data.configData.sendErrorsToOCS", hasItem(0)).
//                body("data.configData.preferredMSISDN", hasItem("0022002200")).
//                body("data.configData.silenceMode", hasItem(false)).
//                body("data.configData.creditButtons.size()", is(1));
//        
//        //search by invalid username
//        given().
//                queryParam("username", "invalid").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(0)).
//                body("total", is(0)).
//                body("offset", is(0));
//        
//        //search by valid mac
//        given().
//                queryParam("mac", "dwusfbdufj").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(1)).
//                body("total", is(1)).
//                body("offset", is(0)).
//                body("data.credentials.username", hasItem("wecking7")).
//                body("data.id", hasItem(8)).
//                body("data.payphoneDeviceId", hasItem(8)).
//                body("data.sim1.iccid", hasItem("qwertyuiop")).
//                body("data.sim1.imsi", hasItem("7410258963")).
//                body("data.sim1.msisdn", hasItem("0022002200")).
//                body("data.sim2.iccid", hasItem("poiuytrewq")).
//                body("data.sim2.imsi", hasItem("9988778899")).
//                body("data.sim2.msisdn", hasItem("8855223366")).
//                body("data.customerId", hasItem(0)).
//                body("data.contractId", hasItem(500)).
//                body("data.profileId", hasItem(2)).
//                body("data.balance", hasItem(2223.98f)).
//                body("data.status.status", hasItem("ACTIVE")).
//                body("data.configData.keepAliveInterval", hasItem(0)).
//                body("data.configData.sendErrorsToOCS", hasItem(0)).
//                body("data.configData.preferredMSISDN", hasItem("0022002200")).
//                body("data.configData.silenceMode", hasItem(false)).
//                body("data.configData.creditButtons.size()", is(1));
//        
//        //search by invalid mac
//        given().
//                queryParam("mac", "invalid").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(0)).
//                body("total", is(0)).
//                body("offset", is(0));
//        
//        //search by valid IMEI 1
//        given().
//                queryParam("imei", "2437t74y34").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(1)).
//                body("total", is(1)).
//                body("offset", is(0)).
//                body("data.credentials.username", hasItem("wecking7")).
//                body("data.id", hasItem(8)).
//                body("data.payphoneDeviceId", hasItem(8)).
//                body("data.sim1.iccid", hasItem("qwertyuiop")).
//                body("data.sim1.imsi", hasItem("7410258963")).
//                body("data.sim1.msisdn", hasItem("0022002200")).
//                body("data.sim2.iccid", hasItem("poiuytrewq")).
//                body("data.sim2.imsi", hasItem("9988778899")).
//                body("data.sim2.msisdn", hasItem("8855223366")).
//                body("data.customerId", hasItem(0)).
//                body("data.contractId", hasItem(500)).
//                body("data.profileId", hasItem(2)).
//                body("data.balance", hasItem(2223.98f)).
//                body("data.status.status", hasItem("ACTIVE")).
//                body("data.configData.keepAliveInterval", hasItem(0)).
//                body("data.configData.sendErrorsToOCS", hasItem(0)).
//                body("data.configData.preferredMSISDN", hasItem("0022002200")).
//                body("data.configData.silenceMode", hasItem(false)).
//                body("data.configData.creditButtons.size()", is(1));
//        
//        //search by valid IMEI 2
//        given().
//                queryParam("imei", "545678674545").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(1)).
//                body("total", is(1)).
//                body("offset", is(0)).
//                body("data.credentials.username", hasItem("wecking7")).
//                body("data.id", hasItem(8)).
//                body("data.payphoneDeviceId", hasItem(8)).
//                body("data.sim1.iccid", hasItem("qwertyuiop")).
//                body("data.sim1.imsi", hasItem("7410258963")).
//                body("data.sim1.msisdn", hasItem("0022002200")).
//                body("data.sim2.iccid", hasItem("poiuytrewq")).
//                body("data.sim2.imsi", hasItem("9988778899")).
//                body("data.sim2.msisdn", hasItem("8855223366")).
//                body("data.customerId", hasItem(0)).
//                body("data.contractId", hasItem(500)).
//                body("data.profileId", hasItem(2)).
//                body("data.balance", hasItem(2223.98f)).
//                body("data.status.status", hasItem("ACTIVE")).
//                body("data.configData.keepAliveInterval", hasItem(0)).
//                body("data.configData.sendErrorsToOCS", hasItem(0)).
//                body("data.configData.preferredMSISDN", hasItem("0022002200")).
//                body("data.configData.silenceMode", hasItem(false)).
//                body("data.configData.creditButtons.size()", is(1));
//        
//        //search by invalid IMEI
//        given().
//                queryParam("imei", "invalid").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(0)).
//                body("total", is(0)).
//                body("offset", is(0));
//        
//        //search by valid SIM1 MSISDN
//        given().
//                queryParam("msisdn", "0022002200").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(1)).
//                body("total", is(1)).
//                body("offset", is(0)).
//                body("data.credentials.username", hasItem("wecking7")).
//                body("data.id", hasItem(8)).
//                body("data.payphoneDeviceId", hasItem(8)).
//                body("data.sim1.iccid", hasItem("qwertyuiop")).
//                body("data.sim1.imsi", hasItem("7410258963")).
//                body("data.sim1.msisdn", hasItem("0022002200")).
//                body("data.sim2.iccid", hasItem("poiuytrewq")).
//                body("data.sim2.imsi", hasItem("9988778899")).
//                body("data.sim2.msisdn", hasItem("8855223366")).
//                body("data.customerId", hasItem(0)).
//                body("data.contractId", hasItem(500)).
//                body("data.profileId", hasItem(2)).
//                body("data.balance", hasItem(2223.98f)).
//                body("data.status.status", hasItem("ACTIVE")).
//                body("data.configData.keepAliveInterval", hasItem(0)).
//                body("data.configData.sendErrorsToOCS", hasItem(0)).
//                body("data.configData.preferredMSISDN", hasItem("0022002200")).
//                body("data.configData.silenceMode", hasItem(false)).
//                body("data.configData.creditButtons.size()", is(1));
//        
//        //search by valid SIM2 MSISDN
//        given().
//                queryParam("msisdn", "8855223366").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(1)).
//                body("total", is(1)).
//                body("offset", is(0)).
//                body("data.credentials.username", hasItem("wecking7")).
//                body("data.id", hasItem(8)).
//                body("data.payphoneDeviceId", hasItem(8)).
//                body("data.sim1.iccid", hasItem("qwertyuiop")).
//                body("data.sim1.imsi", hasItem("7410258963")).
//                body("data.sim1.msisdn", hasItem("0022002200")).
//                body("data.sim2.iccid", hasItem("poiuytrewq")).
//                body("data.sim2.imsi", hasItem("9988778899")).
//                body("data.sim2.msisdn", hasItem("8855223366")).
//                body("data.customerId", hasItem(0)).
//                body("data.contractId", hasItem(500)).
//                body("data.profileId", hasItem(2)).
//                body("data.balance", hasItem(2223.98f)).
//                body("data.status.status", hasItem("ACTIVE")).
//                body("data.configData.keepAliveInterval", hasItem(0)).
//                body("data.configData.sendErrorsToOCS", hasItem(0)).
//                body("data.configData.preferredMSISDN", hasItem("0022002200")).
//                body("data.configData.silenceMode", hasItem(false)).
//                body("data.configData.creditButtons.size()", is(1));
//        
//        //search by invalid MSISDN
//        given().
//                queryParam("msisdn", "invalid").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(0)).
//                body("total", is(0)).
//                body("offset", is(0));
//        
//        //search by valid SIM1 ICCID
//        given().
//                queryParam("iccid", "qwertyuiop").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(1)).
//                body("total", is(1)).
//                body("offset", is(0)).
//                body("data.credentials.username", hasItem("wecking7")).
//                body("data.id", hasItem(8)).
//                body("data.payphoneDeviceId", hasItem(8)).
//                body("data.sim1.iccid", hasItem("qwertyuiop")).
//                body("data.sim1.imsi", hasItem("7410258963")).
//                body("data.sim1.msisdn", hasItem("0022002200")).
//                body("data.sim2.iccid", hasItem("poiuytrewq")).
//                body("data.sim2.imsi", hasItem("9988778899")).
//                body("data.sim2.msisdn", hasItem("8855223366")).
//                body("data.customerId", hasItem(0)).
//                body("data.contractId", hasItem(500)).
//                body("data.profileId", hasItem(2)).
//                body("data.balance", hasItem(2223.98f)).
//                body("data.status.status", hasItem("ACTIVE")).
//                body("data.configData.keepAliveInterval", hasItem(0)).
//                body("data.configData.sendErrorsToOCS", hasItem(0)).
//                body("data.configData.preferredMSISDN", hasItem("0022002200")).
//                body("data.configData.silenceMode", hasItem(false)).
//                body("data.configData.creditButtons.size()", is(1));
//        
//        //search by valid SIM2 ICCID
//        given().
//                queryParam("iccid", "poiuytrewq").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(1)).
//                body("total", is(1)).
//                body("offset", is(0)).
//                body("data.credentials.username", hasItem("wecking7")).
//                body("data.id", hasItem(8)).
//                body("data.payphoneDeviceId", hasItem(8)).
//                body("data.sim1.iccid", hasItem("qwertyuiop")).
//                body("data.sim1.imsi", hasItem("7410258963")).
//                body("data.sim1.msisdn", hasItem("0022002200")).
//                body("data.sim2.iccid", hasItem("poiuytrewq")).
//                body("data.sim2.imsi", hasItem("9988778899")).
//                body("data.sim2.msisdn", hasItem("8855223366")).
//                body("data.customerId", hasItem(0)).
//                body("data.contractId", hasItem(500)).
//                body("data.profileId", hasItem(2)).
//                body("data.balance", hasItem(2223.98f)).
//                body("data.status.status", hasItem("ACTIVE")).
//                body("data.configData.keepAliveInterval", hasItem(0)).
//                body("data.configData.sendErrorsToOCS", hasItem(0)).
//                body("data.configData.preferredMSISDN", hasItem("0022002200")).
//                body("data.configData.silenceMode", hasItem(false)).
//                body("data.configData.creditButtons.size()", is(1));
//        
//        //search by invalid ICCID
//        given().
//                queryParam("iccid", "invalid").
//        when().
//                get("http://localhost:8080/ocs/v1/provision/payphone-services").
//        then().
//                statusCode(200).
//                body("data.size()", is(0)).
//                body("total", is(0)).
//                body("offset", is(0));
//    }
}
