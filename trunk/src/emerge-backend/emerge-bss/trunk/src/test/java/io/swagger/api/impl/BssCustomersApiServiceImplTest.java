/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.api.impl;

import com.emerge.bss.crud.mappers.CustomerExtended;
import io.swagger.api.NotFoundException;
import io.swagger.model.Customer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kingsley
 */
public class BssCustomersApiServiceImplTest {

    /**
     *
     */
    public BssCustomersApiServiceImplTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        try {
            createCustomer();
        } catch (NotFoundException ex) {
            Logger.getLogger(BssCustomersApiServiceImplTest.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
        try {
            deleteCustomer();
        } catch (NotFoundException ex) {
            Logger.getLogger(BssCustomersApiServiceImplTest.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    @Before
    public void setUp() {

    }

    /**
     *
     */
    @After
    public void tearDown() {

    }

    /**
     *
     */
    private static Customer createdCustomer;

    /**
     *
     *
     * @throws io.swagger.api.NotFoundException 404
     */
    private static void deleteCustomer() throws NotFoundException {
        System.out.println("Tear down Customer");
        String umUserHash = "";
        String umSessionId = "";
        String umDomain = "";
        assertNotNull(createdCustomer);
        Long customerId = createdCustomer.getId();
        SecurityContext securityContext = null;
        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
        Response result = instance.deleteCustomer(umUserHash, umSessionId,
                umDomain, customerId, securityContext);
        System.out.println(result.getStatus() + "/" + Response.Status.OK.getStatusCode());
        assertEquals(result.getStatus(), Response.Status.OK.getStatusCode());
    }

    /**
     *
     *
     * @throws io.swagger.api.NotFoundException 404
     */
    private static void createCustomer() throws NotFoundException {
        System.out.println("Set up Customer");
        String umUserHash = "";
        String umSessionId = "";
        String umDomain = "";
        Customer customer = new Customer();
        customer.setCountry("NG");
        customer.setNotifyByEmail("true");
        customer.setFiscalNumber("1" + 
                String.valueOf(System.currentTimeMillis()).substring(5, 13));

        customer.setNotifyBySms("false");
        customer.setName("Jonnas Smith Test");
        customer.setTags("PMP, CCNP, IEEE");
        customer.setStatus("INACTIVE");
        customer.setPrivateNotes("Diese notizen liese vom nur mich");
        customer.setPublicNotes("Dies Notizen nicht privat");
        customer.setTaxExemptionCertificates("CERT1, CERT2");
        customer.setWebsite("http://emerge-dev.timwe.com");

        SecurityContext securityContext = null;
        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
        assertSame(customer.getId(), 0x0L);
        Response result = instance.createCustomer(umUserHash,
                umSessionId, umDomain, customer, securityContext);

        createdCustomer = (Customer) result.getEntity();
        assertEquals(customer.getCountry(), createdCustomer.getCountry());
        assertSame(customer.getFiscalNumber(),
                createdCustomer.getFiscalNumber());

        assertNotSame(createdCustomer.getId(), 0x0L);
    }

    /**
     *
     * @throws NotFoundException 404
     */
    @Test
    public final void testCreateCustomer() throws NotFoundException {
        System.out.println("createCustomer");
        String umUserHash = "";
        String umSessionId = "";
        String umDomain = "";
        Customer customer = new Customer();
        customer.setCountry("NG");
        customer.setNotifyByEmail("true");
        customer.setFiscalNumber("1" + 
                String.valueOf(System.currentTimeMillis()).substring(5, 13));

        customer.setNotifyBySms("false");
        customer.setName("Jonnas Smith Test");
        customer.setTags("PMP, CCNP, IEEE");
        customer.setStatus("INACTIVE");
        customer.setPrivateNotes("Diese notizen liese vom nur mich");
        customer.setPublicNotes("Dies Notizen nicht privat");
        customer.setTaxExemptionCertificates("CERT1, CERT2");
        customer.setWebsite("http://emerge-dev.timwe.com");

        SecurityContext securityContext = null;
        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
        assertSame(customer.getId(), 0x0L);
        Response result = instance.createCustomer(umUserHash,
                umSessionId, umDomain, customer, securityContext);

        assertEquals(result.getStatus(), Response.Status.OK.getStatusCode());
        Customer newCustomer = (Customer) result.getEntity();
        assertEquals(customer.getCountry(), newCustomer.getCountry());
        assertSame(customer.getFiscalNumber(), newCustomer.getFiscalNumber());

        assertNotSame(newCustomer.getId(), 0);
        System.out.println("deleteCustomer");
        Response deleteResult = instance.deleteCustomer(umUserHash, umSessionId,
                umDomain, newCustomer.getId(), securityContext);

        assertEquals(deleteResult.getStatus(),
                Response.Status.OK.getStatusCode());
    }

    /**
     * Test of getCustomer method, of class BssCustomersApiServiceImpl.
     *
     * @throws io.swagger.api.NotFoundException 404
     */
    @Test
    public final void testGetCustomer() throws NotFoundException {
        System.out.println("getCustomer");
        String umUserHash = "";
        String umSessionId = "";
        String umDomain = "";
        Long customerId = createdCustomer.getId();
        SecurityContext securityContext = null;
        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
        CustomerExtended result = (CustomerExtended) instance
                .getCustomer(umUserHash, umSessionId, umDomain,
                        customerId, securityContext).getEntity();

        assertEquals(result.getId(), createdCustomer.getId());
        assertEquals(result.getName(), createdCustomer.getName());
        assertEquals(result.getFiscalNumber(),
                createdCustomer.getFiscalNumber());
    }

//
//    /**
//     * Test of createBillingAddress method, of class BssCustomersApiServiceImpl.
//     */
//    @Test
//    public void testCreateBillingAddress() throws NotFoundException {
//        System.out.println("createBillingAddress");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long customerId = null;
//        io.swagger.model.CustomerAddress customerAddress = null;
//        SecurityContext securityContext = null;
//        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createBillingAddress(umUserHash, umSessionId, umDomain, customerId, customerAddress, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createContact method, of class BssCustomersApiServiceImpl.
//     */
//    @Test
//    public void testCreateContact() throws NotFoundException {
//        System.out.println("createContact");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.Contact createContact = null;
//        Long customerAddressId = null;
//        Long customerId = null;
//        SecurityContext securityContext = null;
//        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.createContact(umUserHash, umSessionId, umDomain, createContact, customerAddressId, customerId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteBillingAddress method, of class BssCustomersApiServiceImpl.
//     */
//    @Test
//    public void testDeleteBillingAddress() throws NotFoundException {
//        System.out.println("deleteBillingAddress");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long customerId = null;
//        Long customerAddressId = null;
//        SecurityContext securityContext = null;
//        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deleteBillingAddress(umUserHash, umSessionId, umDomain, customerId, customerAddressId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteCustomerContact method, of class BssCustomersApiServiceImpl.
//     */
//    @Test
//    public void testDeleteCustomerContact() throws NotFoundException {
//        System.out.println("deleteCustomerContact");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long customerAddressId = null;
//        Long customerId = null;
//        Long id = null;
//        SecurityContext securityContext = null;
//        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.deleteCustomerContact(umUserHash, umSessionId, umDomain, customerAddressId, customerId, id, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchBillingAddress method, of class BssCustomersApiServiceImpl.
//     */
//    @Test
//    public void testSearchBillingAddress() throws NotFoundException {
//        System.out.println("searchBillingAddress");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long customerId = null;
//        Long offset = null;
//        Long limit = null;
//        SecurityContext securityContext = null;
//        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.searchBillingAddress(umUserHash, umSessionId, umDomain, customerId, offset, limit, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchCustomerContact method, of class BssCustomersApiServiceImpl.
//     */
//    @Test
//    public void testSearchCustomerContact() throws NotFoundException {
//        System.out.println("searchCustomerContact");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long customerAddressId = null;
//        Long customerId = null;
//        Long offset = null;
//        Long limit = null;
//        SecurityContext securityContext = null;
//        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.searchCustomerContact(umUserHash, umSessionId, umDomain, customerAddressId, customerId, offset, limit, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of searchCustomers method, of class BssCustomersApiServiceImpl.
//     */
//    @Test
//    public void testSearchCustomers() throws NotFoundException {
//        System.out.println("searchCustomers");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long offset = null;
//        Long limit = null;
//        String name = "";
//        Long customerId = null;
//        String status = "";
//        String fiscalNumber = "";
//        String taxExemptionCertificate = "";
//        String telephoneNumber = "";
//        String email = "";
//        String username = "";
//        String provisionedEquipments = "";
//        String tags = "";
//        SecurityContext securityContext = null;
//        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.searchCustomers(umUserHash, umSessionId, umDomain, offset, limit, name, customerId, status, fiscalNumber, taxExemptionCertificate, telephoneNumber, email, username, provisionedEquipments, tags, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateBillingAddress method, of class BssCustomersApiServiceImpl.
//     */
//    @Test
//    public void testUpdateBillingAddress() throws NotFoundException {
//        System.out.println("updateBillingAddress");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        Long customerId = null;
//        io.swagger.model.CustomerAddress customerAddress = null;
//        Long customerAddressId = null;
//        SecurityContext securityContext = null;
//        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updateBillingAddress(umUserHash, umSessionId, umDomain, customerId, customerAddress, customerAddressId, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//
//    /**
//     * Test of updateCustomerContact method, of class BssCustomersApiServiceImpl.
//     */
//    @Test
//    public void testUpdateCustomerContact() throws NotFoundException {
//        System.out.println("updateCustomerContact");
//        String umUserHash = "";
//        String umSessionId = "";
//        String umDomain = "";
//        io.swagger.model.Contact contact = null;
//        Long customerAddressId = null;
//        Long customerId = null;
//        Long id = null;
//        SecurityContext securityContext = null;
//        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.updateCustomerContact(umUserHash, umSessionId, umDomain, contact, customerAddressId, customerId, id, securityContext);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of updateCustomer method, of class BssCustomersApiServiceImpl.
     *
     * @throws io.swagger.api.NotFoundException 404
     */
    @Test
    public final void testUpdateCustomer() throws NotFoundException {
        System.out.println("updateCustomer");
        String umUserHash = "";
        String umSessionId = "";
        String umDomain = "";

        Customer customer = createdCustomer;
        Long customerId = customer.getId();
        String name = customer.getName();
        customer.setName("Arnold Smith Test");
        customer.setTags("PHD");
        SecurityContext securityContext = null;
        BssCustomersApiServiceImpl instance = new BssCustomersApiServiceImpl();
        Response result = instance.updateCustomer(umUserHash,
                umSessionId, umDomain, customerId, customer,
                securityContext);

        assertEquals(result.getStatus(), Response.Status.OK.getStatusCode());
        Customer updatedCustomer = (Customer) result.getEntity();
        assertEquals(updatedCustomer.getName(), customer.getName());
        assertEquals(updatedCustomer.getTags(), customer.getTags());
        assertNotEquals(name, updatedCustomer.getName());
    }
}
