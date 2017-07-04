package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;




/**
 * ContractPrepaid
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-21T13:42:52.506Z")
public class ContractPrepaid   {
  private long contractId;

  private Date startDate = null;

  private Date endDate = null;

  private Boolean automaticRenewal = true;

  private long customerId;
  
  private Date statusDate = null;
  
  public enum ServiceTypeEnum {
    PSP("PSP"),
    
    TEC("TEC"),
    
    TELOAGENT("TELOAGENT"),
    
    TELOOPERATOR("TELOOPERATOR");
    
    private String value;

    ServiceTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private ServiceTypeEnum serviceType = null;
  
  private String contractType = null;
  

  /**
   * Gets or Sets contractSubtype
   */
  public enum ContractSubtypeEnum {
    SUPPLEMENT("supplement"),
    
    MAIN("main");

    private String value;

    ContractSubtypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private ContractSubtypeEnum contractSubtype = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    NEW("NEW"),
    
    ACTIVE("ACTIVE"),
    
    CLOSED("CLOSED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private StatusEnum status = null;

  private String content = null;

  private long servicePrepaid;

  public ContractPrepaid contractId(long contractId) {
    this.contractId = contractId;
    return this;
  }

   /**
   * Contract Id
   * @return contractId
  **/
  @ApiModelProperty(value = "Contract Id")
  public long getContractId() {
    return contractId;
  }

  public void setContractId(long contractId) {
    this.contractId = contractId;
  }

  public ContractPrepaid startDate(Date startDate) {
    this.startDate = (Date)startDate.clone();
    return this;
  }

   /**
   * Date when the contract effectively starts producing effect
   * @return startDate
  **/
  @ApiModelProperty(required = true, value = "Date when the contract effectively starts producing effect")
  public Date getStartDate() {
    return (Date)startDate.clone();
  }

  public void setStartDate(Date startDate) {
    this.startDate = (Date)startDate.clone();
  }

//  public ContractPrepaid endDate(Date endDate) {
//    this.endDate = (Date)endDate.clone();
//    return this;
//  }

   /**
   * Date when the contract effectively stops producing effect
   * @return endDate
  **/
//  @ApiModelProperty(value = "Date when the contract effectively stops producing effect")
//  public Date getEndDate() {
//    return (Date)endDate.clone();
//  }
//
//  public void setEndDate(Date endDate) {
//    this.endDate = (Date)endDate.clone();
//  }

  public ContractPrepaid automaticRenewal(Boolean automaticRenewal) {
    this.automaticRenewal = automaticRenewal;
    return this;
  }

   /**
   * The contract will automatically renew when End Date is reached
   * @return automaticRenewal
  **/
  @ApiModelProperty(value = "The contract will automatically renew when End Date is reached")
  public Boolean getAutomaticRenewal() {
    return automaticRenewal;
  }

  public void setAutomaticRenewal(Boolean automaticRenewal) {
    this.automaticRenewal = automaticRenewal;
  }

  public ContractPrepaid customerId(long customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * customer_id is the secondContractor. The system will retrieve the necessary information
   * @return customerId
  **/
  @ApiModelProperty(required = true, value = "customer_id is the secondContractor. The system will retrieve the necessary information")
  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }

  public ContractPrepaid contractSubtype(ContractSubtypeEnum contractSubtype) {
    this.contractSubtype = contractSubtype;
    return this;
  }

   /**
   * Get contractSubtype
   * @return contractSubtype
  **/
  @ApiModelProperty(value = "")
  public ContractSubtypeEnum getContractSubtype() {
    return contractSubtype;
  }

  public void setContractSubtype(ContractSubtypeEnum contractSubtype) {
    this.contractSubtype = contractSubtype;
  }

  public ContractPrepaid status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ContractPrepaid content(String content) {
    this.content = content;
    return this;
  }

   /**
   * Contract contents
   * @return content
  **/
  @ApiModelProperty(required = true, value = "Contract contents")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
  
   
  
  public ContractPrepaid statusDate(Date statusDate) {
    this.statusDate = (Date)statusDate.clone();
    return this;
  }

   /**
   * date of status
   * @return statusDate
  **/
  @ApiModelProperty(value = "date of status")
  public Date getStatusDate() {
    return (Date)statusDate.clone();
  }

  public void setStatusDate(Date statusDate) {
    this.statusDate = (Date)statusDate.clone();
  }
  

  public ContractPrepaid servicePrepaid(long servicePrepaid) {
    this.servicePrepaid = servicePrepaid;
    return this;
  }

   /**
   * Prepaid service Id (refers to service_prepaid object)
   * @return servicePrepaid
  **/
  @ApiModelProperty(value = "Prepaid service Id (refers to service_prepaid object)")
  public long getServicePrepaid() {
    return servicePrepaid;
  }

  public void setServicePrepaid(long servicePrepaid) {
    this.servicePrepaid = servicePrepaid;
  }
  
    public ContractPrepaid serviceType(ServiceTypeEnum serviceType) {
    this.serviceType = serviceType;
    return this;
  }

   /**
   * Get serviceType
   * @return serviceType
  **/
  @ApiModelProperty(required = true, value = "")
  public ServiceTypeEnum getServiceType() {
    return serviceType;
  }

  public void setServiceType(ServiceTypeEnum serviceType) {
    this.serviceType = serviceType;
  }
  
  public ContractPrepaid contractType(String contractType) {
    this.contractType = contractType;
    return this;
  }

   /**
   * Get serviceType
   * @return serviceType
  **/
  @ApiModelProperty(required = true, value = "")
  public String getContractType() {
    return contractType;
  }

  public void setContractType(String contractType) {
    this.contractType = contractType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContractPrepaid contractPrepaid = (ContractPrepaid) o;
    return Objects.equals(this.contractId, contractPrepaid.contractId) &&
        Objects.equals(this.startDate, contractPrepaid.startDate) &&
        Objects.equals(this.endDate, contractPrepaid.endDate) &&
        Objects.equals(this.automaticRenewal, contractPrepaid.automaticRenewal) &&
        Objects.equals(this.customerId, contractPrepaid.customerId) &&
        Objects.equals(this.contractSubtype, contractPrepaid.contractSubtype) &&
        Objects.equals(this.status, contractPrepaid.status) &&
        Objects.equals(this.content, contractPrepaid.content) &&
        Objects.equals(this.servicePrepaid, contractPrepaid.servicePrepaid) &&
        Objects.equals(this.serviceType, contractPrepaid.serviceType) &&
            Objects.equals(this.contractType, contractPrepaid.contractType) &&
        Objects.equals(this.statusDate, contractPrepaid.statusDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contractId, startDate, endDate, automaticRenewal, customerId, contractSubtype, status, content, servicePrepaid,serviceType,contractType,statusDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContractPrepaid {\n");
    
    sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    automaticRenewal: ").append(toIndentedString(automaticRenewal)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    contractSubtype: ").append(toIndentedString(contractSubtype)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    servicePrepaid: ").append(toIndentedString(servicePrepaid)).append("\n");
    sb.append("    statusDate: ").append(toIndentedString(statusDate)).append("\n");
     sb.append("    serviceType: ").append(toIndentedString(serviceType)).append("\n");
     sb.append("    contractType: ").append(toIndentedString(contractType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

