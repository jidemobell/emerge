package com.emerge.ocs.rest.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;




/**
 * TopupRsp
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-18T16:03:25.845Z")
public class TopupRsp   {
  private Double creditBeforeTopup = null;

  private Double creditAfterTopup = null;
  
  private Long id = 0l;
  
//  String message = null ;
//  
//  int code = 0 ;

  
   public TopupRsp id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Used tariff
   * @return id
  **/
  @ApiModelProperty(value = "Used tariff")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  public TopupRsp creditBeforeTopup(Double creditBeforeTopup) {
    this.creditBeforeTopup = creditBeforeTopup;
    return this;
  }

   /**
   * Get creditBeforeTopup
   * @return creditBeforeTopup
  **/
  @ApiModelProperty(required = true, value = "")
  public Double getCreditBeforeTopup() {
    return creditBeforeTopup;
  }

  public void setCreditBeforeTopup(Double creditBeforeTopup) {
    this.creditBeforeTopup = creditBeforeTopup;
  }

  public TopupRsp creditAfterTopup(Double creditAfterTopup) {
    this.creditAfterTopup = creditAfterTopup;
    return this;
  }

   /**
   * Get creditAfterTopup
   * @return creditAfterTopup
  **/
  @ApiModelProperty(required = true, value = "")
  public Double getCreditAfterTopup() {
    return creditAfterTopup;
  }

  public void setCreditAfterTopup(Double creditAfterTopup) {
    this.creditAfterTopup = creditAfterTopup;
  }
  
  
//   @ApiModelProperty(required = true, value = "")
//  public String getMessage() {
//    return message;
//  }
//   public TopupRsp description(String  message) {
//    this.message = message;
//    return this;
//  }
//
//   
//
//  public void setMessage(String message) {
//    this.message = message;
//  }
//  
//  
//  @ApiModelProperty(required = true, value = "")
//  public int getCode() {
//    return code;
//  }
//  
//  public TopupRsp code(int  code) {
//    this.code = code;
//    return this;
//  }

   

//  public void setCode(int  code) {
//    this.code = code;
//  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TopupRsp topupRsp = (TopupRsp) o;
    return  Objects.equals(this.id, topupRsp.id) &&
            Objects.equals(this.creditBeforeTopup, topupRsp.creditBeforeTopup) &&
        Objects.equals(this.creditAfterTopup, topupRsp.creditAfterTopup);
//           Objects.equals(this.code, topupRsp.code)&&
//            Objects.equals(this.message, topupRsp.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id,creditBeforeTopup, creditAfterTopup);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TopupRsp {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    creditBeforeTopup: ").append(toIndentedString(creditBeforeTopup)).append("\n");
    sb.append("    creditAfterTopup: ").append(toIndentedString(creditAfterTopup)).append("\n");
//    sb.append("    code: ").append(toIndentedString(code)).append("\n");
//    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

