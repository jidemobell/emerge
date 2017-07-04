///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package io.swagger.api.impl;
//
//import io.swagger.api.NotFoundException;
//import java.io.InputStream;
//import java.util.Date;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.core.SecurityContext;
//import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
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
//public class BssPaymentsApiServiceImplTest {
//    
//    public BssPaymentsApiServiceImplTest() {
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
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of createAllegedPayment method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testCreateAllegedPayment() throws NotFoundException {
//        System.out.println("createAllegedPayment");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.AllegedPayment alledgedPayment = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createAllegedPayment(umUserHash, umSessionId, umDomain, alledgedPayment, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createInvoice method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testCreateInvoice() throws NotFoundException {
//        System.out.println("createInvoice");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.Invoice createInvoice = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createInvoice(umUserHash, umSessionId, umDomain, createInvoice, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createPayment method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testCreatePayment() throws NotFoundException {
//        System.out.println("createPayment");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.Payment paymentRecord = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createPayment(umUserHash, umSessionId, umDomain, paymentRecord, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createTaxType method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testCreateTaxType() throws NotFoundException {
//        System.out.println("createTaxType");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.TaxType taxType = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createTaxType(umUserHash, umSessionId, umDomain, taxType, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createTeloAgent method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testCreateTeloAgent() throws NotFoundException {
//        System.out.println("createTeloAgent");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.TeloAgents telo = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createTeloAgent(umUserHash, umSessionId, umDomain, telo, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createTeloAgentProfitConfig method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testCreateTeloAgentProfitConfig() throws NotFoundException {
//        System.out.println("createTeloAgentProfitConfig");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.TeloAgentProfitConfig teloAgentProfitConfig = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createTeloAgentProfitConfig(umUserHash, umSessionId, umDomain, teloAgentProfitConfig, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createTeloOperatorProfitConfig method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testCreateTeloOperatorProfitConfig() throws NotFoundException {
//        System.out.println("createTeloOperatorProfitConfig");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.TeloOperatorProfitConfig teloOperatorProfitConfig = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createTeloOperatorProfitConfig(umUserHash, umSessionId, umDomain, teloOperatorProfitConfig, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteAlledgedPayment method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testDeleteAlledgedPayment() throws NotFoundException {
//        System.out.println("deleteAlledgedPayment");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long alledgedPaymentId = 0L;
//        io.swagger.model.AllegedPayment alledgedPayment = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deleteAlledgedPayment(umUserHash, umSessionId, umDomain, alledgedPaymentId, alledgedPayment, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deletePayment method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testDeletePayment() throws NotFoundException {
//        System.out.println("deletePayment");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long paymentId = 0L;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deletePayment(umUserHash, umSessionId, umDomain, paymentId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteTaxType method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testDeleteTaxType() throws NotFoundException {
//        System.out.println("deleteTaxType");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long taxTypeId = 0L;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deleteTaxType(umUserHash, umSessionId, umDomain, taxTypeId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteTeloAgent method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testDeleteTeloAgent() throws NotFoundException {
//        System.out.println("deleteTeloAgent");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long teloAgentId = 0L;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deleteTeloAgent(umUserHash, umSessionId, umDomain, teloAgentId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteTeloAgentProfitConfig method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testDeleteTeloAgentProfitConfig() throws NotFoundException {
//        System.out.println("deleteTeloAgentProfitConfig");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long teloAgentId = 0L;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deleteTeloAgentProfitConfig(umUserHash, umSessionId, umDomain, teloAgentId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteTeloOperatorProfitConfig method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testDeleteTeloOperatorProfitConfig() throws NotFoundException {
//        System.out.println("deleteTeloOperatorProfitConfig");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long id = 0L;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deleteTeloOperatorProfitConfig(umUserHash, umSessionId, umDomain, id, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCreditNote method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testGetCreditNote() throws NotFoundException {
//        System.out.println("getCreditNote");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long limit = null;
//        Long customerId = null;
//        Long paymentId = null;
//        Long invoiceNumber = null;
//        Long offset = null;
//        String creditNote = "";
//        String creditNoteDescription = "";
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.getCreditNote(umUserHash, umSessionId, umDomain, limit, customerId, paymentId, invoiceNumber, offset, creditNote, creditNoteDescription, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getInvoiceByInvoiceNumber method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testGetInvoiceByInvoiceNumber() throws NotFoundException {
//        System.out.println("getInvoiceByInvoiceNumber");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long invoiceNumber = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.getInvoiceByInvoiceNumber(umUserHash, umSessionId, umDomain, invoiceNumber, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getInvoices method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testGetInvoices() throws NotFoundException {
//        System.out.println("getInvoices");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        String customerName = "";
//        long customerId = 0L;
//        String customerFiscalNumber = "";
//        String customerContact = "";
//        String customerEmail = "";
//        String customerUsername = "";
//        long paymentId = 0L;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.getInvoices(umUserHash, umSessionId, umDomain, customerName, customerId, customerFiscalNumber, customerContact, customerEmail, customerUsername, paymentId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPayment method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testGetPayment() throws NotFoundException {
//        System.out.println("getPayment");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long limit = 0L;
//        long offset = 0L;
//        long paymentId = 0L;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.getPayment(umUserHash, umSessionId, umDomain, limit, offset, paymentId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPaymentReceipt method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testGetPaymentReceipt() throws NotFoundException {
//        System.out.println("getPaymentReceipt");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long paymentId = 0L;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.getPaymentReceipt(umUserHash, umSessionId, umDomain, paymentId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTeloAgentProfitConfig method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testGetTeloAgentProfitConfig() throws NotFoundException {
//        System.out.println("getTeloAgentProfitConfig");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long limit = null;
//        Long teloAgentId = null;
//        Long offset = null;
//        String teloAgentProfit = "";
//        String teloAgentDescription = "";
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.getTeloAgentProfitConfig(umUserHash, umSessionId, umDomain, limit, teloAgentId, offset, teloAgentProfit, teloAgentDescription, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTeloOperatorProfitConfig method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testGetTeloOperatorProfitConfig() throws NotFoundException {
//        System.out.println("getTeloOperatorProfitConfig");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long limit = null;
//        Long id = null;
//        Long offset = null;
//        String teloOperatorProfitConfig = "";
//        String teloOperatorProfitConfigDescription = "";
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.getTeloOperatorProfitConfig(umUserHash, umSessionId, umDomain, limit, id, offset, teloOperatorProfitConfig, teloOperatorProfitConfigDescription, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of revokePayment method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testRevokePayment() throws NotFoundException {
//        System.out.println("revokePayment");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long paymentId = 0L;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//
//        Response result = instance.revokePayment(umUserHash, umSessionId, umDomain, paymentId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchAllegedPayment method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testSearchAllegedPayment() throws NotFoundException {
//        System.out.println("searchAllegedPayment");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        String paymentMethod = "";
//        String serviceToProvision = "";
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.searchAllegedPayment(umUserHash, umSessionId, umDomain, paymentMethod, serviceToProvision, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchPayment method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testSearchPayment() throws NotFoundException {
//        System.out.println("searchPayment");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long limit = null;
//        Date beginDate = null;
//        Date endDate = null;
//        Long offset = null;
//        String customerId = "";
//        long customerName = 0L;
//        String customerFiscalNumber = "";
//        String customerPhoneNumber = "";
//        String customerEmail = "";
//        String customerUsername = "";
//        String invoiceNumber = "";
//        String paymentMethod = "";
//        String paymentReference = "";
//        String paymentStatus = "";
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//
//        Response result = instance.searchPayment(umUserHash, umSessionId, umDomain, limit, beginDate, endDate, offset, customerId, customerName, customerFiscalNumber, customerPhoneNumber, customerEmail, customerUsername, invoiceNumber, paymentMethod, paymentReference, paymentStatus, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchTaxType method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testSearchTaxType() throws NotFoundException {
//        System.out.println("searchTaxType");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long offset = null;
//        Long limit = null;
//        String description = "";
//        long percentage = 0L;
//        long taxTypeId = 0L;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.searchTaxType(umUserHash, umSessionId, umDomain, offset, limit, description, percentage, taxTypeId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setTeloAgentBalance method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testSetTeloAgentBalance() throws NotFoundException {
//        System.out.println("setTeloAgentBalance");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long teloAgentId = 0L;
//        String newBalance = "";
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.setTeloAgentBalance(umUserHash, umSessionId, umDomain, teloAgentId, newBalance, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of topupTeloAgentBalance method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testTopupTeloAgentBalance() throws NotFoundException {
//        System.out.println("topupTeloAgentBalance");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long teloAgentServiceId = 0L;
//        io.swagger.model.TeloAgents topupValue = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.topupTeloAgentBalance(umUserHash, umSessionId, umDomain, teloAgentServiceId, topupValue, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateAllegedPayment method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testUpdateAllegedPayment() throws NotFoundException {
//        System.out.println("updateAllegedPayment");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long alledgedPaymentId = 0L;
//        io.swagger.model.AllegedPayment teloAgent = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updateAllegedPayment(umUserHash, umSessionId, umDomain, alledgedPaymentId, teloAgent, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updatePayment method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testUpdatePayment() throws NotFoundException {
//        System.out.println("updatePayment");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long paymentId = 0L;
//        io.swagger.model.Payment payment = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updatePayment(umUserHash, umSessionId, umDomain, paymentId, payment, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateTaxType method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testUpdateTaxType() throws NotFoundException {
//        System.out.println("updateTaxType");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long taxTypeId = 0L;
//        io.swagger.model.TaxType taxType = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updateTaxType(umUserHash, umSessionId, umDomain, taxTypeId, taxType, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateTeloAgentProfitConfig method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testUpdateTeloAgentProfitConfig() throws NotFoundException {
//        System.out.println("updateTeloAgentProfitConfig");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long teloAgentId = null;
//        io.swagger.model.TeloAgentProfitConfig contract = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updateTeloAgentProfitConfig(umUserHash, umSessionId, umDomain, teloAgentId, contract, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateTeloOperatorProfitConfig method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testUpdateTeloOperatorProfitConfig() throws NotFoundException {
//        System.out.println("updateTeloOperatorProfitConfig");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long id = null;
//        io.swagger.model.TeloOperatorProfitConfig teloOperatorProfitConfig = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updateTeloOperatorProfitConfig(umUserHash, umSessionId, umDomain, id, teloOperatorProfitConfig, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchTeloAgent method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testSearchTeloAgent() throws NotFoundException {
//        System.out.println("searchTeloAgent");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long offset = null;
//        Long limit = null;
//        long telo_agent_id = 0L;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.searchTeloAgent(umUserHash, umSessionId, umDomain, offset, limit, telo_agent_id, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of confirmBankStatement method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testConfirmBankStatement() throws NotFoundException {
//        System.out.println("confirmBankStatement");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        String fileId = "";
//        String bankName = "";
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.confirmBankStatement(umUserHash, umSessionId, umDomain, fileId, bankName, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of uploadBankStatement method, of class BssPaymentsApiServiceImpl.
//     */
//    @Test
//    public void testUploadBankStatement() throws NotFoundException {
//        System.out.println("uploadBankStatement");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        String bankName = "";
//        InputStream statementFileInputStream = null;
//        FormDataContentDisposition statementFileDetail = null;
//        SecurityContext securityContext = null;
//        BssPaymentsApiServiceImpl instance = new BssPaymentsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.uploadBankStatement(umUserHash, umSessionId, umDomain, bankName, statementFileInputStream, statementFileDetail, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
