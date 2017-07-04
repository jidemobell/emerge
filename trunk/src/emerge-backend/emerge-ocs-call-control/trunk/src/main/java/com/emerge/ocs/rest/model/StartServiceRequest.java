package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;




/**
 * StartServiceRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-01T11:22:47.845Z")
public class StartServiceRequest   {
  private String originMsisdn = null;

  private String destinationMsisdn = null;

  private double serviceCredit;

  private int payphoneID;

  private int id;

  public StartServiceRequest originMsisdn(String originMsisdn) {
    this.originMsisdn = originMsisdn;
    return this;
  }

   /**
   * msisdn used to originate the call.
   * @return originMsisdn
  **/
  @ApiModelProperty(required = true, value = "msisdn used to originate the call.")
  public String getOriginMsisdn() {
    return originMsisdn;
  }

  public void setOriginMsisdn(String originMsisdn) {
    this.originMsisdn = originMsisdn;
  }

  public StartServiceRequest destinationMsisdn(String destinationMsisdn) {
    this.destinationMsisdn = destinationMsisdn;
    return this;
  }

   /**
   * msisdn to call
   * @return destinationMsisdn
  **/
  @ApiModelProperty(required = true, value = "msisdn to call")
  public String getDestinationMsisdn() {
    return destinationMsisdn;
  }

  public void setDestinationMsisdn(String destinationMsisdn) {
    this.destinationMsisdn = destinationMsisdn;
  }

  public StartServiceRequest serviceCredit(double serviceCredit) {
    this.serviceCredit = serviceCredit;
    return this;
  }

   /**
   * Credit to spend on the service
   * @return serviceCredit
  **/
  @ApiModelProperty(required = true, value = "Credit to spend on the service")
  public double getServiceCredit() {
    return serviceCredit;
  }

  public void setServiceCredit(double serviceCredit) {
    this.serviceCredit = serviceCredit;
  }

  public StartServiceRequest payphoneID(int payphoneID) {
    this.payphoneID = payphoneID;
    return this;
  }

   /**
   * payphone ID initiating the call id is created by the OCS when creating a new Payphone. When specified in PUT or POST operations, it is ignored by the server.
   * @return payphoneID
  **/
  @ApiModelProperty(required = true, value = "payphone ID initiating the call id is created by the OCS when creating a new Payphone. When specified in PUT or POST operations, it is ignored by the server.")
  public int getPayphoneID() {
    return payphoneID;
  }

  public void setPayphoneID(int payphoneID) {
    this.payphoneID = payphoneID;
  }

  public StartServiceRequest id(int id) {
    this.id = id;
    return this;
  }

   /**
   * profile id is created by the OCS when creating a new Payphone Service. When specified in PUT or POST operations, it is ignored by the server.
   * @return id
  **/
  @ApiModelProperty(required = true, value = "profile id is created by the OCS when creating a new Payphone Service. When specified in PUT or POST operations, it is ignored by the server.")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartServiceRequest startServiceRequest = (StartServiceRequest) o;
    return Objects.equals(this.originMsisdn, startServiceRequest.originMsisdn) &&
        Objects.equals(this.destinationMsisdn, startServiceRequest.destinationMsisdn) &&
        Objects.equals(this.serviceCredit, startServiceRequest.serviceCredit) &&
        Objects.equals(this.payphoneID, startServiceRequest.payphoneID) &&
        Objects.equals(this.id, startServiceRequest.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originMsisdn, destinationMsisdn, serviceCredit, payphoneID, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartServiceRequest {\n");
    
    sb.append("    originMsisdn: ").append(toIndentedString(originMsisdn)).append("\n");
    sb.append("    destinationMsisdn: ").append(toIndentedString(destinationMsisdn)).append("\n");
    sb.append("    serviceCredit: ").append(toIndentedString(serviceCredit)).append("\n");
    sb.append("    payphoneID: ").append(toIndentedString(payphoneID)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

