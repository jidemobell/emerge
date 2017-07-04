package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;





/**
 * TeloAgents
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T10:10:19.635Z")
public class TeloAgents   {
  private long id;
  private long prepaidServiceId;
  
  private double balance = 0;
  
  private double topUpValue;
  
  private String reasonForTopUp = null;

  public TeloAgents prepaidServiceId(long prepaidServiceId) {
    this.prepaidServiceId = prepaidServiceId;
    return this;
  }

   /**
   * Get prepaidServiceId
   * @return prepaidServiceId
  **/
  @ApiModelProperty(required = true, value = "")
  public long getPrepaidServiceId() {
    return prepaidServiceId;
  }

  public void setPrepaidServiceId(long prepaidServiceId) {
    this.prepaidServiceId = prepaidServiceId;
  }
  
  
   public TeloAgents id(long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(required = true, value = "")
  public long getid() {
    return prepaidServiceId;
  }

  public void setid(long id) {
    this.id = id;
  }

  
  public TeloAgents balance(double balance) {
    this.balance = balance;
    return this;
  }

   /**
   * Get balance
   * @return balance
  **/
  @ApiModelProperty(required = true, value = "")
  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

    public TeloAgents topupValue(double topUpValue) {
    this.topUpValue = topUpValue;
    return this;
  }

   /**
   * Get topUpValue
   * @return topUpValue
  **/
  @ApiModelProperty(required = true, value = "")
  public double getTopUpValue() {
    return topUpValue;
  }

  public void setTopUpValue(double topUpValue) {
    this.topUpValue = topUpValue;
  }
  
  
   public TeloAgents reasonForTopUp(String reasonForTopUp) {
    this.reasonForTopUp = reasonForTopUp;
    return this;
  }

   /**
   * Get reasonForTopUp
   * @return reasonForTopUp
  **/
  @ApiModelProperty(required = true, value = "")
  public String getreasonForTopUp() {
    return reasonForTopUp;
  }

  public void setreasonForTopUp(String reasonForTopUp) {
    this.reasonForTopUp = reasonForTopUp;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TeloAgents teloAgents = (TeloAgents) o;
      return Objects.equals(this.id, teloAgents.id) &&
    Objects.equals(this.prepaidServiceId, teloAgents.prepaidServiceId) &&
        Objects.equals(this.balance, teloAgents.balance) &&
            Objects.equals(this.topUpValue, teloAgents.topUpValue) &&
            Objects.equals(this.reasonForTopUp, teloAgents.reasonForTopUp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, prepaidServiceId, balance, topUpValue,reasonForTopUp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TeloAgents {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    prepaidServiceId: ").append(toIndentedString(prepaidServiceId)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
      sb.append("    topUpValue: ").append(toIndentedString(topUpValue)).append("\n");
       sb.append("    reasonForTopUp: ").append(toIndentedString(reasonForTopUp)).append("\n");
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

