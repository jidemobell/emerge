///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package io.swagger.api.impl;
//
//import io.swagger.api.NotFoundException;
//import java.util.Date;
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
//public class BssContractsApiServiceImplTest {
//    
//    public BssContractsApiServiceImplTest() {
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
//     * Test of bssProvisionContractsTemplatesGet method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testBssProvisionContractsTemplatesGet() throws NotFoundException {
//        System.out.println("bssProvisionContractsTemplatesGet");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long limit = 0L;
//        long offset = 0L;
//        long templateId = 0L;
//        String templateDescription = "";
//        String createdBy = "";
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.bssProvisionContractsTemplatesGet(umUserHash, umSessionId, umDomain, limit, offset, templateId, templateDescription, createdBy, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of bssProvisionCustomersCustomerIdContractsPostpaidGet method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testBssProvisionCustomersCustomerIdContractsPostpaidGet() throws NotFoundException {
//        System.out.println("bssProvisionCustomersCustomerIdContractsPostpaidGet");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long customerId = 0L;
//        long id = 0L;
//        long offset = 0L;
//        long limit = 0L;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.bssProvisionCustomersCustomerIdContractsPostpaidGet(umUserHash, umSessionId, umDomain, customerId, id, offset, limit, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of bssProvisionCustomersCustomerIdContractsPrepaidContractIdGet method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testBssProvisionCustomersCustomerIdContractsPrepaidContractIdGet() throws NotFoundException {
//        System.out.println("bssProvisionCustomersCustomerIdContractsPrepaidContractIdGet");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long customerId = 0L;
//        long contractId = 0L;
//        long offset = 0L;
//        long limit = 0L;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.bssProvisionCustomersCustomerIdContractsPrepaidContractIdGet(umUserHash, umSessionId, umDomain, customerId, contractId, offset, limit, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of bssProvisionCustomersCustomerIdContractsPrepaidGet method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testBssProvisionCustomersCustomerIdContractsPrepaidGet() throws NotFoundException {
//        System.out.println("bssProvisionCustomersCustomerIdContractsPrepaidGet");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long customerId = 0L;
//        String contract_type = "";
//        String status = "";
//        Date creation_date = null;
//        String service_type = "";
//        long offset = 0L;
//        long limit = 0L;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.bssProvisionCustomersCustomerIdContractsPrepaidGet(umUserHash, umSessionId, umDomain, customerId, contract_type, status, creation_date, service_type, offset, limit, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of bssProvisionServicesPrepaidGet method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testBssProvisionServicesPrepaidGet() throws NotFoundException {
//        System.out.println("bssProvisionServicesPrepaidGet");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long limit = 0L;
//        long offset = 0L;
//        String type = "";
//        String status = "";
//        String external_provision_id = "";
//        Date creation_date = null;
//        Date modification_date = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.bssProvisionServicesPrepaidGet(umUserHash, umSessionId, umDomain, limit, offset, type, status, external_provision_id, creation_date, modification_date, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of confirmContract method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testConfirmContract() throws NotFoundException {
//        System.out.println("confirmContract");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long customerId = 0L;
//        long id = 0L;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.confirmContract(umUserHash, umSessionId, umDomain, customerId, id, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createContractPrepaid method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testCreateContractPrepaid() throws NotFoundException {
//        System.out.println("createContractPrepaid");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long customerId = 0L;
//        io.swagger.model.ContractPrepaid contract = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createContractPrepaid(umUserHash, umSessionId, umDomain, customerId, contract, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createContractTemplate method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testCreateContractTemplate() throws NotFoundException {
//        System.out.println("createContractTemplate");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.ContractTemplate contract = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createContractTemplate(umUserHash, umSessionId, umDomain, contract, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createPostpaidContract method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testCreatePostpaidContract() throws NotFoundException {
//        System.out.println("createPostpaidContract");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long customerId = 0L;
//        io.swagger.model.ContractPostpaid contract = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createPostpaidContract(umUserHash, umSessionId, umDomain, customerId, contract, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createPostpaidService method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testCreatePostpaidService() throws NotFoundException {
//        System.out.println("createPostpaidService");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.ProductPostpaid postpaidService = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createPostpaidService(umUserHash, umSessionId, umDomain, postpaidService, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createPrepaidService method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testCreatePrepaidService() throws NotFoundException {
//        System.out.println("createPrepaidService");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.ServicePrepaid prepaidService = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createPrepaidService(umUserHash, umSessionId, umDomain, prepaidService, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteContractTemplate method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testDeleteContractTemplate() throws NotFoundException {
//        System.out.println("deleteContractTemplate");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long id = 0L;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deleteContractTemplate(umUserHash, umSessionId, umDomain, id, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deletePostPaidService method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testDeletePostPaidService() throws NotFoundException {
//        System.out.println("deletePostPaidService");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long id = 0L;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deletePostPaidService(umUserHash, umSessionId, umDomain, id, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deletePostpaidContract method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testDeletePostpaidContract() throws NotFoundException {
//        System.out.println("deletePostpaidContract");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long customerId = 0L;
//        long id = 0L;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deletePostpaidContract(umUserHash, umSessionId, umDomain, customerId, id, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deletePrepaidContract method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testDeletePrepaidContract() throws NotFoundException {
//        System.out.println("deletePrepaidContract");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long customerId = 0L;
//        long contractId = 0L;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deletePrepaidContract(umUserHash, umSessionId, umDomain, customerId, contractId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deletePrepaidService method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testDeletePrepaidService() throws NotFoundException {
//        System.out.println("deletePrepaidService");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long id = 0L;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deletePrepaidService(umUserHash, umSessionId, umDomain, id, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPostpaidProducts method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testGetPostpaidProducts() throws NotFoundException {
//        System.out.println("getPostpaidProducts");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long limit = 0L;
//        long customerId = 0L;
//        long contractId = 0L;
//        long offset = 0L;
//        String postpaidService = "";
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.getPostpaidProducts(umUserHash, umSessionId, umDomain, limit, customerId, contractId, offset, postpaidService, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPrepaidService method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testGetPrepaidService() throws NotFoundException {
//        System.out.println("getPrepaidService");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long id = 0L;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.getPrepaidService(umUserHash, umSessionId, umDomain, id, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateContractTemplate method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testUpdateContractTemplate() throws NotFoundException {
//        System.out.println("updateContractTemplate");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long id = 0L;
//        io.swagger.model.ContractTemplate contract = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updateContractTemplate(umUserHash, umSessionId, umDomain, id, contract, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updatePostpaidContract method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testUpdatePostpaidContract() throws NotFoundException {
//        System.out.println("updatePostpaidContract");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long customerId = 0L;
//        long id = 0L;
//        io.swagger.model.ContractPostpaid contract = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updatePostpaidContract(umUserHash, umSessionId, umDomain, customerId, id, contract, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updatePostpaidProduct method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testUpdatePostpaidProduct() throws NotFoundException {
//        System.out.println("updatePostpaidProduct");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long id = 0L;
//        io.swagger.model.ProductPostpaid service = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updatePostpaidProduct(umUserHash, umSessionId, umDomain, id, service, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updatePrepaidContract method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testUpdatePrepaidContract() throws NotFoundException {
//        System.out.println("updatePrepaidContract");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long customerId = 0L;
//        long contractId = 0L;
//        io.swagger.model.ContractPrepaid contract = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updatePrepaidContract(umUserHash, umSessionId, umDomain, customerId, contractId, contract, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updatePrepaidService method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testUpdatePrepaidService() throws NotFoundException {
//        System.out.println("updatePrepaidService");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long id = 0L;
//        io.swagger.model.ServicePrepaid contract = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updatePrepaidService(umUserHash, umSessionId, umDomain, id, contract, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of bssProvisionProductsGet method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testBssProvisionProductsGet() throws NotFoundException {
//        System.out.println("bssProvisionProductsGet");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long offset = 0L;
//        long limit = 0L;
//        String productCode = "";
//        long productId = 0L;
//        String productDescription = "";
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.bssProvisionProductsGet(umUserHash, umSessionId, umDomain, offset, limit, productCode, productId, productDescription, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createAProduct method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testCreateAProduct() throws NotFoundException {
//        System.out.println("createAProduct");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.Product product = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createAProduct(umUserHash, umSessionId, umDomain, product, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteProduct method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testDeleteProduct() throws NotFoundException {
//        System.out.println("deleteProduct");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long id = 0L;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deleteProduct(umUserHash, umSessionId, umDomain, id, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateProduc method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testUpdateProduc() throws NotFoundException {
//        System.out.println("updateProduc");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long id = 0L;
//        io.swagger.model.Product product = null;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updateProduc(umUserHash, umSessionId, umDomain, id, product, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of cancelContract method, of class BssContractsApiServiceImpl.
//     */
//    @Test
//    public void testCancelContract() throws NotFoundException {
//        System.out.println("cancelContract");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        long customerId = 0L;
//        long id = 0L;
//        SecurityContext securityContext = null;
//        BssContractsApiServiceImpl instance = new BssContractsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.cancelContract(umUserHash, umSessionId, umDomain, customerId, id, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
