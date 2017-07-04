package io.swagger.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;




/**
 * TeloOperatorProfitConfig
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:54:31.527Z")
public class TeloOperatorProfitConfig   {
  private long endAmount;

  private long profitPercentage;

  private long customerId;

  public TeloOperatorProfitConfig endAmount(long endAmount) {
    this.endAmount = endAmount;
    return this;
  }

   /**
   * Get endAmount
   * @return endAmount
  **/
  @ApiModelProperty(required = true, value = "")
  public long getEndAmount() {
    return endAmount;
  }

  public void setEndAmount(long endAmount) {
    this.endAmount = endAmount;
  }

  public TeloOperatorProfitConfig profitPercentage(long profitPercentage) {
    this.profitPercentage = profitPercentage;
    return this;
  }

   /**
   * Get profitPercentage
   * @return profitPercentage
  **/
  @ApiModelProperty(required = true, value = "")
  public long getProfitPercentage() {
    return profitPercentage;
  }

  public void setProfitPercentage(long profitPercentage) {
    this.profitPercentage = profitPercentage;
  }

  public TeloOperatorProfitConfig customerId(long customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * Get customerId
   * @return customerId
  **/
  @ApiModelProperty(required = true, value = "")
  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TeloOperatorProfitConfig teloOperatorProfitConfig = (TeloOperatorProfitConfig) o;
    return Objects.equals(this.endAmount, teloOperatorProfitConfig.endAmount) &&
        Objects.equals(this.profitPercentage, teloOperatorProfitConfig.profitPercentage) &&
        Objects.equals(this.customerId, teloOperatorProfitConfig.customerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endAmount, profitPercentage, customerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TeloOperatorProfitConfig {\n");
    
    sb.append("    endAmount: ").append(toIndentedString(endAmount)).append("\n");
    sb.append("    profitPercentage: ").append(toIndentedString(profitPercentage)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
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

