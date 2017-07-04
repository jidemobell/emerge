package io.swagger.api;

import io.swagger.api.factories.BssCustomersApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.model.CustomerAddress;
import io.swagger.model.Contact;
import io.swagger.model.Customer;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/")
@Consumes({"application/json"})
@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the bss API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:29:26.838Z")
public class BssCustomersApi {

    private final BssCustomersApiService delegate = BssCustomersApiServiceFactory.getBssCustomersApi();

    @POST
    @Path("/provision/customers/{customer_id}/customer-addresses")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "create a new customer billing address on the bss", response = void.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New billing address created", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response createBillingAddress(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Customer address id", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "Customer address information", required = true) CustomerAddress customerAddress, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createBillingAddress(umUserHash, umSessionId, umDomain, customerId, customerAddress, securityContext);
    }

    @POST
    @Path("/provision/customers/{customer_id}/customer-addresses/{customer_address_id}/customer-contacts")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "create a new customer contact", response = void.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New contact id created", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response createContact(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Create new customer contact", required = true) Contact createContact, @ApiParam(value = "customers/users billing address id", required = true) @PathParam("customer_address_id") Long customerAddressId, @ApiParam(value = "customers/users id", required = true) @PathParam("customer_id") Long customerId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createContact(umUserHash, umSessionId, umDomain, createContact, customerAddressId, customerId, securityContext);
    }

    @POST
    @Path("/provision/customers")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "create a new customer on the bss", response = void.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New customer created", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response createCustomer(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Customer information", required = true) Customer customer, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createCustomer(umUserHash, umSessionId, umDomain, customer, securityContext);
    }

    @DELETE
    @Path("/provision/customers/{customer_id}/customer-addresses/{customer_address_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "delete a customer on the bss", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Success! customer details deleted", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response deleteBillingAddress(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Customer address id to delete", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "customers/users billing address id", required = true) @PathParam("customer_address_id") Long customerAddressId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteBillingAddress(umUserHash, umSessionId, umDomain, customerId, customerAddressId, securityContext);
    }

    @DELETE
    @Path("/provision/customers/{customer_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "delete a customer on the bss. The operation does not actually remove the customer entry from the database", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "customer deleted", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response deleteCustomer(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Customer id to delete", required = true) @PathParam("customer_id") Long customerId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteCustomer(umUserHash, umSessionId, umDomain, customerId, securityContext);
    }

    @GET
    @Path("/provision/customers/{customer_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "delete a customer on the bss. The operation does not actually remove the customer entry from the database", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "customer information", response = Customer.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response getCustomer(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Customer id to fetch", required = true) @PathParam("customer_id") Long customerId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getCustomer(umUserHash, umSessionId, umDomain, customerId, securityContext);
    }

    @DELETE
    @Path("/provision/customers/{customer_id}/customer-addresses/{customer_address_id}/customer-contacts/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "delete a customer contact", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "customer billing address deleted", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response deleteCustomerContact(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Customer billing address to delete", required = true) @PathParam("customer_address_id") Long customerAddressId, @ApiParam(value = "Customer id to delete", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "users/customers contact id", required = true) @PathParam("id") Long id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteCustomerContact(umUserHash, umSessionId, umDomain, customerAddressId, customerId, id, securityContext);
    }

    @GET
    @Path("/provision/customers/{customer_id}/customer-addresses")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a list of customers billing addressess that match the search criteria. If multiple criteria are specified, the result will be a list of all customers billing addresses that match all the criteria (logical AND)", response = CustomerAddress.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of customers that match the search criteria", response = CustomerAddress.class, responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = CustomerAddress.class, responseContainer = "List")})
    public Response searchBillingAddress(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "id of the customer whose billing address is to be fetched", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") Long offset, @ApiParam(value = "Page limit", defaultValue = "20") @DefaultValue("20") @QueryParam("limit") Long limit, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchBillingAddress(umUserHash, umSessionId, umDomain, customerId, offset, limit, securityContext);
    }

    @GET
    @Path("/provision/customers/{customer_id}/customer-addresses/{customer_address_id}/customer-contacts")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a list of customers billing addressess that match the search criteria. If multiple criteria are specified, the result will be a list of all customers billing addresses that match all the criteria (logical AND)", response = Contact.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of customers that match the search criteria", response = Contact.class, responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Contact.class, responseContainer = "List")})
    public Response searchCustomerContact(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Customer billing address  id", required = true) @PathParam("customer_address_id") Long customerAddressId, @ApiParam(value = "customers/users id", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") Long offset, @ApiParam(value = "Page limit", defaultValue = "20") @DefaultValue("20") @QueryParam("limit") Long limit, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchCustomerContact(umUserHash, umSessionId, umDomain, customerAddressId, customerId, offset, limit, securityContext);
    }

    @GET
    @Path("/provision/customers")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a list of customers that match the search criteria. If multiple criteria are specified, the result will be a list of all customers that match all the criteria (logical AND)", response = Customer.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of customers that match the search criteria", response = Customer.class, responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Customer.class, responseContainer = "List")})
    public Response searchCustomers(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") Long offset, @ApiParam(value = "Page limit", defaultValue = "20") @DefaultValue("20") @QueryParam("limit") Long limit, @ApiParam(value = "Customer name") @QueryParam("name") String name, @ApiParam(value = "Customer ID", defaultValue = "0") @DefaultValue("0") @QueryParam("customer_id") Long customerId, @ApiParam(value = "Customer's status") @QueryParam("status") String status, @ApiParam(value = "fiscal number") @QueryParam("fiscal_number") String fiscalNumber, @ApiParam(value = "tax_exemption_certificate") @QueryParam("tax_exemption_certificate") String taxExemptionCertificate, @ApiParam(value = "customer's telephone number") @QueryParam("telephone_number") String telephoneNumber, @ApiParam(value = "Customer's email") @QueryParam("email") String email, @ApiParam(value = "Customer's username") @QueryParam("username") String username, @ApiParam(value = "Customer tags") @QueryParam("provisioned_equipments") String provisionedEquipments, @ApiParam(value = "Customer tags") @QueryParam("tags") String tags, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchCustomers(umUserHash, umSessionId, umDomain, offset, limit, name, customerId, status, fiscalNumber, taxExemptionCertificate, telephoneNumber, email, username, provisionedEquipments, tags, securityContext);
    }

    @PUT
    @Path("/provision/customers/{customer_id}/customer-addresses/{customer_address_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "edit an existing customer customer address. The contacts are NOT modified. Use appropriate endpoints to edit the contacts.", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Success! Customer address details edited", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response updateBillingAddress(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Customer address id to edit/update", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "Customer address information", required = true) CustomerAddress customer, @ApiParam(value = "customers/users billing address id", required = true) @PathParam("customer_address_id") Long customerAddressId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateBillingAddress(umUserHash, umSessionId, umDomain, customerId, customer, customerAddressId, securityContext);
    }

    @PUT
    @Path("/provision/customers/{customer_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "edit an existing customer on the bss. Will NOT change addresses or contacts. TO edit the address, use appropriate endpoint.", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Existing customer details edited", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response updateCustomer(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Customer id to edit/update", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "Customer information", required = true) Customer customer, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateCustomer(umUserHash, umSessionId, umDomain, customerId, customer, securityContext);
    }

    @PUT
    @Path("/provision/customers/{customer_id}/customer-addresses/{customer_address_id}/customer-contacts/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "edit an existing customer contact", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Existing customer details edited", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response updateCustomerContact(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Customer contact information", required = true) Contact contact, @ApiParam(value = "customers/users billing address id", required = true) @PathParam("customer_address_id") Long customerAddressId, @ApiParam(value = "Customer id", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "users/customers contact id", required = true) @PathParam("id") Long id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateCustomerContact(umUserHash, umSessionId, umDomain, contact, customerAddressId, customerId, id, securityContext);
    }
}
