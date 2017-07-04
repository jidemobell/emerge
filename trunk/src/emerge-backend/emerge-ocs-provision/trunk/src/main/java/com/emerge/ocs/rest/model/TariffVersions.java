package com.emerge.ocs.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;




/**
 * TariffVersions
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-28T14:29:29.416Z")
public class TariffVersions   {
  private Long id = 0l;

  private String description = null;

  private String status = null;

  private Date activationDate = null;

  public TariffVersions id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Used for tariff version id
   * @return id
  **/
  @ApiModelProperty(value = "Used for tariff version id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TariffVersions description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description of the Tarrif version
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Description of the Tarrif version")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TariffVersions status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Tarrif version status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "Tarrif version status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public TariffVersions activationDate(Date activationDate) {
    this.activationDate = (Date) activationDate.clone();
    return this;
  }

   /**
   * Activation date for the Tarrif .
   * @return activationDate
  **/
  @ApiModelProperty(required = true, value = "Activation date for the Tarrif .")
  public Date getActivationDate() {
    return (Date) activationDate.clone();
  }

  public void setActivationDate(Date activationDate) {
    this.activationDate = (Date) activationDate.clone();
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TariffVersions tariffVersions = (TariffVersions) o;
    return Objects.equals(this.id, tariffVersions.id) &&
        Objects.equals(this.description, tariffVersions.description) &&
        Objects.equals(this.status, tariffVersions.status) &&
        Objects.equals(this.activationDate, tariffVersions.activationDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, status, activationDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TariffVersions {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    activationDate: ").append(toIndentedString(activationDate)).append("\n");
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

