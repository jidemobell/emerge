/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.crud;

import com.emerge.bss.crud.mappers.CustomerAddressMapper;
import com.emerge.bss.crud.mappers.CustomerMapper;
import com.emerge.bss.crud.mappers.PrepaidContractMapper;
import io.swagger.model.ContractPrepaid;
import io.swagger.model.Customer;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.sqlobject.mixins.Transactional;

/**
 *
 * @author akin
 */
@RegisterMapper(PrepaidContractMapper.class)
public interface CustomerDAO extends Transactional<CustomerDAO> {

    @GetGeneratedKeys
    @SqlUpdate("insert into customers (name, fiscal_number, tax_exemption_certificates,country,website,private_notes,public_notes,status,tags) values "
            + "(:name, :fiscal_number, :tax_exemption_certificates, :country, :website, :private_notes, :public_notes,:status, :tags)")
    long createCustomer(
            @Bind("name") String name,
            @Bind("fiscal_number") String fiscal_number,
            @Bind("tax_exemption_certificates") String tax_exemption_certificates,
            @Bind("country") String country,
            @Bind("website") String website,
            @Bind("private_notes") String private_notes,
            @Bind("public_notes") String public_notes,
            @Bind("status") String status,
            @Bind("tags") String tags) throws SQLIntegrityConstraintViolationException;

    @GetGeneratedKeys
    @SqlUpdate("insert into customer_contacts (contact_type,contact_name, contact_email, contact_phone,contact_fax, customer_address_id,notify_by_sms,notify_by_email,send_invoice_by_email,creation_date) values "
            + "(:contact_type, :contact_name, :contact_email, :contact_phone, :contact_fax, :customer_address_id,:notify_by_sms, :notify_by_email,:send_invoice_by_email,now())")
    int createCustomerContact(@Bind("contact_type") String contact_type, @Bind("contact_name") String contact_name, @Bind("contact_email") String contact_email, @Bind("contact_phone") String contact_phone, @Bind("contact_fax") String contact_fax, @Bind("customer_address_id") long customer_address_id, @Bind("notify_by_sms") boolean notify_by_sms, @Bind("notify_by_email") boolean notify_by_email, @Bind("send_invoice_by_email") boolean send_invoice_by_email);

    @SqlUpdate("INSERT INTO contract_template (creation_date, modification_date, second_contractor_name, second_contractor_fiscal_number, second_contractor_address,preamble, "
            + "clauses, conditions_of_expiry, goods_and_services) values "
            + "(:creation_date, :modification_date, :second_contractor_name, :second_contractor_fiscal_number, :second_contractor_address, :preamble, :clauses, "
            + ":conditions_of_expiry, :goods_and_services)")
    void createContractTemplate(@Bind("creation_date") Date creation_date, @Bind("modification_date") Date modification_date, @Bind("second_contractor_name") String second_contractor_name, @Bind("second_contractor_fiscal_number") String second_contractor_fiscal_number, @Bind("second_contractor_address") String second_contractor_address, @Bind("preamble") String preamble, @Bind("clauses") String clauses, @Bind("conditions_of_expiry") String conditions_of_expiry, @Bind("goods_and_services") String service);

    @SqlUpdate("insert INTO credit_note (customer_name,customer_address, customer_vat_number, customer_telephone_number,supplier_name,supplier_address,supplier_vat_number,credit_note_number,rules, invoice_number, good_services, customer_id) values "
            + "(:customer_name,:customer_address, :customer_address, :customer_vat_number, :customer_telephone_number, :supplier_name,:supploer_address, :suppliervat_number, :credit_mote_number, :rules, invoice_number, good_services, customer_id)")
    void createCreditNotes(@Bind("customer_name") String customer_name, @Bind("customer_address") String customer_address, @Bind("customer_vat_number") String customer_vat_number, @Bind("customer_telephone_number") int customer_telephone_number, @Bind("supplier_name") String supplier_name, @Bind("supplier_address") String supplier_address, @Bind("supplier_vat_number") String supplier_vat_number, @Bind("credit_note_number") String credit_note_number, @Bind("rules") String rules, @Bind("invoice_number") String invoice_number, @Bind("good_services") String good_services, @Bind("customer_id") String customer_id);

    @SqlUpdate("insert INTO service_association (postpaid_service_id,contract_id, assoc_date, disassoc_date,status,start_date,end_date,unit_price,tax_percentage,tax_exemption,service_association_status) values "
            + "(:postpaid_service_id,:contract_id, :assoc_date, :disassoc_date, :status, :start_date,:end_date, :unit_price, :tax_percentage, :tax_exemption, :service_association_status)")
    void createPostPaidServiceAssociation(
            @Bind("postpaid_service_id") int contract_id,
            @Bind("assoc_date") Date assoc_date,
            @Bind("disassoc_date") Date disassoc_date,
            @Bind("status") String status,
            @Bind("start_date") Date start_date,
            @Bind("end_date") Date end_date,
            @Bind("unit_price") float unit_price,
            @Bind("tax_percentage") float tax_percentage,
            @Bind("tax_exemption") String tax_exemption,
            @Bind("service_association_status") String service_association_status
    );

    @SqlUpdate("INSERT INTO payment (payment_id, payment_date, customer_id, reconciled, reconciled_method,invoicenumber,provisioned_equipments,payment_reference_number,credit_before_payment,credit_after_payment,cost_of_payment_method,name_of_back_office_operator,revoked,bank_name,value,notes,payment_method,payment_status,electronic_reference,treasury_accounts,paid_service) values "
            + "(:payment_id,:payment_date,:customer_id, :reconciled, :reconciled_method,:invoicenumber,:provisioned_equipments,:payment_reference_number,:credit_before_payment,:credit_after_payment,:cost_of_payment_method,:name_of_back_office_operator,:revoked,:bank_name,:value,:notes,:payment_method,:payment_status,:electronic_reference,:treasury_accounts,:paid_service)")
    void createPayment(
            @Bind("payment_id") String payment_id,
            @Bind("payment_date") Date payment_date,
            @Bind("customer_id") String customer_id,
            @Bind("reconciled") String reconciled,
            @Bind("reconciled_method") String reconciled_method,
            @Bind("invoicenumber") int invoicenumber,
            @Bind("provisioned_equipments") String provisioned_equipments,
            @Bind("payment_reference_number") String payment_reference_number,
            @Bind("credit_before_payment") String credit_before_payment,
            @Bind("credit_after_payment") String credit_after_payment,
            @Bind("cost_of_payment_method") String cost_of_payment_method,
            @Bind("name_of_back_office_operator") String name_of_back_office_operator,
            @Bind("revoked") String revoked,
            @Bind("bank_name") String bankName,
            @Bind("value") String value,
            @Bind("notes") String notes,
            @Bind("payment_method") String payment_method,
            @Bind("payment_status") String payment_status,
            @Bind("electronic_reference") String electronic_reference,
            @Bind("treasury_accounts") String treasury_accounts,
            @Bind("paid_service") String paid_service);

    @SqlUpdate("INSERT INTO prepaid_contracts "
            + "(contract_mode, service_id, customer_id, status_date, second_contractor_name, second_contractor_fiscal_no, second_contractor_address, start_date, end_date,"
            + "preamble, clauses, expiration_conditions, first_contractor) "
            + "values "
            + "(:contract_mode, :service_id, :customer_id, :status_date, "
            + ":second_contractor_name, :second_contractor_fiscal_no, :second_contractor_address, :start_date, :end_date, :preamble, :clauses, "
            + ":expiration_conditions, :first_contractor)")

    void createPrepaidContract(
            @Bind("contract_mode") String contract_mode,
            @Bind("service_id") String service_id,
            @Bind("customer_id") String customer_id,
            @Bind("status_date") String status_date,
            @Bind("second_contractor_name") String second_contractor_name,
            @Bind("second_contractor_fiscal_no") String second_contractor_fiscal_no,
            @Bind("second_contractor_address") String second_contractor_address,
            @Bind("start_date") Date start_date,
            @Bind("end_date") Date end_date,
            @Bind("preamble") String preamble,
            @Bind("clauses") String clauses,
            @Bind("expiration_conditions") String expiration_conditions,
            @Bind("first_contractor") String first_contractor,
            @Bind("goods_services") String goods_services);

    @SqlUpdate("INSERT INTO telo_agents (prepaid_service_id, balance) values (:prepaid_service_id, :balance)")
    void createTeloAgent(
            @Bind("prepaid_service_id") String prepaid_service_id,
            @Bind("balance") double balance);

    @SqlUpdate("insert into postpaid_contracts (contract_mode, allow_joint_billing, customer_id, billing_periodicity, billing_day, "
            + "status_date, second_contractor_name, second_contractor_fiscal_no, second_contractor_address, start_date, end_date, preamble, clauses, "
            + "expiration_conditions, first_contractor, goods_services) "
            + "values "
            + "(:contract_mode, :allow_joint_billing, :customer_id, :billing_periodicity, :billing_day, :status_date, "
            + ":second_contractor_name, :second_contractor_fiscal_no, :second_contractor_address, :start_date, :end_date, :preamble, :clauses, :expiration_conditions, "
            + ":first_contractor, :goods_services)")

    void createPostpaidContract(
            @Bind("contract_mode") String contract_mode,
            @Bind("allow_joint_billing") String allow_joint_billing,
            @Bind("customer_id") String customer_id,
            @Bind("billing_periodicity") String billing_periodicity,
            @Bind("billing_day") Date billing_day,
            @Bind("status_date") String status_date,
            @Bind("second_contractor_name") String second_contractor_name,
            @Bind("second_contractor_fiscal_no") String second_contractor_fiscal_no,
            @Bind("second_contractor_address") String second_contractor_address,
            @Bind("start_date") String start_date,
            @Bind("end_date") String end_date,
            @Bind("preamble") String preamble,
            @Bind("clauses") String clauses,
            @Bind("expiration_conditions") String expiration_conditions,
            @Bind("first_contractor") String first_contractor,
            @Bind("goods_services") String goods_services);

    @SqlUpdate("insert into invoice (due_date,customer_id, provisioned_equipment_id, invoice_number,payment_id,notification_method,company_name,business_name,"
            + "tax_registration_number,telephone_number,fax,accountId,vat_number,invoice_hash,invoice_hash_control,invoice_type,invoice_date,product_code,quantity,unit_price"
            + "discount_percent,discount_value,description,amount_without_tax,tax_type,tax_percentage,tax_amount,tax_exemption_reason,tax_payables,net_total,gross_total,"
            + "emis_entity_code,emis_reference_code,authorization_reference_number,account_number,bank_id,notes) values "
            + "(:due_date,:customer_id, :provisioned_equipment_id, :invoice_number, :payment_id,notification_method,: company_name, :business_name, :tax_registration_number, :telephone_number, :fax,accountId, :vat_number, :invoice_hash, :invoice_hash_control, :invoice_type, :invoice_date, :product_code, :quantity, :unit_price"
            + ":discount_percent, :discount_value, :description, :amount_without_tax, :tax_type, :tax_percentage, :tax_amount, :tax_exemption_reason, :tax_payables, :net_total, :gross_total, :emis_entity_code, :emis_reference_code, :authorization_reference_number, :account_number, :bank_id, :notes)")
    void createInvoice(
            @Bind("due_date") Date due_date,
            @Bind("customer_id") int customer_id,
            @Bind("provisioned_equipment_id") String provisioned_equipment_id,
            @Bind("invoice_number") String invoice_number,
            @Bind("invoice_id") int invoice_id,
            @Bind("payment_id") String payment_id,
            @Bind("company_name") String company_name,
            @Bind("business_name") String business_name,
            @Bind("tax_registration_number") String tax_registration_number,
            @Bind("telephone_number") String telephone_number,
            @Bind("fax") String fax,
            @Bind("vat_number") String vat_number,
            @Bind("invoice_hash") String invoice_hash,
            @Bind("invoice_hash_control") String invoice_hash_control,
            @Bind("invoice_type") String invoice_type,
            @Bind("invoice_date") Date invoice_date,
            @Bind("product_code") String product_code,
            @Bind("quantity") String quantity,
            @Bind("unit_price") String unit_price);

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO alleged_payment (payment_method, services_to_provision, payment_reference_number, bank_name, value, customer_id) values "
            + "(:payment_method, :services_to_provision, :payment_reference_number, :bank_name, :value, :customer_id)")

    int createAllegedPayment(
            @Bind("payment_method") String payment_method,
            @Bind("services_to_provision") String services_to_provision,
            @Bind("payment_reference_number") int payment_reference_number,
            @Bind("bank_name") String bank_name,
            @Bind("value") String value,
            @Bind("customer_id") String customer_id
    );

    @GetGeneratedKeys
    @SqlUpdate("insert into customer_addresses (address_name,address,customer_id, fax_number, telephone_number,email) values"
            + "(:address_name,:address, :customer_id, :fax_number, :telephone_number,:email)")

    long createBillingAddress(
            @Bind("address_name") String address_name,
            @Bind("address") String address,
            @Bind("fax_number") String fax_number,
            @Bind("telephone_number") String telephone_number,
            @Bind("customer_id") long customer_id,
            @Bind("email") String email
    );

    @SqlUpdate("INSERT INTO tax_types (description, percentage) values "
            + "(:description, :percentage)")
    int createTaxType(@Bind("description") String description,
            @Bind("percentage") long percentage);

    @SqlUpdate("insert into telo_operator_profit_config (start_amount,end_amount, profit_percentage) values"
            + "(:start_amount, :end_amount, :profit_percentage)")
    void createTeloOperatorProfitConfig(
            @Bind("start_amount") double start_amount,
            @Bind("end_amount") double end_amount,
            @Bind("profit_percentage") double profit_percentage);

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO alleged_payment (payment_method, services_to_provision) values "
            + "(:payment_method, :services_to_provision)")

    int createAllegedPayment(@Bind("payment_method") String payment_method, @Bind("services_to_provision") String services_to_provision, @Bind("alleged_payment_id") String alleged_payment_id);

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO prepaid_contracts "
            + "(contract_mode, service_id, customer_id, status_date, second_contractor_name, second_contractor_fiscal_no, second_contractor_address, start_date,end_date,"
            + "preamble,clauses,expiration_conditions,first_contractor,goods_services) values "
            + "(:contract_mode, :service_id, :customer_id, :status_date, :second_contractor_name, :second_contractor_fiscal_no, :second_contractor_address,"
            + " :start_date, :end_date, :preamble, :clauses, :expiration_conditions, :first_contractor, :goods_services)")

    int UpdatePrepaidContract(@Bind("contract_mode") String contract_mode,
            @Bind("service_id") String service_id,
            @Bind("customer_id") String customer_id,
            @Bind("status_date") String status_date,
            @Bind("second_contractor_name") String second_contractor_name,
            @Bind("second_contractor_fiscal_no") String second_contractor_fiscal_no,
            @Bind("second_contractor_address") String second_contractor_address,
            @Bind("start_date") String start_date,
            @Bind("end_date") String end_date,
            @Bind("preamble") String preamble,
            @Bind("clauses") String clauses,
            @Bind("expiration_conditions") String expiration_conditions,
            @Bind("first_contractor") String first_contractor,
            @Bind("goods_services") String goods_services);

    @SqlUpdate("insert into supplement_prepaid"
            + "(referenced_contract_id, supplement_contract_id) values "
            + "(:referenced_contract_id, :supplement_contract_id)")

    void createPrepaidContractSupplimentRecord(
            @Bind("referenced_contract_id") int referenced_contract_id,
            @Bind("supplement_contract_id") int supplement_contract_id
    );

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO postpaid_contracts "
            + "(contract_mode, allow_joint_billing, customer_id, billing_periodicity, billing_day, status_date, "
            + "second_contractor_name, second_contractor_fiscal_no, second_contractor_address, "
            + "start_date, end_date, preamble, clauses, expiration_conditions, first_contractor, goods_services) "
            + "values "
            + "(:contract_mode, :allow_joint_billing, :customer_id, :billing_periodicity, :billing_day, :status_date, "
            + ":second_contractor_name, :second_contractor_fiscal_no, :second_contractor_address, :start_date, :end_date, :preamble, :clauses, "
            + ":expiration_conditions, :first_contractor, :goods_services)")

    int UpdatePostpaidContract(
            @Bind("contract_mode") String contract_mode,
            @Bind("allow_joint_billing") String allow_joint_billing,
            @Bind("customer_id") String customer_id,
            @Bind("billing_periodicity") String billing_periodicity,
            @Bind("billing_day") Date billing_day,
            @Bind("status_date") String status_date,
            @Bind("second_contractor_name") String second_contractor_name,
            @Bind("second_contractor_fiscal_no") String second_contractor_fiscal_no,
            @Bind("second_contractor_address") String second_contractor_address,
            @Bind("start_date") String start_date,
            @Bind("end_date") String end_date,
            @Bind("preamble") String preamble,
            @Bind("clauses") String clauses,
            @Bind("expiration_conditions") String expiration_conditions,
            @Bind("first_contractor") String first_contractor,
            @Bind("goods_services") String goods_services);

    @SqlUpdate("INSERT INTO supplement_postpaid"
            + "(referenced_contract_id, supplement_contract_id) values "
            + "(:referenced_contract_id, :supplement_contract_id)")

    void createPostpaidContractSupplimentRecord(
            @Bind("referenced_contract_id") int referenced_contract_id,
            @Bind("supplement_contract_id") int supplement_contract_id
    );

    @SqlUpdate("UPDATE alleged_payment SET payment_method = :payment_method, services_to_provision = :services_to_provision, customer_id = :customer_id, "
            + "payment_reference_number = :payment_reference_number, bank_name = :bank_name, value = :value WHERE id = :alledged_payment_id")

    void updateAllegedPayment(
            @Bind("alledged_payment_id") Long alledged_payment_id,
            @Bind("payment_method") String payment_method,
            @Bind("services_to_provision") String services_to_provision,
            @Bind("payment_reference_number") int payment_reference_number,
            @Bind("bank_name") String bank_name,
            @Bind("value") String value,
            @Bind("customer_id") String customer_id);

    @SqlUpdate("UPDATE telo_agents SET prepaid_service_id = :prepaid_service_id, balance = :balance WHERE id = :id")
    void updateTeloAgent(
            @Bind("id") Long id,
            @Bind("prepaid_service_id") String prepaid_service_id,
            @Bind("balance") double balance
    );

    @SqlUpdate("UPDATE tax_types SET description = :description, percentage = :percentage WHERE id = :taxTypeId")
    void updateTaxType(
            @Bind("taxTypeId") Long taxTypeId,
            @Bind("description") String description,
            @Bind("percentage") double percentage);

    //********Contract Template********************************
    @SqlUpdate("UPDATE contract_template SET "
            + "creation_date = :creation_date, modification_date = :modification_date, second_contractor_name = :second_contractor_name, second_contractor_fiscal_number = :second_contractor_fiscal_number, second_contractor_address = :second_contractor_address, "
            + "preamble = :preamble, "
            + "clauses = :clauses, conditions_of_expiry = :conditions_of_expiry, goods_and_services = :goods_and_services "
            + "WHERE id = :id")

    public void UpdateContractTemplate(
            @Bind("id") long id,
            @Bind("creation_date") Date creation_date,
            @Bind("modification_date") Date modification_date,
            @Bind("second_contractor_name") String second_contractor_name,
            @Bind("second_contractor_fiscal_number") String second_contractor_fiscal_number,
            @Bind("second_contractor_address") String second_contractor_address,
            @Bind("preamble") String preamble,
            @Bind("clauses") String clauses,
            @Bind("conditions_of_expiry") String conditions_of_expiry,
            @Bind("goods_and_services") String service
    );

    //***********************Update Telo Operator Profit Config*********************
    @SqlUpdate("UPDATE telo_operator_profit_config SET start_amount = :start_amount,end_amount = :end_amount, profit_percentage = :profit_percentage WHERE id = :id")
    void updateTeloOperatorProfitConfig(
            @Bind("start_amount") double start_amount,
            @Bind("end_amount") double end_amount,
            @Bind("profit_percentage") double profit_percentage,
            @Bind("id") int id
    );

    //************Payment***********************
    @SqlUpdate("UPDATE payment SET "
            + "payment_date = :payment_date, customer_id = :customer_id, reconciled = :reconciled, "
            + "reconciled_method = :reconciled_method, "
            + "invoicenumber = :invoicenumber, provisioned_equipments = :provisioned_equipments, payment_reference_number = :payment_reference_number, "
            + "credit_before_payment = :credit_before_payment, credit_after_payment =  :credit_after_payment, cost_of_payment_method =  :cost_of_payment_method, "
            + "name_of_back_office_operator = :name_of_back_office_operator, revoked = :revoked, bank_name = :bank_name, value = :value, notes = :notes, payment_method = :payment_method, payment_status = :payment_status, "
            + "electronic_reference = :electronic_reference, treasury_accounts = :treasury_accounts, paid_service = :paid_service WHERE id = :payment_id")

    public void UpdatePayment(
            @Bind("payment_id") Long payment_id,
            @Bind("payment_date") Date payment_date,
            @Bind("customer_id") int customer_id,
            @Bind("reconciled") String reconciled,
            @Bind("reconciled_method") String reconciled_method,
            @Bind("invoicenumber") int invoicenumber,
            @Bind("provisioned_equipments") String provisioned_equipments,
            @Bind("payment_reference_number") String payment_reference_number,
            @Bind("credit_before_payment") String credit_before_payment,
            @Bind("credit_after_payment") String credit_after_payment,
            @Bind("cost_of_payment_method") String cost_of_payment_method,
            @Bind("name_of_back_office_operator") String name_of_back_office_operator,
            @Bind("revoked") String revoked,
            @Bind("bank_name") String bankName,
            @Bind("value") String value,
            @Bind("notes") String notes,
            @Bind("payment_method") String payment_method,
            @Bind("payment_status") String payment_status,
            @Bind("electronic_reference") String electronic_reference,
            @Bind("treasury_accounts") String treasury_accounts,
            @Bind("paid_service") String paid_service);

    @SqlUpdate("UPDATE invoice SET due_date = :due_date,customer_id = :customer_id, provisioned_equipment_id = :provisioned_equipment_id, invoice_number =:invoice_number,payment_id = :payment_id, notification_method = :notification_method,company_name = :company_name,business_name = :business_name,"
            + "tax_registration_number = :tax_registration_number,telephone_number = :telephone_number, fax = :fax,accountId = :accountId,vat_number = :vat_number,invoice_hash = :invoice_hash,invoice_hash_control = :invoice_hash_control,invoice_type = :invoice_type,invoice_date = :invoice_date,product_code = :product_code,quantity = :quantity,unit_price = :unit_price"
            + "WHERE invoice_id = :invoice_id")
    void updateInvoice(
            @Bind("due_date") Date due_date,
            @Bind("customer_id") int customer_id,
            @Bind("provisioned_equipment_id") String provisioned_equipment_id,
            @Bind("invoice_number") String invoice_number,
            @Bind("invoice_id") int invoice_id,
            @Bind("payment_id") String payment_id,
            @Bind("company_name") String company_name,
            @Bind("business_name") String business_name,
            @Bind("tax_registration_number") String tax_registration_number,
            @Bind("telephone_number") String telephone_number,
            @Bind("fax") String fax,
            @Bind("vat_number") String vat_number,
            @Bind("invoice_hash") String invoice_hash,
            @Bind("invoice_hash_control") String invoice_hash_control,
            @Bind("invoice_type") String invoice_type,
            @Bind("invoice_date") Date invoice_date,
            @Bind("product_code") String product_code,
            @Bind("quantity") String quantity,
            @Bind("unit_price") String unit_price);

    @SqlUpdate("update customers set name = :name, fiscal_number = :fiscal_number,tax_exemption_certificates = :tax_exemption_certificates,country = :country,website = :website,private_notes = :private_notes,public_notes = :public_notes,status = :status, tags = :tags where id = :id")
    int updateCustomer(
            @Bind("name") String name,
            @Bind("fiscal_number") String fiscal_number,
            @Bind("tax_exemption_certificates") String tax_exemption,
            @Bind("country") String country,
            @Bind("website") String website,
            @Bind("private_notes") String private_notes,
            @Bind("public_notes") String public_notes,
            @Bind("tags") String tags,
            @Bind("status") String status,
            @Bind("id") long id);

    @SqlUpdate("UPDATE customer_addresses SET address_name = :address_name,address = :address, fax_number = :fax_number, telephone_number = :telephone_number,email =  :email where id = :id")
    int updateBillingAddress(
            @Bind("address_name") String address_name,
            @Bind("address") String address,
            @Bind("fax_number") String fax_number,
            @Bind("telephone_number") String telephone_number,
            @Bind("email") String email,
            @Bind("id") long id);

    @SqlUpdate("UPDATE service_association postpaid_service_id = :postpaid_service_id, contract_id = :contract_id, assoc_date = :assoc_date, disassoc_date = :disassoc_date, status = :status, start_date = :start_date, end_date = :end_date,unit_price = :unit_price, tax_percentage = :tax_percentage, tax_exemption = :tax_exemption,service_association_status = :service_association_status WHERE id = :id")
    void updatePostPaidServiceAssociation(
            @Bind("postpaid_service_id") int contract_id,
            @Bind("assoc_date") Date assoc_date,
            @Bind("disassoc_date") Date disassoc_date,
            @Bind("status") String status,
            @Bind("unit_price") float unit_price,
            @Bind("tax_percentage") float tax_percentage,
            @Bind("tax_exemption") String tax_exemption,
            @Bind("service_association_status") String service_association_status,
            @Bind("id") String id
    );

    //Fetch Operations
    @SqlQuery("select payment_method, services_to_provision FROM alleged_payment "
            + "WHERE ((:alleged_payment_id IS NOT NULL) AND (id = :alleged_payment_id))"
            + "OR ((:payment_method IS NOT NULL) AND (payment_method = :payment_method))"
            + "LIMIT :bucket_size OFFSET :offset")

    List<Map> findAllegedPayment(@Bind("alleged_payment_id") Long alleged_payment_id,
            @Bind("payment_method") String payment_method,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size
    );

    @SqlQuery("select contract_id, service_id, customer_id, status_date, second_contractor, start_date,end_date,preamble,clauses,expiration_conditions,first_contractor,goods_services from prepaid_contracts ")
    ArrayList<Map> findAllPrepaidContracts();

    @SqlQuery("select billing_periodicity, billing_day, customer_id, allow_joint_billing, contract_id, status_date, second_contractor, start_date,end_date,preamble,clauses,expiration_conditions,first_contractor,goods_services from postpaid_contracts")
    ArrayList<Map> findAllPostpaidContracts();

    @SqlQuery("select contract_id, service_id, customer_id, status_date, second_contractor, start_date,end_date,preamble,clauses,expiration_conditions,first_contractor,goods_services from prepaid_contracts where customer_id = :customer_id")
    ArrayList<Map> findPrepaidContractsByCustomerId(@Bind("customer_id") String customer_id);

    @SqlQuery("select billing_periodicity, billing_day, customer_id, allow_joint_billing, contract_id from postpaid_contracts where customer_id = :customer_id")
    ArrayList<Map> findPostpaidContractsByCustomerId(@Bind("customer_id") String customer_id);

    @Mapper(EntityMapper.class)
    @SqlQuery("select id, creation_date, modification_date, second_contractor_name, second_contractor_fiscal_number, second_contractor_address, "
            + "preamble, clauses, conditions_of_expiry, goods_and_services FROM contract_template WHERE "
            + "((:contract_template_id IS NOT NULL) AND id = :contract_template_id)"
            + " LIMIT :bucket_size OFFSET :offset")

    List<Map> findContractTemplate(
            @Bind("contract_template_id") long contract_template_id,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size);

    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT id, payment_date, customer_id, reconciled, reconciled_method, invoicenumber, provisioned_equipments,payment_reference_number,"
            + "credit_before_payment,credit_after_payment, cost_of_payment_method,name_of_back_office_operator,revoked,bank_name,value,notes,payment_method,payment_status,"
            + "electronic_reference,treasury_accounts,paid_service FROM payment "
            + "WHERE ((:id IS NOT NULL) AND (id = :id ))"
            + "OR ((:customer_id IS NOT NULL) AND (customer_id = :customer_id))"
            + "OR ((:invoicenumber IS NOT NULL) AND (invoicenumber = :invoicenumber ))"
            + "LIMIT :bucket_size OFFSET :offset")

    List<Map> findPaymentById(@Bind("id") long id,
            @Bind("customer_id") String customer_id,
            @Bind("invoicenumber") String invoicenumber,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size
    );

    //Fetch invoices from database based on search parameters and pagination values
    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT id,customer_id, provisioned_equipment_id, invoice_number, payment_id, notification_method, company_name, business_name, tax_registration_number, telephone_number, fax, account_id from invoice "
            + "WHERE ((:customer_id IS NULL) OR (customer_id = :customer_id)) "
            + "AND ((:invoice_number IS NULL) OR (invoice_number = :invoice_number))"
            //            //            + "AND ((:invoice_id IS NULL) OR (invoice_id = :invoice_id))"
            //            //            + "AND ((:payment_id IS NULL) OR (payment_id = :payment_id))"
            //            + "AND ((:begin_date IS NULL) OR (invoice_date between :begin_date AND :end_date))"
            + "LIMIT :bucket_size OFFSET :offset"
    )
    List<Map> findInvoices(
            @Bind("customer_id") String customer_id,
            @Bind("invoice_number") String invoice_number,
            @Bind("begin_date") Date begin_date,
            @Bind("end_date") Date end_date,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size);

    //Fetch TeloAgents from database based on search parameters and pagination values
    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT id,prepaid_service_id, balance FROM telo_agents"
            + "WHERE ((:id IS NULL) OR (id = :id)) "
            + "AND ((:prepaid_service_id IS NULL) OR (prepaid_service_id = :prepaid_service_id))"
            + "LIMIT :bucket_size OFFSET :offset"
    )
    List<Map> getTeloAgent(
            @Bind("id") String id,
            @Bind("prepaid_service_id") String prepaid_service_id,
            @Bind("balance") Float balance,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size);

    //Fetch taxTypes from database based on search parameters and pagination values
    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT id, description, percentage FROM tax_types "
            + "WHERE ((:id IS NOT NULL) AND (id = :id)) "
            + "OR ((:percentage IS NOT NULL) AND (percentage = :percentage)) "
            + "LIMIT :bucket_size OFFSET :offset"
    )
    List<Map> getTaxType(
            @Bind("id") Long id,
            @Bind("description") String description,
            @Bind("percentage") String percentage,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size);

    //Fetch service association from database based on search parameters and pagination values
    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT postpaid_service_id, contract_id, assoc_date, "
            + "disassoc_date, status, start_date, "
            + "end_date, unit_price, tax_percentage, tax_exemption,service_association_status  from postpaid_services"
            + "WHERE ((:postpaid_service_id IS NULL) OR (postpaid_service_id = :postpaid_service_id)) "
            + "AND ((:contract_id IS NULL) OR (contract_id = :contract_id))"
            + "AND ((:status IS NULL) OR (status = :status))"
            + "AND ((:begin_date IS NULL) OR (assoc_date between :begin_date AND :end_date))"
            + "LIMIT :bucket_size OFFSET :offset"
    )
    List<Map> findServiceAssociation(
            @Bind("contract_id") String contract_id,
            @Bind("postpaid_service_id") String postpaid_service_id,
            @Bind("status") String status,
            @Bind("begin_date") Date begin_date,
            @Bind("end_date") Date end_date,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size);

    //Fetch service customer billing address from database based on search parameters and pagination values
    @Mapper(CustomerAddressMapper.class)
    @SqlQuery("SELECT address_name,address, fax_number, telephone_number,email,"
            + "customer_id, id from customer_addresses "
            + "WHERE ((enum_status_id != 2))"
            + "AND ((:telephone_number::varchar IS NULL) OR (telephone_number = :telephone_number)) "
            + "AND ((:email::varchar IS NULL) OR (email = :email))"
            + "AND ((:customer_id::int = 0) OR (customer_id = :customer_id))"
            + "AND ((:id::int = 0) OR (id = :id))"
            + "AND ((:begin_date::DATE IS NULL) OR (db_cdate between :begin_date AND :end_date))"
            + "LIMIT :bucket_size OFFSET :offset "
//               + "ORDER BY id ASC"
    )
    List<Map> findBillingAddress(
            @Bind("telephone_number") String telephone_number,
            @Bind("email") String email,
            @Bind("customer_id") long customer_id,
            @Bind("id") long id,
            @Bind("begin_date") Date begin_date,
            @Bind("end_date") Date end_date,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size);

    @SqlQuery("SELECT count(*) from customer_addresses "
            + "WHERE ((:telephone_number::varchar IS NULL) OR (telephone_number = :telephone_number)) "
            + "AND ((:email::varchar IS NULL) OR (email = :email))"
            + "AND ((:customer_id::int = 0) OR (customer_id = :customer_id))"
            + "AND ((:begin_date::DATE IS NULL) OR (db_cdate between :begin_date AND :end_date))"
    )
    int findBillingAddressCount(
            @Bind("telephone_number") String telephone_number,
            @Bind("email") String email,
            @Bind("customer_id") long customer_id,
            @Bind("begin_date") Date begin_date,
            @Bind("end_date") Date end_date);

    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT start_amount,end_amount, profit_percentage from telo_operator_profit_config  WHERE id = :id")
    List<Map> findTeloOperatorProfitConfig(
            @Bind("id") int id
    );

    //Fetch customers from database based on search parameters and pagination values
    @Mapper(CustomerMapper.class)
    @SqlQuery("SELECT distinct on (cs.id) cs.id,cs.db_cdate,cs.name, cs.fiscal_number,cs.status, cs.tax_exemption_certificates,cs.country,cs.website,"
            + "cs.private_notes,cs.public_notes,cs.tags,ca.email,ca.telephone_number from customers cs left join customer_addresses ca on (ca.customer_id = cs.id) "
            + "WHERE ((:name::varchar IS NULL) OR (cs.name iLIKE concat('%',:name::varchar,'%')))"
            + "AND ((:fiscal_number::varchar IS NULL) OR (fiscal_number = :fiscal_number))"
            + "AND ((:id::int = 0) OR (cs.id = :id))"
            + "AND ((:status::varchar IS NULL) OR (cs.status = :status))"
            + "AND ((:tags::varchar IS NULL) OR (cs.tags iLIKE concat('%',:tags::varchar,'%')))"
            + "AND ((:tax_exemption_certificates::varchar IS NULL) OR (cs.tax_exemption_certificates iLIKE concat('%',:tax_exemption_certificates::varchar,'%')))"
            + "AND ((:begin_date::DATE IS NULL) OR (cs.db_cdate between :begin_date AND :end_date))"
            + "AND cs.enum_status_id != 2 LIMIT :bucket_size OFFSET :offset"
    )

    List<Map> getCustomers(
            @Bind("name") String name,
            @Bind("fiscal_number") String fiscalNumber,
            @Bind("status") String status,
            @Bind("id") long id,
            @Bind("tags") String tags,
            @Bind("tax_exemption_certificates") String taxExemptionCertificate,
            @Bind("begin_date") Date beginDate,
            @Bind("end_date") Date endDate,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucketSize);

    //Fetch customers from database based on search parameters and pagination values
    @Mapper(CustomerMapper.class)
    @SqlQuery("SELECT distinct on (cs.id) cs.id,cs.db_cdate,cs.name,ps.service_type, cs.fiscal_number,cs.status, cs.tax_exemption_certificates,cs.country,cs.website,"
            + "cs.private_notes,cs.public_notes,cs.tags,ca.email,ca.telephone_number from customers cs left join customer_addresses ca on (ca.customer_id = cs.id) "
            + " join prepaid_contracts pc on (cs.id = pc.customer_id) join prepaid_services ps on (pc.prepaid_service_id = ps.id) "
            + "WHERE ((:name::varchar IS NULL) OR (cs.name iLIKE concat('%',:name::varchar,'%')))"
            + "AND ((:fiscal_number::varchar IS NULL) OR (fiscal_number = :fiscal_number))"
            + "AND ((:id::int = 0) OR (cs.id = :id))"
            + "AND ((:status::varchar IS NULL) OR (cs.status = :status))"
            + "AND ((:tags::varchar IS NULL) OR (cs.tags iLIKE concat('%',:tags::varchar,'%')))"
            + "AND ((:provisionedEquipment::varchar IS NULL) OR (ps.service_type iLIKE concat('%',:provisionedEquipment::varchar,'%')))"
            + "AND ((:tax_exemption_certificates::varchar IS NULL) OR (cs.tax_exemption_certificates iLIKE concat('%',:tax_exemption_certificates::varchar,'%')))"
            + "AND ((:begin_date::DATE IS NULL) OR (cs.db_cdate between :begin_date AND :end_date))"
            + "AND cs.enum_status_id != 2 LIMIT :bucket_size OFFSET :offset"
    )

    List<Map> getCustomersByEquipment(
            @Bind("name") String name,
            @Bind("fiscal_number") String fiscalNumber,
            @Bind("status") String status,
            @Bind("id") long id,
            @Bind("tags") String tags,
            @Bind("provisionedEquipment") String provisionedEquipment,
            @Bind("tax_exemption_certificates") String taxExemptionCertificate,
            @Bind("begin_date") Date beginDate,
            @Bind("end_date") Date endDate,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucketSize);

    @Mapper(CustomerMapper.class)
    @SqlQuery("SELECT distinct on (cs.id) cs.id, cs.db_cdate,cs.name, cs.fiscal_number,cs.status, cs.tax_exemption_certificates,cs.country,cs.website,"
            + "cs.private_notes,cs.public_notes,cs.tags,ca.email,ca.telephone_number from customers cs left join customer_addresses ca on (ca.customer_id = cs.id)"
            + "WHERE cs.id = :id"
    )

    List<Map> getCustomer(
            @Bind("id") long id
    );

    //Fetch customers count from database based on search parameters no limits
    @SqlQuery("SELECT count( distinct(cs.id)) from customers cs "
            + "WHERE ((:name::varchar IS NULL) OR (cs.name iLIKE concat('%',:name::varchar,'%')))"
            + "AND ((:fiscal_number::varchar IS NULL) OR (cs.fiscal_number = :fiscal_number))"
            + "AND ((:id::int = 0) OR (cs.id = :id))"
            + "AND ((:status::varchar IS NULL) OR (cs.status = :status))"
            + "AND ((:tags::varchar IS NULL) OR (cs.tags iLIKE concat('%',:tags::varchar,'%')))"
            + "AND ((:tax_exemption_certificates::varchar IS NULL) OR (cs.tax_exemption_certificates iLIKE concat('%',:tax_exemption_certificates::varchar,'%')))"
            + "AND ((:begin_date::DATE IS NULL) OR (cs.db_cdate between :begin_date AND :end_date))"
            + "AND cs.enum_status_id != 2"
    )
    long getCustomersCount(
            @Bind("name") String name,
            @Bind("fiscal_number") String fiscal_number,
            @Bind("status") String status,
            @Bind("id") long id,
            @Bind("tags") String tags,
            @Bind("tax_exemption_certificates") String taxExemptionCertificates,
            @Bind("begin_date") Date begin_date,
            @Bind("end_date") Date end_date);

    @SqlQuery("SELECT count( distinct(cs.id)) from customers cs "
            + " join prepaid_contracts pc on (cs.id = pc.customer_id) join prepaid_services ps on (pc.prepaid_service_id = ps.id) "
            + "WHERE ((:name::VARCHAR IS NULL) OR (cs.name = :name)) "
            + "AND ((:fiscal_number::VARCHAR IS NULL) OR (cs.fiscal_number = :fiscal_number))"
            + "AND ((:status::VARCHAR IS NULL) OR (cs.status = :status))"
            + "AND ((:id::int = 0) OR (cs.id = :id))"
            + "AND ((:provisionedEquipment::varchar IS NULL) OR (ps.service_type iLIKE concat('%',:provisionedEquipment::varchar,'%')))"
            + "AND ((:tags::VARCHAR IS NULL) OR (cs.tags iLIKE concat('%',:tags::VARCHAR,'%')))"
            + "AND ((:tax_exemption_certificates::VARCHAR IS NULL) OR (cs.tax_exemption_certificates iLIKE concat('%',:tax_exemption_certificates::VARCHAR,'%')))"
            + "AND ((:begin_date::DATE IS NULL) OR (cs.db_cdate between :begin_date AND :end_date))"
            + "AND cs.enum_status_id != 2"
    )
    long getCustomersByEquipmentCount(
            @Bind("name") String name,
            @Bind("fiscal_number") String fiscal_number,
            @Bind("status") String status,
            @Bind("id") long id,
            @Bind("tags") String tags,
            @Bind("provisionedEquipment") String provisionedEquipment,
            @Bind("tax_exemption_certificates") String taxExemptionCertificates,
            @Bind("begin_date") Date begin_date,
            @Bind("end_date") Date end_date);

    //Confirm Contract
    @SqlUpdate("insert into prepaid_contract set status = :status")

    int confirmcontract(@Bind("status") String status);

    @SqlUpdate("update customers set enum_status_id  = 2 where id = :id")
    int deleteCustomer(@Bind("id") long id);

    @SqlQuery("SELECT product_code, product_description, tax_type_id FROM services WHERE id = :service_id")
    ArrayList<Map> findServicesByServicesId(@Bind("service_id") String service_id,
            @Bind("product_code") String product_code,
            @Bind("product_description") String product_description,
            @Bind("tax_type_id") String tax_type_id
    );

    @SqlQuery("SELECT product_code = :product_code, product_description = :product_description, tax_type_id = :tax_type_id, service_type = :service_type FROM services")
    ArrayList<Map> findAllServices(@Bind("service_id") String service_id,
            @Bind("product_code") String product_code,
            @Bind("product_description") String product_description,
            @Bind("tax_type_id") String tax_type_id);

    //Delete operations
    @SqlUpdate("UPDATE postpaid_contracts SET enum_status_id = 2 WHERE id = :contract_id")
    public void deletePostpaidContract(@Bind("contract_id") Long contract_id);

    @SqlUpdate("UPDATE prepaid_contracts SET enum_status_id = 2 WHERE id = :contract_id")
    public void deletePrepaidContract(@Bind("contract_id") Long contract_id);

    @SqlUpdate("UPDATE telo_operator_profit_config SET enum_status_id = 2 WHERE id = :id")
    public void deleteTeloOperatorProfitConfig(@Bind("id") String id);

    @SqlUpdate("UPDATE contract_template SET enum_status_id = 2 WHERE id = :contract_template_id")
    public void deleteContractTemplate(@Bind("contract_template_id") Long contract_template_id);

    @SqlUpdate("UPDATE payment SET enum_status_id = 2 WHERE id = :payment_id")
    public void deletePaymentById(@Bind("payment_id") Long payment_id
    );
    @SqlUpdate("UPDATE customer_addresses SET enum_status_id = 2 WHERE id = :id")
    public void deleteBillingAdress(@Bind("id") long id);

    @SqlUpdate("UPDATE alleged_payment SET enum_status_id = 2 WHERE id = :alledged_payment_Id")
    public void deleteAllegedPaymentById(@Bind("alledged_payment_Id") Long alledged_payment_Id);

    @SqlUpdate("UPDATE telo_agents SET enum_status_id = 2 WHERE id = :telo_agent_id")
    public void deleteTeloAgentById(@Bind("telo_agent_id") Long telo_agent_id);

    @SqlUpdate("UPDATE tax_types SET enum_status_id = 2 WHERE id = :tax_type_id")
    public void deleteTaxType(@Bind("tax_type_id") Long tax_type_id);

    //Fetch Operations
    //Update Operations
    //Delete service association by Id
    @SqlUpdate("update service_association set enum_status_id  = 2 where id = :id")
    void deleteServiceAssociation(@Bind("id") String id);

    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT telo_agent_profit_config.start_amount, telo_agent_profit_config.end_amount, telo_agent_profit_config.profit_percentage, telo_agents.telo_agent_id FROM telo_agent_profit_config INNER JOIN telo_agents ON telo_agent_profit_config.telo_agent_id = telo_agents.telo_agent_id"
            + "WHERE (:telo_agent_profit_config.telo_agent_id = :telo_agent_id ))"
            + "LIMIT :bucket_size OFFSET :offset"
    )
    List<Map> getTeloAgentProfitConfig(
            @Bind("telo_agent_id") String telo_agent_id,
            @Bind("start_amount") double start_amount,
            @Bind("end_amount") double end_amount,
            @Bind("profit_percentage") double profit_percentage,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size
    );

    @SqlUpdate("INSERT INTO telo_agent_profit_config (start_amount, end_amount, profit_percentage, telo_agent_id) VALUES " + "(:start_amount, :end_amount, :profit_percentage, :telo_agent_id)")
    void createTeloAgentProfitConfig(@Bind("start_amount") double start_amount,
            @Bind("end_amount") double end_amount,
            @Bind("profit_percentage") double profit_percentage,
            @Bind("telo_agent_id") String telo_agent_id
    );

    @SqlUpdate("UPDATE telo_agent_profit_config SET start_amount = :start_amount, end_amount = :end_amount, profit_percentage = :profit_percentage WHERE telo_agent_id = :telo_agent_id")
    public void updateTeloAgentProfitConfig(
            @Bind("start_amount") double start_amount,
            @Bind("end_amount") double end_amount,
            @Bind("profit_percentage") double profit_percentage
    );

    @SqlUpdate("UPDATE telo_agent_profit_config SET enum_status_id  = 2 WHERE telo_agent_id = :telo_agent_id")
    void deleteTeloAgentProfitConfig(@Bind("telo_agent_id") String telo_agent_id);

    ///============Service DAO===============
    ///***********SERVICES***************///
    ///**************************************///
    @SqlUpdate("UPDATE services SET product_code = :product_code, product_description = :product_description, tax_type_id = :tax_type_id WHERE service_id = :service_id")
    public void updateServices(@Bind("service_id") String service_id,
            @Bind("product_code") String product_code,
            @Bind("product_description") String product_description,
            @Bind("tax_type_id") String tax_type_id);

    @SqlUpdate("UPDATE services SET enum_status_id = 1 WHERE service_id = :service_id")
    public void deleteService(@Bind("service_id") String service_id);

    ///**************PREPAID SERVICES*************///
    ///******************************************///
    @SqlQuery("SELECT extenal_privison_id , status , name FROM prepaid_services WHERE enum_status_id != 2 ")
    ArrayList<Map> findAllPrepaidServices();

    @SqlQuery("SELECT extenal_privison_id, status, name, service_type_id  FROM prepaid_services WHERE prepaid_service_id = :prepaid_service_id AND enum_status_id != 2")
    ArrayList<Map> findPrepaidServiceById(@Bind("prepaid_service_id") String prepaid_service_id);

    @SqlUpdate("UPDATE prepaid_services SET external_provision_id = :external_provision_id, status = :status, name= :name, service_type_id = :service_type_id")
    public void updatePrepaidService(@Bind("external_provision_id") String external_provision_id,
            @Bind("status") Enum status,
            @Bind("name") String name,
            @Bind("service_type_id") String service_type_id
    );

    @SqlUpdate("UPDATE prepaid_services SET enum_status_id = 2 WHERE prepaid_service_id = :prepaid_service_id")
    public void deletePrepaidService(@Bind("prepaid_service_id") String prepaid_service_id);

    ///**************POSTPAID SERVICES*************///
    ///******************************************///
    @SqlQuery("SELECT unit_price, service_type_id, external_provision_id FROM postpaid_service WHERE enum_status_id != 2")
    ArrayList<Map> findAllPostPaidServices();

    @SqlQuery("SELECT unit_price, service_type_id, external_provision_id FROM postpaid_service FROM postpaid_service WHERE postpaid_service_id = :postpaid_service_id AND enum_status_id != 2")
    ArrayList<Map> findAllPostpaidServicesById(@Bind("postpaid_service_id") String postpaid_service_id);

    @SqlUpdate("UPDATE postpaid_services SET unit_price = :unit_price, service_type_id = :service_type_id, external_provision_id = :external_provision_id WHERE id = :id")
    public void updatePostpaidService(
            @Bind("unit_price") double unit_price,
            @Bind("service_type_id") String service_type_id,
            @Bind("external_provision_id") String external_provision_id,
            @Bind("id") int id
    );

    @SqlUpdate("UPDATE postpaid_services SET enum_status_id = 2 WHERE id = id ")
    public void deletePostpaidService(
            @Bind("id") String id);

    //=============End Service DA0===========//
    //================START INVOICE DAO============//
    //================END INVOICE DAO=============//    
    //==============CREDIT NOTE DAO===========//
    @SqlQuery("SELECT credit_note.customer_name, credit_note.customer_address, credit_note.customer_vat_number,credit_note.customer_telephobe_number, credit_note.supplier_name, credit_note.supplier_address, credit_note.supplier_vat_number, credit_note.credit_note_number ,credit_note.rules, credit_note.good_services, credit_note.customer_id, invoice.invoice_number FROM credit_note INNER JOIN invoice ON credit_note.credit_note_Id WHERE enum_status_id != 2")
    ArrayList<Map> findAllCreditNotes();

    @SqlQuery("SELECT credit_note.customer_name, credit_note.customer_address, credit_note.customer_vat_number, credit_note.supplier_name, credit_note.supplier_address, credit_note.supplier_vat_number, credit_note.rules, credit_note.good_services, credit_note.customer_id, invoice.invoice_number FROM credit_note INNER JOIN invoice ON credit_note.credit_note_Id WHERE credit_note_Id = :credit_note_Id AND enum_status_id != 2")
    ArrayList<Map> findAllCreditNotesById(@Bind("credit_note_id") String credit_note_Id);

    @SqlUpdate("UPDATE credit_note SET customer_name = :customer_name, custoemr_address = :customer_address, customer_vat_number = customer_vat_number, customer_telephone_number = :customer_telephone_number, supplier_name = :supplier_name, supplier_address = :supplier_address, supplier_vat_number = :supplier_vat_number, credit_note_number = :credit_note_number, rules = :rules, good_services, custommer_id = :customer_id WHERE customer_id = :customer_id")
    public void updateCreditNote(@Bind("customer_name") String customer_name,
            @Bind("customer_address") String customer_address,
            @Bind("customer_vat_number") String customer_vat_number,
            @Bind("customer_telephone_number") int customer_telephone_number,
            @Bind("supplier_name") String supplier_name,
            @Bind("supplier_address") String supplier_address,
            @Bind("supplier_vat_number") String supplier_vat_numbebr,
            @Bind("credit_note_number") String credit_note_number,
            @Bind("rules") String rules,
            @Bind("invoice_number") String invoice_number,
            @Bind("good_services") String good_services,
            @Bind("customer_id") String customer_id
    );

    @SqlUpdate("UPDATE credit_note SET enum_status_id = 2 WHERE invoice_number = :invoice_number ")
    public int deleteCreditNote(@Bind("invoice_number") String invoice_number);
    //=========CREDIT NOTE DAO ENDS===========//

    //=================CUSTOMER CONTACT DAO==============//
    @Mapper(ContactMapper.class)
    @SqlQuery("SELECT contact_type, contact_name, contact_email, contact_phone, customer_address_id, notify_by_sms, notify_by_email, send_invoice_by_email, id, contact_fax FROM customer_contacts WHERE enum_status_id != 2 AND customer_address_id = :customer_address_id ORDER BY id ASC")

    List<Map> findAllCustomerContact(
            @Bind("customer_address_id") long customer_address_id
    );

    @SqlQuery("SELECT COUNT(*) FROM customer_contacts  WHERE enum_status_id != 2 AND customer_address_id = :customer_address_id")
    long getContactCount(
            @Bind("customer_address_id") long customer_address_id
    );

    @SqlQuery("SELECT contact_type, contact_name, contact_email, contact_phone, contact_fax, notify_by_sms, notify_by_email, send_invoice_by_email, FROM customer_contacts WHERE customer_contact_id = :customer_contact_id AND enum_status_id != 2 ORDER BY id ASC")
    ArrayList<Map> findAllCustomerContactById(@Bind("customer_address_id") String customer_address_id);

    @SqlUpdate("UPDATE customer_contacts SET contact_type = :contact_type, contact_name = :contact_name, contact_email = :contact_email, contact_phone = :contact_phone, contact_fax = :contact_fax, notify_by_sms = :notify_by_sms, notify_by_email = :notify_by_email, send_invoice_by_email = :send_invoice_by_email WHERE customer_address_id = :customer_address_id AND id = :id")
    public long updateCustomerContact(@Bind("contact_type") String contact_type,
            @Bind("contact_name") String contact_name,
            @Bind("contact_email") String contact_email,
            @Bind("contact_phone") String contact_phone,
            @Bind("contact_fax") String contact_fax,
            @Bind("notify_by_sms") boolean notify_by_sms,
            @Bind("notify_by_email") boolean notify_by_email,
            @Bind("send_invoice_by_email") boolean send_invoice_by_email,
            @Bind("customer_address_id") long customer_address_id,
            @Bind("id") long id
    );

    @SqlUpdate("UPDATE customer_contacts SET enum_status_id = 2 WHERE id = :id")
    public void deleteCustomrContact(@Bind("id") long id);

    @Mapper(PrepaidContractMapper.class)
    @SqlQuery("SELECT id, prepaid_service_id, customer_id, status_date, start_date, content, service_type, status "
            + " FROM prepaid_contracts WHERE "
            + "((:customer_id IS NULL) OR (customer_id = :customer_id)) "
            + "AND enum_status_id != 2")
    //     + "LIMIT :bucket_size OFFSET :offset")
    List<ContractPrepaid> findPrepaidContractsByCustomerId(
            @Bind("customer_id") long customer_id);

    //=================CUSTOMER DAO ENDS================//
    /**
     * close with no args is used to close the connection
     */
    void close();

    public void createCustomer(Customer customer);
}
