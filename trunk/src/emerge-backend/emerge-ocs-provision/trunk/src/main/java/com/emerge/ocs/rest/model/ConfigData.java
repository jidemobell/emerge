package com.emerge.ocs.rest.model;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;




/**
 * ConfigData
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-18T16:03:25.845Z")
public class ConfigData   {
  /**
   * Gets or Sets defaultLanguage
   */
  public enum DefaultLanguageEnum {
    PORTUGUESE("portuguese"),
    
    FRENCH("french"),
    
    ENGLISH("english");

    private String value;

    DefaultLanguageEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private DefaultLanguageEnum defaultLanguage = null;

  private Long keepAliveInterval = null;

  private Long sendErrorsToOCS = null;

  private String preferredMSISDN = null;

  private Boolean silenceMode = false;

  private List<CreditButton> creditButtons = new ArrayList<CreditButton>();

  public ConfigData defaultLanguage(DefaultLanguageEnum defaultLanguage) {
    this.defaultLanguage = defaultLanguage;
    return this;
  }

   /**
   * Get defaultLanguage
   * @return defaultLanguage
  **/
  @ApiModelProperty(value = "")
  public DefaultLanguageEnum getDefaultLanguage() {
    return defaultLanguage;
  }

  public void setDefaultLanguage(DefaultLanguageEnum defaultLanguage) {
    this.defaultLanguage = defaultLanguage;
  }

  public ConfigData keepAliveInterval(Long keepAliveInterval) {
    this.keepAliveInterval = keepAliveInterval;
    return this;
  }

   /**
   * Keep alive interval, in seconds, that the payphone must obey
   * @return keepAliveInterval
  **/
  @ApiModelProperty(value = "Keep alive interval, in seconds, that the payphone must obey")
  public Long getKeepAliveInterval() {
    return keepAliveInterval;
  }

  public void setKeepAliveInterval(Long keepAliveInterval) {
    this.keepAliveInterval = keepAliveInterval;
  }

  public ConfigData sendErrorsToOCS(Long sendErrorsToOCS) {
    this.sendErrorsToOCS = sendErrorsToOCS;
    return this;
  }

   /**
   * Send application error logs during the next <sendErrorsToOCS> seconds
   * @return sendErrorsToOCS
  **/
  @ApiModelProperty(value = "Send application error logs during the next <sendErrorsToOCS> seconds")
  public Long getSendErrorsToOCS() {
    return sendErrorsToOCS;
  }

  public void setSendErrorsToOCS(Long sendErrorsToOCS) {
    this.sendErrorsToOCS = sendErrorsToOCS;
  }

  public ConfigData preferredMSISDN(String preferredMSISDN) {
    this.preferredMSISDN = preferredMSISDN;
    return this;
  }

   /**
   * Get preferredMSISDN
   * @return preferredMSISDN
  **/
  @ApiModelProperty(value = "")
  public String getPreferredMSISDN() {
    return preferredMSISDN;
  }

  public void setPreferredMSISDN(String preferredMSISDN) {
    this.preferredMSISDN = preferredMSISDN;
  }

  public ConfigData silenceMode(Boolean silenceMode) {
    this.silenceMode = silenceMode;
    return this;
  }

   /**
   * Put the payphone in silence mode - it will disable all messages except keepAlive, which will be sent every 24h
   * @return silenceMode
  **/
  @ApiModelProperty(value = "Put the payphone in silence mode - it will disable all messages except keepAlive, which will be sent every 24h")
  public Boolean getSilenceMode() {
    return silenceMode;
  }

  public void setSilenceMode(Boolean silenceMode) {
    this.silenceMode = silenceMode;
  }

  public ConfigData creditButtons(List<CreditButton> creditButtons) {
    this.creditButtons = creditButtons;
    return this;
  }

  public ConfigData addCreditButtonsItem(CreditButton creditButtonsItem) {
    this.creditButtons.add(creditButtonsItem);
    return this;
  }

   /**
   * Buttons to display for service credit specification
   * @return creditButtons
  **/
  @ApiModelProperty(value = "Buttons to display for service credit specification")
  public List<CreditButton> getCreditButtons() {
    return creditButtons;
  }

  public void setCreditButtons(List<CreditButton> creditButtons) {
    this.creditButtons = creditButtons;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConfigData configData = (ConfigData) o;
    return Objects.equals(this.defaultLanguage, configData.defaultLanguage) &&
        Objects.equals(this.keepAliveInterval, configData.keepAliveInterval) &&
        Objects.equals(this.sendErrorsToOCS, configData.sendErrorsToOCS) &&
        Objects.equals(this.preferredMSISDN, configData.preferredMSISDN) &&
        Objects.equals(this.silenceMode, configData.silenceMode) &&
        Objects.equals(this.creditButtons, configData.creditButtons);
  }

  @Override
  public int hashCode() {
    return Objects.hash(defaultLanguage, keepAliveInterval, sendErrorsToOCS, preferredMSISDN, silenceMode, creditButtons);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConfigData {\n");
    
    sb.append("    defaultLanguage: ").append(toIndentedString(defaultLanguage)).append("\n");
    sb.append("    keepAliveInterval: ").append(toIndentedString(keepAliveInterval)).append("\n");
    sb.append("    sendErrorsToOCS: ").append(toIndentedString(sendErrorsToOCS)).append("\n");
    sb.append("    preferredMSISDN: ").append(toIndentedString(preferredMSISDN)).append("\n");
    sb.append("    silenceMode: ").append(toIndentedString(silenceMode)).append("\n");
    sb.append("    creditButtons: ").append(toIndentedString(creditButtons)).append("\n");
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

