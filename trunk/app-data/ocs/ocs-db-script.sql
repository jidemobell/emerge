ALTER TABLE "ongoing_service_detail_records" DROP CONSTRAINT "fk_call_records_session";
ALTER TABLE "authentication_attempts" DROP CONSTRAINT "fk_authentication_attempts_session";
ALTER TABLE "group_zones" DROP CONSTRAINT "fk_group_zones_group";
ALTER TABLE "group_zones" DROP CONSTRAINT "fk_group_zones_zone";
ALTER TABLE "authentication_attempts" DROP CONSTRAINT "fk_authentication_attempts_payphone";
ALTER TABLE "prefixes" DROP CONSTRAINT "fk_prefix";
ALTER TABLE "zones" DROP CONSTRAINT "fk_zone_group";
ALTER TABLE "tariffs" DROP CONSTRAINT "fk_tarrif_group";
ALTER TABLE "tariffs" DROP CONSTRAINT "fk_tarrif_modulation";
ALTER TABLE "modulations" DROP CONSTRAINT "fk_modulation_type";
ALTER TABLE "payphone_devices" DROP CONSTRAINT "fk_payphones_payphone_version_id";
ALTER TABLE "payphone_devices" DROP CONSTRAINT "fk_payphone_services";
ALTER TABLE "ongoing_service_detail_records" DROP CONSTRAINT "fk_service_record_profile";
ALTER TABLE "ongoing_session_detail_records" DROP CONSTRAINT "fk_session_detail_profile";
ALTER TABLE "modulations" DROP CONSTRAINT "fk_tariff_version";
ALTER TABLE "modulation_types" DROP CONSTRAINT "fk_tariff_version_id";
ALTER TABLE "ongoing_service_detail_records" DROP CONSTRAINT "fk_ongoing_service_detail_records_tarrif";
ALTER TABLE "prefixes" DROP CONSTRAINT "fk_prefixes_tariff_version";
ALTER TABLE "zones" DROP CONSTRAINT "fk_zones_tariff_version";
ALTER TABLE "groups" DROP CONSTRAINT "fk_groups_tariff_version";

DROP INDEX "service_id";

ALTER TABLE "prefixes" DROP CONSTRAINT "prefix_id";
ALTER TABLE "prefixes" DROP CONSTRAINT "prefix_value";
ALTER TABLE "tariffs" DROP CONSTRAINT "tarrif_initial_cost";
ALTER TABLE "tariffs" DROP CONSTRAINT "tarrif_ recurrent_cost";
ALTER TABLE "tariffs" DROP CONSTRAINT "tarrif_initial_duration";
ALTER TABLE "tariffs" DROP CONSTRAINT "tarrif_ recurrent_duration";
ALTER TABLE "tariffs" DROP CONSTRAINT "tarrif_id";
ALTER TABLE "groups" DROP CONSTRAINT "group_id";
ALTER TABLE "groups" DROP CONSTRAINT "group_name";
ALTER TABLE "zones" DROP CONSTRAINT "zone_id";
ALTER TABLE "zones" DROP CONSTRAINT "zone_name";
ALTER TABLE "payphone_devices" DROP CONSTRAINT "payphone_id";
ALTER TABLE "payphone_devices" DROP CONSTRAINT "payphone_imei";
ALTER TABLE "payphone_devices" DROP CONSTRAINT "payphone_mac";
ALTER TABLE "payphone_devices" DROP CONSTRAINT "payphone_serial_no";
ALTER TABLE "ongoing_session_detail_records" DROP CONSTRAINT "msisdn";
ALTER TABLE "modulation_types" DROP CONSTRAINT "modulation_types.id";
ALTER TABLE "payphone_services" DROP CONSTRAINT "payphone_service_username";
ALTER TABLE "payphone_services" DROP CONSTRAINT "payphone_service_id";

DROP TABLE "prefixes";
DROP TABLE "tariffs";
DROP TABLE "groups";
DROP TABLE "zones";
DROP TABLE "payphone_devices";
DROP TABLE "ongoing_service_detail_records";
DROP TABLE "authentication_attempts";
DROP TABLE "ongoing_session_detail_records";
DROP TABLE "group_zones";
DROP TABLE "payphone_versions";
DROP TABLE "modulation_types";
DROP TABLE "modulations";
DROP TABLE "special_days";
DROP TABLE "payphone_services";
DROP TABLE "profiles";
DROP TABLE "tariff_versions";
DROP TABLE "payphone_global_cfg";

CREATE TABLE "prefixes" (
"id" serial8 NOT NULL,
"value" int4 NOT NULL,
"zone_id" int8,
"country" varchar(100),
"search_key" varchar(255),
"realm_id" int4,
"app_cuser" varchar(50),
"app_muser" varchar(50),
"app_cdate" timestamp,
"app_mdate" timestamp,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int2 NOT NULL DEFAULT 1,
"tariff_version_id" int8 NOT NULL,
"description" varchar(255),
PRIMARY KEY ("id") ,
CONSTRAINT "prefix_id" UNIQUE ("id"),
CONSTRAINT "prefix_value" UNIQUE ("value")
);

CREATE TABLE "tariffs" (
"id" serial8 NOT NULL,
"name" varchar(50) NOT NULL,
"group_id" int8,
"modulation_type_id" int8,
"initial_duration" decimal(255) NOT NULL,
"initial_cost" decimal(50) NOT NULL,
"setup_cost" decimal(50),
"recurrent_cost" decimal(50) NOT NULL,
"recurrent_duration" decimal(255) NOT NULL,
"tariff_version_id" int8,
"profile_id" int8 NOT NULL,
"status" bool NOT NULL,
"realm_id" int4,
"app_cuser" varchar(50),
"app_muser" varchar(50),
"app_cdate" timestamp,
"app_mdate" timestamp,
"search_key" varchar(50),
"unique_control" int8,
"version" int4 NOT NULL DEFAULT 1,
"enum_status_id" int2 NOT NULL,
PRIMARY KEY ("id") ,
CONSTRAINT "tarrif_initial_cost" UNIQUE ("initial_cost"),
CONSTRAINT "tarrif_ recurrent_cost" UNIQUE ("recurrent_cost"),
CONSTRAINT "tarrif_initial_duration" UNIQUE ("initial_duration"),
CONSTRAINT "tarrif_ recurrent_duration" UNIQUE ("recurrent_duration"),
CONSTRAINT "tarrif_id" UNIQUE ("id")
);

CREATE TABLE "groups" (
"id" serial8 NOT NULL,
"name" varchar(50),
"search_key" varchar(50),
"realm_id" int4,
"app_cuser" varchar(50),
"app_muser" varchar(50),
"app_cdate" timestamp,
"app_mdate" timestamp,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int2 NOT NULL DEFAULT 1,
"tariff_version_id" int8,
"description" varchar(255),
PRIMARY KEY ("id") ,
CONSTRAINT "group_id" UNIQUE ("id"),
CONSTRAINT "group_name" UNIQUE ("name")
);

CREATE TABLE "zones" (
"id" serial8 NOT NULL,
"name" varchar(50) NOT NULL,
"group_id" int8,
"search_key" varchar(255),
"realm_id" int,
"app_cuser" varchar(50),
"app_muser" varchar(50),
"app_cdate" timestamp,
"app_mdate" timestamp,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int4,
"version" int2 NOT NULL DEFAULT 1,
"tariff_version_id" int8 NOT NULL,
"description" varchar(255),
PRIMARY KEY ("id") ,
CONSTRAINT "zone_id" UNIQUE ("id"),
CONSTRAINT "zone_name" UNIQUE ("name")
);

CREATE TABLE "payphone_devices" (
"id" int8 NOT NULL,
"imei1" varchar(30) NOT NULL,
"imei2" varchar(30) NOT NULL,
"serial_no" varchar(62) NOT NULL,
"mac" varchar(24) NOT NULL,
"default_language" varchar(20) NOT NULL,
"payphone_version_id" int8 NOT NULL,
"silence_mode" bool,
"send_errors_to_ocs" int4,
"search_key" varchar(255),
"realm_id" int4,
"app_cuser" varchar(255),
"app_muser" varchar(255),
"app_cdate" timestamp(10),
"app_mdate" timestamp(10),
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int2 NOT NULL DEFAULT 1,
"deleted_reason" varchar(255),
PRIMARY KEY ("id") ,
CONSTRAINT "payphone_id" UNIQUE ("id"),
CONSTRAINT "payphone_imei" UNIQUE ("imei1"),
CONSTRAINT "payphone_mac" UNIQUE ("mac"),
CONSTRAINT "payphone_serial_no" UNIQUE ("serial_no")
);

COMMENT ON COLUMN "payphone_devices"."default_language" IS 'Enum — EN, PT, FR';

CREATE TABLE "ongoing_service_detail_records" (
"id" serial8 NOT NULL,
"hostname" varchar(255),
"payphone_device_id" int8,
"origin_msisdn" varchar(255),
"destination_msisdn" varchar(255),
"destination_group" varchar(255),
"tariff_id" int8 NOT NULL,
"call_authorization_time" timestamptz(10),
"start_time" timestamptz(10),
"call_answer_time" timestamptz(10),
"call_end_time" timestamptz(10),
"call_duration" int8,
"billed_duration" int8,
"billed_amount" float8,
"initial_balance" float8,
"end_cause" varchar(255),
"end_balance" float8,
"session_id" int8 NOT NULL,
"search_key" varchar(15),
"realm_id" int4,
"app_cuser" varchar(255),
"app_muser" varchar(255),
"app_cdate" timestamptz(10),
"app_mdate" timestamptz(10),
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int4 DEFAULT 1,
"profile_id" int8 NOT NULL,
PRIMARY KEY ("id") 
);

CREATE TABLE "authentication_attempts" (
"id" serial8 NOT NULL,
"username" varchar(255),
"sim1_imei" varchar(25),
"sim1_msisdn" varchar(25),
"sim1_imsi" varchar(25),
"sim1_iccid" varchar(25),
"sim2_imei" varchar(25),
"sim2_msisdn" varchar(25),
"sim2_imsi" varchar(25),
"sim2_iccid" varchar(25),
"gsm_cell_id" varchar(11),
"gsm_location_area_code" varchar(8),
"payphone_device_id" int8,
"payphone_version" varchar(255),
"session_id" int4 NOT NULL,
"hostname" varchar(255),
"origin_ip_address" varchar(16) NOT NULL,
"result_code" int2,
"search_key" varchar(255),
"realm_id" int4,
"app_cuser" varchar(255),
"app_muser" varchar(255),
"app_cdate" timestamp,
"app_mdate" timestamp,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int4 NOT NULL DEFAULT 1,
PRIMARY KEY ("id") 
);

CREATE TABLE "ongoing_session_detail_records" (
"id" serial8 NOT NULL,
"access_token" varchar(255),
"payphone_device_id" int8 NOT NULL,
"total_cost" float8,
"total_call_duration" float8,
"total_billed_time" float8,
"total_billed_amount" float8,
"total_service_duration" float8,
"session_duration" float8,
"session_begin_time" timestamptz(10),
"session_end_time" timestamptz(10),
"end_cause" varchar(255),
"remaining_credit" float8,
"number_of_services" int4,
"payphone_balance" float8,
"maximum_amount_to_spend" float8,
"search_key" varchar(255),
"realm_id" int4,
"app_muser" varchar,
"app_cuser" varchar(255),
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int4 NOT NULL DEFAULT 1,
"profile_id" int8 NOT NULL,
PRIMARY KEY ("id") ,
CONSTRAINT "msisdn" UNIQUE ("payphone_device_id")
);

COMMENT ON COLUMN "ongoing_session_detail_records"."total_cost" IS '1: active 2: Inactive 3: Inprogress 4: dropped ';
COMMENT ON COLUMN "ongoing_session_detail_records"."end_cause" IS 'Enum value of the possible end causes';

CREATE TABLE "group_zones" (
"id" serial8 NOT NULL,
"group_id" int8,
"zone_id" int8,
PRIMARY KEY ("id") 
);

CREATE TABLE "payphone_versions" (
"id" serial8 NOT NULL,
"major" int8,
"minor" int8,
"patch" int8,
"status" varchar(50),
"expiry" timestamp(255),
"realm_id" int4,
"app_muser" varchar,
"app_cuser" varchar(255),
"app_cdate" timestamp,
"app_mdate" timestamp,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int8,
"version" int4 NOT NULL DEFAULT 1,
PRIMARY KEY ("id") 
);

CREATE TABLE "modulation_types" (
"id" serial8 NOT NULL,
"name" varchar(10) NOT NULL,
"realm_id" int4,
"tariff_version_id" int8 NOT NULL,
"profile_id" int8 NOT NULL,
"description" varchar(255),
"enum_status_id" int2 NOT NULL DEFAULT 1,
"app_cuser" varchar(50),
"app_muser" varchar(50),
"app_mdate" timestamp,
"app_cdate" timestamp,
"unique_control" int4,
"version" int2 NOT NULL DEFAULT 1,
"seach_key" varchar(10),
CONSTRAINT "modulation_types.id" UNIQUE ("id")
);

CREATE TABLE "modulations" (
"id" serial8,
"name" varchar(55) DEFAULT 'mod',
"days" int8,
"modulation_type_id" int8,
"end_time" int2 NOT NULL,
"profile_id" int8,
"tariff_version_id" int8,
"app_cuser" varchar(50),
"app_muser" varchar(50),
"app_cdate" timestamp,
"app_mdate" timestamp,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"unique_control" int2,
"version" int2 NOT NULL DEFAULT 1,
"search_key" varchar(10)
);

CREATE TABLE "special_days" (
"id" serial8,
"day" int2 NOT NULL,
"month" int2 NOT NULL,
"year" int4,
"realm_id" int4,
"app_cuser" varchar(255),
"app_muser" varchar(255),
"app_cdate" timestamp,
"app_mdate" timestamp,
"unique_control" varchar(255),
"version" int2 NOT NULL DEFAULT 1,
"description" varchar(255),
"search_key" varchar(10),
"enum_status_id" int2 NOT NULL DEFAULT 1
);

CREATE TABLE "payphone_services" (
"id" serial8 NOT NULL,
"status" varchar(15) NOT NULL DEFAULT 'INACTIVE',
"profile_id" int8 NOT NULL,
"contract_id" int8 NOT NULL,
"sim1_msisdn" varchar(255),
"sim1_imsi" varchar(255),
"sim1_iccid" varchar(255),
"sim2_msisdn" varchar(255),
"sim2_imsi" varchar(255),
"sim2_iccid" varchar(255),
"balance" float8 NOT NULL DEFAULT 0,
"username" varchar(25) NOT NULL,
"password" text NOT NULL,
"keep_alive_interval" int4 NOT NULL,
"preferred_msisdn" varchar(15),
"status_date" date,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"app_cuser" varchar(15),
"app_muser" varchar(15),
"db_cuser" varchar(15),
"db_muser" varchar(255),
"db_cdate" timestamptz(12),
"db_mdate" timestamptz(12),
"version" int4 NOT NULL DEFAULT 1,
"search_key" varchar(15),
"unique_control" int8,
"app_cdate" timestamptz(12),
"app_mdate" timestamptz(12),
PRIMARY KEY ("id") ,
CONSTRAINT "payphone_service_username" UNIQUE ("username"),
CONSTRAINT "payphone_service_id" UNIQUE ("id")
);

CREATE INDEX "service_id" ON "payphone_services" ("id");
COMMENT ON COLUMN "payphone_services"."contract_id" IS 'Contract ID on BSS';

CREATE TABLE "profiles" (
"id" serial8 NOT NULL,
"description" varchar(255),
PRIMARY KEY ("id") 
);

CREATE TABLE "tariff_versions" (
"id" serial8 NOT NULL,
"description" text NOT NULL,
"status" varchar(15) NOT NULL DEFAULT 'INACTIVE',
"activation_date" date NOT NULL,
"enum_status_id" int2 NOT NULL DEFAULT 1,
"version" int4 NOT NULL DEFAULT 1,
"app_cdate" timestamptz,
"app_mdate" timestamptz,
"app_cuser" timestamptz(255),
"app_muser" timestamptz(255),
"unique_control" int8,
"search_key" varchar(10),
PRIMARY KEY ("id") 
);

COMMENT ON COLUMN "tariff_versions"."status" IS 'Enum — ACTIVE, INACTIVE';

CREATE TABLE "payphone_global_cfg" (
"id" serial8 NOT NULL,
"button1_label" text NOT NULL,
"button1_amount" int8 NOT NULL,
"button2_label" text NOT NULL,
"button2_amount" int8 NOT NULL,
"button3_label" text NOT NULL,
"button3_amount" int8 NOT NULL,
"button4_label" text NOT NULL,
"button4_amount" int8 NOT NULL,
"keep_alive_interval" int8 NOT NULL,
PRIMARY KEY ("id") 
);


ALTER TABLE "ongoing_service_detail_records" ADD CONSTRAINT "fk_call_records_session" FOREIGN KEY ("session_id") REFERENCES "ongoing_session_detail_records" ("id");
ALTER TABLE "authentication_attempts" ADD CONSTRAINT "fk_authentication_attempts_session" FOREIGN KEY ("session_id") REFERENCES "ongoing_session_detail_records" ("id");
ALTER TABLE "group_zones" ADD CONSTRAINT "fk_group_zones_group" FOREIGN KEY ("group_id") REFERENCES "groups" ("id");
ALTER TABLE "group_zones" ADD CONSTRAINT "fk_group_zones_zone" FOREIGN KEY ("zone_id") REFERENCES "zones" ("id");
ALTER TABLE "authentication_attempts" ADD CONSTRAINT "fk_authentication_attempts_payphone" FOREIGN KEY ("payphone_device_id") REFERENCES "payphone_devices" ("id");
ALTER TABLE "prefixes" ADD CONSTRAINT "fk_prefix" FOREIGN KEY ("zone_id") REFERENCES "zones" ("id");
ALTER TABLE "zones" ADD CONSTRAINT "fk_zone_group" FOREIGN KEY ("group_id") REFERENCES "groups" ("id");
ALTER TABLE "tariffs" ADD CONSTRAINT "fk_tarrif_group" FOREIGN KEY ("group_id") REFERENCES "groups" ("id");
ALTER TABLE "tariffs" ADD CONSTRAINT "fk_tarrif_modulation" FOREIGN KEY ("modulation_type_id") REFERENCES "modulation_types" ("id");
ALTER TABLE "modulations" ADD CONSTRAINT "fk_modulation_type" FOREIGN KEY ("modulation_type_id") REFERENCES "modulation_types" ("id");
ALTER TABLE "payphone_devices" ADD CONSTRAINT "fk_payphones_payphone_version_id" FOREIGN KEY ("payphone_version_id") REFERENCES "payphone_versions" ("id");
ALTER TABLE "payphone_devices" ADD CONSTRAINT "fk_payphone_services" FOREIGN KEY ("id") REFERENCES "payphone_services" ("id");
ALTER TABLE "ongoing_service_detail_records" ADD CONSTRAINT "fk_service_record_profile" FOREIGN KEY ("profile_id") REFERENCES "profiles" ("id");
ALTER TABLE "ongoing_session_detail_records" ADD CONSTRAINT "fk_session_detail_profile" FOREIGN KEY ("profile_id") REFERENCES "profiles" ("id");
ALTER TABLE "modulations" ADD CONSTRAINT "fk_tariff_version" FOREIGN KEY ("tariff_version_id") REFERENCES "tariff_versions" ("id");
ALTER TABLE "modulation_types" ADD CONSTRAINT "fk_tariff_version_id" FOREIGN KEY ("tariff_version_id") REFERENCES "tariff_versions" ("id");
ALTER TABLE "ongoing_service_detail_records" ADD CONSTRAINT "fk_ongoing_service_detail_records_tarrif" FOREIGN KEY ("tariff_id") REFERENCES "tariffs" ("id");
ALTER TABLE "prefixes" ADD CONSTRAINT "fk_prefixes_tariff_version" FOREIGN KEY ("tariff_version_id") REFERENCES "tariff_versions" ("id");
ALTER TABLE "zones" ADD CONSTRAINT "fk_zones_tariff_version" FOREIGN KEY ("tariff_version_id") REFERENCES "tariff_versions" ("id");
ALTER TABLE "groups" ADD CONSTRAINT "fk_groups_tariff_version" FOREIGN KEY ("tariff_version_id") REFERENCES "tariff_versions" ("id");

