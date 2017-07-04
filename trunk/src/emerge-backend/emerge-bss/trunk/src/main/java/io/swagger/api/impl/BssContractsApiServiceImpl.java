package io.swagger.api.impl;

import com.emerge.bss.auth.AccessControl;
import com.emerge.bss.crud.ContractDAO;
import com.emerge.bss.crud.mappers.PrepaidServiceMapper;
import com.emerge.bss.database.history.HDBResource;
import com.emerge.bss.util.JdbiHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.api.*;
import io.swagger.model.ContractTemplate;
import io.swagger.model.ContractPostpaid;
import io.swagger.model.ContractPrepaid;
import io.swagger.model.ServicePrepaid;
import io.swagger.model.ProductPostpaid;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.swagger.api.NotFoundException;
import io.swagger.model.PayphoneService;
import io.swagger.model.Product;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.json.simple.JSONObject;
import org.skife.jdbi.v2.sqlobject.Transaction;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-21T13:42:52.506Z")
public class BssContractsApiServiceImpl extends BssContractsApiService {

    public final String MAIN = "MAIN";
    public final String SUPPLEMENT = "SUPPLEMENT";

    @Override
    public Response bssProvisionContractsTemplatesGet(String umUserHash, String umSessionId, String umDomain, long limit, long offset, long templateId, String templateDescription, String createdBy, String content, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).
                    entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        //JSONArray a = new JSONArray();
        ContractDAO bssDAO = null;
        try {

            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            //set default values if pagination fields are empty
            limit = limit == 0 ? 20 : limit;
            offset = offset == 0 ? 0 : offset;
            List<Map> contract_temp = bssDAO.findContractTemplate(templateId, templateDescription, createdBy, content, offset, limit);
            bssDAO.close();
//            if (contract_temp.size() > 0) {
//                return Response.ok().entity(contract_temp.get(0)).build();
//            } else {
//                return Response.ok().entity(contract_temp).build();
//            }
            JSONObject o = new JSONObject();
            o.put("data", contract_temp);
            bssDAO.close();
            return Response.ok().entity(o).build();
            //   return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, list.toString())).build();
        } catch (Exception ex) {

            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {

            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response bssProvisionCustomersCustomerIdContractsPostpaidGet(String umUserHash, String umSessionId, String umDomain, long customerId, long id, long offset, long limit, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }

        //Validate role
//        JSONArray a = new JSONArray();
        ContractDAO bssDAO = null;
        try {

            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            //set default values if pagination fields are empty
            limit = limit == 0 ? 20 : limit;
            offset = offset == 0 ? 0 : offset;
            List<Map> contract_prepaid = bssDAO.findPostpaidContractsByContractsId(id, offset, limit);
            bssDAO.close();
            if (contract_prepaid.size() > 0) {
                return Response.ok().entity(contract_prepaid.get(0)).build();
            } else {
                return Response.ok().entity(contract_prepaid).build();
            }
        } catch (Exception ex) {

            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response bssProvisionCustomersCustomerIdContractsPrepaidContractIdGet(String umUserHash, String umSessionId, String umDomain, long customerId, long contractId, long offset, long limit, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }

        //Validate role
        ContractDAO bssDAO = null;
        try {

            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            //set default values if pagination fields are empty
            limit = limit == 0 ? 20 : limit;
            offset = offset == 0 ? 0 : offset;
            List<Map> contract_prepaid = bssDAO.findPrepaidContractsByContractsId(contractId, customerId);
            bssDAO.close();
            if (contract_prepaid.size() > 0) {
                return Response.ok().entity(contract_prepaid.get(0)).build();
            } else {
                return Response.ok().entity(contract_prepaid).build();
            }
        } catch (Exception ex) {

            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response bssProvisionCustomersCustomerIdContractsPrepaidGet(String umUserHash, String umSessionId, String umDomain, long customerId, String contractType, String status, Date creationDate, String serviceType, long offset, long limit, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }

        //Validate role
        ContractDAO bssDAO = null;
        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            //set default values if pagination fields are empty
            limit = limit == 0 ? 20 : limit;
            offset = offset == 0 ? 0 : offset;
            //creationDate = "2016-11-10";
            long count = bssDAO.getPrepaidContractsCount(customerId, serviceType, status, creationDate);

            List<Map> contractprepaid = bssDAO.findPrepaidContractsByCustomerId(customerId, serviceType, status, creationDate, offset, limit);
            JSONObject o = new JSONObject();
            o.put("count", count);
            o.put("data", contractprepaid);
            bssDAO.close();
            return Response.ok().entity(o).build();
        } catch (Exception ex) {
            Logger.getLogger(BssPaymentsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);

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

    @Override
    public Response bssProvisionServicesPrepaidGet(String umUserHash, String umSessionId, String umDomain, long limit, long offset, String type, String status, String external_provision_id, Date creation_date, Date modification_date, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssPaymentsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {

            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            //set default values if pagination fields are empty
            limit = limit == 0 ? 20 : limit;
            offset = offset == 0 ? 0 : offset;
            List<PrepaidServiceMapper> prepaidservices = bssDAO.findAllPrepaidServices(type, status, external_provision_id, creation_date, modification_date, offset, limit);
            long total = bssDAO.getPrepaidServicesCount(type, status, external_provision_id, creation_date, modification_date);
            JSONObject o = new JSONObject();
            o.put("total", total);
            o.put("data", prepaidservices);
            bssDAO.close();
            return Response.ok().entity(o).build();
//            if (prepaidservices.size() > 0) {
//                return Response.ok().entity(prepaidservices.toString()).build();
//            } else {
//                return Response.ok().entity(prepaidservices).build();
//            }
//              return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, list.toString())).build();
        } catch (Exception ex) {
            Logger.getLogger(BssPaymentsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public Response confirmContract(String umUserHash, String umSessionId, String umDomain, long customerId, long id, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }

        ContractDAO bssDAO = null;
        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            Date d = Calendar.getInstance().getTime();
            bssDAO.confirmcontract("ACTIVE", id, customerId, d);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Contract confirmed")).build();
        } catch (Exception ex) {

            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }

    }

    @Override
    public Response createContractPrepaid(String umUserHash, String umSessionId, String umDomain, long customerId, ContractPrepaid contract, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        if (contract.getContent() == null) {

            JSONObject ob = new JSONObject();
            ob.put("message", "Missing attribute");
            ob.put("data", contract);
            return Response.status(Response.Status.BAD_REQUEST).entity(ob).build();
        }
        ContractDAO bssDAO = null;
        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            if (contract.getServiceType().name().equals("TELOAGENT")) {

                if (bssDAO.confirmIfTeloAgentContractExists(customerId, contract.getServiceType().name())) {
                    return Response.status(Response.Status.BAD_REQUEST).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Customer already have an existing TELOAGENT contract")).build();
                }

            }
            long serviceId = contract.getServicePrepaid();
            if (!bssDAO.checkIfServiceExists(serviceId)) {

                long contractId = bssDAO.createPrepaidContract(MAIN, contract.getServicePrepaid(), contract.getCustomerId(), contract.getStatusDate(), contract.getStartDate(), contract.getContent(), contract.getAutomaticRenewal(), contract.getServiceType().name()); //serviceid and customerid
                bssDAO.updateServiceStatus(serviceId);
                
          
                
                contract.setContractId(contractId);

                HDBResource.put(contract, "contract_prepaid", "create");

                return Response.ok().entity(contract).build();
            } else {
                long custId = bssDAO.findCustomerId(serviceId);
                return Response.status(Response.Status.BAD_REQUEST).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "This Service has already been associated to customer with id " + custId)).build();
            }
        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();

        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response createContractTemplate(String umUserHash, String umSessionId, String umDomain, ContractTemplate contract, SecurityContext securityContext) throws NotFoundException {

        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            Date d = Calendar.getInstance().getTime();
            long contractId = bssDAO.createContractTemplate(contract.getName(), contract.getDescription(), contract.getContractType().name(), contract.getContent(), contract.getCreatedBy(), contract.getCreationDate(), contract.getModificationDate());
            contract.setContractTemplateId(contractId);
            HDBResource.put(contract, "contract_template", "create");

            return Response.ok().entity(contract).build();
        } catch (Exception ex) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response createPostpaidContract(String umUserHash, String umSessionId, String umDomain, long customerId, ContractPostpaid contract, SecurityContext securityContext) throws NotFoundException {

        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }

        ContractDAO bssDAO = null;

        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            long Id = bssDAO.createPostpaidContract(MAIN, contract.getAllowJointBilling(), contract.getCustomerId(), contract.getBillingPeriod().name(), contract.getBillingDay(), contract.getStatusDate(), contract.getSecondContractorName(), contract.getSecondContractorFiscalNumber(), contract.getSecondContractorAddress(), contract.getStartDate(), contract.getEndDate(), contract.getPreamble(), contract.getClauses(), contract.getExpirationCondition(), "Telo Pay", contract.getGoodsAndServices());
            contract.setContractId(Id);
            HDBResource.put(contract, "contract_postpaid", "create");

            return Response.ok().entity(contract).build();

        } catch (RuntimeException ex) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();

        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response createPostpaidService(String umUserHash, String umSessionId, String umDomain, ProductPostpaid postpaidService, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO contractsDAO = null;
        try {
            contractsDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            contractsDAO.createPostpaidService(postpaidService.getExternalProvisionId(), postpaidService.getUnitPrice());
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            ex.getMessage())).build();
        } finally {
            if (contractsDAO != null) {
                contractsDAO.close();
            }
        }
        return Response.ok().entity(new ApiResponseMessage(
                ApiResponseMessage.OK, "Successfully created!")).build();
    }

    @Override
    public final Response createPrepaidService(final String umUserHash,
            final String umSessionId, final String umDomain,
            final ServicePrepaid prepaidService,
            final SecurityContext securityContext) throws NotFoundException {

        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain,
                    securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(
                    new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Unauthorized!")).build();
        }

        ContractDAO contractsDAO = null;
        try {
            contractsDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            if ((prepaidService.getServiceType().equals(
                    ServicePrepaid.ServiceTypeEnum.TELOOPERATOR)
                    && prepaidService.getIsLegacy())
                    || prepaidService.getServiceType().equals(
                            ServicePrepaid.ServiceTypeEnum.TEC)
                    || prepaidService.getServiceType().equals(
                            ServicePrepaid.ServiceTypeEnum.PSP)) {
                if (prepaidService.getExternalProvisionId() == null || prepaidService.getExternalProvisionId().trim().isEmpty()) {
                    return Response.status(Response.Status.BAD_REQUEST).
                            entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                    "ExternalProvisioningId cannot be null for "
                                    + "the selected service type")).build();
                }
            }

            long prepaidServiceId = createPrepaidService(contractsDAO,
                    prepaidService);

            prepaidService.setServicePrepaidId(prepaidServiceId);
            //     HDBResource.put(prepaidService, "contract_post", "create");
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            ex.getMessage())).build();
        } finally {
            if (contractsDAO != null) {
                contractsDAO.close();
            }
        }

        return Response.ok().entity(prepaidService).build();
    }

    private PayphoneService provisionPayphone(
            final ServicePrepaid prepaidService,
            final String urlString,
            final String method) throws Exception {
        PayphoneService payphoneService = prepaidService.getPayphoneService();
        HttpURLConnection conn = null;
        try {
            URL url = new URL("http://lx-dev-emea-emerge-ws-tc-01:8080/"
                    + "emerge-ocs-provision/v1/provision/" + urlString);

            url.getHost();
            //lx-dev-emea-emerge-ws-tc-01:8080
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", "application/json");
            if ("POST".equals(method) || "PUT".equals(method)) {
                try (OutputStream os = conn.getOutputStream()) {
                    String params = (new ObjectMapper()).writeValueAsString(
                            prepaidService.getPayphoneService());

                    os.write(params.getBytes());
                    os.flush();

                }
            }

            if (conn.getResponseCode()
                    < Response.Status.BAD_REQUEST.getStatusCode()) {

                payphoneService = ((new ObjectMapper()).readValue(
                        conn.getInputStream(), PayphoneService.class));
            }
        } catch (MalformedURLException ex) {

            throw ex;
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

        return payphoneService;
    }

    @Transaction
    private long createPrepaidService(ContractDAO contractsDAO, ServicePrepaid prepaidService) throws Exception {

        if (prepaidService.getServiceType().equals(
                ServicePrepaid.ServiceTypeEnum.TELOOPERATOR)
                && !prepaidService.getIsLegacy()) {

            PayphoneService payphoneService
                    = provisionPayphone(prepaidService,
                            "payphone-services", "POST");
            if (payphoneService.getId() == 0L) {
                throw new Exception();
            } else {
                prepaidService.setPayphoneService(payphoneService);
                prepaidService.setExternalProvisionId(
                        String.valueOf(payphoneService.getId()));
            }
        }

        long id = contractsDAO.createPrepaidService(
                prepaidService.getExternalProvisionId(),
                prepaidService.getName(),
                prepaidService.getServiceType().name(),
                prepaidService.getProductId()
        );
        prepaidService.setServicePrepaidId(id);
        HDBResource.put(prepaidService, "contract_post", "create");
        if (prepaidService.getServiceType().equals(
                ServicePrepaid.ServiceTypeEnum.TELOAGENT)) {

            contractsDAO.createTeloAgent(
                    prepaidService.getServicePrepaidId(), 0);

        } else if (prepaidService.getServiceType().equals(
                ServicePrepaid.ServiceTypeEnum.TELOOPERATOR)) {

            contractsDAO.createTeloOperator(
                    prepaidService.getExternalProvisionId(),
                    prepaidService.getIsLegacy(),
                    prepaidService.getServicePrepaidId());
        }

        return prepaidService.getServicePrepaidId();
    }

    @Override
    public Response deleteContractTemplate(String umUserHash, String umSessionId, String umDomain, long id, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            List<Map> customerTemplates = bssDAO.findContractTemplate(id, "", "", "", 0, 1);

            if (customerTemplates.size() < 1) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            bssDAO.deleteContractTemplate(id);

            ContractTemplate template = (ContractTemplate) customerTemplates.get(0);

            HDBResource.put(template, "contract_templates", "delete");

            return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully deleted!")).build();

        } catch (RuntimeException ex) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();

        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response deletePostPaidService(String umUserHash, String umSessionId, String umDomain, long id, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO contractsDAO = null;
        try {
            contractsDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            contractsDAO.deletePostpaidService(id);
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully Deleted!")).build();

        } catch (RuntimeException ex) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();

        } finally {
            if (contractsDAO != null) {
                contractsDAO.close();
            }
        }
    }

    @Override
    public Response deletePostpaidContract(String umUserHash, String umSessionId, String umDomain, long customerId, long id, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            List<Map> postPaidContracts = bssDAO.findPostpaidContractsByContractsId(id, 0, 1);

            if (postPaidContracts.size() < 1) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            bssDAO.deletePostpaidContract(id, customerId);

            ContractPostpaid postpaid = (ContractPostpaid) postPaidContracts.get(0);

            HDBResource.put(postpaid, "postpaid_contracts", "delete");

            return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully deleted!")).build();

        } catch (RuntimeException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response deletePrepaidContract(String umUserHash, String umSessionId, String umDomain, long customerId, long serviceId, long contractId, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            List<Map> prePaidContracts = bssDAO.findPrepaidContractsByContractsId(contractId, customerId);

            if (prePaidContracts.size() < 1) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            bssDAO.deletePrepaidContract(contractId, customerId);

            bssDAO.removeService(serviceId);

            ContractPrepaid prepaid = (ContractPrepaid) prePaidContracts.get(0);

            HDBResource.put(prepaid, "prepaid_contracts", "delete");

            return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully deleted!")).build();

        } catch (RuntimeException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();

        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }

        }
    }

    @Override
    public Response deletePrepaidService(String umUserHash, String umSessionId, String umDomain, long id, ServicePrepaid prepaidservice, SecurityContext securityContext) throws NotFoundException {

        try {

            //Add missing params in the swagger delete customer API
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO contractsDAO = null;
        try {
            contractsDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            List<ServicePrepaid> prepaidServices
                    = contractsDAO.findPrepaidServiceById(id);

            if (prepaidServices.size() < 1) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            if (contractsDAO.confirmAssociation(id)) {
                return Response.status(Response.Status.BAD_REQUEST).
                        entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Active service cannot be deleted")).build();
            }

            contractsDAO.deletePrepaidService(id, prepaidservice.getDeletedReason(), "DELETED");

            ServicePrepaid servicePrepaid = (ServicePrepaid) prepaidServices.get(0);

            HDBResource.put(servicePrepaid, "prepaid_services", "delete");

            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully Deleted!")).build();

        } catch (RuntimeException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();

        } finally {
            if (contractsDAO != null) {
                contractsDAO.close();
            }
        }
    }

    @Override
    public Response getPostpaidProducts(String umUserHash, String umSessionId, String umDomain, long limit, long customerId, long contractId, long offset, String postpaidService, SecurityContext securityContext) throws NotFoundException {
        // do some successful!
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "successful!")).build();
    }

    /*
    
    ServicePrepaid prepaidService = null;
            if (prepaidService.getServiceType().equals("TELOOPERATOR")) {
                
                if (!prepaidService.getIsLegacy()) {
                    PayphoneService payphoneService
                            = provisionPayphone(prepaidService,
                                    "payphone-services/", "GET");
                }
            }

     */
    @Override
    public Response getPrepaidService(String umUserHash, String umSessionId,
            String umDomain, long id, SecurityContext securityContext)
            throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain,
                    securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssPaymentsApiServiceImpl.class.getName()).log(
                    Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {

            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            List<ServicePrepaid> prepaidservices
                    = bssDAO.findPrepaidServiceById(id);
            bssDAO.close();
            if (prepaidservices.size() > 0) {
                ServicePrepaid prepaidService = prepaidservices.get(0);
                if (prepaidService.getServiceType().equals(
                        ServicePrepaid.ServiceTypeEnum.TELOOPERATOR)
                        && !prepaidService.getIsLegacy()) {

                    PayphoneService payphoneService = provisionPayphone(
                            prepaidService, "payphone-services/id/"
                            + prepaidService.getExternalProvisionId(),
                            "GET");

                    if (payphoneService == null
                            || payphoneService.getId() == 0L) {
                        return Response.status(Response.Status.NOT_FOUND)
                                .entity(new ApiResponseMessage(
                                        ApiResponseMessage.ERROR,
                                        "NOT_FOUND")).build();
                    }

                    prepaidService.setPayphoneService(payphoneService);
                }

                return Response.ok().entity(prepaidService).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponseMessage(
                                ApiResponseMessage.ERROR,
                                "NOT_FOUND")).build();
            }

        } catch (Exception ex) {
            Logger.getLogger(BssPaymentsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }

    }

    @Override
    public Response updateContractTemplate(String umUserHash, String umSessionId, String umDomain, long id, ContractTemplate contract, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            Date d = Calendar.getInstance().getTime();
            //SimpleDateFormat sp = new SimpleDateFormat();
            long contractId = bssDAO.UpdateContractTemplate(id, contract.getName(), contract.getDescription(), contract.getContractType().name(), contract.getContent(), contract.getCreatedBy(), contract.getModificationDate()); //  //merge contract template with postpaid
            //ccontract_type, contract_template_id, second_contractor_name, second_contractor_fiscal_number, second_contractor_address, preamble, clauses, expiration_conditions, creation_date, modification_date
            contract.setContractTemplateId(contractId);
            HDBResource.put(contract, "contract_template", "update");

            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully updated!")).build();

        } catch (RuntimeException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response updatePostpaidContract(String umUserHash, String umSessionId, String umDomain, long customerId, long id, ContractPostpaid contract, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {

//        contract.
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            long supplementId = bssDAO.UpdatePostpaidContract(SUPPLEMENT, contract.getAllowJointBilling(), contract.getCustomerId(), contract.getBillingPeriod().name(), contract.getBillingDay(), contract.getStatusDate(), contract.getSecondContractorName(), contract.getSecondContractorFiscalNumber(), contract.getSecondContractorAddress(), contract.getStartDate(), contract.getEndDate(), contract.getPreamble(), contract.getClauses(), contract.getExpirationCondition(), "Telo Pay", contract.getGoodsAndServices());
            //contract_id, billing_periodicity, allow_joint_billing, customer_id, billing_day, status_date, second_contractor, start_date, end_date, preamble, clauses, expiration_condition, first_contractor, goods_services
            bssDAO.createPostpaidContractSupplimentRecord(id, supplementId);
            HDBResource.put(contract, "postpaid_contract", "update");

            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully created a supplement!")).build();

        } catch (RuntimeException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response updatePostpaidProduct(String umUserHash, String umSessionId, String umDomain, long id, ProductPostpaid service, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.serverError().build();
        }
        ContractDAO contractsDAO = null;
        try {
            contractsDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            contractsDAO.updatePostpaidService(service.getExternalProvisionId(), service.getUnitPrice(), id);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (contractsDAO != null) {
                contractsDAO.close();
            }
        }
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully updated!")).build();
    }

    @Override
    public Response updatePrepaidContract(String umUserHash, String umSessionId, String umDomain, long customerId, long contractId, ContractPrepaid contract, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            Date d = Calendar.getInstance().getTime();
            bssDAO.cancelcontract("CLOSED", contractId, customerId, d);

            if (contract.getServiceType().name().equals("TELOAGENT")) {

                if (bssDAO.confirmIfTeloAgentContractExists(customerId, contract.getServiceType().name())) {
                    return Response.status(Response.Status.BAD_REQUEST).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Customer already have an existing TELOAGENT contract")).build();
                }
            }

            //Create a supplement contract and retrieve the id
            long supplementId = bssDAO.UpdatePrepaidContract(SUPPLEMENT, contract.getServicePrepaid(), contract.getCustomerId(), contract.getStatusDate(), contract.getStartDate(), "ACTIVE", contract.getContent(), contract.getAutomaticRenewal(), contract.getServiceType().name());
            //create a contract_supplement record and pass the suppliment and referenced contract ids
            bssDAO.createPrepaidContractSupplimentRecord(contractId, supplementId);
            long serviceId = contract.getServicePrepaid();
            bssDAO.updateServiceStatus(serviceId);

            //Creates a supplement contract
            HDBResource.put(contract, "prepaid_contract", "update");

            //Create a supplement association 
//            int res HDBResource.put(contract, "prepaid_contract", "create");
            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully updated!")).build();

        } catch (RuntimeException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }

    }

    @Override
    public Response updatePrepaidService(String umUserHash, String umSessionId, String umDomain, long id, ServicePrepaid prepaidService, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO contractsDAO = null;
        try {
            contractsDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            if ((prepaidService.getServiceType().equals(
                    ServicePrepaid.ServiceTypeEnum.TELOOPERATOR)
                    && prepaidService.getIsLegacy())
                    || prepaidService.getServiceType().equals(
                            ServicePrepaid.ServiceTypeEnum.TEC)
                    || prepaidService.getServiceType().equals(
                            ServicePrepaid.ServiceTypeEnum.PSP)) {
                if (prepaidService.getExternalProvisionId() == null
                        || prepaidService.getExternalProvisionId().trim()
                        .isEmpty()) {

                    return Response.status(Response.Status.BAD_REQUEST).
                            entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                    "ExternalProvisioningId cannot be null for "
                                    + "the selected service type")).build();
                }
            }

            if (prepaidService.getServiceType().equals(
                    ServicePrepaid.ServiceTypeEnum.TELOOPERATOR)
                    && !prepaidService.getIsLegacy()) {

                PayphoneService payphoneService
                        = provisionPayphone(prepaidService,
                                "payphone-services/id/"
                                + prepaidService.getExternalProvisionId(), "PUT");
                if (payphoneService.getId() == 0L) {
                    throw new Exception();
                } else {
                    prepaidService.setPayphoneService(payphoneService);
//                contract.setExternalProvisionId(
//                        String.valueOf(payphoneService.getId()));
                }
            }
            
            
            contractsDAO.updatePrepaidService(
                    prepaidService.getExternalProvisionId(),
//                    prepaidService.getStatus().toString(),
                    prepaidService.getName(),
                    prepaidService.getServiceType().name(),
                    prepaidService.getDeletedReason(),
                    prepaidService.getProductId(), id);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex.getMessage());

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            ex.getMessage())).build();
        } finally {
            if (contractsDAO != null) {
                contractsDAO.close();
            }
        }
        return Response.ok().entity(prepaidService).build();
    }

    @Override
    public Response bssProvisionProductsGet(String umUserHash, String umSessionId, String umDomain, long offset, long limit, String productCode, long productId, String productDescription, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {

            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            //set default values if pagination fields are empty
//            limit = limit == 0 ? 20 : limit;
//            offset = offset == 0 ? 0 : offset;
            List<Map> products = bssDAO.findProduct(productId, offset, limit);
            bssDAO.close();
            if (products.size() > 0) {
                return Response.ok().entity(products.get(0)).build();
            } else {
                return Response.ok().entity(products).build();
            }
            //    return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, list.toString())).build();
        } catch (Exception ex) {

            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {

            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response createAProduct(String umUserHash, String umSessionId, String umDomain, Product product, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            long createProduct = bssDAO.createProduct(product.getProductCode(), product.getProductDescription(), product.getProductName(), product.getTaxId(), product.getProductType().name());

            product.setProductId(createProduct);

            HDBResource.put(createProduct, "products", "create");

            return Response.ok().entity(product).build();

            //  return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully created!")).build();
        } catch (RuntimeException ex) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();

        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response deleteProduct(String umUserHash, String umSessionId, String umDomain, long id, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            List<Map> proDucts = bssDAO.findProduct(id, 0, 1);

            if (id == 0 || proDucts.size() < 1) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            //Now delete the customer
            /*cDAO.deleteCustomer(id);*/

            Product product = (Product) proDucts.get(0);

            HDBResource.put(product, "products", "delete");

            bssDAO.deleteProduct(id);

            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully deleted!")).build();

        } catch (RuntimeException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();

        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }

        }
    }

    @Override
    public Response updateProduc(String umUserHash, String umSessionId, String umDomain, long id, Product product, SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain, securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }
        ContractDAO bssDAO = null;
        try {
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            long productUpdate = bssDAO.UpdateProduct(id, product.getProductCode(), product.getProductDescription(), product.getProductName(), product.getProductType().name(), product.getTaxId());

            //ccontract_type, contract_template_id, second_contractor_name, second_contractor_fiscal_number, second_contractor_address, preamble, clauses, expiration_conditions, creation_date, modification_date
            if (productUpdate < 1) {

                return Response.status(200).entity(new ApiResponseMessage(ApiResponseMessage.INFO, "No row was updated!")).build();

            }

            HDBResource.put(productUpdate, "products", "update");

            return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Successfully updated!")).build();

        } catch (RuntimeException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response cancelContract(String umUserHash, String umSessionId,
            String umDomain, long customerId, long serviceId, long id,
            SecurityContext securityContext) throws NotFoundException {
        try {
            AccessControl.authenticate(umUserHash, umSessionId, umDomain,
                    securityContext);
        } catch (Exception ex) {
            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.UNAUTHORIZED).
                    entity(new ApiResponseMessage
        (ApiResponseMessage.ERROR, "Unauthorized!")).build();
        }

        ContractDAO bssDAO = null;
        try {
            
            
            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);
            Date d = Calendar.getInstance().getTime();
            bssDAO.cancelcontract("CLOSED", id, customerId, d);
            bssDAO.removeService(serviceId);
            
            return Response.ok().entity(new ApiResponseMessage
        (ApiResponseMessage.OK, "Contract cancelled")).build();
            
        } catch (Exception ex) {

            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
                    entity(new ApiResponseMessage
        (ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
    }

    @Override
    public Response getContractTemplate(String umUserHash, String umSessionId, String umDomain, long id, SecurityContext securityContext) throws NotFoundException {
  ContractDAO bssDAO = null;
        try {

            bssDAO = JdbiHelper.getDBI().open(ContractDAO.class);

            //set default values if pagination fields are empty

            List<Map> contract_prepaid = bssDAO.findContractTemplateById(id);
            bssDAO.close();
            if (contract_prepaid.size() > 0) {
                return Response.ok().entity(contract_prepaid.get(0)).build();
            } else {
                return Response.ok().entity(contract_prepaid).build();
            }
        } catch (Exception ex) {

            Logger.getLogger(BssContractsApiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(new ApiResponseMessage(ApiResponseMessage.ERROR, ex.getMessage())).build();
        } finally {
            if (bssDAO != null) {
                bssDAO.close();
            }
        }
}
}