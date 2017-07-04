package io.swagger.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;




/**
 * Customer
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:29:26.838Z")
public class Customer   {
  private Long id = 0l;

  private String status = null;

  private String name = null;

  private String fiscalNumber = null;

  private String taxExemptionCertificates = null;

  private String country = null;

  private String website = null;

  private String privateNotes = null;

  private String publicNotes = null;

  private String notifyBySms = null;

  private String notifyByEmail = null;

  private Contact mainContact = null;

  private List<CustomerAddress> customerAddresses = new ArrayList<>();

  private String tags = null;

  public Customer id(Long id) {
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

  public Customer status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Customer name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(required = true, value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Customer fiscalNumber(String fiscalNumber) {
    this.fiscalNumber = fiscalNumber;
    return this;
  }

   /**
   * Get fiscalNumber
   * @return fiscalNumber
  **/
  @ApiModelProperty(required = true, value = "")
  public String getFiscalNumber() {
    return fiscalNumber;
  }

  public void setFiscalNumber(String fiscalNumber) {
    this.fiscalNumber = fiscalNumber;
  }

  public Customer taxExemptionCertificates(String taxExemptionCertificates) {
    this.taxExemptionCertificates = taxExemptionCertificates;
    return this;
  }

  public Customer addTaxExemptionCertificateItem(String taxExemptionCertificatesItem) {
    this.taxExemptionCertificates = taxExemptionCertificatesItem;
    return this;
  }

   /**
   * List of Tax Exemption Certificates
   * @return taxExemptionCertificates
  **/
  @ApiModelProperty(value = "List of Tax Exemption Certificates")
  public String getTaxExemptionCertificates() {
    return taxExemptionCertificates;
  }

  public void setTaxExemptionCertificates(String taxExemptionCertificates) {
    this.taxExemptionCertificates = taxExemptionCertificates;
  }

  public Customer country(String country) {
    this.country = country;
    return this;
  }

   /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(required = true, value = "")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Customer website(String website) {
    this.website = website;
    return this;
  }

   /**
   * Get website
   * @return website
  **/
  @ApiModelProperty(value = "")
  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public Customer privateNotes(String privateNotes) {
    this.privateNotes = privateNotes;
    return this;
  }

   /**
   * Get privateNotes
   * @return privateNotes
  **/
  @ApiModelProperty(value = "")
  public String getPrivateNotes() {
    return privateNotes;
  }

  public void setPrivateNotes(String privateNotes) {
    this.privateNotes = privateNotes;
  }

  public Customer publicNotes(String publicNotes) {
    this.publicNotes = publicNotes;
    return this;
  }

   /**
   * Get publicNotes
   * @return publicNotes
  **/
  @ApiModelProperty(value = "")
  public String getPublicNotes() {
    return publicNotes;
  }

  public void setPublicNotes(String publicNotes) {
    this.publicNotes = publicNotes;
  }

  public Customer notifyBySms(String notifyBySms) {
    this.notifyBySms = notifyBySms;
    return this;
  }

   /**
   * Get notifyBySms
   * @return notifyBySms
  **/
  @ApiModelProperty(value = "")
  public String getNotifyBySms() {
    return notifyBySms;
  }

  public void setNotifyBySms(String notifyBySms) {
    this.notifyBySms = notifyBySms;
  }

  public Customer notifyByEmail(String notifyByEmail) {
    this.notifyByEmail = notifyByEmail;
    return this;
  }

   /**
   * Get notifyByEmail
   * @return notifyByEmail
  **/
  @ApiModelProperty(value = "")
  public String getNotifyByEmail() {
    return notifyByEmail;
  }

  public void setNotifyByEmail(String notifyByEmail) {
    this.notifyByEmail = notifyByEmail;
  }

  public Customer mainContact(Contact mainContact) {
    this.mainContact = mainContact;
    return this;
  }

   /**
   * Get mainContact
   * @return mainContact
  **/
  @ApiModelProperty(required = true, value = "")
  public Contact getMainContact() {
    return mainContact;
  }

  public void setMainContact(Contact mainContact) {
    this.mainContact = mainContact;
  }

  public Customer customerAddresses(List<CustomerAddress> customerAddresses) {
    this.customerAddresses = customerAddresses;
    return this;
  }

  public Customer addCustomerAddressesItem(CustomerAddress customerAddressesItem) {
    this.customerAddresses.add(customerAddressesItem);
    return this;
  }

   /**
   * List of customer (additional) addresses
   * @return customerAddresses
  **/
  @ApiModelProperty(value = "List of customer (additional) addresses")
  public List<CustomerAddress> getCustomerAddresses() {
    return customerAddresses;
  }

  public void setCustomerAddresses(List<CustomerAddress> customerAddresses) {
    this.customerAddresses = customerAddresses;
  }

  public Customer tags(String tags) {
    this.tags = tags;
    return this;
  }

  public Customer addTagsItem(String tagsItem) {
    this.tags = tagsItem;
    return this;
  }

   /**
   * Get tags
   * @return tags
  **/
  @ApiModelProperty(value = "")
  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.id, customer.id) &&
        Objects.equals(this.status, customer.status) &&
        Objects.equals(this.name, customer.name) &&
        Objects.equals(this.fiscalNumber, customer.fiscalNumber) &&
        Objects.equals(this.taxExemptionCertificates, customer.taxExemptionCertificates) &&
        Objects.equals(this.country, customer.country) &&
        Objects.equals(this.website, customer.website) &&
        Objects.equals(this.privateNotes, customer.privateNotes) &&
        Objects.equals(this.publicNotes, customer.publicNotes) &&
        Objects.equals(this.notifyBySms, customer.notifyBySms) &&
        Objects.equals(this.notifyByEmail, customer.notifyByEmail) &&
        Objects.equals(this.mainContact, customer.mainContact) &&
        Objects.equals(this.customerAddresses, customer.customerAddresses) &&
        Objects.equals(this.tags, customer.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status, name, fiscalNumber, taxExemptionCertificates, country, website, privateNotes, publicNotes, notifyBySms, notifyByEmail, mainContact, customerAddresses, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fiscalNumber: ").append(toIndentedString(fiscalNumber)).append("\n");
    sb.append("    taxExemptionCertificates: ").append(toIndentedString(taxExemptionCertificates)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    website: ").append(toIndentedString(website)).append("\n");
    sb.append("    privateNotes: ").append(toIndentedString(privateNotes)).append("\n");
    sb.append("    publicNotes: ").append(toIndentedString(publicNotes)).append("\n");
    sb.append("    notifyBySms: ").append(toIndentedString(notifyBySms)).append("\n");
    sb.append("    notifyByEmail: ").append(toIndentedString(notifyByEmail)).append("\n");
    sb.append("    mainContact: ").append(toIndentedString(mainContact)).append("\n");
    sb.append("    customerAddresses: ").append(toIndentedString(customerAddresses)).append("\n");
    sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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

