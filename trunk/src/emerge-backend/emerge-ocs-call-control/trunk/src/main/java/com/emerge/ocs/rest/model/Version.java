package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;

/**
 * Version
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T14:27:56.968Z")
public class Version   {
  private Integer major = null;

  private Integer minor = null;

  private Integer patch = null;

  /**
   * Enum field containing - Allowed, Recommend, NotAllowed.
   */
  public enum StatusEnum {
    ALLOWED("Allowed"),
    
    RECOMMEND("Recommend"),
    
    NOTALLOWED("NotAllowed");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private StatusEnum status = null;

  public Version major(Integer major) {
    this.major = major;
    return this;
  }

   /**
   * Get major
   * @return major
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getMajor() {
    return major;
  }

  public void setMajor(Integer major) {
    this.major = major;
  }

  public Version minor(Integer minor) {
    this.minor = minor;
    return this;
  }

   /**
   * Get minor
   * @return minor
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getMinor() {
    return minor;
  }

  public void setMinor(Integer minor) {
    this.minor = minor;
  }

  public Version patch(Integer patch) {
    this.patch = patch;
    return this;
  }

   /**
   * Get patch
   * @return patch
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getPatch() {
    return patch;
  }

  public void setPatch(Integer patch) {
    this.patch = patch;
  }

  public Version status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Enum field containing - Allowed, Recommend, NotAllowed.
   * @return status
  **/
  @ApiModelProperty(value = "Enum field containing - Allowed, Recommend, NotAllowed.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Version version = (Version) o;
    return Objects.equals(this.major, version.major) &&
        Objects.equals(this.minor, version.minor) &&
        Objects.equals(this.patch, version.patch) &&
        Objects.equals(this.status, version.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(major, minor, patch, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Version {\n");
    
    sb.append("    major: ").append(toIndentedString(major)).append("\n");
    sb.append("    minor: ").append(toIndentedString(minor)).append("\n");
    sb.append("    patch: ").append(toIndentedString(patch)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

