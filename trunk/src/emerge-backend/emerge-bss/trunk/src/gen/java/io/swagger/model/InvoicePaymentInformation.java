package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;



/**
 * Payment information. Only used for Postpaid contracts
 **/

/**
 * Payment information. Only used for Postpaid contracts
 */
@ApiModel(description = "Payment information. Only used for Postpaid contracts")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:54:31.527Z")
public class InvoicePaymentInformation   {
  private String emisCode = null;

  private String emisReference = null;

  private String sepaReference = null;

  private String sepaAccount = null;

  private String sepaBankId = null;

  private Date dueDate = null;

  public InvoicePaymentInformation emisCode(String emisCode) {
    this.emisCode = emisCode;
    return this;
  }

   /**
   * Get emisCode
   * @return emisCode
  **/
  @ApiModelProperty(value = "")
  public String getEmisCode() {
    return emisCode;
  }

  public void setEmisCode(String emisCode) {
    this.emisCode = emisCode;
  }

  public InvoicePaymentInformation emisReference(String emisReference) {
    this.emisReference = emisReference;
    return this;
  }

   /**
   * Get emisReference
   * @return emisReference
  **/
  @ApiModelProperty(value = "")
  public String getEmisReference() {
    return emisReference;
  }

  public void setEmisReference(String emisReference) {
    this.emisReference = emisReference;
  }

  public InvoicePaymentInformation sepaReference(String sepaReference) {
    this.sepaReference = sepaReference;
    return this;
  }

   /**
   * Get sepaReference
   * @return sepaReference
  **/
  @ApiModelProperty(value = "")
  public String getSepaReference() {
    return sepaReference;
  }

  public void setSepaReference(String sepaReference) {
    this.sepaReference = sepaReference;
  }

  public InvoicePaymentInformation sepaAccount(String sepaAccount) {
    this.sepaAccount = sepaAccount;
    return this;
  }

   /**
   * Get sepaAccount
   * @return sepaAccount
  **/
  @ApiModelProperty(value = "")
  public String getSepaAccount() {
    return sepaAccount;
  }

  public void setSepaAccount(String sepaAccount) {
    this.sepaAccount = sepaAccount;
  }

  public InvoicePaymentInformation sepaBankId(String sepaBankId) {
    this.sepaBankId = sepaBankId;
    return this;
  }

   /**
   * Get sepaBankId
   * @return sepaBankId
  **/
  @ApiModelProperty(value = "")
  public String getSepaBankId() {
    return sepaBankId;
  }

  public void setSepaBankId(String sepaBankId) {
    this.sepaBankId = sepaBankId;
  }

  public InvoicePaymentInformation dueDate(Date dueDate) {
    this.dueDate = (Date)dueDate.clone();
    return this;
  }

   /**
   * Get dueDate
   * @return dueDate
  **/
  @ApiModelProperty(value = "")
  public Date getDueDate() {
    return (Date)dueDate.clone();
  }

  public void setDueDate(Date dueDate) {
    this.dueDate = (Date)dueDate.clone();
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvoicePaymentInformation invoicePaymentInformation = (InvoicePaymentInformation) o;
    return Objects.equals(this.emisCode, invoicePaymentInformation.emisCode) &&
        Objects.equals(this.emisReference, invoicePaymentInformation.emisReference) &&
        Objects.equals(this.sepaReference, invoicePaymentInformation.sepaReference) &&
        Objects.equals(this.sepaAccount, invoicePaymentInformation.sepaAccount) &&
        Objects.equals(this.sepaBankId, invoicePaymentInformation.sepaBankId) &&
        Objects.equals(this.dueDate, invoicePaymentInformation.dueDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(emisCode, emisReference, sepaReference, sepaAccount, sepaBankId, dueDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvoicePaymentInformation {\n");
    
    sb.append("    emisCode: ").append(toIndentedString(emisCode)).append("\n");
    sb.append("    emisReference: ").append(toIndentedString(emisReference)).append("\n");
    sb.append("    sepaReference: ").append(toIndentedString(sepaReference)).append("\n");
    sb.append("    sepaAccount: ").append(toIndentedString(sepaAccount)).append("\n");
    sb.append("    sepaBankId: ").append(toIndentedString(sepaBankId)).append("\n");
    sb.append("    dueDate: ").append(toIndentedString(dueDate)).append("\n");
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

