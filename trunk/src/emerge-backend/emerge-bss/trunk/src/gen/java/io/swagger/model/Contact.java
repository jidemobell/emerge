package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Contact
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:29:26.838Z")
public class Contact   {
  private Long id;

  private String contactType = null;

  private String contactName = null;

  private String contactEmail = null;

  private String contactPhone = null;

  private String contactFax = null;

  private Long billingAddressId;
  
   private Boolean notifyBySms = null;

  private Boolean notifyByEmail = null;

  private Boolean sendInvoiceByEmail = null;
  private Boolean mainContact = null;

  public Contact id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Contact contactType(String contactType) {
    this.contactType = contactType;
    return this;
  }

   /**
   * Get contactType
   * @return contactType
  **/
  @ApiModelProperty(value = "")
  public String getContactType() {
    return contactType;
  }

  public void setContactType(String contactType) {
    this.contactType = contactType;
  }

  public Contact contactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

   /**
   * Get contactName
   * @return contactName
  **/
  @ApiModelProperty(value = "")
  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public Contact contactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
    return this;
  }

   /**
   * Get contactEmail
   * @return contactEmail
  **/
  @ApiModelProperty(value = "")
  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public Contact contactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

   /**
   * Get contactPhone
   * @return contactPhone
  **/
  @ApiModelProperty(value = "")
  public String getContactPhone() {
    return contactPhone;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }

  public Contact contactFax(String contactFax) {
    this.contactFax = contactFax;
    return this;
  }

   /**
   * Get contactFax
   * @return contactFax
  **/
  @ApiModelProperty(value = "")
  public String getContactFax() {
    return contactFax;
  }

  public void setContactFax(String contactFax) {
    this.contactFax = contactFax;
  }

  public Contact billingAddressId(Long billingAddressId) {
    this.billingAddressId = billingAddressId;
    return this;
  }

   /**
   * Get billingAddressId
   * @return billingAddressId
  **/
  @ApiModelProperty(required = true, value = "")
  public Long getBillingAddressId() {
    return billingAddressId;
  }

  public void setBillingAddressId(Long billingAddressId) {
    this.billingAddressId = billingAddressId;
  }
  
  public Contact notifyBySms(Boolean notifyBySms) {
    this.notifyBySms = notifyBySms;
    return this;
  }

   /**
   * Get notifyBySms
   * @return notifyBySms
  **/
  @ApiModelProperty(value = "")
  public Boolean getNotifyBySms() {
    return notifyBySms;
  }

  public void setNotifyBySms(Boolean notifyBySms) {
    this.notifyBySms = notifyBySms;
  }

  public Contact notifyByEmail(Boolean notifyByEmail) {
    this.notifyByEmail = notifyByEmail;
    return this;
  }

   /**
   * Get notifyByEmail
   * @return notifyByEmail
  **/
  @ApiModelProperty(value = "")
  public Boolean getNotifyByEmail() {
    return notifyByEmail;
  }

  public void setNotifyByEmail(Boolean notifyByEmail) {
    this.notifyByEmail = notifyByEmail;
  }

  public Contact sendInvoiceByEmail(Boolean sendInvoiceByEmail) {
    this.sendInvoiceByEmail = sendInvoiceByEmail;
    return this;
  }
  
   /**
   * Get mainContact
     * @param mainContact
   * @return mainContact
  **/
  @ApiModelProperty(value = "")
  public Boolean getMainContact(Boolean mainContact){
      return mainContact;
  }
  public void setMainContact(Boolean mainContact){
      this.mainContact = mainContact;
  }
 
   /**
   * Get sendInvoiceByEmail
   * @return sendInvoiceByEmail
  **/
  @ApiModelProperty(value = "")
  public Boolean getSendInvoiceByEmail() {
    return sendInvoiceByEmail;
  }

  public void setSendInvoiceByEmail(Boolean sendInvoiceByEmail) {
    this.sendInvoiceByEmail = sendInvoiceByEmail;
  }



  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Contact contact = (Contact) o;
    return Objects.equals(this.id, contact.id) &&
        Objects.equals(this.contactType, contact.contactType) &&
        Objects.equals(this.contactName, contact.contactName) &&
        Objects.equals(this.contactEmail, contact.contactEmail) &&
        Objects.equals(this.contactPhone, contact.contactPhone) &&
        Objects.equals(this.contactFax, contact.contactFax) &&
        Objects.equals(this.billingAddressId, contact.billingAddressId)&&
        Objects.equals(this.notifyBySms, contact.notifyBySms) &&
        Objects.equals(this.notifyByEmail, contact.notifyByEmail) &&
        Objects.equals(this.sendInvoiceByEmail, contact.sendInvoiceByEmail)&&
        Objects.equals(this.mainContact, contact.mainContact);

  }

  @Override
  public int hashCode() {
    return Objects.hash(id, contactType, contactName, contactEmail, contactPhone, contactFax, billingAddressId, notifyBySms, notifyByEmail, sendInvoiceByEmail,mainContact);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Contact {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    contactType: ").append(toIndentedString(contactType)).append("\n");
    sb.append("    contactName: ").append(toIndentedString(contactName)).append("\n");
    sb.append("    contactEmail: ").append(toIndentedString(contactEmail)).append("\n");
    sb.append("    contactPhone: ").append(toIndentedString(contactPhone)).append("\n");
    sb.append("    contactFax: ").append(toIndentedString(contactFax)).append("\n");
    sb.append("    billingAddressId: ").append(toIndentedString(billingAddressId)).append("\n");
    sb.append("    notifyBySms: ").append(toIndentedString(notifyBySms)).append("\n");
    sb.append("    notifyByEmail: ").append(toIndentedString(notifyByEmail)).append("\n");
    sb.append("    sendInvoiceByEmail: ").append(toIndentedString(sendInvoiceByEmail)).append("\n");
    sb.append("    mainContact: ").append(toIndentedString(mainContact)).append("\n");
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

