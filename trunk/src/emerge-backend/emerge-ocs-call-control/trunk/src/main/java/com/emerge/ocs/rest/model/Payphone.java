package com.emerge.ocs.rest.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * Payphone
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T14:27:56.968Z")
public class Payphone   {
  private int payphoneID;

  private Equipment equipment = null;

  private SIM sIM1 = null;

  private SIM sIM2 = null;

  private Application application = null;

  private long customerID;

  private long accountID;

  private Double balance = null;

  private Status status = null;

  private Date creationDate = null;

  private Date modificationDate = null;

  private PayphoneCredentials credentials = null;

  private ConfigData configData = null;

  public Payphone payphoneID(int payphoneID) {
    this.payphoneID = payphoneID;
    return this;
  }

   /**
   * PayphoneID is created by the OCS when creating a new Payphone. When specified in PUT or POST operations, it is ignored by the server.
   * @return payphoneID
  **/
  @ApiModelProperty(value = "PayphoneID is created by the OCS when creating a new Payphone. When specified in PUT or POST operations, it is ignored by the server.")
  public int getPayphoneID() {
    return payphoneID;
  }

  public void setPayphoneID(int payphoneID) {
    this.payphoneID = payphoneID;
  }

  public Payphone equipment(Equipment equipment) {
    this.equipment = equipment;
    return this;
  }

   /**
   * Get equipment
   * @return equipment
  **/
  @ApiModelProperty(required = true, value = "")
  public Equipment getEquipment() {
    return equipment;
  }

  public void setEquipment(Equipment equipment) {
    this.equipment = equipment;
  }

  public Payphone sIM1(SIM sIM1) {
    this.sIM1 = sIM1;
    return this;
  }

   /**
   * Get sIM1
   * @return sIM1
  **/
  @ApiModelProperty(required = true, value = "")
  public SIM getSIM1() {
    return sIM1;
  }

  public void setSIM1(SIM sIM1) {
    this.sIM1 = sIM1;
  }

  public Payphone sIM2(SIM sIM2) {
    this.sIM2 = sIM2;
    return this;
  }

   /**
   * Get sIM2
   * @return sIM2
  **/
  @ApiModelProperty(value = "")
  public SIM getSIM2() {
    return sIM2;
  }

  public void setSIM2(SIM sIM2) {
    this.sIM2 = sIM2;
  }

  public Payphone application(Application application) {
    this.application = application;
    return this;
  }

   /**
   * Get application
   * @return application
  **/
  @ApiModelProperty(required = true, value = "")
  public Application getApplication() {
    return application;
  }

  public void setApplication(Application application) {
    this.application = application;
  }

  public Payphone customerID(long customerID) {
    this.customerID = customerID;
    return this;
  }

   /**
   * Get customerID
   * @return customerID
  **/
  @ApiModelProperty(value = "")
  public long getCustomerID() {
    return customerID;
  }

  public void setCustomerID(long customerID) {
    this.customerID = customerID;
  }

  public Payphone accountID(long accountID) {
    this.accountID = accountID;
    return this;
  }

   /**
   * Get accountID
   * @return accountID
  **/
  @ApiModelProperty(value = "")
  public long getAccountID() {
    return accountID;
  }

  public void setAccountID(long accountID) {
    this.accountID = accountID;
  }

  public Payphone balance(Double balance) {
    this.balance = balance;
    return this;
  }

   /**
   * Get balance
   * @return balance
  **/
  @ApiModelProperty(value = "")
  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public Payphone status(Status status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Payphone creationDate(Date creationDate) {
    this.creationDate = (Date) creationDate.clone();
    return this;
  }

   /**
   * Get creationDate
   * @return creationDate
  **/
  @ApiModelProperty(value = "")
  public Date getCreationDate() {
    return (Date) creationDate.clone();
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = (Date) creationDate.clone();
  }

  public Payphone modificationDate(Date modificationDate) {
    this.modificationDate = (Date) modificationDate.clone();
    return this;
  }

   /**
   * Get modificationDate
   * @return modificationDate
  **/
  @ApiModelProperty(value = "")
  public Date getModificationDate() {
    return (Date) modificationDate.clone();
  }

  public void setModificationDate(Date modificationDate) {
    this.modificationDate = (Date) modificationDate.clone();
  }

  public Payphone credentials(PayphoneCredentials credentials) {
    this.credentials = credentials;
    return this;
  }

   /**
   * Get credentials
   * @return credentials
  **/
  @ApiModelProperty(value = "")
  public PayphoneCredentials getCredentials() {
    return credentials;
  }

  public void setCredentials(PayphoneCredentials credentials) {
    this.credentials = credentials;
  }

  public Payphone configData(ConfigData configData) {
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
    Payphone payphone = (Payphone) o;
    return Objects.equals(this.payphoneID, payphone.payphoneID) &&
        Objects.equals(this.equipment, payphone.equipment) &&
        Objects.equals(this.sIM1, payphone.sIM1) &&
        Objects.equals(this.sIM2, payphone.sIM2) &&
        Objects.equals(this.application, payphone.application) &&
        Objects.equals(this.customerID, payphone.customerID) &&
        Objects.equals(this.accountID, payphone.accountID) &&
        Objects.equals(this.balance, payphone.balance) &&
        Objects.equals(this.status, payphone.status) &&
        Objects.equals(this.creationDate, payphone.creationDate) &&
        Objects.equals(this.modificationDate, payphone.modificationDate) &&
        Objects.equals(this.credentials, payphone.credentials) &&
        Objects.equals(this.configData, payphone.configData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payphoneID, equipment, sIM1, sIM2, application, customerID, accountID, balance, status, creationDate, modificationDate, credentials, configData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Payphone {\n");
    
    sb.append("    payphoneID: ").append(toIndentedString(payphoneID)).append("\n");
    sb.append("    equipment: ").append(toIndentedString(equipment)).append("\n");
    sb.append("    sIM1: ").append(toIndentedString(sIM1)).append("\n");
    sb.append("    sIM2: ").append(toIndentedString(sIM2)).append("\n");
    sb.append("    application: ").append(toIndentedString(application)).append("\n");
    sb.append("    customerID: ").append(toIndentedString(customerID)).append("\n");
    sb.append("    accountID: ").append(toIndentedString(accountID)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    modificationDate: ").append(toIndentedString(modificationDate)).append("\n");
    sb.append("    credentials: ").append(toIndentedString(credentials)).append("\n");
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

