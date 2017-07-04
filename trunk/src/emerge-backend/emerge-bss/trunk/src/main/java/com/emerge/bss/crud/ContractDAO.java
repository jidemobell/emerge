/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.crud;

import com.emerge.bss.crud.mappers.ContractTemplateMapper;
import com.emerge.bss.crud.mappers.PrepaidContractMapper;
import com.emerge.bss.crud.mappers.PrepaidServiceMapper;
import io.swagger.model.ServicePrepaid;
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
public interface ContractDAO {
    
    

    //Create Operations
    @GetGeneratedKeys
    @SqlUpdate("insert into contracts (status_date, second_contractor, start_date,end_date,preamble,clauses,expiration_conditions,first_contractor,goods_services) values "
            + "(:status_date :second_contractor :start_date :end_date :preamble :clauses :expiration_conditions :first_contractor :goods_services)")
    int createContract(@Bind("status_date") String status_date, @Bind("second_contractor") String second_contractor, @Bind("start_date") String start_date, @Bind("end_date") String end_date, @Bind("preamble") String preamble, @Bind("clauses") String clauses, @Bind("expiration_conditions") String expiration_conditions, @Bind("first_contractor") String first_contractor, @Bind("goods_services") String goods_services);
    
    @GetGeneratedKeys
    @SqlUpdate("insert into prepaid_services (external_provision_id, name, service_type, product_id) values "
            + "(:external_provision_id, :name, :service_type, :product_id)")

    long createPrepaidService(
            
            @Bind("external_provision_id") String external_provision_id, 
            @Bind("name") String name, 
            @Bind("service_type") String service_type, 
            @Bind("product_id") long product_id);
    
    

    @SqlUpdate("insert into postpaid_products (external_provision_id, unit_price) values "
            + "(:external_provision_id, :unit_price)")
    void createPostpaidService(@Bind("external_provision_id") String external_provision_id, 
                               @Bind("unit_price") float unit_price
                                                                   );

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
            + "(:contact_type, :contact_name, :contact_email, :contact_phone, :contact_fax)")
    int createCustomerContact(@Bind("contact_type") String contact_type, @Bind("contact_name") String contact_name, @Bind("contact_email") String contact_email, @Bind("contact_phone") String contact_phone, @Bind("contact_fax") String contact_fax);

    @GetGeneratedKeys 
    @SqlUpdate("INSERT INTO contract_templates(name, description, contract_type, content, created_by, db_cdate, db_mdate) values "
            + "(:name, :description, :contract_type, :content, :created_by, :creation_date, :modification_date)")
            
    long createContractTemplate(
            @Bind("name") String name, 
            @Bind("description") String description, 
            @Bind("contract_type") String contract_type, 
            @Bind("content") String content, 
            @Bind("created_by") String created_by,
            @Bind("creation_date") Date creation_date,
            @Bind("modification_date") Date modification_date);

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

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO payment (payment_id, payment_date, customer_id, reconciled, reconciled_method,invoicenumber,provisioned_equipments,payment_reference_number,credit_before_payment,credit_after_payment,cost_of_payment_method,name_of_back_office_operator,revoked,bank_name,value,notes,payment_method,payment_status,electronic_reference,treasury_accounts,paid_service) values "
            + "(:payment_id,:payment_date,:customer_id, :reconciled, :reconciled_method,:invoicenumber,:provisioned_equipments,:payment_reference_number,:credit_before_payment,:credit_after_payment,:cost_of_payment_method,:name_of_back_office_operator,:revoked,:bank_name,:value,:notes,:payment_method,:payment_status,:electronic_reference,:treasury_accounts,:paid_service)")
    long createPayment(
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

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO prepaid_contracts "
            + "(mode, prepaid_service_id, customer_id, status_date, start_date, "
            + "content, automatic_renewal, service_type) "
            + "values "
            + "(:mode, :prepaid_service_id, :customer_id, :status_date, "
            + ":start_date, "
            + ":content, :automatic_renewal, :service_type)")

    long createPrepaidContract(
            @Bind("mode") String mode,
            @Bind("prepaid_service_id") long prepaid_service_id,
            @Bind("customer_id") long customer_id,
            @Bind("status_date") Date status_date,
            @Bind("start_date") Date start_date,
            @Bind("content") String content,
            @Bind("automatic_renewal") boolean automatic_renewal,
            @Bind("service_type") String service_type);
    
     @SqlUpdate ("UPDATE prepaid_services SET status = 'ACTIVE' WHERE id = :prepaid_service_id")
     void updateServiceStatus(
     @Bind("prepaid_service_id") long prepaid_service_id);
     
     @SqlUpdate ("UPDATE prepaid_services SET status = 'READY' WHERE id = :prepaid_service_id")
     void removeService(
     @Bind("prepaid_service_id") long prepaid_service_id);
     
     
     @SqlQuery ("SELECT EXISTS(SELECT 1 FROM prepaid_contracts WHERE prepaid_service_id = :serviceId)")
     boolean checkIfServiceExists(
            @Bind("serviceId")long serviceId);
     
     @SqlQuery ("SELECT EXISTS(SELECT 1 FROM prepaid_services WHERE id = :serviceId AND status = 'ACTIVE')")
     boolean confirmAssociation(
            @Bind("serviceId")long serviceId);
     
    @SqlQuery("SELECT customer_id FROM prepaid_contracts WHERE prepaid_service_id = :serviceId") 
    long findCustomerId(
            @Bind("serviceId")long serviceId);
    
    @SqlQuery ("SELECT EXISTS(SELECT 1 FROM prepaid_contracts WHERE customer_id = :customer_id AND service_type = :teloagent AND (status = 'ACTIVE' OR status = 'NEW'))")
            
    boolean confirmIfTeloAgentContractExists(
    @Bind("customer_id") long customer_id,
    @Bind("teloagent") String teloagent);
    
    @GetGeneratedKeys
   @SqlUpdate("INSERT INTO telo_agents (prepaid_service_id, "
            + " balance) "
            + "values (:prepaid_service_id, :balance)")
            
    long createTeloAgent(
            @Bind("prepaid_service_id") long prepaid_service_id,
            @Bind("balance") double balance);

    @GetGeneratedKeys
    @SqlUpdate("insert into postpaid_contracts (mode, allow_joint_billing, customer_id, billing_periodicity, billing_day, "
            + "status_date, second_contractor_name, second_contractor_fiscal_no, second_contractor_address, start_date, end_date, preamble, clauses, "
            + "expiration_conditions, first_contractor, goods_services) "
            + "values "
            + "(:mode, :allow_joint_billing, :customer_id, :billing_periodicity, :billing_day, :status_date, "
            + ":second_contractor_name, :second_contractor_fiscal_no, :second_contractor_address, :start_date, :end_date, :preamble, :clauses, :expiration_conditions, "
            + ":first_contractor, :goods_services)")

    long createPostpaidContract(
            @Bind("mode") String mode,
            @Bind("allow_joint_billing") boolean allow_joint_billing,
            @Bind("customer_id") long customer_id,
            @Bind("billing_periodicity") String billing_periodicity,
            @Bind("billing_day") Date billing_day,
            @Bind("status_date") Date status_date,
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
    @SqlUpdate("INSERT INTO telo_operators (payphone_service_id, is_legacy,prepaid_service_id) values"
            + "(:payphone_service_id, :is_legacy, :prepaid_service_id)")
    long createTeloOperator(
            @Bind("payphone_service_id") String payphone_service_id,
            @Bind("is_legacy") boolean is_legacy,
            @Bind("prepaid_service_id") long prepaid_service_id
            );

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO alleged_payment (payment_method, services_to_provision) values "
            + "(:payment_method, :services_to_provision)")

    int createAllegedPayment(@Bind("payment_method") String payment_method, @Bind("services_to_provision") String services_to_provision, @Bind("alleged_payment_id") String alleged_payment_id);

    @SqlUpdate ("INSERT INTO products (product_code, product_description, product_name, tax_type_id, product_type) VALUES "
            + "(:product_code, :product_description, :product_name, :tax_type_id, :product_type)")
    long createProduct(
           @Bind("product_code") String product_code, 
           @Bind("product_description") String product_description, 
           @Bind("product_name") String product_name, 
           @Bind("tax_type_id") long tax_type_id,
           @Bind("product_type") String product_type);
    
    
    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO prepaid_contracts "
            + "(mode, prepaid_service_id, customer_id, status_date, start_date, "
            + "status, content, automatic_renewal, service_type) "
            + "values "
            + "(:mode, :prepaid_service_id, :customer_id, :status_date, "
            + ":start_date, "
            + ":status, :content, :automatic_renewal, :service_type)")

    int UpdatePrepaidContract(
           @Bind("mode") String mode,
            @Bind("prepaid_service_id") long prepaid_service_id,
            @Bind("customer_id") long customer_id,
            @Bind("status_date") Date status_date,
            @Bind("start_date") Date start_date,
            @Bind("status") String status,
            @Bind("content") String content,
            @Bind("automatic_renewal") boolean automatic_renewal,
            @Bind("service_type") String service_type);

    @SqlUpdate("insert into prepaid_contract_supplements"
            + "(referenced_contract_id, supplement_contract_id) values "
            + "(:referenced_contract_id, :supplement_contract_id)")

    void createPrepaidContractSupplimentRecord(
            @Bind("referenced_contract_id") long referenced_contract_id,
            @Bind("supplement_contract_id") long supplement_contract_id
    );

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO postpaid_contracts "
            + "(mode, allow_joint_billing, customer_id, billing_periodicity, billing_day, status_date, "
            + "second_contractor_name, second_contractor_fiscal_no, second_contractor_address, "
            + "start_date, end_date, preamble, clauses, expiration_conditions, first_contractor, goods_services) "
            + "values "
            + "(:mode, :allow_joint_billing, :customer_id, :billing_periodicity, :billing_day, :status_date, "
            + ":second_contractor_name, :second_contractor_fiscal_no, :second_contractor_address, :start_date, :end_date, :preamble, :clauses, "
            + ":expiration_conditions, :first_contractor, :goods_services)")

    int UpdatePostpaidContract(
            @Bind("mode") String mode,
            @Bind("allow_joint_billing") boolean allow_joint_billing,
            @Bind("customer_id") long customer_id,
            @Bind("billing_periodicity") String billing_periodicity,
            @Bind("billing_day") Date billing_day,
            @Bind("status_date") Date status_date,
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

    @SqlUpdate("INSERT INTO postpaid_contract_supplements"
            + "(referenced_contract_id, supplement_contract_id) values "
            + "(:referenced_contract_id, :supplement_contract_id)")

    void createPostpaidContractSupplimentRecord(
            @Bind("referenced_contract_id") long referenced_contract_id,
            @Bind("supplement_contract_id") long supplement_contract_id
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
    
    @SqlUpdate("UPDATE products SET product_code = :product_code, "
            + "product_description = :product_description, "
            + "product_name = :product_name, product_type =:product_type,"
            + " tax_type_id = :tax_type_id WHERE id = :product_id")
    
    public long UpdateProduct(
            @Bind("product_id")long product_id, 
            @Bind("product_code") String product_code, 
            @Bind("product_description") String product_description, 
            @Bind("product_name") String product_name, 
            @Bind("product_type") String product_type,
            @Bind("tax_type_id") long tax_type_id);    
    
    //********Contract Template********************************
   @GetGeneratedKeys
    @SqlUpdate("UPDATE contract_templates SET "
            + "name = :name, description = :description, contract_type = :contract_type, content = :content, created_by = :created_by, "
            + "db_mdate = :modification_date "
            + "WHERE id = :id")

    public long UpdateContractTemplate(
            @Bind("id") long id,
            @Bind("name") String name, 
            @Bind("description") String description, 
            @Bind("contract_type") String contract_type, 
            @Bind("content") String content, 
            @Bind("created_by") String created_by,
            @Bind("modification_date") Date modification_date);


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
    
    @Mapper(PrepaidContractMapper.class)
    @SqlQuery("SELECT id, prepaid_service_id, customer_id, status_date, start_date, content, service_type, status, 'prepaid' as contract_type " //,'prepaid' as contract_type
            + " FROM prepaid_contracts WHERE "
            + "((:customer_id::int=0 IS NULL) OR (customer_id = :customer_id)) "
            + "AND ((:service_type::VARCHAR IS NULL) OR (service_type = :service_type)) "
            + "AND ((:status::VARCHAR IS NULL) OR (status = :status)) "
            + "AND ((:creation_date::DATE IS NULL) OR (db_cdate = :creation_date)) "
      //      + "AND ((:contract_type::VARCHAR IS NULL) OR (contract_type = :contract_type)) "
            + "AND enum_status_id != 2 "
           + "LIMIT :bucket_size OFFSET :offset")
           
   List<Map> findPrepaidContractsByCustomerId(
            @Bind("customer_id") long customer_id,
            @Bind("service_type") String service_type,
            @Bind("status") String status,
            @Bind("creation_date") Date creation_date,
           // @Bind("contract_type") String contract_type,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size);
   
   @SqlQuery("SELECT count(*) from prepaid_contracts "
            + "WHERE "
            + "((:customer_id::int=0 IS NULL) OR (customer_id = :customer_id)) "
            + "AND ((:service_type::VARCHAR IS NULL) OR (service_type = :service_type)) "
            + "AND ((:status::VARCHAR IS NULL) OR (status = :status)) "
            + "AND ((:creation_date::VARCHAR IS NULL) OR (app_cdate = :creation_date)) "
            + "AND enum_status_id != 2 "
          
           
    )
    long getPrepaidContractsCount(
            @Bind("customer_id") long customer_id,
            @Bind("service_type") String service_type,
            @Bind("status") String status,
            @Bind("creation_date") Date creation_date);
    
    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT id, prepaid_service_id, customer_id, status_date, start_date, content, service_type, status FROM prepaid_contracts  WHERE "
            + "(:id IS NULL OR id = :id)"
            + "AND (:customer_id IS NULL OR customer_id = :customer_id)" )
   List<Map> findPrepaidContractsByContractsId(
            @Bind("id") long id,
            @Bind("customer_id") long customer_id);
   
    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT billing_periodicity, billing_day, customer_id, allow_joint_billing, id, status_date, "
            + "second_contractor_name, second_contractor_address, second_contractor_fiscal_no, start_date, "
            + "end_date,preamble,clauses,expiration_conditions, first_contractor,goods_services from postpaid_contracts WHERE "
            + "(:id IS NOT NULL AND id = :id)")
    List<Map> findPostpaidContractsByContractsId(
            @Bind("id") long id,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size);
            
             
    @Mapper(ContractTemplateMapper.class)
    @SqlQuery("SELECT id, name, description, contract_type, content, created_by, db_cdate, db_mdate FROM contract_templates "
            + "WHERE ((:contract_template_id::int = 0) OR (id = :contract_template_id)) "
            + "AND ((:description::VARCHAR IS NULL) OR (description iLIKE concat('%',:description::VARCHAR,'%'))) "
            + "AND ((:content::VARCHAR IS NULL) OR (content iLIKE concat ('%',:content::VARCHAR,'%'))) "
            + "AND ((:created_by::VARCHAR IS NULL) OR (created_by = :created_by)) " //(tags iLIKE concat('%',:tags::varchar,'%')))"
            + " LIMIT :bucket_size OFFSET :offset")
            
    List<Map> findContractTemplate(
            @Bind("contract_template_id") long contract_template_id,  
            @Bind("description") String description,
            @Bind("created_by") String created_by,
            @Bind("content") String content,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size);
    
    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT id, name, description, contract_type, content, created_by, db_cdate, db_mdate FROM contract_templates  WHERE id = :id")
   List<Map> findContractTemplateById(
            @Bind("id") long id);
    
    
    @Mapper(EntityMapper.class)
    @SqlQuery("SELECT id, product_name, product_description, product_type, product_code, tax_type_id FROM products WHERE "
            + "((:product_id IS NULL) OR id = :product_id)"
            + " LIMIT :bucket_size OFFSET :offset")
    List<Map> findProduct(
            @Bind("product_id") long productId, 
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
    @SqlUpdate("UPDATE prepaid_contracts SET status = :status, status_date = :date WHERE id = :id AND customer_id = :customer_id")

    int confirmcontract(
            @Bind("status") String status,
            @Bind("id") long id,
            @Bind("customer_id") long customer_id,
            @Bind("date") Date date);
    
     @SqlUpdate("UPDATE prepaid_contracts SET status = :status, status_date = :date, end_date = :date, enum_status_id = 2 WHERE id = :id AND customer_id = :customer_id")

    int cancelcontract(
            @Bind("status") String status,
            @Bind("id") long id,
            @Bind("customer_id") long customer_id,
            @Bind("date") Date date);
            

    @SqlUpdate("update customer set enum_status_id  = 2 where id = :id")
    int deleteCustomer(@Bind("id") int id);

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
    @SqlUpdate("UPDATE postpaid_contracts SET enum_status_id = 2 WHERE id = :contract_id AND customer_id = :customer_id")
    public void deletePostpaidContract(@Bind("contract_id") long contract_id,
            @Bind("customer_id") long customer_id
                    );

    @SqlUpdate("UPDATE prepaid_contracts SET enum_status_id = 2 WHERE id = :contract_id AND customer_id = :customer_id")
    public void deletePrepaidContract(@Bind("contract_id") long contract_id,
             @Bind("customer_id") long customer_id
                    );

    @SqlUpdate("UPDATE telo_operator_profit_config SET enum_status_id = 2 WHERE id = :id")
    public void deleteTeloOperatorProfitConfig(@Bind("id") String id);

    @SqlUpdate("UPDATE contract_templates SET enum_status_id = 2 WHERE id = :contract_template_id")
    public void deleteContractTemplate(@Bind("contract_template_id") Long contract_template_id);

    @SqlUpdate("UPDATE payment SET enum_status_id = 2 WHERE id = :payment_id")
    public void deletePaymentById(@Bind("payment_id") Long payment_id
    );
    @SqlUpdate("UPDATE products SET enum_status_id = 2 WHERE id = :product_id")
    public void deleteProduct(@Bind("product_id")long product_id);

    @SqlUpdate("UPDATE customer_address SET enum_status_id = 1 WHERE id = :id")
    public void deleteBillingAdress(@Bind("id") int id);

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
    
    @SqlUpdate("UPDATE services SET enum_status_id = 2 WHERE service_id = :service_id")
            public void deleteService(@Bind("service_id") String service_id);
            
    ///**************PREPAID SERVICES*************///
    ///******************************************///
            
    @Mapper(PrepaidServiceMapper.class)
    @SqlQuery("SELECT id, external_provision_id , status, name, product_id, deleted_reason, service_type, "
            + "(SELECT is_legacy FROM telo_operators WHERE prepaid_service_id = prepaid_services.id) "
            + "FROM prepaid_services "
            + "WHERE enum_status_id != 2 "
            + "AND ((:service_type::VARCHAR IS NULL) OR (service_type = :service_type)) "
            + "AND ((:external_provision_id::VARCHAR IS NULL) OR (external_provision_id iLIKE concat('%',:external_provision_id::VARCHAR,'%'))) " //(name iLIKE concat('%',:name::varchar,'%')))"
            + "AND ((:status::VARCHAR IS NULL) OR (status = :status)) "
            + "AND ((:creation_date::DATE IS NULL) OR (db_cdate = :creation_date)) "
            + "AND ((:modification_date::DATE IS NULL) OR (db_mdate = :modification_date)) "
            + "LIMIT :bucket_size OFFSET :offset")
            
    List<PrepaidServiceMapper> findAllPrepaidServices(
            @Bind("service_type") String service_type,
            @Bind("status") String status,
            @Bind("external_provision_id") String external_provision_id,
            @Bind ("creation_date") Date creation_date,
            @Bind("modification_date") Date modification_date,
            @Bind("offset") long offset,
            @Bind("bucket_size") long bucket_size
            );
    
    
    //Fetch prepaid_services count from database based on search parameters no limits
    @SqlQuery("SELECT count(*) from prepaid_services "
            + "WHERE enum_status_id != 2 "
            + "AND ((:service_type::VARCHAR IS NULL) OR (service_type = :service_type)) "
            + "AND ((:external_provision_id::VARCHAR IS NULL) OR (external_provision_id iLIKE concat('%',:external_provision_id::VARCHAR,'%'))) "
            + "AND ((:status::VARCHAR IS NULL) OR (status = :status)) "
            + "AND ((:creation_date::DATE IS NULL) OR (db_cdate = :creation_date)) "
            + "AND ((:modification_date::DATE IS NULL) OR (db_mdate = :modification_date)) "
    )
    long getPrepaidServicesCount(
            @Bind("service_type") String service_type,
            @Bind("status") String status,
            @Bind("external_provision_id") String external_provision_id,
            @Bind ("creation_date") Date creation_date,
            @Bind("modification_date") Date modification_date);
    
    
    @Mapper(PrepaidServiceMapper.class)
    @SqlQuery("SELECT id, external_provision_id, "
            + "status, name, deleted_reason, "
            + "(SELECT is_legacy FROM telo_operators WHERE "
            + "prepaid_service_id = :prepaid_service_id) AS is_legacy, "
            + "service_type, product_id FROM prepaid_services "
            + "WHERE id = :prepaid_service_id "
)
    List<ServicePrepaid> findPrepaidServiceById(
            @Bind("prepaid_service_id") long prepaid_service_id);       
    
    @SqlUpdate("UPDATE prepaid_services SET external_provision_id = :external_provision_id, name= :name, service_type = :service_type, product_id = :product_id ,deleted_reason = :deleted_reason WHERE id = :id")
            public void updatePrepaidService(@Bind("external_provision_id") String external_provision_id,
//                                             @Bind("status") String status,
                                             @Bind("name") String name,
                                             @Bind("service_type") String service_type,
                                             @Bind("deleted_reason") String deleted_reason,
                                             @Bind("product_id") long product_id,
                                             @Bind("id") long id
            );
            
    @SqlUpdate("UPDATE prepaid_services SET enum_status_id = 2, deleted_reason = :deleted_reason, status = :status WHERE id = :id")
            public void deletePrepaidService(
                    @Bind("id") long id,
                    @Bind("deleted_reason") String deleted_reason,
                    @Bind("status") String status);
    
            
             ///**************POSTPAID SERVICES*************///
             ///******************************************///
    @SqlQuery("SELECT unit_price, service_type_id, external_provision_id FROM postpaid_products WHERE enum_status_id != 2")
    ArrayList<Map> findAllPostPaidServices();
    
    @SqlQuery("SELECT unit_price, service_type_id, external_provision_id FROM postpaid_service FROM postpaid_products WHERE postpaid_service_id = :postpaid_service_id AND enum_status_id != 2")
    ArrayList<Map> findAllPostpaidServicesById(@Bind("postpaid_service_id") String postpaid_service_id);
    
    @SqlUpdate("UPDATE postpaid_products SET external_provision_id = :external_provision_id, unit_price = :unit_price  WHERE id = :id")
            public void updatePostpaidService(
                                            @Bind("external_provision_id") String external_provision_id,
                                            @Bind("unit_price") float unit_price,
                                            @Bind("id") long id
            );
    
     @SqlUpdate("UPDATE postpaid_products SET enum_status_id = 2 WHERE id = id ")
            public void deletePostpaidService(
                                             @Bind("id") long id);
    
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
            public int deleteCreditNote( @Bind("invoice_number") String invoice_number);
    //=========CREDIT NOTE DAO ENDS===========//
            
            //=================CUSTOMER CONTACT DAO==============//
    @SqlQuery("SELECT contact_type, contact_name, contact_email, contact_phone, contact_fax FROM contact WHERE enum_status_id != 2")
            ArrayList<Map> findAllCustomerContact();
            
    @SqlQuery("SELECT contact_type, contact_name, contact_email, contact_phone, contact_fax FROM contact WHERE customer_contact_id = :customer_contact_id AND enum_status_id != 2")
            ArrayList<Map> findAllCustomerContactById(@Bind("customer_contact_id") String customer_contact_id);
    
    @SqlUpdate("UPDATE customer_contact SET contact_type = :contact_type, contact_name = :contact_name, contact_email = :contact_email, contact_phone = :contact_phone, contact_fax = :contact_fax WHERE id = :id")
            public void updateCustomerContact(@Bind("contact_type") String contact_type,
                                              @Bind("contact_name") String contact_name,
                                              @Bind("contact_email") String contact_email,
                                              @Bind("contact_phone") String contact_phone,
                                              @Bind("contact_fax") String contact_fax,
                                              @Bind("id") int id
                                                );
    
    @SqlUpdate("UPDATE contact SET enum_status_id = 2 WHERE cid = :cid")
            public void deleteCustomrContact(@Bind("cid") String cid);
    
            //=================CUSTOMER DAO ENDS================//
    /**
     * close with no args is used to close the connection
     */
    void close();



   


    

}
