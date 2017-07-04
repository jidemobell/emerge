package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;




/**
 * PayphoneAuthenticationData
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-18T10:20:17.665Z")
public class PayphoneAuthenticationData   {
  private String accessToken = null;

  private int sessionID;

  private String message = null;

  private String code = null;

  private Date sessionStartTime = null;

  private ConfigData configData = null;

  private double balance;

  public PayphoneAuthenticationData accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

   /**
   * Access Token, created by the OCS.
   * @return accessToken
  **/
  @ApiModelProperty(required = true, value = "Access Token, created by the OCS.")
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public PayphoneAuthenticationData sessionID(int sessionID) {
    this.sessionID = sessionID;
    return this;
  }

   /**
   * Session ID, created by the OCS
   * @return sessionID
  **/
  @ApiModelProperty(required = true, value = "Session ID, created by the OCS")
  public int getSessionID() {
    return sessionID;
  }

  public void setSessionID(int sessionID) {
    this.sessionID = sessionID;
  }

  public PayphoneAuthenticationData message(String message) {
    this.message = message;
    return this;
  }

   /**
   * Authentication status message.
   * @return message
  **/
  @ApiModelProperty(required = true, value = "Authentication status message.")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public PayphoneAuthenticationData code(String code) {
    this.code = code;
    return this;
  }

   /**
   * Authentication status code
   * @return code
  **/
  @ApiModelProperty(required = true, value = "Authentication status code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public PayphoneAuthenticationData sessionStartTime(Date sessionStartTime) {
    
    if (sessionStartTime != null) {
        this.sessionStartTime = (Date) sessionStartTime.clone();
    }
    
    return this;
  }

   /**
   * Get sessionStartTime
   * @return sessionStartTime
  **/
  @ApiModelProperty(value = "")
  public Date getSessionStartTime() {
      
    if (sessionStartTime != null) {
        return (Date) sessionStartTime.clone();
    }
  
    return new Date();
  }

  public void setSessionStartTime(Date sessionStartTime) {
    this.sessionStartTime = (Date) sessionStartTime.clone();
  }

  public PayphoneAuthenticationData configData(ConfigData configData) {
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

  public PayphoneAuthenticationData balance(double balance) {
    this.balance = balance;
    return this;
  }

   /**
   * Get balance
   * @return balance
  **/
  @ApiModelProperty(value = "")
  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
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
    PayphoneAuthenticationData payphoneAuthenticationData = (PayphoneAuthenticationData) o;
    return Objects.equals(this.accessToken, payphoneAuthenticationData.accessToken) &&
        Objects.equals(this.sessionID, payphoneAuthenticationData.sessionID) &&
        Objects.equals(this.message, payphoneAuthenticationData.message) &&
        Objects.equals(this.code, payphoneAuthenticationData.code) &&
        Objects.equals(this.sessionStartTime, payphoneAuthenticationData.sessionStartTime) &&
        Objects.equals(this.configData, payphoneAuthenticationData.configData) &&
        Objects.equals(this.balance, payphoneAuthenticationData.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessToken, sessionID, message, code, sessionStartTime, configData, balance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayphoneAuthenticationData {\n");
    
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
    sb.append("    sessionID: ").append(toIndentedString(sessionID)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    sessionStartTime: ").append(toIndentedString(sessionStartTime)).append("\n");
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

