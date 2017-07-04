package com.emerge.ocs.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Zones
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-27T14:57:44.531Z")
public class Zones   {
  private Long id = 0l;

  private String name = null;

  private String description = null;

  private Long groupId = 0l;

  public Zones id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Used for zone id
   * @return id
  **/
  @ApiModelProperty(value = "Used for zone id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Zones name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the zone
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the zone")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Zones description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description  for the zone
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Description  for the zone")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Zones groupId(Long groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * Information about the zone
   * @return groupId
  **/
  @ApiModelProperty(required = true, value = "Information about the zone")
  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Zones zones = (Zones) o;
    return Objects.equals(this.id, zones.id) &&
        Objects.equals(this.name, zones.name) &&
        Objects.equals(this.description, zones.description) &&
        Objects.equals(this.groupId, zones.groupId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, groupId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Zones {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
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

