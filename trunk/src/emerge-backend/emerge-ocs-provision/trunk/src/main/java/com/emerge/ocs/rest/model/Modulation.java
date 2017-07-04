package com.emerge.ocs.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Modulation
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages."
        + "JavaJerseyServerCodegen", date = "2016-11-02T01:54:15.796Z")
public class Modulation {

    private Long id = 0l;
    private String days = null;
    private Integer endTime = null;

    private Long profileId = 0l;

    private Long modulationTypeId = 0l;

    private Long tariffVersionId = 0l;

    private String description = null;
    private String name = null;

    public Modulation id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Used for the special day id
     *
     * @return id
  *
     */
    @ApiModelProperty(value = "Used for the special day id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modulation days(String days) {
        this.days = days;
        return this;
    }

    /**
     * The days for the modulation
     *
     * @return days
  *
     */
    @ApiModelProperty(required = true, value = "The days for the modulation")
    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Modulation endTime(Integer endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * The end time for the modulation
     *
     * @return endTime
  *
     */
    @ApiModelProperty(required = true, value = "The end time for the modulation")
    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public Modulation profileId(Long profileId) {
        this.profileId = profileId;
        return this;
    }

    /**
     * The tariffVersionId for the modulation
     *
     * @return profileId
  *
     */
    @ApiModelProperty(required = true, value = "The profile id for the modulation")
    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Modulation tariffVersionId(Long tariffVersionId) {
        this.tariffVersionId = tariffVersionId;
        return this;
    }

    /**
     * The tariffVersionId id for the modulation
     *
     * @return profileId
  *
     */
    @ApiModelProperty(required = true, value = "The Tariif version id for the modulation")
    public Long getTariffVersionId() {
        return tariffVersionId;
    }

    public void setTariffVersionId(Long tariffVersionId) {
        this.tariffVersionId = tariffVersionId;
    }

    public Modulation modulationTypeId(Long modulationTypeId) {
        this.modulationTypeId = modulationTypeId;
        return this;
    }

    /**
     * The modulation type id for the modulation
     *
     * @return modulationTypeId
  *
     */
    @ApiModelProperty(required = true, value = "The modulation type id  for the modulation")
    public Long getModulationTypeId() {
        return modulationTypeId;
    }

    public void setModulationTypeId(Long modulationTypeId) {
        this.modulationTypeId = modulationTypeId;
    }

    public Modulation description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description for the Modulation
     *
     * @return description
  *
     */
    @ApiModelProperty(value = "Description  for the Modulation")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
     public Modulation names(String name) {
        this.name  = name;
        return this;
    }

    /**
     * Description for the Modulation
     *
     * @return description
  *
     */
    @ApiModelProperty(value = "Name  for the Modulation")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Modulation modulation = (Modulation) o;
        return Objects.equals(this.id, modulation.id)
                && Objects.equals(this.days, modulation.days)
                && Objects.equals(this.endTime, modulation.endTime)
                && Objects.equals(this.name, modulation.name)
                && Objects.equals(this.profileId, modulation.profileId)
                && Objects.equals(this.modulationTypeId, modulation.modulationTypeId)
                && Objects.equals(this.description, modulation.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, days, endTime,name, profileId, modulationTypeId, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Modulation {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    days: ").append(toIndentedString(days)).append("\n");
        sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    profileId: ").append(toIndentedString(profileId)).append("\n");
        sb.append("    modulationTypeId: ").append(toIndentedString(modulationTypeId)).append("\n");
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
