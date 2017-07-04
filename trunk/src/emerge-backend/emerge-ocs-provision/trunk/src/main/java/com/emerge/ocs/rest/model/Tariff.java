package com.emerge.ocs.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;




/**
 * Tariff
 */
@javax.annotation.Generated(value =
        "class io.swagger.codegen.languages.JavaJerseyServerCodegen",
        date = "2016-10-26T14:27:06.896Z")
public class Tariff   {
  private Long id = 0l;
  private String name = null;
  private Long groupId = 0l;
  private Long zoneId = 0l;
  private Double initialCost = null;
  private Long initialDuration = null;
  private Double setupCost = null;
  private Long modulationTypeId = 0l;
  private Double recurrentCost = null;
  private Long recurrentDuration = null;
  private Long tariffVersionId = 0l;
  private Boolean status = false;
  private Long profileId = 0l;
  
  public Tariff id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Used tariff
   * @return id
  **/
  @ApiModelProperty(required = true, value = "Used tariff")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Tariff name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Tariff groupId(Long groupId) {
    this.groupId = groupId;
    return this;
  }

   /**
   * Applied tariff group
   * @return groupId
  **/
  @ApiModelProperty(required = true, value = "Applied tariff group")
  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }

  public Tariff zoneId(Long zoneId) {
    this.zoneId = zoneId;
    return this;
  }

   /**
   * Applied tariff zone
   * @return zoneId
  **/
  @ApiModelProperty(required = true, value = "Applied tariff zone")
  public Long getZoneId() {
    return zoneId;
  }

  public void setZoneId(Long zoneId) {
    this.zoneId = zoneId;
  }

  public Tariff cost(Double initialCost) {
    this.initialCost = initialCost;
    return this;
  }

   /**
   * Applied tariff cost
   * @return cost
  **/
  @ApiModelProperty(required = true, value = "Applied tariff cost")
  public Double getInitialCost() {
    return initialCost;
  }

  public void setInitialCost(Double initialCost) {
    this.initialCost = initialCost;
  }

  public Tariff initialDuration(Long initialDuration) {
    this.initialDuration = initialDuration;
    return this;
  }

   /**
   * Applied tariff initial duration
   * @return initialDuration
  **/
  @ApiModelProperty(required = true, value = "Applied tariff initial duration")
  public Long getInitialDuration() {
    return initialDuration;
  }

  public void setInitialDuration(Long initialDuration) {
    this.initialDuration = initialDuration;
  }

  public Tariff setupCost(Double setupCost) {
    this.setupCost = setupCost;
    return this;
  }

   /**
   * Applied tariff cost
   * @return setupCost
  **/
  @ApiModelProperty(required = true, value = "Applied tariff cost")
  public Double getSetupCost() {
    return setupCost;
  }

  public void setSetupCost(Double setupCost) {
    this.setupCost = setupCost;
  }

  public Tariff modulationType(Long modulationTypeId) {
    this.modulationTypeId = modulationTypeId;
    return this;
  }

   /**
   * Used tariff modulation type
   * @return modulationType
  **/
  @ApiModelProperty(required = true, value = "Used tariff modulation type")
  public Long getModulationTypeId() {
    return modulationTypeId;
  }

  public void setModulationTypeId(Long modulationTypeId) {
    this.modulationTypeId = modulationTypeId;
  }

  public Tariff recurrentCost(Double recurrentCost) {
    this.recurrentCost = recurrentCost;
    return this;
  }

   /**
   * Used tariff  recurrent cost
   * @return recurrentCost
  **/
  @ApiModelProperty(required = true, value = "Used tariff  recurrent cost")
  public Double getRecurrentCost() {
    return recurrentCost;
  }

  public void setRecurrentCost(Double recurrentCost) {
    this.recurrentCost = recurrentCost;
  }

  public Tariff recurrentDuration(Long recurrentDuration) {
    this.recurrentDuration = recurrentDuration;
    return this;
  }

   /**
   * Used tariff recurrent duration
   * @return recurrentDuration
  **/
  @ApiModelProperty(required = true, value = "Used tariff recurrent duration")
  public Long getRecurrentDuration() {
    return recurrentDuration;
  }

  public void setRecurrentDuration(Long recurrentDuration) {
    this.recurrentDuration = recurrentDuration;
  }

  public Tariff tariffVersionId(Long tariffVersionId) {
    this.tariffVersionId = tariffVersionId;
    return this;
  }

   /**
   * Used tariff version Id
   * @return tariffVersionId
  **/
  @ApiModelProperty(required = true, value = "Used tariff version Id")
  public Long getTariffVersionId() {
    return tariffVersionId;
  }

  public void setTariffVersionId(Long tariffVersionId) {
    this.tariffVersionId = tariffVersionId;
  }

  public Tariff status(Boolean status) {
    this.status = status;
    return this;
  }

   /**
   * Tariff status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "Tariff status")
  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public Tariff profileId(Long profileId) {
    this.profileId = profileId;
    return this;
  }

   /**
   * Used Profile Id tariff
   * @return profileId
  **/
  @ApiModelProperty(required = true, value = "Used Profile Id tariff")
  public Long getProfileId() {
    return profileId;
  }

  public void setProfileId(Long profileId) {
    this.profileId = profileId;
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
        Objects.equals(this.name, tariff.name) &&
        Objects.equals(this.groupId, tariff.groupId) &&
        Objects.equals(this.zoneId, tariff.zoneId) &&
        Objects.equals(this.initialCost, tariff.initialCost) &&
        Objects.equals(this.initialDuration, tariff.initialDuration) &&
        Objects.equals(this.setupCost, tariff.setupCost) &&
        Objects.equals(this.modulationTypeId, tariff.modulationTypeId) &&
        Objects.equals(this.recurrentCost, tariff.recurrentCost) &&
        Objects.equals(this.recurrentDuration, tariff.recurrentDuration) &&
        Objects.equals(this.tariffVersionId, tariff.tariffVersionId) &&
        Objects.equals(this.status, tariff.status) &&
        Objects.equals(this.profileId, tariff.profileId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, groupId, zoneId, initialCost, initialDuration, setupCost, modulationTypeId, recurrentCost, recurrentDuration, tariffVersionId, status, profileId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tariff {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    zoneId: ").append(toIndentedString(zoneId)).append("\n");
    sb.append("    initialCost: ").append(toIndentedString(initialCost)).append("\n");
    sb.append("    initialDuration: ").append(toIndentedString(initialDuration)).append("\n");
    sb.append("    setupCost: ").append(toIndentedString(setupCost)).append("\n");
    sb.append("    modulationTypeId: ").append(toIndentedString(modulationTypeId)).append("\n");
    sb.append("    recurrentCost: ").append(toIndentedString(recurrentCost)).append("\n");
    sb.append("    recurrentDuration: ").append(toIndentedString(recurrentDuration)).append("\n");
    sb.append("    tariffVersionId: ").append(toIndentedString(tariffVersionId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    profileId: ").append(toIndentedString(profileId)).append("\n");
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

