package io.swagger.api;

import io.swagger.model.CustomerAddress;
import io.swagger.model.Contact;
import io.swagger.model.Customer;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:29:26.838Z")
public abstract class BssCustomersApiService {

    public abstract Response createBillingAddress(String umUserHash, String umSessionId, String umDomain, Long customerId, CustomerAddress customerAddress, SecurityContext securityContext) throws NotFoundException;

    public abstract Response createContact(String umUserHash, String umSessionId, String umDomain, Contact createContact, Long customerAddressId, Long customerId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response createCustomer(String umUserHash, String umSessionId, String umDomain, Customer customer, SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteBillingAddress(String umUserHash, String umSessionId, String umDomain, Long customerId, Long customerAddressId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteCustomer(String umUserHash, String umSessionId, String umDomain, Long customerId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteCustomerContact(String umUserHash, String umSessionId, String umDomain, Long customerAddressId, Long customerId, Long cid, SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchBillingAddress(String umUserHash, String umSessionId, String umDomain, Long customerId, Long offset, Long limit, SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchCustomerContact(String umUserHash, String umSessionId, String umDomain, Long customerAddressId, Long customerId,Long offset, Long limit, SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchCustomers(String umUserHash, String umSessionId, String umDomain, Long offset, Long limit, String name, Long customerId, String status, String fiscalNumber, String taxExemptionCertificate, String telephoneNumber, String email, String username, String provisionedEquipments, String tags, SecurityContext securityContext) throws NotFoundException;

    public abstract Response updateBillingAddress(String umUserHash, String umSessionId, String umDomain, Long customerId, CustomerAddress customer, Long customerAddressId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response updateCustomer(String umUserHash, String umSessionId, String umDomain, Long customerId, Customer customer, SecurityContext securityContext) throws NotFoundException;

    public abstract Response updateCustomerContact(String umUserHash, String umSessionId, String umDomain, Contact contact, Long customerAddressId, Long customerId, Long cid, SecurityContext securityContext) throws NotFoundException;

    public abstract Response getCustomer(String umUserHash, String umSessionId, String umDomain, Long customerId, SecurityContext securityContext) throws NotFoundException;
}
