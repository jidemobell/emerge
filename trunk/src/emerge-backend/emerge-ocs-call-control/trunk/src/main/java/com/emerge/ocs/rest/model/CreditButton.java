package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;



/**
 * Contains information about credit buttons to display on the Payphone GUI
 **/

/**
 * Contains information about credit buttons to display on the Payphone GUI
 */
@ApiModel(description = "Contains information about credit buttons to display on the Payphone GUI")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T14:27:56.968Z")
public class CreditButton   {
  private String label = null;

  private BigDecimal amount = null;

  public CreditButton label(String label) {
    this.label = label;
    return this;
  }

   /**
   * Button label
   * @return label
  **/
  @ApiModelProperty(required = true, value = "Button label")
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public CreditButton amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Credit amount
   * @return amount
  **/
  @ApiModelProperty(required = true, value = "Credit amount")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
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
    CreditButton creditButton = (CreditButton) o;
    return Objects.equals(this.label, creditButton.label) &&
        Objects.equals(this.amount, creditButton.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(label, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditButton {\n");
    
    sb.append("    label: ").append(toIndentedString(label)).append("\n");
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

