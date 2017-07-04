///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.emerge.bss.test;
//
//import static com.jayway.restassured.RestAssured.given;
//import com.jayway.restassured.http.ContentType;
//import static com.jayway.restassured.http.ContentType.JSON;
//import com.jayway.restassured.response.Response;
//import io.swagger.model.ContractTemplate;
//import java.io.File;
//import java.util.Calendar;
//import java.util.Date;
//import static org.hamcrest.CoreMatchers.equalTo;
//import org.json.simple.JSONObject;
//import org.junit.Test;
//
///**
// *
// * @author akin
// */
//public class BSSTest extends FunctionalTest {
//
//    @Test
//    public void basicPingTest() {
////        long n = new long(7);
////        given().when().get("http://localhost:9080/Emerge/bss/v1/bss/provision/contracts/templates/").then().statusCode(200);
//        given().when().pathParam("customerid", "7").get("http://localhost:9080/Emerge/bss/v1/bss/provision/contract/prepaid/customer/{customerid}").then().statusCode(200);
//    }
//
//    @Test
//    public void createContractTemplate() {
//        ContractTemplate ct = new ContractTemplate();
////        ct.setAdditionalClauses("sfds");
////        ct.secondContractorName("sfdsaf");
////        ct.setFinancialTerms(null);
////        JSONObject o = new JSONObject();
////        o.put("creation_date", d.toString());
////        o.put("name", "Emeka Johnson");
////        o.put("second_contractor_name", "Name");
////        o.put("second_contractor_fiscal_number", 126263);
////        o.put("second_contractor_address", "Lagos");
////        o.put("preamble", "registration");
////        o.put("clauses", "terms and conditions");
////        o.put("expiration_conditions", "non performance");
////        o.put("first_contractor", "Telo Pay");
////        o.put("service", "telo phones");
//
//        given().contentType(JSON).body(ct.toString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/contracts/templates/").then().statusCode(200);
//    }
//
//    @Test
//    public Response confirmContract() {
//        Date d = Calendar.getInstance().getTime();
//        JSONObject o = new JSONObject();
//        o.put("creation_date", d.toString());
//        o.put("name", "Emeka Johnson");
//        o.put("second_contractor_name", "Name");
//        o.put("second_contractor_fiscal_number", 126263);
//        o.put("second_contractor_address", "Lagos");
//        o.put("preamble", "registration");
//        o.put("clauses", "terms and conditions");
//        o.put("expiration_conditions", "non performance");
//        o.put("first_contractor", "Telo Pay");
//        o.put("service", "telo phones");
//        return given().contentType(JSON).pathParam("contractId", "7").when().put("http://localhost:9080/Emerge/bss/v1/bss/provision/contract/postpaid/{contractId}/confirm").then().
//                contentType(ContentType.JSON).extract().response();
//
//    }
//    
//    @Test
//    public Response creatCustomer() {
//        JSONObject o = new JSONObject();
//        o.put("name", "Emeka Johnson");
//        o.put("fiscalNumber", "123945678");
//        o.put("taxExemptionCertificate", "76guytf7698");
//        o.put("country", "Angola");
//        o.put("website", "www.webiste.com");
//        o.put("privateNotes", "terms and conditions");
//        o.put("tags", "pilot customer");
//        o.put("customerAddressId", "2");
//        Response response = given().contentType(JSON).body(o.toJSONString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/customer").then().
//                contentType(ContentType.JSON).extract().response();
//        return response;
//    }
//    
//      @Test
//    public void updatetCustomer() {
//        JSONObject o = new JSONObject();
//        o.put("name", "Emeka Johnson");
//        o.put("fiscalNumber", "123945678");
//        o.put("taxExemptionCertificate", "76guytf7698");
//        o.put("country", "Angola");
//        o.put("website", "www.webiste.com");
//        o.put("privateNotes", "terms and conditions");
//        o.put("tags", "pilot customer");
//        o.put("customerAddressId", "2");
//        given().contentType(JSON).body(o.toJSONString()).pathParam("customerId", 1).when().put("http://localhost:9080/Emerge/bss/v1/bss/provision/customer/{customerId}").then().
//                contentType(ContentType.JSON).statusCode(204).body("message", equalTo("Successful"));
//      
//    }
//    
//
//      @Test
//    public Response deleteCustomer() {
//        Response response = given().contentType(JSON).pathParam("customerId", 6).when().put("http://localhost:9080/Emerge/bss/v1/bss/provision/customer/{customerId}/").then().
//                contentType(ContentType.JSON).extract().response();
//        return response;
//    }
//    
//    
//    public Response createBillingAddress() {
////        Date d = Calendar.getInstance().getTime();
//        JSONObject o = new JSONObject();
////        o.put("creation_date", d.toString());
//        o.put("addressName", "Emeka's address");
//        o.put("address", "Aluko area,onigbongbo lagos");
//        o.put("faxNumber", "34567898");
//        o.put("telephoneNumber", "23456789008");
//        o.put("notifyBySms", false);
//        o.put("notifyByEmail", true);
//        o.put("email", "www.myemail@email.com");
//        o.put("customerAddressId", "1");
//        Response response = given().contentType(JSON).body(o.toJSONString()).pathParam("customerId", 6).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/customers/{customerId}/expeditionaddress").then().
//                contentType(ContentType.JSON).statusCode(200).body("message", equalTo("Successful")).extract().response();
//        return response;
//
//    }
//    public static void main(String[] args) {
//
//        BSSTest op = new BSSTest();
//        op.rullAll();
//
//    }
//
//    private void rullAll() {
//       
//        creatCustomer();
////        updateCustomer();
////        deleteCustomer();
//
//    }
//}
