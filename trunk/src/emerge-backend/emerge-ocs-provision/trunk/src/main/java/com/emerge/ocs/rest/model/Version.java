package com.emerge.ocs.rest.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;




/**
 * Version
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-18T16:03:25.845Z")
public class Version   {
  private Long major = 0l;

  private Long minor = 0l;

  private Long patch = 0l;

  public Version major(Long major) {
    this.major = major;
    return this;
  }

   /**
   * Get major
   * @return major
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getMajor() {
    return major;
  }

  public void setMajor(Long major) {
    this.major = major;
  }

  public Version minor(Long minor) {
    this.minor = minor;
    return this;
  }

   /**
   * Get minor
   * @return minor
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getMinor() {
    return minor;
  }

  public void setMinor(Long minor) {
    this.minor = minor;
  }

  public Version patch(Long patch) {
    this.patch = patch;
    return this;
  }

   /**
   * Get patch
   * @return patch
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getPatch() {
    return patch;
  }

  public void setPatch(Long patch) {
    this.patch = patch;
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
        Objects.equals(this.patch, version.patch);
  }

  @Override
  public int hashCode() {
    return Objects.hash(major, minor, patch);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Version {\n");
    
    sb.append("    major: ").append(toIndentedString(major)).append("\n");
    sb.append("    minor: ").append(toIndentedString(minor)).append("\n");
    sb.append("    patch: ").append(toIndentedString(patch)).append("\n");
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

