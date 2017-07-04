package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ProductPostpaid;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




/**
 * ContractPostpaid
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-21T13:42:52.506Z")
public class ContractPostpaid   {
  private long contractId;

  private Date startDate = null;

  private Date endDate = null;

  private Boolean automaticRenewal = true;

  private long customerId;

  private String content = null;
  
  private String preamble = null;

  private String clauses = null;

  private String secondContractorName = null;

  private String secondContractorAddress = null;

  private String secondContractorFiscalNumber = null;
  
  private String expirationCondition = null;

  private String goodsAndServices = null;

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
    NEW("new"),
    
    PENDING("pending"),
    
    ACTIVE("active"),
    
    INACTIVE("inactive"),
    
    CANCELLED("cancelled"),
    
    EXPIRED("expired"),
    
    CLOSED("closed");

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

  private Boolean allowJointBilling = null;

  /**
   * billing periodicity
   */
  public enum BillingPeriodEnum {
    MONTHLY("monthly"),
    
    BIMONTHLY("bimonthly"),
    
    QUARTERLY("quarterly"),
    
    SEMIANUALLY("semianually"),
    
    ANUALLY("anually");

    private String value;

    BillingPeriodEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private BillingPeriodEnum billingPeriod = null;

  private Date billingDay;

  private List<ProductPostpaid> services = new ArrayList<ProductPostpaid>();

  private Date creationDate = null;

 // private Date modificationDate = null;

  private Date statusDate = null;

  private List<Long> productPrepaid = new ArrayList<>();

  public ContractPostpaid contractId(long contractId) {
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

  public ContractPostpaid startDate(Date startDate) {
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

  public ContractPostpaid endDate(Date endDate) {
    this.endDate = (Date)endDate.clone();
    return this;
  }

   /**
   * Date when the contract effectively stops producing effect
   * @return endDate
  **/
  @ApiModelProperty(value = "Date when the contract effectively stops producing effect")
  public Date getEndDate() {
    return (Date)endDate.clone();
  }

  public void setEndDate(Date endDate) {
    this.endDate = (Date)endDate.clone();
  }

  public ContractPostpaid automaticRenewal(Boolean automaticRenewal) {
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

  public ContractPostpaid customerId(long customerId) {
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

  public ContractPostpaid content(String content) {
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
  
  public ContractPostpaid preamble(String preamble) {
    this.preamble = preamble;
    return this;
  }

   /**
   * Contract justification
   * @return preamble
  **/
  @ApiModelProperty(value = "Contract justification")
  public String getPreamble() {
    return preamble;
  }

  public void setPreamble(String preamble) {
    this.preamble = preamble;
  }

  public ContractPostpaid clauses(String clauses) {
    this.clauses = clauses;
    return this;
  }

   /**
   * Contract clauses
   * @return clauses
  **/
  @ApiModelProperty(value = "Contract clauses")
  public String getClauses() {
    return clauses;
  }

  public void setClauses(String clauses) {
    this.clauses = clauses;
  }

  public ContractPostpaid secondContractorName(String secondContractorName) {
    this.secondContractorName = secondContractorName;
    return this;
  }

   /**
   * second contractor
   * @return secondContractorName
  **/
  @ApiModelProperty(value = "second contractor")
  public String getSecondContractorName() {
    return secondContractorName;
  }

  public void setSecondContractorName(String secondContractorName) {
    this.secondContractorName = secondContractorName;
  }

  public ContractPostpaid secondContractorAddress(String secondContractorAddress) {
    this.secondContractorAddress = secondContractorAddress;
    return this;
  }

   /**
   * second contractor address
   * @return secondContractorAddress
  **/
  @ApiModelProperty(value = "second contractor address")
  public String getSecondContractorAddress() {
    return secondContractorAddress;
  }

  public void setSecondContractorAddress(String secondContractorAddress) {
    this.secondContractorAddress = secondContractorAddress;
  }

  public ContractPostpaid secondContractorFiscalNumber(String secondContractorFiscalNumber) {
    this.secondContractorFiscalNumber = secondContractorFiscalNumber;
    return this;
  }

   /**
   * Fiscal Number
   * @return secondContractorFiscalNumber
  **/
  @ApiModelProperty(value = "Fiscal Number")
  public String getSecondContractorFiscalNumber() {
    return secondContractorFiscalNumber;
  }

  public void setSecondContractorFiscalNumber(String secondContractorFiscalNumber) {
    this.secondContractorFiscalNumber = secondContractorFiscalNumber;
  }
  
   public ContractPostpaid expirationCondition(String expirationCondition) {
    this.expirationCondition = expirationCondition;
    return this;
  }

   /**
   * expiration condition
   * @return expirationCondition
  **/
  @ApiModelProperty(value = "expiration condition")
  public String getExpirationCondition() {
    return expirationCondition;
  }

  public void setExpirationCondition(String expirationCondition) {
    this.expirationCondition = expirationCondition;
  }

  public ContractPostpaid goodsAndServices(String goodsAndServices) {
    this.goodsAndServices = goodsAndServices;
    return this;
  }

   /**
   * Goods and services
   * @return goodsAndServices
  **/
  @ApiModelProperty(value = "Goods and services")
  public String getGoodsAndServices() {
    return goodsAndServices;
  }

  public void setGoodsAndServices(String goodsAndServices) {
    this.goodsAndServices = goodsAndServices;
  }

  public ContractPostpaid contractSubtype(ContractSubtypeEnum contractSubtype) {
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

  public ContractPostpaid status(StatusEnum status) {
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

  public ContractPostpaid allowJointBilling(Boolean allowJointBilling) {
    this.allowJointBilling = allowJointBilling;
    return this;
  }

   /**
   * allow this contract to be billed together with other contracts with the same billing cycle
   * @return allowJointBilling
  **/
  @ApiModelProperty(required = true, value = "allow this contract to be billed together with other contracts with the same billing cycle")
  public Boolean getAllowJointBilling() {
    return allowJointBilling;
  }

  public void setAllowJointBilling(Boolean allowJointBilling) {
    this.allowJointBilling = allowJointBilling;
  }

  public ContractPostpaid billingPeriod(BillingPeriodEnum billingPeriod) {
    this.billingPeriod = billingPeriod;
    return this;
  }

   /**
   * billing periodicity
   * @return billingPeriod
  **/
  @ApiModelProperty(required = true, value = "billing periodicity")
  public BillingPeriodEnum getBillingPeriod() {
    return billingPeriod;
  }

  public void setBillingPeriod(BillingPeriodEnum billingPeriod) {
    this.billingPeriod = billingPeriod;
  }

  public ContractPostpaid billingDay(Date billingDay) {
    this.billingDay = (Date)billingDay.clone();
    return this;
  }

   /**
   * day of the month when billing should take place
   * @return billingDay
  **/
  @ApiModelProperty(required = true, value = "day of the month when billing should take place")
  public Date getBillingDay() {
    return (Date)billingDay.clone();
  }

  public void setBillingDay(Date billingDay) {
    this.billingDay = (Date)billingDay.clone();
  }

  public ContractPostpaid services(List<ProductPostpaid> services) {
    this.services = services;
    return this;
  }

  public ContractPostpaid addServicesItem(ProductPostpaid servicesItem) {
    this.services.add(servicesItem);
    return this;
  }

   /**
   * ID of the services associated with contract. If it is a prepaid contract, the IDs refer to TEC, TELO or PSP services, and there will be only ONE object on the array
   * @return services
  **/
  @ApiModelProperty(value = "ID of the services associated with contract. If it is a prepaid contract, the IDs refer to TEC, TELO or PSP services, and there will be only ONE object on the array")
  public List<ProductPostpaid> getServices() {
    return services;
  }

  public void setServices(List<ProductPostpaid> services) {
    this.services = services;
  }

  public ContractPostpaid creationDate(Date creationDate) {
    this.creationDate = (Date)creationDate.clone();
    return this;
  }

   /**
   * Date when the contract was created
   * @return creationDate
  **/
  @ApiModelProperty(value = "Date when the contract was created")
  public Date getCreationDate() {
    return (Date)creationDate.clone();
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = (Date)creationDate.clone();
  }

//  public ContractPostpaid modificationDate(Date modificationDate) {
//    this.modificationDate = (Date)modificationDate.clone();
//    return this;
//  }
//
//   /**
//   * Date when the contract was modified
//   * @return modificationDate.clone();
//  **/
//  @ApiModelProperty(value = "Date when the contract was modified")
//  public Date getModificationDate() {
//    return (Date)modificationDate.clone();
//  }
//
//  public void setModificationDate(Date modificationDate) {
//    this.modificationDate = (Date)modificationDate.clone();
//  }

  public ContractPostpaid statusDate(Date statusDate) {
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

  public ContractPostpaid productPrepaid(List<Long> productPrepaid) {
    this.productPrepaid = productPrepaid;
    return this;
  }

  public ContractPostpaid addProductPrepaidItem(long productPrepaidItem) {
    this.productPrepaid.add(productPrepaidItem);
    return this;
  }

   /**
   * Array of Postpaid product IDs (refers to product_postpaid object)
   * @return productPrepaid
  **/
  @ApiModelProperty(value = "Array of Postpaid product IDs (refers to product_postpaid object)")
  public List<Long> getProductPrepaid() {
    return productPrepaid;
  }

  public void setProductPrepaid(List<Long> productPrepaid) {
    this.productPrepaid = productPrepaid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContractPostpaid contractPostpaid = (ContractPostpaid) o;
    return Objects.equals(this.contractId, contractPostpaid.contractId) &&
        Objects.equals(this.startDate, contractPostpaid.startDate) &&
        Objects.equals(this.endDate, contractPostpaid.endDate) &&
        Objects.equals(this.automaticRenewal, contractPostpaid.automaticRenewal) &&
        Objects.equals(this.customerId, contractPostpaid.customerId) &&
        Objects.equals(this.content, contractPostpaid.content) &&
        Objects.equals(this.contractSubtype, contractPostpaid.contractSubtype) &&
        Objects.equals(this.status, contractPostpaid.status) &&
        Objects.equals(this.allowJointBilling, contractPostpaid.allowJointBilling) &&
        Objects.equals(this.billingPeriod, contractPostpaid.billingPeriod) &&
        Objects.equals(this.billingDay, contractPostpaid.billingDay) &&
        Objects.equals(this.services, contractPostpaid.services) &&
        Objects.equals(this.creationDate, contractPostpaid.creationDate) &&
      //  Objects.equals(this.modificationDate, contractPostpaid.modificationDate) &&
        Objects.equals(this.statusDate, contractPostpaid.statusDate) &&
        Objects.equals(this.productPrepaid, contractPostpaid.productPrepaid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contractId, startDate, endDate, automaticRenewal, customerId, content, contractSubtype, status, allowJointBilling, billingPeriod, billingDay, services, creationDate,  statusDate, productPrepaid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContractPostpaid {\n");
    
    sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    automaticRenewal: ").append(toIndentedString(automaticRenewal)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    contractSubtype: ").append(toIndentedString(contractSubtype)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    allowJointBilling: ").append(toIndentedString(allowJointBilling)).append("\n");
    sb.append("    billingPeriod: ").append(toIndentedString(billingPeriod)).append("\n");
    sb.append("    billingDay: ").append(toIndentedString(billingDay)).append("\n");
    sb.append("    services: ").append(toIndentedString(services)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    //sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
    sb.append("    statusDate: ").append(toIndentedString(statusDate)).append("\n");
    sb.append("    productPrepaid: ").append(toIndentedString(productPrepaid)).append("\n");
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

