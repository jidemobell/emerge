package io.swagger.api;

import io.swagger.model.AllegedPayment;
import io.swagger.model.Invoice;
import io.swagger.model.Payment;
import io.swagger.model.TaxType;
import io.swagger.model.TeloAgentProfitConfig;
import io.swagger.model.TeloAgents;
import io.swagger.model.TeloOperatorProfitConfig;
import java.io.InputStream;
import java.util.Date;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:54:31.527Z")
public abstract class BssPaymentsApiService {

    public abstract Response createAllegedPayment(String umUserHash, String umSessionId, String umDomain, AllegedPayment alledgedPayment, SecurityContext securityContext) throws NotFoundException;

    public abstract Response confirmBankStatement(String umUserHash, String umSessionId, String umDomain, String fileId,String bankName, SecurityContext securityContext) throws NotFoundException;

    public abstract Response uploadBankStatement(String umUserHash, String umSessionId, String umDomain, String bankName, InputStream statementFileInputStream, FormDataContentDisposition statementFileDetail, SecurityContext securityContext) throws NotFoundException;

    public abstract Response createInvoice(String umUserHash, String umSessionId, String umDomain, Invoice createInvoice, SecurityContext securityContext) throws NotFoundException;

    public abstract Response createPayment(String umUserHash, String umSessionId, String umDomain, Payment paymentRecord, SecurityContext securityContext) throws NotFoundException;

    public abstract Response createTaxType(String umUserHash, String umSessionId, String umDomain, TaxType taxType, SecurityContext securityContext) throws NotFoundException;

    public abstract Response createTeloAgent(String umUserHash, String umSessionId, String umDomain, TeloAgents telo, SecurityContext securityContext) throws NotFoundException;

    public abstract Response createTeloAgentProfitConfig(String umUserHash, String umSessionId, String umDomain, TeloAgentProfitConfig teloAgentProfitConfig, SecurityContext securityContext) throws NotFoundException;

    public abstract Response createTeloOperatorProfitConfig(String umUserHash, String umSessionId, String umDomain, TeloOperatorProfitConfig teloAgentProfitConfig, SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteAlledgedPayment(String umUserHash, String umSessionId, String umDomain, long alledgedPaymentId, AllegedPayment alledgedPayment, SecurityContext securityContext) throws NotFoundException;

    public abstract Response deletePayment(String umUserHash, String umSessionId, String umDomain, long paymentId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteTaxType(String umUserHash, String umSessionId, String umDomain, long taxTypeId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteTeloAgent(String umUserHash, String umSessionId, String umDomain, long teloAgentId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteTeloAgentProfitConfig(String umUserHash, String umSessionId, String umDomain, long customerId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteTeloOperatorProfitConfig(String umUserHash, String umSessionId, String umDomain, long customerId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response getCreditNote(String umUserHash, String umSessionId, String umDomain, Long limit, Long customerId, Long paymentId, Long invoiceNumber, Long offset, String creditNote, String creditNoteDescription, SecurityContext securityContext) throws NotFoundException;

    public abstract Response getInvoiceByInvoiceNumber(String umUserHash, String umSessionId, String umDomain, Long invoiceNumber, SecurityContext securityContext) throws NotFoundException;

    public abstract Response getInvoices(String umUserHash, String umSessionId, String umDomain, String customerName, long customerId, String customerFiscalNumber, String customerContact, String customerEmail, String customerUsername, long paymentId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response getPayment(String umUserHash, String umSessionId, String umDomain, long offset, long limit, long paymentId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response getPaymentReceipt(String umUserHash, String umSessionId, String umDomain, long paymentId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response getTeloAgentProfitConfig(String umUserHash, String umSessionId, String umDomain, Long limit, Long customerId, Long offset, String teloAgentProfit, String teloAgentDescription, SecurityContext securityContext) throws NotFoundException;

    public abstract Response getTeloOperatorProfitConfig(String umUserHash, String umSessionId, String umDomain, Long limit, Long customerId, Long offset, String teloOperatorProfitConfig, String teloOperatorProfitConfigDescription, SecurityContext securityContext) throws NotFoundException;

    public abstract Response revokePayment(String umUserHash, String umSessionId, String umDomain, long paymentId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchAllegedPayment(String umUserHash, String umSessionId, String umDomain, String paymentMethod, String serviceToProvision, SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchPayment(String umUserHash, String umSessionId, String umDomain, Long limit, Date beginDate, Date endDate, Long offset, String customerId, long customerName, String customerFiscalNumber, String customerPhoneNumber, String customerEmail, String customerUsername, String invoiceNumber, String paymentMethod, String paymentReference, String paymentStatus, SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchTaxType(String umUserHash, String umSessionId, String umDomain, Long offset, Long limit, String description, long percentage, long tax_type_id, SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchTeloAgent(String umUserHash, String umSessionId, String umDomain, Long offset, Long limit, long prepaidServiceId, SecurityContext securityContext) throws NotFoundException;

    public abstract Response setTeloAgentBalance(String umUserHash, String umSessionId, String umDomain, long teloAgentId, String newBalance, SecurityContext securityContext) throws NotFoundException;

    public abstract Response topupTeloAgentBalance(String umUserHash, String umSessionId, String umDomain, long teloAgentServiceId, TeloAgents topupValue, SecurityContext securityContext) throws NotFoundException;

    public abstract Response updateAllegedPayment(String umUserHash, String umSessionId, String umDomain, long alledgedPaymentId, AllegedPayment teloAgent, SecurityContext securityContext) throws NotFoundException;

    public abstract Response updatePayment(String umUserHash, String umSessionId, String umDomain, long paymentId, Payment payment, SecurityContext securityContext) throws NotFoundException;

    public abstract Response updateTaxType(String umUserHash, String umSessionId, String umDomain, long taxTypeId, TaxType taxType, SecurityContext securityContext) throws NotFoundException;

    public abstract Response updateTeloAgentProfitConfig(String umUserHash, String umSessionId, String umDomain, Long customerId, TeloAgentProfitConfig contract, SecurityContext securityContext) throws NotFoundException;

    public abstract Response updateTeloOperatorProfitConfig(String umUserHash, String umSessionId, String umDomain, Long customerId, TeloOperatorProfitConfig contract, SecurityContext securityContext) throws NotFoundException;

    public abstract Response returnBalanceOfTeloAgent(String umUserHash, String umSessionId, String umDomain, TeloAgents telo, long prepaidServiceId, SecurityContext securityContext) throws NotFoundException;

}
