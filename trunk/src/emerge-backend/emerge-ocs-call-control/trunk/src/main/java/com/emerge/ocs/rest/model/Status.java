package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * Status
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T14:27:56.968Z")
public class Status   {
  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    INACTIVE("Inactive"),
    
    READY("Ready"),
    
    ACTIVE("Active"),
    
    DELETED("Deleted");

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

  private Date statusDate = null;

  public Status status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(required = true, value = "")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Status statusDate(Date statusDate) {
    this.statusDate = (Date) statusDate.clone();
    return this;
  }

   /**
   * Start date of current status.
   * @return statusDate
  **/
  @ApiModelProperty(value = "Start date of current status.")
  public Date getStatusDate() {
    return (Date) statusDate.clone();
  }

  public void setStatusDate(Date statusDate) {
    this.statusDate = (Date) statusDate.clone();
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Status status = (Status) o;
    return Objects.equals(this.status, status.status) &&
        Objects.equals(this.statusDate, status.statusDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, statusDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Status {\n");
    
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    statusDate: ").append(toIndentedString(statusDate)).append("\n");
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

