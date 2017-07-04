package io.swagger.api;


import io.swagger.model.ContractTemplate;
import io.swagger.model.ContractPostpaid;
import io.swagger.model.ContractPrepaid;
import io.swagger.model.Product;
import io.swagger.model.ServicePrepaid;
import io.swagger.model.ProductPostpaid;

import java.util.Date;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T12:02:51.809Z")
public abstract class BssContractsApiService {
    public abstract Response bssProvisionContractsTemplatesGet(String umUserHash,String umSessionId,String umDomain,long limit,long offset,long templateId,String templateDescription,String createdBy,String content,SecurityContext securityContext) throws NotFoundException;
    public abstract Response bssProvisionCustomersCustomerIdContractsPostpaidGet(String umUserHash,String umSessionId,String umDomain,long customerId, long id,long offset,long limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response bssProvisionCustomersCustomerIdContractsPrepaidContractIdGet(String umUserHash,String umSessionId,String umDomain,long customerId,long contractId,long offset,long limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response bssProvisionCustomersCustomerIdContractsPrepaidGet(String umUserHash,String umSessionId,String umDomain,long customerId,String contractType, String status, Date creationDate, String serviceType,long offset,long limit,SecurityContext securityContext) throws NotFoundException;
    public abstract Response bssProvisionProductsGet(String umUserHash,String umSessionId,String umDomain,long offset,long limit,String productCode,long productId,String productDescription,SecurityContext securityContext) throws NotFoundException;
    public abstract Response bssProvisionServicesPrepaidGet(String umUserHash,String umSessionId,String umDomain,long limit,long offset,String type,String status, String external_provision_id, Date creation_date, Date modification_date, SecurityContext securityContext) throws NotFoundException;
    public abstract Response confirmContract(String umUserHash,String umSessionId,String umDomain,long customerId,long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response cancelContract(String umUserHash,String umSessionId,String umDomain,long customerId, long serviceId, long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createAProduct(String umUserHash,String umSessionId,String umDomain,Product product,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createContractPrepaid(String umUserHash,String umSessionId,String umDomain,long customerId,ContractPrepaid contract,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createContractTemplate(String umUserHash,String umSessionId,String umDomain,ContractTemplate contract,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createPostpaidContract(String umUserHash,String umSessionId,String umDomain,long customerId,ContractPostpaid contract,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createPostpaidService(String umUserHash,String umSessionId,String umDomain,ProductPostpaid postpaidService,SecurityContext securityContext) throws NotFoundException;
    public abstract Response createPrepaidService(String umUserHash,String umSessionId,String umDomain,ServicePrepaid prepaidService,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteContractTemplate(String umUserHash,String umSessionId,String umDomain,long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deletePostPaidService(String umUserHash,String umSessionId,String umDomain,long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deletePostpaidContract(String umUserHash,String umSessionId,String umDomain,long customerId,long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deletePrepaidContract(String umUserHash,String umSessionId,String umDomain,long contractId,long serviceId,long customerId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deletePrepaidService(String umUserHash,String umSessionId,String umDomain,long id, ServicePrepaid prepaidService,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteProduct(String umUserHash,String umSessionId,String umDomain,long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPostpaidProducts(String umUserHash,String umSessionId,String umDomain,long limit,long customerId,long contractId,long offset,String postpaidService,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getPrepaidService(String umUserHash,String umSessionId,String umDomain,long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getContractTemplate(String umUserHash,String umSessionId,String umDomain,long id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateContractTemplate(String umUserHash,String umSessionId,String umDomain,long id,ContractTemplate contract,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updatePostpaidContract(String umUserHash,String umSessionId,String umDomain,long customerId,long id,ContractPostpaid contract,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updatePostpaidProduct(String umUserHash,String umSessionId,String umDomain,long id,ProductPostpaid service,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updatePrepaidContract(String umUserHash,String umSessionId,String umDomain,long customerId,long contractId,ContractPrepaid contract,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updatePrepaidService(String umUserHash,String umSessionId,String umDomain,long id,ServicePrepaid contract,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateProduc(String umUserHash,String umSessionId,String umDomain,long id,Product product,SecurityContext securityContext) throws NotFoundException;
}
