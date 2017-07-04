package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;




/**
 * EndSessionRsp
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T14:27:56.968Z")
public class EndSessionRsp   {
  private Date sessionStartTime = null;

  private Date sessionEndTime = null;

  private BigDecimal sessionDuration = null;

  private BigDecimal numberOfServices = null;

  private BigDecimal totalServiceDuration = null;

  private BigDecimal totalBilledDuration = null;

  private BigDecimal totalBilledAmount = null;

  private String endCause = null;

  private Float remainingCredit = null;

  private Float payphoneBalance = null;

  public EndSessionRsp sessionStartTime(Date sessionStartTime) {
    this.sessionStartTime = new Date(sessionStartTime.toString());
    return this;
  }

   /**
   * Date/time when service has actually started
   * @return sessionStartTime
  **/
  @ApiModelProperty(required = true, value = "Date/time when service has actually started")
  public Date getSessionStartTime() {
    return (Date) sessionStartTime.clone();
  }

  public void setSessionStartTime(Date sessionStartTime) {
    this.sessionStartTime = (Date) sessionStartTime.clone();
  }

  public EndSessionRsp sessionEndTime(Date sessionEndTime) {
    this.sessionEndTime = (Date) sessionEndTime.clone();
    return this;
  }

   /**
   * Date/time when service has actually started
   * @return sessionEndTime
  **/
  @ApiModelProperty(required = true, value = "Date/time when service has actually started")
  public Date getSessionEndTime() {
    return (Date) sessionEndTime.clone();
  }

  public void setSessionEndTime(Date sessionEndTime) {
    this.sessionEndTime = (Date) sessionEndTime.clone();
  }

  public EndSessionRsp sessionDuration(BigDecimal sessionDuration) {
    this.sessionDuration = sessionDuration;
    return this;
  }

   /**
   * Session duration, in seconds
   * @return sessionDuration
  **/
  @ApiModelProperty(required = true, value = "Session duration, in seconds")
  public BigDecimal getSessionDuration() {
    return sessionDuration;
  }

  public void setSessionDuration(BigDecimal sessionDuration) {
    this.sessionDuration = sessionDuration;
  }

  public EndSessionRsp numberOfServices(BigDecimal numberOfServices) {
    this.numberOfServices = numberOfServices;
    return this;
  }

   /**
   * Number of services within the session
   * @return numberOfServices
  **/
  @ApiModelProperty(required = true, value = "Number of services within the session")
  public BigDecimal getNumberOfServices() {
    return numberOfServices;
  }

  public void setNumberOfServices(BigDecimal numberOfServices) {
    this.numberOfServices = numberOfServices;
  }

  public EndSessionRsp totalServiceDuration(BigDecimal totalServiceDuration) {
    this.totalServiceDuration = totalServiceDuration;
    return this;
  }

   /**
   * Total duration of all services within the session, in seconds
   * @return totalServiceDuration
  **/
  @ApiModelProperty(value = "Total duration of all services within the session, in seconds")
  public BigDecimal getTotalServiceDuration() {
    return totalServiceDuration;
  }

  public void setTotalServiceDuration(BigDecimal totalServiceDuration) {
    this.totalServiceDuration = totalServiceDuration;
  }

  public EndSessionRsp totalBilledDuration(BigDecimal totalBilledDuration) {
    this.totalBilledDuration = totalBilledDuration;
    return this;
  }

   /**
   * Total billed duration of all services within the session, in seconds
   * @return totalBilledDuration
  **/
  @ApiModelProperty(required = true, value = "Total billed duration of all services within the session, in seconds")
  public BigDecimal getTotalBilledDuration() {
    return totalBilledDuration;
  }

  public void setTotalBilledDuration(BigDecimal totalBilledDuration) {
    this.totalBilledDuration = totalBilledDuration;
  }

  public EndSessionRsp totalBilledAmount(BigDecimal totalBilledAmount) {
    this.totalBilledAmount = totalBilledAmount;
    return this;
  }

   /**
   * Total billed amount of all services within the session
   * @return totalBilledAmount
  **/
  @ApiModelProperty(required = true, value = "Total billed amount of all services within the session")
  public BigDecimal getTotalBilledAmount() {
    return totalBilledAmount;
  }

  public void setTotalBilledAmount(BigDecimal totalBilledAmount) {
    this.totalBilledAmount = totalBilledAmount;
  }

  public EndSessionRsp endCause(String endCause) {
    this.endCause = endCause;
    return this;
  }

   /**
   * Logical end cause of the session
   * @return endCause
  **/
  @ApiModelProperty(required = true, value = "Logical end cause of the session")
  public String getEndCause() {
    return endCause;
  }

  public void setEndCause(String endCause) {
    this.endCause = endCause;
  }

  public EndSessionRsp remainingCredit(Float remainingCredit) {
    this.remainingCredit = remainingCredit;
    return this;
  }

   /**
   * Remaining credit (Initial credit specified by the customer minus the cost of the delivered services)
   * @return remainingCredit
  **/
  @ApiModelProperty(required = true, value = "Remaining credit (Initial credit specified by the customer minus the cost of the delivered services)")
  public Float getRemainingCredit() {
    return remainingCredit;
  }

  public void setRemainingCredit(Float remainingCredit) {
    this.remainingCredit = remainingCredit;
  }

  public EndSessionRsp payphoneBalance(Float payphoneBalance) {
    this.payphoneBalance = payphoneBalance;
    return this;
  }

   /**
   * Remaining payphone balance
   * @return payphoneBalance
  **/
  @ApiModelProperty(required = true, value = "Remaining payphone balance")
  public Float getPayphoneBalance() {
    return payphoneBalance;
  }

  public void setPayphoneBalance(Float payphoneBalance) {
    this.payphoneBalance = payphoneBalance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EndSessionRsp endSessionRsp = (EndSessionRsp) o;
    return Objects.equals(this.sessionStartTime, endSessionRsp.sessionStartTime) &&
        Objects.equals(this.sessionEndTime, endSessionRsp.sessionEndTime) &&
        Objects.equals(this.sessionDuration, endSessionRsp.sessionDuration) &&
        Objects.equals(this.numberOfServices, endSessionRsp.numberOfServices) &&
        Objects.equals(this.totalServiceDuration, endSessionRsp.totalServiceDuration) &&
        Objects.equals(this.totalBilledDuration, endSessionRsp.totalBilledDuration) &&
        Objects.equals(this.totalBilledAmount, endSessionRsp.totalBilledAmount) &&
        Objects.equals(this.endCause, endSessionRsp.endCause) &&
        Objects.equals(this.remainingCredit, endSessionRsp.remainingCredit) &&
        Objects.equals(this.payphoneBalance, endSessionRsp.payphoneBalance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionStartTime, sessionEndTime, sessionDuration, numberOfServices, totalServiceDuration, totalBilledDuration, totalBilledAmount, endCause, remainingCredit, payphoneBalance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndSessionRsp {\n");
    
    sb.append("    sessionStartTime: ").append(toIndentedString(sessionStartTime)).append("\n");
    sb.append("    sessionEndTime: ").append(toIndentedString(sessionEndTime)).append("\n");
    sb.append("    sessionDuration: ").append(toIndentedString(sessionDuration)).append("\n");
    sb.append("    numberOfServices: ").append(toIndentedString(numberOfServices)).append("\n");
    sb.append("    totalServiceDuration: ").append(toIndentedString(totalServiceDuration)).append("\n");
    sb.append("    totalBilledDuration: ").append(toIndentedString(totalBilledDuration)).append("\n");
    sb.append("    totalBilledAmount: ").append(toIndentedString(totalBilledAmount)).append("\n");
    sb.append("    endCause: ").append(toIndentedString(endCause)).append("\n");
    sb.append("    remainingCredit: ").append(toIndentedString(remainingCredit)).append("\n");
    sb.append("    payphoneBalance: ").append(toIndentedString(payphoneBalance)).append("\n");
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

