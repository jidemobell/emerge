package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.InvoiceCustomerInformation;
import io.swagger.model.InvoiceHeader;
import io.swagger.model.InvoicePaymentInformation;
import io.swagger.model.InvoiceProducts;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




/**
 * Invoice
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:54:31.527Z")
public class Invoice   {
  private InvoiceHeader header = null;

  private InvoiceCustomerInformation customer = null;

  private InvoicePaymentInformation payment = null;

  private String invoiceNumber = null;

  private String invoiceHash = null;

  private String invoiceHashControl = null;

  private String invoiceType = null;

  private Date invoiceDate = null;

  private String invoicePeriod = null;

  private String creditNoteId = null;

  private long contractId;

  /**
   * Prepaid or Postpaid
   */
  public enum ContractTypeEnum {
    PREPAID("PREPAID"),
    
    POSTPAID("POSTPAID");

    private String value;

    ContractTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private ContractTypeEnum contractType = null;

  private List<InvoiceProducts> products = new ArrayList<InvoiceProducts>();

  private long taxPayables;

  private long netTotal;

  private long grossTotal;

  private String notes = null;

  public Invoice header(InvoiceHeader header) {
    this.header = header;
    return this;
  }

   /**
   * Get header
   * @return header
  **/
  @ApiModelProperty(required = true, value = "")
  public InvoiceHeader getHeader() {
    return header;
  }

  public void setHeader(InvoiceHeader header) {
    this.header = header;
  }

  public Invoice customer(InvoiceCustomerInformation customer) {
    this.customer = customer;
    return this;
  }

   /**
   * Get customer
   * @return customer
  **/
  @ApiModelProperty(required = true, value = "")
  public InvoiceCustomerInformation getCustomer() {
    return customer;
  }

  public void setCustomer(InvoiceCustomerInformation customer) {
    this.customer = customer;
  }

  public Invoice payment(InvoicePaymentInformation payment) {
    this.payment = payment;
    return this;
  }

   /**
   * Get payment
   * @return payment
  **/
  @ApiModelProperty(value = "")
  public InvoicePaymentInformation getPayment() {
    return payment;
  }

  public void setPayment(InvoicePaymentInformation payment) {
    this.payment = payment;
  }

  public Invoice invoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
    return this;
  }

   /**
   * Get invoiceNumber
   * @return invoiceNumber
  **/
  @ApiModelProperty(value = "")
  public String getInvoiceNumber() {
    return invoiceNumber;
  }

  public void setInvoiceNumber(String invoiceNumber) {
    this.invoiceNumber = invoiceNumber;
  }

  public Invoice invoiceHash(String invoiceHash) {
    this.invoiceHash = invoiceHash;
    return this;
  }

   /**
   * Get invoiceHash
   * @return invoiceHash
  **/
  @ApiModelProperty(value = "")
  public String getInvoiceHash() {
    return invoiceHash;
  }

  public void setInvoiceHash(String invoiceHash) {
    this.invoiceHash = invoiceHash;
  }

  public Invoice invoiceHashControl(String invoiceHashControl) {
    this.invoiceHashControl = invoiceHashControl;
    return this;
  }

   /**
   * Get invoiceHashControl
   * @return invoiceHashControl
  **/
  @ApiModelProperty(value = "")
  public String getInvoiceHashControl() {
    return invoiceHashControl;
  }

  public void setInvoiceHashControl(String invoiceHashControl) {
    this.invoiceHashControl = invoiceHashControl;
  }

  public Invoice invoiceType(String invoiceType) {
    this.invoiceType = invoiceType;
    return this;
  }

   /**
   * Get invoiceType
   * @return invoiceType
  **/
  @ApiModelProperty(value = "")
  public String getInvoiceType() {
    return invoiceType;
  }

  public void setInvoiceType(String invoiceType) {
    this.invoiceType = invoiceType;
  }

  public Invoice invoiceDate(Date invoiceDate) {
    this.invoiceDate = (Date)invoiceDate.clone();
    return this;
  }

   /**
   * Get invoiceDate
   * @return invoiceDate
  **/
  @ApiModelProperty(value = "")
  public Date getInvoiceDate() {
    return (Date)invoiceDate.clone();
  }

  public void setInvoiceDate(Date invoiceDate) {
    this.invoiceDate = (Date)invoiceDate.clone();
  }

  public Invoice invoicePeriod(String invoicePeriod) {
    this.invoicePeriod = invoicePeriod;
    return this;
  }

   /**
   * Get invoicePeriod
   * @return invoicePeriod
  **/
  @ApiModelProperty(value = "")
  public String getInvoicePeriod() {
    return invoicePeriod;
  }

  public void setInvoicePeriod(String invoicePeriod) {
    this.invoicePeriod = invoicePeriod;
  }

  public Invoice creditNoteId(String creditNoteId) {
    this.creditNoteId = creditNoteId;
    return this;
  }

   /**
   * ID of credit note related to this invoice (if any)
   * @return creditNoteId
  **/
  @ApiModelProperty(value = "ID of credit note related to this invoice (if any)")
  public String getCreditNoteId() {
    return creditNoteId;
  }

  public void setCreditNoteId(String creditNoteId) {
    this.creditNoteId = creditNoteId;
  }

  public Invoice contractId(long contractId) {
    this.contractId = contractId;
    return this;
  }

   /**
   * ID of contract related to this invoice (if any)
   * @return contractId
  **/
  @ApiModelProperty(value = "ID of contract related to this invoice (if any)")
  public long getContractId() {
    return contractId;
  }

  public void setContractId(long contractId) {
    this.contractId = contractId;
  }

  public Invoice contractType(ContractTypeEnum contractType) {
    this.contractType = contractType;
    return this;
  }

   /**
   * Prepaid or Postpaid
   * @return contractType
  **/
  @ApiModelProperty(value = "Prepaid or Postpaid")
  public ContractTypeEnum getContractType() {
    return contractType;
  }

  public void setContractType(ContractTypeEnum contractType) {
    this.contractType = contractType;
  }

  public Invoice products(List<InvoiceProducts> products) {
    this.products = products;
    return this;
  }

  public Invoice addProductsItem(InvoiceProducts productsItem) {
    this.products.add(productsItem);
    return this;
  }

   /**
   * Get products
   * @return products
  **/
  @ApiModelProperty(required = true, value = "")
  public List<InvoiceProducts> getProducts() {
    return products;
  }

  public void setProducts(List<InvoiceProducts> products) {
    this.products = products;
  }

  public Invoice taxPayables(long taxPayables) {
    this.taxPayables = taxPayables;
    return this;
  }

   /**
   * Get taxPayables
   * @return taxPayables
  **/
  @ApiModelProperty(value = "")
  public long getTaxPayables() {
    return taxPayables;
  }

  public void setTaxPayables(long taxPayables) {
    this.taxPayables = taxPayables;
  }

  public Invoice netTotal(long netTotal) {
    this.netTotal = netTotal;
    return this;
  }

   /**
   * Get netTotal
   * @return netTotal
  **/
  @ApiModelProperty(value = "")
  public long getNetTotal() {
    return netTotal;
  }

  public void setNetTotal(long netTotal) {
    this.netTotal = netTotal;
  }

  public Invoice grossTotal(long grossTotal) {
    this.grossTotal = grossTotal;
    return this;
  }

   /**
   * Get grossTotal
   * @return grossTotal
  **/
  @ApiModelProperty(value = "")
  public long getGrossTotal() {
    return grossTotal;
  }

  public void setGrossTotal(long grossTotal) {
    this.grossTotal = grossTotal;
  }

  public Invoice notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   * Get notes
   * @return notes
  **/
  @ApiModelProperty(value = "")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Invoice invoice = (Invoice) o;
    return Objects.equals(this.header, invoice.header) &&
        Objects.equals(this.customer, invoice.customer) &&
        Objects.equals(this.payment, invoice.payment) &&
        Objects.equals(this.invoiceNumber, invoice.invoiceNumber) &&
        Objects.equals(this.invoiceHash, invoice.invoiceHash) &&
        Objects.equals(this.invoiceHashControl, invoice.invoiceHashControl) &&
        Objects.equals(this.invoiceType, invoice.invoiceType) &&
        Objects.equals(this.invoiceDate, invoice.invoiceDate) &&
        Objects.equals(this.invoicePeriod, invoice.invoicePeriod) &&
        Objects.equals(this.creditNoteId, invoice.creditNoteId) &&
        Objects.equals(this.contractId, invoice.contractId) &&
        Objects.equals(this.contractType, invoice.contractType) &&
        Objects.equals(this.products, invoice.products) &&
        Objects.equals(this.taxPayables, invoice.taxPayables) &&
        Objects.equals(this.netTotal, invoice.netTotal) &&
        Objects.equals(this.grossTotal, invoice.grossTotal) &&
        Objects.equals(this.notes, invoice.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, customer, payment, invoiceNumber, invoiceHash, invoiceHashControl, invoiceType, invoiceDate, invoicePeriod, creditNoteId, contractId, contractType, products, taxPayables, netTotal, grossTotal, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Invoice {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
    sb.append("    invoiceHash: ").append(toIndentedString(invoiceHash)).append("\n");
    sb.append("    invoiceHashControl: ").append(toIndentedString(invoiceHashControl)).append("\n");
    sb.append("    invoiceType: ").append(toIndentedString(invoiceType)).append("\n");
    sb.append("    invoiceDate: ").append(toIndentedString(invoiceDate)).append("\n");
    sb.append("    invoicePeriod: ").append(toIndentedString(invoicePeriod)).append("\n");
    sb.append("    creditNoteId: ").append(toIndentedString(creditNoteId)).append("\n");
    sb.append("    contractId: ").append(toIndentedString(contractId)).append("\n");
    sb.append("    contractType: ").append(toIndentedString(contractType)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    taxPayables: ").append(toIndentedString(taxPayables)).append("\n");
    sb.append("    netTotal: ").append(toIndentedString(netTotal)).append("\n");
    sb.append("    grossTotal: ").append(toIndentedString(grossTotal)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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

