/*
 Navicat Premium Data Transfer

 Source Server         : Emerge DEV
 Source Server Type    : PostgreSQL
 Source Server Version : 90502
 Source Host           : lx-dev-emea-emerge-rdbms-pg-01
 Source Database       : bss
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90502
 File Encoding         : utf-8

 Date: 11/24/2016 12:18:33 PM
*/

-- ----------------------------
--  Sequence structure for alleged_payments_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."alleged_payments_id_seq";
CREATE SEQUENCE "public"."alleged_payments_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."alleged_payments_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for contract_templates_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."contract_templates_id_seq";
CREATE SEQUENCE "public"."contract_templates_id_seq" INCREMENT 1 START 18 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."contract_templates_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for credit_notes_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."credit_notes_id_seq";
CREATE SEQUENCE "public"."credit_notes_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."credit_notes_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for customer_addresses_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."customer_addresses_id_seq";
CREATE SEQUENCE "public"."customer_addresses_id_seq" INCREMENT 1 START 72 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."customer_addresses_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for customer_contacts_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."customer_contacts_id_seq";
CREATE SEQUENCE "public"."customer_contacts_id_seq" INCREMENT 1 START 64 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."customer_contacts_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for customers_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."customers_id_seq";
CREATE SEQUENCE "public"."customers_id_seq" INCREMENT 1 START 276 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."customers_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for invoices_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."invoices_id_seq";
CREATE SEQUENCE "public"."invoices_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."invoices_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for payments_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."payments_id_seq";
CREATE SEQUENCE "public"."payments_id_seq" INCREMENT 1 START 513 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."payments_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for postpaid_contract_supplements_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."postpaid_contract_supplements_id_seq";
CREATE SEQUENCE "public"."postpaid_contract_supplements_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."postpaid_contract_supplements_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for postpaid_contracts_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."postpaid_contracts_id_seq";
CREATE SEQUENCE "public"."postpaid_contracts_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."postpaid_contracts_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for postpaid_products_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."postpaid_products_id_seq";
CREATE SEQUENCE "public"."postpaid_products_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."postpaid_products_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for prepaid_contract_supplements_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."prepaid_contract_supplements_id_seq";
CREATE SEQUENCE "public"."prepaid_contract_supplements_id_seq" INCREMENT 1 START 18 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."prepaid_contract_supplements_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for prepaid_contracts_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."prepaid_contracts_id_seq";
CREATE SEQUENCE "public"."prepaid_contracts_id_seq" INCREMENT 1 START 85 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."prepaid_contracts_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for prepaid_services_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."prepaid_services_id_seq";
CREATE SEQUENCE "public"."prepaid_services_id_seq" INCREMENT 1 START 195 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."prepaid_services_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for products_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."products_id_seq";
CREATE SEQUENCE "public"."products_id_seq" INCREMENT 1 START 8 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."products_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for service_associations_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."service_associations_id_seq";
CREATE SEQUENCE "public"."service_associations_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."service_associations_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for tax_types_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tax_types_id_seq";
CREATE SEQUENCE "public"."tax_types_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."tax_types_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for telo_agent_profit_config_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."telo_agent_profit_config_id_seq";
CREATE SEQUENCE "public"."telo_agent_profit_config_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."telo_agent_profit_config_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for telo_agents_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."telo_agents_id_seq";
CREATE SEQUENCE "public"."telo_agents_id_seq" INCREMENT 1 START 44 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."telo_agents_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for telo_operator_profit_config_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."telo_operator_profit_config_id_seq";
CREATE SEQUENCE "public"."telo_operator_profit_config_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."telo_operator_profit_config_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for telo_operators_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."telo_operators_id_seq";
CREATE SEQUENCE "public"."telo_operators_id_seq" INCREMENT 1 START 49 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."telo_operators_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Table structure for payments
-- ----------------------------
DROP TABLE IF EXISTS "public"."payments";
CREATE TABLE "public"."payments" (
	"id" int8 NOT NULL DEFAULT nextval('payments_id_seq'::regclass),
	"search_key" text COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" text COLLATE "default",
	"db_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"app_muser" text COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int8 NOT NULL DEFAULT 1,
	"payment_date" timestamp(6) WITH TIME ZONE,
	"reconciled" varchar(20) COLLATE "default",
	"reconciled_method" varchar(20) COLLATE "default",
	"provisioned_equipment" varchar(15) COLLATE "default",
	"payment_reference_number" text COLLATE "default",
	"credit_before_payment" varchar(100) COLLATE "default",
	"credit_after_payment" varchar(100) COLLATE "default",
	"cost_of_payment_method" float4,
	"name_of_back_office_operator" varchar(150) COLLATE "default",
	"revoked" varchar(200) COLLATE "default",
	"notes" text COLLATE "default",
	"payment_status" varchar(100) NOT NULL COLLATE "default",
	"electronic_reference" text COLLATE "default",
	"paid_service" varchar(10) COLLATE "default",
	"value" float8,
	"bank_name" varchar(50) COLLATE "default",
	"provisioned_equipments" varchar(512) COLLATE "default",
	"payment_method" varchar(215) COLLATE "default",
	"description" varchar(512) COLLATE "default",
	"treasury_accounts" varchar(128) COLLATE "default",
	"prepaid_service_id" int8,
	"postpaid_service_id" int8,
	"customer_id" int8
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."payments" OWNER TO "postgres";

COMMENT ON COLUMN "public"."payments"."reconciled" IS 'Yes or No';
COMMENT ON COLUMN "public"."payments"."reconciled_method" IS 'Auto, Manual';
COMMENT ON COLUMN "public"."payments"."provisioned_equipment" IS 'TEC: TEC ID, PSP: PSP ID, Payphone: MSISDN';
COMMENT ON COLUMN "public"."payments"."credit_before_payment" IS 'Yes or No';
COMMENT ON COLUMN "public"."payments"."credit_after_payment" IS 'Yes or No';
COMMENT ON COLUMN "public"."payments"."revoked" IS 'Yes or No';

-- ----------------------------
--  Table structure for telo_operator_profit_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."telo_operator_profit_config";
CREATE TABLE "public"."telo_operator_profit_config" (
	"id" int8 NOT NULL DEFAULT nextval('telo_operator_profit_config_id_seq'::regclass),
	"telo_operator_id" int8 NOT NULL,
	"start_amount" float8 NOT NULL,
	"end_amount" float8 NOT NULL,
	"search_key" varchar(15) COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" text COLLATE "default",
	"db_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"app_muser" text COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int8 NOT NULL DEFAULT 1,
	"profit_percentage" float8 NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."telo_operator_profit_config" OWNER TO "postgres";

-- ----------------------------
--  Table structure for tax_types
-- ----------------------------
DROP TABLE IF EXISTS "public"."tax_types";
CREATE TABLE "public"."tax_types" (
	"id" int8 NOT NULL DEFAULT nextval('tax_types_id_seq'::regclass),
	"description" text NOT NULL COLLATE "default",
	"percentage" float4 NOT NULL,
	"search_key" varchar(15) COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" varchar(255) COLLATE "default",
	"db_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"app_muser" varchar(15) COLLATE "default",
	"app_cuser" varchar(15) COLLATE "default",
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int2,
	"version" int8 NOT NULL DEFAULT 1
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."tax_types" OWNER TO "postgres";

-- ----------------------------
--  Table structure for invoices
-- ----------------------------
DROP TABLE IF EXISTS "public"."invoices";
CREATE TABLE "public"."invoices" (
	"id" int8 NOT NULL DEFAULT nextval('invoices_id_seq'::regclass),
	"search_key" text COLLATE "default",
	"realm_id" int8,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" text COLLATE "default",
	"db_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"app_muser" text COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"unique_control" int8,
	"due_date" timestamp(6) WITH TIME ZONE,
	"customer_id" int8 NOT NULL,
	"provisioned_equipment_id" varchar(50) COLLATE "default",
	"invoice_number" varchar(100) NOT NULL COLLATE "default",
	"payment_id" int8,
	"notification_method" varchar(15) COLLATE "default",
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"version" int8 NOT NULL DEFAULT 1,
	"company_name" varchar(100) NOT NULL COLLATE "default",
	"business_name" varchar(100) NOT NULL COLLATE "default",
	"tax_registration_number" varchar(100) NOT NULL COLLATE "default",
	"telephone_number" varchar(15) NOT NULL COLLATE "default",
	"fax" varchar(30) COLLATE "default",
	"account_id" varchar(15) NOT NULL COLLATE "default",
	"vat_number" varchar(30) NOT NULL COLLATE "default",
	"invoice_hash" varchar(50) COLLATE "default",
	"invoice_hash_control" varchar(255) COLLATE "default",
	"invoice_type" varchar(30) NOT NULL COLLATE "default",
	"invoice_date" timestamp(6) WITH TIME ZONE NOT NULL,
	"invoice_period" varchar(20) NOT NULL COLLATE "default",
	"product_code" varchar(20) NOT NULL COLLATE "default",
	"quantity" int4,
	"unit_price" float8,
	"discount_percentage" float4,
	"discount_value" float4,
	"description" varchar COLLATE "default",
	"amount_without_tax" float4,
	"tax_type" varchar(20) COLLATE "default",
	"tax_percentage" float4,
	"tax_amount" float4,
	"tax_exemption_reason" varchar(255) COLLATE "default",
	"tax_payables" float4,
	"net_total" float4,
	"gross_total" float4,
	"emis_entity_code" varchar(20) COLLATE "default",
	"emis_reference_code" varchar(255) COLLATE "default",
	"authorization_reference_number" varchar(25) COLLATE "default",
	"account_number" varchar(50) COLLATE "default",
	"bank_id" varchar(20) COLLATE "default",
	"notes" text COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."invoices" OWNER TO "postgres";

-- ----------------------------
--  Table structure for postpaid_contracts
-- ----------------------------
DROP TABLE IF EXISTS "public"."postpaid_contracts";
CREATE TABLE "public"."postpaid_contracts" (
	"id" int8 NOT NULL DEFAULT nextval('postpaid_contracts_id_seq'::regclass),
	"billing_periodicity" int2 NOT NULL,
	"billing_day" timestamp(6) WITH TIME ZONE NOT NULL,
	"search_key" varchar(255) COLLATE "default",
	"realm_id" varchar(255) COLLATE "default",
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" varchar(255) COLLATE "default",
	"db_muser" varchar(255) COLLATE "default",
	"app_cuser" varchar(255) COLLATE "default",
	"app_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int2,
	"version" int8 NOT NULL DEFAULT 1,
	"customer_id" int8,
	"allow_joint_billing" bool,
	"status_date" timestamp(6) WITH TIME ZONE,
	"second_contractor_name" text COLLATE "default",
	"second_contractor_fiscal_no" text COLLATE "default",
	"second_contractor_address" text COLLATE "default",
	"start_date" timestamp(6) WITH TIME ZONE,
	"contract_mode" varchar(15) NOT NULL DEFAULT 'MAIN'::character varying COLLATE "default",
	"end_date" timestamp(6) WITH TIME ZONE,
	"preamble" text COLLATE "default",
	"clauses" text COLLATE "default",
	"expiration_conditions" text COLLATE "default",
	"first_contractor" text COLLATE "default",
	"goods_services" text COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."postpaid_contracts" OWNER TO "postgres";

COMMENT ON COLUMN "public"."postpaid_contracts"."billing_periodicity" IS '{Monthly, Bimonthly, Quarterly, Semiannualy, Annualy}';
COMMENT ON COLUMN "public"."postpaid_contracts"."allow_joint_billing" IS '1 - Yes 2 - No';
COMMENT ON COLUMN "public"."postpaid_contracts"."contract_mode" IS 'Enum — MAIN, SUPPLEMENT';

-- ----------------------------
--  Table structure for customer_contacts
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer_contacts";
CREATE TABLE "public"."customer_contacts" (
	"id" int8 NOT NULL DEFAULT nextval('customer_contacts_id_seq'::regclass),
	"search_key" text COLLATE "default",
	"realm_id" int8,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" text COLLATE "default",
	"db_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"app_muser" text COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int4 NOT NULL DEFAULT 1,
	"optional_attributes_context" text COLLATE "default",
	"optional_attribute_01" text COLLATE "default",
	"optional_attribute_02" text COLLATE "default",
	"customer_address_id" int8 NOT NULL,
	"creation_date" timestamp(6) WITH TIME ZONE NOT NULL,
	"contact_type" varchar(25) COLLATE "default",
	"contact_name" varchar(25) COLLATE "default",
	"contact_email" varchar(50) COLLATE "default",
	"contact_phone" varchar(20) COLLATE "default",
	"contact_fax" varchar(20) COLLATE "default",
	"notify_by_sms" bool,
	"notify_by_email" bool,
	"send_invoice_by_email" bool,
	"main_contact" bool DEFAULT false
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."customer_contacts" OWNER TO "postgres";

-- ----------------------------
--  Table structure for contract_templates
-- ----------------------------
DROP TABLE IF EXISTS "public"."contract_templates";
CREATE TABLE "public"."contract_templates" (
	"id" int8 NOT NULL DEFAULT nextval('contract_templates_id_seq'::regclass),
	"name" varchar(50) COLLATE "default",
	"description" varchar(255) COLLATE "default",
	"contract_type" varchar(11) COLLATE "default",
	"content" text NOT NULL COLLATE "default",
	"search_key" varchar(255) COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" varchar(255) COLLATE "default",
	"db_muser" varchar(255) COLLATE "default",
	"app_cuser" varchar(255) COLLATE "default",
	"app_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int2,
	"version" int2,
	"created_by" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."contract_templates" OWNER TO "postgres";

COMMENT ON COLUMN "public"."contract_templates"."contract_type" IS '1 - Prepaid 2 - Postpaid';

-- ----------------------------
--  Table structure for postpaid_contract_supplements
-- ----------------------------
DROP TABLE IF EXISTS "public"."postpaid_contract_supplements";
CREATE TABLE "public"."postpaid_contract_supplements" (
	"id" int8 NOT NULL DEFAULT nextval('postpaid_contract_supplements_id_seq'::regclass),
	"referenced_contract_id" int8,
	"supplement_contract_id" int8,
	"search_key" varchar(255) COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" varchar(255) COLLATE "default",
	"db_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"app_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int2,
	"version" int2
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."postpaid_contract_supplements" OWNER TO "postgres";

-- ----------------------------
--  Table structure for customer_addresses
-- ----------------------------
DROP TABLE IF EXISTS "public"."customer_addresses";
CREATE TABLE "public"."customer_addresses" (
	"id" int8 NOT NULL DEFAULT nextval('customer_addresses_id_seq'::regclass),
	"customer_id" int8,
	"email" varchar(62) COLLATE "default",
	"search_key" text COLLATE "default",
	"realm_id" int8,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" text COLLATE "default",
	"app_muser" text COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int8 NOT NULL DEFAULT 1,
	"address_name" varchar(100) NOT NULL COLLATE "default",
	"address" text NOT NULL COLLATE "default",
	"fax_number" varchar(20) COLLATE "default",
	"telephone_number" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."customer_addresses" OWNER TO "postgres";

-- ----------------------------
--  Table structure for credit_notes
-- ----------------------------
DROP TABLE IF EXISTS "public"."credit_notes";
CREATE TABLE "public"."credit_notes" (
	"id" int8 NOT NULL DEFAULT nextval('credit_notes_id_seq'::regclass),
	"customer_id" int8,
	"search_key" text COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" text COLLATE "default",
	"db_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"app_muser" text COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int8 NOT NULL DEFAULT 1,
	"customer_name" varchar(50) NOT NULL COLLATE "default",
	"customer_address" varchar(100) NOT NULL COLLATE "default",
	"customer_vat_number" varchar(30) NOT NULL COLLATE "default",
	"customer_telephone_number" varchar(15) NOT NULL COLLATE "default",
	"supplier_name" varchar(50) NOT NULL COLLATE "default",
	"supplier_address" varchar(100) NOT NULL COLLATE "default",
	"supplier_country" varchar(30) COLLATE "default",
	"supplier_vat_number" varchar(20) NOT NULL COLLATE "default",
	"credit_note_number" varchar(20) NOT NULL COLLATE "default",
	"rules" varchar(20) NOT NULL COLLATE "default",
	"credit_note_date" timestamp(6) WITH TIME ZONE NOT NULL,
	"total_amount" float8 NOT NULL,
	"invoice_number" varchar(20) NOT NULL COLLATE "default",
	"goods_services" varchar(100) COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."credit_notes" OWNER TO "postgres";

-- ----------------------------
--  Table structure for alleged_payments
-- ----------------------------
DROP TABLE IF EXISTS "public"."alleged_payments";
CREATE TABLE "public"."alleged_payments" (
	"id" int8 NOT NULL DEFAULT nextval('alleged_payments_id_seq'::regclass),
	"payment_method" varchar(15) COLLATE "default",
	"customer_id" int8,
	"services_to_provision" int2,
	"search_key" text COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"payment_reference_number" varchar(50) COLLATE "default",
	"bank_name" varchar(50) COLLATE "default",
	"value" float8,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" text COLLATE "default",
	"db_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"app_muser" text COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int8 NOT NULL DEFAULT 1
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."alleged_payments" OWNER TO "postgres";

COMMENT ON COLUMN "public"."alleged_payments"."payment_method" IS '1 - Bordereau 2 - EMIS 3 - Bank Wire Transfer 4 - Postal Receipt';
COMMENT ON COLUMN "public"."alleged_payments"."services_to_provision" IS '1 - TeloPayPhone 2 - TEC 3 - PSP';

-- ----------------------------
--  Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS "public"."products";
CREATE TABLE "public"."products" (
	"id" int8 NOT NULL DEFAULT nextval('products_id_seq'::regclass),
	"product_code" varchar(25) NOT NULL COLLATE "default",
	"product_description" text NOT NULL COLLATE "default",
	"tax_type_id" int8 NOT NULL,
	"search_key" varchar(255) COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" date,
	"db_cuser" varchar(255) COLLATE "default",
	"db_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"app_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int4 NOT NULL DEFAULT 1,
	"product_type" varchar(15) COLLATE "default",
	"product_name" varchar(30) COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."products" OWNER TO "postgres";

COMMENT ON COLUMN "public"."products"."product_type" IS '1 - prepaid 2 - postpaid';

-- ----------------------------
--  Table structure for telo_agents
-- ----------------------------
DROP TABLE IF EXISTS "public"."telo_agents";
CREATE TABLE "public"."telo_agents" (
	"id" int8 NOT NULL DEFAULT nextval('telo_agents_id_seq'::regclass),
	"balance" float8 NOT NULL,
	"prepaid_service_id" int8,
	"search_key" varchar(255) COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" varchar(255) COLLATE "default",
	"db_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"app_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int2,
	"version" int8 NOT NULL DEFAULT 1
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."telo_agents" OWNER TO "postgres";

-- ----------------------------
--  Table structure for prepaid_contract_supplements
-- ----------------------------
DROP TABLE IF EXISTS "public"."prepaid_contract_supplements";
CREATE TABLE "public"."prepaid_contract_supplements" (
	"id" int8 NOT NULL DEFAULT nextval('prepaid_contract_supplements_id_seq'::regclass),
	"referenced_contract_id" int8,
	"supplement_contract_id" int8,
	"search_key" text COLLATE "default",
	"realm_id" int8,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" varchar(255) COLLATE "default",
	"db_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"app_muser" varchar(255) COLLATE "default",
	"app_cuser" varchar(255) COLLATE "default",
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int2,
	"version" int2
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."prepaid_contract_supplements" OWNER TO "postgres";

-- ----------------------------
--  Table structure for customers
-- ----------------------------
DROP TABLE IF EXISTS "public"."customers";
CREATE TABLE "public"."customers" (
	"id" int8 NOT NULL DEFAULT nextval('customers_id_seq'::regclass),
	"search_key" text COLLATE "default",
	"realm_id" int8,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" text COLLATE "default",
	"db_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"app_muser" text COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int8 NOT NULL DEFAULT 1,
	"status" varchar(15) NOT NULL DEFAULT 'INACTIVE'::character varying COLLATE "default",
	"name" varchar(50) NOT NULL COLLATE "default",
	"fiscal_number" varchar(100) NOT NULL COLLATE "default",
	"tax_exemption_certificates" text COLLATE "default",
	"country" varchar(10) NOT NULL COLLATE "default",
	"website" varchar(100) COLLATE "default",
	"private_notes" varchar(255) COLLATE "default",
	"public_notes" varchar(255) COLLATE "default",
	"tags" text COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."customers" OWNER TO "postgres";

COMMENT ON COLUMN "public"."customers"."status" IS '1 - NEW 2 - ACTIVE 3 - INACTIVE 4 - FROZEN';

-- ----------------------------
--  Table structure for telo_agent_profit_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."telo_agent_profit_config";
CREATE TABLE "public"."telo_agent_profit_config" (
	"id" int8 NOT NULL DEFAULT nextval('telo_agent_profit_config_id_seq'::regclass),
	"start_amount" float8 NOT NULL,
	"end_amount" float8 NOT NULL,
	"profit_percentage" numeric NOT NULL,
	"telo_agent_id" int8 NOT NULL,
	"search_key" varchar(15) COLLATE "default",
	"realm_id" int8,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" varchar(15) COLLATE "default",
	"db_muser" varchar(15) COLLATE "default",
	"app_cuser" varchar(15) COLLATE "default",
	"app_muser" varchar(15) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int4,
	"version" int8 NOT NULL DEFAULT 1
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."telo_agent_profit_config" OWNER TO "postgres";

-- ----------------------------
--  Table structure for telo_operators
-- ----------------------------
DROP TABLE IF EXISTS "public"."telo_operators";
CREATE TABLE "public"."telo_operators" (
	"id" int8 NOT NULL DEFAULT nextval('telo_operators_id_seq'::regclass),
	"payphone_service_id" varchar(15) NOT NULL COLLATE "default",
	"is_legacy" bool DEFAULT false,
	"prepaid_service_id" int8,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"version" int8 NOT NULL DEFAULT 1,
	"search_key" varchar(10) COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" varchar(10) COLLATE "default",
	"db_muser" varchar(10) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"app_muser" varchar(10) COLLATE "default",
	"app_cuser" varchar(10) COLLATE "default",
	"unique_control" int8
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."telo_operators" OWNER TO "postgres";

COMMENT ON COLUMN "public"."telo_operators"."payphone_service_id" IS 'varchar because the ID reference is external';

-- ----------------------------
--  Table structure for prepaid_contracts
-- ----------------------------
DROP TABLE IF EXISTS "public"."prepaid_contracts";
CREATE TABLE "public"."prepaid_contracts" (
	"id" int8 NOT NULL DEFAULT nextval('prepaid_contracts_id_seq'::regclass),
	"prepaid_service_id" int8 NOT NULL,
	"search_key" text COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" text COLLATE "default",
	"db_muser" text COLLATE "default",
	"app_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int8 NOT NULL DEFAULT 1,
	"customer_id" int8 NOT NULL,
	"status_date" timestamp(6) WITH TIME ZONE NOT NULL,
	"content" text NOT NULL COLLATE "default",
	"start_date" timestamp(6) WITH TIME ZONE NOT NULL,
	"end_date" timestamp(6) WITH TIME ZONE,
	"status" varchar(15) NOT NULL DEFAULT 'NEW'::character varying COLLATE "default",
	"automatic_renewal" bool,
	"service_type" text COLLATE "default",
	"mode" varchar(15) DEFAULT 'MAIN'::character varying COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."prepaid_contracts" OWNER TO "postgres";

COMMENT ON COLUMN "public"."prepaid_contracts"."status" IS 'Enum, NEW, PENDING, ACTIVE, CANCELLED, EXPIRED, CLOSED';

-- ----------------------------
--  Table structure for postpaid_products
-- ----------------------------
DROP TABLE IF EXISTS "public"."postpaid_products";
CREATE TABLE "public"."postpaid_products" (
	"id" int8 NOT NULL DEFAULT nextval('postpaid_products_id_seq'::regclass),
	"unit_price" float4 NOT NULL,
	"search_key" text COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" text COLLATE "default",
	"db_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"app_muser" text COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int8 NOT NULL DEFAULT 1,
	"external_provision_id" varchar(15) COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."postpaid_products" OWNER TO "postgres";

-- ----------------------------
--  Table structure for service_associations
-- ----------------------------
DROP TABLE IF EXISTS "public"."service_associations";
CREATE TABLE "public"."service_associations" (
	"id" int8 NOT NULL DEFAULT nextval('service_associations_id_seq'::regclass),
	"postpaid_service_id" int8 NOT NULL,
	"postpaid_contract_id" int8 NOT NULL,
	"assoc_date" timestamp(6) WITH TIME ZONE NOT NULL,
	"disassoc_date" timestamp(6) WITH TIME ZONE,
	"status" varchar(255) NOT NULL COLLATE "default",
	"start_date" timestamp(6) WITH TIME ZONE NOT NULL,
	"end_date" timestamp(6) WITH TIME ZONE,
	"unit_price" float8 NOT NULL,
	"tax_percentage" varchar(255) NOT NULL COLLATE "default",
	"tax_exemption" varchar(255) COLLATE "default",
	"search_key" varchar(255) COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" varchar(255) COLLATE "default",
	"db_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique control" int2,
	"version" int8 NOT NULL DEFAULT 1,
	"service_association_status" varchar(15) NOT NULL DEFAULT 'NEW'::character varying COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."service_associations" OWNER TO "postgres";

COMMENT ON COLUMN "public"."service_associations"."service_association_status" IS '1 - New 2 - Pending 3 - Active 4 - Cancelled 5 - Expired 6 - Close';

-- ----------------------------
--  Table structure for prepaid_services
-- ----------------------------
DROP TABLE IF EXISTS "public"."prepaid_services";
CREATE TABLE "public"."prepaid_services" (
	"id" int8 NOT NULL DEFAULT nextval('prepaid_services_id_seq'::regclass),
	"external_provision_id" varchar(25) COLLATE "default",
	"status" varchar(15) NOT NULL DEFAULT 'READY'::character varying COLLATE "default",
	"name" varchar(255) NOT NULL COLLATE "default",
	"deleted_reason" varchar(255) COLLATE "default",
	"service_type" varchar(15) NOT NULL COLLATE "default",
	"search_key" varchar(255) COLLATE "default",
	"realm_id" int2,
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"db_cuser" varchar(255) COLLATE "default",
	"db_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"app_muser" text COLLATE "default",
	"app_cuser" text COLLATE "default",
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int2,
	"version" int8 NOT NULL DEFAULT 1,
	"product_id" int8 NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."prepaid_services" OWNER TO "postgres";

COMMENT ON COLUMN "public"."prepaid_services"."status" IS '1 - READY 2 - ACTIVE 3 - DELETED';
COMMENT ON COLUMN "public"."prepaid_services"."service_type" IS 'Enum of service types';


-- ----------------------------
--  Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."alleged_payments_id_seq" RESTART 3 OWNED BY "alleged_payments"."id";
ALTER SEQUENCE "public"."contract_templates_id_seq" RESTART 19 OWNED BY "contract_templates"."id";
ALTER SEQUENCE "public"."credit_notes_id_seq" RESTART 3 OWNED BY "credit_notes"."id";
ALTER SEQUENCE "public"."customer_addresses_id_seq" RESTART 73 OWNED BY "customer_addresses"."id";
ALTER SEQUENCE "public"."customer_contacts_id_seq" RESTART 65 OWNED BY "customer_contacts"."id";
ALTER SEQUENCE "public"."customers_id_seq" RESTART 277 OWNED BY "customers"."id";
ALTER SEQUENCE "public"."invoices_id_seq" RESTART 3 OWNED BY "invoices"."id";
ALTER SEQUENCE "public"."payments_id_seq" RESTART 514 OWNED BY "payments"."id";
ALTER SEQUENCE "public"."postpaid_contract_supplements_id_seq" RESTART 3 OWNED BY "postpaid_contract_supplements"."id";
ALTER SEQUENCE "public"."postpaid_contracts_id_seq" RESTART 3 OWNED BY "postpaid_contracts"."id";
ALTER SEQUENCE "public"."postpaid_products_id_seq" RESTART 3 OWNED BY "postpaid_products"."id";
ALTER SEQUENCE "public"."prepaid_contract_supplements_id_seq" RESTART 19 OWNED BY "prepaid_contract_supplements"."id";
ALTER SEQUENCE "public"."prepaid_contracts_id_seq" RESTART 86 OWNED BY "prepaid_contracts"."id";
ALTER SEQUENCE "public"."prepaid_services_id_seq" RESTART 196 OWNED BY "prepaid_services"."id";
ALTER SEQUENCE "public"."products_id_seq" RESTART 9 OWNED BY "products"."id";
ALTER SEQUENCE "public"."service_associations_id_seq" RESTART 3 OWNED BY "service_associations"."id";
ALTER SEQUENCE "public"."tax_types_id_seq" RESTART 3 OWNED BY "tax_types"."id";
ALTER SEQUENCE "public"."telo_agent_profit_config_id_seq" RESTART 3 OWNED BY "telo_agent_profit_config"."id";
ALTER SEQUENCE "public"."telo_agents_id_seq" RESTART 45 OWNED BY "telo_agents"."id";
ALTER SEQUENCE "public"."telo_operator_profit_config_id_seq" RESTART 3 OWNED BY "telo_operator_profit_config"."id";
ALTER SEQUENCE "public"."telo_operators_id_seq" RESTART 50 OWNED BY "telo_operators"."id";
-- ----------------------------
--  Primary key structure for table telo_operator_profit_config
-- ----------------------------
ALTER TABLE "public"."telo_operator_profit_config" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table tax_types
-- ----------------------------
ALTER TABLE "public"."tax_types" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table tax_types
-- ----------------------------
CREATE UNIQUE INDEX  "tax_types_id_enum_status_id_key" ON "public"."tax_types" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table invoices
-- ----------------------------
ALTER TABLE "public"."invoices" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table invoices
-- ----------------------------
ALTER TABLE "public"."invoices" ADD CONSTRAINT "invoice_number" UNIQUE ("invoice_number") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table invoices
-- ----------------------------
CREATE UNIQUE INDEX  "invoices_invoice_number_key" ON "public"."invoices" USING btree(invoice_number COLLATE "default" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table postpaid_contracts
-- ----------------------------
ALTER TABLE "public"."postpaid_contracts" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table postpaid_contracts
-- ----------------------------
CREATE UNIQUE INDEX  "postpaid_contracts_id_enum_status_id_key" ON "public"."postpaid_contracts" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);
CREATE UNIQUE INDEX  "postpaid_contracts_id_key" ON "public"."postpaid_contracts" USING btree("id" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table customer_contacts
-- ----------------------------
ALTER TABLE "public"."customer_contacts" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table customer_contacts
-- ----------------------------
CREATE UNIQUE INDEX  "customer_contacts_id_key" ON "public"."customer_contacts" USING btree("id" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table contract_templates
-- ----------------------------
ALTER TABLE "public"."contract_templates" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table customer_addresses
-- ----------------------------
ALTER TABLE "public"."customer_addresses" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table customer_addresses
-- ----------------------------
CREATE UNIQUE INDEX  "customer_addresses_id_enum_status_id_key" ON "public"."customer_addresses" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);
CREATE UNIQUE INDEX  "customer_addresses_id_key" ON "public"."customer_addresses" USING btree("id" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table credit_notes
-- ----------------------------
ALTER TABLE "public"."credit_notes" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table alleged_payments
-- ----------------------------
ALTER TABLE "public"."alleged_payments" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table products
-- ----------------------------
ALTER TABLE "public"."products" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table products
-- ----------------------------
ALTER TABLE "public"."products" ADD CONSTRAINT "product_code" UNIQUE ("product_code") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table products
-- ----------------------------
CREATE UNIQUE INDEX  "products_id_enum_status_id_key" ON "public"."products" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);
CREATE UNIQUE INDEX  "products_id_key" ON "public"."products" USING btree("id" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table telo_agents
-- ----------------------------
ALTER TABLE "public"."telo_agents" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table telo_agents
-- ----------------------------
ALTER TABLE "public"."telo_agents" ADD CONSTRAINT "agent_prepaid_service_id" UNIQUE ("prepaid_service_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table telo_agents
-- ----------------------------
CREATE UNIQUE INDEX  "telo_agents_id_enum_status_id_key" ON "public"."telo_agents" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table customers
-- ----------------------------
ALTER TABLE "public"."customers" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table customers
-- ----------------------------
ALTER TABLE "public"."customers" ADD CONSTRAINT "un_fiscal_number" UNIQUE ("fiscal_number") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table customers
-- ----------------------------
CREATE UNIQUE INDEX  "customers_id_enum_status_id_key" ON "public"."customers" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table telo_agent_profit_config
-- ----------------------------
ALTER TABLE "public"."telo_agent_profit_config" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table telo_operators
-- ----------------------------
ALTER TABLE "public"."telo_operators" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table telo_operators
-- ----------------------------
ALTER TABLE "public"."telo_operators" ADD CONSTRAINT "operator_prepaid_service_id" UNIQUE ("prepaid_service_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table telo_operators
-- ----------------------------
CREATE UNIQUE INDEX  "telo_operators_id_enum_status_id_key" ON "public"."telo_operators" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table prepaid_contracts
-- ----------------------------
ALTER TABLE "public"."prepaid_contracts" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table prepaid_contracts
-- ----------------------------
ALTER TABLE "public"."prepaid_contracts" ADD CONSTRAINT "contract_prepaid_service" UNIQUE ("prepaid_service_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table prepaid_contracts
-- ----------------------------
CREATE UNIQUE INDEX  "prepaid_contracts_id_enum_status_id_key" ON "public"."prepaid_contracts" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);
CREATE UNIQUE INDEX  "prepaid_contracts_id_key" ON "public"."prepaid_contracts" USING btree("id" ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table postpaid_products
-- ----------------------------
ALTER TABLE "public"."postpaid_products" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table postpaid_products
-- ----------------------------
CREATE UNIQUE INDEX  "postpaid_products_id_enum_status_id_key" ON "public"."postpaid_products" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table service_associations
-- ----------------------------
ALTER TABLE "public"."service_associations" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table prepaid_services
-- ----------------------------
ALTER TABLE "public"."prepaid_services" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table prepaid_services
-- ----------------------------
ALTER TABLE "public"."prepaid_services" ADD CONSTRAINT "external_provision_id" UNIQUE ("external_provision_id","product_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table prepaid_services
-- ----------------------------
CREATE UNIQUE INDEX  "prepaid_services_id_enum_status_id_key" ON "public"."prepaid_services" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);

-- ----------------------------
--  Foreign keys structure for table telo_operator_profit_config
-- ----------------------------
ALTER TABLE "public"."telo_operator_profit_config" ADD CONSTRAINT "fk_telo_operator_profit_config_opeartor" FOREIGN KEY ("telo_operator_id", "enum_status_id") REFERENCES "public"."telo_operators" ("id", "enum_status_id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table invoices
-- ----------------------------
ALTER TABLE "public"."invoices" ADD CONSTRAINT "fk_invoice_customer" FOREIGN KEY ("customer_id") REFERENCES "public"."customers" ("id") ON UPDATE CASCADE ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table postpaid_contracts
-- ----------------------------
ALTER TABLE "public"."postpaid_contracts" ADD CONSTRAINT "fk_postpaid_contracts_customer" FOREIGN KEY ("customer_id", "enum_status_id") REFERENCES "public"."customers" ("id", "enum_status_id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table customer_contacts
-- ----------------------------
ALTER TABLE "public"."customer_contacts" ADD CONSTRAINT "fk_customer_contacts_address" FOREIGN KEY ("customer_address_id") REFERENCES "public"."customer_addresses" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table customer_addresses
-- ----------------------------
ALTER TABLE "public"."customer_addresses" ADD CONSTRAINT "fk_customer_addresses_customer" FOREIGN KEY ("customer_id") REFERENCES "public"."customers" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table credit_notes
-- ----------------------------
ALTER TABLE "public"."credit_notes" ADD CONSTRAINT "fk_invoice_number" FOREIGN KEY ("invoice_number") REFERENCES "public"."invoices" ("invoice_number") ON UPDATE CASCADE ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."credit_notes" ADD CONSTRAINT "fk_credit_notes_customer" FOREIGN KEY ("customer_id") REFERENCES "public"."customers" ("id") ON UPDATE CASCADE ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table alleged_payments
-- ----------------------------
ALTER TABLE "public"."alleged_payments" ADD CONSTRAINT "fk_alleged_payment_customer" FOREIGN KEY ("customer_id") REFERENCES "public"."customers" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table products
-- ----------------------------
ALTER TABLE "public"."products" ADD CONSTRAINT "fk_products_tax_type" FOREIGN KEY ("tax_type_id") REFERENCES "public"."tax_types" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table telo_agents
-- ----------------------------
ALTER TABLE "public"."telo_agents" ADD CONSTRAINT "fk_telo_agents_prepaid_service" FOREIGN KEY ("prepaid_service_id", "enum_status_id") REFERENCES "public"."prepaid_services" ("id", "enum_status_id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table prepaid_contract_supplements
-- ----------------------------
ALTER TABLE "public"."prepaid_contract_supplements" ADD CONSTRAINT "prepaid_contract_refernce" FOREIGN KEY ("referenced_contract_id") REFERENCES "public"."prepaid_contracts" ("id") ON UPDATE NO ACTION ON DELETE SET NULL NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."prepaid_contract_supplements" ADD CONSTRAINT "prepaid_contract_supplement" FOREIGN KEY ("supplement_contract_id") REFERENCES "public"."prepaid_contracts" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table telo_agent_profit_config
-- ----------------------------
ALTER TABLE "public"."telo_agent_profit_config" ADD CONSTRAINT "fk_telo_agent_profit_config_agent" FOREIGN KEY ("telo_agent_id", "enum_status_id") REFERENCES "public"."telo_agents" ("id", "enum_status_id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table telo_operators
-- ----------------------------
ALTER TABLE "public"."telo_operators" ADD CONSTRAINT "fk_telo_operators_prepaid" FOREIGN KEY ("prepaid_service_id", "enum_status_id") REFERENCES "public"."prepaid_services" ("id", "enum_status_id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table prepaid_contracts
-- ----------------------------
ALTER TABLE "public"."prepaid_contracts" ADD CONSTRAINT "fk_prepaid_contracts_customer" FOREIGN KEY ("customer_id") REFERENCES "public"."customers" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."prepaid_contracts" ADD CONSTRAINT "fk_prepaid_contracts_service" FOREIGN KEY ("prepaid_service_id") REFERENCES "public"."prepaid_services" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table service_associations
-- ----------------------------
ALTER TABLE "public"."service_associations" ADD CONSTRAINT "fk_postpaid_service_id" FOREIGN KEY ("postpaid_service_id") REFERENCES "public"."postpaid_products" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."service_associations" ADD CONSTRAINT "fk_postpaid_contract_id" FOREIGN KEY ("postpaid_contract_id") REFERENCES "public"."postpaid_contracts" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table prepaid_services
-- ----------------------------
ALTER TABLE "public"."prepaid_services" ADD CONSTRAINT "fk_preaid_services_product" FOREIGN KEY ("product_id") REFERENCES "public"."products" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

