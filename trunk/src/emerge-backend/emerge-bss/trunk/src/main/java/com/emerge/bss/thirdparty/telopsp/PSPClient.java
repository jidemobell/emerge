///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.emerge.bss.thirdparty.telopsp;
//
//import javax.xml.bind.JAXBElement;
//import org.datacontract.schemas._2004._07.ObjectFactory;
//import org.datacontract.schemas._2004._07.RequestAddCredit;
//import org.datacontract.schemas._2004._07.ResponseAddCredit;
//
////vvideo stripe
///**
// *
// * @author Yusuf
// */
//public class PSPClient {
//
//    static ResponseAddCredit response;
//    static RequestAddCredit requestAddCredit;
//    ObjectFactory factory = new ObjectFactory();
//
//    public PSPClient() {
//
//        response = new ResponseAddCredit();
//
//        requestAddCredit = new RequestAddCredit();
//
//        factory = new ObjectFactory();
//
//    }
//
//    public static void main(String args[]) {
//
//        PSPClient pspclient = new PSPClient();
//
//        requestAddCredit = pspclient.getCreditParameters("100", "Timwe", "Password123", "1500");
//        response = pspclient.addCredit(requestAddCredit);
//        
//        
//        System.out.println("The CurrentValue is : "+response.getAddCreditCurrentValue().getValue());
//        
//        System.out.println("The Description  is : "+response.getAddCreditDescription().getValue());
//        
//        System.out.println("The PreviousValue is : "+response.getAddCreditPreviousValue().getValue());
//        
//        System.out.println("The Response is " + response.getAddCreditReturnCode());
//        
//    }
//
//    public RequestAddCredit getCreditParameters(String agentId, String username, String password, String creditAmount) {
//
//        RequestAddCredit request = new RequestAddCredit();
//        JAXBElement<String> createRequestAddCreditAdd = factory.createRequestAddCreditAddCreditAgentID(agentId);
//        request.setAddCreditAgentID(createRequestAddCreditAdd);
//
//        JAXBElement<String> createAddCreditPassword = factory.createRequestAddCreditAddCreditPassword(password);
//        request.setAddCreditPassword(createAddCreditPassword);
//
//        JAXBElement<String> createAddCreditUsername = factory.createRequestAddCreditAddCreditUsername(username);
//        request.setAddCreditUsername(createAddCreditUsername);
//
//        JAXBElement<String> createAddCreditValue = factory.createRequestAddCreditAddCreditValue(creditAmount);
//        request.setAddCreditValue(createAddCreditValue);
//
//        return request;
//    }
//
//    private static ResponseAddCredit addCredit(org.datacontract.schemas._2004._07.RequestAddCredit request) {
//        org.tempuri.ServiceBSS service = new org.tempuri.ServiceBSS();
//        org.tempuri.IServiceBSS port = service.getBasicHttpBindingIServiceBSS();
//        return port.addCredit(request);
//    }
//
//}
