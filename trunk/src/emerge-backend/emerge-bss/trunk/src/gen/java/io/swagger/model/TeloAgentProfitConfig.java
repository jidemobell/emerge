package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//import java.math.double;




/**
 * TeloAgentProfitConfig
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T10:10:19.635Z")
public class TeloAgentProfitConfig   {
  private double startAmount;

  private double endAmount;

  private double profitPercentage;

  private long teloAgentId;

  public TeloAgentProfitConfig startAmount(double startAmount) {
    this.startAmount = startAmount;
    return this;
  }

   /**
   * Get startAmount
   * @return startAmount
  **/
  @ApiModelProperty(required = true, value = "")
  public double getStartAmount() {
    return startAmount;
  }

  public void setStartAmount(double startAmount) {
    this.startAmount = startAmount;
  }

  public TeloAgentProfitConfig endAmount(double endAmount) {
    this.endAmount = endAmount;
    return this;
  }

   /**
   * Get endAmount
   * @return endAmount
  **/
  @ApiModelProperty(required = true, value = "")
  public double getEndAmount() {
    return endAmount;
  }

  public void setEndAmount(double endAmount) {
    this.endAmount = endAmount;
  }

  public TeloAgentProfitConfig profitPercentage(double profitPercentage) {
    this.profitPercentage = profitPercentage;
    return this;
  }

   /**
   * Get profitPercentage
   * @return profitPercentage
  **/
  @ApiModelProperty(required = true, value = "")
  public double getProfitPercentage() {
    return profitPercentage;
  }

  public void setProfitPercentage(double profitPercentage) {
    this.profitPercentage = profitPercentage;
  }

  public TeloAgentProfitConfig teloAgentId(long teloAgentId) {
    this.teloAgentId = teloAgentId;
    return this;
  }

   /**
   * Get teloAgentId
   * @return teloAgentId
  **/
  @ApiModelProperty(required = true, value = "")
  public long getTeloAgentId() {
    return teloAgentId;
  }

  public void setTeloAgentId(long teloAgentId) {
    this.teloAgentId = teloAgentId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TeloAgentProfitConfig teloAgentProfitConfig = (TeloAgentProfitConfig) o;
    return Objects.equals(this.startAmount, teloAgentProfitConfig.startAmount) &&
        Objects.equals(this.endAmount, teloAgentProfitConfig.endAmount) &&
        Objects.equals(this.profitPercentage, teloAgentProfitConfig.profitPercentage) &&
        Objects.equals(this.teloAgentId, teloAgentProfitConfig.teloAgentId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startAmount, endAmount, profitPercentage, teloAgentId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TeloAgentProfitConfig {\n");
    
    sb.append("    startAmount: ").append(toIndentedString(startAmount)).append("\n");
    sb.append("    endAmount: ").append(toIndentedString(endAmount)).append("\n");
    sb.append("    profitPercentage: ").append(toIndentedString(profitPercentage)).append("\n");
    sb.append("    teloAgentId: ").append(toIndentedString(teloAgentId)).append("\n");
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

