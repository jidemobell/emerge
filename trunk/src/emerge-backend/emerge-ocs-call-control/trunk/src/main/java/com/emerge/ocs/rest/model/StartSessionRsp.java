package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * StartSessionRsp
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T14:27:56.968Z")
public class StartSessionRsp   {
  private String sessionID = null;

  private Date sessionStartTime = null;

  private PayphoneAuthenticationData payphoneAuthenticationData = null;

  private ConfigData configData = null;

  private Double balance = null;

  public StartSessionRsp sessionID(String sessionID) {
    this.sessionID = sessionID;
    return this;
  }

   /**
   * OCS Session ID. Used to identify the current session within the OCS
   * @return sessionID
  **/
  @ApiModelProperty(required = true, value = "OCS Session ID. Used to identify the current session within the OCS")
  public String getSessionID() {
    return sessionID;
  }

  public void setSessionID(String sessionID) {
    this.sessionID = sessionID;
  }

  public StartSessionRsp sessionStartTime(Date sessionStartTime) {
    this.sessionStartTime = (Date) sessionStartTime.clone();
    return this;
  }

   /**
   * Get sessionStartTime
   * @return sessionStartTime
  **/
  @ApiModelProperty(required = true, value = "")
  public Date getSessionStartTime() {
    return (Date) sessionStartTime.clone();
  }

  public void setSessionStartTime(Date sessionStartTime) {
    this.sessionStartTime = (Date) sessionStartTime.clone();
  }

  public StartSessionRsp payphoneAuthenticationData(PayphoneAuthenticationData payphoneAuthenticationData) {
    this.payphoneAuthenticationData = payphoneAuthenticationData;
    return this;
  }

   /**
   * Get payphoneAuthenticationData
   * @return payphoneAuthenticationData
  **/
  @ApiModelProperty(required = true, value = "")
  public PayphoneAuthenticationData getPayphoneAuthenticationData() {
    return payphoneAuthenticationData;
  }

  public void setPayphoneAuthenticationData(PayphoneAuthenticationData payphoneAuthenticationData) {
    this.payphoneAuthenticationData = payphoneAuthenticationData;
  }

  public StartSessionRsp configData(ConfigData configData) {
    this.configData = configData;
    return this;
  }

   /**
   * Get configData
   * @return configData
  **/
  @ApiModelProperty(value = "")
  public ConfigData getConfigData() {
    return configData;
  }

  public void setConfigData(ConfigData configData) {
    this.configData = configData;
  }

  public StartSessionRsp balance(Double balance) {
    this.balance = balance;
    return this;
  }

   /**
   * Get balance
   * @return balance
  **/
  @ApiModelProperty(required = true, value = "")
  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartSessionRsp startSessionRsp = (StartSessionRsp) o;
    return Objects.equals(this.sessionID, startSessionRsp.sessionID) &&
        Objects.equals(this.sessionStartTime, startSessionRsp.sessionStartTime) &&
        Objects.equals(this.payphoneAuthenticationData, startSessionRsp.payphoneAuthenticationData) &&
        Objects.equals(this.configData, startSessionRsp.configData) &&
        Objects.equals(this.balance, startSessionRsp.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, sessionStartTime, payphoneAuthenticationData, configData, balance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartSessionRsp {\n");
    
    sb.append("    sessionID: ").append(toIndentedString(sessionID)).append("\n");
    sb.append("    sessionStartTime: ").append(toIndentedString(sessionStartTime)).append("\n");
    sb.append("    payphoneAuthenticationData: ").append(toIndentedString(payphoneAuthenticationData)).append("\n");
    sb.append("    configData: ").append(toIndentedString(configData)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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

