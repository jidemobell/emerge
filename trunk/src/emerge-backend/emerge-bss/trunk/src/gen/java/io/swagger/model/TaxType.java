package io.swagger.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;




/**
 * TaxType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:54:31.527Z")
public class TaxType   {
  private long taxTypeId;

  private String taxCode = null;

  private String description = null;

  private long percentage;

  private Date startDate = null;

  private Date endDate = null;

  public TaxType taxTypeId(long taxTypeId) {
    this.taxTypeId = taxTypeId;
    return this;
  }

   /**
   * Get taxTypeId
   * @return taxTypeId
  **/
  @ApiModelProperty(value = "")
  public long getTaxTypeId() {
    return taxTypeId;
  }

  public void setTaxTypeId(long taxTypeId) {
    this.taxTypeId = taxTypeId;
  }

  public TaxType taxCode(String taxCode) {
    this.taxCode = taxCode;
    return this;
  }

   /**
   * Get taxCode
   * @return taxCode
  **/
  @ApiModelProperty(required = true, value = "")
  public String getTaxCode() {
    return taxCode;
  }

  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  public TaxType description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(required = true, value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TaxType percentage(long percentage) {
    this.percentage = percentage;
    return this;
  }

   /**
   * Get percentage
   * @return percentage
  **/
  @ApiModelProperty(required = true, value = "")
  public long getPercentage() {
    return percentage;
  }

  public void setPercentage(long percentage) {
    this.percentage = percentage;
  }

  public TaxType startDate(Date startDate) {
    this.startDate = (Date)startDate.clone();
    return this;
  }

   /**
   * Date when the tax type is active
   * @return startDate
  **/
  @ApiModelProperty(value = "Date when the tax type is active")
  public Date getStartDate() {
    return (Date)startDate.clone();
  }

  public void setStartDate(Date startDate) {
    this.startDate = (Date)startDate.clone();
  }

  public TaxType endDate(Date endDate) {
    this.endDate = (Date)endDate.clone();
    return this;
  }

   /**
   * Date when the tax type is active
   * @return endDate
  **/
  @ApiModelProperty(value = "Date when the tax type is active")
  public Date getEndDate() {
    return (Date)endDate.clone();
  }

  public void setEndDate(Date endDate) {
    this.endDate = (Date)endDate.clone();
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaxType taxType = (TaxType) o;
    return Objects.equals(this.taxTypeId, taxType.taxTypeId) &&
        Objects.equals(this.taxCode, taxType.taxCode) &&
        Objects.equals(this.description, taxType.description) &&
        Objects.equals(this.percentage, taxType.percentage) &&
        Objects.equals(this.startDate, taxType.startDate) &&
        Objects.equals(this.endDate, taxType.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(taxTypeId, taxCode, description, percentage, startDate, endDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaxType {\n");
    
    sb.append("    taxTypeId: ").append(toIndentedString(taxTypeId)).append("\n");
    sb.append("    taxCode: ").append(toIndentedString(taxCode)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

