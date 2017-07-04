///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.emerge.bss.e2e;
//
///**
// *
// * @author Kolade Arowolo
// */
//import static com.jayway.restassured.RestAssured.given;
//import com.jayway.restassured.http.ContentType;
//import static com.jayway.restassured.http.ContentType.JSON;
//import com.jayway.restassured.response.Response;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import static org.hamcrest.CoreMatchers.equalTo;
//import org.json.simple.JSONObject;
//import org.junit.Test;
//
//public class BssPaymentsTests {    // The main test class
//
//    @Test
//    public void basicPingTest() {
////        long n = new long(7);
////        given().when().get("http://localhost:9080/Emerge/bss/v1/bss/provision/contracts/templates/").then().statusCode(200);
//        given().when().pathParam("customerid", "7").get("http://localhost:9080/Emerge/bss/v1/bss/provision/contract/prepaid/customer/{customerid}").then().statusCode(200);
//    }
//
//    @Test
//    public void confirmContract() {
//       JSONObject o = new JSONObject();
//       o.put("id", 14);
//       o.put("customer_id", 1);
//
//        Response r = given().contentType(JSON).pathParams(o).when().put("http://localhost:9080/bss/v1/provision/customers/{customer_id}/contracts/{id}/confirm").then().
//                contentType(ContentType.JSON).extract().response();
//        
//        String resp = r.asString();
//    }
//    
//    @Test
//    public void cancelContract() {
//       JSONObject o = new JSONObject();
//       o.put("id", 10);
//       o.put("customer_id", 1);
//
//        Response r = given().contentType(JSON).pathParams(o).when().put("http://localhost:9080/bss/v1/provision/customers/{customer_id}/contracts/{id}/cancel").then().
//                contentType(ContentType.JSON).extract().response();
//        
//        String resp = r.asString();
//    }
//
//    @Test
//    public Response creatCustomer() {
////        Date d = Calendar.getInstance().getTime();
//        JSONObject o = new JSONObject();
////        o.put("creation_date", d.toString());
//        o.put("name", "Emeka Johnson");
//        o.put("fiscalNumber", "123945678");
//        o.put("taxExemptionCertificate", "76guytf7698");
//        o.put("country", "Angola");
//        o.put("website", "www.webiste.com");
//        o.put("privateNotes", "terms and conditions");
//        o.put("tags", "pilot customer");
//        o.put("customerAddressId", "2");
//
//        Response response = given().contentType(JSON).body(o.toJSONString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/customer").then().
//                contentType(ContentType.JSON).extract().response();
//
//        return response;
//
//    }
//
//    @Test
//    public Response updateCustomer() {
////        Date d = Calendar.getInstance().getTime();
//        JSONObject o = new JSONObject();
////        o.put("creation_date", d.toString());
//        o.put("name", "Audu Suleimon");
//        o.put("fiscalNumber", "12345678");
//        o.put("taxExemptionCertificate", "76guytf7698");
//        o.put("country", "Angola");
//        o.put("website", "www.webiste.com");
//        o.put("privateNotes", "terms and conditions");
//        o.put("tags", "pilot customer");
//        o.put("customerAddressId", "1");
//
//        Response response = given().contentType(JSON).body(o.toJSONString()).pathParam("customerId", 6).when().put("http://localhost:9080/Emerge/bss/v1/bss/provision/customer/{customerId}/").then().
//                contentType(ContentType.JSON).extract().response();
//
//        return response;
//
//    }
//
//    @Test
//    public Response deleteCustomer() {
////        Date d = Calendar.getInstance().getTime();
////        JSONObject o = new JSONObject();
//////        o.put("creation_date", d.toString());
////        o.put("name", "Audu Suleimon");
////        o.put("fiscalNumber", "12345678");
////        o.put("taxExemptionCertificate", "76guytf7698");
////        o.put("country", "Angola");
////        o.put("website", "www.webiste.com");
////        o.put("privateNotes", "terms and conditions");
////        o.put("tags", "pilot customer");
////        o.put("customerAddressId", "1");
//
//        Response response = given().contentType(JSON).pathParam("customerId", 6).when().delete("http://localhost:9080/Emerge/bss/v1/bss/provision/customer/{customerId}/").then().
//                contentType(ContentType.JSON).extract().response();
//
//        return response;
//
//    }
//
//    public Response creatBillingAddress() {
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
//
//        Response response = given().contentType(JSON).body(o.toJSONString()).pathParam("customerId", 6).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/customers/{customerId}/expeditionaddress").then().
//                contentType(ContentType.JSON).extract().response();
//
//        return response;
//
//    }
//
//    //*************TEST FOR CREATE OPERATIONS***********************//
//    @Test
//    public void createContractTemplate() {
//        Date d = Calendar.getInstance().getTime();
//        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
//
//        JSONObject o = new JSONObject();
//        o.put("creationDate", sp.format(d));
//        o.put("modificationDate", sp.format(d));
//        o.put("createdBy", "Arowolo Kolade Ibrahim");
//        o.put("content", "This is just a template for prepaid contracts");
//        o.put("name", "TemplateForPrepaid");
//        o.put("description", "This template will be used for only prepaid contract customers");
//        o.put("contractType", "PREPAID");
//
//        //       System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).body(o.toString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/contracts/templates/").then().statusCode(200);
//     Response resp =   given().
//                contentType(JSON).
//                body(o.toJSONString()).
//                when().
//                post("http://localhost:9080/bss/v1/provision/contracts/templates/").
//                then().
//                //   body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//         String r = resp.asString();
//    }
//
//    @Test
//    public void createPostpaidContract() {
//
//        Date d = Calendar.getInstance().getTime();
//        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
//        JSONObject o = new JSONObject();
//
//        o.put("allowJointBilling", "true");
//        o.put("customerId", 1);
//        o.put("billingPeriod", "MONTHLY");
//        o.put("billingDay", sp.format(d));
//        o.put("statusDate", sp.format(d));
//        o.put("secondContractorName", "Kola");
//        o.put("secondContractorFiscalNumber", "106263");
//        o.put("secondContractorAddress", "Lagos");
//        o.put("startDate", sp.format(d));
//        o.put("endDate", sp.format(d));
//        o.put("preamble", "registration");
//        o.put("clauses", "terms and conditions");
//        o.put("expirationCondition", "non performance");
//        o.put("goodsAndServices", "telo phones");
//
////           System.out.println("the value being passed " + o.toJSONString());
//        //given().contentType(JSON).body(o.toJSONString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/contract/postpaid/customer").then().statusCode(200);
//        given().
//                contentType(JSON).
//                body(o.toJSONString()).
//                pathParam("customer_id", "1").
//                when().
//                post("http://localhost:9080/bss/v1/provision/customers/{customer_id}/contracts/postpaid").
//                then().
//            //    body("message", equalTo("Successfully created!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//    
//     @Test
//    public void createPrepaidService() {
//        JSONObject o = new JSONObject();
//        
//        o.put("externalProvisionId", "YT6703");
//       o.put("status", "READY");
//        o.put("name", "Arowolo  Kolade");
//     //   o.put("deletedReason" , "Intolerable act");
//        o.put("serviceType", "TEC");
//        o.put("productId", 2);
//
// //Response re =   given().contentType(JSON).body(o.toJSONString()).when().post("{"").then().statusCode(200).contentType(ContentType.JSON).extract().response();
//           //     .body("message", equalTo("Successfully created!"));
//            //String r = re.asString();
//    }
//    
//     @Test
//    public void bssProvisionServicesPrepaidGet(){
//   given().contentType(JSON).when().queryParam("type", "TELOAGENT").get("http://localhost:9080/bss/v1/provision/services/prepaid").then().contentType(JSON).extract().response();
//       
//     
//    }
//    
//
//    @Test
//    public void createPrepaidContract() {
//        Date d = Calendar.getInstance().getTime();
//        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
//        JSONObject o = new JSONObject();
//
//        o.put("servicePrepaid", 15);
//        o.put("customerId", 3);
//        o.put("statusDate", sp.format(d));
//        o.put("startDate", sp.format(d));
//        o.put("content", "This is the content of the contract we just created for a TELOOperator with customer id 2");
//        o.put("automaticRenewal", false);
//        o.put("serviceType", "TEC");
//
//        //System.out.println("the value being passed " + o.toJSONString());
//       // given().contentType(JSON).pathParam("customer_id", 1).body(o.toJSONString()).when().post("http://localhost:9080/bss/v1/provision/customers/{customer_id}/contracts/prepaid").then().statusCode(200);
//     Response resp =   given().
//                contentType(JSON).
//                body(o.toJSONString()).
//                pathParam("customer_id", 1).
//                when().
//                post("http://localhost:9080/bss/v1/provision/customers/{customer_id}/contracts/prepaid").
//                then().
//               //body("message", equalTo("Successfully created!")).
//                contentType(ContentType.JSON).extract().response();
//         String r = resp.asString();
//    }
//
//    @Test
//    public void taxTypes() {
//
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
//        JSONObject o = new JSONObject();
//
//        o.put("description", "Tax considering the income of the new customer");
//        o.put("percentage", 74.0);
//
////      System.out.println("the value being passed " + o.toJSONString());
//        // given().contentType(JSON).body(o.toJSONString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/tax_types").then().statusCode(200);
//        given().
//                contentType(JSON).body(o.toJSONString()).
//                when().
//                post("http://localhost:9080/bss/v1/provision/tax-types").
//                then().
//                body("message", equalTo("Successfully created!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//
//    public void teloAgent() {
//
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
//        JSONObject o = new JSONObject();
//
//        o.put("prepaidServiceId", 1);
//        o.put("balance", 0);
//
////      System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/emerge/bss/v1/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
//        given().
//                contentType(JSON).
//                body(o.toJSONString()).
//                when().
//                post("http://localhost:9080/bss/v1/provision/telo-agents").
//                then().
//                body("message", equalTo("Successfully created!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//
//    public void createProduct() {
//
//        JSONObject o = new JSONObject();
//
//        o.put("productCode", "PSP12365");
//        o.put("productName", "PSP");
//        o.put("productType", "PREPAID");
//        o.put("productDescription", "PSP Product Type");
//        o.put("taxId", 1);
//
////    System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
//        given().
//                contentType(JSON).
//                body(o.toJSONString()).
//                when().
//                post("http://localhost:9080/bss/v1/provision/products").
//                then().
//        //                       body("message", equalTo("Successfully created!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//
//    }
//
//    public void payment() {
//
//        Date d = Calendar.getInstance().getTime();
//        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
//        JSONObject o = new JSONObject();
//
//        o.put("paymentDate", sp.format(d));
//        o.put("customerId", 1);
//        o.put("prepaid_service_id", 1);
//        o.put("postpaid_service_id", 1);
//        o.put("reconciled", "YES");
//        o.put("reconciledMethod", "MANUAL");
//        o.put("invoiceId", "876543");
//        o.put("provisionedEquipment", "PSP");
//        o.put("paymentReferenceNumber", "123456");
//        o.put("creditBeforePayment", "Yes");
//        o.put("creditAfterPayment", "No");
//        o.put("costOfPaymentMethod", 34.8);
//        o.put("nameOfBackOfficeOperator", "Ajayi Olufemi");
//        o.put("revoked", "NO");
//        o.put("bankName", "WEMA BANK");
//        o.put("value", 6.9);
//        o.put("note", "Testing");
//        o.put("paymentMethod", "EMIS");
//        o.put("paymentStatus", "Paid");
//        o.put("electronicReference", "Test");
//        o.put("treasuryAccounts", "EMIS");
//        o.put("paidService", "PREPAID");
//
////    System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
//        given().
//                contentType(JSON).
//                body(o.toJSONString()).
//                when().
//                post("http://localhost:9080/bss/v1/provision/payments").
//                then().
//                //                body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//
//    @Test
//    public void allegedPayment() {
//
////        Date d = Calendar.getInstance().getTime();
//        JSONObject o = new JSONObject();
//
//        o.put("paymentMethod", "EMIS");
//        o.put("servicesToProvision", "TEC");
//        o.put("paymentReferenceNumber", "4021");
//        o.put("bankName", "AAA Bank");
//        o.put("value", "280");
//        o.put("customerId", "5896");
//
////      System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
//        given().
//                contentType(JSON).
//                body(o.toJSONString()).
//                when().
//                post("http://localhost:9080/bss/v1/provision/alleged_payment").
//                then().
//                body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//
//    //****************TEST OPERATIONS FOR UPDATE OPERATIONS***********************//
//    @Test
//    public void updateAllegedPayment() {
//
//        JSONObject o = new JSONObject();
//
//        o.put("paymentMethod", "EMIS");
//        o.put("servicesToProvision", "PSP");
//        o.put("paymentReferenceNumber", "4021");
//        o.put("bankName", "YY Bank");
//        o.put("value", "2280");
//        o.put("customerId", "789");
//
//        // System.out.println("the value being passed " + o.toJSONString());
//        //  given().contentType(JSON).pathParam("alleged_payment_id", "1").body(o.toJSONString()).when().put("http://localhost:9080/Emerge/bss/v1/bss/provision/alledged_payment/{alleged_payment_id}").then().statusCode(200);
//        given().
//                pathParam("alledged_payment_id", "2").
//                contentType(JSON).body(o.toJSONString()).
//                when().
//                put("http://localhost:9080/bss/v1/provision/alledged_payment/{alledged_payment_id}").
//                then().
//                body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//
//    @Test
//    public void updatePayment() {
//
//        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
//        Date d = Calendar.getInstance().getTime();
//        JSONObject o = new JSONObject();
//        o.put("paymentDate", sp.format(d));
//        o.put("customerId", 1);
//        o.put("prepaidServiceId", 1);
//        o.put("postpaidServiceId", 1);
//        o.put("reconciled", "YES");
//        o.put("reconciledMethod", "MANUAL");
//        o.put("invoiceId", "45678");
//        o.put("provisionedEquipment", "TEC");
//        o.put("paymentReferenceNumber", "123456");
//        o.put("creditBeforePayment", "Ok");
//        o.put("creditAfterPayment", "tfs2");
//        o.put("costOfPaymentMethod", "34.8");
//        o.put("nameOfBackOfficeOperator", "Shikemi Ayowale");
//        o.put("revoked", "NO");
//        o.put("bankName", "Key BANK");
//        o.put("value", 55.1);
//        o.put("note", "Testing note");
//        o.put("paymentMethod", "EMIS");
//        o.put("paymentStatus", "Paid");
//        o.put("electronicReference", "Test");
//        o.put("treasuryAccounts", "EMIS");
//        o.put("paidService", "PREPAID");
//
////      System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
//        given().
//                contentType(JSON).
//                pathParam("payment_id", 1).
//                body(o.toJSONString()).
//                when().
//                put("http://localhost:9080/bss/v1/provision/payments/{payment_id}").
//                then().
//                //               body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//
//    @Test
//    public void editPrepaidContract() {
//
//        Date d = Calendar.getInstance().getTime();
//        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
//        JSONObject o = new JSONObject();
//        JSONObject jo = new JSONObject();
//        jo.put("customer_id", 1);
//        jo.put("contract_id", 12);
//        
//        o.put("servicePrepaid", 61);
//        o.put("customerId", 1);
//        o.put("statusDate", sp.format(d));
//        o.put("startDate", sp.format(d));
//       // o.put("endDate", sp.format(d));
//        o.put("content", "This is the edited content of the contract");
//        o.put("automaticRenewal", true);
//       // o.put("status", "ACTIVE");
//        o.put("serviceType", "TEC");
//
//
////           System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
//    Response   resp = given().
//                contentType(JSON).
//                body(o.toJSONString()).
//                pathParams(jo).
//                when().
//                put("http://localhost:9080/bss/v1/provision/customers/{customer_id}/contracts/prepaid/{contract_id}").
//                then().
//              //  body("message", equalTo("Successfully updated!")).
//                contentType(ContentType.JSON).extract().response();
//         String r = resp.asString();
//         System.out.println(r);
//    }
//
//    @Test
//    public void editPostpaidContract() {
//        Date d = Calendar.getInstance().getTime();
//        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
//        JSONObject o = new JSONObject();
//        JSONObject jo = new JSONObject();
//        jo.put("customer_id", 1);
//        jo.put("id", 1);
//
//        o.put("allowJointBilling", "true");
//        o.put("customerId", 1);
//        o.put("billingPeriod", "MONTHLY");
//        o.put("billingDay", sp.format(d));
//        o.put("statusDate", sp.format(d));
//        o.put("secondContractorName", "Umu");
//        o.put("secondContractorFiscalNumber", "126263");
//        o.put("secondContractorAddress", "Ibadan");
//        o.put("startDate", sp.format(d));
//        o.put("endDate", sp.format(d));
//        o.put("preamble", "postpaid contract editing");
//        o.put("clauses", "terms and conditions");
//        o.put("expirationCondition", "non performance");
//        o.put("goodsAndServices", "telo phones");
//
////           System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
//        given().
//                contentType(JSON).
//                body(o.toJSONString()).
//                pathParams(jo).
//                when().
//                put("http://localhost:9080/bss/v1/provision/customers/{customer_id}/contracts/postpaid/{id}").
//                then().
//                //                body("message", equalTo("Successfully created a supplement!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//
//    @Test
//    public void editContractTemplate() {
//
//        Date d = Calendar.getInstance().getTime();
//        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
//        JSONObject o = new JSONObject();
//        o.put("modificationDate", sp.format(d));
//        o.put("createdBy", "Ibrahim");
//        o.put("content", "This is just a template for prepaid contracts");
//        o.put("name", "TemplateForPrepaidEDIT1");
//        o.put("description", "This template will be used for only prepaid contract customers");
//        o.put("contractType", "PREPAID");
//
//        // System.out.println("the value being passed " + o.toJSONString());
//        // given().contentType(JSON).contentType(JSON).pathParam("id", "1").when().put("http://localhost:9080/Emerge/bss/v1/bss/provision/contracts/templates/{id}").then().statusCode(200);
//        Response resp= given().
//                contentType(JSON).
//                pathParam("id", 16).
//                body(o.toJSONString()).
//                when().
//                put("http://localhost:9080/bss/v1/provision/contracts/templates/{id}").
//                then().
//                //                body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//         String r = resp.asString();
//
//    }
//
//    @Test
//    public void editTaxType() {
//
//        JSONObject o = new JSONObject();
//        o.put("description", "Tax considering the amount of income");
//        o.put("percentage", 90.0);
//
////      System.out.println("the value being passed " + o.toJSONString());
//        given().
//                contentType(JSON).pathParam("tax_type_id", 1).
//                body(o.toJSONString()).
//                when().
//                put("http://localhost:9080/bss/v1/provision/tax-types/{tax_type_id}").
//                then().
//                body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//
//    public void updateProduct() {
//
//        JSONObject o = new JSONObject();
//
//        o.put("productCode", "TELO-PSP-AO");
//        o.put("productName", "PSP");
//        o.put("productType", "PREPAID");
//        o.put("productDescription", "PSP Product");
//        o.put("taxId", 1);
//
//
//     Response r =   given().
//                contentType(JSON).
//                pathParam("id", 1).
//                body(o.toJSONString()).
//                when().
//                put("http://localhost:9080/bss/v1/provision/products/{id}").
//                then().
//                //                body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//        String re = r.asString();
//        System.out.println(re);
//
//    }
//
//    @Test
//    public void topupTeloAgentBalance() {
//        JSONObject o = new JSONObject();
//        o.put("topUpValue", 2000);
//        o.put("reasonForTopUp", "Top up account");
//       Response resp = given().
//                contentType(JSON).
//                pathParam("telo_agent_service_id", 3).
//                body(o).
//                when().
//                put("http://localhost:9080/bss/v1/provision/telo-agents/{telo_agent_service_id}/topup").
//                then().
//                contentType(ContentType.JSON).extract().response();
//         String r = resp.asString();
//    }
//
//    //**********************TEST FOR GET OPERATIONS***********************************//
//    @Test
//    public void getPrepaidService(){
//        
//        given().
//                contentType(JSON).queryParam("external_provision_id", "xxxxxx").
//                when().
//                get("http://localhost:9080/bss/v1/provision/services/prepaid").
//                then().
//             //   body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//    
//    
//        @Test
//    public void returnTeloAgentBalance(){
//        
//     Response resp =   given().
//                contentType(JSON).pathParam("prepaid_service_id", "3").
//                when().
//                get("http://localhost:9080/bss/v1/provision/telo_agents/{prepaid_service_id}").
//                then().
//             //   body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//         String r = resp.asString();
//         
//            System.out.println(r);
//    }
//    
//    
//    
//    
//    
//    @Test
//    public void bssProvisionContractPostpaidCustomerCustomeridGet() {
//
//        given().
//                contentType(JSON).pathParam("customerid", "55").
//                when().
//                get("http://localhost:9080/bss/v1/provision/contract/postpaid/customer/{customerid}").
//                then().
//                body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//
//    public void getPayment() {
//
////        System.out.println("the value being passed " + jo.toJSONString());
//        given().
//                contentType(JSON).
//                pathParam("payment_id", 1).
//                when().
//                get("http://localhost:9080/bss/v1/provision/payments/{payment_id}").
//                then().
//                //             body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//
//    }
//
//    public void getTeloAgent() {
////      System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
//     Response resp =   given().
//                contentType(JSON).
//                pathParam("prepaid_service_id", 3).
//                when().
//                get("http://localhost:9080/bss/v1/provision/prepaidservices/{prepaid_service_id}/telo-agent").
//                then().
//                //            body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//        String r = resp.asString();
//        System.out.println(r);
//
//    }
//
//    public void getTaxType() {
////        System.out.println("the value being passed " + jo.toJSONString());
//        given().
//                contentType(JSON).
//                queryParam("tax_type_id", 1).
//                when().
//                get("http://localhost:9080/bss/v1/provision/tax-types").
//                then().
//                //               body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//
//        // String r = resp.asString();
//    }
//    
//     public void getProduct() {
////        System.out.println("the value being passed " + jo.toJSONString());
//        given().
//                contentType(JSON).
//                queryParam("product_id", 2).
//                when().
//                get("http://localhost:9080/bss/v1/provision/products").
//                then().
//                //body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//
//        // String r = resp.asString();
//    }
//
//    public void getAllegedPayment() {
//
//        JSONObject jo = new JSONObject();
//        jo.put("AlledgedPaymentID", 6);
//        jo.put("paymentMethod", "EMIS");
////       System.out.println("the value being passed " + jo.toJSONString());
//        given().
//                contentType(JSON).
//                queryParams(jo).
//                when().
//                get("http://localhost:9080/bss/v1/provision/alleged_payment").
//                then().
//                //               body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//
//        // String r = resp.asString();
//
//    }
//
//    public void getContractTemplate() {
////       System.out.println("the value being passed " + jo.toJSONString());
//        given().
//                contentType(JSON).
//                queryParam("template_id", 1).
//                when().
//                get("http://localhost:9080/bss/v1/provision/contracts/templates/").
//                then().
//                //               body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//
//        // String r = resp.asString();
//    }
//
//    public void getPrepaidContract() {
//        JSONObject jo = new JSONObject();
//        jo.put("customer_id", 1);
//        jo.put("contract_id", 6);
////       System.out.println("the value being passed " + jo.toJSONString());
//        given().
//                contentType(JSON).
//                pathParams(jo).
//                when().
//                get("http://localhost:9080/bss/v1/provision/customers/{customer_id}/contracts/prepaid/{contract_id}").
//                then().
//                //             body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//
//        // String r = resp.asString();
//    }
//    
//        public void getPrepaidContractByCustomerId() {
//        JSONObject jo = new JSONObject();
//        jo.put("customer_id", 1);
////       System.out.println("the value being passed " + jo.toJSONString());
//      Response r =  given().
//                contentType(ContentType.JSON).
//                pathParam("customer_id", 1).
//                queryParam("creation_date", "2016-11-18 17:33:44.987636+00").
//                when().
//                get("http://localhost:9080/bss/v1/provision/customers/{customer_id}/contracts/prepaid").
//                then().
//                //             body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//
//        // String r = resp.asString();
//    }
//
//    public void getPostpaidContract() {
//        JSONObject jo = new JSONObject();
//        jo.put("customer_id", 1);
//        jo.put("id", 3);
////       System.out.println("the value being passed " + jo.toJSONString());
//        given().
//                contentType(JSON).
//                pathParams(jo).
//                when().
//                get("http://localhost:9080/bss/v1/provision/customers/{customer_id}/contracts/postpaid/{id}").
//                then().
//                //             body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//
//        // String r = resp.asString();
//    }
//    
//    
//        public void getPrepaidServicebyId() {
//
////       System.out.println("the value being passed " + jo.toJSONString());
//        given().
//                contentType(JSON).
//                pathParam("id", 7).
//                when().
//                get("http://localhost:9080/bss/v1/provision/services/prepaid/{id}").
//                then().
//                //             body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//
//        // String r = resp.asString();
//    }
//         @Test
//    public void updatePrepaidService() {
//        JSONObject o = new JSONObject();
//        o.put("externalProvisionId", "gt-i229556");
//        o.put("name", "MrAde");
//        o.put("serviceType", "PSP");
//        o.put("productId", 1);
//        o.put("isLegacy", true);
//      //  o.put("id", 202);
//     Response r =   given().contentType(JSON).body(o.toJSONString()).pathParam("id",202).when().
//             put("http://localhost:9080/bss/v1/provision/services/prepaid/{id}").
//             then().statusCode(200).extract().response();
//     
//     String res = r.asString();
//             System.out.println(res);
////                .body("message", equalTo("Successfully updated!"));
//    }
//    
//    
//    //**************TEST FOR DELETE OPERATIONS**********************************//
//
//    @Test
//    public void deletePostpaidContract() {
//        JSONObject jo = new JSONObject();
//        jo.put("customer_id", 1);
//        jo.put("id", 1);
//
//        given().
//                contentType(JSON).
//                pathParams(jo).
//                when().
//                delete("http://localhost:9080/bss/v1/provision/customers/{customer_id}/contracts/postpaid/{id}").
//                then().
//                //           body("message", equalTo("Successfully deleted!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
/////provision/services/prepaid/{id}
//    @Test
//    public void deletePrepaidContract() {
//        JSONObject jo = new JSONObject();
//        jo.put("customer_id", 1);
//        jo.put("id", 9);
//
//        given().
//                contentType(JSON).
//                pathParams(jo).
//                when().
//                delete("http://localhost:9080/bss/v1/provision/customers/{customer_id}/contracts/prepaid/{id}").
//                then().
//                //             body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//
//    @Test
//    public void deleteContractTemplate() {
//
//        given().
//                contentType(JSON).
//                pathParam("id", 3).
//                when().
//                delete("http://localhost:9080/bss/v1/provision/contracts/templates/{id}").
//                then().
//                statusCode(204).
//                body("message", equalTo("Successfully deleted!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//    }
//
//    @Test
//    public void deleteTaxType() {
//        given().
//                contentType(JSON).
//                pathParam("tax_type_id", 1).
//                when().
//                delete("http://localhost:9080/bss/v1/provision/tax-types/{tax_type_id}").
//                then().
//                //         body("message", equalTo("Successfully deleted!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//
//    }
//
//    @Test
//    public void deleteTeloAgent() {
//        given().
//                contentType(JSON).
//                pathParam("telo_agent_id", 3).
//                when().
//                delete("http://localhost:9080/bss/v1/provision/telo-agents/{telo_agent_id}").
//                then().
//                statusCode(204).
//                //               body("message", equalTo("Successfully deleted!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//
//    }
//    
//        @Test
//    public void deleteProduct() {
//        given().
//                contentType(JSON).
//                pathParam("id", 2).
//                when().
//                delete("http://localhost:9080/bss/v1/provision/products/{id}").
//                then().
//                statusCode(204).
//                //               body("message", equalTo("Successfully deleted!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//
//    }
//    @Test
//    public void deletePrepaidService(){
//        JSONObject jo = new JSONObject();
//        jo.put("deletedReason", "Fraud1");
//      given().contentType(JSON).when().body(jo).pathParam("id", 49).put("http://localhost:9080/bss/v1/provision/services/prepaid/{id}/delete").then().statusCode(200).body("message",equalTo("Successfully Deleted!"));
//    }
//
//    @Test
//    public void deletePayment() {
//
//        given().
//                contentType(JSON).
//                when().
//                pathParam("payment_id", 1).
//                delete("http://localhost:9080/bss/v1/provision/payments/{payment_id}").
//                then().
//                //             body("message", equalTo("Successfully deleted!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//
//    }
//
//    @Test
//    public void deleteAllegedPayment() {
//
//        // given().contentType(JSON).pathParam("alledged_payment_Id", "1").when().delete("http://localhost:9080/Emerge/bss/v1/bss/provision/alledged_payment/{alledged_payment_Id}").then().statusCode(200);
//        given().
//                contentType(JSON).
//                when().
//                pathParam("alledged_payment_Id", "3").
//                delete("http://localhost:9080/bss/v1/provision/alledged_payment/{alledged_payment_Id}").
//                then().
//                body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
//        // String r = resp.asString();
//
//    }
//
//    public static void main(String[] args) {
//
//        BssPaymentsTests op = new BssPaymentsTests();
//        op.rullAll();
//
//    }
//
//    void rullAll() {
//           // cancelContract();
//         //confirmContract();
//      //  createContractTemplate();
//        // createPostpaidContract();
//       // createPrepaidContract();
//      //  createProduct();
//        //taxTypes();
//        // teloAgent();
//        //  payment();
//        // allegedPayment();
//        //  bssProvisionContractPostpaidCustomerCustomeridGet();
//       //  topupTeloAgentBalance();
//      // getTeloAgent();
//      // getPrepaidContractByCustomerId();
//        //getPayment();
//        //getTaxType();
//        //getAllegedPayment();
//        //getContractTemplate();
//       // getPrepaidContract();
//        //getPostpaidContract();
//       // getProduct();
//      // createPrepaidService();
//      // bssProvisionServicesPrepaidGet();
//     // getPrepaidService();
//      //deletePrepaidService();
//     // getPrepaidServicebyId();
//        //editTaxType();
//        updateProduct();
//     //  editContractTemplate();
//        // editPostpaidContract();
//      //  editPrepaidContract();
//        // UpdatePayment();
//        //UpdateAllegedPayment();
//      //  deleteProduct();
//        //deletePostpaidContract() ;
//        //deletePrepaidContract();
//        //deleteContractTemplate();
//        //deleteTaxType();
//        //deleteTeloAgent();
//        //deletePayment();
//        //deleteAllegedPayment();
//        // creatCustomer();
//        //        updateCustomer();
////      deleteCustomer();
////updatePrepaidService();
////returnTeloAgentBalance();
//    }
//}
