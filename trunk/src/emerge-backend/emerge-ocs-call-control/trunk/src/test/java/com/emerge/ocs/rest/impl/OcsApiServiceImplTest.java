///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.emerge.ocs.rest.impl;
//
//import com.emerge.ocs.rest.api.ApiResponseMessage;
//import com.emerge.ocs.rest.api.NotFoundException;
//import com.emerge.ocs.rest.model.AuthenticationReq;
//import com.emerge.ocs.rest.model.EndServiceReq;
//import com.emerge.ocs.rest.model.PayphoneAuthenticationData;
//import com.emerge.ocs.rest.model.ServiceParams;
//import com.emerge.ocs.rest.model.StartServiceRequest;
//import com.emerge.ocs.rest.model.StartServiceResponse;
//import com.emerge.ocs.rest.test.TestPreloadedModelProvider;
//import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.SecurityContext;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author kingsley
// */
//public class OcsApiServiceImplTest {
//    
//    AuthenticationReq payphoneInformation;
//    StartServiceResponse startServiceResponse;
//    OcsApiServiceImpl instance;
//    PayphoneAuthenticationData payphoneAuthenticationData;
//    
//    public OcsApiServiceImplTest() {
//        payphoneInformation =
//           new TestPreloadedModelProvider().getAuthenticationReq();
//        instance = new OcsApiServiceImpl();
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//        
//    }
//    
//    @After
//    public void tearDown() {
//    }
//    
//    
//    @Test
//    public void testCresteService(){
//         System.out.println("testCresteService");
//         long result = 0;
//        try {
////             result = instance.createPayphoneService(payphoneInformation);
////       assertEquals(result, 1);
//        } catch (Exception ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                .log(Level.SEVERE, null, ex);
//        }
//        if (result > 0) {
//            testLogin();
//            testResumeSession();
//            testStartService();
//            testNotifyStartService();
//            testEndService();
//        }
//       
//    }
//    
//    /**
//     * Test of login method, of class OcsApiServiceImpl.
//     */
//    private final void testLogin() {
//        System.out.println("login");
//        String accessToken = "";
//        SecurityContext securityContext = null;
//        HttpServletRequest requestContext = null;
//        Response expResult = null;
//        Response result = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        try {
//            result = instance.login(payphoneInformation, accessToken,
//                securityContext, requestContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                .log(Level.SEVERE, null, ex);
//        }
//        payphoneAuthenticationData 
//            = (PayphoneAuthenticationData) result.getEntity();
//        System.out.println(result.getEntity());
//        assertNotNull(result);
//        assertNotNull(payphoneAuthenticationData.getConfigData());
//        assertNotNull(payphoneAuthenticationData.getBalance());
//        assertEquals("Payphone Authenticated",
//            payphoneAuthenticationData.getMessage());
//        assertNotNull(payphoneAuthenticationData.getSessionStartTime());
////        assertEquals(expResult, result);
//        // TODO review the generated test code and remove default call to fail.
//    }
//    
//    /**
//     * Test of resumeSession method, of class OcsApiServiceImpl.
//     */
//    private final void testResumeSession() {
//        System.out.println("resumeSession");
//        int sessionId = payphoneAuthenticationData.getSessionID();
//        String accessToken = payphoneAuthenticationData.getAccessToken();
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.resumeSession(sessionId, accessToken,
//                securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                .log(Level.SEVERE, null, ex);
//        }
//        ApiResponseMessage apiResponseMessage = (ApiResponseMessage)
//            result.getEntity();
//        assertNotNull(result);
//        assertEquals(200, result.getStatus());
//        assertEquals("Session resumed",
//            apiResponseMessage.getMessage());
//        // TODO review the generated test code and remove default call to fail.
//    }
//    
//    
//    /**
//     * Test of startService method, of class OcsApiServiceImpl.
//     */
//    private final void testStartService() {
//        System.out.println("startService");
//        int sessionId = payphoneAuthenticationData.getSessionID();
//        String accessToken = payphoneAuthenticationData.getAccessToken();
//        StartServiceRequest startServiceRequest = new StartServiceRequest();
//        startServiceRequest.setDestinationMsisdn("+2348034609060");
//        startServiceRequest.setOriginMsisdn("+234567865432");
//        startServiceRequest.setServiceCredit(300);
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.startService(sessionId, accessToken,
//                startServiceRequest, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                .log(Level.SEVERE, null, ex);
//        }
//        startServiceResponse = (StartServiceResponse)
//            result.getEntity();
//        assertNotNull(result);
//        assertEquals(200, result.getStatus());
//        assertNotNull(startServiceResponse);
//        assertNotNull(startServiceResponse.getMaxServiceDuration());
//        assertNotNull(startServiceResponse.getServiceAuthorizedTime());
//        assertNotNull(startServiceResponse.getTariff());
//        assertEquals("+234567865432", startServiceResponse.getOriginMsisdn());
//        // TODO review the generated test code and remove default call to fail.
//    }
//    
//    
//    /**
//     * Test of notifyStartService method, of class OcsApiServiceImpl.
//     */
//    private final void testNotifyStartService() {
//        System.out.println("notifyStartService");
//        ServiceParams serviceParams = new ServiceParams();
//        serviceParams.setCallAnswerTime(new Date());
//        serviceParams.setServiceStartTime(new Date());
//        int sessionId = payphoneAuthenticationData.getSessionID();
//        int serviceId = startServiceResponse.getServiceId();
//        String accessToken = payphoneAuthenticationData.getAccessToken();
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.notifyStartService(serviceParams, sessionId,
//                serviceId, accessToken, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                .log(Level.SEVERE, null, ex);
//        }
//        ApiResponseMessage apiResponseMessage = (ApiResponseMessage)
//            result.getEntity();
//        assertNotNull(result);
//        assertEquals(200, result.getStatus());
//        assertEquals("Start service notified!",
//            apiResponseMessage.getMessage());
//        // TODO review the generated test code and remove default call to fail.
//    }
//
//
//    /**
//     * Test of endService method, of class OcsApiServiceImpl.
//     */
//    private final void testEndService() {
//        System.out.println("endService");
//        EndServiceReq notifyServiceInformation = new EndServiceReq();
//        notifyServiceInformation.setCallAnswerTime(new Date());
//        notifyServiceInformation.setEndCause("call ended");
//        notifyServiceInformation.setServiceDuration(84);
//        notifyServiceInformation.setServiceEndTime(new Date());
//        notifyServiceInformation.setServiceStartTime(new Date());
//        int sessionId = payphoneAuthenticationData.getSessionID();
//        int serviceId = startServiceResponse.getServiceId();
//        String accessToken = payphoneAuthenticationData.getAccessToken();
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.endService(notifyServiceInformation, sessionId,
//                serviceId, accessToken, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                .log(Level.SEVERE, null, ex);
//        }
//        assertNotNull(result);
//        // TODO review the generated test code and remove default call to fail.
//    }
//
////    /**
////     * Test of endsession method, of class OcsApiServiceImpl.
////     */
////    @Test
////    public void testEndsession() throws Exception {
////        System.out.println("endsession");
////        int sessionid = 0;
////        String accessToken = "";
////        SecurityContext securityContext = null;
////        OcsApiServiceImpl instance = new OcsApiServiceImpl();
////        Response expResult = null;
////        Response result = instance.endsession(sessionid, accessToken, securityContext);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of keepAlive method, of class OcsApiServiceImpl.
////     */
////    @Test
////    public void testKeepAlive() throws Exception {
////        System.out.println("keepAlive");
////        String accessToken = "";
////        AuthenticationReq keepAliveReq = null;
////        SecurityContext securityContext = null;
////        OcsApiServiceImpl instance = new OcsApiServiceImpl();
////        Response expResult = null;
////        Response result = instance.keepAlive(accessToken, keepAliveReq, securityContext);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of logevent method, of class OcsApiServiceImpl.
////     */
////    @Test
////    public void testLogevent() throws Exception {
////        System.out.println("logevent");
////        String accessToken = "";
////        LogReq logReq = null;
////        SecurityContext securityContext = null;
////        OcsApiServiceImpl instance = new OcsApiServiceImpl();
////        Response expResult = null;
////        Response result = instance.logevent(accessToken, logReq, securityContext);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//    
//
//
//
//
////    /**
////     * Test of logout method, of class OcsApiServiceImpl.
////     */
////    @Test
////    public void testLogout() throws Exception {
////        System.out.println("logout");
////        String accessToken = "";
////        int sessionID = 0;
////        SecurityContext securityContext = null;
////        OcsApiServiceImpl instance = new OcsApiServiceImpl();
////        Response expResult = null;
////        Response result = instance.logout(accessToken, sessionID, securityContext);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
//    
//
//    
//    
////
//
////
////    /**
////     * Test of logServiceEvent method, of class OcsApiServiceImpl.
////     */
////    @Test
////    public void testLogServiceEvent() throws Exception {
////        System.out.println("logServiceEvent");
////        int sessionid = 0;
////        int serviceid = 0;
////        String accessToken = "";
////        LogReq logReq = null;
////        SecurityContext securityContext = null;
////        OcsApiServiceImpl instance = new OcsApiServiceImpl();
////        Response expResult = null;
////        Response result = instance.logServiceEvent(sessionid, serviceid, accessToken, logReq, securityContext);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of logSessionEvent method, of class OcsApiServiceImpl.
////     */
////    @Test
////    public void testLogSessionEvent() throws Exception {
////        System.out.println("logSessionEvent");
////        int sessionid = 0;
////        String accessToken = "";
////        LogReq logReq = null;
////        SecurityContext securityContext = null;
////        OcsApiServiceImpl instance = new OcsApiServiceImpl();
////        Response expResult = null;
////        Response result = instance.logSessionEvent(sessionid, accessToken, logReq, securityContext);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////    
//}
