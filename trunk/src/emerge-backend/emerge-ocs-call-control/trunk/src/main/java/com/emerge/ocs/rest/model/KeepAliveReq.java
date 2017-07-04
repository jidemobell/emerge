package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;


/**
 * KeepAliveReq
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-21T10:24:04.864Z")
public class KeepAliveReq   {
  private Payphone payphone = null;

  private LocationInformation locationInformation = null;

  private String accessToken = null;

  public KeepAliveReq payphone(Payphone payphone) {
    this.payphone = payphone;
    return this;
  }

   /**
   * Get payphone
   * @return payphone
  **/
  @ApiModelProperty(required = true, value = "")
  public Payphone getPayphone() {
    return payphone;
  }

  public void setPayphone(Payphone payphone) {
    this.payphone = payphone;
  }

  public KeepAliveReq locationInformation(LocationInformation locationInformation) {
    this.locationInformation = locationInformation;
    return this;
  }

   /**
   * Get locationInformation
   * @return locationInformation
  **/
  @ApiModelProperty(required = true, value = "")
  public LocationInformation getLocationInformation() {
    return locationInformation;
  }

  public void setLocationInformation(LocationInformation locationInformation) {
    this.locationInformation = locationInformation;
  }

  public KeepAliveReq accessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

   /**
   * User Access Token
   * @return accessToken
  **/
  @ApiModelProperty(value = "User Access Token")
  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeepAliveReq keepAliveReq = (KeepAliveReq) o;
    return Objects.equals(this.payphone, keepAliveReq.payphone) &&
        Objects.equals(this.locationInformation, keepAliveReq.locationInformation) &&
        Objects.equals(this.accessToken, keepAliveReq.accessToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payphone, locationInformation, accessToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeepAliveReq {\n");
    
    sb.append("    payphone: ").append(toIndentedString(payphone)).append("\n");
    sb.append("    locationInformation: ").append(toIndentedString(locationInformation)).append("\n");
    sb.append("    accessToken: ").append(toIndentedString(accessToken)).append("\n");
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

