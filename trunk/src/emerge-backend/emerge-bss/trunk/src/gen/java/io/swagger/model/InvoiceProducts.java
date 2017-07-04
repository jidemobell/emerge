package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * InvoiceProducts
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:54:31.527Z")
public class InvoiceProducts   {
  private String productCode = null;

  private String productDescription = null;

  private String quantity = null;

  private String unitPrice = null;

  private String discountPercentage = null;

  private String discountValue = null;

  private String description = null;

  private String amountWithoutTax = null;

  private String taxType = null;

  private String taxPercentage = null;

  private String taxAmount = null;

  private String taxExemptionReason = null;

  public InvoiceProducts productCode(String productCode) {
    this.productCode = productCode;
    return this;
  }

   /**
   * Get productCode
   * @return productCode
  **/
  @ApiModelProperty(value = "")
  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public InvoiceProducts productDescription(String productDescription) {
    this.productDescription = productDescription;
    return this;
  }

   /**
   * Get productDescription
   * @return productDescription
  **/
  @ApiModelProperty(value = "")
  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public InvoiceProducts quantity(String quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * Get quantity
   * @return quantity
  **/
  @ApiModelProperty(value = "")
  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public InvoiceProducts unitPrice(String unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

   /**
   * Get unitPrice
   * @return unitPrice
  **/
  @ApiModelProperty(value = "")
  public String getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(String unitPrice) {
    this.unitPrice = unitPrice;
  }

  public InvoiceProducts discountPercentage(String discountPercentage) {
    this.discountPercentage = discountPercentage;
    return this;
  }

   /**
   * Get discountPercentage
   * @return discountPercentage
  **/
  @ApiModelProperty(value = "")
  public String getDiscountPercentage() {
    return discountPercentage;
  }

  public void setDiscountPercentage(String discountPercentage) {
    this.discountPercentage = discountPercentage;
  }

  public InvoiceProducts discountValue(String discountValue) {
    this.discountValue = discountValue;
    return this;
  }

   /**
   * Get discountValue
   * @return discountValue
  **/
  @ApiModelProperty(value = "")
  public String getDiscountValue() {
    return discountValue;
  }

  public void setDiscountValue(String discountValue) {
    this.discountValue = discountValue;
  }

  public InvoiceProducts description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public InvoiceProducts amountWithoutTax(String amountWithoutTax) {
    this.amountWithoutTax = amountWithoutTax;
    return this;
  }

   /**
   * Get amountWithoutTax
   * @return amountWithoutTax
  **/
  @ApiModelProperty(value = "")
  public String getAmountWithoutTax() {
    return amountWithoutTax;
  }

  public void setAmountWithoutTax(String amountWithoutTax) {
    this.amountWithoutTax = amountWithoutTax;
  }

  public InvoiceProducts taxType(String taxType) {
    this.taxType = taxType;
    return this;
  }

   /**
   * Get taxType
   * @return taxType
  **/
  @ApiModelProperty(value = "")
  public String getTaxType() {
    return taxType;
  }

  public void setTaxType(String taxType) {
    this.taxType = taxType;
  }

  public InvoiceProducts taxPercentage(String taxPercentage) {
    this.taxPercentage = taxPercentage;
    return this;
  }

   /**
   * Get taxPercentage
   * @return taxPercentage
  **/
  @ApiModelProperty(value = "")
  public String getTaxPercentage() {
    return taxPercentage;
  }

  public void setTaxPercentage(String taxPercentage) {
    this.taxPercentage = taxPercentage;
  }

  public InvoiceProducts taxAmount(String taxAmount) {
    this.taxAmount = taxAmount;
    return this;
  }

   /**
   * Get taxAmount
   * @return taxAmount
  **/
  @ApiModelProperty(value = "")
  public String getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(String taxAmount) {
    this.taxAmount = taxAmount;
  }

  public InvoiceProducts taxExemptionReason(String taxExemptionReason) {
    this.taxExemptionReason = taxExemptionReason;
    return this;
  }

   /**
   * Get taxExemptionReason
   * @return taxExemptionReason
  **/
  @ApiModelProperty(value = "")
  public String getTaxExemptionReason() {
    return taxExemptionReason;
  }

  public void setTaxExemptionReason(String taxExemptionReason) {
    this.taxExemptionReason = taxExemptionReason;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InvoiceProducts invoiceProducts = (InvoiceProducts) o;
    return Objects.equals(this.productCode, invoiceProducts.productCode) &&
        Objects.equals(this.productDescription, invoiceProducts.productDescription) &&
        Objects.equals(this.quantity, invoiceProducts.quantity) &&
        Objects.equals(this.unitPrice, invoiceProducts.unitPrice) &&
        Objects.equals(this.discountPercentage, invoiceProducts.discountPercentage) &&
        Objects.equals(this.discountValue, invoiceProducts.discountValue) &&
        Objects.equals(this.description, invoiceProducts.description) &&
        Objects.equals(this.amountWithoutTax, invoiceProducts.amountWithoutTax) &&
        Objects.equals(this.taxType, invoiceProducts.taxType) &&
        Objects.equals(this.taxPercentage, invoiceProducts.taxPercentage) &&
        Objects.equals(this.taxAmount, invoiceProducts.taxAmount) &&
        Objects.equals(this.taxExemptionReason, invoiceProducts.taxExemptionReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productCode, productDescription, quantity, unitPrice, discountPercentage, discountValue, description, amountWithoutTax, taxType, taxPercentage, taxAmount, taxExemptionReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InvoiceProducts {\n");
    
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    productDescription: ").append(toIndentedString(productDescription)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    discountPercentage: ").append(toIndentedString(discountPercentage)).append("\n");
    sb.append("    discountValue: ").append(toIndentedString(discountValue)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    amountWithoutTax: ").append(toIndentedString(amountWithoutTax)).append("\n");
    sb.append("    taxType: ").append(toIndentedString(taxType)).append("\n");
    sb.append("    taxPercentage: ").append(toIndentedString(taxPercentage)).append("\n");
    sb.append("    taxAmount: ").append(toIndentedString(taxAmount)).append("\n");
    sb.append("    taxExemptionReason: ").append(toIndentedString(taxExemptionReason)).append("\n");
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

