package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;

/**
 * Equipment
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T14:27:56.968Z")
public class Equipment   {
  private String serialNr = null;

  private String MAC = null;

  private String iMEI1 = null;

  private String iMEI2 = null;

  public Equipment serialNr(String serialNr) {
    this.serialNr = serialNr;
    return this;
  }

   /**
   * Get serialNr
   * @return serialNr
  **/
  @ApiModelProperty(value = "")
  public String getSerialNr() {
    return serialNr;
  }

  public void setSerialNr(String serialNr) {
    this.serialNr = serialNr;
  }

  public Equipment MAC(String MAC) {
    this.MAC = MAC;
    return this;
  }

   /**
   * Get MAC
   * @return MAC
  **/
  @ApiModelProperty(value = "")
  public String getMAC() {
    return MAC;
  }

  public void setMAC(String MAC) {
    this.MAC = MAC;
  }

  public Equipment iMEI1(String iMEI1) {
    this.iMEI1 = iMEI1;
    return this;
  }

   /**
   * Get iMEI1
   * @return iMEI1
  **/
  @ApiModelProperty(required = true, value = "")
  public String getIMEI1() {
    return iMEI1;
  }

  public void setIMEI1(String iMEI1) {
    this.iMEI1 = iMEI1;
  }

  public Equipment iMEI2(String iMEI2) {
    this.iMEI2 = iMEI2;
    return this;
  }

   /**
   * Get iMEI2
   * @return iMEI2
  **/
  @ApiModelProperty(required = true, value = "")
  public String getIMEI2() {
    return iMEI2;
  }

  public void setIMEI2(String iMEI2) {
    this.iMEI2 = iMEI2;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Equipment equipment = (Equipment) o;
    return Objects.equals(this.serialNr, equipment.serialNr) &&
        Objects.equals(this.MAC, equipment.MAC) &&
        Objects.equals(this.iMEI1, equipment.iMEI1) &&
        Objects.equals(this.iMEI2, equipment.iMEI2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serialNr, MAC, iMEI1, iMEI2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Equipment {\n");
    
    sb.append("    serialNr: ").append(toIndentedString(serialNr)).append("\n");
    sb.append("    MAC: ").append(toIndentedString(MAC)).append("\n");
    sb.append("    iMEI1: ").append(toIndentedString(iMEI1)).append("\n");
    sb.append("    iMEI2: ").append(toIndentedString(iMEI2)).append("\n");
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

