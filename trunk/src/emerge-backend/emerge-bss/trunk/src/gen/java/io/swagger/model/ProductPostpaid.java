package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Product;




/**
 * ProductPostpaid
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T12:02:51.809Z")
public class ProductPostpaid   {
  private Product product = null;

  private Float unitPrice = null;
  
  private String externalProvisionId = null;

  public ProductPostpaid product(Product product) {
    this.product = product;
    return this;
  }

   /**
   * Get product
   * @return product
  **/
  @ApiModelProperty(required = true, value = "")
  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public ProductPostpaid unitPrice(Float unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

   /**
   * Get unitPrice
   * @return unitPrice
  **/
  @ApiModelProperty(required = true, value = "")
  public Float getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Float unitPrice) {
    this.unitPrice = unitPrice;
  }
  
  @ApiModelProperty(required = true, value = "")
  public String getExternalProvisionId(){
      return externalProvisionId;
  }
  
  public void setExternalProvisionId(String externalProvisionId){
      this.externalProvisionId = externalProvisionId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductPostpaid productPostpaid = (ProductPostpaid) o;
    return Objects.equals(this.product, productPostpaid.product) &&
        Objects.equals(this.unitPrice, productPostpaid.unitPrice) &&
        Objects.equals(this.externalProvisionId, productPostpaid.externalProvisionId);

  }

  @Override
  public int hashCode() {
    return Objects.hash(product, unitPrice, externalProvisionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductPostpaid {\n");
    
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    externalProvisionId: ").append(toIndentedString(externalProvisionId)).append("\n");

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

