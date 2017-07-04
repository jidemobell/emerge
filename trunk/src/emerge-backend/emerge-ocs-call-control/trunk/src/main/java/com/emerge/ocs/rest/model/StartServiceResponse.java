package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;




/**
 * StartServiceResponse
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-31T09:38:26.924Z")
public class StartServiceResponse   {
  private int serviceId;

  private Date serviceAuthorizedTime = null;

  private String originMsisdn = null;

  private double maxServiceDuration;

  private Tariff tariff = null;

  public StartServiceResponse serviceId(int serviceId) {
    this.serviceId = serviceId;
    return this;
  }

   /**
   * OCS Service ID. Used to identify the current service within the OCS and current session_id.
   * @return serviceId
  **/
  @ApiModelProperty(required = true, value = "OCS Service ID. Used to identify the current service within the OCS and current session_id.")
  public int getServiceId() {
    return serviceId;
  }

  public void setServiceId(int serviceId) {
    this.serviceId = serviceId;
  }

  public StartServiceResponse serviceAuthorizedTime(Date serviceAuthorizedTime) {
    this.serviceAuthorizedTime = (Date) serviceAuthorizedTime.clone();
    return this;
  }

   /**
   * Date/time when the service was authorized
   * @return serviceAuthorizedTime
  **/
  @ApiModelProperty(required = true, value = "Date/time when the service was authorized")
  public Date getServiceAuthorizedTime() {
    return (Date) serviceAuthorizedTime.clone();
  }

  public void setServiceAuthorizedTime(Date serviceAuthorizedTime) {
    this.serviceAuthorizedTime = (Date) serviceAuthorizedTime.clone();
  }

  public StartServiceResponse originMsisdn(String originMsisdn) {
    this.originMsisdn = originMsisdn;
    return this;
  }

   /**
   * msisdn that the Payphone must use to originate the call
   * @return originMsisdn
  **/
  @ApiModelProperty(value = "msisdn that the Payphone must use to originate the call")
  public String getOriginMsisdn() {
    return originMsisdn;
  }

  public void setOriginMsisdn(String originMsisdn) {
    this.originMsisdn = originMsisdn;
  }

  public StartServiceResponse maxServiceDuration(int maxServiceDuration) {
    this.maxServiceDuration = maxServiceDuration;
    return this;
  }

   /**
   * Maximum service duration. To be enforced by the payphone application.
   * @return maxServiceDuration
  **/
  @ApiModelProperty(required = true, value = "Maximum service duration. To be enforced by the payphone application.")
  public double getMaxServiceDuration() {
    return maxServiceDuration;
  }

  public void setMaxServiceDuration(double maxServiceDuration) {
    this.maxServiceDuration = maxServiceDuration;
  }

  public StartServiceResponse tariff(Tariff tariff) {
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
    StartServiceResponse startServiceResponse = (StartServiceResponse) o;
    return Objects.equals(this.serviceId, startServiceResponse.serviceId) &&
        Objects.equals(this.serviceAuthorizedTime, startServiceResponse.serviceAuthorizedTime) &&
        Objects.equals(this.originMsisdn, startServiceResponse.originMsisdn) &&
        Objects.equals(this.maxServiceDuration, startServiceResponse.maxServiceDuration) &&
        Objects.equals(this.tariff, startServiceResponse.tariff);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceId, serviceAuthorizedTime, originMsisdn, maxServiceDuration, tariff);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartServiceResponse {\n");
    
    sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
    sb.append("    serviceAuthorizedTime: ").append(toIndentedString(serviceAuthorizedTime)).append("\n");
    sb.append("    originMsisdn: ").append(toIndentedString(originMsisdn)).append("\n");
    sb.append("    maxServiceDuration: ").append(toIndentedString(maxServiceDuration)).append("\n");
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

