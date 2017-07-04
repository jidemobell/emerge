package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;



/**
 * contains information about services that were delivered.
 **/

/**
 * contains information about services that were delivered.
 */
@ApiModel(description = "contains information about services that were delivered.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T14:27:56.968Z")
public class DeliveredServiceInformation   {
  private String originMSISDN = null;

  private String destinationMSISDN = null;

  private Date serviceStartTime = null;

  private Date serviceEstablishedTime = null;

  private Date serviceEndTime = null;

  private BigDecimal serviceDuration = null;

  private BigDecimal billedDuration = null;

  private BigDecimal billedAmount = null;

  private Tariff tariff = null;

  private String endCause = null;

  private BigDecimal initialBalance = null;

  private BigDecimal finalBalance = null;

  private BigDecimal initialCredit = null;

  private BigDecimal finalCredit = null;

  public DeliveredServiceInformation originMSISDN(String originMSISDN) {
    this.originMSISDN = originMSISDN;
    return this;
  }

   /**
   * Origin MSISDN
   * @return originMSISDN
  **/
  @ApiModelProperty(required = true, value = "Origin MSISDN")
  public String getOriginMSISDN() {
    return originMSISDN;
  }

  public void setOriginMSISDN(String originMSISDN) {
    this.originMSISDN = originMSISDN;
  }

  public DeliveredServiceInformation destinationMSISDN(String destinationMSISDN) {
    this.destinationMSISDN = destinationMSISDN;
    return this;
  }

   /**
   * Origin MSISDN
   * @return destinationMSISDN
  **/
  @ApiModelProperty(required = true, value = "Origin MSISDN")
  public String getDestinationMSISDN() {
    return destinationMSISDN;
  }

  public void setDestinationMSISDN(String destinationMSISDN) {
    this.destinationMSISDN = destinationMSISDN;
  }

  public DeliveredServiceInformation serviceStartTime(Date serviceStartTime) {
    this.serviceStartTime = (Date) serviceStartTime.clone();
    return this;
  }

   /**
   * Date/time when service was requested to start
   * @return serviceStartTime
  **/
  @ApiModelProperty(required = true, value = "Date/time when service was requested to start")
  public Date getServiceStartTime() {
    return (Date) serviceStartTime.clone();
  }

  public void setServiceStartTime(Date serviceStartTime) {
    this.serviceStartTime = (Date) serviceStartTime.clone();
  }

  public DeliveredServiceInformation serviceEstablishedTime(Date serviceEstablishedTime) {
    this.serviceEstablishedTime = (Date) serviceEstablishedTime.clone();
    return this;
  }

   /**
   * Date/time when service has actually started
   * @return serviceEstablishedTime
  **/
  @ApiModelProperty(required = true, value = "Date/time when service has actually started")
  public Date getServiceEstablishedTime() {
    return (Date) serviceEstablishedTime.clone();
  }

  public void setServiceEstablishedTime(Date serviceEstablishedTime) {
    this.serviceEstablishedTime = (Date) serviceEstablishedTime.clone();
  }

  public DeliveredServiceInformation serviceEndTime(Date serviceEndTime) {
    this.serviceEndTime = (Date) serviceEndTime.clone();
    return this;
  }

   /**
   * Date/time when service has actually started
   * @return serviceEndTime
  **/
  @ApiModelProperty(required = true, value = "Date/time when service has actually started")
  public Date getServiceEndTime() {
    return (Date) serviceEndTime.clone();
  }

  public void setServiceEndTime(Date serviceEndTime) {
    this.serviceEndTime = (Date) serviceEndTime.clone();
  }

  public DeliveredServiceInformation serviceDuration(BigDecimal serviceDuration) {
    this.serviceDuration = serviceDuration;
    return this;
  }

   /**
   * Service duration, in seconds.
   * @return serviceDuration
  **/
  @ApiModelProperty(required = true, value = "Service duration, in seconds.")
  public BigDecimal getServiceDuration() {
    return serviceDuration;
  }

  public void setServiceDuration(BigDecimal serviceDuration) {
    this.serviceDuration = serviceDuration;
  }

  public DeliveredServiceInformation billedDuration(BigDecimal billedDuration) {
    this.billedDuration = billedDuration;
    return this;
  }

   /**
   * Billed duration, in seconds.
   * @return billedDuration
  **/
  @ApiModelProperty(required = true, value = "Billed duration, in seconds.")
  public BigDecimal getBilledDuration() {
    return billedDuration;
  }

  public void setBilledDuration(BigDecimal billedDuration) {
    this.billedDuration = billedDuration;
  }

  public DeliveredServiceInformation billedAmount(BigDecimal billedAmount) {
    this.billedAmount = billedAmount;
    return this;
  }

   /**
   * Billed amount.
   * @return billedAmount
  **/
  @ApiModelProperty(required = true, value = "Billed amount.")
  public BigDecimal getBilledAmount() {
    return billedAmount;
  }

  public void setBilledAmount(BigDecimal billedAmount) {
    this.billedAmount = billedAmount;
  }

  public DeliveredServiceInformation tariff(Tariff tariff) {
    this.tariff = tariff;
    return this;
  }

   /**
   * Get tariff
   * @return tariff
  **/
  @ApiModelProperty(required = true, value = "")
  public Tariff getTariff() {
    return tariff;
  }

  public void setTariff(Tariff tariff) {
    this.tariff = tariff;
  }

  public DeliveredServiceInformation endCause(String endCause) {
    this.endCause = endCause;
    return this;
  }

   /**
   * Logical end cause of the delivered service
   * @return endCause
  **/
  @ApiModelProperty(required = true, value = "Logical end cause of the delivered service")
  public String getEndCause() {
    return endCause;
  }

  public void setEndCause(String endCause) {
    this.endCause = endCause;
  }

  public DeliveredServiceInformation initialBalance(BigDecimal initialBalance) {
    this.initialBalance = initialBalance;
    return this;
  }

   /**
   * Initial payphone balance
   * @return initialBalance
  **/
  @ApiModelProperty(required = true, value = "Initial payphone balance")
  public BigDecimal getInitialBalance() {
    return initialBalance;
  }

  public void setInitialBalance(BigDecimal initialBalance) {
    this.initialBalance = initialBalance;
  }

  public DeliveredServiceInformation finalBalance(BigDecimal finalBalance) {
    this.finalBalance = finalBalance;
    return this;
  }

   /**
   * Final payphone balance
   * @return finalBalance
  **/
  @ApiModelProperty(required = true, value = "Final payphone balance")
  public BigDecimal getFinalBalance() {
    return finalBalance;
  }

  public void setFinalBalance(BigDecimal finalBalance) {
    this.finalBalance = finalBalance;
  }

  public DeliveredServiceInformation initialCredit(BigDecimal initialCredit) {
    this.initialCredit = initialCredit;
    return this;
  }

   /**
   * Initial service credit, specified by the customer
   * @return initialCredit
  **/
  @ApiModelProperty(required = true, value = "Initial service credit, specified by the customer")
  public BigDecimal getInitialCredit() {
    return initialCredit;
  }

  public void setInitialCredit(BigDecimal initialCredit) {
    this.initialCredit = initialCredit;
  }

  public DeliveredServiceInformation finalCredit(BigDecimal finalCredit) {
    this.finalCredit = finalCredit;
    return this;
  }

   /**
   * Final service credit
   * @return finalCredit
  **/
  @ApiModelProperty(required = true, value = "Final service credit")
  public BigDecimal getFinalCredit() {
    return finalCredit;
  }

  public void setFinalCredit(BigDecimal finalCredit) {
    this.finalCredit = finalCredit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeliveredServiceInformation deliveredServiceInformation = (DeliveredServiceInformation) o;
    return Objects.equals(this.originMSISDN, deliveredServiceInformation.originMSISDN) &&
        Objects.equals(this.destinationMSISDN, deliveredServiceInformation.destinationMSISDN) &&
        Objects.equals(this.serviceStartTime, deliveredServiceInformation.serviceStartTime) &&
        Objects.equals(this.serviceEstablishedTime, deliveredServiceInformation.serviceEstablishedTime) &&
        Objects.equals(this.serviceEndTime, deliveredServiceInformation.serviceEndTime) &&
        Objects.equals(this.serviceDuration, deliveredServiceInformation.serviceDuration) &&
        Objects.equals(this.billedDuration, deliveredServiceInformation.billedDuration) &&
        Objects.equals(this.billedAmount, deliveredServiceInformation.billedAmount) &&
        Objects.equals(this.tariff, deliveredServiceInformation.tariff) &&
        Objects.equals(this.endCause, deliveredServiceInformation.endCause) &&
        Objects.equals(this.initialBalance, deliveredServiceInformation.initialBalance) &&
        Objects.equals(this.finalBalance, deliveredServiceInformation.finalBalance) &&
        Objects.equals(this.initialCredit, deliveredServiceInformation.initialCredit) &&
        Objects.equals(this.finalCredit, deliveredServiceInformation.finalCredit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originMSISDN, destinationMSISDN, serviceStartTime, serviceEstablishedTime, serviceEndTime, serviceDuration, billedDuration, billedAmount, tariff, endCause, initialBalance, finalBalance, initialCredit, finalCredit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeliveredServiceInformation {\n");
    
    sb.append("    originMSISDN: ").append(toIndentedString(originMSISDN)).append("\n");
    sb.append("    destinationMSISDN: ").append(toIndentedString(destinationMSISDN)).append("\n");
    sb.append("    serviceStartTime: ").append(toIndentedString(serviceStartTime)).append("\n");
    sb.append("    serviceEstablishedTime: ").append(toIndentedString(serviceEstablishedTime)).append("\n");
    sb.append("    serviceEndTime: ").append(toIndentedString(serviceEndTime)).append("\n");
    sb.append("    serviceDuration: ").append(toIndentedString(serviceDuration)).append("\n");
    sb.append("    billedDuration: ").append(toIndentedString(billedDuration)).append("\n");
    sb.append("    billedAmount: ").append(toIndentedString(billedAmount)).append("\n");
    sb.append("    tariff: ").append(toIndentedString(tariff)).append("\n");
    sb.append("    endCause: ").append(toIndentedString(endCause)).append("\n");
    sb.append("    initialBalance: ").append(toIndentedString(initialBalance)).append("\n");
    sb.append("    finalBalance: ").append(toIndentedString(finalBalance)).append("\n");
    sb.append("    initialCredit: ").append(toIndentedString(initialCredit)).append("\n");
    sb.append("    finalCredit: ").append(toIndentedString(finalCredit)).append("\n");
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

