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
import java.util.List;




/**
 * CreditNote
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-26T11:54:31.527Z")
public class CreditNote   {
  private InvoiceHeader header = null;

  private InvoiceCustomerInformation customer = null;

  private List<InvoiceProducts> products = new ArrayList<InvoiceProducts>();

  private String creditNoteNumber = null;

  private String invoiceNumber = null;

  public CreditNote header(InvoiceHeader header) {
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

  public CreditNote customer(InvoiceCustomerInformation customer) {
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

  public CreditNote products(List<InvoiceProducts> products) {
    this.products = products;
    return this;
  }

  public CreditNote addProductsItem(InvoiceProducts productsItem) {
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

  public CreditNote creditNoteNumber(String creditNoteNumber) {
    this.creditNoteNumber = creditNoteNumber;
    return this;
  }

   /**
   * Get creditNoteNumber
   * @return creditNoteNumber
  **/
  @ApiModelProperty(value = "")
  public String getCreditNoteNumber() {
    return creditNoteNumber;
  }

  public void setCreditNoteNumber(String creditNoteNumber) {
    this.creditNoteNumber = creditNoteNumber;
  }

  public CreditNote invoiceNumber(String invoiceNumber) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditNote creditNote = (CreditNote) o;
    return Objects.equals(this.header, creditNote.header) &&
        Objects.equals(this.customer, creditNote.customer) &&
        Objects.equals(this.products, creditNote.products) &&
        Objects.equals(this.creditNoteNumber, creditNote.creditNoteNumber) &&
        Objects.equals(this.invoiceNumber, creditNote.invoiceNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, customer, products, creditNoteNumber, invoiceNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditNote {\n");
    
    sb.append("    header: ").append(toIndentedString(header)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    creditNoteNumber: ").append(toIndentedString(creditNoteNumber)).append("\n");
    sb.append("    invoiceNumber: ").append(toIndentedString(invoiceNumber)).append("\n");
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

