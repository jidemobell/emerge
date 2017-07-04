package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * AllegedPayment
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-15T06:33:48.490Z")
public class AllegedPayment   {
  /**
   * Gets or Sets paymentMethod
   */
  public enum PaymentMethodEnum {
    EMIS("EMIS"),
    
    BORDEREAU("Bordereau"),
    
    BANK_WIRE_TRANSFER("Bank Wire Transfer"),
    
    POSTAL_RECEIPTS_TO_COLLECTION("Postal Receipts to Collection");

    private String value;

    PaymentMethodEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private PaymentMethodEnum paymentMethod = null;

  /**
   * Gets or Sets servicesToProvision
   */
  public enum ServicesToProvisionEnum {
    TELOPAYPHONE("TeloPayPhone"),
    
    TEC("TEC"),
    
    PSP("PSP"),
    
    PAYPHONE("Payphone");

    private String value;

    ServicesToProvisionEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private ServicesToProvisionEnum servicesToProvision = null;

  private String paymentReferenceNumber = null;

  private String bankName = null;

  private double value;

  private long customerId;

  public AllegedPayment paymentMethod(PaymentMethodEnum paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

   /**
   * Get paymentMethod
   * @return paymentMethod
  **/
  @ApiModelProperty(value = "")
  public PaymentMethodEnum getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public AllegedPayment servicesToProvision(ServicesToProvisionEnum servicesToProvision) {
    this.servicesToProvision = servicesToProvision;
    return this;
  }

   /**
   * Get servicesToProvision
   * @return servicesToProvision
  **/
  @ApiModelProperty(value = "")
  public ServicesToProvisionEnum getServicesToProvision() {
    return servicesToProvision;
  }

  public void setServicesToProvision(ServicesToProvisionEnum servicesToProvision) {
    this.servicesToProvision = servicesToProvision;
  }

  public AllegedPayment paymentReferenceNumber(String paymentReferenceNumber) {
    this.paymentReferenceNumber = paymentReferenceNumber;
    return this;
  }

   /**
   * Get paymentReferenceNumber
   * @return paymentReferenceNumber
  **/
  @ApiModelProperty(value = "")
  public String getPaymentReferenceNumber() {
    return paymentReferenceNumber;
  }

  public void setPaymentReferenceNumber(String paymentReferenceNumber) {
    this.paymentReferenceNumber = paymentReferenceNumber;
  }

  public AllegedPayment bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

   /**
   * Get bankName
   * @return bankName
  **/
  @ApiModelProperty(value = "")
  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public AllegedPayment value(double value) {
    this.value = value;
    return this;
  }

   /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")
  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public AllegedPayment customerId(long customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * Get customerId
   * @return customerId
  **/
  @ApiModelProperty(value = "")
  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AllegedPayment allegedPayment = (AllegedPayment) o;
    return Objects.equals(this.paymentMethod, allegedPayment.paymentMethod) &&
        Objects.equals(this.servicesToProvision, allegedPayment.servicesToProvision) &&
        Objects.equals(this.paymentReferenceNumber, allegedPayment.paymentReferenceNumber) &&
        Objects.equals(this.bankName, allegedPayment.bankName) &&
        Objects.equals(this.value, allegedPayment.value) &&
        Objects.equals(this.customerId, allegedPayment.customerId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentMethod, servicesToProvision, paymentReferenceNumber, bankName, value, customerId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AllegedPayment {\n");
    
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    servicesToProvision: ").append(toIndentedString(servicesToProvision)).append("\n");
    sb.append("    paymentReferenceNumber: ").append(toIndentedString(paymentReferenceNumber)).append("\n");
    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
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

