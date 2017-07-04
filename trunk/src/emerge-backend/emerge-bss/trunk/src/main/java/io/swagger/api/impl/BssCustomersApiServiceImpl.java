package io.swagger.api.impl;

import com.emerge.bss.auth.AccessControl;
import com.emerge.bss.crud.CustomerDAO;
import com.emerge.bss.crud.mappers.CustomerExtended;
import com.emerge.bss.crud.mappers.CustomerMapper;
import com.emerge.bss.database.history.HDBResource;
import com.emerge.bss.util.JdbiHelper;
import io.swagger.api.ApiResponseMessage;
import io.swagger.api.BssCustomersApiService;
import io.swagger.model.CustomerAddress;
import io.swagger.model.Contact;
import io.swagger.model.Customer;

import io.swagger.api.NotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.json.simple.JSONObject;
import org.skife.jdbi.v2.sqlobject.Transaction;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-21T13:43:31.183Z")
public class BssCustomersApiServiceImpl extends BssCustomersApiService {

    /**
     *
     * @param umUserHash umUserHash
     * @param umSessionId umSessionId
     * @param umDomain umDomain
     * @param customer customer
     * @param securityContext securityContext
     * @return Customer instance
     * @throws NotFoundException 404
     */
    @Override
    @Transaction
    public final Response createCustomer(final String umUserHash,
            final String umSessionId, final String umDomain,
            final Customer customer, final SecurityContext securityContext)
            throws NotFoundException {

        try {
            AccessControl.authenticate(umUserHash, umSessionId,
                    umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
        if (customer == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        if (customer.getName() == null || customer.getCountry() == null
                || customer.getFiscalNumber() == null) {

            JSONObject ob = new JSONObject();
            ob.put("message", "Missing attribute");
            ob.put("data", customer);
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(ob).build();
        }

        if (!validateFiscalNumber(customer.getFiscalNumber())) {
            JSONObject ob = new JSONObject();
            ob.put("message", "Invalid FiscalNumber");
            ob.put("data", customer);
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(ob).build();
        }

        CustomerDAO cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);
        try {
            cDAO.begin();
            long customerId = cDAO.createCustomer(customer.getName(),
                    customer.getFiscalNumber(),
                    customer.getTaxExemptionCertificates(),
                    customer.getCountry(), customer.getWebsite(),
                    customer.getPrivateNotes(), customer.getPublicNotes(),
                    "INACTIVE", customer.getTags());

            customer.setId(customerId);
            for (CustomerAddress customerAddress
                    : customer.getCustomerAddresses()) {
                if (customerAddress.getAddressName() == null || customerAddress.getAddressName().isEmpty() || customerAddress.getAddress() == null || customerAddress.getAddress().isEmpty() || customerAddress.getEmail() == null || customerAddress.getEmail().isEmpty() || customerAddress.getTelephoneNumber()== null || customerAddress.getTelephoneNumber().isEmpty()) {
            JSONObject ob = new JSONObject();
            ob.put("message", "Missing required attribute");
            ob.put("data", customerAddress);
            return Response.status(Response.Status.BAD_REQUEST).entity(ob).build();
        }
                
                long billingAddressId = cDAO.createBillingAddress(
                        customerAddress.getAddressName(),
                        customerAddress.getAddress(),
                        customerAddress.getFaxNumber(),
                        customerAddress.getTelephoneNumber(), customerId,
                        customerAddress.getEmail());
                

                for (Contact contact : customerAddress.getContacts()) {
                    if (contact.getContactName() == null || contact.getContactName().isEmpty() || contact.getContactType() == null || contact.getContactType().isEmpty() || contact.getContactEmail() == null || contact.getContactEmail().isEmpty() || contact.getContactPhone() == null || contact.getContactPhone().isEmpty()) {
            JSONObject ob = new JSONObject();
            ob.put("message", "Missing required attribute");
            ob.put("data", contact);
            return Response.status(Response.Status.BAD_REQUEST).entity(ob).build();
        }
                        cDAO.createCustomerContact(contact.getContactType(),
                            contact.getContactName(),
                            contact.getContactEmail(),
                            contact.getContactPhone(), contact.getContactFax(),
                            billingAddressId, true, true, true);
                }
            }

            cDAO.commit();
            HDBResource.put(customer, "customers", "create");
            return Response.ok().entity(customer).build();
        } catch (SQLIntegrityConstraintViolationException ex) {
            cDAO.rollback();
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.CONFLICT).entity(
                    new ApiResponseMessage(ApiResponseMessage.ERROR,
                            ex.getMessage())).build();
        } catch (Exception ex) {
            cDAO.rollback();
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.serverError().entity(
                    new ApiResponseMessage(ApiResponseMessage.ERROR,
                            ex.getMessage())).build();
        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
    }

    @Override
    public Response createBillingAddress(String umUserHash, String umSessionId, String umDomain, Long customerId, CustomerAddress customerAddress, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
        if (customerAddress.getAddressName() == null || customerAddress.getAddressName().isEmpty() || customerAddress.getAddress() == null || customerAddress.getAddress().isEmpty() || customerAddress.getEmail() == null || customerAddress.getEmail().isEmpty() || customerAddress.getTelephoneNumber()== null || customerAddress.getTelephoneNumber().isEmpty()) {
            JSONObject ob = new JSONObject();
            ob.put("message", "Missing required attribute");
            ob.put("data", customerAddress);
            return Response.status(Response.Status.BAD_REQUEST).entity(ob).build();
        }
        CustomerDAO cDAO = null;
        try {
            cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);
            long id = cDAO.createBillingAddress(customerAddress.getAddressName(), customerAddress.getAddress(), customerAddress.getFaxNumber(), customerAddress.getTelephoneNumber(), customerId, customerAddress.getEmail());
            customerAddress.setId(id);

            HDBResource.put(customerAddress, "customer_addresses", "create");

        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Error adding address!")).build();
        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
        return Response.ok().entity(customerAddress).build();
        //return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully created!")).build();

    }

    @Override
    public Response createContact(String umUserHash, String umSessionId, String umDomain, Contact createContact, Long customerAddressId, Long customerId, SecurityContext securityContext) throws NotFoundException {
        try {

            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
        if (createContact == null) {
            JSONObject ob = new JSONObject();
            ob.put("message", "Contact is empty");
            ob.put("data", createContact);
            return Response.status(Response.Status.BAD_REQUEST).entity(ob).build();
        }

        if (createContact.getContactName() == null || createContact.getContactName().isEmpty() || createContact.getContactType() == null || createContact.getContactType().isEmpty() || createContact.getContactEmail() == null || createContact.getContactEmail().isEmpty() || createContact.getContactPhone() == null || createContact.getContactPhone().isEmpty()) {
            JSONObject ob = new JSONObject();
            ob.put("message", "Missing required attribute");
            ob.put("data", createContact);
            return Response.status(Response.Status.BAD_REQUEST).entity(ob).build();
        }
        CustomerDAO cDAO = null;
        try {
            cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);

            long contactId = cDAO.createCustomerContact(createContact.getContactType(), createContact.getContactName(), createContact.getContactEmail(), createContact.getContactPhone(), createContact.getContactFax(), createContact.getBillingAddressId(), createContact.getNotifyByEmail(), createContact.getNotifyBySms(), createContact.getSendInvoiceByEmail());
            createContact.setId(contactId);

            HDBResource.put(createContact, "customer_addresses", "create");

        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
        return Response.ok().entity(createContact).build();
    }

    @Override
    public Response deleteBillingAddress(String umUserHash, String umSessionId, String umDomain, Long customerId, Long customerAddressId, SecurityContext securityContext) throws NotFoundException {
        try {
            //Add missing params in the swagger delete customer API
            AccessControl.authenticate(null, null, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
        CustomerDAO cDAO = null;
        try {
            cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);
            List<Map> customersAddresses = cDAO.findBillingAddress(umDomain, umDomain, customerId, customerAddressId, null, null, 0, 1);

            if (customerAddressId == 0 || customersAddresses.size() < 1) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            CustomerAddress cAddress = (CustomerAddress) customersAddresses.get(0);
            //Now delete record in bss
            cDAO.deleteBillingAdress(customerAddressId);

            HDBResource.put(cAddress, "customer_addresses", "delete");

            return Response.status(Response.Status.OK).entity(new ApiResponseMessage(ApiResponseMessage.INFO, "Successfully deleted")).build();

        } catch (RuntimeException ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
    }

    @Override
    public Response deleteCustomer(String umUserHash, String umSessionId, String umDomain, Long customerId, SecurityContext securityContext) throws NotFoundException {
        try {
            //Add missing params in the swagger delete customer API
            AccessControl.authenticate(null, null, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
        CustomerDAO cDAO = null;
        try {
            cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);
            List<Map> customers = cDAO.getCustomers(null, null, null, customerId, null, null, null, null, 0, 1);//.findInvoices(String.valueOf(customerid), String.valueOf(invoicenumber), d, d, offset, limit);

            if (customers.size() < 1) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            //Now delete the customer
            cDAO.deleteCustomer(customerId);

            CustomerExtended customer = (CustomerExtended) customers.get(0);

            HDBResource.put(customer, "customers", "delete");

            return Response.status(Response.Status.OK).entity(new ApiResponseMessage(ApiResponseMessage.INFO, "Successfully deleted")).build();

        } catch (RuntimeException ex) {

            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();

        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
    }

    @Override
    public Response deleteCustomerContact(String umUserHash, String umSessionId, String umDomain, Long customerAddressId, Long customerId, Long id, SecurityContext securityContext) throws NotFoundException {
        try {
            //Add missing params in the swagger delete customer API
            AccessControl.authenticate(null, null, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
        CustomerDAO cDAO = null;
        try {
            cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);
            List<Map> customersContacts = cDAO.findAllCustomerContact(customerAddressId);

//            if (customersContacts.size() < 1) {
//                return Response.status(Response.Status.NOT_FOUND).build();
//            }
            //Now delete record in bss
            cDAO.deleteCustomrContact(id);

            HDBResource.put(customersContacts, "customer_contacts", "delete");

            return Response.status(Response.Status.OK).entity(new ApiResponseMessage(ApiResponseMessage.INFO, "Successfully deleted")).build();

        } catch (RuntimeException ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
    }

    @Override
    public Response searchBillingAddress(String umUserHash, String umSessionId, String umDomain, Long customerId, Long offset, Long limit, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
        CustomerDAO cDAO = null;
        try {
            cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);

            if (limit == null) {
                limit = 20L;
            }
            if (offset == null) {
                offset = 0L;
            }

            List<Map> customersAddresses = cDAO.findBillingAddress(umDomain, umDomain, customerId, 0, null, null, offset, limit);
            long total = cDAO.findBillingAddressCount(umDomain, umDomain, customerId, null, null);
            JSONObject o = new JSONObject();
            o.put("total", total);
            o.put("data", customersAddresses);
            return Response.ok().entity(o).build();
        } catch (Exception ex) {

            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
    }

    @Override
    public Response searchCustomerContact(String umUserHash, String umSessionId, String umDomain, Long customerAddressId, Long customerId, Long offset, Long limit, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
        CustomerDAO cDAO = null;
        try {
            cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);
            List<Map> contacts = cDAO.findAllCustomerContact(customerAddressId);
            cDAO.getContactCount(customerAddressId);
            return Response.ok().entity(contacts).build();
        } catch (Exception ex) {

            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
    }

    @Override
    public Response searchCustomers(String umUserHash, String umSessionId, String umDomain, Long offset, Long limit, String name, Long customerId, String status, String fiscalNumber, String taxExemptionCertificate, String telephoneNumber, String email, String username, String provisionedEquipments, String tags, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        CustomerDAO cDAO = null;
        try {
            cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);
            if (limit == null) {
                limit = 20L;
            }
            if (offset == null) {
                offset = 0L;
            }
            List<Map> customers;
            long total;

            if (provisionedEquipments != null && !provisionedEquipments.isEmpty()) {
                customers = cDAO.getCustomersByEquipment(name, fiscalNumber, status, customerId, tags, provisionedEquipments, taxExemptionCertificate, null, null, offset, limit);//.findInvoices(String.valueOf(customerid), String.valueOf(invoicenumber), d, d, offset, limit);
                total = cDAO.getCustomersByEquipmentCount(name, fiscalNumber, status, customerId, tags, provisionedEquipments, taxExemptionCertificate, null, null);//.findInvoices(String.valueOf(customerid), String.valueOf(invoicenumber), d, d);
            } else {
                customers = cDAO.getCustomers(name, fiscalNumber, status, customerId, tags, taxExemptionCertificate, null, null, offset, limit);//.findInvoices(String.valueOf(customerid), String.valueOf(invoicenumber), d, d, offset, limit);
                total = cDAO.getCustomersCount(name, fiscalNumber, status, customerId, tags, taxExemptionCertificate, null, null);//.findInvoices(String.valueOf(customerid), String.valueOf(invoicenumber), d, d);
            }

            JSONObject o = new JSONObject();
            for (Object ob : customers) {
                CustomerExtended c = (CustomerExtended) ob;
                c.setContractPrepaids(cDAO.findPrepaidContractsByCustomerId(c.getId()));
            }
            o.put("total", total);
            o.put("data", customers);
            return Response.ok().entity(o).build();
        } catch (Exception ex) {

            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
    }

    @Override
    public Response updateBillingAddress(String umUserHash, String umSessionId, String umDomain, Long customerId, CustomerAddress customerAddress, Long customerAddressId, SecurityContext securityContext) throws NotFoundException {
        try {
            //Edit swagger to pass missing authenticate parameters
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
        if (customerAddress.getAddressName() == null || customerAddress.getAddressName().isEmpty() || customerAddress.getAddress() == null || customerAddress.getAddress().isEmpty() || customerAddress.getEmail() == null || customerAddress.getEmail().isEmpty() || customerAddress.getTelephoneNumber()== null || customerAddress.getTelephoneNumber().isEmpty()) {
            JSONObject ob = new JSONObject();
            ob.put("message", "Missing required attribute");
            ob.put("data", customerAddress);
            return Response.status(Response.Status.BAD_REQUEST).entity(ob).build();
        }
        CustomerDAO cDAO = null;
        try {
            cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);
            int updateResult = cDAO.updateBillingAddress(customerAddress.getAddressName(), customerAddress.getAddress(), customerAddress.getFaxNumber(), customerAddress.getTelephoneNumber(), customerAddress.getEmail(), customerAddressId);
            if (updateResult < 1) {
                return Response.status(Response.Status.OK).entity(new ApiResponseMessage(ApiResponseMessage.INFO, "No row was updated!")).build();
            }

            HDBResource.put(customerAddress, "customer_addresses", "update");

            return Response.status(Response.Status.OK).entity(customerAddress).build();

        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
    }

    @Override
    public Response updateCustomer(String umUserHash, String umSessionId, String umDomain, Long customerId, Customer customer, SecurityContext securityContext) throws NotFoundException {
        try {
            //Edit swagger to pass missing authenticate parameters
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }

        if (customer == null) {
            return Response.serverError().status(Response.Status.BAD_REQUEST).build();
        }

        if (customer.getName() == null || customer.getCountry() == null || customer.getFiscalNumber() == null) {
            JSONObject ob = new JSONObject();
            ob.put("message", "Missing attribute");
            ob.put("data", customer);
            return Response.status(Response.Status.BAD_REQUEST).entity(ob).build();
        }
        if (!validateFiscalNumber(customer.getFiscalNumber())) {
            JSONObject ob = new JSONObject();
            ob.put("message", "Invalid FiscalNumber");
            ob.put("data", customer);
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(ob).build();
        }

        CustomerDAO cDAO = null;
        try {
            cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);
            long customersUpdateResult = cDAO.updateCustomer(customer.getName(), customer.getFiscalNumber(), customer.getTaxExemptionCertificates(), customer.getCountry(), customer.getWebsite(), customer.getPrivateNotes(), customer.getPublicNotes(), customer.getTags(), customer.getStatus(), customerId);

            if (customersUpdateResult < 1) {
                return Response.status(Response.Status.BAD_REQUEST).entity(new ApiResponseMessage(ApiResponseMessage.INFO, "No row was updated!")).build();
            }

            HDBResource.put(customer, "customers", "update");
            return Response.status(Response.Status.OK).entity(customer).build();
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
    }

    @Override
    public Response updateCustomerContact(String umUserHash, String umSessionId, String umDomain, Contact contact, Long customerAddressId, Long customerId, Long id, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
        if (contact == null) {
            JSONObject ob = new JSONObject();
            ob.put("message", "Contact is empty");
            return Response.status(Response.Status.BAD_REQUEST).entity(ob).build();
        }
        if (contact.getContactName() == null || contact.getContactName().isEmpty() || contact.getContactType() == null || contact.getContactType().isEmpty() || contact.getContactEmail() == null && contact.getContactEmail().isEmpty() || contact.getContactPhone() == null || contact.getContactPhone().isEmpty()) {
            JSONObject ob = new JSONObject();
            ob.put("message", "Missing attribute");
            ob.put("data", contact);
            return Response.status(Response.Status.BAD_REQUEST).entity(ob).build();
        }
        CustomerDAO cDAO = null;
        try {
            cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);

            long updateCustomerResult = cDAO.updateCustomerContact(contact.getContactType(), contact.getContactName(), contact.getContactEmail(), contact.getContactPhone(), contact.getContactFax(), contact.getNotifyByEmail(), contact.getNotifyBySms(), contact.getSendInvoiceByEmail(), customerAddressId, id);

            if (updateCustomerResult < 1) {
                return Response.status(Response.Status.OK).entity(new ApiResponseMessage(ApiResponseMessage.INFO, "No row was updated!")).build();
            }

            HDBResource.put(contact, "customer_contacts", "update");
            return Response.status(Response.Status.OK).entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully updated!")).build();
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
    }

    @Override
    public Response getCustomer(String umUserHash, String umSessionId,
            String umDomain, Long customerId, SecurityContext securityContext)
            throws NotFoundException {

        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain,
                    securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        CustomerDAO cDAO = null;
        try {
            cDAO = JdbiHelper.getDBI().open(CustomerDAO.class);

            List<Map> customers = cDAO.getCustomer(customerId);
            if (customers.size() < 1) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponseMessage(
                                ApiResponseMessage.ERROR, "NOT FOUND")
                        ).build();
            }

            return Response.ok().entity(customers.get(0)).build();
        } catch (Exception ex) {
            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (cDAO != null) {
                cDAO.close();
            }
        }
    }

    private static boolean validateFiscalNumber(String fiscalNumber) {
        Character validChars[] = {'1', '2', '3', '4', '7'};
        if (!(fiscalNumber.matches("[0-9]+") && fiscalNumber.length() == 9)) {
            return false;
        }
        Character c = fiscalNumber.charAt(0);
        return Arrays.asList(validChars).contains(c);
    }
}
