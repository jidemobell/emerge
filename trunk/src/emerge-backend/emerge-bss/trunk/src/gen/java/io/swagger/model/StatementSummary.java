package io.swagger.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;




/**
 * StatementSummary
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-11-10T11:13:25.810Z")
public class StatementSummary   {
  private BigDecimal statementSummaryId = null;

  private String bankName = null;

  private String description = null;

  private long numberOfEntries ;

  private Double totalSum = null;

  private String fileId = null;

  public StatementSummary statementSummaryId(BigDecimal statementSummaryId) {
    this.statementSummaryId = statementSummaryId;
    return this;
  }

   /**
   * Get statementSummaryId
   * @return statementSummaryId
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getStatementSummaryId() {
    return statementSummaryId;
  }

  public void setStatementSummaryId(BigDecimal statementSummaryId) {
    this.statementSummaryId = statementSummaryId;
  }

  public StatementSummary bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

   /**
   * Get bankName
   * @return bankName
  **/
  @ApiModelProperty(required = true, value = "")
  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public StatementSummary description(String description) {
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

  public StatementSummary numberOfEntries(long numberOfEntries) {
    this.numberOfEntries = numberOfEntries;
    return this;
  }

   /**
   * Get numberOfEntries
   * @return numberOfEntries
  **/
  @ApiModelProperty(required = true, value = "")
  public long getNumberOfEntries() {
    return numberOfEntries;
  }

  public void setNumberOfEntries(long numberOfEntries) {
    this.numberOfEntries = numberOfEntries;
  }

  public StatementSummary totalSum(Double totalSum) {
    this.totalSum = totalSum;
    return this;
  }

   /**
   * Total sum of the upload
   * @return totalSum
  **/
  @ApiModelProperty(required = true, value = "Total sum of the upload")
  public Double getTotalSum() {
    return totalSum;
  }

  public void setTotalSum(Double totalSum) {
    this.totalSum = totalSum;
  }

  public StatementSummary fileId(String fileId) {
    this.fileId = fileId;
    return this;
  }

   /**
   * id that denotes the file to process, this must have been saved during upload
   * @return fileId
  **/
  @ApiModelProperty(value = "id that denotes the file to process, this must have been saved during upload")
  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatementSummary statementSummary = (StatementSummary) o;
    return Objects.equals(this.statementSummaryId, statementSummary.statementSummaryId) &&
        Objects.equals(this.bankName, statementSummary.bankName) &&
        Objects.equals(this.description, statementSummary.description) &&
        Objects.equals(this.numberOfEntries, statementSummary.numberOfEntries) &&
        Objects.equals(this.totalSum, statementSummary.totalSum) &&
        Objects.equals(this.fileId, statementSummary.fileId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statementSummaryId, bankName, description, numberOfEntries, totalSum, fileId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatementSummary {\n");
    
    sb.append("    statementSummaryId: ").append(toIndentedString(statementSummaryId)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    numberOfEntries: ").append(toIndentedString(numberOfEntries)).append("\n");
    sb.append("    totalSum: ").append(toIndentedString(totalSum)).append("\n");
    sb.append("    fileId: ").append(toIndentedString(fileId)).append("\n");
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

