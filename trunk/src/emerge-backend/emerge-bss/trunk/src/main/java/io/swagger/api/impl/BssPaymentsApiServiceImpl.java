package io.swagger.api.impl;

import au.com.bytecode.opencsv.CSVReader;
import com.emerge.bss.auth.AccessControl;
import com.emerge.bss.crud.DBResource;
import com.emerge.bss.crud.PaymentDAO;
import com.emerge.bss.crud.PaymentMapper;
import com.emerge.bss.database.history.HDBResource;
import com.emerge.bss.util.JdbiHelper;
import io.swagger.api.ApiResponseMessage;
import io.swagger.api.BssPaymentsApiService;
import io.swagger.model.AllegedPayment;
import io.swagger.model.Invoice;
import io.swagger.model.Payment;
import io.swagger.model.TaxType;
import io.swagger.model.TeloAgentProfitConfig;
import io.swagger.model.TeloOperatorProfitConfig;
import java.util.Date;
import io.swagger.api.NotFoundException;
import io.swagger.model.StatementSummary;
import io.swagger.model.TaxTypes;
import io.swagger.model.TeloAgents;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.skife.jdbi.v2.DBI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-21T13:41:49.775Z")
public class BssPaymentsApiServiceImpl extends BssPaymentsApiService {

    @Override
    public Response createAllegedPayment(String umUserHash, String umSessionId, String umDomain, AllegedPayment alledgedPayment, SecurityContext securityContext) throws NotFoundException {
        PaymentDAO pDAO = null;
        try {
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
            long allegedPaymentID = pDAO.createAllegedPayment(alledgedPayment.getPaymentMethod().name(), alledgedPayment.getCustomerId(), alledgedPayment.getServicesToProvision().name(), alledgedPayment.getPaymentReferenceNumber(), alledgedPayment.getBankName(), alledgedPayment.getValue());
            alledgedPayment.setCustomerId(allegedPaymentID);

            HDBResource.put(alledgedPayment, "alleged_payments", "create");

            return Response.status(201).entity(new ApiResponseMessage(ApiResponseMessage.OK, "successful!")).build();
        } catch (Exception Ex) {

            return Response.status(500).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, Ex.getMessage())).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response createInvoice(String umUserHash, String umSessionId, String umDomain, Invoice createInvoice, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response createPayment(String umUserHash, String umSessionId, String umDomain, Payment paymentRecord, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        PaymentDAO pDAO = null;
        try {
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
             long paymentId = pDAO.createPayment(paymentRecord.getPaymentDate(), paymentRecord.getCustomerId(), paymentRecord.getPrepaidServiceId(), paymentRecord.getPostpaidServiceId(), paymentRecord.getReconciled().name(), paymentRecord.getReconciledMethod().name(), paymentRecord.getProvisionedEquipment().name(), paymentRecord.getPaymentReferenceNumber(), paymentRecord.getCreditBeforePayment(), paymentRecord.getCreditAfterPayment(), paymentRecord.getCostOfPaymentMethod(), paymentRecord.getNameOfBackOfficeOperator(), paymentRecord.getRevoked().name(), paymentRecord.getBankName(), paymentRecord.getValue(), paymentRecord.getNote(), paymentRecord.getPaymentMethod().name(), paymentRecord.getPaymentStatus(), paymentRecord.getElectronicReference(), paymentRecord.getTreasuryAccounts().name(), paymentRecord.getPaidService().name(), paymentRecord.getDescription());
            paymentRecord.setPaymentId(paymentId);
            
            HDBResource.put(paymentRecord, "payments", "create");

            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "successful!")).build();
        } catch (Exception Ex) {
            return Response.status(500).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, Ex.getMessage())).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response createTaxType(String umUserHash, String umSessionId, String umDomain, TaxType taxType, SecurityContext securityContext) throws NotFoundException {

        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        PaymentDAO pDAO = null;
        try {
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
            long taxID = pDAO.createTaxType(taxType.getDescription(), (taxType.getPercentage()));
            taxType.setTaxTypeId(taxID);

            HDBResource.put(taxType, "tax_types", "create");

            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully created!")).build();
        } catch (Exception Ex) {

            return Response.status(500).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, Ex.getMessage())).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response createTeloAgent(String umUserHash, String umSessionId, String umDomain, TeloAgents telo, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        PaymentDAO pDAO = null;
        try {
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
            long teloId = pDAO.createTeloAgent(telo.getPrepaidServiceId(), telo.getBalance());
            telo.setid(teloId);
            HDBResource.put(telo, "telo_agents", "create");

            //  return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "successful!")).build();
            return Response.status(201).entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully created!")).build();
        } catch (Exception Ex) {

            return Response.status(500).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, Ex.getMessage())).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response createTeloAgentProfitConfig(String umUserHash, String umSessionId, String umDomain, TeloAgentProfitConfig teloAgentProfitConfig, SecurityContext securityContext) throws NotFoundException {
        try {
            //     AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.serverError().build();
        }
        PaymentDAO paymentsDAO = null;
        try {
            paymentsDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
            long tpcID = paymentsDAO.createTeloAgentProfitConfig(teloAgentProfitConfig.getStartAmount(), teloAgentProfitConfig.getEndAmount(), teloAgentProfitConfig.getProfitPercentage(), teloAgentProfitConfig.getTeloAgentId());
            teloAgentProfitConfig.setTeloAgentId(tpcID);
            HDBResource.put(teloAgentProfitConfig, "telo_agent_profit_config", "create");

        } catch (Exception ex) {
            return Response.serverError().status(503).build();
        } finally {
            if (paymentsDAO != null) {
                paymentsDAO.close();
            }
        }
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully Configured!")).build();
    }

    @Override
    public Response createTeloOperatorProfitConfig(String umUserHash, String umSessionId, String umDomain, TeloOperatorProfitConfig teloOperatorProfitConfig, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.serverError().build();
        }
        PaymentDAO pDAO = null;
        try {
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);

            long topID = pDAO.createTeloOperatorProfitConfig(teloOperatorProfitConfig.getEndAmount(), teloOperatorProfitConfig.getProfitPercentage(), 0);
            teloOperatorProfitConfig.setCustomerId(topID);

            HDBResource.put(teloOperatorProfitConfig, "telo_operators", "create");

            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "successful!")).build();
        } catch (Exception ex) {
            return Response.serverError().build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response deleteAlledgedPayment(String umUserHash, String umSessionId, String umDomain, long alledgedPaymentId, AllegedPayment alledgedPayment, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response deletePayment(String umUserHash, String umSessionId, String umDomain, long paymentId, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        PaymentDAO pDAO = null;
        try {

            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);

            List<Map> payMENTS = pDAO.findPaymentById(paymentId, 0, 1);

            if (paymentId == 0 || payMENTS.size() < 1) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            //Now delete the customer
            /*cDAO.deleteCustomer(id);*/

            Payment payment = (Payment) payMENTS.get(0);
            HDBResource.put(payment, "payments", "delete");

            pDAO.deletePaymentById(paymentId);
            return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully deleted!")).build();
        } catch (Exception e) {
            return Response.status(500).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, e.getMessage())).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response deleteTaxType(String umUserHash, String umSessionId, String umDomain, long taxTypeId, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        PaymentDAO pDAO = null;
        try {
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);

            List<Map> taxTypes = pDAO.getTaxType(taxTypeId, null, 0, 0, 1);

            if (taxTypeId == 0 || taxTypes.size() < 1) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            //Now delete the customer
            /*cDAO.deleteCustomer(id);*/

            TaxTypes taxType = (TaxTypes) taxTypes.get(0);
            HDBResource.put(taxType, "tax_types", "delete");

            pDAO.deleteTaxType(taxTypeId);

            return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully deleted!")).build();

        } catch (Exception ex) {
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();

        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response deleteTeloAgent(String umUserHash, String umSessionId, String umDomain, long teloAgentId, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }

        PaymentDAO pDAO = null;
        try {
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
            pDAO.deleteTeloAgentById(teloAgentId);

            return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully deleted!")).build();

        } catch (Exception ex) {

            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response deleteTeloAgentProfitConfig(String umUserHash, String umSessionId, String umDomain, long teloAgentId, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.serverError().build();
        }
        PaymentDAO paymentsDAO = null;
        try {
            PaymentDAO pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);

            List<Map> teloAgentProfitId = paymentsDAO.findTeloOperatorProfitConfig(teloAgentId);

            if (teloAgentId == 0 || teloAgentProfitId.size() < 1) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            TeloAgentProfitConfig teloAgentProfitConfig = (TeloAgentProfitConfig) teloAgentProfitId.get(0);
            HDBResource.put(teloAgentProfitConfig, "tax_agent_profit_config", "delete");

            paymentsDAO.deleteTeloAgentProfitConfig(teloAgentId);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully Deleted!")).build();

        } catch (RuntimeException ex) {

            return Response.serverError().build();

        } finally {
            if (paymentsDAO != null) {
                paymentsDAO.close();
            }
        }

    }

    @Override
    public Response deleteTeloOperatorProfitConfig(String umUserHash, String umSessionId, String umDomain, long id, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.serverError().build();
        }
        PaymentDAO pDAO = null;
        try {
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
            List<Map> teloOperatorProfitId = pDAO.findTeloOperatorProfitConfig(id);

            if (id == 0 || teloOperatorProfitId.size() < 1) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            TeloOperatorProfitConfig teloOperatorProfitConfig = (TeloOperatorProfitConfig) teloOperatorProfitId.get(0);
            HDBResource.put(teloOperatorProfitConfig, "tax_operator_profit_config", "delete");

            pDAO.deleteTeloOperatorProfitConfig(id);
            return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.OK, "successful!")).build();
        } catch (RuntimeException ex) {

            return Response.serverError().build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response getCreditNote(String umUserHash, String umSessionId, String umDomain, Long limit, Long customerId, Long paymentId, Long invoiceNumber, Long offset, String creditNote, String creditNoteDescription, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response getInvoiceByInvoiceNumber(String umUserHash, String umSessionId, String umDomain, Long invoiceNumber, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response getInvoices(String umUserHash, String umSessionId, String umDomain, String customerName, long customerId, String customerFiscalNumber, String customerContact, String customerEmail, String customerUsername, long paymentId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response getPayment(String umUserHash, String umSessionId, String umDomain, long limit, long offset, long paymentId, SecurityContext securityContext) throws NotFoundException {
        PaymentDAO pDAO = null;

        try {

            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);

            //set default values if pagination fields are empty
            limit = limit == 0 ? 20 : limit;
            offset = offset == 0 ? 0 : offset;
            List<Map> payments = pDAO.findPaymentById(paymentId, offset, limit);//.findInvoices(String.valueOf(customerid), String.valueOf(invoicenumber), d, d, offset, limit);

            if (payments.size() > 0) {
                return Response.ok().entity(PaymentMapper.getPayment(payments.get(0))).build();
            } else {
                return Response.status(Status.NOT_FOUND).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Not Found")).build();
            }
        } catch (Exception ex) {

            return Response.status(500).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response getPaymentReceipt(String umUserHash, String umSessionId, String umDomain, long paymentId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response getTeloAgentProfitConfig(String umUserHash, String umSessionId, String umDomain, Long limit, Long teloAgentId, Long offset, String teloAgentProfit, String teloAgentDescription, SecurityContext securityContext) throws NotFoundException {
//        try {
//            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
//        } catch (Exception ex) {
//            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            return Response.serverError().build();
//        }
//        PaymentDAO pDAO = null;
//        try {
//            // do some magic!
//            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
//
//            //set default values if pagination fields are empty
////            if(limit == null)limit = 20L;
////            if(offset == null)offset = 0L;
//            List<Map> configs = pDAO.getTeloAgentProfitConfig(teloAgentId);
//            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, configs.toString())).build();
//        } catch (Exception ex) {
//            Logger.getLogger(BssCustomersApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//            return Response.serverError().build();
//        } finally {
//            if (pDAO != null) {
//                pDAO.close();
//            }
//        }
//    }
// do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response getTeloOperatorProfitConfig(String umUserHash, String umSessionId, String umDomain, Long limit, Long id, Long offset, String teloOperatorProfitConfig, String teloOperatorProfitConfigDescription, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.serverError().build();
        }
        PaymentDAO pDAO = null;
        try {
            // do some magic!
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);

            //set default values if pagination fields are empty
//            if(limit == null)limit = 20L;
//            if(offset == null)offset = 0L;
            List<Map> configs = pDAO.findTeloOperatorProfitConfig(id);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, configs.toString())).build();
        } catch (Exception ex) {

            return Response.serverError().build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response revokePayment(String umUserHash, String umSessionId, String umDomain, long paymentId, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response searchAllegedPayment(String umUserHash, String umSessionId, String umDomain, String paymentMethod, String serviceToProvision, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response searchPayment(String umUserHash, String umSessionId, String umDomain, Long limit, Date beginDate, Date endDate, Long offset, String customerId, long customerName, String customerFiscalNumber, String customerPhoneNumber, String customerEmail, String customerUsername, String invoiceNumber, String paymentMethod, String paymentReference, String paymentStatus, SecurityContext securityContext) throws NotFoundException {

        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response searchTaxType(String umUserHash, String umSessionId, String umDomain, Long offset, Long limit, String description, long percentage, long taxTypeId, SecurityContext securityContext) throws NotFoundException {

        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        PaymentDAO pDAO = null;
        try {

            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);

            //set default values if pagination fields are empty
            if (limit == null) {
                limit = 20L;
            }
            if (offset == null) {
                offset = 0L;
            }
            List<Map> tax_types = pDAO.getTaxType(taxTypeId, description, percentage, offset, limit);
            pDAO.close();
            if (tax_types.size() > 0) {
                return Response.ok().entity(tax_types.get(0)).build();
            } else {
                return Response.ok().entity(tax_types).build();
            }
            //    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, list.toString())).build();
        } catch (Exception ex) {

            if (pDAO != null) {
                pDAO.close();
            }
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response setTeloAgentBalance(String umUserHash, String umSessionId, String umDomain, long teloAgentId, String newBalance, SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }

    @Override
    public Response topupTeloAgentBalance(String umUserHash, String umSessionId, String umDomain, long teloAgentServiceId, TeloAgents topupValue, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        try {
            PaymentDAO pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
            if (pDAO.confirmIfTeloAgentExists(teloAgentServiceId)) {
                double balancebeforeTopUp = pDAO.selectBalance(teloAgentServiceId);
                double topUpValue = topupValue.getTopUpValue();
                if(topUpValue <= 0){
                    return Response.status(400).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Invalid Amount")).build();
                }
                double final_balance = balancebeforeTopUp + topUpValue;
                String reason = topupValue.getreasonForTopUp();
                pDAO.TopUpTeloAgentBalance(teloAgentServiceId, topupValue.getTopUpValue());
                return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Balance before TopUp is " + balancebeforeTopUp + " Balance after TopUp is " + final_balance + " Reason for top up is " + reason)).build();
            } else {
                return Response.status(404).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Telo Agent Service ID does not exist")).build();
            }
        } catch (Exception Ex) {
            return Response.status(500).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, Ex.getMessage())).build();
        }
    }

    @Override
    public Response updateAllegedPayment(String umUserHash, String umSessionId, String umDomain, long alledgedPaymentId, AllegedPayment teloAgent, SecurityContext securityContext) throws NotFoundException {
        PaymentDAO pDAO = null;
        try {
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
            long allegedPaymentResult = pDAO.updateAllegedPayment(alledgedPaymentId, teloAgent.getPaymentMethod().name(), teloAgent.getCustomerId(), teloAgent.getServicesToProvision().name(), teloAgent.getPaymentReferenceNumber(), teloAgent.getBankName(), teloAgent.getValue());
            if (allegedPaymentResult < 1) {
                return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.INFO, "No row was updated!")).build();
            }
            HDBResource.put(teloAgent, "alleged_payments", "update");

            return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.OK, "successful!")).build();
        } catch (Exception Ex) {
            return Response.status(500).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, Ex.getMessage())).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response updatePayment(String umUserHash, String umSessionId, String umDomain, long paymentId, Payment payment, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        PaymentDAO pDAO = null;
        try {
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
            int result = pDAO.UpdatePayment(paymentId, payment.getPaymentDate(),
                    payment.getCustomerId(), payment.getPrepaidServiceId(),
                    payment.getPostpaidServiceId(),
                    payment.getReconciled().name(),
                    payment.getReconciledMethod().name(),
                    payment.getProvisionedEquipment().name(),
                    payment.getPaymentReferenceNumber(),
                    payment.getCreditBeforePayment(),
                    payment.getCreditAfterPayment(),
                    payment.getCostOfPaymentMethod(),
                    payment.getNameOfBackOfficeOperator(),
                    payment.getRevoked().toString(), payment.getBankName(),
                    payment.getValue(), payment.getNote(),
                    payment.getPaymentMethod().name(),
                    payment.getPaymentStatus(),
                    payment.getElectronicReference(),
                    payment.getTreasuryAccounts().name(),
                    payment.getPaidService().name());
            /*
             if (result != 1) {
             throw new Exception();
             }*/
            if (result < 1) {
                return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.INFO, "No row was updated!")).build();
            }

            HDBResource.put(payment, "payments", "update");

            return Response.status(200).entity(payment).build();
        } catch (Exception Ex) {
            return Response.status(500).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, Ex.getMessage())).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response updateTaxType(String umUserHash, String umSessionId, String umDomain, long taxTypeId, TaxType taxType, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        PaymentDAO pDAO = null;
        try {
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
            long taxTypeResult = pDAO.updateTaxType(taxTypeId, taxType.getDescription(), taxType.getPercentage());

            if (taxTypeResult < 1) {
                return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.INFO, "No row was updated!")).build();
            }
            HDBResource.put(taxType, "tax_types", "update");

            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "successful!")).build();
        } catch (RuntimeException ex) {
            return Response.status(500).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Error!")).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response updateTeloAgentProfitConfig(String umUserHash, String umSessionId, String umDomain, Long teloAgentId, TeloAgentProfitConfig contract, SecurityContext securityContext) throws NotFoundException {

        try {
            //     AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.serverError().build();
        }
        PaymentDAO paymentsDAO = null;
        try {
            DBI dbi = new DBI(DBResource.getDataSource());
            paymentsDAO = dbi.open(PaymentDAO.class);
            long teloAgentProfitResult = paymentsDAO.createTeloAgentProfitConfig(contract.getStartAmount(),
                    contract.getEndAmount(),
                    contract.getProfitPercentage(),
                    teloAgentId);

            if (teloAgentProfitResult < 1) {
                return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.INFO, "No row was updated!")).build();
            }
            HDBResource.put(contract, "telo_agent_profit_config", "update");

        } catch (RuntimeException ex) {
            return Response.serverError().status(503).build();
        } finally {
            if (paymentsDAO != null) {
                paymentsDAO.close();
            }
        }
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully updated!")).build();
    }

    @Override
    public Response updateTeloOperatorProfitConfig(String umUserHash, String umSessionId, String umDomain, Long id, TeloOperatorProfitConfig teloOperatorProfitConfig, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.serverError().build();
        }
        PaymentDAO pDAO = null;
        try {
            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
            long teloProfitConfigResult = pDAO.updateTeloOperatorProfitConfig(teloOperatorProfitConfig.getEndAmount(), teloOperatorProfitConfig.getProfitPercentage(), id);

            if (teloProfitConfigResult < 1) {
                return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.INFO, "No row was updated!")).build();
            }

            HDBResource.put(teloOperatorProfitConfig, "telo_operators", "update");

            return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.OK, "successful!")).build();
        } catch (RuntimeException ex) {

            return Response.serverError().build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    @Override
    public Response searchTeloAgent(String umUserHash, String umSessionId, String umDomain, Long offset, Long limit, long prepaidServiceId, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        PaymentDAO pDAO = null;
        try {

            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);

            //set default values if pagination fields are empty
            if (limit == null) {
                limit = 20L;
            }
            if (offset == null) {
                offset = 0L;
            }
            List<Map> contract_prepaid = pDAO.searchTeloAgent(prepaidServiceId);
            pDAO.close();
            if (contract_prepaid.size() > 0) {
                return Response.ok().entity(contract_prepaid.get(0)).build();
            } else {
                return Response.ok().entity(contract_prepaid).build();
            }
        } catch (Exception ex) {
            if (pDAO != null) {
                pDAO.close();
            }
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
    }

    private static final HashMap<String, Integer> valueMap;
    private static final HashMap<String, String[]> readingTrack;
    private static final HashMap<String, int[]> controlMap;

    //Initialize parameters to help parsing and interpreting upload files for different banks
    static {
        valueMap = new HashMap();
        valueMap.put("BFA", 5);
        valueMap.put("Millenium", 5);
        valueMap.put("Atlantico", 4);
        valueMap.put("BAI", 4);
        valueMap.put("BIC", 5);
        valueMap.put("SOL", 4);

        String[] bfaHeaders = {"DATA MOV.", "NUM. OPER.", "NUM. DOC.", "DATA VALOR", "DESCRIÇÃO", "VALOR", "SALDO CONTABILÍSTICO", "MOEDA"};
        String[] atlanticoHeaders = {"Data", "Data valor", "Operação", "Descrição", "Valor", "Saldo", "Moeda"};
        String[] bicHeaders = {"Data Mov.", "Operação", "Nº Documento", "Data Valor", "Descrição", "Montante", "Saldo", "Moeda"};
        String[] baiHeaders = {"DATA MOV.", "N.º DA OPERAÇÃO", "DATA VALOR", "DESCRIÇÃO", "VALOR A TRANSFERIR", "MOEDA", "SALDO", "MOEDA"};
        String[] millenuimHeaders = {"Número do cartão/conta", "DATA", "REFERENCIA", "DT_VALOR", "DESCRICAO1", "MONTANTE", "SALDO", "MOEDA"};
        String[] solHeaders = {"DATA MOV.", "NUM. OPER.", "DATA VALOR", "DESCRIÇÃO", "MONTANTE", "MOEDA", "SALDO", "MOEDA"};

        readingTrack = new HashMap();
        readingTrack.put("BFA", bfaHeaders);
        readingTrack.put("Millenium", millenuimHeaders);
        readingTrack.put("Atlantico", atlanticoHeaders);
        readingTrack.put("BAI", baiHeaders);
        readingTrack.put("BIC", bicHeaders);
        readingTrack.put("SOL", solHeaders);

        //date,valueDate,operataionId,description,referenceNumber,value //Column indexes corresponding to each bank file
        int[] bfaControl = {0, 3, 1, 4, 2, 5}; //**
        int[] milliniumControl = {1, 3, 2, 4, 2, 5}; //**
        int[] atlanticoControl = {0, 1, 2, 3, 2, 4};//**
        int[] baiControl = {0, 2, 1, 3, 1, 4}; //**
        int[] bicControl = {0, 3, 1, 4, 2, 5}; //**
        int[] solControl = {0, 2, 1, 3, 1, 4}; //**

        controlMap = new HashMap();
        controlMap.put("BFA", bfaControl);
        controlMap.put("Millenium", milliniumControl);
        controlMap.put("Atlantico", atlanticoControl);
        controlMap.put("BAI", baiControl);
        controlMap.put("BIC", bicControl);
        controlMap.put("SOL", solControl);
    }

    @Override
    public Response confirmBankStatement(String umUserHash, String umSessionId, String umDomain, String fileId, String bankName, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.status(401).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        PaymentDAO pDAO = null;
        try {

            pDAO = JdbiHelper.getDBI().open(PaymentDAO.class);
            String uploadedFileLocation = "/tmp/";
            String filename = new StringBuilder(uploadedFileLocation).append(fileId).toString();
            File activeFile = new File(filename);

            if (filename.toLowerCase().endsWith(".csv")) {
                confirmCSVStatement(bankName, activeFile, pDAO);
            }

            if (filename.toLowerCase().endsWith(".xlsx")) {
                confirmExcelStatement(bankName, activeFile, pDAO);
            }

            activeFile.delete();

        } catch (RuntimeException | IOException | ParseException ex) {
            // ex.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } finally {
            if (pDAO != null) {
                pDAO.close();
            }
        }
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "successful!")).build();
    }

    private void confirmCSVStatement(String bankName, File activeFile, PaymentDAO pDAO) throws FileNotFoundException, ParseException, NumberFormatException, IOException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date, referenceNumber, value, description, valueDate;
        int[] activeControl = controlMap.get(bankName);
        CSVReader reader = new CSVReader(new FileReader(activeFile));
        String[] nextLine;
        boolean reading = false;
        String trackLine = (String) readingTrack.get(bankName)[0];
        while ((nextLine = reader.readNext()) != null) {
            if (!reading && nextLine[0].equals(trackLine)) {
                reading = true;
                continue;
            }
            if (reading) {
                value = nextLine[activeControl[5]].replace(".", "").replace(",", "").replace("+", "");
                //Skip negative values
                if (Double.parseDouble(value) < 0) {
                    continue;
                }
                valueDate = nextLine[activeControl[1]];
//                    operataionId = nextLine[activeControl[2]];
                date = nextLine[activeControl[0]];
                referenceNumber = nextLine[activeControl[4]];

                description = nextLine[activeControl[3]];

                //Craete the payment
                Payment paymentRecord = new Payment();
                paymentRecord.setBankName(bankName);
                paymentRecord.setPaymentDate(df.parse(date));
                paymentRecord.setValue(Double.valueOf(value));
                paymentRecord.setPaymentMethod(Payment.PaymentMethodEnum.BORDEREAU);
                paymentRecord.setElectronicReference(referenceNumber);
                paymentRecord.setTreasuryAccounts(Payment.TreasuryAccountsEnum.BORDEREAU);
                paymentRecord.setReconciled(Payment.ReconciledEnum.NO);
                paymentRecord.setDescription(description);
                paymentRecord.setRevoked(Payment.RevokedEnum.NO);
                paymentRecord.setPaymentStatus("NEW");

                //Test values
                paymentRecord.setPaidService(Payment.PaidServiceEnum.POSTPAID);
                paymentRecord.setProvisionedEquipment(Payment.ProvisionedEquipmentEnum.PSP);
                paymentRecord.setReconciledMethod(Payment.ReconciledMethodEnum.MANUAL);

                pDAO.createPayment(paymentRecord.getPaymentDate(), paymentRecord.getCustomerId(), paymentRecord.getPrepaidServiceId(), paymentRecord.getPostpaidServiceId(), paymentRecord.getReconciled().name(), paymentRecord.getReconciledMethod().name(), paymentRecord.getProvisionedEquipment().name(), paymentRecord.getPaymentReferenceNumber(), paymentRecord.getCreditBeforePayment(), paymentRecord.getCreditAfterPayment(), paymentRecord.getCostOfPaymentMethod(), paymentRecord.getNameOfBackOfficeOperator(), paymentRecord.getRevoked().name(), paymentRecord.getBankName(), paymentRecord.getValue(), paymentRecord.getNote(), paymentRecord.getPaymentMethod().name(), paymentRecord.getPaymentStatus(), paymentRecord.getElectronicReference(), paymentRecord.getTreasuryAccounts().name(), paymentRecord.getPaidService().name(), paymentRecord.getDescription());
//                    paymentRecord.setPaymentId(paymentId);

//                    HDBResource.put(paymentRecord, "payments", "create");
            }
        }
    }

    private void confirmExcelStatement(String bankName, File activeFile, PaymentDAO pDAO) throws FileNotFoundException, ParseException, NumberFormatException, IOException, RuntimeException {
//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String referenceNumber, description;
        int[] activeControl = controlMap.get(bankName);
        String[] dataHeaderColNames = readingTrack.get(bankName);
        String trackLine = (String) dataHeaderColNames[0];
        boolean reading = false;
        XSSFSheet excelSheet;
        //Using try with resources for auto close cleanup
        try (XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(activeFile))) {

            //Get desired sheet from the workbook
            excelSheet = wb.getSheetAt(0);
            final Iterator<Row> rowIterator = excelSheet.iterator();
            // Skip HEADER_ROWS rows
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //Locate the header rows
                final Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                if (!reading && cellIterator.next().getStringCellValue().equals(trackLine)) {

                    int header = 1;
                    while (cellIterator.hasNext()) {
                        cell = cellIterator.next();
                        if (cell.getStringCellValue().compareTo(dataHeaderColNames[header]) != 0) {
                            throw new RuntimeException("Invalid file format: invalid data header: expected " + dataHeaderColNames[header] + ", "
                                    + "found " + cell.getStringCellValue());
                        }
                        header++;
                    }
                    reading = true;
                    continue;
                }
                if (reading) {
//                    value = row.getCell(activeControl[5]).getStringCellValue().replace(".", "").replace(",", "").replace("+", "");

                    double opValue = 0;
                    if (row.getCell(activeControl[5]).getCellTypeEnum() == CellType.NUMERIC) {
                        opValue = row.getCell(activeControl[5]).getNumericCellValue();
                    } else {
                        String v = row.getCell(activeControl[5]).getStringCellValue().replace(".", "").replace(",", "").replace("+", "");
                        opValue = Double.valueOf(v);
                    }

                    //Skip negative values
                    if (opValue < 0) {
                        continue;
                    }
                    cell = row.getCell(activeControl[1]);
                    Date dateCellValue = cell.getDateCellValue();

                    cell = row.getCell(activeControl[4]);
                    referenceNumber = cell.getCellTypeEnum() == CellType.NUMERIC
                            ? String.valueOf(cell.getNumericCellValue()) : cell.getStringCellValue();

                    //Craete the payment
                    Payment paymentRecord = new Payment();
                    paymentRecord.setBankName(bankName);
                    paymentRecord.setPaymentDate(row.getCell(activeControl[0]).getDateCellValue());
                    paymentRecord.setValue(opValue);
                    paymentRecord.setPaymentMethod(Payment.PaymentMethodEnum.BORDEREAU);
                    paymentRecord.setElectronicReference(referenceNumber);
                    paymentRecord.setTreasuryAccounts(Payment.TreasuryAccountsEnum.BORDEREAU);
                    paymentRecord.setReconciled(Payment.ReconciledEnum.NO);
                    paymentRecord.setDescription(row.getCell(activeControl[3]).getStringCellValue());
                    paymentRecord.setRevoked(Payment.RevokedEnum.NO);
                    paymentRecord.setPaymentStatus("NEW");

                    //Test values
                    paymentRecord.setPaidService(Payment.PaidServiceEnum.POSTPAID);
                    paymentRecord.setProvisionedEquipment(Payment.ProvisionedEquipmentEnum.PSP);
                    paymentRecord.setReconciledMethod(Payment.ReconciledMethodEnum.MANUAL);
                    pDAO.createPayment(paymentRecord.getPaymentDate(), paymentRecord.getCustomerId(), paymentRecord.getPrepaidServiceId(), paymentRecord.getPostpaidServiceId(), paymentRecord.getReconciled().name(), paymentRecord.getReconciledMethod().name(), paymentRecord.getProvisionedEquipment().name(), paymentRecord.getPaymentReferenceNumber(), paymentRecord.getCreditBeforePayment(), paymentRecord.getCreditAfterPayment(), paymentRecord.getCostOfPaymentMethod(), paymentRecord.getNameOfBackOfficeOperator(), paymentRecord.getRevoked().name(), paymentRecord.getBankName(), paymentRecord.getValue(), paymentRecord.getNote(), paymentRecord.getPaymentMethod().name(), paymentRecord.getPaymentStatus(), paymentRecord.getElectronicReference(), paymentRecord.getTreasuryAccounts().name(), paymentRecord.getPaidService().name(), paymentRecord.getDescription());
//                    paymentRecord.setPaymentId(paymentId);

//                    HDBResource.put(paymentRecord, "payments", "create");
                }
            }
        }
    }

    @Override
    public Response uploadBankStatement(String umUserHash, String umSessionId, String umDomain, String bankName, InputStream statementFileInputStream, FormDataContentDisposition statementFileDetail, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            return Response.serverError().build();
        }

        StatementSummary st = null;
        try {

            String filename = UUID.randomUUID() + statementFileDetail.getFileName();
            String uploadedFileLocation = new StringBuilder("/tmp/").append(filename).toString();

            // save it
            writeToFile(statementFileInputStream, uploadedFileLocation);

            if (filename.toLowerCase().endsWith(".csv")) {
                st = processCSV(uploadedFileLocation, bankName, st, filename);
            }

            if (filename.toLowerCase().endsWith(".xlsx")) {

                st = processExcel(uploadedFileLocation, bankName, st, filename);
            }

        } catch (RuntimeException ex) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } catch (IOException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
        }
        return Response.status(200).entity(st).build();
    }

    private StatementSummary processCSV(String uploadedFileLocation, String bankName, StatementSummary st, String filename) throws FileNotFoundException, NumberFormatException, IOException {
        CSVReader reader = new CSVReader(new FileReader(uploadedFileLocation));
        int valueIndex = valueMap.get(bankName);
        int noOfEntries = 0;
        double totalSum = 0d;
        //Read CSV line by line and use the string array as you want
        String[] nextLine;
        boolean reading = false;
        String trackLine = (String) readingTrack.get(bankName)[0];
        while ((nextLine = reader.readNext()) != null) {
            if (!reading && nextLine[0].equals(trackLine)) {
                reading = true;
                continue;
            }
            if (reading) {
                String v = nextLine[valueIndex].replace(".", "").replace(",", "").replace("+", "");

                //Skip negative values
                if (Double.parseDouble(v) < 0) {
                    continue;
                }

                totalSum += Double.valueOf(v);
                noOfEntries++;
            }
        }
        st = new StatementSummary();
        st.setBankName(bankName);
        st.setDescription("Description");
        st.setFileId(filename);
        st.setNumberOfEntries(noOfEntries);
        st.setTotalSum(new BigDecimal(totalSum).setScale(2, RoundingMode.HALF_UP).doubleValue());
        return st;
    }

    /**
     * loadFile: load file contents Deprecated warnings suppressed due to Apache
     * POI getCellType and getCellTypeEnum deprecation
     */
    @SuppressWarnings("deprecation")
    private StatementSummary processExcel(String uploadedFileLocation, String bankName, StatementSummary st, String filename) throws FileNotFoundException, NumberFormatException, IOException, RuntimeException {

        int valueIndex = valueMap.get(bankName);
        int noOfEntries = 0;
        double totalSum = 0d;
        boolean reading = false;
        String[] dataHeaderColNames = readingTrack.get(bankName);
        String trackLine = (String) dataHeaderColNames[0];

        XSSFSheet excelSheet;
        //Using try with resources for auto close cleanup
        try (XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(uploadedFileLocation))) {
            //Get desired sheet from the workbook
            excelSheet = wb.getSheetAt(0);
            final Iterator<Row> rowIterator = excelSheet.iterator();
            // Skip HEADER_ROWS rows

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //Locate the header rows
                final Iterator<Cell> cellIterator = row.cellIterator();

                if (!reading && cellIterator.next().getStringCellValue().equals(trackLine)) {
                    Cell cell;
                    int header = 1;
                    while (cellIterator.hasNext()) {
                        cell = cellIterator.next();
                        if (cell.getStringCellValue().compareTo(dataHeaderColNames[header]) != 0) {
                            throw new Exception("Invalid file format: invalid data header: expected " + dataHeaderColNames[header] + ", "
                                    + "found " + cell.getStringCellValue());
                        }
                        header++;
                    }
                    reading = true;
                    continue;
                }
                if (reading) {
                    double opValue;
                    if (row.getCell(valueIndex).getCellTypeEnum() == CellType.NUMERIC) {
                        opValue = row.getCell(valueIndex).getNumericCellValue();
                    } else {
                        String v = row.getCell(valueIndex).getStringCellValue().replace(".", "").replace(",", "").replace("+", "");
                        opValue = Double.valueOf(v);
                    }
                    //Skip negative values
                    if (opValue < 0) {
                        continue;
                    }
                    totalSum += opValue;
                    noOfEntries++;

                }

            }

            st = new StatementSummary();
            st.setBankName(bankName);
            st.setDescription("Description");
            st.setFileId(filename);
            st.setNumberOfEntries(noOfEntries);
            st.setTotalSum(new BigDecimal(totalSum).setScale(2, RoundingMode.HALF_UP).doubleValue());

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage()+"Problem encountered while processing ");

        } finally {
           
        }

        return st;
    }

    // save uploaded file to new location
    private void writeToFile(InputStream uploadedInputStream,
            String uploadedFileLocation) throws IOException {

        try {
            OutputStream out;
            int read;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            throw e;

        }

    }

    @Override
    public Response returnBalanceOfTeloAgent(String umUserHash, String umSessionId, String umDomain, TeloAgents telo, long prepaidServiceId, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssPaymentsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        PaymentDAO bssDAO = null;
        try {

            bssDAO = JdbiHelper.getDBI().open(PaymentDAO.class);

            long prepaidservices = bssDAO.findTeloAgentBalance(prepaidServiceId);
            bssDAO.close();
            if (prepaidservices > 0) {
                return Response.ok().entity(prepaidservices).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

        } catch (Exception ex) {
            Logger.getLogger(BssPaymentsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            if (bssDAO != null) {
                bssDAO.close();
            }
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }

    }
}
