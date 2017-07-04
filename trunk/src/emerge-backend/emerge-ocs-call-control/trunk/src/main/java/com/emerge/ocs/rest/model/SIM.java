package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;

/**
 * SIM
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T14:27:56.968Z")
public class SIM   {
  private String MSISDN = null;

  private String IMSI = null;

  private String ICCID = null;

  private Float BALANCE = null;

  public SIM MSISDN(String MSISDN) {
    this.MSISDN = MSISDN;
    return this;
  }

   /**
   * Get MSISDN
   * @return MSISDN
  **/
  @ApiModelProperty(required = true, value = "")
  public String getMSISDN() {
    return MSISDN;
  }

  public void setMSISDN(String MSISDN) {
    this.MSISDN = MSISDN;
  }

  public SIM IMSI(String IMSI) {
    this.IMSI = IMSI;
    return this;
  }

   /**
   * Get IMSI
   * @return IMSI
  **/
  @ApiModelProperty(required = true, value = "")
  public String getIMSI() {
    return IMSI;
  }

  public void setIMSI(String IMSI) {
    this.IMSI = IMSI;
  }

  public SIM ICCID(String ICCID) {
    this.ICCID = ICCID;
    return this;
  }

   /**
   * Get ICCID
   * @return ICCID
  **/
  @ApiModelProperty(required = true, value = "")
  public String getICCID() {
    return ICCID;
  }

  public void setICCID(String ICCID) {
    this.ICCID = ICCID;
  }

  public SIM BALANCE(Float BALANCE) {
    this.BALANCE = BALANCE;
    return this;
  }

   /**
   * Get BALANCE
   * @return BALANCE
  **/
  @ApiModelProperty(value = "")
  public Float getBALANCE() {
    return BALANCE;
  }

  public void setBALANCE(Float BALANCE) {
    this.BALANCE = BALANCE;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SIM SIM = (SIM) o;
    return Objects.equals(this.MSISDN, SIM.MSISDN) &&
        Objects.equals(this.IMSI, SIM.IMSI) &&
        Objects.equals(this.ICCID, SIM.ICCID) &&
        Objects.equals(this.BALANCE, SIM.BALANCE);
  }

  @Override
  public int hashCode() {
    return Objects.hash(MSISDN, IMSI, ICCID, BALANCE);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SIM {\n");
    
    sb.append("    MSISDN: ").append(toIndentedString(MSISDN)).append("\n");
    sb.append("    IMSI: ").append(toIndentedString(IMSI)).append("\n");
    sb.append("    ICCID: ").append(toIndentedString(ICCID)).append("\n");
    sb.append("    BALANCE: ").append(toIndentedString(BALANCE)).append("\n");
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

