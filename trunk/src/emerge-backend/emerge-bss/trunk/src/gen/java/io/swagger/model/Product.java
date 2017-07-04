package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Product
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T12:02:51.809Z")
public class Product   {
  private long productId;

  private String productCode = null;

  private String productName = null;

  /**
   * Gets or Sets productType
   */
  public enum ProductTypeEnum {
    PREPAID("PREPAID"),
    
    POSTPAID("POSTPAID");

    private String value;

    ProductTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private ProductTypeEnum productType = null;

  private String productDescription = null;

  private long taxId;

  private String taxDescription = null;

  private Float taxPercentage = null;

  public Product productId(long productId) {
    this.productId = productId;
    return this;
  }

   /**
   * Get productId
   * @return productId
  **/
  @ApiModelProperty(required = true, value = "")
  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public Product productCode(String productCode) {
    this.productCode = productCode;
    return this;
  }

   /**
   * Product Code
   * @return productCode
  **/
  @ApiModelProperty(required = true, value = "Product Code")
  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public Product productName(String productName) {
    this.productName = productName;
    return this;
  }

   /**
   * Product Name
   * @return productName
  **/
  @ApiModelProperty(required = true, value = "Product Name")
  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Product productType(ProductTypeEnum productType) {
    this.productType = productType;
    return this;
  }

   /**
   * Get productType
   * @return productType
  **/
  @ApiModelProperty(required = true, value = "")
  public ProductTypeEnum getProductType() {
    return productType;
  }

  public void setProductType(ProductTypeEnum productType) {
    this.productType = productType;
  }

  public Product productDescription(String productDescription) {
    this.productDescription = productDescription;
    return this;
  }

   /**
   * Product Description
   * @return productDescription
  **/
  @ApiModelProperty(required = true, value = "Product Description")
  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public Product taxId(long taxId) {
    this.taxId = taxId;
    return this;
  }

   /**
   * Tax ID
   * @return taxId
  **/
  @ApiModelProperty(required = true, value = "Tax ID")
  public long getTaxId() {
    return taxId;
  }

  public void setTaxId(long taxId) {
    this.taxId = taxId;
  }

  public Product taxDescription(String taxDescription) {
    this.taxDescription = taxDescription;
    return this;
  }

   /**
   * Tax description
   * @return taxDescription
  **/
  @ApiModelProperty(required = true, value = "Tax description")
  public String getTaxDescription() {
    return taxDescription;
  }

  public void setTaxDescription(String taxDescription) {
    this.taxDescription = taxDescription;
  }

  public Product taxPercentage(Float taxPercentage) {
    this.taxPercentage = taxPercentage;
    return this;
  }

   /**
   * Tax percentage
   * @return taxPercentage
  **/
  @ApiModelProperty(required = true, value = "Tax percentage")
  public Float getTaxPercentage() {
    return taxPercentage;
  }

  public void setTaxPercentage(Float taxPercentage) {
    this.taxPercentage = taxPercentage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.productId, product.productId) &&
        Objects.equals(this.productCode, product.productCode) &&
        Objects.equals(this.productName, product.productName) &&
        Objects.equals(this.productType, product.productType) &&
        Objects.equals(this.productDescription, product.productDescription) &&
        Objects.equals(this.taxId, product.taxId) &&
        Objects.equals(this.taxDescription, product.taxDescription) &&
        Objects.equals(this.taxPercentage, product.taxPercentage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, productCode, productName, productType, productDescription, taxId, taxDescription, taxPercentage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    productType: ").append(toIndentedString(productType)).append("\n");
    sb.append("    productDescription: ").append(toIndentedString(productDescription)).append("\n");
    sb.append("    taxId: ").append(toIndentedString(taxId)).append("\n");
    sb.append("    taxDescription: ").append(toIndentedString(taxDescription)).append("\n");
    sb.append("    taxPercentage: ").append(toIndentedString(taxPercentage)).append("\n");
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

