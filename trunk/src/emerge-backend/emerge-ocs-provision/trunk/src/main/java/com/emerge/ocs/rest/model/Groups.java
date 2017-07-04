package com.emerge.ocs.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Groups
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-27T14:57:44.531Z")
public class Groups   {
  private Long id = 0l;

  private String name = null;

  private String description = null;

  public Groups id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Used for group id
   * @return id
  **/
  @ApiModelProperty(value = "Used for group id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Groups name(String name) {
    this.name = name;
    return this;
  }

   /**
   * The name of the group
   * @return name
  **/
  @ApiModelProperty(required = true, value = "The name of the group")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Groups description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description  for the group
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Description  for the group")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Groups groups = (Groups) o;
    return Objects.equals(this.id, groups.id) &&
        Objects.equals(this.name, groups.name) &&
        Objects.equals(this.description, groups.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Groups {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

