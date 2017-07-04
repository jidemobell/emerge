///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.emerge.bss.e2e;
//
//import static com.jayway.restassured.RestAssured.given;
//import com.jayway.restassured.http.ContentType;
//import static com.jayway.restassured.http.ContentType.JSON;
//import com.jayway.restassured.response.Response;
//import io.swagger.model.Customer;
//import io.swagger.model.CustomerAddress;
//import io.swagger.model.ServicePrepaid;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import static org.hamcrest.CoreMatchers.equalTo;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.junit.Test;
//
///**
// *
// * @author akin
// */
//public class OperationsRestTest {
////
////    @Test
////    public void basicPingTest() {
////        long n = new long(7);
////        given().when().get("http://localhost:9080/bss/v1/provision/contracts/templates/").then().statusCode(200);
////        given().when().pathParam("customerid", "7").get("http://localhost:9080/bss/v1/provision/contract/prepaid/customer/{customerid}").then().statusCode(200);
////    }
////
////    @Test
////    public Response confirmContract() {
////        Date d = Calendar.getInstance().getTime();
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
////
////        return given().contentType(JSON).pathParam("contractId", "7").when().put("http://localhost:9080/bss/v1/provision/contract/postpaid/{contractId}/confirm").then().
////                contentType(ContentType.JSON).extract().response();
////
////    }
////
////    @Test
////    public Response creatCustomer() {
////        JSONObject co = new JSONObject();
////        co.put("contactType", "Billing");
////        co.put("contactName", "BigC");
////        co.put("contactEmail", "abc@gmail.com");
////        co.put("contactPhone", "08105802590");
////        co.put("contactFax", "+234108865445");
////        co.put("customerAddressId", 1);
////        JSONArray contacts = new JSONArray();
////        contacts.add(co);
////        JSONObject b = new JSONObject();
////        o.put("creation_date", d.toString());
////        b.put("addressName", "Emeka's address");
////        b.put("address", "Aluko area,onigbongbo lagos");
////        b.put("faxNumber", "9988567898");
////        b.put("telephoneNumber", "234597789008");
////        b.put("notifyBySms", false);
////        b.put("notifyByEmail", true);
////        b.put("contacts", contacts);
////        b.put("email", "www.myemail@email.com");
////
////        JSONArray a = new JSONArray();
////        a.add(b);
////
////        JSONObject o = new JSONObject();
////        o.put("creation_date", d.toString());
////        o.put("name", "Musa Yahaya Maxton");
////        o.put("fiscalNumber", "89786r4fk876ru238");
////        o.put("taxExemptionCertificate", "09iukj98tf7698");
////        o.put("country", "Angola");
////        o.put("website", "www.webiste.com");
////        o.put("privateNotes", "terms and conditions");
////        o.put("tags", "pilot customer");
////        o.put("customerAddresses", a);
////
////        Response response = given().contentType(JSON).body(o.toJSONString()).when().post("http://localhost:8080/bss/v1/provision/customers").then().
////                statusCode(200).contentType(ContentType.JSON).extract().response();
////
////        return response;
////
////    }
////
////    @Test
////    public Response createTeloOperatorConfig() {
////        JSONObject o = new JSONObject();
////        o.put("startAmount", "50");
////        o.put("endAmount", "200");
////        o.put("teloOperatorId", 1);
////        o.put("profitPercentage", "20");
////
////        Response response = given().contentType(JSON).body(o.toJSONString()).when().post("http://localhost:9080/bss/v1/provision/telo_operator_profit_config").then().
////                statusCode(200).contentType(ContentType.JSON).extract().response();
////        return response;
////    }
////
////    @Test
////    public Response updateTeloOperatorConfig() {
////
////        JSONObject o = new JSONObject();
////        o.put("startAmount", "50");
////        o.put("endAmount", "900");
////        o.put("profitPercentage", "20");
////
////        Response response = given().contentType(JSON).body(o.toJSONString()).pathParam("telo_operator_profit_config_id", 1).when().put("http://localhost:9080/bss/v1/provision/telo-operator-profit-config/update/{telo_operator_profit_config_id}").then().
////                statusCode(204).contentType(ContentType.JSON).extract().response();
////
////        return response;
////    }
////
////    @Test
////    public Response fetchTeloOperatorConfig() {
////        Response response = given().pathParam("telo_operator_profit_config_id", 2).when().get("http://localhost:9080/bss/v1/provision/telo-operator-profit-config/{telo_operator_profit_config_id}").then().
////                statusCode(200).contentType(ContentType.JSON).body("type", equalTo("ok")).extract().response();
////
////        return response;
////    }
////
////    @Test
////    public Response fetchCustomer() {
////        Response response = given().queryParam("customer_id", 1).when().get("http://localhost:9080/bss/v1/provision/customers").then().
////                statusCode(200).contentType(ContentType.JSON).body("type", equalTo("ok")).extract().response();
////
////        return response;
////    }
////
////    @Test
////    public Response updateCustomer() {
////        Date d = Calendar.getInstance().getTime();
////        JSONObject o = new JSONObject();
////        o.put("creation_date", d.toString());
////        o.put("name", "Abubakar Saidi");
////        o.put("fiscalNumber", "687787678");
////        o.put("taxExemptionCertificates", "76guytf7698");
////        o.put("country", "Angola");
////        o.put("website", "www.webiste.com");
////        o.put("privateNotes", "terms and conditions");
////        o.put("tags", "pilot customer");
////
////        Response response = given().contentType(JSON).body(o.toJSONString()).pathParam("customerId", 31).when().put("http://localhost:9080/bss/v1/provision/customers/{customerId}/").then().
////                statusCode(200).contentType(ContentType.JSON).extract().response();
////
////        return response;
////
////    }
////
////    @Test
////    public Response deleteCustomer() {
////        Date d = Calendar.getInstance().getTime();
////        JSONObject o = new JSONObject();
////        o.put("creation_date", d.toString());
////        o.put("name", "Audu Suleimon");
////        o.put("fiscalNumber", "12345678");
////        o.put("taxExemptionCertificate", "76guytf7698");
////        o.put("country", "Angola");
////        o.put("website", "www.webiste.com");
////        o.put("privateNotes", "terms and conditions");
////        o.put("tags", "pilot customer");
////        o.put("customerAddressId", "1");
////
////        Response response = given().contentType(JSON).pathParam("customerId", 31).when().delete("http://localhost:9080/bss/v1/provision/customers/{customerId}/").then().
////                contentType(ContentType.JSON).extract().response();
////
////        return response;
////
////    }
////
////    @Test
////    public Response deleteBillingAddress() {
////
////        Response response = given().contentType(JSON).pathParam("customer_id", 1).pathParam("customer_address_id", 1).when().delete("http://localhost:9080/bss/v1/provision/customers/{customer_id}/customer-addresses/{customer_address_id}").then().
////                contentType(ContentType.JSON).extract().response();
////
////        return response;
////
////    }
////
////    @Test
////    public Response deleteTeloOperatorProfitConfig() {
////
////        Response response = given().contentType(JSON).pathParam("teloOperatorProfitConfig", 1).when().delete("http://localhost:9080/bss/v1/provision/telo-operator-profit-config/delete/{teloOperatorProfitConfig}").then().
////                contentType(ContentType.JSON).extract().response();
////
////        return response;
////
////    }
////
////    @Test
////    public Response creatBillingAddress() {
////        Date d = Calendar.getInstance().getTime();
////        JSONObject o = new JSONObject();
////        o.put("creation_date", d.toString());
////        o.put("addressName", "Emeka's address");
////        o.put("address", "Aluko area,onigbongbo lagos");
////        o.put("faxNumber", "34567898");
////        o.put("telephoneNumber", "23456789008");
////        o.put("notifyBySms", false);
////        o.put("notifyByEmail", true);
////        o.put("email", "www.myemail@email.com");
////
////        Response response = given().contentType(JSON).body(o.toJSONString()).pathParam("customer_id", 1).when().post("http://localhost:9080/bss/v1/provision/customers/{customer_id}/customer-addresses").then().
////                statusCode(200).contentType(ContentType.JSON).extract().response();
////
////        return response;
////
////    }
////
////    @Test
////    public String updateBillingAddress() {
////        Date d = Calendar.getInstance().getTime();
////        JSONObject o = new JSONObject();
////        o.put("creation_date", d.toString());
////        o.put("addressName", "Emeka's address");
////        o.put("address", "Aluko area,onigbongbo lagos");
////        o.put("faxNumber", "34567898");
////        o.put("telephoneNumber", "23456789008");
////        o.put("notifyBySms", false);
////        o.put("notifyByEmail", true);
////        o.put("email", "www.myemail@email.com");
////
////        String response = given().contentType(JSON).body(o.toJSONString()).pathParam("customer_id", 1).pathParam("customer_address_id", 3).when().put("http://localhost:9080/bss/v1/provision/customers/{customer_id}/customer-addresses/{customer_address_id}").then().
////                statusCode(204).contentType(ContentType.JSON).extract().response().asString();
////
////        return response;
////
////    }
////
////    *************TEST FOR CREATE OPERATIONS***********************//
////    @Test
////    public void createContractTemplate() {
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
////
////        JSONObject o = new JSONObject();
////        o.put("creationDate", sp.format(d));
////        o.put("modificationDate", sp.format(d));
////        o.put("secondContractorName", "Mr Azeez");
////        o.put("secondContractorFiscalNumber", "88");
////        o.put("secondContractorAddress", "Lagos");
////        o.put("preamble", "ContractTemplateCreation");
////        o.put("clauses", "Terms and Conditions");
////        o.put("expirationCondition", "Lack of fullfilment of obligation in anyway");
////        o.put("goodsAndServices", "Some goods");
////
////given().contentType(JSON).body(o.toString()).when().post("http://localhost:9080/bss/v1/provision/contracts/templates/").then().statusCode(200);
////        given().
////                contentType(JSON).
////                body(o.toJSONString()).
////                when().
////                post("http://localhost:9080/bss/v1/provision/contracts/templates/").
////                then().
////                body("message", equalTo("successful!"));
////    }
////
////    @Test
////    public void createPostpaidContract() {
////
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
////        JSONObject o = new JSONObject();
////
////        o.put("allowJointBilling", "true");
////        o.put("customerID", "207");
////        o.put("billingPeriod", "MONTHLY");
////        o.put("billingDay", sp.format(d));
////        o.put("statusDate", sp.format(d));
////        o.put("secondContractorName", "Kola");
////        o.put("secondContractorFiscalNumber", "106263");
////        o.put("secondContractorAddress", "Lagos");
////        o.put("startDate", sp.format(d));
////        o.put("endDate", sp.format(d));
////        o.put("preamble", "registration");
////        o.put("clauses", "terms and conditions");
////        o.put("expirationCondition", "non performance");
////        o.put("goodsAndServices", "telo phones");
////
////           System.out.println("the value being passed " + o.toJSONString());
////        given().contentType(JSON).body(o.toJSONString()).when().post("http://localhost:9080/bss/v1/provision/contract/postpaid/customer").then().statusCode(200);
////       given().
////                contentType(JSON).
////                body(o.toJSONString()).
////                when().
////                post("http://localhost:9080/bss/v1/provision/contract/postpaid/customer").
////                then().
////                body("message", equalTo("successful!"));
////        String r = resp.asString();
////    }
////
////    @Test
////    public void createPrepaidContract() {
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
////        JSONObject o = new JSONObject();
////
////        o.put("serviceID", "22");
////        o.put("customerID", "23456");
////        o.put("statusDate", sp.format(d));
////        o.put("secondContractorName", "Kolade");
////        o.put("secondContractorAddress", "Lagos");
////        o.put("secondContractorFiscalNumber", "1111");
////        o.put("startDate", sp.format(d));
////        o.put("endDate", sp.format(d));
////        o.put("preamble", "Let's see");
////        o.put("clauses", "Terms and conditions");
////        o.put("expirationCondition", "Non performance");
////
////        System.out.println("the value being passed " + o.toJSONString());
////        given().contentType(JSON).body(o.toJSONString()).when().post("http://localhost:9080/bss/v1/provision/contract/postpaid/customer").then().statusCode(200);
////       given().
////                contentType(JSON).
////                body(o.toJSONString()).
////                pathParam("customerid", "7").
////                when().
////                post("http://localhost:9080/bss/v1/provision/customer/{customerid}/contract/prepaid").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    @Test
////    public void taxTypes() {
////
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
////        JSONObject o = new JSONObject();
////
////        o.put("description", "Tax considering the income");
////        o.put("percentage", "74.0");
////
////      System.out.println("the value being passed " + o.toJSONString());
////         given().contentType(JSON).body(o.toJSONString()).when().post("http://localhost:9080/bss/v1/provision/tax_types").then().statusCode(200);
////       given().
////                contentType(JSON).body(o.toJSONString()).
////                when().
////                post("http://localhost:9080/bss/v1/provision/tax_types").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    public void teloAgent() {
////
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
////        JSONObject o = new JSONObject();
////
////        o.put("prepaidServiceId", 1);
////        o.put("postpaidServiceId", 1);
////        o.put("balance", 0);
////
////      System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/bss/v1/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
////       given().
////                contentType(JSON).
////                body(o.toJSONString()).
////                when().
////                post("http://localhost:9080/bss/v1/provision/telo-agents").
////                then().statusCode(201).
////                body("message", equalTo("Successfully created!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    public void payment() {
////
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
////        JSONObject o = new JSONObject();
////
////        o.put("paymentId", "182");
////        o.put("paymentDate", sp.format(d));
////        o.put("customerId", "OY23455");
////        o.put("reconciled", "YES");
////        o.put("reconciledMethod", "MANUAL");
////        o.put("invoiceId", "876543");
////        o.put("provisionedEquipment", "PSP");
////        o.put("paymentReferenceNumber", "123456");
////        o.put("creditBeforePayment", "Ok");
////        o.put("creditAfterPayment", "Ok2");
////        o.put("costOfPaymentMethod", "34.8");
////        o.put("nameOfBackOfficeOperator", "Ajayi Olufemi");
////        o.put("revoked", "NO");
////        o.put("bankName", "WEMA BANK");
////        o.put("value", "WF3267");
////        o.put("note", "Testing");
////        o.put("paymentMethod", "EMIS");
////        o.put("paymentStatus", "Paid");
////        o.put("electronicReference", "Test");
////        o.put("treasuryAccounts", "EMIS");
////        o.put("paidService", "PREPAID");
////
////    System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/bss/v1/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
////       given().
////                contentType(JSON).
////                body(o.toJSONString()).
////                when().
////                post("http://localhost:9080/bss/v1/provision/payment").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    @Test
////    public void allegedPayment() {
////
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
////        JSONObject o = new JSONObject();
////
////        o.put("paymentMethod", "EMIS");
////        o.put("customerId", 1);
////        o.put("servicesToProvision", "TEC");
////        o.put("paymentReferenceNumber", "4021");
////        o.put("bankName", "ACCESS Bank");
////        o.put("value", 34.876);
////
////        ****************TEST OPERATIONS FOR UPDATE OPERATIONS***********************//
////      System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/bss/v1/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
////       given().
////                contentType(JSON).
////                body(o.toJSONString()).
////                when().post("http://localhost:9080/Emerge/bss/v1/bss/provision/alleged_payments").
////                then().body("message", equalTo("successful!")).
////                statusCode(201).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    @Test
////    public void updateAllegedPayment() {
////
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
////        JSONObject o = new JSONObject();
////
////        o.put("paymentMethod", "EMIS");
////        o.put("customerId", 1);
////        o.put("servicesToProvision", "PSP");
////        o.put("paymentReferenceNumber", "4021");
////        o.put("bankName", "YY Bank");
////        o.put("value", "2280");
////
////         System.out.println("the value being passed " + o.toJSONString());
////          given().contentType(JSON).pathParam("alleged_payment_id", "1").body(o.toJSONString()).when().put("http://localhost:9080/bss/v1/provision/alledged_payment/{alleged_payment_id}").then().statusCode(200);
////       given().
////                pathParam("alledged_payment_id", 1).
////                contentType(JSON).body(o.toJSONString()).
////                when().
////                put("http://localhost:9080/bss/v1/provision/alledged_payment/{alledged_payment_id}").
////                then().body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    @Test
////    public void updatePayment() {
////        JSONObject jo = new JSONObject();
////        jo.put("paymentid", "2");
////        jo.put("customerid", "544");
////        jo.put("invoicenumber", "876543");
////
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
////        JSONObject o = new JSONObject();
////
////        o.put("paymentId", "8910");
////        o.put("paymentDate", sp.format(d));
////        o.put("customerId", "Lag5");
////        o.put("reconciled", "YES");
////        o.put("reconciledMethod", "MANUAL");
////        o.put("invoiceId", "45678");
////        o.put("provisionedEquipment", "TEC");
////        o.put("paymentReferenceNumber", "123456");
////        o.put("creditBeforePayment", "Ok");
////        o.put("creditAfterPayment", "tfs2");
////        o.put("costOfPaymentMethod", "34.8");
////        o.put("nameOfBackOfficeOperator", "Shikemi Ayowale");
////        o.put("revoked", "NO");
////        o.put("bankName", "Key BANK");
////        o.put("value", "WF3267");
////        o.put("note", "Testing note");
////        o.put("paymentMethod", "EMIS");
////        o.put("paymentStatus", "Paid");
////        o.put("electronicReference", "Test");
////        o.put("treasuryAccounts", "EMIS");
////        o.put("paidService", "PREPAID");
////
////      System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/bss/v1/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
////        given().
////                contentType(JSON).
////                pathParams(jo).
////                body(o.toJSONString()).
////                when().
////                put("http://localhost:9080/bss/v1/provision/payment/update/{paymentid}/{customerid}/{invoicenumber}").
////                then().
////                body("message", equalTo("successful!"));
////        String r = resp.asString();
////    }
////
////    @Test
////    public void editPrepaidContract() {
////
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
////        JSONObject o = new JSONObject();
////        JSONObject jo = new JSONObject();
////        jo.put("contractid", "6");
////        jo.put("customerid", "544");
////
////        o.put("serviceID", "226");
////        o.put("customerID", "234456");
////        o.put("statusDate", sp.format(d));
////        o.put("secondContractorName", "Kanyinsola");
////        o.put("secondContractorAddress", "Ibadan");
////        o.put("secondContractorFiscalNumber", "23690");
////        o.put("startDate", sp.format(d));
////        o.put("endDate", sp.format(d));
////        o.put("preamble", "Let's see");
////        o.put("clauses", "Terms and conditions");
////        o.put("expirationCondition", "Non performance");
////        o.put("goodsAndServices", "telo phones");
////
////           System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/bss/v1/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
////        given().
////                contentType(JSON).
////                body(o.toJSONString()).
////                pathParams(jo).
////                when().
////                put("http://localhost:9080/bss/v1/provision/customer/{contractid}/contract/prepaid/{customerid}").
////                then().
////                body("message", equalTo("successful!"));
////        String r = resp.asString();
////    }
////
////    @Test
////    public void editPostpaidContract() {
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
////        JSONObject o = new JSONObject();
////
////        o.put("allowJointBilling", "true");
////        o.put("customerID", "337");
////        o.put("billingPeriod", "MONTHLY");
////        o.put("billingDay", sp.format(d));
////        o.put("statusDate", sp.format(d));
////        o.put("secondContractorName", "Umu");
////        o.put("secondContractorFiscalNumber", "126263");
////        o.put("secondContractorAddress", "Ibadan");
////        o.put("startDate", sp.format(d));
////        o.put("endDate", sp.format(d));
////        o.put("preamble", "postpaid contract editing");
////        o.put("clauses", "terms and conditions");
////        o.put("expirationCondition", "non performance");
////        o.put("goodsAndServices", "telo phones");
////
////           System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/bss/v1/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
////       given().
////                contentType(JSON).
////                body(o.toJSONString()).
////                pathParam("id", "7").
////                when().
////                put("http://localhost:9080/bss/v1/provision/contract/postpaid/{id}").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    @Test
////    public void editContractTemplate() {
////
////        Date d = Calendar.getInstance().getTime();
////        SimpleDateFormat sp = new SimpleDateFormat("YYYY-MM-dd");
////        JSONObject o = new JSONObject();
////
////        o.put("creationDate", sp.format(d));
////        o.put("modificationDate", sp.format(d));
////        o.put("secondContractorName", "Mr Kolade");
////        o.put("secondContractorFiscalNumber", "89");
////        o.put("secondContractorAddress", "Lagos");
////        o.put("preamble", "ContractTemplateCreation");
////        o.put("clauses", "Terms and Conditions");
////        o.put("expirationCondition", "Lack of fullfilment of obligation");
////        o.put("goodsAndServices", "Some goods are missing");
////
////         System.out.println("the value being passed " + o.toJSONString());
////         given().contentType(JSON).contentType(JSON).pathParam("id", "1").when().put("http://localhost:9080/bss/v1/provision/contracts/templates/{id}").then().statusCode(200);
////       given().
////                contentType(JSON).
////                pathParam("id", "18").
////                body(o.toJSONString()).
////                when().
////                put("http://localhost:9080/bss/v1/provision/contracts/templates/{id}").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////
////    }
////
////    @Test
////    public void editTaxType() {
////
////        JSONObject o = new JSONObject();
////        o.put("description", "Tax considering the amount of income");
////        o.put("percentage", "90.0");
////
////      System.out.println("the value being passed " + o.toJSONString());
////        given().
////                contentType(JSON).
////                pathParam("tax_type_Id", "1").
////                body(o.toJSONString()).
////                when().
////                put("http://localhost:9080/bss/v1/provision/tax_types/{tax_type_Id}").
////                then().
////                body("message", equalTo("successful!")).
////                statusCode(200);
////
////       given().
////                contentType(JSON).pathParam("tax_type_Id", "7").
////                body(o.toJSONString()).
////                when().
////                put("http://localhost:9080/bss/v1/provision/tax_types/{tax_type_Id}").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    @Test
////    public void topupTeloAgentBalance() {
////        JSONObject o = new JSONObject();
////        o.put("topUpValue", 25.9);
////       given().
////                contentType(JSON).
////                pathParam("telo_agent_id", 2).
////                body(o).
////                when().
////                put("http://localhost:9080/bss/v1/provision/telo-agents/{telo_agent_id}/topup").
////                then().
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////
////    }
////
////    @Test
////    public void editTeloAgent() {
////
////        JSONObject o = new JSONObject();
////        o.put("prepaidServiceId", "902");
////        o.put("balance", "65.9");
////
////         given().contentType(JSON).pathParam("telo_agent_Id", "1").body(o.toJSONString()).when().put("http://localhost:9080/bss/v1/provision/telo_agents/{telo_agent_Id}").then().statusCode(200);
////       given().
////                contentType(JSON).
////                pathParam("telo_agent_Id", "3").
////                body(o.toJSONString()).
////                when().
////                put("http://localhost:9080/bss/v1/provision/telo_agents/{telo_agent_Id}").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    **********************TEST FOR GET OPERATIONS***********************************//
////    @Test
////    public void bssProvisionContractPostpaidCustomerCustomeridGet() {
////
////       given().
////                contentType(JSON).pathParam("customerid", "55").
////                when().
////                get("http://localhost:9080/bss/v1/provision/contract/postpaid/customer/{customerid}").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    public void getPayment() {
////
////       given().
////                contentType(JSON).
////                pathParam("payment_id", 5).
////                when().
////                get("http://localhost:9080/Emerge/bss/v1/bss/provision/payments/{payment_id}").
////                then().
////                     body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////
////    }
////
////    public void getTeloAgent() {
////      System.out.println("the value being passed " + o.toJSONString());
////      given().contentType(JSON).pathParam("customerid", "7").body(o.toJSONString()).when().post("http://localhost:9080/bss/v1/provision/contract/postpaid/customer/{customerid}").then().statusCode(200);
////       given().
////                pathParam("payment_id", 1).
////                contentType(JSON).
////                 body(o.toJSONString()).
////                when().
////                get("http://localhost:9080/bss/v1/provision/payments/{payment_id}").
////                then().
////                        body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////
////    }
////
////    public void getTaxType() {
////
////        JSONObject jo = new JSONObject();
////        jo.put("taxTypeId", 1);
////        jo.put("percentage", "90");
////        System.out.println("the value being passed " + jo.toJSONString());
////       given().
////                contentType(JSON).
////                queryParams(jo).
////                when().
////                get("http://localhost:9080/bss/v1/provision/tax_types").
////                then().
////                               body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////
////        String r = resp.asString();
////    }
////
////    public void getAllegedPayment() {
////
////        JSONObject jo = new JSONObject();
////        jo.put("AlledgedPaymentID", 6);
////        jo.put("paymentMethod", "EMIS");
////       System.out.println("the value being passed " + jo.toJSONString());
////       given().
////                contentType(JSON).
////                queryParams(jo).
////                when().
////                get("http://localhost:9080/bss/v1/provision/alleged_payment").
////                then().
////                               body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////
////        String r = resp.asString();
////
////    }
////
////    public void getContractTemplate() {
////
////        JSONObject jo = new JSONObject();
////        jo.put("templateId", 18);
////       System.out.println("the value being passed " + jo.toJSONString());
////       given().
////                contentType(JSON).
////                queryParams(jo).
////                when().
////                get("http://localhost:9080/bss/v1/provision/contracts/templates").
////                then().
////                               body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////
////        String r = resp.asString();
////    }
////
////    public void getPrepaidContract() {
////
////        JSONObject jo = new JSONObject();
////        jo.put("templateId", 18);
////       System.out.println("the value being passed " + jo.toJSONString());
////       given().
////                contentType(JSON).
////                queryParams(jo).
////                when().
////                get("http://localhost:9080/bss/v1/provision/contracts/templates").
////                then().
////                               body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////
////        String r = resp.asString();
////    }
////    **************TEST FOR DELETE OPERATIONS**********************************//
////
////    @Test
////    public void deletePostpaidContract() {
////
////       given().
////                contentType(JSON).
////                pathParam("id", "4").
////                when().
////                delete("http://localhost:9080/bss/v1/provision/contract/postpaid/{id}").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    @Test
////    public void deletePrepaidContract() {
////        JSONObject jo = new JSONObject();
////        jo.put("customerid", "544");
////        jo.put("contractid", "6");
////
////       given().
////                contentType(JSON).
////                pathParams(jo).
////                when().
////                delete("http://localhost:9080/bss/v1/provision/customer/{customerid}/contract/prepaid/{contractid}").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    @Test
////    public void deleteContractTemplate() {
////
////       given().
////                contentType(JSON).
////                pathParam("id", "18").
////                when().
////                delete("http://localhost:9080/bss/v1/provision/contracts/templates/{id}").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////    }
////
////    @Test
////    public void deleteTaxType() {
////       given().
////                contentType(JSON).
////                pathParam("tax_type_Id", "7").
////                when().
////                delete("http://localhost:9080/bss/v1/provision/tax_types/{tax_type_Id}").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////
////    }
////
//
//    @Test
//    public void deleteTeloAgent() {
//        given().
//                contentType(JSON).
//                pathParam("telo_agent_Id", "3").
//                when().
//                delete("http://localhost:8080/bss/v1/provision/telo_agents/{telo_agent_Id}").
//                then().statusCode(200).
//                body("message", equalTo("successful!")).
//                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
//
//    }
////
////    @Test
////    public void deletePayment() {
////
////        JSONObject jo = new JSONObject();
////        jo.put("paymentid", "2");
////        jo.put("customerid", "544");
////        jo.put("invoicenumber", "45678");
////       given().
////                contentType(JSON).
////                when().
////                pathParams(jo).
////                delete("http://localhost:9080/bss/v1/provision/payment/delete/{paymentid}/{customerid}/{invoicenumber}").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////
////    }
////
////    @Test
////    public void deleteAllegedPayment() {
////
////         given().contentType(JSON).pathParam("alledged_payment_Id", "1").when().delete("http://localhost:9080/bss/v1/provision/alledged_payment/{alledged_payment_Id}").then().statusCode(200);
////       given().
////                contentType(JSON).
////                when().
////                pathParam("alledged_payment_Id", "3").
////                delete("http://localhost:9080/bss/v1/provision/alledged_payment/{alledged_payment_Id}").
////                then().
////                body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////        String r = resp.asString();
////
////    }
////
////    =================PREPAID SERVICES==============//
////    @Test
////    public void createPrepaidService() {
////        JSONObject o = new JSONObject();
////        ServicePrepaid s = new ServicePrepaid();
////        o.put("externalProvisionId", "xxxxxx");
////        o.put("status", "ACTIVE");
////        o.put("name", "Mr. Kolade");
////        o.put("serviceType", "PSP");
////        o.put("productId", 1);
////
////        given().contentType(JSON).body(o.toJSONString()).when().post("http://localhost:8080/bss/v1/provision/services/prepaid").then().statusCode(200)
////                .body("message", equalTo("Successfully created!"));
////    }
////
////    @Test
////    public void updatePrepaidService() {
////        JSONObject o = new JSONObject();
////        o.put("externalProvisionId", "gt-i9556");
////        o.put("status", "DELETED");
////        o.put("name", "Mr. Akin");
////        o.put("serviceType", "PSP");
////        o.put("deletedReason", "EXPIRED");
////        o.put("productId", 1);
////        given().contentType(JSON).body(o.toJSONString()).pathParam("id", 8).when().put("http://localhost:8080/bss/v1/provision/services/prepaid/{id}").then().statusCode(200).body("message", equalTo("Successfully updated!"));
////
////    }
////
////    @Test
////    public void deletePrepaidService() {
////        given().contentType(JSON).when().pathParam("id", 9).delete("http://localhost:8080/bss/v1/provision/services/prepaid/{id}").then().statusCode(200).body("message", equalTo("Successfully Deleted!"));
////    }
////
////    @Test
////    public void bssProvisionServicesPrepaidGet() {
////       given().contentType(JSON).when().queryParam("type", "TELOOPERATOR").get("http://localhost:8080/bss/v1/provision/services/prepaid").then().contentType(JSON).extract().response();
////        String rr = r.asString();
////
////    }
////    =================PREPAID SERVICES ENDS=========//
////
////    ==============POSTPAID SERVICE===============//
////    @Test
////    public void createPostpaidService() {
////        JSONObject o = new JSONObject();
////        o.put("externalProvisionId", "S123MGN");
////        o.put("unitPrice", 123.67);
////        given().contentType(JSON).body(o.toJSONString()).when().post("http://localhost:8080/bss/v1/provision/products/postpaid").then().statusCode(200)
////                .body("message", equalTo("Successfully created!"));
////
////    }
////
////    @Test
////    public void updatePostpaidProduct() {
////        JSONObject o = new JSONObject();
////        o.put("externalProvisionId", "Google Pixel");
////        o.put("unitPrice", "2000.152");
////        given().contentType(JSON).body(o.toJSONString()).pathParam("id", 2).when().put("http://localhost:8080/bss/v1/provision/products/postpaid/{id}").then().statusCode(200).body("message", equalTo("Successfully updated!"));
////        o.put("unitPrice", "2000.152");
////        given().contentType(JSON).body(o.toJSONString()).pathParam("id", 2).when().put("http://localhost:8080/Emerge/bss/v1/bss/provision/products/postpaid/{id}").then().statusCode(200).body("message", equalTo("Successfully updated!"));
////    }
////
////    public void deletePostpaidService() {
////        given().contentType(JSON).when().pathParam("id", 2).delete("http://localhost:8080/bss/v1/provision/products/postpaid/{id}").then().statusCode(200).body("message", equalTo("Successfully Deleted!"));
////    }
////    =============POSTPAID SERVICE ENDS==========//
////
////    ================TELO OPERATOR CONFIG===========//
////    public void createTeloAgentProfitConfig() {
////        JSONObject o = new JSONObject();
////        o.put("startAmount", "7000.00");
////        o.put("endAmount", "4500.00");
////        o.put("profitPercentage", "40.0");
////        o.put("teloAgentId", 1);
////
////        given().contentType(JSON).body(o.toJSONString()).when().post("http://localhost:8080/Emerge/bss/v1/bss/provision/telo-agent-profit-config").then().statusCode(200)
////                .body("message", equalTo("Successfully Configured!"));
////    }
////
////    @Test
////    public void updateTeloAgentProfitConfig() {
////        JSONObject o = new JSONObject();
////        o.put("startAmount", "15000.00");
////        o.put("endAmount", "7000.00");
////        given().contentType(JSON).body(o.toJSONString()).pathParam("telo_agent_id", 1).when().put("http://localhost:8080/Emerge/bss/v1/bss/provision/telo-agent-profit-config/update/{telo_agent_id}").then().statusCode(200).body("message", equalTo("Successfully updated!"));
////    }
////
////    @Test
////
////    public void deleteTeloAgentProfitConfig() {
////        given().contentType(JSON).when().pathParam("id", 1).delete("http://localhost:8080/bss/v1/provision/telo-agent-profit-config/delete/{telo_agent_id}").then().statusCode(200).body("message", equalTo("Successfully Deleted!"));
////    }
////    ================TELO OPERATOR CONFIG ENDS=====//
////
////    ===============CUSTOMER CONTACTS=============//
////    @Test
////    public void createContact() {
////        JSONObject o = new JSONObject();
////        o.put("contactType", "Billing");
////        o.put("contactName", "Big2");
////        o.put("contactEmail", "abc@gmail.com");
////        o.put("contactPhone", "08105212590");
////        o.put("contactFax", "+2341098655");
////        o.put("billingAddressId", 2);
////
////        given().contentType(JSON).body(o.toJSONString()).pathParam("customer_id", 4).pathParam("customer_address_id", 2).when().post("http://localhost:8080/bss/v1/provision/customers/{customer_id}/customer-addresses/{customer_address_id}/customers-contacts").then().statusCode(200);
////    }
////
////    @Test
////    public void updateCustomerContact() {
////        JSONObject o = new JSONObject();
////        o.put("contactType", "Customer");
////        o.put("contactName", "BigWAZZA");
////        o.put("contactEmail", "abc@gmail.com");
////        o.put("contactPhone", "081052120");
////        o.put("contactFax", "+23410986445");
////        o.put("billingAddressId", 6);
////        o.put("notifyBySms", true);
////        o.put("notifyByEmail", true);
////        o.put("sendInvoiceByEmail", false);
////
////        given().contentType(JSON).body(o.toJSONString()).pathParam("customer_id", 42).pathParam("customer_address_id", 6).pathParam("id", 1).when().put("http://localhost:8080/bss/v1/provision/customers/{customer_id}/customer-addresses/{customer_address_id}/customer-contacts/{id}").then().statusCode(204);
////    }
////
////
////    @Test
////    public void deleteCustomerContact() {
////        given().contentType(JSON).when().pathParam("customer_id", 3).pathParam("customer_address_id", 52).pathParam("id", 49).delete("http://localhost:8080/bss/v1/provision/customers/{customer_id}/customer-addresses/{customer_address_id}/customer-contacts/{id}").then().statusCode(200).body("message", equalTo("Successfully Deleted!"));
////    }
//
//    @Test
//    public void deleteCustomerContact() {
//        given().when().delete("http://localhost:8080/bss/v1/provision/customers/3/customer-addresses/52/customer-contacts/49").then().statusCode(200);
//    }
////
////    @Test
////    public void searchCustomerContact() {
////        JSONObject oj = new JSONObject();
////        oj.put("customer_address_id", 1);
////        oj.put("customer_id", 1);
////       given().contentType(JSON).pathParams(oj).when().get("http://localhost:8080/bss/v1/provision/customers/{customer_id}/customer-addresses/{customer_address_id}/customers-contacts").then().contentType(ContentType.JSON).extract().response();
////
////    }
////
////    @Test
////    public void getPrepaidService() {
////
////       given().
////                contentType(JSON).queryParam("external_provision_id", "xxxxxx").
////                when().
////                get("http://localhost:9080/bss/v1/provision/services/prepaid").
////                then().
////                   body("message", equalTo("successful!")).
////                contentType(ContentType.JSON).extract().response();
////    }
////    
////    @Test
////    public void confirmBankStatement(){
////        JSONObject oj = new JSONObject();
////        oj.put("bank_name", "BFA");
////        oj.put("file_id", "f8299bee-0cef-412e-952a-ad8e77aae677Ficheiro BFA.csv");
////        given().contentType(JSON).body(oj).when().post("http://localhost:8080/bss/v1/provision/confirm").then().contentType(ContentType.JSON).extract().response();
////    }
////
////    ===============CUSTOMER CONTAACTS END=======//
////    ===============CUSTOMER CONTAACTS END=======//
//
//    public static void main(String[] args) {
//
//        OperationsRestTest op = new OperationsRestTest();
//        op.rullAll();
//
//    }
//
//    void rullAll() {
////        confirmBankStatement();
////       searchCustomerContact();
//    deleteCustomerContact();
//       // deleteTeloAgent();
////         updateCustomerContact();
////        createContact();
////        fetchCustomer();
////                createContact()
//// deleteTeloAgentProfitConfig();
////         updateTeloAgentProfitConfig();
////        createTeloAgentProfitConfig();
////        deletePostpaidService();  
////        deletePostpaidService();
////        deleteBillingAddress();
////        updatePostpaidProduct();
////        createPostpaidService();
////        bssProvisionServicesPrepaidGet();
////
////        deletePrepaidService();
////         deletePrepaidService();
////        updatePrepaidService();
////         createPrepaidService();
////         createContractTemplate();
////         createPostpaidContract();
////        createPrepaidContract();
////         taxTypes();
////        teloAgent();
////          payment();
////         allegedPayment();
////  bssProvisionContractPostpaidCustomerCustomeridGet();
//// editTeloAgent();
////getPayment();
////getTaxType();
////getAllegedPayment();
////getContractTemplate();
////        editTaxType();
//// editContractTemplate();
////        editPostpaidContract();
////         editPrepaidContract();
////        UpdatePayment();
////UpdateAllegedPayment();
////deletePostpaidContract() ;
////deletePrepaidContract();
////deleteContractTemplate();
////deleteTaxType();
////deleteTeloAgent();
////deletePayment();
////deleteAllegedPayment();
////        deleteCustomer();
////        creatCustomer();
////
////        creatCustomer();
////         creatBillingAddress();
////         updateBillingAddress();
////                updateCustomer();
////        deleteCustomer();
////        createContractTemplate();
////        createPostpaidContract();
////        createPrepaidContract();
////        taxTypes();
////           teloAgent();
////        payment();
////        allegedPayment();
////getTeloAgent();
////topupTeloAgentBalance();
//    }
//}
