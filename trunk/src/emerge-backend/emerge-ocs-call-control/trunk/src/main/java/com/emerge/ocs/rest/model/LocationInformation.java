package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;




/**
 * LocationInformation
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-18T14:38:13.405Z")
public class LocationInformation   {
  private String gsmCellId = null;

  private String gsmLocationAreaCode = null;

  private long gpsLat;

  private long gpsLong;

  public LocationInformation gsmCellId(String gsmCellId) {
    this.gsmCellId = gsmCellId;
    return this;
  }

   /**
   * GSM Cell Id
   * @return gsmCellId
  **/
  @ApiModelProperty(value = "GSM Cell Id")
  public String getGsmCellId() {
    return gsmCellId;
  }

  public void setGsmCellId(String gsmCellId) {
    this.gsmCellId = gsmCellId;
  }

  public LocationInformation gsmLocationAreaCode(String gsmLocationAreaCode) {
    this.gsmLocationAreaCode = gsmLocationAreaCode;
    return this;
  }

   /**
   * GSM Location Area Code
   * @return gsmLocationAreaCode
  **/
  @ApiModelProperty(value = "GSM Location Area Code")
  public String getGsmLocationAreaCode() {
    return gsmLocationAreaCode;
  }

  public void setGsmLocationAreaCode(String gsmLocationAreaCode) {
    this.gsmLocationAreaCode = gsmLocationAreaCode;
  }

  public LocationInformation gpsLat(long gpsLat) {
    this.gpsLat = gpsLat;
    return this;
  }

   /**
   * GPS Latitude
   * @return gpsLat
  **/
  @ApiModelProperty(value = "GPS Latitude")
  public long getGpsLat() {
    return gpsLat;
  }

  public void setGpsLat(long gpsLat) {
    this.gpsLat = gpsLat;
  }

  public LocationInformation gpsLong(long gpsLong) {
    this.gpsLong = gpsLong;
    return this;
  }

   /**
   * GPS Longitude
   * @return gpsLong
  **/
  @ApiModelProperty(value = "GPS Longitude")
  public long getGpsLong() {
    return gpsLong;
  }

  public void setGpsLong(long gpsLong) {
    this.gpsLong = gpsLong;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationInformation locationInformation = (LocationInformation) o;
    return Objects.equals(this.gsmCellId, locationInformation.gsmCellId) &&
        Objects.equals(this.gsmLocationAreaCode, locationInformation.gsmLocationAreaCode) &&
        Objects.equals(this.gpsLat, locationInformation.gpsLat) &&
        Objects.equals(this.gpsLong, locationInformation.gpsLong);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gsmCellId, gsmLocationAreaCode, gpsLat, gpsLong);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationInformation {\n");
    
    sb.append("    gsmCellId: ").append(toIndentedString(gsmCellId)).append("\n");
    sb.append("    gsmLocationAreaCode: ").append(toIndentedString(gsmLocationAreaCode)).append("\n");
    sb.append("    gpsLat: ").append(toIndentedString(gpsLat)).append("\n");
    sb.append("    gpsLong: ").append(toIndentedString(gpsLong)).append("\n");
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

