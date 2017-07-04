package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;




/**
 * EndServiceReq
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-03T09:24:27.365Z")
public class EndServiceReq   {

  private Date serviceStartTime = null;

  private Date callAnswerTime = null;

  private Date serviceEndTime = null;

  private int serviceDuration;

  private String endCause = null;

  public EndServiceReq serviceStartTime(Date serviceStartTime) {
    this.serviceStartTime = (Date) serviceStartTime.clone();
    return this;
  }

   /**
   * Get serviceStartTime
   * @return serviceStartTime
  **/
  @ApiModelProperty(required = true, value = "")
  public Date getServiceStartTime() {
    return (Date)serviceStartTime.clone();
  }

  public void setServiceStartTime(Date serviceStartTime) {
    this.serviceStartTime = (Date) serviceStartTime.clone();
  }

  public EndServiceReq callAnswerTime(Date callAnswerTime) {
    this.callAnswerTime = (Date) callAnswerTime.clone();
    return this;
  }

   /**
   * Get callAnswerTime
   * @return callAnswerTime
  **/
  @ApiModelProperty(required = true, value = "")
  public Date getCallAnswerTime() {
    return (Date) callAnswerTime.clone();
  }

  public void setCallAnswerTime(Date callAnswerTime) {
    this.callAnswerTime = (Date) callAnswerTime.clone();
  }

  public EndServiceReq serviceEndTime(Date serviceEndTime) {
    this.serviceEndTime = (Date) serviceEndTime.clone();
    return this;
  }

   /**
   * Get serviceEndTime
   * @return serviceEndTime
  **/
  @ApiModelProperty(required = true, value = "")
  public Date getServiceEndTime() {
    return (Date) serviceEndTime.clone();
  }

  public void setServiceEndTime(Date serviceEndTime) {
    this.serviceEndTime = (Date) serviceEndTime.clone();
  }

  public EndServiceReq serviceDuration(int serviceDuration) {
    this.serviceDuration = serviceDuration;
    return this;
  }

   /**
   * Get serviceDuration
   * @return serviceDuration
  **/
  @ApiModelProperty(required = true, value = "")
  public int getServiceDuration() {
    return serviceDuration;
  }

  public void setServiceDuration(int serviceDuration) {
    this.serviceDuration = serviceDuration;
  }

  public EndServiceReq endCause(String endCause) {
    this.endCause = endCause;
    return this;
  }

   /**
   * Get endCause
   * @return endCause
  **/
  @ApiModelProperty(required = true, value = "")
  public String getEndCause() {
    return endCause;
  }

  public void setEndCause(String endCause) {
    this.endCause = endCause;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EndServiceReq endServiceReq = (EndServiceReq) o;
    return
        Objects.equals(this.serviceStartTime, endServiceReq.serviceStartTime) &&
        Objects.equals(this.callAnswerTime, endServiceReq.callAnswerTime) &&
        Objects.equals(this.serviceEndTime, endServiceReq.serviceEndTime) &&
        Objects.equals(this.serviceDuration, endServiceReq.serviceDuration) &&
        Objects.equals(this.endCause, endServiceReq.endCause);
  }

  @Override
  public int hashCode() {
    return Objects.hash( serviceStartTime, callAnswerTime, serviceEndTime, serviceDuration, endCause);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EndServiceReq {\n");
    
    sb.append("    serviceStartTime: ").append(toIndentedString(serviceStartTime)).append("\n");
    sb.append("    callAnswerTime: ").append(toIndentedString(callAnswerTime)).append("\n");
    sb.append("    serviceEndTime: ").append(toIndentedString(serviceEndTime)).append("\n");
    sb.append("    serviceDuration: ").append(toIndentedString(serviceDuration)).append("\n");
    sb.append("    endCause: ").append(toIndentedString(endCause)).append("\n");
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

