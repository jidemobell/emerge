package io.swagger.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;




/**
 * Equipment
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-18T16:03:25.845Z")
public class Equipment   {
  private String serialNr = null;

  private String MAC = null;

  private String IMEI1 = null;
  
   private String IMEI2 = null;

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

  public Equipment IMEI1(String IMEI1) {
    this.IMEI1 = IMEI1;
    return this;
  }
  
  public Equipment IMEI2(String IMEI2) {
    this.IMEI2 = IMEI2;
    return this;
  }

   /**
   * Get IMEI
   * @return IMEI
  **/
  @ApiModelProperty(required = true, value = "")
  public String getIMEI1() {
    return IMEI1;
  }

  
   /**
   * Get IMEI
   * @return IMEI
  **/
  @ApiModelProperty(required = true, value = "")
  public String getIMEI2() {
    return IMEI2;
  }

  public void setIMEI1(String IMEI1) {
    this.IMEI1 = IMEI1;
  }
  
    public void setIMEI2(String IMEI2) {
    this.IMEI2 = IMEI2;
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
        Objects.equals(this.IMEI1, equipment.IMEI1)&&
        Objects.equals(this.IMEI2, equipment.IMEI2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(serialNr, MAC, IMEI1,IMEI2);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Equipment {\n");
    
    sb.append("    serialNr: ").append(toIndentedString(serialNr)).append("\n");
    sb.append("    MAC: ").append(toIndentedString(MAC)).append("\n");
    sb.append("    IMEI1: ").append(toIndentedString(IMEI1)).append("\n");
    sb.append("    IMEI2: ").append(toIndentedString(IMEI2)).append("\n");
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

