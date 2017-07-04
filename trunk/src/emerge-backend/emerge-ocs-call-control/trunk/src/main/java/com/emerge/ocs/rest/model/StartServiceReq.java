package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

/**
 * StartServiceReq
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T14:27:56.968Z")
public class StartServiceReq   {
  private String originMSISDN = null;

  private String destinationMSISDN = null;

  private BigDecimal serviceCredit = null;

  private Long payphoneID = null;

  public StartServiceReq originMSISDN(String originMSISDN) {
    this.originMSISDN = originMSISDN;
    return this;
  }

   /**
   * MSISDN used to originate the call.
   * @return originMSISDN
  **/
  @ApiModelProperty(required = true, value = "MSISDN used to originate the call.")
  public String getOriginMSISDN() {
    return originMSISDN;
  }

  public void setOriginMSISDN(String originMSISDN) {
    this.originMSISDN = originMSISDN;
  }

  public StartServiceReq destinationMSISDN(String destinationMSISDN) {
    this.destinationMSISDN = destinationMSISDN;
    return this;
  }

   /**
   * MSISDN to call
   * @return destinationMSISDN
  **/
  @ApiModelProperty(required = true, value = "MSISDN to call")
  public String getDestinationMSISDN() {
    return destinationMSISDN;
  }

  public void setDestinationMSISDN(String destinationMSISDN) {
    this.destinationMSISDN = destinationMSISDN;
  }

  public StartServiceReq serviceCredit(BigDecimal serviceCredit) {
    this.serviceCredit = serviceCredit;
    return this;
  }

   /**
   * Credit to spend on the service
   * @return serviceCredit
  **/
  @ApiModelProperty(required = true, value = "Credit to spend on the service")
  public BigDecimal getServiceCredit() {
    return serviceCredit;
  }

  public void setServiceCredit(BigDecimal serviceCredit) {
    this.serviceCredit = serviceCredit;
  }

  public StartServiceReq payphoneID(Long payphoneID) {
    this.payphoneID = payphoneID;
    return this;
  }

   /**
   * PayphoneID is created by the OCS when creating a new Payphone. When specified in PUT or POST operations, it is ignored by the server.
   * @return payphoneID
  **/
  @ApiModelProperty(value = "PayphoneID is created by the OCS when creating a new Payphone. When specified in PUT or POST operations, it is ignored by the server.")
  public Long getPayphoneID() {
    return payphoneID;
  }

  public void setPayphoneID(Long payphoneID) {
    this.payphoneID = payphoneID;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartServiceReq startServiceReq = (StartServiceReq) o;
    return Objects.equals(this.originMSISDN, startServiceReq.originMSISDN) &&
        Objects.equals(this.destinationMSISDN, startServiceReq.destinationMSISDN) &&
        Objects.equals(this.serviceCredit, startServiceReq.serviceCredit) &&
        Objects.equals(this.payphoneID, startServiceReq.payphoneID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originMSISDN, destinationMSISDN, serviceCredit, payphoneID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartServiceReq {\n");
    
    sb.append("    originMSISDN: ").append(toIndentedString(originMSISDN)).append("\n");
    sb.append("    destinationMSISDN: ").append(toIndentedString(destinationMSISDN)).append("\n");
    sb.append("    serviceCredit: ").append(toIndentedString(serviceCredit)).append("\n");
    sb.append("    payphoneID: ").append(toIndentedString(payphoneID)).append("\n");
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

