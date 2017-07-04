package com.emerge.ocs.rest.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * EndServiceRsp
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T14:27:56.968Z")
public class EndServiceRsp   {
  private String sessionID = null;

  private String serviceID = null;

  private DeliveredServiceInformation deliveredService = null;

  private Float remainingCredit = null;

  public EndServiceRsp sessionID(String sessionID) {
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

  public EndServiceRsp serviceID(String serviceID) {
    this.serviceID = serviceID;
    return this;
  }

   /**
   * OCS Service ID. Used to identify the service within the session on the OCS
   * @return serviceID
  **/
  @ApiModelProperty(required = true, value = "OCS Service ID. Used to identify the service within the session on the OCS")
  public String getServiceID() {
    return serviceID;
  }

  public void setServiceID(String serviceID) {
    this.serviceID = serviceID;
  }

  public EndServiceRsp deliveredService(DeliveredServiceInformation deliveredService) {
    this.deliveredService = deliveredService;
    return this;
  }

   /**
   * Get deliveredService
   * @return deliveredService
  **/
  @ApiModelProperty(required = true, value = "")
  public DeliveredServiceInformation getDeliveredService() {
    return deliveredService;
  }

  public void setDeliveredService(DeliveredServiceInformation deliveredService) {
    this.deliveredService = deliveredService;
  }

  public EndServiceRsp remainingCredit(Float remainingCredit) {
    this.remainingCredit = remainingCredit;
    return this;
  }

   /**
   * Remaining credit for additional services within the current session (Initial credit specified by the customer minus the cost of the delivered services so far)
   * @return remainingCredit
  **/
  @ApiModelProperty(required = true, value = "Remaining credit for additional services within the current session (Initial credit specified by the customer minus the cost of the delivered services so far)")
  public Float getRemainingCredit() {
    return remainingCredit;
  }

  public void setRemainingCredit(Float remainingCredit) {
    this.remainingCredit = remainingCredit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EndServiceRsp endServiceRsp = (EndServiceRsp) o;
    return Objects.equals(this.sessionID, endServiceRsp.sessionID) &&
        Objects.equals(this.serviceID, endServiceRsp.serviceID) &&
        Objects.equals(this.deliveredService, endServiceRsp.deliveredService) &&
        Objects.equals(this.remainingCredit, endServiceRsp.remainingCredit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionID, serviceID, deliveredService, remainingCredit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndServiceRsp {\n");
    
    sb.append("    sessionID: ").append(toIndentedString(sessionID)).append("\n");
    sb.append("    serviceID: ").append(toIndentedString(serviceID)).append("\n");
    sb.append("    deliveredService: ").append(toIndentedString(deliveredService)).append("\n");
    sb.append("    remainingCredit: ").append(toIndentedString(remainingCredit)).append("\n");
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

