package com.emerge.ocs.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Prefix
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-27T10:47:36.349Z")
public class Prefix {

    private Long id = 0l;

    private String country = null;

    private Long value = null;

    private String description = null;

//    private Long tariffVersionId = 0l;
//
//    private Long zoneId = 0l;

    public Prefix id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Used tariff
     *
     * @return id
  *
     */
    @ApiModelProperty(value = "Used tariff")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prefix country(String country) {
        this.country = country;
        return this;
    }

    /**
     * Country that own the prefix
     *
     * @return country
  *
     */
    @ApiModelProperty(required = true, value = "Country that own the prefix")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Prefix value(Long value) {
        this.value = value;
        return this;
    }

    /**
     * Value for the Prefix
     *
     * @return value
  *
     */
    @ApiModelProperty(required = true, value = "Value for the Prefix")
    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Prefix description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Information about the prefix
     *
     * @return description
  *
     */
    @ApiModelProperty(value = "Information about the prefix")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Prefix tariffVersionId(Long tariffVersionId) {
//        this.tariffVersionId = tariffVersionId;
//        return this;
//    }
//
//    /**
//     * Used tariff version Id
//     *
//     * @return tariffVersionId
//  *
//     */
//    @ApiModelProperty(required = true, value = "Used tariff version Id")
//    public Long getTariffVersionId() {
//        return tariffVersionId;
//    }
//
//    public void setTariffVersionId(Long tariffVersionId) {
//        this.tariffVersionId = tariffVersionId;
//    }
//
//    public Prefix zoneId(Long zoneId) {
//        this.zoneId = zoneId;
//        return this;
//    }
//
//    /**
//     * Used tariff version Id
//     *
//     * @return tariffVersionId
//  *
//     */
//    @ApiModelProperty(required = true, value = "Used zone Id")
//    public Long getZoneId() {
//        return zoneId;
//    }
//
//    public void setZoneId(Long zoneId) {
//        this.zoneId = zoneId;
//    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prefix prefix = (Prefix) o;
        return Objects.equals(this.id, prefix.id)
                && Objects.equals(this.country, prefix.country)
                && Objects.equals(this.value, prefix.value)
          //      && Objects.equals(this.tariffVersionId, prefix.tariffVersionId)
                && Objects.equals(this.description, prefix.description);
              //  && Objects.equals(this.zoneId, prefix.zoneId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, value, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Prefix {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
//        sb.append("    tariffVersionId: ").append(toIndentedString(tariffVersionId)).append("\n");
//        sb.append("    zoneId: ").append(toIndentedString(zoneId)).append("\n");
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
