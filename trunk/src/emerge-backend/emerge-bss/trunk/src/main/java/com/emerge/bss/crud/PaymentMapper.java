/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.crud;

import io.swagger.model.Payment;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Kolade Arowolo
 */

public class PaymentMapper {
  public static Payment getPayment(Map < String, Object > map) {
    Payment payment = new Payment();
    
    payment.setPaymentId(Long.parseLong(map.get("id").toString()));
    payment.setBankName(map.get("bank_name").toString());
    payment.setCostOfPaymentMethod(Double.parseDouble(map.get("cost_of_payment_method").toString()));
    payment.setCreditAfterPayment(map.get("credit_after_payment").toString());
    payment.setCreditBeforePayment(map.get("credit_before_payment").toString());
    payment.setCustomerId((Long.parseLong(map.get("customer_id").toString())));
    payment.setElectronicReference(map.get("electronic_reference").toString());
    payment.setNameOfBackOfficeOperator(map.get("name_of_back_office_operator").toString());
    payment.setNote(map.get("notes").toString());
    payment.setPaidService(Payment.PaidServiceEnum.valueOf(map.get("paid_service").toString()));
    payment.setPaymentReferenceNumber(map.get("payment_reference_number").toString());
    payment.setPaymentStatus(map.get("payment_status").toString());
    
    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ssZZ");
    DateTime dt = DateTime.parse(map.get("payment_date").toString(), formatter);
    payment.setPaymentDate(dt.toDate());
    
    Object prepaidServiceId = map.get("prepaid_service_id");
    Object postpaidServiceId = map.get("postpaid_service_id");

    if (prepaidServiceId != null) {
       payment.setPrepaidServiceId(Long.parseLong(prepaidServiceId.toString()));
    }
    
    if (postpaidServiceId != null) {
       payment.setPostpaidServiceId(Long.parseLong(postpaidServiceId.toString()));
    }
    payment.setProvisionedEquipment(Payment.ProvisionedEquipmentEnum.valueOf(map.get("provisioned_equipment").toString()));
    payment.setTreasuryAccounts(Payment.TreasuryAccountsEnum.valueOf(map.get("treasury_accounts").toString()));
    payment.setRevoked(Payment.RevokedEnum.valueOf(map.get("revoked").toString()));
    payment.setReconciled(Payment.ReconciledEnum.valueOf(map.get("reconciled").toString()));
    payment.setReconciledMethod(Payment.ReconciledMethodEnum.valueOf(map.get("reconciled_method").toString()));
    payment.setValue(Double.parseDouble(map.get("value").toString()));
    return payment;
  }
}