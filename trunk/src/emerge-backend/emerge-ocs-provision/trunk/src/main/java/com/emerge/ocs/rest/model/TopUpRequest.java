package com.emerge.ocs.rest.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * TopUpRequest
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-21T16:08:02.901Z")
public class TopUpRequest   {
  private Float amount = null;

  public TopUpRequest amount(Float amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Amount to top up
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "Amount to top up")
  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TopUpRequest topUpRequest = (TopUpRequest) o;
    return Objects.equals(this.amount, topUpRequest.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopUpRequest {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

