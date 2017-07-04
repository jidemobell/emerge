package io.swagger.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;




/**
 * PayphoneCredentials
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-18T16:03:25.845Z")
public class PayphoneCredentials   {
  private String username = null;

  private String password = null;

  public PayphoneCredentials username(String username) {
    this.username = username;
    return this;
  }

   /**
   * Payphone Username.
   * @return username
  **/
  @ApiModelProperty(required = true, value = "Payphone Username.")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public PayphoneCredentials password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Payphone Password, must be hashed before sending. On GET operations, the server must not include the password.
   * @return password
  **/
  @ApiModelProperty(value = "Payphone Password, must be hashed before sending. On GET operations, the server must not include the password.")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayphoneCredentials payphoneCredentials = (PayphoneCredentials) o;
    return Objects.equals(this.username, payphoneCredentials.username) &&
        Objects.equals(this.password, payphoneCredentials.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayphoneCredentials {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

