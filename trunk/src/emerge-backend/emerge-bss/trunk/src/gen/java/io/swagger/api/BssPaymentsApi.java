package io.swagger.api;

import io.swagger.api.factories.BssPaymentsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.model.AllegedPayment;
import io.swagger.model.Invoice;
import io.swagger.model.Payment;
import io.swagger.model.TaxType;
import io.swagger.model.TeloAgents;
import io.swagger.model.TeloAgentProfitConfig;
import io.swagger.model.TeloOperatorProfitConfig;
import io.swagger.model.CreditNote;
import io.swagger.model.Receipt;
import io.swagger.model.StatementSummary;
import java.io.InputStream;
import java.util.Date;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/")
@Consumes({"application/json"})
@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the bss API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:54:31.527Z")
public class BssPaymentsApi {

    private final BssPaymentsApiService delegate = BssPaymentsApiServiceFactory.getBssPaymentsApi();

    @POST
    @Path("/provision/bank-statement/confirm")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Confirm a bank statement upload", response = void.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Bank statement confirm message", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response confirmBankStatement(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Id that denotes the file to confirm and process", required = true) @FormParam("file_id") String fileId, @ApiParam(value = "Name of the bank whose file is being processed", required = true) @FormParam("bank_name") String bankName, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.confirmBankStatement(umUserHash, umSessionId, umDomain, fileId, bankName, securityContext);
    }

    @POST
    @Path("/provision/bank-statement/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Upload bank statement for a bank", response = StatementSummary.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Summary of the uploaded file", response = StatementSummary.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = StatementSummary.class)})
    public Response uploadBankStatement(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Name of bank", required = true) @FormDataParam("bankName") String bankName,
            @FormDataParam("statementFile") InputStream statementFileInputStream,
            @FormDataParam("statementFile") FormDataContentDisposition statementFileDetail, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.uploadBankStatement(umUserHash, umSessionId, umDomain, bankName, statementFileInputStream, statementFileDetail, securityContext);
    }

    @POST
    @Path("/provision/alleged_payments")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Manage alleged payments of customers", response = void.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New alleged payment created", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response createAllegedPayment(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Alleged Payment", required = true) AllegedPayment alledgedPayment, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createAllegedPayment(umUserHash, umSessionId, umDomain, alledgedPayment, securityContext);
    }

    @POST
    @Path("/provision/invoices")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "create a new invoice for a payment", response = void.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New invoice created", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response createInvoice(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Customer invoice information", required = true) Invoice createInvoice, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createInvoice(umUserHash, umSessionId, umDomain, createInvoice, securityContext);
    }

    @POST
    @Path("/provision/payments")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Keeps payment information", response = void.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Payment record created", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response createPayment(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Payment information", required = true) Payment paymentRecord, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createPayment(umUserHash, umSessionId, umDomain, paymentRecord, securityContext);
    }

    @POST
    @Path("/provision/tax-types")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "create a new tax type", response = void.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New customer created", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response createTaxType(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Tax type information", required = true) TaxType taxType, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createTaxType(umUserHash, umSessionId, umDomain, taxType, securityContext);
    }

    @POST
    @Path("/provision/telo-agents")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Create a new telo agent", response = TeloAgents.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "New telo agent created", response = TeloAgents.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = TeloAgents.class)})
    public Response createTeloAgent(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Tax type information", required = true) TeloAgents telo, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createTeloAgent(umUserHash, umSessionId, umDomain, telo, securityContext);
    }

    @POST
    @Path("/provision/telo-agent-profit-config")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Manage profit config for telo agent", response = void.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "telo_agent_profit_configured", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response createTeloAgentProfitConfig(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Telo agent profit", required = true) TeloAgentProfitConfig teloAgentProfitConfig, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createTeloAgentProfitConfig(umUserHash, umSessionId, umDomain, teloAgentProfitConfig, securityContext);
    }

    @POST
    @Path("/provision/telo_operator_profit_config")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Manage profit config for telo operator", response = void.class, tags = {"Events",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "telo_agent_profit_configured", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response createTeloOperatorProfitConfig(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Telo Operator Profit Configuration", required = true) TeloOperatorProfitConfig teloAgentProfitConfig, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createTeloOperatorProfitConfig(umUserHash, umSessionId, umDomain, teloAgentProfitConfig, securityContext);
    }

    @DELETE
    @Path("/provision/alledged_payment/{alledged_payment_Id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "delete an alledged payment on the bss", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "alledged payment deleted", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response deleteAlledgedPayment(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "alledged payment id to delete", required = true) @PathParam("alledged_payment_Id") long alledgedPaymentId, @ApiParam(value = "alledged payment information", required = true) AllegedPayment alledgedPayment, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteAlledgedPayment(umUserHash, umSessionId, umDomain, alledgedPaymentId, alledgedPayment, securityContext);
    }

    @DELETE
    @Path("/provision/payments/{payment_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Delete a payment", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Customer Payment Invoice deleted", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response deletePayment(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "payment id to delete", required = true) @PathParam("payment_id") long paymentId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deletePayment(umUserHash, umSessionId, umDomain, paymentId, securityContext);
    }

    @DELETE
    @Path("/provision/tax-types/{tax_type_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "delete a tax_type on the bss", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "tax type deleted", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response deleteTaxType(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "tax type id to delete", required = true) @PathParam("tax_type_id") long taxTypeId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteTaxType(umUserHash, umSessionId, umDomain, taxTypeId, securityContext);
    }

    @DELETE
    @Path("/provision/telo-agents/{telo_agent_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "delete a telo agent", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "tax type deleted", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response deleteTeloAgent(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "tax type id to delete", required = true) @PathParam("telo_agent_id") long teloAgentId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteTeloAgent(umUserHash, umSessionId, umDomain, teloAgentId, securityContext);
    }

    @DELETE
    @Path("/provision/telo-agent-profit-config/delete/{customer_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Delete a telo_agent_profit_config", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Telo_agent_profit_config deleted", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response deleteTeloAgentProfitConfig(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "customer id of the Telo_agent_profit_config to delete", required = true) @PathParam("customer_id") long customerId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteTeloAgentProfitConfig(umUserHash, umSessionId, umDomain, customerId, securityContext);
    }

    @DELETE
    @Path("/provision/telo-operator-profit-config/delete/{customer_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Delete a telo_operator_profit_config", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Telo_operator_profit_config deleted", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response deleteTeloOperatorProfitConfig(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "customer id of the Telo_operator_profit_config to delete", required = true) @PathParam("customer_id") long customerId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteTeloOperatorProfitConfig(umUserHash, umSessionId, umDomain, customerId, securityContext);
    }

    @GET
    @Path("/provision/credit_notes/{payment_id}/{customer_id}/{invoice_number}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets credit note. Optional pagination parameters - offset, and limit to determine the number of records to ", response = CreditNote.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of credit_notes that match the search criteria", response = CreditNote.class, responseContainer = "List")
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = CreditNote.class, responseContainer = "List")})
    public Response getCreditNote(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Page limit", required = true, defaultValue = "20") @DefaultValue("20") @QueryParam("limit") Long limit, @ApiParam(value = "customer_id of the credit_note to fetch", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "payment_id of the credit_note to fetch", required = true) @PathParam("payment_id") Long paymentId, @ApiParam(value = "invoice_number of the credit_note to fetch", required = true) @PathParam("invoice_number") Long invoiceNumber, @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") Long offset, @ApiParam(value = "credit_note management") @QueryParam("credit_note") String creditNote, @ApiParam(value = "Description of credit_note management") @QueryParam("credit_noteDescription") String creditNoteDescription, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getCreditNote(umUserHash, umSessionId, umDomain, limit, customerId, paymentId, invoiceNumber, offset, creditNote, creditNoteDescription, securityContext);
    }

    @GET
    @Path("/provision/invoices/{invoice_number}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets prepaid services. Optional pagination parameters - offset, and limit to determine the number of records to ", response = Invoice.class, tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Invoice", response = Invoice.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Invoice.class)})
    public Response getInvoiceByInvoiceNumber(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "invoice_number of the invoice to fetch", required = true) @PathParam("invoice_number") Long invoiceNumber, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getInvoiceByInvoiceNumber(umUserHash, umSessionId, umDomain, invoiceNumber, securityContext);
    }

    @GET
    @Path("/provision/invoices")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets prepaid services. Optional pagination parameters - offset, and limit to determine the number of records to ", response = Invoice.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of Invoices that match the search criteria", response = Invoice.class, responseContainer = "List")
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Invoice.class, responseContainer = "List")})
    public Response getInvoices(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Customer name to whom of the invoices belong to") @QueryParam("customer_name") String customerName, @ApiParam(value = "Customer Id to whom of the invoices belong to", defaultValue = "0") @DefaultValue("0") @QueryParam("customer_id") long customerId, @ApiParam(value = "Customer fiscal number to whom of the invoices belong to") @QueryParam("customer_fiscal_number") String customerFiscalNumber, @ApiParam(value = "Customer contact to whom of the invoices belong to. Will search all phone and fax contacts") @QueryParam("customerContact") String customerContact, @ApiParam(value = "Customer email to whom of the invoices belong to") @QueryParam("customer_email") String customerEmail, @ApiParam(value = "Customer username to whom of the invoices belong to") @QueryParam("customer_username") String customerUsername, @ApiParam(value = "Payment for this invoice", defaultValue = "0") @DefaultValue("0") @QueryParam("payment_id") long paymentId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getInvoices(umUserHash, umSessionId, umDomain, customerName, customerId, customerFiscalNumber, customerContact, customerEmail, customerUsername, paymentId, securityContext);
    }

    @GET
    @Path("/provision/payments/{payment_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Get payment", response = Payment.class, tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Payment", response = Payment.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Payment.class)})
    public Response getPayment(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Page limit", required = true, defaultValue = "20") @DefaultValue("20") @QueryParam("limit") Long limit, @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") Long offset, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "payment_id of the payment to fetch", required = true) @PathParam("payment_id") long paymentId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getPayment(umUserHash, umSessionId, umDomain, limit, offset, paymentId, securityContext);
    }

    @GET
    @Path("/provision/payments/{payment_id}/receipt")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Issue receipt for a payment", response = Receipt.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Invoice information edited", response = Receipt.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Receipt.class)})
    public Response getPaymentReceipt(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "payment_id of the payment invoice to update", required = true) @PathParam("payment_id") long paymentId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getPaymentReceipt(umUserHash, umSessionId, umDomain, paymentId, securityContext);
    }

    @GET
    @Path("/provision/telo-agent-profit-config/{customer_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets telo_agent_profit_config. Optional pagination parameters - offset, and limit to determine the number of records to ", response = TeloAgentProfitConfig.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of telo_agent_profit_config that match the search criteria", response = TeloAgentProfitConfig.class, responseContainer = "List")
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = TeloAgentProfitConfig.class, responseContainer = "List")})
    public Response getTeloAgentProfitConfig(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Page limit", required = true, defaultValue = "20") @DefaultValue("20") @QueryParam("limit") Long limit, @ApiParam(value = "customer_id of the telo_agent_profit_config to fetch", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") Long offset, @ApiParam(value = "telo_agent_profit_config") @QueryParam("telo_agent_profit") String teloAgentProfit, @ApiParam(value = "Description of telo_agent_profit_config management") @QueryParam("TeloAgentDescription") String teloAgentDescription, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getTeloAgentProfitConfig(umUserHash, umSessionId, umDomain, limit, customerId, offset, teloAgentProfit, teloAgentDescription, securityContext);
    }

    @GET
    @Path("/provision/telo-operator-profit-config/{customer_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets telo_operator_profit_config. Optional pagination parameters - offset, and limit to determine the number of records to ", response = TeloOperatorProfitConfig.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of Telo_operator_profit_config that match the search criteria", response = TeloOperatorProfitConfig.class, responseContainer = "List")
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = TeloOperatorProfitConfig.class, responseContainer = "List")})
    public Response getTeloOperatorProfitConfig(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Page limit", required = true, defaultValue = "20") @DefaultValue("20") @QueryParam("limit") Long limit, @ApiParam(value = "customer_id of the telo_operator_profit_config to fetch", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") Long offset, @ApiParam(value = "Telo_operator_profit_config management") @QueryParam("Telo_operator_profit_config") String teloOperatorProfitConfig, @ApiParam(value = "Description of Telo_operator_profit_config management") @QueryParam("Telo_operator_profit_configDescription") String teloOperatorProfitConfigDescription, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getTeloOperatorProfitConfig(umUserHash, umSessionId, umDomain, limit, customerId, offset, teloOperatorProfitConfig, teloOperatorProfitConfigDescription, securityContext);
    }

    @PUT
    @Path("/provision/payments/{payment_id}/revoke")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Revoke a payment", response = CreditNote.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Invoice information edited", response = CreditNote.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = CreditNote.class)})
    public Response revokePayment(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "payment_id of the payment invoice to update", required = true) @PathParam("payment_id") long paymentId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.revokePayment(umUserHash, umSessionId, umDomain, paymentId, securityContext);
    }

    @GET
    @Path("/provision/alleged_payments")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a list of alledged payments that match the search criteria. If multiple criteria are specified, the result will be a list of all customers that match all the criteria (logical AND)", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "All alledged payments listed", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response searchAllegedPayment(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "payment method for the alledged payment") @QueryParam("payment method") String paymentMethod, @ApiParam(value = "description of service the alledged payment is associated with") @QueryParam("service to provision") String serviceToProvision, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchAllegedPayment(umUserHash, umSessionId, umDomain, paymentMethod, serviceToProvision, securityContext);
    }

    @GET
    @Path("/provision/payments")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Gets prepaid services. Optional pagination parameters - offset, and limit to determine the number of records to fetch ", response = Payment.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of payment Invoices that match the search criteria", response = Payment.class, responseContainer = "List")
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Payment.class, responseContainer = "List")})
    public Response searchPayment(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Page limit", required = true, defaultValue = "20") @DefaultValue("20") @QueryParam("limit") Long limit, @ApiParam(value = "Begin date", required = true) @QueryParam("begin_date") Date beginDate, @ApiParam(value = "End date", required = true) @QueryParam("end_date") Date endDate, @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") Long offset, @ApiParam(value = "Customer Id") @QueryParam("customer_id") String customerId, @ApiParam(value = "Customer Id") @QueryParam("customer_name") long customerName, @ApiParam(value = "Customer fiscal number") @QueryParam("customer_fiscal_number") String customerFiscalNumber, @ApiParam(value = "Customer phone number") @QueryParam("customer_phone_number") String customerPhoneNumber, @ApiParam(value = "Customer email") @QueryParam("customer_email") String customerEmail, @ApiParam(value = "Customer Username") @QueryParam("customer_username") String customerUsername, @ApiParam(value = "Invoice number") @QueryParam("invoice_number") String invoiceNumber, @ApiParam(value = "Payment method", allowableValues = "Insert, payment, methods") @QueryParam("payment_method") String paymentMethod, @ApiParam(value = "Payment reference") @QueryParam("payment_reference") String paymentReference, @ApiParam(value = "Payment status", allowableValues = "Insert, payment, status") @QueryParam("payment_status") String paymentStatus, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchPayment(umUserHash, umSessionId, umDomain, limit, beginDate, endDate, offset, customerId, customerName, customerFiscalNumber, customerPhoneNumber, customerEmail, customerUsername, invoiceNumber, paymentMethod, paymentReference, paymentStatus, securityContext);
    }

    @GET
    @Path("/provision/tax-types")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a list of tax types that match the search criteria. If multiple criteria are specified, the result will be a list of all customers that match all the criteria (logical AND)", response = TaxType.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of tax types that match the search criteria", response = TaxType.class, responseContainer = "List")
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = TaxType.class, responseContainer = "List")})
    public Response searchTaxType(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") Long offset, @ApiParam(value = "Page limit", defaultValue = "20") @DefaultValue("20") @QueryParam("limit") Long limit, @ApiParam(value = "tax type description") @QueryParam("description") String description, @ApiParam(value = "percentage of the particular tax_type") @QueryParam("percentage") long percentage, @ApiParam(value = "percentage of the particular tax_type") @QueryParam("tax_type_id") long tax_type_id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchTaxType(umUserHash, umSessionId, umDomain, offset, limit, description, percentage, tax_type_id, securityContext);
    }

    @GET
    @Path("/provision/prepaid-services/{prepaid_service_id}/telo-agent")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a list of teloagents that match the search criteria. If multiple criteria are specified, the result will be a list of all customers that match all the criteria (logical AND)", response = TaxType.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of teloagents that match the search criteria", response = TaxType.class, responseContainer = "List")
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = TaxType.class, responseContainer = "List")})
    public Response searchTeloAgent(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") Long offset, @ApiParam(value = "Page limit", defaultValue = "20") @DefaultValue("20") @QueryParam("limit") Long limit, @ApiParam(value = "telo_agent_id of the customer to search") @PathParam("prepaid_service_id") long prepaidServiceId, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchTeloAgent(umUserHash, umSessionId, umDomain, offset, limit, prepaidServiceId, securityContext);
    }

    @GET
    @Path("/provision/telo_agents/{prepaid_service_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a list of teloagents that match the search criteria. If multiple criteria are specified, the result will be a list of all customers that match all the criteria (logical AND)", response = TaxType.class, responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of teloagents that match the search criteria", response = TaxType.class, responseContainer = "List")
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = TaxType.class, responseContainer = "List")})
    public Response returnBalanceOfTeloAgent(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash,
            @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain,
            @ApiParam(value = "prepaidservice", required = true) TeloAgents telo,
            @ApiParam(value = "prepaid_service_id of the telo_agent to search") @PathParam("prepaid_service_id") long prepaidServiceId,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.returnBalanceOfTeloAgent(umUserHash, umSessionId, umDomain, telo, prepaidServiceId, securityContext);
    }

    @PUT
    @Path("/provision/telo-agents/{telo_agent_id}/set-balance")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Set balance of a telo agent", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Existing telo agent details updated", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response setTeloAgentBalance(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Telo Agent id to edit/update", required = true) @PathParam("telo_agent_id") long teloAgentId, @ApiParam(value = "Telo Agent id to edit/update", required = true) @HeaderParam("newBalance") String newBalance, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.setTeloAgentBalance(umUserHash, umSessionId, umDomain, teloAgentId, newBalance, securityContext);
    }

    @PUT
    @Path("/provision/telo-agents/{telo_agent_service_id}/topup")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Topup a telo agent", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Existing telo agent details updated", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response topupTeloAgentBalance(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Telo Agent service id to edit/update", required = true) @PathParam("telo_agent_service_id") long teloAgentServiceId, @ApiParam(value = "value to add to balance", required = true) TeloAgents topupValue, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.topupTeloAgentBalance(umUserHash, umSessionId, umDomain, teloAgentServiceId, topupValue, securityContext);

    }

    @PUT
    @Path("/provision/alledged_payment/{alledged_payment_Id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "edit an existing telo agent information", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Existing telo agent details updated", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response updateAllegedPayment(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "Alledged payment id to edit/update", required = true) @PathParam("alledged_payment_Id") long alledgedPaymentId, @ApiParam(value = "Alledged payment information", required = true) AllegedPayment teloAgent, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateAllegedPayment(umUserHash, umSessionId, umDomain, alledgedPaymentId, teloAgent, securityContext);
    }

    @PUT
    @Path("/provision/payments/{payment_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Update a generated payment", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Invoice information edited", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response updatePayment(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "payment_id of the payment invoice to update", required = true) @PathParam("payment_id") long paymentId, @ApiParam(value = "Update payment information", required = true) Payment payment, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updatePayment(umUserHash, umSessionId, umDomain, paymentId, payment, securityContext);
    }

    @PUT
    @Path("/provision/tax-types/{tax_type_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "edit an existing customer on the bss", response = void.class, tags = {"Operation",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Existing customer details edited", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response updateTaxType(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "tax type id to edit/update", required = true) @PathParam("tax_type_id") long taxTypeId, @ApiParam(value = "Customer information", required = true) TaxType taxType, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateTaxType(umUserHash, umSessionId, umDomain, taxTypeId, taxType, securityContext);
    }

    @PUT
    @Path("/provision/telo-agent-profit-config/update/{customer_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Update profit configuration for a customer id", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Invoice information edited", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response updateTeloAgentProfitConfig(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "customer_id of the telo_agent_profit_config to update", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "Update telo_agent_profit_config_information", required = true) TeloAgentProfitConfig contract, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateTeloAgentProfitConfig(umUserHash, umSessionId, umDomain, customerId, contract, securityContext);
    }

    @PUT
    @Path("/provision/telo-operator-profit-config/update/{customer_id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Update profit configuration for a customer id", response = void.class, tags = {"Operations",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "Telo_operator_profit_config edited", response = void.class)
        ,

        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class)})
    public Response updateTeloOperatorProfitConfig(@ApiParam(value = "um_user_hash, as returned by the User Management system", required = true) @HeaderParam("um_user_hash") String umUserHash, @ApiParam(value = "um_session_id on the User Management system", required = true) @HeaderParam("um_session_id") String umSessionId, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("um_domain") String umDomain, @ApiParam(value = "customer_id of the telo_operator_profit_config to update", required = true) @PathParam("customer_id") Long customerId, @ApiParam(value = "Update telo_operator_profit_config_information", required = true) TeloOperatorProfitConfig contract, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.updateTeloOperatorProfitConfig(umUserHash, umSessionId, umDomain, customerId, contract, securityContext);
    }
}
