package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;


/**
 * Tariff
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-31T11:05:44.750Z")
public class Tariff   {
  private int id;

  private int groupId;

  private int zoneId;

  private double cost;

  public Tariff id(int id) {
    this.id = id;
    return this;
  }

   /**
   * Used tariff
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Used tariff")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Tariff groupId(int groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * Applied tariff group
   * @return groupId
  **/
  @ApiModelProperty(required = true, value = "Applied tariff group")
  public int getGroupId() {
    return groupId;
  }

  public void setGroupId(int groupId) {
    this.groupId = groupId;
  }

  public Tariff zoneId(int zoneId) {
    this.zoneId = zoneId;
    return this;
  }

   /**
   * Applied tariff zone
   * @return zoneId
  **/
  @ApiModelProperty(required = true, value = "Applied tariff zone")
  public int getZoneId() {
    return zoneId;
  }

  public void setZoneId(int zoneId) {
    this.zoneId = zoneId;
  }

  public Tariff cost(double cost) {
    this.cost = cost;
    return this;
  }

   /**
   * Applied tariff cost
   * @return cost
  **/
  @ApiModelProperty(required = true, value = "Applied tariff cost")
  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Tariff tariff = (Tariff) o;
    return Objects.equals(this.id, tariff.id) &&
        Objects.equals(this.groupId, tariff.groupId) &&
        Objects.equals(this.zoneId, tariff.zoneId) &&
        Objects.equals(this.cost, tariff.cost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, groupId, zoneId, cost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tariff {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    zoneId: ").append(toIndentedString(zoneId)).append("\n");
    sb.append("    cost: ").append(toIndentedString(cost)).append("\n");
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

