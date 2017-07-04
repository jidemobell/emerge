package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.InvoiceCustomerInformation;
import io.swagger.model.InvoiceHeader;
import io.swagger.model.InvoiceProducts;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




/**
 * Receipt
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:54:31.527Z")
public class Receipt   {
  private InvoiceHeader header = null;

  private InvoiceCustomerInformation customer = null;

  private List<InvoiceProducts> products = new ArrayList<InvoiceProducts>();

  private String invoiceNumber = null;

  private String receiptNumber = null;

  private Date receiptDate = null;

  private long taxPayables;

  private long netTotal;

  private long grossTotal;

  private String notes = null;

  public Receipt header(InvoiceHeader header) {
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

  public Receipt customer(InvoiceCustomerInformation customer) {
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

  public Receipt products(List<InvoiceProducts> products) {
    this.products = products;
    return this;
  }

  public Receipt addProductsItem(InvoiceProducts productsItem) {
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

  public Receipt invoiceNumber(String invoiceNumber) {
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

  public Receipt receiptNumber(String receiptNumber) {
    this.receiptNumber = receiptNumber;
    return this;
  }

   /**
   * Get receiptNumber
   * @return receiptNumber
  **/
  @ApiModelProperty(value = "")
  public String getReceiptNumber() {
    return receiptNumber;
  }

  public void setReceiptNumber(String receiptNumber) {
    this.receiptNumber = receiptNumber;
  }

  public Receipt receiptDate(Date receiptDate) {
    this.receiptDate = (Date)receiptDate.clone();
    return this;
  }

   /**
   * Get receiptDate
   * @return receiptDate
  **/
  @ApiModelProperty(value = "")
  public Date getReceiptDate() {
    return (Date)receiptDate.clone();
  }

  public void setReceiptDate(Date receiptDate) {
    this.receiptDate = (Date)receiptDate.clone();
  }

  public Receipt taxPayables(long taxPayables) {
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

  public Receipt netTotal(long netTotal) {
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

  public Receipt grossTotal(long grossTotal) {
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

  public Receipt notes(String notes) {
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
    Receipt receipt = (Receipt) o;
    return Objects.equals(this.header, receipt.header) &&
        Objects.equals(this.customer, receipt.customer) &&
        Objects.equals(this.products, receipt.products) &&
        Objects.equals(this.invoiceNumber, receipt.invoiceNumber) &&
        Objects.equals(this.receiptNumber, receipt.receiptNumber) &&
        Objects.equals(this.receiptDate, receipt.receiptDate) &&
        Objects.equals(this.taxPayables, receipt.taxPayables) &&
        Objects.equals(this.netTotal, receipt.netTotal) &&
        Objects.equals(this.grossTotal, receipt.grossTotal) &&
        Objects.equals(this.notes, receipt.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, customer, products, invoiceNumber, receiptNumber, receiptDate, taxPayables, netTotal, grossTotal, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Receipt {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
    sb.append("    receiptNumber: ").append(toIndentedString(receiptNumber)).append("\n");
    sb.append("    receiptDate: ").append(toIndentedString(receiptDate)).append("\n");
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

