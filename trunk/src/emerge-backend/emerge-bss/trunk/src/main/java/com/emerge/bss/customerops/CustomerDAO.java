/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.customerops;

import com.emerge.bss.crud.*;
import io.swagger.model.Customer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 *
 * @author akin
 */
public interface CustomerDAO {

    //Create Operations
    @GetGeneratedKeys
    @SqlUpdate("insert into contracts (status_date, second_contractor, start_date,end_date,preamble,clauses,expiration_conditions,first_contractor,goods_services) values "
            + "(:status_date :second_contractor :start_date :end_date :preamble :clauses :expiration_conditions :first_contractor :goods_services)")
    int createContract(@Bind("status_date") String status_date, @Bind("second_contractor") String second_contractor, @Bind("start_date") String start_date, @Bind("end_date") String end_date, @Bind("preamble") String preamble, @Bind("clauses") String clauses, @Bind("expiration_conditions") String expiration_conditions, @Bind("first_contractor") String first_contractor, @Bind("goods_services") String goods_services);

    @SqlUpdate("insert into prepaid_contracts (contract_id, service_id, allow_joint_billing, customer_id) values "
            + "(:contract_id :service_id :allow_joint_billing :customer_id)")
    void createPrepaidContract(@Bind("contract_id") int contract_id, @Bind("service_id") String service_id, @Bind("customer_id") String customer_id);

    @SqlUpdate("insert into postpaid_contracts (contract_id, allow_joint_billing, customer_id, billing_periodicity, billing_day, ) values "
            + "(:contract_id :allow_joint_billing :customer_id :billing_periodicity :billing_day)")
    void createPostpaidContract(@Bind("contract_id") int contract_id, @Bind("allow_joint_billing") boolean allow_joint_billing, @Bind("customer_id") String customer_id,
            @Bind("billing_periodicity") String billing_periodicity, @Bind("billing_day") int billing_day);

    @SqlUpdate("insert into prepaid_services (external_provision_id, status, name, service_type_id) values "
            + "(:external_provision_id :status :name :service_type_id)")
    void createPrepaidService(@Bind("external_provision_id") int external_provision_id, @Bind("status") int status, @Bind("name") int name, @Bind("service_type_id") int service_type_id);

    @SqlUpdate("insert into postpaid_services (external_provision_id, unit_price, service_type_id) values "
            + "(:external_provision_id, :unit_price, :service_type_id)")
    void createPostpaidService(@Bind("external_provision_id") String external_provision_id, @Bind("unit_price") float unit_price, @Bind("service_type_id") int service_type_id);

    @SqlUpdate("insert into customer (name, fiscal_number, tax_exemption,country,website,private_notes,public_notes,customer_id,status,tags) values "
            + "(:name, :fiscal_number, :tax_exemption, :country, :website, :private_notes, :public_notes,:customer_id,:status, :tags)")
    void createCustomer(
            @Bind("name") String name,
            @Bind("fiscal_number") String fiscal_number,
            @Bind("tax_exemption") String tax_exemption,
            @Bind("country") String country,
            @Bind("website") String website,
            @Bind("private_notes") String private_notes,
            @Bind("public_notes") String public_notes,
            @Bind("customer_id") int customer_id,
            @Bind("status") int status,
            @Bind("tags") String tags);

    @GetGeneratedKeys
    @SqlUpdate("insert into services (product_code,product_description, tax_type_id, service_type) values "
            + "(:product_code, :product_description, :tax_type_id, :service_type)")
    int createService(@Bind("product_code") String product_code, @Bind("product_description") String product_description, @Bind("tax_type_id") int tax_type_id, @Bind("service_type") int service_type);

    @GetGeneratedKeys
    @SqlUpdate("insert into customer_contact (contact_type,contact_name, contact_email, contact_phone,contact_fax) values "
            + "(:product_code, :product_description, :tax_type_id, :service_type)")

    int createCustomerContact(@Bind("contact_type") String contact_type, @Bind("contact_name") String contact_name, @Bind("contact_email") String contact_email, @Bind("contact_phone") String contact_phone, @Bind("contact_fax") String contact_fax);

    @SqlUpdate("INSERT INTO contract_template (creation_date, modification_date, second_contractor_name,second_contractor_fiscal_number,second_contractor_address,preamble,clauses,conditions_of_expiry,goods_and_services) values "
            + "(:creation_date, :modification_date, :second_contractor_name, :second_contractor_fiscal_number, :second_contractor_address,:preamble, :clauses, :conditions_of_expiry, :goods_and_services)")
    void createContractTemplate(@Bind("creation_date") Date creation_date, @Bind("modification_date") Date modification_date, @Bind("second_contractor_name") String second_contractor_name, @Bind("second_contractor_fiscal_number") String second_contractor_fiscal_number, @Bind("second_contractor_address") String second_contractor_address, @Bind("preamble") String preamble, @Bind("clauses") String clauses, @Bind("conditions_of_expiry") String conditions_of_expiry, String first_contractor, @Bind("goods_and_services") String service);

    @SqlUpdate("insert into credit_note (customer_name,customer_address, customer_vat_number, customer_telephone_number,supplier_name,supplier_address,supplier_vat_number,credit_note_number,rules, invoice_number, good_services, customer_id) values "
            + "(:customer_name,:customer_address, :customer_address, :customer_vat_number, :customer_telephone_number, :supplier_name,:supploer_address, :suppliervat_number, :credit_mote_number, :rules, invoice_number, good_services, customer_id)")
    void createCreditNotes(@Bind("customer_name") String customer_name, @Bind("customer_address") String customer_address, @Bind("customer_vat_number") String customer_vat_number, @Bind("customer_telephone_number") int customer_telephone_number, @Bind("supplier_name") String supplier_name, @Bind("supplier_address") String supplier_address, @Bind("supplier_vat_number") String supplier_vat_number, @Bind("credit_note_number") String credit_note_number, @Bind("rules") String rules, @Bind("invoice_number") String invoice_number, @Bind("good_services") String good_services, @Bind("customer_id") String customer_id);

    @SqlUpdate("insert into service_association (postpaid_service_id,contract_id, assoc_date, disassoc_date,status,start_date,end_date,unit_price,tax_percentage,tax_exemption,service_association_status) values "
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

    @SqlUpdate("INSERT INTO payment (customer_id, payment_date, reconciled, reconciled_method,invoice_id,provisioned_equipments,payment_reference_number,credit_before_payment,credit_after_payment,cost_of_payment_method,name_of_back_office_operator,revoked,notes,payment_method,payment_status,electronic_reference,treasury_accounts,paid_service) values "
            + "(:payment_date,:customer_id, :reconciled, :reconciled_method,:invoice_id,:provisioned_equipments,:payment_reference_number,:credit_before_payment,:credit_after_payment,:cost_of_payment_method,name_of_back_office_operator,revoked,notes,payment_method,payment_status,electronic_reference,treasury_accounts,paid_service)")
    void createPayment(
            @Bind("customer_id") int customer_id,
            @Bind("payment_date") Date payment_date,
            @Bind("reconciled") String reconciled,
            @Bind("reconciled_method") String reconciled_method,
            @Bind("invoice_id") int invoice_id,
            @Bind("provisioned_equipments") String provisioned_equipments,
            @Bind("payment_reference_number") String payment_reference_number,
            @Bind("credit_before_payment") String credit_before_payment,
            @Bind("credit_after_payment") String credit_after_payment,
            @Bind("cost_of_payment_method") String cost_of_payment_method,
            @Bind("name_of_back_office_operator") String name_of_back_office_operator,
            @Bind("revoked") String revoked,
            @Bind("notes") String notes,
            @Bind("payment_method") String payment_method,
            @Bind("payment_status") String payment_status,
            @Bind("electronic_reference") String electronic_reference,
            @Bind("treasury_accounts") String treasury_accounts,
            @Bind("paid_service") String paid_service);

    @SqlUpdate("insert into prepaid_contracts "
            + "(contract_mode, service_id, customer_id, status_date, second_contractor_name, second_contractor_fiscal_no, second_contractor_address, start_date, end_date,"
            + "preamble, clauses, expiration_conditions, first_contractor, goods_services) "
            + "values "
            + "(:contract_mode :service_id :customer_id :status_date "
            + ":second_contractor_name :second_contractor_fiscal_no :second_contractor_address :start_date :end_date :preamble :clauses "
            + ":expiration_conditions :first_contractor :goods_services)")

    void createPrepaidContract(
            @Bind("contract_mode") String contract_mode,
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

    @SqlUpdate("insert into postpaid_contracts (contract_mode, allow_joint_billing, customer_id, billing_periodicity, billing_day, "
            + "status_date, second_contractor_name, second_contractor_fiscal_no, second_contractor_address, start_date, end_date, preamble, clauses, "
            + "expiration_conditions, first_contractor, goods_services) "
            + "values "
            + "(:contract_mode :allow_joint_billing :customer_id :billing_periodicity :billing_day :status_date "
            + ":second_contractor_name :second_contractor_fiscal_no :second_contractor_address :start_date :end_date :preamble :clauses :expiration_conditions "
            + ":first_contractor :goods_services)")

    void createPostpaidContract(
            @Bind("contract_mode") String contract_mode,
            @Bind("allow_joint_billing") String allow_joint_billing,
            @Bind("customer_id") String customer_id,
            @Bind("billing_periodicity") String billing_periodicity,
            @Bind("billing_day") int billing_day,
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

    @SqlUpdate("insert into customer_address (address_name,address, fax_number, telephone_number,notify_by_sms,email,notify_by_email,send_invoice_by_email) values"
            + "(:address_name,  :address, :fax_number, :telephone_number, :notify_by_sms, :email, :notify_by_email,:send_invoice_by_email)")

    void createBillingAddress(
            @Bind("address_name") String address_name,
            @Bind("address") String address,
            @Bind("fax_number") String fax_number,
            @Bind("telephone_number") String telephone_number,
            @Bind("notify_by_sms") boolean notify_by_sms,
            @Bind("email") String email,
            @Bind("notify_by_email") boolean notify_by_email,
            @Bind("send_invoice_by_email") boolean send_invoice_by_email);

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

    @SqlUpdate("insert into supplement_prepaid"
            + "(referenced_contract_id, supplement_contract_id) values "
            + "(:referenced_contract_id :supplement_contract_id)")

    void createPrepaidContractSupplimentRecord(
            @Bind("referenced_contract_id") int referenced_contract_id,
            @Bind("supplement_contract_id") int supplement_contract_id
    );

    @GetGeneratedKeys
    @SqlUpdate("insert into postpaid_contracts "
            + "(contract_mode, contract_id, allow_joint_billing, customer_id, billing_periodicity, billing_day, status_date, "
            + "second_contractor_name, second_contractor_fiscal_number, second_contractor_address "
            + "start_date, end_date, preamble, clauses, expiration_conditions, first_contractor, goods_services) "
            + "values "
            + "(:contract_mode :contract_id :allow_joint_billing :customer_id :billing_periodicity :billing_day, :status_date "
            + ":second_contractor_name :second_contractor_fiscal_number :second_contractor_address :start_date :end_date :preamble :clauses "
            + ":expiration_conditions :first_contractor :goods_services)")

    int UpdatePostpaidContract(
            @Bind("contract_mode") String contract_mode,
            @Bind("contract_id") int contract_id,
            @Bind("allow_joint_billing") String allow_joint_billing,
            @Bind("customer_id") String customer_id,
            @Bind("billing_periodicity") String billing_periodicity,
            @Bind("billing_day") int billing_day,
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

    @SqlUpdate("insert into supplement_postpaid"
            + "(referenced_contract_id, supplement_contract_id) values "
            + "(:referenced_contract_id :supplement_contract_id)")

    void createPostpaidContractSupplimentRecord(
            @Bind("referenced_contract_id") int referenced_contract_id,
            @Bind("supplement_contract_id") int supplement_contract_id
    );

    @SqlUpdate("UPDATE alleged_payment set payment_method = :payment_method, services_to_provision = :services_to_provision")
    void updateAllegedPayment(
            @Bind("payment_method") String payment_method,
            @Bind("services_to_provision") String services_to_provision);

    //********Contract Template********************************
    @SqlUpdate("UPDATE contract_template SET "
            + "contract_template_id = :contract_template_id, "
            + "second_contractor_name = :second_contractor_name, second_contractor_fiscal_number = :second_contractor_fiscal_number, second_contractor_address = :second_contractor_address, "
            + "preamble = :preamble, "
            + "clauses = :clauses, expiration_conditions = :expiration_conditions, service = :service, creation_date = :creation_date, modification_date = :modification_date")

    public void UpdateContractTemplate(
            @Bind("contract_template_id") String contract_template_id,
            @Bind("second_contractor_name") String second_contractor_name,
            @Bind("second_contractor_fiscal_number") String second_contractor_fiscal_number,
            @Bind("second_contractor_address") String second_contractor_address,
            @Bind("preamble") String preamble,
            @Bind("clauses") String clauses,
            @Bind("expiration_conditions") String expiration_conditions,
            @Bind("creation_date") String creation_date,
            @Bind("modification_date") String modification_date
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
            + "payment_id = :payment_id, "
            + "payment_date = :payment_date, customer_id = :customer_id, reconcilled = :reconciled, "
            + "reconcilled_method = :reconcilled_method, "
            + "invoice_id = :invoice_id, provisioned_equipments = :provisioned_equipments, payment_reference_number = :payment_reference_number, "
            + "credit_before_payment = :credit_before_payment, credit_after_payment =  :credit_after_payment, cost_of_payment_method =  :cost_of_payment_method, "
            + "name_of_back_office_operator = :name_of_back_office_operator, revoked = :revoked, notes = :notes, payment_method = :payment_method, payment_status = :payment_status, "
            + "electronic_reference = :electronic_reference, treasury_accounts = :treasury_accounts, paid_service = :paid_service WHERE payment_id = :payment_id")

    public void UpdatePayment(
            @Bind("payment_id") String payment_id,
            @Bind("payment_date") Date payment_date,
            @Bind("customer_id") int customer_id,
            @Bind("reconciled") String reconciled,
            @Bind("reconciled_method") String reconciled_method,
            @Bind("invoice_id") int invoice_id,
            @Bind("provisioned_equipments") String provisioned_equipments,
            @Bind("payment_reference_number") String payment_reference_number,
            @Bind("credit_before_payment") String credit_before_payment,
            @Bind("credit_after_payment") String credit_after_payment,
            @Bind("cost_of_payment_method") String cost_of_payment_method,
            @Bind("name_of_back_office_operator") String name_of_back_office_operator,
            @Bind("revoked") String revoked,
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

    @SqlUpdate("update customer set name = :name, fiscal_number = :fiscal_number,tax_exemption = :tax_exemption,country = :country,website = :website,private_notes = :private_notes,public_notes = :public_notes, tags = :tags where id = :id")
    int updateCustomer(
            @Bind("name") String name,
            @Bind("fiscal_number") String fiscal_number,
            @Bind("tax_exemption") String tax_exemption,
            @Bind("country") String country,
            @Bind("website") String website,
            @Bind("private_notes") String private_notes,
            @Bind("public_notes") String public_notes,
            @Bind("tags") String tags,
            @Bind("id") int id);

    @SqlUpdate("UPDATE customer_address SET address_name = :address_name,address = :address, fax_number = :fax_number, telephone_number = :telephone_number, notify_by_sms = :notify_by_sms,email =  :email,notify_by_email = :notify_by_email, send_invoice_by_email = :send_invoice_by_email where id = :id")

    void updateBillingAddress(
            @Bind("address_name") String address_name,
            @Bind("address") String address,
            @Bind("fax_number") String fax_number,
            @Bind("telephone_number") String telephone_number,
            @Bind("notify_by_sms") String notify_by_sms,
            @Bind("email") String email,
            @Bind("notify_by_email") String notify_by_email,
            @Bind("id") int id,
            @Bind("send_invoice_by_email") String send_invoice_by_email);

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
    @SqlQuery("select payment_method, services_to_provision from alleged_payment where payment_id = :payment_id")
    ArrayList<Map> findAllegedPayment(@Bind("payment_id") String payment_id);

    @SqlQuery("select contract_id, service_id, customer_id, status_date, second_contractor, start_date,end_date,preamble,clauses,expiration_conditions,first_contractor,goods_services from prepaid_contracts ")
    ArrayList<Map> findAllPrepaidContracts();

    @SqlQuery("select billing_periodicity, billing_day, customer_id, allow_joint_billing, contract_id, status_date, second_contractor, start_date,end_date,preamble,clauses,expiration_conditions,first_contractor,goods_services from postpaid_contracts")
    ArrayList<Map> findAllPostpaidContracts();

    @SqlQuery("select contract_id, service_id, customer_id, status_date, second_contractor, start_date,end_date,preamble,clauses,expiration_conditions,first_contractor,goods_services from prepaid_contracts where customer_id = :customer_id")
    ArrayList<Map> findPrepaidContractsByCustomerId(@Bind("customer_id") String customer_id);

    @SqlQuery("select billing_periodicity, billing_day, customer_id, allow_joint_billing, contract_id from postpaid_contracts where customer_id = :customer_id")
    ArrayList<Map> findPostpaidContractsByCustomerId(@Bind("customer_id") String customer_id);

    @SqlQuery("select contract_type, contract_template_id, second_contractor_name, second_contractor_fiscal_number, second_contractor_address, preamble, clauses, expiration_conditions, service from contract_template where contract_template_id = :contract_template_id")
    ArrayList<Map> findContractTemplate(@Bind("contract_template_id") String contract_template_id);

    @SqlQuery("select payment_id, payment_date, customer_id, reconciled, reconciled_method, invoice_id, provisioned_equipments,payment_reference_number,"
            + "credit_before_payment,credit_after_payment,cost_of_payment_method,name_of_back_office_operator,revoked,notes,payment_method,payment_status,"
            + "electronic_reference,treasury_accounts,paid_service where payment_id = :payment_id")
    ArrayList<Map> findPaymentById(@Bind("payment_id") String payment_id);

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

    //Fetch service association from database based on search parameters and pagination values
    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT postpaid_service_id, contract_id, assoc_date, disassoc_date, status, start_date, "
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
    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT address_name,address, fax_number, telephone_number,notify_by_sms,email,notify_by_email,send_invoice_by_email from customer_address"
            + "WHERE ((:telephone_number IS NULL) OR (telephone_number = :telephone_number)) "
            + "AND ((:email IS NULL) OR (email = :email))"
            + "AND ((:begin_date IS NULL) OR (db_cdate between :begin_date AND :end_date))"
            + "LIMIT :bucket_size OFFSET :offset"
    )
    List<Map> findBillingAddress(
            @Bind("telephone_number") String telephone_number,
            @Bind("email") String email,
            @Bind("begin_date") Date begin_date,
            @Bind("end_date") Date end_date,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size);

    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT start_amount,end_amount, profit_percentage from telo_operator_profit_config  WHERE id = :id")
    List<Map> findTeloOperatorProfitConfig(
            @Bind("id") int id
    );

    //Fetch customers from database based on search parameters and pagination values
    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT name, fiscal_number, tax_exemption,country,website,private_notes,public_notes,tags from customer "
            + "WHERE ((CAST(:name AS VARCHAR) IS NULL) OR (name = :name)) "
            + "AND ((CAST(:fiscal_number AS VARCHAR) IS NULL) OR (fiscal_number = :fiscal_number))"
            + "AND ((CAST(:status AS VARCHAR) IS NULL) OR (status = :status))"
            + "AND ((CAST(:begin_date AS DATE) IS NULL) OR (db_cdate between :begin_date AND :end_date))"
            + "LIMIT :bucket_size OFFSET :offset"
    )
    List<Map> getCustomers(
            @Bind("name") String name,
            @Bind("fiscal_number") String fiscal_number,
//            @Bind("email") String email,
            @Bind("status") String status,
            @Bind("begin_date") Date begin_date,
            @Bind("end_date") Date end_date,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size);

    //Confirm Contract
    @SqlUpdate("insert into prepaid_contract set status = :status")

    int confirmcontract(@Bind("status") String status);

    @SqlUpdate("update customer set enum_status_id  = 2 where id = :id")
    int deleteCustomer(@Bind("id") int id);

    ///============Service DAO===============
    ///***********SERVICES***************///
    ///**************************************///
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
    public void deletePostpaidContract(@Bind("contract_id") String contract_id);

    @SqlUpdate("UPDATE telo_operator_profit_config SET enum_status_id = 2 WHERE id = :id")
    public void deleteTeloOperatorProfitConfig(@Bind("id") String id);

    @SqlUpdate("UPDATE prepaid_contracts SET enum_status_id = 1 WHERE id = :contract_id")
    public void deletePrepaidContract(@Bind("contract_id") String contract_id);

    @SqlUpdate("UPDATE contract_template SET enum_status_id = 1 WHERE id = :contract_template_id")
    public void deleteContractTemplate(@Bind("contract_template_id") String contract_id);

    @SqlUpdate("UPDATE payments SET enum_status_id = 1 WHERE payment_id = :payment_id")
    public void deletePaymentById(@Bind("payment_id") String payment_id);

    @SqlUpdate("UPDATE customer_address SET enum_status_id = 1 WHERE id = :id")
    public void deleteBillingAdress(@Bind("id") int id);

    @SqlUpdate("UPDATE alleged_payment SET enum_status_id = 1 WHERE id = :id")
    public void deleteAllegedPaymentById(@Bind("id") String allegedPayment_id);

    //Delete invoice
    @SqlUpdate("update invoice set enum_status_id  = 2 where invoice_number = :invoice_number")
    void deleteInvoiceByNumber(@Bind("invoice_number") String invoice_number);

    //Fetch Operations
    // Delete Operations
    //Update Operations
    @SqlUpdate("UPDATE prepaid_contracts INNER JOIN contracts ON prepaid_contracts.contracts_id = contracts.id SET prepaid_contracts.contract_id = :contract_id, "
            + "prepaid_contracts.service_id = :service_id, "
            + "prepaid_contracts.customer_id = :customer_id, contracts.status_date = :status_date, "
            + "contracts.second_contractor_name = :second_contractor_name, contracts.second_contractor_fiscal_number = :second_contractor_fiscal_number, "
            + "contracts.second_contractor_address = :second_contractor_address, contracts.start_date = :start_date, contracts.end_date = :end_date, contracts.preamble = :preamble, "
            + "contracts.clauses = :clauses, contracts.expiration_conditions = :expiration_conditions, contracts.first_contractor = :first_contractor, "
            + "contracts.goods_services = :goods_services WHERE contracts.id = :prepaid_contracts.contract_id")
    public void UpdatePrepaidContract(@Bind("contract_id") String contract_id,
            @Bind("service_id") String service_id,
            @Bind("customer_id") String customer_id,
            @Bind("status_date") String status_date,
            @Bind("second_contractor_name") String second_contractor_name,
            @Bind("second_contractor_fiscal_number") String second_contractor_fiscal_number,
            @Bind("second_contractor_address") String second_contractor_address,
            @Bind("start_date") String start_date,
            @Bind("end_date") String end_date,
            @Bind("preamble") String preamble,
            @Bind("clauses") String clauses,
            @Bind("expiration_condition") String expiration_condition,
            @Bind("first_contractor") String first_contractor,
            @Bind("goods_services") String goods_services
    );

    @SqlUpdate("UPDATE postpaid_contracts INNER JOIN contracts ON postpaid_contracts.contracts_id = contracts.id SET postpaid_contracts.contract_id = :contract_id, "
            + "postpaid_contracts.billing_periodicity = :billing_periodicity, "
            + "postpaid_contracts.billing_day = :billing_day, postpaid_contracts.allow_joint_billing = :allow_joint_billing, postpaid_contracts.customer_id = :customer_id, "
            + "contracts.status_date = :status_date, "
            + "contracts.second_contractor_name = :second_contractor_name, contracts.second_contractor_fiscal_number = :second_contractor_fiscal_number,"
            + "contracts.second_contractor_address = :second_contractor_address, contracts.start_date = :start_date, contracts.end_date = :end_date, contracts.preamble = :preamble, "
            + "contracts.clauses = :clauses, contracts.expiration_conditions = :expiration_conditions, contracts.first_contractor = :first_contractor, "
            + "contracts.goods_services = :goods_services WHERE contracts.id = :prepaid_contracts.contract_id")
    public void UpdatePostpaidContract(@Bind("contract_id") String contract_id,
            @Bind("billing_periodicity") String billing_periodicity,
            @Bind("allow_joint_billing") String allow_joint_billing,
            @Bind("customer_id") String customer_id,
            @Bind("billing_day") String billing_day,
            @Bind("status_date") String status_date,
            @Bind("second_contractor_name") String second_contractor_name,
            @Bind("second_contractor_fiscal_number") String second_contractor_fiscal_number,
            @Bind("second_contractor_address") String second_contractor_address,
            @Bind("start_date") Date start_date,
            @Bind("end_date") Date end_date,
            @Bind("preamble") String preamble,
            @Bind("clauses") String clauses,
            @Bind("expiration_condition") String expiration_condition,
            @Bind("first_contractor") String first_contractor,
            @Bind("goods_services") String goods_services
    );

    //Fetch Operations
    //Update Operations
    //Delete service association by Id
    @SqlUpdate("update service_association set enum_status_id  = 2 where id = :id")
    void deleteServiceAssociation(@Bind("id") String id);

    
//    @SqlUpdate("INSERT INTO users (username,password) values (:username,:password)")
//        int insertPayphoneConfiguration(@Bind("username") String username, @Bind("password") String password);

    ///============Service DAO===============
    //=============End Service DA0===========
    /**
     * close with no args is used to close the connection
     */
    void close();

    public void createCustomer(Customer customer);
}
