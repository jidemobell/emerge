package com.emerge.ocs.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;



/**
 * Contains information about ongoing services
 **/

/**
 * Contains information about ongoing services
 */
@ApiModel(description = "Contains information about ongoing services")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-18T16:03:25.845Z")
public class OngoingServiceInformation   {
  private String originMSISDN = null;

  private String destinationMSISDN = null;

  private Date serviceStartTime = null;

  private Date serviceEstablishedTime = null;

  private BigDecimal serviceDuration = null;

  private Tariff tariff = null;

  public OngoingServiceInformation originMSISDN(String originMSISDN) {
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

  public OngoingServiceInformation destinationMSISDN(String destinationMSISDN) {
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

  public OngoingServiceInformation serviceStartTime(Date serviceStartTime) {
    this.serviceStartTime = new Date(serviceStartTime.toString());
    return this;
  }

   /**
   * Date/time when service was requested to start
   * @return serviceStartTime
  **/
  @ApiModelProperty(required = true, value = "Date/time when service was requested to start")
  public Date getServiceStartTime() {
    return new Date(serviceStartTime.toString());
  }

  public void setServiceStartTime(Date serviceStartTime) {
    this.serviceStartTime = new Date(serviceStartTime.toString());
  }

  public OngoingServiceInformation serviceEstablishedTime(Date serviceEstablishedTime) {
    this.serviceEstablishedTime = new Date(serviceEstablishedTime.toString());
    return this;
  }

   /**
   * Date/time when service has actually started
   * @return serviceEstablishedTime
  **/
  @ApiModelProperty(required = true, value = "Date/time when service has actually started")
  public Date getServiceEstablishedTime() {
    return new Date(serviceEstablishedTime.toString());
  }

  public void setServiceEstablishedTime(Date serviceEstablishedTime) {
    this.serviceEstablishedTime = new Date(serviceEstablishedTime.toString());
  }

  public OngoingServiceInformation serviceDuration(BigDecimal serviceDuration) {
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

  public OngoingServiceInformation tariff(Tariff tariff) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OngoingServiceInformation ongoingServiceInformation = (OngoingServiceInformation) o;
    return Objects.equals(this.originMSISDN, ongoingServiceInformation.originMSISDN) &&
        Objects.equals(this.destinationMSISDN, ongoingServiceInformation.destinationMSISDN) &&
        Objects.equals(this.serviceStartTime, ongoingServiceInformation.serviceStartTime) &&
        Objects.equals(this.serviceEstablishedTime, ongoingServiceInformation.serviceEstablishedTime) &&
        Objects.equals(this.serviceDuration, ongoingServiceInformation.serviceDuration) &&
        Objects.equals(this.tariff, ongoingServiceInformation.tariff);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originMSISDN, destinationMSISDN, serviceStartTime, serviceEstablishedTime, serviceDuration, tariff);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OngoingServiceInformation {\n");
    
    sb.append("    originMSISDN: ").append(toIndentedString(originMSISDN)).append("\n");
    sb.append("    destinationMSISDN: ").append(toIndentedString(destinationMSISDN)).append("\n");
    sb.append("    serviceStartTime: ").append(toIndentedString(serviceStartTime)).append("\n");
    sb.append("    serviceEstablishedTime: ").append(toIndentedString(serviceEstablishedTime)).append("\n");
    sb.append("    serviceDuration: ").append(toIndentedString(serviceDuration)).append("\n");
    sb.append("    tariff: ").append(toIndentedString(tariff)).append("\n");
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

