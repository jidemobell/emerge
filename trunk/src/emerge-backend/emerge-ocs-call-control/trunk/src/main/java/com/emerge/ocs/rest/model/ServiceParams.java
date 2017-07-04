package com.emerge.ocs.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;




/**
 * ServiceParams
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-03T12:54:10.032Z")
public class ServiceParams   {
    
  private Date serviceStartTime = null;

  private Date callAnswerTime = null;

  private Integer payphoneID = null;

  public ServiceParams serviceStartTime(Date serviceStartTime) {
    this.serviceStartTime = (Date) serviceStartTime.clone();
    return this;
  }

   /**
   * Get serviceStartTime
   * @return serviceStartTime
  **/
  @ApiModelProperty(required = true, value = "")
  public Date getServiceStartTime() {
    return (Date) serviceStartTime.clone();
  }

  public void setServiceStartTime(Date serviceStartTime) {
    this.serviceStartTime = (Date) serviceStartTime.clone();
  }

  public ServiceParams callAnswerTime(Date callAnswerTime) {
    this.callAnswerTime = (Date) callAnswerTime.clone();
    return this;
  }

   /**
   * Get callAnswerTime
   * @return callAnswerTime
  **/
  @ApiModelProperty(value = "")
  public Date getCallAnswerTime() {
    return (Date) callAnswerTime.clone();
  }

  public void setCallAnswerTime(Date callAnswerTime) {
    this.callAnswerTime = (Date) callAnswerTime.clone();
  }

  public ServiceParams payphoneID(int payphoneID) {
    this.payphoneID = payphoneID;
    return this;
  }

   /**
   * Get payphoneID
   * @return payphoneID
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getPayphoneID() {
    return payphoneID;
  }

  public void setPayphoneID(Integer payphoneID) {
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
    ServiceParams serviceParams = (ServiceParams) o;
    return
        Objects.equals(this.serviceStartTime, serviceParams.serviceStartTime) &&
        Objects.equals(this.callAnswerTime, serviceParams.callAnswerTime) &&
        Objects.equals(this.payphoneID, serviceParams.payphoneID);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceStartTime, callAnswerTime, payphoneID);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ServiceParams {\n");
    sb.append("    serviceStartTime: ").append(toIndentedString(serviceStartTime)).append("\n");
    sb.append("    callAnswerTime: ").append(toIndentedString(callAnswerTime)).append("\n");
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

