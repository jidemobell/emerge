package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;

/**
 * KeepAliveRsp
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T14:27:56.968Z")
public class KeepAliveRsp   {
  private ConfigData configData = null;
  
  private int statusCode;
  private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

  public KeepAliveRsp configData(ConfigData configData) {
    this.configData = configData;
    return this;
  }

   /**
   * Get configData
   * @return configData
  **/
  @ApiModelProperty(value = "")
  public ConfigData getConfigData() {
    return configData;
  }

  public void setConfigData(ConfigData configData) {
    this.configData = configData;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeepAliveRsp keepAliveRsp = (KeepAliveRsp) o;
    return Objects.equals(this.configData, keepAliveRsp.configData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(configData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeepAliveRsp {\n");
    
    sb.append("    configData: ").append(toIndentedString(configData)).append("\n");
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

