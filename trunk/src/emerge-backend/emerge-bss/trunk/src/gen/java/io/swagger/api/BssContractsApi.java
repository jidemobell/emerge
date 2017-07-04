package io.swagger.api;

import io.swagger.api.factories.BssContractsApiServiceFactory;

import io.swagger.annotations.ApiParam;

import io.swagger.model.ContractTemplate;
import io.swagger.model.ContractPostpaid;
import io.swagger.model.ContractPrepaid;
import io.swagger.model.Product;
import io.swagger.model.ServicePrepaid;
import io.swagger.model.ProductPostpaid;

import java.util.Date;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/")
@Consumes({"application/json"})
@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the bss API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T12:02:51.809Z")
public class BssContractsApi {

    private final BssContractsApiService delegate = BssContractsApiServiceFactory.getBssApi();

    @GET
    @Path("/provision/contract-templates")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `contract template` objects. Optional pagination parameters - offset, and limit to determine the number of records to fetch ", response = ContractTemplate.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of contract that match the search criteria", response = ContractTemplate.class, responseContainer = "List")
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = ContractTemplate.class, responseContainer = "List")})
    public Response bssProvisionContractsTemplatesGet(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Page limit", required = true, defaultValue = "20") @DefaultValue("20") @QueryParam("limit") long limit,
            @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") long offset,
            @ApiParam(value = "Name of the contract template") @QueryParam("template_id") long templateId,
            @ApiParam(value = "Description of the contract template") @QueryParam("template_description") String templateDescription,
            @ApiParam(value = "Backoffice username who created the template") @QueryParam("created_by") String createdBy,
            @ApiParam(value = "Content of the created template") @QueryParam("content") String content,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.bssProvisionContractsTemplatesGet(umUserHash, umSessionId, umDomain, limit, offset, templateId, templateDescription, createdBy, content, securityContext);
    }

    @GET
    @Path("/provision/customers/{customer_id}/postpaid-contracts/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets contracts for a specific customer Optional pagination parameters - offset, limits determine the size of the fetch bucket ", response = ContractPostpaid.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of contract that match the search criteria", response = ContractPostpaid.class, responseContainer = "List")
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = ContractPostpaid.class, responseContainer = "List")})
    public Response bssProvisionCustomersCustomerIdContractsPostpaidGet(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Id of customer whose contract to fetch", required = true) @PathParam("customer_id") long customerId,
            @ApiParam(value = "Id of contract to fetch", required = true) @PathParam("id") long id,
            @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") long offset,
            @ApiParam(value = "Page limit", defaultValue = "20") @DefaultValue("20") @QueryParam("limit") long limit,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.bssProvisionCustomersCustomerIdContractsPostpaidGet(umUserHash, umSessionId, umDomain, customerId, id, offset, limit, securityContext);
    }

    @GET
    @Path("/provision/customers/{customer_id}/prepaid-contracts/{contract_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets contracts for a specific customer Optional pagination parameters - offset, limits determine the size of the fetch bucket ", response = ContractPrepaid.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of contract that match the search criteria", response = ContractPrepaid.class, responseContainer = "List")
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = ContractPrepaid.class, responseContainer = "List")})
    public Response bssProvisionCustomersCustomerIdContractsPrepaidContractIdGet(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Id of customer to fetch", required = true) @PathParam("customer_id") long customerId,
            @ApiParam(value = "Id of contract to fetch", required = true) @PathParam("contract_id") long contractId,
            @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") long offset,
            @ApiParam(value = "Page limit", defaultValue = "20") @DefaultValue("20") @QueryParam("limit") long limit,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.bssProvisionCustomersCustomerIdContractsPrepaidContractIdGet(umUserHash, umSessionId, umDomain, customerId, contractId, offset, limit, securityContext);
    }

    @GET
    @Path("/provision/customers/{customer_id}/prepaid-contracts")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets contracts for a specific customer Optional pagination parameters - offset, limits determine the size of the fetch bucket ", response = ContractPrepaid.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of contract that match the search criteria", response = ContractPrepaid.class, responseContainer = "List")
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = ContractPrepaid.class, responseContainer = "List")})
    public Response bssProvisionCustomersCustomerIdContractsPrepaidGet(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Id of customer whose contract to fetch", required = true) @PathParam("customer_id") long customerId,
            @ApiParam(value = "contract type") @QueryParam("contract_type") String contractType,
            @ApiParam(value = "contract status") @QueryParam("status") String status,
            @ApiParam(value = "contract creation_date") @QueryParam("creation_date") Date creationDate,
            @ApiParam(value = "contract service_type") @QueryParam("service_type") String serviceType,
            @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") long offset,
            @ApiParam(value = "Page limit", defaultValue = "20") @DefaultValue("20") @QueryParam("limit") long limit,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.bssProvisionCustomersCustomerIdContractsPrepaidGet(umUserHash, umSessionId, umDomain, customerId, contractType, status, creationDate, serviceType, offset, limit, securityContext);
    }

    @GET
    @Path("/provision/products")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets the products available Optional pagination parameters - offset, limits determine the size of the fetch bucket ", response = Product.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of products that match the search criteria", response = Product.class, responseContainer = "List")
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = Product.class, responseContainer = "List")})
    public Response bssProvisionProductsGet(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") long offset,
            @ApiParam(value = "Page limit", defaultValue = "20") @DefaultValue("20") @QueryParam("limit") long limit,
            @ApiParam(value = "") @QueryParam("product_code") String productCode,
            @ApiParam(value = "", defaultValue = "0") @DefaultValue("0") @QueryParam("product_id") long productId,
            @ApiParam(value = "") @QueryParam("product_description") String productDescription,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.bssProvisionProductsGet(umUserHash, umSessionId, umDomain, offset, limit, productCode, productId, productDescription, securityContext);
    }

    @GET
    @Path("/provision/prepaid-services")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets `Prepaid Service` objects. Optional pagination parameters - offset, and limit to determine the number of records to fetch ", response = ServicePrepaid.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of contract that match the search criteria", response = ServicePrepaid.class, responseContainer = "List")
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = ServicePrepaid.class, responseContainer = "List")})
    public Response bssProvisionServicesPrepaidGet(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Page limit", required = true, defaultValue = "20") @DefaultValue("20") @QueryParam("limit") long limit,
            @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") long offset,
            @ApiParam(value = "Prepaid service type") @QueryParam("type") String type,
            @ApiParam(value = "Prepaid service status") @QueryParam("status") String status,
            @ApiParam(value = "Prepaid service external_provision_id") @QueryParam("external_provision_id") String external_provision_id,
            @ApiParam(value = "Prepaid service creation_date") @QueryParam("creation_date") Date creation_date,
            @ApiParam(value = "Prepaid service modification_date") @QueryParam("modification_date") Date modification_date,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.bssProvisionServicesPrepaidGet(umUserHash, umSessionId, umDomain, limit, offset, type, status, external_provision_id, creation_date, modification_date, securityContext);
    }

    @PUT
    @Path("/provision/customers/{customer_id}/prepaid-contracts/{id}/confirm")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Confirm a contract, changes a contract from the new state -> pending", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "New contract details confirmed", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response confirmContract(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "customerId of contract to confirm", required = true) @PathParam("customer_id") long customerId,
            @ApiParam(value = "Id of contract to confirm", required = true) @PathParam("id") long id,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.confirmContract(umUserHash, umSessionId, umDomain, customerId, id, securityContext);
    }

    @PUT
    @Path("/provision/prepaid-services/{id}/delete")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Delete a prepaidservice -> pending", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Prepaid Service deleted", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response deletePrepaidService(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "prepaidservice", required = true) ServicePrepaid prepaidService,
            @ApiParam(value = "Postpaid Service id to delete", required = true) @PathParam("id") long id,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deletePrepaidService(umUserHash, umSessionId, umDomain, id, prepaidService, securityContext);
    }

//        @PUT
//    @Path("/provision/prepaid-services/{id}")
//    @Consumes({ "application/json" })
//    @Produces({ "application/json" })
//    @io.swagger.annotations.ApiOperation(value = "", notes = "Delete a prepaidservice", response = void.class, tags={ "Operations", })
//    @io.swagger.annotations.ApiResponses(value = { 
//        @io.swagger.annotations.ApiResponse(code = 204, message = "Prepaid Service deleted", response = void.class),
//        
//        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class) })
//    public Response deletePrepaidService(@ApiParam(value = "Userhash, as returned by the User Management system" ,required=true)@HeaderParam("um_user_hash") String umUserHash
//,@ApiParam(value = "SessionID on the User Management system" ,required=true)@HeaderParam("um_session_id") String umSessionId
//,@ApiParam(value = "Domain of the user" ,required=true)@HeaderParam("um_domain") String umDomain
//,@ApiParam(value = "prepaidservice" ,required=true) ServicePrepaid prepaidService
//,@ApiParam(value = "Postpaid Service id to delete",required=true) @PathParam("id") long id
//,@Context SecurityContext securityContext)
//    throws NotFoundException {
//        return delegate.deletePrepaidService(umUserHash,umSessionId,umDomain,id,prepaidService,securityContext);
//    }
//    
//    
    @PUT
    @Path("/provision/customers/{customer_id}/prepaid-contracts/{id}/services/{service_id}/cancel")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Cancel a contract, changes a contract from the Active state -> Closed", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Contract details canceled", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response cancelContract(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "customerId of contract to cancel", required = true) @PathParam("customer_id") long customerId,
            @ApiParam(value = "service id to delete", required = true) @PathParam("service_id") long serviceId,
            @ApiParam(value = "Id of contract to cancel", required = true) @PathParam("id") long id,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.cancelContract(umUserHash, umSessionId, umDomain, customerId, serviceId, id, securityContext);
    }

    @POST
    @Path("/provision/products")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "create a new product", response = String.class, tags = {"Provisioning",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New product created", response = String.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class)})
    public Response createAProduct(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "product information", required = true) Product product,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createAProduct(umUserHash, umSessionId, umDomain, product, securityContext);
    }

    @POST
    @Path("/provision/customers/{customer_id}/prepaid-contracts")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "create a new contract for a customer", response = String.class, tags = {"Provisioning",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New contract created", response = String.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class)})
    public Response createContractPrepaid(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "customer id", required = true) @PathParam("customer_id") long customerId,
            @ApiParam(value = "contract information", required = true) ContractPrepaid contract,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createContractPrepaid(umUserHash, umSessionId, umDomain, customerId, contract, securityContext);
    }

    @POST
    @Path("/provision/contract-templates/")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "create a new contract template", response = String.class, tags = {"Provisioning",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New contract template created", response = String.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class)})
    public Response createContractTemplate(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "contract template information", required = true) ContractTemplate contract,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createContractTemplate(umUserHash, umSessionId, umDomain, contract, securityContext);
    }

    @POST
    @Path("/provision/customers/{customer_id}/postpaid-contracts")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "create a new contract for a customer", response = String.class, tags = {"Provisioning",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New contract created", response = String.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class)})
    public Response createPostpaidContract(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "customer id", required = true) @PathParam("customer_id") long customerId,
            @ApiParam(value = "contract information", required = true) ContractPostpaid contract,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createPostpaidContract(umUserHash, umSessionId, umDomain, customerId, contract, securityContext);
    }

    @POST
    @Path("/provision/products/postpaid")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "create a new postpaid product", response = void.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New postpaid service created", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response createPostpaidService(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "postpaidservice", required = true) ProductPostpaid postpaidService,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createPostpaidService(umUserHash, umSessionId, umDomain, postpaidService, securityContext);
    }

    @POST
    @Path("/provision/prepaid-services")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "create a new prepaid service", response = void.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New prepaid service created", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response createPrepaidService(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "prepaidservice", required = true) ServicePrepaid prepaidService,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createPrepaidService(umUserHash, umSessionId, umDomain, prepaidService, securityContext);
    }

    @DELETE
    @Path("/provision/contract-templates/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Delete a contract template", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "contract deleted", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response deleteContractTemplate(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "contract template id to delete", required = true) @PathParam("id") long id,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteContractTemplate(umUserHash, umSessionId, umDomain, id, securityContext);
    }

    @DELETE
    @Path("/provision/products/postpaid/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Delete a postpaidservice", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Postpaid Service deleted", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response deletePostPaidService(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Postpaid Service id to delete", required = true) @PathParam("id") long id,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deletePostPaidService(umUserHash, umSessionId, umDomain, id, securityContext);
    }

    @DELETE
    @Path("/provision/customers/{customer_id}/postpaid-contracts/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "(also deletes all related services)", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "contract deleted", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response deletePostpaidContract(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "contract id to delete", required = true) @PathParam("customer_id") long customerId,
            @ApiParam(value = "contract id to delete", required = true) @PathParam("id") long id,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deletePostpaidContract(umUserHash, umSessionId, umDomain, customerId, id, securityContext);
    }

    @DELETE
    @Path("/provision/customers/{customer_id}/prepaid-contracts/{contract_id}/services/{service_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "(also deletes all related services)", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "contract deleted", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response deletePrepaidContract(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "contract id to delete", required = true) @PathParam("contract_id") long contractId,
            @ApiParam(value = "service id to delete", required = true) @PathParam("service_id") long serviceId,
            @ApiParam(value = "Id of customer to fetch", required = true) @PathParam("customer_id") long customerId,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deletePrepaidContract(umUserHash, umSessionId, umDomain, contractId, serviceId, customerId, securityContext);
    }

    @DELETE
    @Path("/provision/products/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Delete a product from catalogue", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "product deleted", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response deleteProduct(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "id of product to delete", required = true) @PathParam("id") long id,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteProduct(umUserHash, umSessionId, umDomain, id, securityContext);
    }

    @GET
    @Path("/provision/customers/{customer_id}/prepaid-contracts/{contract_id}/products")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets postpaid products associated with a contract. Optional pagination parameters - offset, and limit to determine the number of records to ", response = ProductPostpaid.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of postpaid services that match the search criteria", response = ProductPostpaid.class, responseContainer = "List")
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = ProductPostpaid.class, responseContainer = "List")})
    public Response getPostpaidProducts(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Page limit", required = true, defaultValue = "20") @DefaultValue("20") @QueryParam("limit") long limit,
            @ApiParam(value = "Customer id of the postpaid service to fetch", required = true) @PathParam("customer_id") long customerId,
            @ApiParam(value = "contract_id of the postpaid service to fetch", required = true) @PathParam("contract_id") long contractId,
            @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") long offset,
            @ApiParam(value = "Prepaid Services") @QueryParam("Postpaid service") String postpaidService,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getPostpaidProducts(umUserHash, umSessionId, umDomain, limit, customerId, contractId, offset, postpaidService, securityContext);
    }

    @GET
    @Path("/provision/prepaid-services/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets prepaid services. Optional pagination parameters - offset, and limit to determine the number of records to ", response = ServicePrepaid.class, tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Prepaid service", response = ServicePrepaid.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = ServicePrepaid.class)})
    public Response getPrepaidService(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Prepaid service ID to fetch", required = true) @PathParam("id") long id,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getPrepaidService(umUserHash, umSessionId, umDomain, id, securityContext);
    }

    @GET
    @Path("/provision/contract-templates/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "View an existing contract template", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "seen", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response getContractTemplate(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Id of contract to view", required = true) @PathParam("id") long id,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getContractTemplate(umUserHash, umSessionId, umDomain, id, securityContext);
    }

    @PUT
    @Path("/provision/contract-templates/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Update an existing contract template", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Contract template edited", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response updateContractTemplate(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Id of contract to update", required = true) @PathParam("id") long id,
            @ApiParam(value = "contract template information", required = true) ContractTemplate contract,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateContractTemplate(umUserHash, umSessionId, umDomain, id, contract, securityContext);
    }

    @PUT
    @Path("/provision/customers/{customer_id}/postpaid-contracts/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Update an existing contract", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Existing contract details edited", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response updatePostpaidContract(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Id of customer to update", required = true) @PathParam("customer_id") long customerId,
            @ApiParam(value = "Id of contract to update", required = true) @PathParam("id") long id,
            @ApiParam(value = "contract information", required = true) ContractPostpaid contract,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updatePostpaidContract(umUserHash, umSessionId, umDomain, customerId, id, contract, securityContext);
    }

    @PUT
    @Path("/provision/products/postpaid/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Update a postpaid product", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Postpaid Service edited", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response updatePostpaidProduct(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Product ID of the postpaid product to update", required = true) @PathParam("id") long id,
            @ApiParam(value = "Postpaid product information", required = true) ProductPostpaid service,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updatePostpaidProduct(umUserHash, umSessionId, umDomain, id, service, securityContext);
    }

    @PUT
    @Path("/provision/customers/{customer_id}/prepaid-contracts/{contract_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Update an existing contract", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Existing contract details edited", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response updatePrepaidContract(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Id of customer to update", required = true) @PathParam("customer_id") long customerId,
            @ApiParam(value = "Id of contract to update", required = true) @PathParam("contract_id") long contractId,
            @ApiParam(value = "contract information", required = true) ContractPrepaid contract,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updatePrepaidContract(umUserHash, umSessionId, umDomain, customerId, contractId, contract, securityContext);
    }

    @PUT
    @Path("/provision/prepaid-services/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Update a prepaidservice", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Prepaid service information edited", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response updatePrepaidService(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "contract_id of the prepaid service to fetch", required = true) @PathParam("id") long id,
            @ApiParam(value = "PrepaidService information", required = true) ServicePrepaid contract,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updatePrepaidService(umUserHash, umSessionId, umDomain, id, contract, securityContext);
    }

    @PUT
    @Path("/provision/products/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Update an existing product", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Existing product details edited", response = void.class)
        ,
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response updateProduc(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "Id of product to update", required = true) @PathParam("id") long id,
            @ApiParam(value = "product information", required = true) Product product,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateProduc(umUserHash, umSessionId, umDomain, id, product, securityContext);
    }
}
