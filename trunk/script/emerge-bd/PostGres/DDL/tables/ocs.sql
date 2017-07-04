/*
 Navicat Premium Data Transfer

 Source Server         : Emerge DEV
 Source Server Type    : PostgreSQL
 Source Server Version : 90502
 Source Host           : lx-dev-emea-emerge-rdbms-pg-01
 Source Database       : ocs
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90502
 File Encoding         : utf-8

 Date: 11/24/2016 12:20:32 PM
*/

-- ----------------------------
--  Sequence structure for authentication_attempts_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."authentication_attempts_id_seq";
CREATE SEQUENCE "public"."authentication_attempts_id_seq" INCREMENT 1 START 459 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."authentication_attempts_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for groups_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."groups_id_seq";
CREATE SEQUENCE "public"."groups_id_seq" INCREMENT 1 START 105 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."groups_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for modulation_types_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."modulation_types_id_seq";
CREATE SEQUENCE "public"."modulation_types_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."modulation_types_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for modulations_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."modulations_id_seq";
CREATE SEQUENCE "public"."modulations_id_seq" INCREMENT 1 START 50 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."modulations_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for ongoing_service_detail_records_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."ongoing_service_detail_records_id_seq";
CREATE SEQUENCE "public"."ongoing_service_detail_records_id_seq" INCREMENT 1 START 308 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."ongoing_service_detail_records_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for ongoing_session_detail_records_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."ongoing_session_detail_records_id_seq";
CREATE SEQUENCE "public"."ongoing_session_detail_records_id_seq" INCREMENT 1 START 459 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."ongoing_session_detail_records_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for payphone_configurations_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."payphone_configurations_id_seq";
CREATE SEQUENCE "public"."payphone_configurations_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."payphone_configurations_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for payphone_global_cfg_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."payphone_global_cfg_id_seq";
CREATE SEQUENCE "public"."payphone_global_cfg_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."payphone_global_cfg_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for payphone_services_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."payphone_services_id_seq";
CREATE SEQUENCE "public"."payphone_services_id_seq" INCREMENT 1 START 117 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."payphone_services_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for payphone_versions_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."payphone_versions_id_seq";
CREATE SEQUENCE "public"."payphone_versions_id_seq" INCREMENT 1 START 54 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."payphone_versions_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for prefixes_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."prefixes_id_seq";
CREATE SEQUENCE "public"."prefixes_id_seq" INCREMENT 1 START 47 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."prefixes_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for profiles_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."profiles_id_seq";
CREATE SEQUENCE "public"."profiles_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."profiles_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for sims_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."sims_id_seq";
CREATE SEQUENCE "public"."sims_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."sims_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for sims_payphone_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."sims_payphone_id_seq";
CREATE SEQUENCE "public"."sims_payphone_id_seq" INCREMENT 1 START 2 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."sims_payphone_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for special_days_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."special_days_id_seq";
CREATE SEQUENCE "public"."special_days_id_seq" INCREMENT 1 START 66 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."special_days_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for tariff_versions_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tariff_versions_id_seq";
CREATE SEQUENCE "public"."tariff_versions_id_seq" INCREMENT 1 START 34 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."tariff_versions_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for tariffs_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."tariffs_id_seq";
CREATE SEQUENCE "public"."tariffs_id_seq" INCREMENT 1 START 44 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."tariffs_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Sequence structure for zones_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."zones_id_seq";
CREATE SEQUENCE "public"."zones_id_seq" INCREMENT 1 START 70 MAXVALUE 9223372036854775807 MINVALUE 1 CACHE 1;
ALTER TABLE "public"."zones_id_seq" OWNER TO "postgres";

-- ----------------------------
--  Table structure for sims
-- ----------------------------
DROP TABLE IF EXISTS "public"."sims";
CREATE TABLE "public"."sims" (
	"id" int8 NOT NULL DEFAULT nextval('sims_id_seq'::regclass),
	"msisdn" varchar(50) COLLATE "default",
	"search_key" varchar(50) COLLATE "default",
	"realm_id" int4,
	"db_cdate" timestamp(6) NULL,
	"db_mdate" timestamp(6) NULL,
	"db_cuser" varchar(50) COLLATE "default",
	"db_muser" varchar(50) COLLATE "default",
	"app_cuser" varchar(50) COLLATE "default",
	"app_muser" varchar(50) COLLATE "default",
	"app_cdate" timestamp(6) NULL,
	"app_mdate" timestamp(6) NULL,
	"enum_status_id" int2,
	"unique_control" int8,
	"version" int4 NOT NULL,
	"optional_attributes_context" varchar(255) COLLATE "default",
	"imsi" varchar(20) NOT NULL COLLATE "default",
	"iccid" varchar COLLATE "default",
	"balance" money,
	"payphone_id" int8 NOT NULL DEFAULT nextval('sims_payphone_id_seq'::regclass)
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."sims" OWNER TO "postgres";

-- ----------------------------
--  Table structure for payphone_services
-- ----------------------------
DROP TABLE IF EXISTS "public"."payphone_services";
CREATE TABLE "public"."payphone_services" (
	"id" int8 NOT NULL DEFAULT nextval('payphone_services_id_seq'::regclass),
	"status" varchar(15) NOT NULL DEFAULT 'INACTIVE'::character varying COLLATE "default",
	"profile_id" int8 NOT NULL,
	"contract_id" int8 NOT NULL,
	"sim1_msisdn" varchar(255) COLLATE "default",
	"sim1_imsi" varchar(255) COLLATE "default",
	"sim1_iccid" varchar(255) COLLATE "default",
	"sim2_msisdn" varchar(255) COLLATE "default",
	"sim2_imsi" varchar(255) COLLATE "default",
	"sim2_iccid" varchar(255) COLLATE "default",
	"balance" float8 NOT NULL DEFAULT 0,
	"username" varchar(25) NOT NULL COLLATE "default",
	"password" text NOT NULL COLLATE "default",
	"keep_alive_interval" int4 NOT NULL,
	"preferred_msisdn" varchar(15) COLLATE "default",
	"status_date" date,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"app_cuser" varchar(15) COLLATE "default",
	"app_muser" varchar(15) COLLATE "default",
	"db_cuser" varchar(15) COLLATE "default",
	"db_muser" varchar(255) COLLATE "default",
	"db_cdate" timestamp(6) WITH TIME ZONE,
	"db_mdate" timestamp(6) WITH TIME ZONE,
	"version" int4 NOT NULL DEFAULT 1,
	"search_key" varchar(15) COLLATE "default",
	"unique_control" int8,
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."payphone_services" OWNER TO "postgres";

COMMENT ON COLUMN "public"."payphone_services"."contract_id" IS 'Contract ID on BSS';

-- ----------------------------
--  Table structure for payphone_configurations
-- ----------------------------
DROP TABLE IF EXISTS "public"."payphone_configurations";
CREATE TABLE "public"."payphone_configurations" (
	"id" int8 NOT NULL DEFAULT nextval('payphone_configurations_id_seq'::regclass),
	"description" varchar(255) COLLATE "default",
	"preferred_msisdn" varchar(255) NOT NULL COLLATE "default",
	"search_key" varchar(255) COLLATE "default",
	"app_cuser" varchar(255) COLLATE "default",
	"app_muser" varchar(255) COLLATE "default",
	"app_cdate" date,
	"app_mdate" date,
	"version" int4,
	"enum_status_id" int4,
	"unique_control" varchar(255) COLLATE "default",
	"realm_id" int4,
	"defaultLanguage" int2,
	"sendErrorsToOCS" int4,
	"silenceMode" bool
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."payphone_configurations" OWNER TO "postgres";

-- ----------------------------
--  Table structure for special_days
-- ----------------------------
DROP TABLE IF EXISTS "public"."special_days";
CREATE TABLE "public"."special_days" (
	"id" int8 NOT NULL DEFAULT nextval('special_days_id_seq'::regclass),
	"day" int2 NOT NULL,
	"month" int2 NOT NULL,
	"year" int4,
	"realm_id" int4,
	"app_cuser" varchar(255) COLLATE "default",
	"app_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) NULL,
	"app_mdate" timestamp(6) NULL,
	"unique_control" varchar(255) COLLATE "default",
	"version" int2 NOT NULL DEFAULT 1,
	"description" varchar(255) COLLATE "default",
	"search_key" varchar(10) COLLATE "default",
	"enum_status_id" int2 NOT NULL DEFAULT 1
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."special_days" OWNER TO "postgres";

-- ----------------------------
--  Table structure for zones
-- ----------------------------
DROP TABLE IF EXISTS "public"."zones";
CREATE TABLE "public"."zones" (
	"id" int8 NOT NULL DEFAULT nextval('zones_id_seq'::regclass),
	"name" varchar(50) NOT NULL COLLATE "default",
	"group_id" int8,
	"search_key" varchar(255) COLLATE "default",
	"realm_id" int4,
	"app_cuser" varchar(50) COLLATE "default",
	"app_muser" varchar(50) COLLATE "default",
	"app_cdate" timestamp(6) NULL,
	"app_mdate" timestamp(6) NULL,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int4,
	"version" int2 NOT NULL DEFAULT 1,
	"tariff_version_id" int8 NOT NULL,
	"description" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."zones" OWNER TO "postgres";

-- ----------------------------
--  Table structure for profiles
-- ----------------------------
DROP TABLE IF EXISTS "public"."profiles";
CREATE TABLE "public"."profiles" (
	"id" int8 NOT NULL DEFAULT nextval('profiles_id_seq'::regclass),
	"description" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."profiles" OWNER TO "postgres";

-- ----------------------------
--  Table structure for payphone_versions
-- ----------------------------
DROP TABLE IF EXISTS "public"."payphone_versions";
CREATE TABLE "public"."payphone_versions" (
	"id" int8 NOT NULL DEFAULT nextval('payphone_versions_id_seq'::regclass),
	"major" int8,
	"minor" int8,
	"patch" int8,
	"status" varchar(50) COLLATE "default",
	"expiry" timestamp(6) NULL,
	"realm_id" int4,
	"app_muser" varchar COLLATE "default",
	"app_cuser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) NULL,
	"app_mdate" timestamp(6) NULL,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int4 NOT NULL DEFAULT 1
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."payphone_versions" OWNER TO "postgres";

-- ----------------------------
--  Table structure for prefixes
-- ----------------------------
DROP TABLE IF EXISTS "public"."prefixes";
CREATE TABLE "public"."prefixes" (
	"id" int8 NOT NULL DEFAULT nextval('prefixes_id_seq'::regclass),
	"value" int8 NOT NULL,
	"zone_id" int8,
	"country" varchar(100) COLLATE "default",
	"search_key" varchar(255) COLLATE "default",
	"realm_id" int4,
	"app_cuser" varchar(50) COLLATE "default",
	"app_muser" varchar(50) COLLATE "default",
	"app_cdate" timestamp(6) NULL,
	"app_mdate" timestamp(6) NULL,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int2 NOT NULL DEFAULT 1,
	"tariff_version_id" int8 NOT NULL,
	"description" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."prefixes" OWNER TO "postgres";

-- ----------------------------
--  Table structure for payphone_global_cfg
-- ----------------------------
DROP TABLE IF EXISTS "public"."payphone_global_cfg";
CREATE TABLE "public"."payphone_global_cfg" (
	"id" int8 NOT NULL DEFAULT nextval('payphone_global_cfg_id_seq'::regclass),
	"button1_label" text NOT NULL COLLATE "default",
	"button1_amount" int8 NOT NULL,
	"button2_label" text NOT NULL COLLATE "default",
	"button2_amount" int8 NOT NULL,
	"button3_label" text NOT NULL COLLATE "default",
	"button3_amount" int8 NOT NULL,
	"button4_label" text NOT NULL COLLATE "default",
	"button4_amount" int8 NOT NULL,
	"keep_alive_interval" int8 NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."payphone_global_cfg" OWNER TO "postgres";

-- ----------------------------
--  Table structure for ongoing_service_detail_records
-- ----------------------------
DROP TABLE IF EXISTS "public"."ongoing_service_detail_records";
CREATE TABLE "public"."ongoing_service_detail_records" (
	"id" int8 NOT NULL DEFAULT nextval('ongoing_service_detail_records_id_seq'::regclass),
	"hostname" varchar(255) COLLATE "default",
	"payphone_device_id" int8,
	"origin_msisdn" varchar(255) COLLATE "default",
	"destination_msisdn" varchar(255) COLLATE "default",
	"destination_group" varchar(255) COLLATE "default",
	"tariff_id" int8 NOT NULL,
	"call_authorization_time" timestamp(6) WITH TIME ZONE,
	"start_time" timestamp(6) WITH TIME ZONE,
	"call_answer_time" timestamp(6) WITH TIME ZONE,
	"call_end_time" timestamp(6) WITH TIME ZONE,
	"call_duration" int8,
	"billed_duration" int8,
	"billed_amount" float8,
	"initial_balance" float8,
	"end_cause" varchar(255) COLLATE "default",
	"end_balance" float8,
	"session_id" int8 NOT NULL,
	"search_key" varchar(15) COLLATE "default",
	"realm_id" int4,
	"app_cuser" varchar(255) COLLATE "default",
	"app_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int4 DEFAULT 1,
	"profile_id" int8 NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."ongoing_service_detail_records" OWNER TO "postgres";

-- ----------------------------
--  Table structure for modulation_types
-- ----------------------------
DROP TABLE IF EXISTS "public"."modulation_types";
CREATE TABLE "public"."modulation_types" (
	"id" int8 NOT NULL DEFAULT nextval('modulation_types_id_seq'::regclass),
	"name" varchar(10) NOT NULL COLLATE "default",
	"realm_id" int4,
	"tariff_version_id" int8 NOT NULL,
	"profile_id" int8 NOT NULL,
	"description" varchar(255) COLLATE "default",
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"app_cuser" varchar(50) COLLATE "default",
	"app_muser" varchar(50) COLLATE "default",
	"app_mdate" timestamp(6) NULL,
	"app_cdate" timestamp(6) NULL,
	"unique_control" int4,
	"version" int2 NOT NULL DEFAULT 1,
	"seach_key" varchar(10) COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."modulation_types" OWNER TO "postgres";

-- ----------------------------
--  Table structure for tariffs
-- ----------------------------
DROP TABLE IF EXISTS "public"."tariffs";
CREATE TABLE "public"."tariffs" (
	"id" int8 NOT NULL DEFAULT nextval('tariffs_id_seq'::regclass),
	"name" varchar(50) NOT NULL COLLATE "default",
	"group_id" int8,
	"modulation_type_id" int8,
	"initial_duration" int8 NOT NULL,
	"initial_cost" float8 NOT NULL,
	"setup_cost" float8,
	"recurrent_cost" float8 NOT NULL,
	"recurrent_duration" int8 NOT NULL,
	"tariff_version_id" int8,
	"profile_id" int8 NOT NULL,
	"status" bool NOT NULL,
	"realm_id" int4,
	"app_cuser" varchar(50) COLLATE "default",
	"app_muser" varchar(50) COLLATE "default",
	"app_cdate" timestamp(6) NULL,
	"app_mdate" timestamp(6) NULL,
	"search_key" varchar(50) COLLATE "default",
	"unique_control" int8,
	"version" int4 NOT NULL DEFAULT 1,
	"enum_status_id" int2 NOT NULL DEFAULT 1
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."tariffs" OWNER TO "postgres";

-- ----------------------------
--  Table structure for tariff_versions
-- ----------------------------
DROP TABLE IF EXISTS "public"."tariff_versions";
CREATE TABLE "public"."tariff_versions" (
	"id" int8 NOT NULL DEFAULT nextval('tariff_versions_id_seq'::regclass),
	"description" text NOT NULL COLLATE "default",
	"status" varchar(15) NOT NULL DEFAULT 'NEW'::character varying COLLATE "default",
	"activation_date" date NOT NULL,
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"app_cuser" varchar(15) COLLATE "default",
	"app_muser" varchar(15) COLLATE "default",
	"search_key" varchar(15) COLLATE "default",
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"version" int4 NOT NULL DEFAULT 1,
	"realm_id" int4,
	"unique_control" int8
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."tariff_versions" OWNER TO "postgres";

COMMENT ON COLUMN "public"."tariff_versions"."status" IS 'Enum — ACTIVE, INACTIVE';

-- ----------------------------
--  Table structure for ongoing_session_detail_records
-- ----------------------------
DROP TABLE IF EXISTS "public"."ongoing_session_detail_records";
CREATE TABLE "public"."ongoing_session_detail_records" (
	"id" int8 NOT NULL DEFAULT nextval('ongoing_session_detail_records_id_seq'::regclass),
	"access_token" varchar(255) COLLATE "default",
	"payphone_device_id" int8 NOT NULL,
	"total_cost" float8,
	"total_call_duration" float8,
	"total_billed_time" float8,
	"total_billed_amount" float8,
	"total_service_duration" float8,
	"session_duration" float8,
	"session_begin_time" timestamp(6) WITH TIME ZONE,
	"session_end_time" timestamp(6) WITH TIME ZONE,
	"end_cause" varchar(255) COLLATE "default",
	"remaining_credit" float8,
	"number_of_services" int4,
	"payphone_balance" float8,
	"maximum_amount_to_spend" float8,
	"search_key" varchar(255) COLLATE "default",
	"realm_id" int4,
	"app_muser" varchar COLLATE "default",
	"app_cuser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) WITH TIME ZONE,
	"app_mdate" timestamp(6) WITH TIME ZONE,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int4 NOT NULL DEFAULT 1,
	"profile_id" int8 NOT NULL
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."ongoing_session_detail_records" OWNER TO "postgres";

COMMENT ON COLUMN "public"."ongoing_session_detail_records"."total_cost" IS '1: active 2: Inactive 3: Inprogress 4: dropped ';
COMMENT ON COLUMN "public"."ongoing_session_detail_records"."end_cause" IS 'Enum value of the possible end causes';

-- ----------------------------
--  Table structure for payphone_devices
-- ----------------------------
DROP TABLE IF EXISTS "public"."payphone_devices";
CREATE TABLE "public"."payphone_devices" (
	"id" int8 NOT NULL,
	"imei1" varchar(30) NOT NULL COLLATE "default",
	"imei2" varchar(30) NOT NULL COLLATE "default",
	"serial_no" varchar(62) NOT NULL COLLATE "default",
	"mac" varchar(24) NOT NULL COLLATE "default",
	"default_language" varchar(20) NOT NULL COLLATE "default",
	"payphone_version_id" int8 NOT NULL,
	"silence_mode" bool,
	"send_errors_to_ocs" int4,
	"search_key" varchar(255) COLLATE "default",
	"realm_id" int4,
	"app_cuser" varchar(255) COLLATE "default",
	"app_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) NULL,
	"app_mdate" timestamp(6) NULL,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int2 NOT NULL DEFAULT 1,
	"deleted_reason" varchar(255) COLLATE "default",
	"preferred_msisdn" varchar(15) COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."payphone_devices" OWNER TO "postgres";

COMMENT ON COLUMN "public"."payphone_devices"."default_language" IS 'Enum — EN, PT, FR';

-- ----------------------------
--  Table structure for authentication_attempts
-- ----------------------------
DROP TABLE IF EXISTS "public"."authentication_attempts";
CREATE TABLE "public"."authentication_attempts" (
	"id" int8 NOT NULL DEFAULT nextval('authentication_attempts_id_seq'::regclass),
	"username" varchar(255) COLLATE "default",
	"sim1_imei" varchar(25) COLLATE "default",
	"sim1_msisdn" varchar(25) COLLATE "default",
	"sim1_imsi" varchar(25) COLLATE "default",
	"sim1_iccid" varchar(25) COLLATE "default",
	"sim2_imei" varchar(25) COLLATE "default",
	"sim2_msisdn" varchar(25) COLLATE "default",
	"sim2_imsi" varchar(25) COLLATE "default",
	"sim2_iccid" varchar(25) COLLATE "default",
	"gsm_cell_id" varchar(11) COLLATE "default",
	"gsm_location_area_code" varchar(8) COLLATE "default",
	"payphone_device_id" int8,
	"payphone_version" varchar(255) COLLATE "default",
	"session_id" int4 NOT NULL,
	"hostname" varchar(255) COLLATE "default",
	"origin_ip_address" varchar(16) NOT NULL COLLATE "default",
	"result_code" int2,
	"search_key" varchar(255) COLLATE "default",
	"realm_id" int4,
	"app_cuser" varchar(255) COLLATE "default",
	"app_muser" varchar(255) COLLATE "default",
	"app_cdate" timestamp(6) NULL,
	"app_mdate" timestamp(6) NULL,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int4 NOT NULL DEFAULT 1
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."authentication_attempts" OWNER TO "postgres";

-- ----------------------------
--  Table structure for modulations
-- ----------------------------
DROP TABLE IF EXISTS "public"."modulations";
CREATE TABLE "public"."modulations" (
	"id" int8 NOT NULL DEFAULT nextval('modulations_id_seq'::regclass),
	"name" varchar(55) DEFAULT 'mod'::character varying COLLATE "default",
	"days" varchar COLLATE "default",
	"modulation_type_id" int8,
	"end_time" int2 NOT NULL,
	"profile_id" int8,
	"tariff_version_id" int8,
	"app_cuser" varchar(50) COLLATE "default",
	"app_muser" varchar(50) COLLATE "default",
	"app_cdate" timestamp(6) NULL,
	"app_mdate" timestamp(6) NULL,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int2,
	"version" int2 NOT NULL DEFAULT 1,
	"search_key" varchar(10) COLLATE "default",
	"group_id" int8
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."modulations" OWNER TO "postgres";

-- ----------------------------
--  Table structure for groups
-- ----------------------------
DROP TABLE IF EXISTS "public"."groups";
CREATE TABLE "public"."groups" (
	"id" int8 NOT NULL DEFAULT nextval('groups_id_seq'::regclass),
	"name" varchar(50) COLLATE "default",
	"search_key" varchar(50) COLLATE "default",
	"realm_id" int4,
	"app_cuser" varchar(50) COLLATE "default",
	"app_muser" varchar(50) COLLATE "default",
	"app_cdate" timestamp(6) NULL,
	"app_mdate" timestamp(6) NULL,
	"enum_status_id" int2 NOT NULL DEFAULT 1,
	"unique_control" int8,
	"version" int2 NOT NULL DEFAULT 1,
	"tariff_version_id" int8,
	"description" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE);
ALTER TABLE "public"."groups" OWNER TO "postgres";


-- ----------------------------
--  Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."authentication_attempts_id_seq" RESTART 460 OWNED BY "authentication_attempts"."id";
ALTER SEQUENCE "public"."groups_id_seq" RESTART 106 OWNED BY "groups"."id";
ALTER SEQUENCE "public"."modulation_types_id_seq" RESTART 3 OWNED BY "modulation_types"."id";
ALTER SEQUENCE "public"."modulations_id_seq" RESTART 51 OWNED BY "modulations"."id";
ALTER SEQUENCE "public"."ongoing_service_detail_records_id_seq" RESTART 309 OWNED BY "ongoing_service_detail_records"."id";
ALTER SEQUENCE "public"."ongoing_session_detail_records_id_seq" RESTART 460 OWNED BY "ongoing_session_detail_records"."id";
ALTER SEQUENCE "public"."payphone_configurations_id_seq" RESTART 3 OWNED BY "payphone_configurations"."id";
ALTER SEQUENCE "public"."payphone_global_cfg_id_seq" RESTART 3 OWNED BY "payphone_global_cfg"."id";
ALTER SEQUENCE "public"."payphone_services_id_seq" RESTART 118 OWNED BY "payphone_services"."id";
ALTER SEQUENCE "public"."payphone_versions_id_seq" RESTART 55 OWNED BY "payphone_versions"."id";
ALTER SEQUENCE "public"."prefixes_id_seq" RESTART 48 OWNED BY "prefixes"."id";
ALTER SEQUENCE "public"."profiles_id_seq" RESTART 3 OWNED BY "profiles"."id";
ALTER SEQUENCE "public"."sims_id_seq" RESTART 3 OWNED BY "sims"."id";
ALTER SEQUENCE "public"."sims_payphone_id_seq" RESTART 3 OWNED BY "sims"."payphone_id";
ALTER SEQUENCE "public"."special_days_id_seq" RESTART 67 OWNED BY "special_days"."id";
ALTER SEQUENCE "public"."tariff_versions_id_seq" RESTART 35 OWNED BY "tariff_versions"."id";
ALTER SEQUENCE "public"."tariffs_id_seq" RESTART 45 OWNED BY "tariffs"."id";
ALTER SEQUENCE "public"."zones_id_seq" RESTART 71 OWNED BY "zones"."id";
-- ----------------------------
--  Primary key structure for table sims
-- ----------------------------
ALTER TABLE "public"."sims" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table sims
-- ----------------------------
ALTER TABLE "public"."sims" ADD CONSTRAINT "sims_iccid" UNIQUE ("iccid") NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."sims" ADD CONSTRAINT "sims_imsi" UNIQUE ("imsi") NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."sims" ADD CONSTRAINT "sims_msisdn" UNIQUE ("msisdn") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table payphone_services
-- ----------------------------
ALTER TABLE "public"."payphone_services" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table payphone_services
-- ----------------------------
ALTER TABLE "public"."payphone_services" ADD CONSTRAINT "payphone_service_username" UNIQUE ("username") NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."payphone_services" ADD CONSTRAINT "payphone_sim1_msisdn" UNIQUE ("sim1_msisdn") NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."payphone_services" ADD CONSTRAINT "payphone_sim2_msisdn" UNIQUE ("sim2_msisdn") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table payphone_services
-- ----------------------------
CREATE INDEX  "service_id" ON "public"."payphone_services" USING btree("id" ASC NULLS LAST);

-- ----------------------------
--  Uniques structure for table payphone_configurations
-- ----------------------------
ALTER TABLE "public"."payphone_configurations" ADD CONSTRAINT "payphone_configurations_preferred_msisdn_key" UNIQUE ("preferred_msisdn") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table zones
-- ----------------------------
ALTER TABLE "public"."zones" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table zones
-- ----------------------------
ALTER TABLE "public"."zones" ADD CONSTRAINT "zone_name" UNIQUE ("name","group_id","tariff_version_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table zones
-- ----------------------------
CREATE UNIQUE INDEX  "zones_id_enum_status_id_key" ON "public"."zones" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table profiles
-- ----------------------------
ALTER TABLE "public"."profiles" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table payphone_versions
-- ----------------------------
ALTER TABLE "public"."payphone_versions" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table prefixes
-- ----------------------------
ALTER TABLE "public"."prefixes" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table prefixes
-- ----------------------------
ALTER TABLE "public"."prefixes" ADD CONSTRAINT "prefix_value" UNIQUE ("value","country","tariff_version_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table payphone_global_cfg
-- ----------------------------
ALTER TABLE "public"."payphone_global_cfg" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table ongoing_service_detail_records
-- ----------------------------
ALTER TABLE "public"."ongoing_service_detail_records" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table modulation_types
-- ----------------------------
ALTER TABLE "public"."modulation_types" ADD CONSTRAINT "modulation_types.id" UNIQUE ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table tariffs
-- ----------------------------
ALTER TABLE "public"."tariffs" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table tariff_versions
-- ----------------------------
ALTER TABLE "public"."tariff_versions" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table tariff_versions
-- ----------------------------
CREATE UNIQUE INDEX  "tariff_versions_id_enum_status_id_key" ON "public"."tariff_versions" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table ongoing_session_detail_records
-- ----------------------------
ALTER TABLE "public"."ongoing_session_detail_records" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table ongoing_session_detail_records
-- ----------------------------
ALTER TABLE "public"."ongoing_session_detail_records" ADD CONSTRAINT "msisdn" UNIQUE ("payphone_device_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table payphone_devices
-- ----------------------------
ALTER TABLE "public"."payphone_devices" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table payphone_devices
-- ----------------------------
ALTER TABLE "public"."payphone_devices" ADD CONSTRAINT "payphone_imei" UNIQUE ("imei1") NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."payphone_devices" ADD CONSTRAINT "payphone_mac" UNIQUE ("mac") NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."payphone_devices" ADD CONSTRAINT "payphone_serial_no" UNIQUE ("serial_no") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Primary key structure for table authentication_attempts
-- ----------------------------
ALTER TABLE "public"."authentication_attempts" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table modulations
-- ----------------------------
CREATE UNIQUE INDEX  "modulations_group_id_enum_status_id_key" ON "public"."modulations" USING btree(group_id ASC NULLS LAST, enum_status_id ASC NULLS LAST);

-- ----------------------------
--  Primary key structure for table groups
-- ----------------------------
ALTER TABLE "public"."groups" ADD PRIMARY KEY ("id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Uniques structure for table groups
-- ----------------------------
ALTER TABLE "public"."groups" ADD CONSTRAINT "group_name" UNIQUE ("name","tariff_version_id") NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Indexes structure for table groups
-- ----------------------------
CREATE UNIQUE INDEX  "groups_id_enum_status_id_key" ON "public"."groups" USING btree("id" ASC NULLS LAST, enum_status_id ASC NULLS LAST);

-- ----------------------------
--  Foreign keys structure for table zones
-- ----------------------------
ALTER TABLE "public"."zones" ADD CONSTRAINT "fk_zones_tariff_version" FOREIGN KEY ("tariff_version_id") REFERENCES "public"."tariff_versions" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."zones" ADD CONSTRAINT "fk_zone_group" FOREIGN KEY ("group_id") REFERENCES "public"."groups" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table prefixes
-- ----------------------------
ALTER TABLE "public"."prefixes" ADD CONSTRAINT "fk_prefixes_tariff_version" FOREIGN KEY ("tariff_version_id") REFERENCES "public"."tariff_versions" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."prefixes" ADD CONSTRAINT "fk_prefix" FOREIGN KEY ("zone_id") REFERENCES "public"."zones" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table ongoing_service_detail_records
-- ----------------------------
ALTER TABLE "public"."ongoing_service_detail_records" ADD CONSTRAINT "fk_call_records_session" FOREIGN KEY ("session_id") REFERENCES "public"."ongoing_session_detail_records" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."ongoing_service_detail_records" ADD CONSTRAINT "fk_service_record_profile" FOREIGN KEY ("profile_id") REFERENCES "public"."profiles" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."ongoing_service_detail_records" ADD CONSTRAINT "fk_ongoing_service_detail_records_tarrif" FOREIGN KEY ("tariff_id") REFERENCES "public"."tariffs" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table modulation_types
-- ----------------------------
ALTER TABLE "public"."modulation_types" ADD CONSTRAINT "fk_tariff_version_id" FOREIGN KEY ("tariff_version_id") REFERENCES "public"."tariff_versions" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table tariffs
-- ----------------------------
ALTER TABLE "public"."tariffs" ADD CONSTRAINT "fk_tarrif_modulation" FOREIGN KEY ("modulation_type_id") REFERENCES "public"."modulation_types" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."tariffs" ADD CONSTRAINT "fk_tarrif_group" FOREIGN KEY ("group_id") REFERENCES "public"."groups" ("id") ON UPDATE CASCADE ON DELETE CASCADE NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table ongoing_session_detail_records
-- ----------------------------
ALTER TABLE "public"."ongoing_session_detail_records" ADD CONSTRAINT "fk_session_detail_profile" FOREIGN KEY ("profile_id") REFERENCES "public"."profiles" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table payphone_devices
-- ----------------------------
ALTER TABLE "public"."payphone_devices" ADD CONSTRAINT "fk_payphones_payphone_version_id" FOREIGN KEY ("payphone_version_id") REFERENCES "public"."payphone_versions" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."payphone_devices" ADD CONSTRAINT "fk_payphone_services" FOREIGN KEY ("id") REFERENCES "public"."payphone_services" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table authentication_attempts
-- ----------------------------
ALTER TABLE "public"."authentication_attempts" ADD CONSTRAINT "fk_authentication_attempts_session" FOREIGN KEY ("session_id") REFERENCES "public"."ongoing_session_detail_records" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."authentication_attempts" ADD CONSTRAINT "fk_authentication_attempts_payphone" FOREIGN KEY ("payphone_device_id") REFERENCES "public"."payphone_devices" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table modulations
-- ----------------------------
ALTER TABLE "public"."modulations" ADD CONSTRAINT "fk_modulation_type" FOREIGN KEY ("modulation_type_id") REFERENCES "public"."modulation_types" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."modulations" ADD CONSTRAINT "fk_tariff_version" FOREIGN KEY ("tariff_version_id") REFERENCES "public"."tariff_versions" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

-- ----------------------------
--  Foreign keys structure for table groups
-- ----------------------------
ALTER TABLE "public"."groups" ADD CONSTRAINT "fk_groups_tariff_version" FOREIGN KEY ("tariff_version_id", "enum_status_id") REFERENCES "public"."tariff_versions" ("id", "enum_status_id") ON UPDATE CASCADE ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE "public"."groups" ADD CONSTRAINT "fk_group_modulation" FOREIGN KEY ("id", "enum_status_id") REFERENCES "public"."modulations" ("group_id", "enum_status_id") ON UPDATE CASCADE ON DELETE NO ACTION NOT DEFERRABLE INITIALLY IMMEDIATE;

