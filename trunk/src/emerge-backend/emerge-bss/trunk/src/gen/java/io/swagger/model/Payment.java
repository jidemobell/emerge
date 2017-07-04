package io.swagger.model;

import java.util.Objects;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
 * Payment
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-11T10:10:19.635Z")
public class Payment {

    private long id = 0l;

    private Date paymentDate = null;

    private long customerId;

    private String description = null;

    @ApiModelProperty(value = "")
    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets or Sets reconciled
     */
    public enum ReconciledEnum {

        YES("Yes"),
        NO("No");

        private String value;

        ReconciledEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private ReconciledEnum reconciled = null;

    /**
     * Gets or Sets reconciledMethod
     */
    public enum ReconciledMethodEnum {

        MANUAL("Manual"),
        AUTOMATIC("Automatic");

        private String value;

        ReconciledMethodEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private ReconciledMethodEnum reconciledMethod = null;

    private String invoiceId = null;

    /**
     * Gets or Sets provisionedEquipment
     */
    public enum ProvisionedEquipmentEnum {

        TEC("TEC"),
        PSP("PSP"),
        PAYPHONE("Payphone");

        private String value;

        ProvisionedEquipmentEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private ProvisionedEquipmentEnum provisionedEquipment = null;

    private String paymentReferenceNumber = null;

    private String creditBeforePayment = null;

    private String creditAfterPayment = null;

    private double costOfPaymentMethod;

    private String nameOfBackOfficeOperator = null;

    private long prepaidServiceId;

    private long postpaidServiceId;

    /**
     * Gets or Sets revoked
     */
    public enum RevokedEnum {

        YES("Yes"),
        NO("No");

        private String value;

        RevokedEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private RevokedEnum revoked = null;

    private String bankName = null;

    private double value;

    private String note = null;

    /**
     * Gets or Sets paymentMethod
     */
    public enum PaymentMethodEnum {

        EMIS("EMIS"),
        CHEQUE("Cheque"),
        CASH("Cash"),
        SEPA("SEPA"),
        BORDEREAU("Bordereau"),
        BANK_WIRE_TRANSFER("Bank Wire Transfer"),
        FINANCE_DISCOUNT("Finance Discount"),
        RECONCILIATION_OF_ACCOUNTS("Reconciliation of Accounts"),
        POSTAL_RECEIPTS_TO_COLLECTION("Postal Receipts to Collection"),
        INTENAL_WALLETS("Intenal Wallets");

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

    private String paymentStatus = null;

    private String electronicReference = null;

    /**
     * Gets or Sets treasuryAccounts
     */
    public enum TreasuryAccountsEnum {

        EMIS("EMIS"),
        CHEQUE("Cheque"),
        CASH("Cash"),
        SEPA("SEPA"),
        BORDEREAU("Bordereau"),
        BANK_WIRE_TRANSFER("Bank Wire Transfer"),
        FINANCE_DISCOUNT("Finance Discount"),
        RECONCILIATION_OF_ACCOUNTS("Reconciliation of Accounts"),
        POSTAL_RECEIPTS_TO_COLLECTION("Postal Receipts to Collection"),
        INTENAL_WALLETS("Intenal Wallets");

        private String value;

        TreasuryAccountsEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private TreasuryAccountsEnum treasuryAccounts = null;

    /**
     * Gets or Sets paidService
     */
    public enum PaidServiceEnum {

        PREPAID("Prepaid"),
        POSTPAID("Postpaid");

        private String value;

        PaidServiceEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private PaidServiceEnum paidService = null;

    public Payment id(long id) {
        this.id = id;
        return this;
    }

    /**
     * Get paymentId
     *
     * @return paymentId
     *
     */
    @ApiModelProperty(value = "")
    public long getPaymentId() {
        return id;
    }

    public void setPaymentId(long id) {
        this.id = id;
    }

    public Payment paymentDate(Date paymentDate) {
        this.paymentDate = (Date) paymentDate.clone();
        return this;
    }

    /**
     * Get paymentDate
     *
     * @return paymentDate
     *
     */
    @ApiModelProperty(value = "")
    public Date getPaymentDate() {
        return (Date) paymentDate.clone();
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = (Date) paymentDate.clone();
    }

    public Payment customerId(long customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * Get customerId
     *
     * @return customerId
     *
     */
    @ApiModelProperty(value = "")
    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Payment prepaidServiceId(long prepaidServiceId) {
        this.prepaidServiceId = prepaidServiceId;
        return this;
    }

    /**
     * Get prepaidServiceId
     *
     * @return prepaidServiceId
     *
     */
    @ApiModelProperty(value = "")
    public long getPrepaidServiceId() {
        return prepaidServiceId;
    }

    public void setPrepaidServiceId(long prepaidServiceId) {
        this.prepaidServiceId = prepaidServiceId;
    }

    public Payment postpaidServiceId(long postpaidServiceId) {
        this.postpaidServiceId = postpaidServiceId;
        return this;
    }

    /**
     * Get postpaidServiceId
     *
     * @return postpaidServiceId
     *
     */
    @ApiModelProperty(value = "")
    public long getPostpaidServiceId() {
        return postpaidServiceId;
    }

    public void setPostpaidServiceId(long postpaidServiceId) {
        this.postpaidServiceId = postpaidServiceId;
    }

    public Payment reconciled(ReconciledEnum reconciled) {
        this.reconciled = reconciled;
        return this;
    }

    /**
     * Get reconciled
     *
     * @return reconciled
     *
     */
    @ApiModelProperty(value = "")
    public ReconciledEnum getReconciled() {
        return reconciled;
    }

    public void setReconciled(ReconciledEnum reconciled) {
        this.reconciled = reconciled;
    }

    /**
     * Get reconciledMethod
     *
     * @return reconciledMethod
     *
     */
    @ApiModelProperty(value = "")
    public ReconciledMethodEnum getReconciledMethod() {
        return reconciledMethod;
    }

    public void setReconciledMethod(ReconciledMethodEnum reconciledMethod) {
        this.reconciledMethod = reconciledMethod;
    }

    public Payment invoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
        return this;
    }

    /**
     * Get invoiceId
     *
     * @return invoiceId
     *
     */
    @ApiModelProperty(value = "")
    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Payment provisionedEquipment(ProvisionedEquipmentEnum provisionedEquipment) {
        this.provisionedEquipment = provisionedEquipment;
        return this;
    }

    /**
     * Get provisionedEquipment
     *
     * @return provisionedEquipment
     *
     */
    @ApiModelProperty(value = "")
    public ProvisionedEquipmentEnum getProvisionedEquipment() {
        return provisionedEquipment;
    }

    public void setProvisionedEquipment(ProvisionedEquipmentEnum provisionedEquipment) {
        this.provisionedEquipment = provisionedEquipment;
    }

    public Payment paymentReferenceNumber(String paymentReferenceNumber) {
        this.paymentReferenceNumber = paymentReferenceNumber;
        return this;
    }

    /**
     * Get paymentReferenceNumber
     *
     * @return paymentReferenceNumber
     *
     */
    @ApiModelProperty(value = "")
    public String getPaymentReferenceNumber() {
        return paymentReferenceNumber;
    }

    public void setPaymentReferenceNumber(String paymentReferenceNumber) {
        this.paymentReferenceNumber = paymentReferenceNumber;
    }

    public Payment creditBeforePayment(String creditBeforePayment) {
        this.creditBeforePayment = creditBeforePayment;
        return this;
    }

    /**
     * Get creditBeforePayment
     *
     * @return creditBeforePayment
     *
     */
    @ApiModelProperty(value = "")
    public String getCreditBeforePayment() {
        return creditBeforePayment;
    }

    public void setCreditBeforePayment(String creditBeforePayment) {
        this.creditBeforePayment = creditBeforePayment;
    }

    public Payment creditAfterPayment(String creditAfterPayment) {
        this.creditAfterPayment = creditAfterPayment;
        return this;
    }

    /**
     * Get creditAfterPayment
     *
     * @return creditAfterPayment
     *
     */
    @ApiModelProperty(value = "")
    public String getCreditAfterPayment() {
        return creditAfterPayment;
    }

    public void setCreditAfterPayment(String creditAfterPayment) {
        this.creditAfterPayment = creditAfterPayment;
    }

    public Payment costOfPaymentMethod(double costOfPaymentMethod) {
        this.costOfPaymentMethod = costOfPaymentMethod;
        return this;
    }

    /**
     * Get costOfPaymentMethod
     *
     * @return costOfPaymentMethod
     *
     */
    @ApiModelProperty(value = "")
    public double getCostOfPaymentMethod() {
        return costOfPaymentMethod;
    }

    public void setCostOfPaymentMethod(double costOfPaymentMethod) {
        this.costOfPaymentMethod = costOfPaymentMethod;
    }

    public Payment reconciledMethod(ReconciledMethodEnum reconciledMethod) {
        this.reconciledMethod = reconciledMethod;
        return this;
    }

    public Payment nameOfBackOfficeOperator(String nameOfBackOfficeOperator) {
        this.nameOfBackOfficeOperator = nameOfBackOfficeOperator;
        return this;
    }

    /**
     * Get nameOfBackOfficeOperator
     *
     * @return nameOfBackOfficeOperator
     *
     */
    @ApiModelProperty(value = "")
    public String getNameOfBackOfficeOperator() {
        return nameOfBackOfficeOperator;
    }

    public void setNameOfBackOfficeOperator(String nameOfBackOfficeOperator) {
        this.nameOfBackOfficeOperator = nameOfBackOfficeOperator;
    }

    public Payment revoked(RevokedEnum revoked) {
        this.revoked = revoked;
        return this;
    }

    /**
     * Get revoked
     *
     * @return revoked
     *
     */
    @ApiModelProperty(value = "")
    public RevokedEnum getRevoked() {
        return revoked;
    }

    public void setRevoked(RevokedEnum revoked) {
        this.revoked = revoked;
    }

    public Payment bankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    /**
     * Get bankName
     *
     * @return bankName
     *
     */
    @ApiModelProperty(value = "")
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Payment value(double value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     *
     */
    @ApiModelProperty(value = "")
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Payment note(String note) {
        this.note = note;
        return this;
    }

    /**
     * Get note
     *
     * @return note
     *
     */
    @ApiModelProperty(value = "")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Payment paymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    /**
     * Get paymentMethod
     *
     * @return paymentMethod
     *
     */
    @ApiModelProperty(value = "")
    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Payment paymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
        return this;
    }

    /**
     * Get paymentStatus
     *
     * @return paymentStatus
     *
     */
    @ApiModelProperty(value = "")
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Payment electronicReference(String electronicReference) {
        this.electronicReference = electronicReference;
        return this;
    }

    /**
     * Get electronicReference
     *
     * @return electronicReference
     *
     */
    @ApiModelProperty(value = "")
    public String getElectronicReference() {
        return electronicReference;
    }

    public void setElectronicReference(String electronicReference) {
        this.electronicReference = electronicReference;
    }

    public Payment treasuryAccounts(TreasuryAccountsEnum treasuryAccounts) {
        this.treasuryAccounts = treasuryAccounts;
        return this;
    }

    /**
     * Get treasuryAccounts
     *
     * @return treasuryAccounts
     *
     */
    @ApiModelProperty(value = "")
    public TreasuryAccountsEnum getTreasuryAccounts() {
        return treasuryAccounts;
    }

    public void setTreasuryAccounts(TreasuryAccountsEnum treasuryAccounts) {
        this.treasuryAccounts = treasuryAccounts;
    }

    public Payment paidService(PaidServiceEnum paidService) {
        this.paidService = paidService;
        return this;
    }

    /**
     * Get paidService
     *
     * @return paidService
     *
     */
    @ApiModelProperty(value = "")
    public PaidServiceEnum getPaidService() {
        return paidService;
    }

    public void setPaidService(PaidServiceEnum paidService) {
        this.paidService = paidService;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Payment payment = (Payment) o;
        return Objects.equals(this.id, payment.id)
                && Objects.equals(this.paymentDate, payment.paymentDate)
                && Objects.equals(this.customerId, payment.customerId)
                && Objects.equals(this.prepaidServiceId, payment.prepaidServiceId)
                && Objects.equals(this.postpaidServiceId, payment.postpaidServiceId)
                && Objects.equals(this.reconciled, payment.reconciled)
                && Objects.equals(this.reconciledMethod, payment.reconciledMethod)
                && Objects.equals(this.invoiceId, payment.invoiceId)
                && Objects.equals(this.provisionedEquipment, payment.provisionedEquipment)
                && Objects.equals(this.paymentReferenceNumber, payment.paymentReferenceNumber)
                && Objects.equals(this.creditBeforePayment, payment.creditBeforePayment)
                && Objects.equals(this.creditAfterPayment, payment.creditAfterPayment)
                && Objects.equals(this.costOfPaymentMethod, payment.costOfPaymentMethod)
                && Objects.equals(this.nameOfBackOfficeOperator, payment.nameOfBackOfficeOperator)
                && Objects.equals(this.revoked, payment.revoked)
                && Objects.equals(this.bankName, payment.bankName)
                && Objects.equals(this.value, payment.value)
                && Objects.equals(this.note, payment.note)
                && Objects.equals(this.paymentMethod, payment.paymentMethod)
                && Objects.equals(this.paymentStatus, payment.paymentStatus)
                && Objects.equals(this.electronicReference, payment.electronicReference)
                && Objects.equals(this.treasuryAccounts, payment.treasuryAccounts)
                && Objects.equals(this.paidService, payment.paidService)
                && Objects.equals(this.description, payment.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentDate, customerId, prepaidServiceId, postpaidServiceId, reconciled, reconciledMethod, invoiceId, provisionedEquipment, paymentReferenceNumber, creditBeforePayment, creditAfterPayment, costOfPaymentMethod, nameOfBackOfficeOperator, revoked, bankName, value, note, paymentMethod, paymentStatus, electronicReference, treasuryAccounts, paidService);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Payment {\n");

        sb.append("    paymentId: ").append(toIndentedString(id)).append("\n");
        sb.append("    paymentDate: ").append(toIndentedString(paymentDate)).append("\n");
        sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
        sb.append("    prepaidServiceId: ").append(toIndentedString(prepaidServiceId)).append("\n");
        sb.append("    postpaidServiceId: ").append(toIndentedString(postpaidServiceId)).append("\n");
        sb.append("    reconciled: ").append(toIndentedString(reconciled)).append("\n");
        sb.append("    reconciledMethod: ").append(toIndentedString(reconciledMethod)).append("\n");
        sb.append("    invoiceId: ").append(toIndentedString(invoiceId)).append("\n");
        sb.append("    provisionedEquipment: ").append(toIndentedString(provisionedEquipment)).append("\n");
        sb.append("    paymentReferenceNumber: ").append(toIndentedString(paymentReferenceNumber)).append("\n");
        sb.append("    creditBeforePayment: ").append(toIndentedString(creditBeforePayment)).append("\n");
        sb.append("    creditAfterPayment: ").append(toIndentedString(creditAfterPayment)).append("\n");
        sb.append("    costOfPaymentMethod: ").append(toIndentedString(costOfPaymentMethod)).append("\n");
        sb.append("    nameOfBackOfficeOperator: ").append(toIndentedString(nameOfBackOfficeOperator)).append("\n");
        sb.append("    revoked: ").append(toIndentedString(revoked)).append("\n");
        sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    note: ").append(toIndentedString(note)).append("\n");
        sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
        sb.append("    paymentStatus: ").append(toIndentedString(paymentStatus)).append("\n");
        sb.append("    electronicReference: ").append(toIndentedString(electronicReference)).append("\n");
        sb.append("    treasuryAccounts: ").append(toIndentedString(treasuryAccounts)).append("\n");
        sb.append("    paidService: ").append(toIndentedString(paidService)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
