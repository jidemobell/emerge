package com.emerge.ocs.rest.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * SpecialDay
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-02T01:54:15.796Z")
public class SpecialDay   {
  private Long id = 0l;

  private Integer day = null;

  private Integer month = null;

  private Integer year = null;

  private String description = null;

  public SpecialDay id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Used for the special day id
   * @return id
  **/
  @ApiModelProperty(value = "Used for the special day id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public SpecialDay day(Integer day) {
    this.day = day;
    return this;
  }

   /**
   * The day of the special day
   * @return day
  **/
  @ApiModelProperty(required = true, value = "The day of the special day")
  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  public SpecialDay month(Integer month) {
    this.month = month;
    return this;
  }

   /**
   * The month of the special day
   * @return month
  **/
  @ApiModelProperty(required = true, value = "The month of the special day")
  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public SpecialDay year(Integer year) {
    this.year = year;
    return this;
  }

   /**
   * The year of the special day
   * @return year
  **/
  @ApiModelProperty(required = true, value = "The year of the special day")
  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public SpecialDay description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Description  for the special day
   * @return description
  **/
  @ApiModelProperty(required = true, value = "Description  for the special day")
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
    SpecialDay specialDay = (SpecialDay) o;
    return Objects.equals(this.id, specialDay.id) &&
        Objects.equals(this.day, specialDay.day) &&
        Objects.equals(this.month, specialDay.month) &&
        Objects.equals(this.year, specialDay.year) &&
        Objects.equals(this.description, specialDay.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, day, month, year, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecialDay {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    day: ").append(toIndentedString(day)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    year: ").append(toIndentedString(year)).append("\n");
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

