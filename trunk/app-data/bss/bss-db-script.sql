ALTER TABLE "service_associations" DROP CONSTRAINT "fk_postpaid_service_id";
ALTER TABLE "prepaid_contracts" DROP CONSTRAINT "fk_service_id";
ALTER TABLE "service_associations" DROP CONSTRAINT "fk_postpaid_contract_id";
ALTER TABLE "telo_agent_profit_config" DROP CONSTRAINT "fk_telo_agent_id";
ALTER TABLE "telo_agents" DROP CONSTRAINT "fk_prepaid_service_id";
ALTER TABLE "products" DROP CONSTRAINT "fk_tax_type_id";
ALTER TABLE "credit_notes" DROP CONSTRAINT "fk_invoice_number";
ALTER TABLE "invoices" DROP CONSTRAINT "fk_payment_id";
ALTER TABLE "invoices" DROP CONSTRAINT "fk_customer_id2";
ALTER TABLE "invoices" DROP CONSTRAINT "fk_provisioned_equipment_id";
ALTER TABLE "payments" DROP CONSTRAINT "fk_paid_service";
ALTER TABLE "postpaid_contract_supplements" DROP CONSTRAINT "fk_referenced_contract_id";
ALTER TABLE "credit_notes" DROP CONSTRAINT "fk_credit_notes_customer";
ALTER TABLE "payments" DROP CONSTRAINT "fk_payments_customer";
ALTER TABLE "prepaid_contracts" DROP CONSTRAINT "fk_prepaid_contracts_customer";
ALTER TABLE "alleged_payments" DROP CONSTRAINT "fk_alleged_payment_customer";
ALTER TABLE "customer_addresses" DROP CONSTRAINT "fk_customer_addresses_customer";
ALTER TABLE "prepaid_contract_supplements" DROP CONSTRAINT "fk_supplement_prepaid_contract";
ALTER TABLE "payments" DROP CONSTRAINT "fk_payments_postpaid_service";
ALTER TABLE "telo_operators" DROP CONSTRAINT "fk_telo_operators_prepaid";
ALTER TABLE "customer_contacts" DROP CONSTRAINT "fk_customer_contacts_address";
ALTER TABLE "telo_operator_profit_config" DROP CONSTRAINT "fk_telo_operator_profit_config_opeartor";
ALTER TABLE "prepaid_services" DROP CONSTRAINT "fk_product_id";
ALTER TABLE "postpaid_contracts" DROP CONSTRAINT "fk_postpaid_contracts_customer";

ALTER TABLE "customers" DROP CONSTRAINT "un_fiscal_number";
ALTER TABLE "customers" DROP CONSTRAINT "un_tax_exemption_certificate";
ALTER TABLE "invoices" DROP CONSTRAINT "invoice_number";
ALTER TABLE "prepaid_contracts" DROP CONSTRAINT "contract_prepaid_service";
ALTER TABLE "telo_agents" DROP CONSTRAINT "agent_prepaid_service_id";
ALTER TABLE "products" DROP CONSTRAINT "product_code";
ALTER TABLE "telo_operators" DROP CONSTRAINT "operator_prepaid_service_id";

DROP TABLE "customers";
DROP TABLE "postpaid_contracts";
DROP TABLE "contract_templates";
DROP TABLE "service_associations";
DROP TABLE "prepaid_services";
DROP TABLE "invoices";
DROP TABLE "telo_agent_profit_config";
DROP TABLE "telo_operator_profit_config";
DROP TABLE "credit_notes";
DROP TABLE "payments";
DROP TABLE "tax_types";
DROP TABLE "postpaid_products";
DROP TABLE "prepaid_contracts";
DROP TABLE "telo_agents";
DROP TABLE "products";
DROP TABLE "customer_addresses";
DROP TABLE "alleged_payments";
DROP TABLE "prepaid_contract_supplements";
DROP TABLE "postpaid_contract_supplements";
DROP TABLE "telo_operators";
DROP TABLE "customer_contacts";

CREATE TABLE "customers" (
"id" serial8 NOT NULL,
"search_key" text,
"realm_id" int8,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" text,
"db_muser" text,
"app_cuser" text,
"app_muser" text,
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int8 NOT NULL DEFAULT 1,
"status" varchar(15) NOT NULL DEFAULT 'INACTIVE',
"name" varchar(50) NOT NULL,
"fiscal_number" varchar(100) NOT NULL,
"tax_exemption_certificates" text,
"country" varchar(100) NOT NULL,
"website" varchar(100),
"private_notes" varchar(255),
"public_notes" varchar(255),
"tags" text,
PRIMARY KEY ("id") ,
CONSTRAINT "un_fiscal_number" UNIQUE ("fiscal_number"),
CONSTRAINT "un_tax_exemption_certificate" UNIQUE ("tax_exemption_certificates")
);

COMMENT ON COLUMN "customers"."status" IS '1 - NEW 2 - ACTIVE 3 - INACTIVE 4 - FROZEN';

CREATE TABLE "postpaid_contracts" (
"id" serial8 NOT NULL,
"billing_periodicity" int2 NOT NULL,
"billing_day" timestamptz NOT NULL,
"search_key" varchar(255),
"realm_id" varchar(255),
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" varchar(255),
"db_muser" varchar(255),
"app_cuser" varchar(255),
"app_muser" varchar(255),
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int2,
"version" int8 NOT NULL DEFAULT 1,
"customer_id" int8,
"allow_joint_billing" bool,
"status_date" timestamptz,
"second_contractor_name" text,
"second_contractor_fiscal_no" text,
"second_contractor_address" text,
"start_date" timestamptz,
"mode" varchar(15) NOT NULL DEFAULT 'MAIN',
"end_date" timestamptz,
"preamble" text,
"clauses" text,
"expiration_conditions" text,
"first_contractor" text,
"goods_services" text,
PRIMARY KEY ("id") 
);

COMMENT ON COLUMN "postpaid_contracts"."billing_periodicity" IS '{Monthly, Bimonthly, Quarterly, Semiannualy, Annualy}';
COMMENT ON COLUMN "postpaid_contracts"."allow_joint_billing" IS '1 - Yes 2 - No';
COMMENT ON COLUMN "postpaid_contracts"."mode" IS 'Enum — MAIN, SUPPLEMENT';

CREATE TABLE "contract_templates" (
"id" serial8 NOT NULL,
"name" varchar(50),
"description" varchar(255),
"contract_type" varchar(11),
"content" text NOT NULL,
"search_key" varchar(255),
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" varchar(255),
"db_muser" varchar(255),
"app_cuser" varchar(255),
"app_muser" varchar(255),
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int2,
"version" int2,
"created_by" varchar(255),
PRIMARY KEY ("id") 
);

COMMENT ON COLUMN "contract_templates"."contract_type" IS '1 - Prepaid 2 - Postpaid';

CREATE TABLE "service_associations" (
"id" serial8 NOT NULL,
"postpaid_service_id" int8 NOT NULL,
"postpaid_contract_id" int8 NOT NULL,
"assoc_date" timestamptz NOT NULL,
"disassoc_date" timestamptz,
"status" varchar(255) NOT NULL,
"start_date" timestamptz NOT NULL,
"end_date" timestamptz,
"unit_price" float8 NOT NULL,
"tax_percentage" varchar(255) NOT NULL,
"tax_exemption" varchar(255),
"search_key" varchar(255),
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" varchar(255),
"db_muser" varchar(255),
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique control" int2,
"version" int8 NOT NULL DEFAULT 1,
"service_association_status" varchar(15) NOT NULL DEFAULT 'New',
PRIMARY KEY ("id") 
);

COMMENT ON COLUMN "service_associations"."service_association_status" IS '1 - New 2 - Pending 3 - Active 4 - Cancelled 5 - Expired 6 - Close';

CREATE TABLE "prepaid_services" (
"id" serial8 NOT NULL,
"external_provision_id" varchar(25),
"status" varchar(15) NOT NULL DEFAULT 'READY',
"name" varchar(255) NOT NULL,
"deleted_reason" varchar(255),
"service_type" varchar(15) NOT NULL,
"search_key" varchar(255),
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" varchar(255),
"db_muser" varchar(255),
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"app_muser" text,
"app_cuser" text,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int2,
"version" int8 NOT NULL DEFAULT 1,
"product_id" int8 NOT NULL,
PRIMARY KEY ("id") 
);

COMMENT ON COLUMN "prepaid_services"."status" IS '1 - READY 2 - ACTIVE 3 - DELETED';
COMMENT ON COLUMN "prepaid_services"."service_type" IS 'Enum of service types';

CREATE TABLE "invoices" (
"id" serial8 NOT NULL,
"search_key" text,
"realm_id" int8,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" text,
"db_muser" text,
"app_cuser" text,
"app_muser" text,
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"unique_control" int8,
"due_date" timestamptz,
"customer_id" int8 NOT NULL,
"provisioned_equipment_id" varchar(50),
"invoice_number" varchar(100) NOT NULL,
"payment_id" int8,
"notification_method" varchar(15),
"enum_status_id" int2 NOT NULL DEFAULT 1,
"version" int8 NOT NULL DEFAULT 1,
"company_name" varchar(100) NOT NULL,
"business_name" varchar(100) NOT NULL,
"tax_registration_number" varchar(100) NOT NULL,
"telephone_number" varchar(15) NOT NULL,
"fax" varchar(30),
"account_id" varchar(15) NOT NULL,
"vat_number" varchar(30) NOT NULL,
"invoice_hash" varchar(50),
"invoice_hash_control" varchar(255),
"invoice_type" varchar(30) NOT NULL,
"invoice_date" timestamptz NOT NULL,
"invoice_period" varchar(20) NOT NULL,
"product_code" varchar(20) NOT NULL,
"quantity" int4,
"unit_price" float8,
"discount_percentage" float4,
"discount_value" float4,
"description" varchar,
"amount_without_tax" float4,
"tax_type" varchar(20),
"tax_percentage" float4,
"tax_amount" float4,
"tax_exemption_reason" varchar(255),
"tax_payables" float4,
"net_total" float4,
"gross_total" float4,
"emis_entity_code" varchar(20),
"emis_reference_code" varchar(255),
"authorization_reference_number" varchar(25),
"account_number" varchar(50),
"bank_id" varchar(20),
"notes" text,
PRIMARY KEY ("id") ,
CONSTRAINT "invoice_number" UNIQUE ("invoice_number")
);

CREATE TABLE "telo_agent_profit_config" (
"id" serial8 NOT NULL,
"start_amount" float8 NOT NULL,
"end_amount" float8 NOT NULL,
"profit_percentage" decimal NOT NULL,
"telo_agent_id" int8 NOT NULL,
"search_key" varchar(15),
"realm_id" int8,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" varchar(15),
"db_muser" varchar(15),
"app_cuser" varchar(15),
"app_muser" varchar(15),
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int4,
"version" int8 NOT NULL DEFAULT 1,
PRIMARY KEY ("id") 
);

CREATE TABLE "telo_operator_profit_config" (
"id" serial8 NOT NULL,
"telo_operator_id" int8 NOT NULL,
"start_amount" float8 NOT NULL,
"end_amount" float8 NOT NULL,
"search_key" varchar(15),
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" text,
"db_muser" text,
"app_cuser" text,
"app_muser" text,
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int8 NOT NULL DEFAULT 1,
"profit_percentage" float8 NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "credit_notes" (
"id" serial8 NOT NULL,
"customer_id" int8,
"search_key" text,
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" text,
"db_muser" text,
"app_cuser" text,
"app_muser" text,
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int8 NOT NULL DEFAULT 1,
"customer_name" varchar(50) NOT NULL,
"customer_address" varchar(100) NOT NULL,
"customer_vat_number" varchar(30) NOT NULL,
"customer_telephone_number" varchar(15) NOT NULL,
"supplier_name" varchar(50) NOT NULL,
"supplier_address" varchar(100) NOT NULL,
"supplier_country" varchar(30),
"supplier_vat_number" varchar(20) NOT NULL,
"credit_note_number" varchar(20) NOT NULL,
"rules" varchar(20) NOT NULL,
"credit_note_date" timestamptz NOT NULL,
"total_amount" float8 NOT NULL,
"invoice_number" varchar(20) NOT NULL,
"goods_services" varchar(100),
PRIMARY KEY ("id") 
);

CREATE TABLE "payments" (
"id" serial8,
"search_key" text,
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" text,
"db_muser" text,
"app_cuser" text,
"app_muser" text,
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int8 NOT NULL DEFAULT 1,
"payment_date" timestamptz,
"customer_id" int8 NOT NULL,
"reconciled" varchar(20),
"reconciled_method" varchar(20),
"provisioned_equipment" varchar(15),
"payment_reference_number" text,
"credit_before_payment" varchar(100),
"credit_after_payment" varchar(100),
"cost_of_payment_method" float4,
"name_of_back_office_operator" varchar(150),
"revoked" varchar(200),
"notes" text,
"payment_method" int2 NOT NULL,
"payment_status" varchar(100) NOT NULL,
"electronic_reference" text,
"treasury_accounts" int2,
"prepaid_service_id" int8,
"postpaid_service_id" int8,
"paid_service" varchar(10),
"value" float8,
"bank_name" varchar(50)
);

COMMENT ON COLUMN "payments"."reconciled" IS 'Yes or No';
COMMENT ON COLUMN "payments"."reconciled_method" IS 'Auto, Manual';
COMMENT ON COLUMN "payments"."provisioned_equipment" IS 'TEC: TEC ID, PSP: PSP ID, Payphone: MSISDN';
COMMENT ON COLUMN "payments"."credit_before_payment" IS 'Yes or No';
COMMENT ON COLUMN "payments"."credit_after_payment" IS 'Yes or No';
COMMENT ON COLUMN "payments"."revoked" IS 'Yes or No';
COMMENT ON COLUMN "payments"."payment_method" IS '1 - EMIS 2 - Check 3 - Cash 4 - SEPA  5 - Bordereau 6 -  Bank Wire Transfer 7 -  finance discount  8 -  reconciliation of accounts  9 -  postal receipts to collection  10 -  internal walets';
COMMENT ON COLUMN "payments"."treasury_accounts" IS '1 - EMIS 2 - Check 3 - Cash 4 - SEPA  5 - Bordereau 6 -  Bank Wire Transfer 7 -  finance discount  8 -  reconciliation of accounts  9 -  postal receipts to collection  10 -  internal walets';
COMMENT ON COLUMN "payments"."prepaid_service_id" IS '1 - prepaid 2 - postpaid';

CREATE TABLE "tax_types" (
"id" serial8 NOT NULL,
"description" text NOT NULL,
"percentage" float4 NOT NULL,
"search_key" varchar(15),
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" varchar(255),
"db_muser" varchar(255),
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"app_muser" varchar(15),
"app_cuser" varchar(15),
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int2,
"version" int8 NOT NULL DEFAULT 1,
PRIMARY KEY ("id") 
);

CREATE TABLE "postpaid_products" (
"id" serial8 NOT NULL,
"unit_price" float4 NOT NULL,
"search_key" text,
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" text,
"db_muser" text,
"app_cuser" text,
"app_muser" text,
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int8 NOT NULL DEFAULT 1,
"external_provision_id" varchar(15),
PRIMARY KEY ("id") 
);

CREATE TABLE "prepaid_contracts" (
"id" serial8 NOT NULL,
"prepaid_service_id" int8 NOT NULL,
"search_key" text,
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" text,
"db_muser" text,
"app_muser" text,
"mode" varchar(15) DEFAULT 'MAIN',
"app_cuser" text,
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int8 NOT NULL DEFAULT 1,
"customer_id" int8 NOT NULL,
"status_date" timestamptz NOT NULL,
"content" text NOT NULL,
"start_date" timestamptz NOT NULL,
"end_date" timestamptz,
"status" varchar(15) NOT NULL DEFAULT 'NEW',
"automatic_renewal" bool,
"service_type" varchar(15) NOT NULL,
PRIMARY KEY ("id") ,
CONSTRAINT "contract_prepaid_service" UNIQUE ("prepaid_service_id")
);

COMMENT ON COLUMN "prepaid_contracts"."mode" IS 'MAIN, SUPPLEMENT';
COMMENT ON COLUMN "prepaid_contracts"."status" IS 'Enum, NEW, PENDING, ACTIVE, CANCELLED, EXPIRED, CLOSED';
COMMENT ON COLUMN "prepaid_contracts"."service_type" IS 'Enum PSP, TEC, TELOAGENT, TELOOPERATOR';

CREATE TABLE "telo_agents" (
"id" serial8 NOT NULL,
"balance" float8 NOT NULL,
"prepaid_service_id" int8,
"search_key" varchar(255),
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" varchar(255),
"db_muser" varchar(255),
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"app_muser" text,
"app_cuser" text,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int2,
"version" int8 NOT NULL DEFAULT 1,
PRIMARY KEY ("id") ,
CONSTRAINT "agent_prepaid_service_id" UNIQUE ("prepaid_service_id")
);

CREATE TABLE "products" (
"id" serial8 NOT NULL,
"product_code" varchar(25) NOT NULL,
"product_description" text NOT NULL,
"tax_type_id" int8 NOT NULL,
"search_key" varchar(255),
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" date,
"db_cuser" varchar(255),
"db_muser" varchar(255),
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"app_muser" text,
"app_cuser" text,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int4 NOT NULL DEFAULT 1,
"product_type" varchar(15),
"product_name" varchar(30),
PRIMARY KEY ("id") ,
CONSTRAINT "product_code" UNIQUE ("product_code")
);

COMMENT ON COLUMN "products"."product_type" IS '1 - prepaid 2 - postpaid';

CREATE TABLE "customer_addresses" (
"id" serial8 NOT NULL,
"customer_id" int8,
"email" varchar,
"search_key" text,
"realm_id" int8,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" text,
"app_muser" text,
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int8 NOT NULL DEFAULT 1,
"address_name" varchar(100) NOT NULL,
"address" text NOT NULL,
"fax_number" varchar(50),
"telephone_number" varchar(20),
"notify_by_sms" bool NOT NULL,
"notify_by_email" bool NOT NULL,
"send_invoice_by_email" bool NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "alleged_payments" (
"id" serial8 NOT NULL,
"payment_method" varchar(15),
"customer_id" int8,
"services_to_provision" int2,
"search_key" text,
"realm_id" int2,
"db_cdate" timestamptz,
"payment_reference_number" varchar(50),
"bank_name" varchar(50),
"value" float8,
"db_mdate" timestamptz,
"db_cuser" text,
"db_muser" text,
"app_cuser" text,
"app_muser" text,
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int8 NOT NULL DEFAULT 1,
PRIMARY KEY ("id") 
);

COMMENT ON COLUMN "alleged_payments"."payment_method" IS '1 - Bordereau 2 - EMIS 3 - Bank Wire Transfer 4 - Postal Receipt';
COMMENT ON COLUMN "alleged_payments"."services_to_provision" IS '1 - TeloPayPhone 2 - TEC 3 - PSP';

CREATE TABLE "prepaid_contract_supplements" (
"id" serial8,
"referenced_contract_id" int8,
"supplement_contract_id" int8,
"search_key" text,
"realm_id" int8,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" varchar(255),
"db_muser" varchar(255),
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"app_muser" varchar(255),
"app_cuser" varchar(255),
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int2,
"version" int2
);

CREATE TABLE "postpaid_contract_supplements" (
"id" serial8,
"referenced_contract_id" int8,
"supplement_contract_id" int8,
"search_key" varchar(255),
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" varchar(255),
"db_muser" varchar(255),
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"app_muser" text,
"app_cuser" text,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int2,
"version" int2
);

CREATE TABLE "telo_operators" (
"id" serial8 NOT NULL,
"payphone_service_id" varchar(15) NOT NULL,
"is_legacy" bool DEFAULT FALSE,
"prepaid_service_id" int8,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"version" int8 NOT NULL DEFAULT 1,
"search_key" varchar(10),
"realm_id" int2,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" varchar(10),
"db_muser" varchar(10),
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"app_muser" varchar(10),
"app_cuser" varchar(10),
"unique_control" int8,
PRIMARY KEY ("id") ,
CONSTRAINT "operator_prepaid_service_id" UNIQUE ("prepaid_service_id")
);

COMMENT ON COLUMN "telo_operators"."payphone_service_id" IS 'varchar because the ID reference is external';

CREATE TABLE "customer_contacts" (
"id" serial8 NOT NULL,
"search_key" text,
"realm_id" int8,
"db_cdate" timestamptz,
"db_mdate" timestamptz,
"db_cuser" text,
"db_muser" text,
"app_cuser" text,
"app_muser" text,
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int4 NOT NULL DEFAULT 1,
"optional_attributes_context" text,
"optional_attribute_01" text,
"optional_attribute_02" text,
"customer_address_id" int8 NOT NULL,
"creation_date" timestamptz NOT NULL,
"contact_type" varchar(10),
"contact_name" varchar(10),
"contact_email" varchar(50),
"contact_phone" varchar(20),
"contact_fax" varchar,
PRIMARY KEY ("id") 
);


ALTER TABLE "service_associations" ADD CONSTRAINT "fk_postpaid_service_id" FOREIGN KEY ("postpaid_service_id") REFERENCES "postpaid_products" ("id");
ALTER TABLE "prepaid_contracts" ADD CONSTRAINT "fk_service_id" FOREIGN KEY ("prepaid_service_id") REFERENCES "prepaid_services" ("id");
ALTER TABLE "service_associations" ADD CONSTRAINT "fk_postpaid_contract_id" FOREIGN KEY ("postpaid_contract_id") REFERENCES "postpaid_contracts" ("id");
ALTER TABLE "telo_agent_profit_config" ADD CONSTRAINT "fk_telo_agent_id" FOREIGN KEY ("telo_agent_id") REFERENCES "telo_agents" ("id");
ALTER TABLE "telo_agents" ADD CONSTRAINT "fk_prepaid_service_id" FOREIGN KEY ("prepaid_service_id") REFERENCES "prepaid_services" ("id");
ALTER TABLE "products" ADD CONSTRAINT "fk_tax_type_id" FOREIGN KEY ("tax_type_id") REFERENCES "tax_types" ("id");
ALTER TABLE "credit_notes" ADD CONSTRAINT "fk_invoice_number" FOREIGN KEY ("invoice_number") REFERENCES "invoices" ("invoice_number");
ALTER TABLE "invoices" ADD CONSTRAINT "fk_payment_id" FOREIGN KEY ("payment_id") REFERENCES "payments" ("id");
ALTER TABLE "invoices" ADD CONSTRAINT "fk_customer_id2" FOREIGN KEY ("customer_id") REFERENCES "customers" ("id");
ALTER TABLE "invoices" ADD CONSTRAINT "fk_provisioned_equipment_id" FOREIGN KEY ("provisioned_equipment_id") REFERENCES "prepaid_services" ("external_provision_id");
ALTER TABLE "payments" ADD CONSTRAINT "fk_paid_service" FOREIGN KEY ("prepaid_service_id") REFERENCES "prepaid_services" ("id");
ALTER TABLE "postpaid_contract_supplements" ADD CONSTRAINT "fk_referenced_contract_id" FOREIGN KEY ("referenced_contract_id", "supplement_contract_id") REFERENCES "postpaid_contracts" ("id");
ALTER TABLE "credit_notes" ADD CONSTRAINT "fk_credit_notes_customer" FOREIGN KEY ("customer_id") REFERENCES "customers" ("id");
ALTER TABLE "payments" ADD CONSTRAINT "fk_payments_customer" FOREIGN KEY ("customer_id") REFERENCES "customers" ("id");
ALTER TABLE "prepaid_contracts" ADD CONSTRAINT "fk_prepaid_contracts_customer" FOREIGN KEY ("customer_id") REFERENCES "customers" ("id");
ALTER TABLE "alleged_payments" ADD CONSTRAINT "fk_alleged_payment_customer" FOREIGN KEY ("customer_id") REFERENCES "customers" ("id");
ALTER TABLE "customer_addresses" ADD CONSTRAINT "fk_customer_addresses_customer" FOREIGN KEY ("customer_id") REFERENCES "customers" ("id");
ALTER TABLE "prepaid_contract_supplements" ADD CONSTRAINT "fk_supplement_prepaid_contract" FOREIGN KEY ("referenced_contract_id", "supplement_contract_id") REFERENCES "prepaid_contracts" ("id");
ALTER TABLE "payments" ADD CONSTRAINT "fk_payments_postpaid_service" FOREIGN KEY ("postpaid_service_id") REFERENCES "postpaid_products" ("id");
ALTER TABLE "telo_operators" ADD CONSTRAINT "fk_telo_operators_prepaid" FOREIGN KEY ("prepaid_service_id") REFERENCES "prepaid_services" ("id");
ALTER TABLE "customer_contacts" ADD CONSTRAINT "fk_customer_contacts_address" FOREIGN KEY ("customer_address_id") REFERENCES "customer_addresses" ("id");
ALTER TABLE "telo_operator_profit_config" ADD CONSTRAINT "fk_telo_operator_profit_config_opeartor" FOREIGN KEY ("telo_operator_id") REFERENCES "telo_operators" ("id");
ALTER TABLE "prepaid_services" ADD CONSTRAINT "fk_product_id" FOREIGN KEY ("product_id") REFERENCES "products" ("id");
ALTER TABLE "postpaid_contracts" ADD CONSTRAINT "fk_postpaid_contracts_customer" FOREIGN KEY ("customer_id") REFERENCES "customers" ("id");

