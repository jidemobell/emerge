package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;




/**
 * AuthenticationReq
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-18T14:38:13.405Z")
public class AuthenticationReq   {
  private Payphone payphone = null;

  private LocationInformation locationInformation = null;
  
  public AuthenticationReq payphone(Payphone payphone) {
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

  public AuthenticationReq locationInformation(LocationInformation locationInformation) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticationReq authenticationReq = (AuthenticationReq) o;
    return Objects.equals(this.payphone, authenticationReq.payphone) &&
        Objects.equals(this.locationInformation, authenticationReq.locationInformation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payphone, locationInformation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationReq {\n");
    
    sb.append("    payphone: ").append(toIndentedString(payphone)).append("\n");
    sb.append("    locationInformation: ").append(toIndentedString(locationInformation)).append("\n");
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

