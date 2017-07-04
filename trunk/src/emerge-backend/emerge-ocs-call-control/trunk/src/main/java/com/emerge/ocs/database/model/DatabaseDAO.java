/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.database.elastic.model.AuthenticationAttempts;
import com.emerge.ocs.database.elastic.model.OngoingServiceInformation;
import com.emerge.ocs.database.elastic.model.PayphoneDevice;
import com.emerge.ocs.database.elastic.model.Session;
import com.emerge.ocs.database.elastic.model.ServiceAndTariff;
import com.emerge.ocs.database.model.Tariff;
import com.emerge.ocs.database.elastic.model.Tariffs;
import com.emerge.ocs.rest.model.ConfigData;
import com.emerge.ocs.rest.model.EndServiceResponse;
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
 * @author kingsley
 */
public interface DatabaseDAO {

    @SqlQuery("select a.id, b.access_token from ongoing_session_detail_records a, authentication_attempts b where a.id = :id and a.id = b.service_id")
//    @Mapper(MapMappper.class)
    List<Map> findBySessionId(@Bind("id") int id);

    @SqlQuery("SELECT EXISTS(select * from payphone_services where username =:username and password =:password"
        + " and sim1_msisdn = :sim1_msisdn and "
            + "sim2_msisdn =:sim2_msisdn"
        + " and sim1_imsi = :sim1_imsi and sim2_imsi = :sim2_imsi and sim1_iccid=:sim1_iccid and sim2_iccid=:sim2_iccid and status = 'ACTIVE')")
    public boolean isPayPhoneAuthenticated(@Bind("username") String username, @Bind("password") String password, @Bind("sim1_msisdn") String sim1_msisdn,
            @Bind("sim1_imsi") String sim1_imsi, @Bind("sim1_iccid") String sim1_iccid, @Bind("sim2_msisdn") String sim2_msisdn, @Bind("sim2_imsi") String sim2_imsi,
            @Bind("sim2_iccid") String sim2_iccid);

    @SqlQuery("SELECT EXISTS(select * from ongoing_session_detail_records where id =:id)")
    boolean isSessionExist(@Bind("id") int id);
    
    @SqlQuery("SELECT EXISTS(select * from ongoing_service_detail_records where id =:id and session_id = :session_id)")
    boolean isServiceExist(@Bind("id") int id, @Bind("session_id") int session_id);

    @SqlQuery("SELECT EXISTS(select * from payphone_devices where id = :id)")
    boolean isPayphonesExist(@Bind("id") int id);

    @SqlUpdate("UPDATE ongoing_session_detail_records SET access_token = :access_token WHERE id = :id;")
    int updateSession(@Bind("access_token") String access_token, @Bind("id") int id);

    @SqlQuery("SELECT * from ongoing_session_detail_records where payphone_device_id =:payphone_device_id")
    int getSessionID(@Bind("payphone_device_id") int payphone_device_id);

    @SqlQuery("SELECT * from ongoing_session_detail_records where id =:id")
    @Mapper(SessionMapper.class)
    Session getSessionRecord(@Bind("id") int id);
    
     @SqlQuery("SELECT * from payphone_devices where id =:id")
    @Mapper(PayphoneDeviceMapper.class)
    PayphoneDevice getDeviceRecord(@Bind("id") int id);

   

    @SqlQuery("SELECT * from authentication_attempts where session_id =:id")
    @Mapper(AuthenticationAttemptsMapper.class)
    AuthenticationAttempts getAuthenticationAttempt(@Bind("id") int id);
    
    @SqlQuery("SELECT * from ongoing_service_detail_records where session_id =:id")
    @Mapper(OngoingServiceMapper.class)
    OngoingServiceInformation getServiceRecord(@Bind("id") int id);
    
    @SqlQuery("SELECT * from tariffs where id =:id")
    @Mapper(TariffsMapper.class)
    Tariffs getTariffInfo(@Bind("id") int id);

    

    @SqlQuery("Select service.*, tariffs.* from ongoing_service_detail_records service LEFT OUTER JOIN "
            + "tariffs tariffs on service.tariff_id = tariffs.id where service.session_id"
            + " = :session_id;")
    @Mapper(ServiceAndTariffMapper.class)
    ServiceAndTariff getServiceAndTariffInfo(@Bind("session_id") int session_id);

    @SqlQuery("SELECT payphone_version_id FROM payphone_devices where id =:id")
    int getVersionID(@Bind("id") int id);
    
    @SqlQuery("SELECT t.id, t.name, t.group_id, t.initial_duration, t.initial_cost, t.setup_cost, t.recurrent_cost, t.recurrent_duration, t.tariff_version_id, t.profile_id, p.zone_id " +
"FROM tariff_versions tv " +
"JOIN modulations m " +
"ON m.days LIKE '%' || :days || '%' " +
"AND m.end_time >= :end_time " +
"AND m.profile_id = 1 " +
"AND m.enum_status_id = 1" +
"AND m.tariff_version_id = tv.id " +
"JOIN prefixes p " +
"ON tv.id = p.tariff_version_id " +
"AND p.value = :value " +
"JOIN zones z " +
"ON p.zone_id = z.id " +
"AND tv.id = z.tariff_version_id " +
"JOIN tariffs t " +
"ON z.group_id = t.group_id " +
"AND tv.id = t.tariff_version_id " +
"AND t.profile_id = 1 " +
"AND m.modulation_type_id = t.modulation_type_id " +
"AND t.enum_status_id = 1 " +
"WHERE tv.status = 'ACTIVE';")
    @Mapper(TariffMapper.class)
    Tariff getTariff(@Bind("value") int value, @Bind("days") int days, 
            @Bind("end_time") int endTime);

    @SqlQuery("SELECT status FROM payphone_versions WHERE id =:id and major = :major and minor =:minor and patch=:patch")
    String getVersionStatus(@Bind("id") int id, @Bind("major") int major, @Bind("minor") int minor, @Bind("patch") int patch);

    @SqlQuery("SELECT EXISTS(select * FROM payphone_versions WHERE id =:id and major = :major and minor =:minor and patch=:patch and expiry >= NOW())")
    boolean checkVersionExp(@Bind("id") int id, @Bind("major") int major, @Bind("minor") int minor, @Bind("patch") int patch);

    @SqlQuery("SELECT EXISTS(select * FROM payphone_devices WHERE id =:id and imei1 = :imei1 and serial_no =:serial_no and mac=:mac and imei2=:imei2)")
    boolean isPayphonChanged(@Bind("id") int id, @Bind("imei1") String imei1, @Bind("serial_no") String serial_no, @Bind("mac") String mac, @Bind("imei2") String imei2);

    @SqlQuery("SELECT id from payphone_services where username =:username and password = :password")
    int getPayphoneID(@Bind("username") String username, @Bind("password") String password);

    
    @SqlUpdate("UPDATE payphone_devices SET imei1 = :imei1, serial_no =:serial_no, mac=:mac, imei2=:imei2 WHERE id = :id;")
    int updatePayphoneDevice(@Bind("id") int id, @Bind("imei1") String imei1, @Bind("serial_no") String serial_no, @Bind("mac") String mac, @Bind("imei2") String imei2);

    @SqlQuery("SELECT balance from payphone_services where username =:username and password = :password")
    int getBalance(@Bind("username") String username, @Bind("password") String password);

     @SqlQuery("SELECT balance from payphone_services where id = :id")
    int getPayphoneBalance(@Bind("id") int id);

    
    @SqlQuery("SELECT preferred_msisdn, silence_mode, default_language, send_errors_to_ocs FROM payphone_devices WHERE id =:id")
    @Mapper(ConfigMapper.class)
    ConfigData getConfig(@Bind("id") long id);

    @SqlQuery("DELETE FROM ongoing_session_detail_records WHERE id = :id;")
    int deleteSession(@Bind("id") int id);
    
    @SqlQuery("DELETE FROM ongoing_service_detail_records WHERE session_id = :session_id;")
    int deleteService(@Bind("session_id") int  session_id);
    
    @SqlQuery("SELECT payphone_device_id FROM ongoing_session_detail_records WHERE id = :id;")
    int getPayphoneServicID(@Bind("id") int id);
    
    @SqlQuery("DELETE FROM authentication_attempts WHERE session_id = :session_id;")
    int deleteAuthenticatonAttempt(@Bind("session_id") int  session_id);

    @SqlUpdate("WITH session AS ("
            + "INSERT INTO ongoing_session_detail_records (payphone_device_id, access_token, profile_id, session_begin_time) VALUES (:payphone_device_id, :access_token, 1, NOW())"
            + "RETURNING id)"
            + " INSERT INTO authentication_attempts "
            + "( username, sim1_imei, sim1_msisdn, sim1_imsi, sim1_iccid, sim2_imei, sim2_msisdn,"
            + "sim2_imsi, sim2_iccid, payphone_device_id, payphone_version, "
            + "session_id, gsm_cell_id, gsm_location_area_code, hostname, origin_ip_address)"
            + " VALUES (:username, :sim1_imei, :sim1_msisdn, :sim1_imsi,"
            + " :sim1_iccid, :sim2_imei, :sim2_msisdn, :sim2_imsi, :sim2_iccid, :payphone_device_id, :payphone_version,"
            + " (SELECT id FROM session),"
            + ":gsm_cell_id, :gsm_location_area_code, :hostname, :origin_ip_address);"
    )
    int Authenticate(@Bind("username") String username, @Bind("sim1_imei") String sim1_imei, @Bind("sim1_msisdn") String sim1_msisdn,
            @Bind("sim1_imsi") String sim1_imsi, @Bind("sim1_iccid") String sim1_iccid,
            @Bind("sim2_imei") String sim2_imei, @Bind("sim2_msisdn") String sim2_msisdn,
            @Bind("sim2_imsi") String sim2_imsi, @Bind("sim2_iccid") String sim2_iccid,
            @Bind("payphone_device_id") int payphone_device_id, @Bind("payphone_version") String payphone_version,
            @Bind("access_token") String access_token, @Bind("gsm_cell_id") String gsm_cell_id, @Bind("gsm_location_area_code") String gsm_location_area_code,
            @Bind("hostname") String hostname, @Bind("origin_ip_address") String origin_ip_address);

    @SqlUpdate("WITH versions AS ("
            + "INSERT INTO payphone_versions (major, minor, patch, status, expiry) VALUES (:major, :minor, :patch, :status, '2020-10-10 00:00:00')"
            + "RETURNING id)"
            + "INSERT INTO payphone_devices (imei1, imei2, serial_no, mac, payphone_version_id,  "
            + "enum_status_id, silence_mode, default_language, send_errors_to_ocs, id) "
            + "VALUES (:imei1, :imei2,  "
            + ":serial_no, :mac, (SELECT id FROM versions), :enum_status_id, "
            + ":silence_mode, :default_language, :send_errors_to_ocs, :id)")
    int updatePayphone(@Bind("imei1") String imei1, @Bind("imei2") String imei2,
            @Bind("serial_no") String serial_no, @Bind("mac") String mac, @Bind("payphone_version_id") int payphone_version_id,
            @Bind("enum_status_id") int enum_status_id,
            @Bind("silence_mode") boolean silence_mode, @Bind("default_language") int default_language,
            @Bind("send_errors_to_ocs") int send_errors_to_ocs, @Bind("id") int id, @Bind("major") int major,
            @Bind("minor") int minor, @Bind("patch") int patch, @Bind("status") String status);
    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO ongoing_service_detail_records (hostname, call_duration,"
            + " origin_msisdn, destination_msisdn, destination_group, tariff_id, call_authorization_time,"
            + "session_id, enum_status_id, profile_id, payphone_device_id) VALUES (:hostname, :call_duration, "
            + ":origin_msisdn, :destination_msisdn, :destination_group, :tariff_id, NOW(),"
            + ":session_id, :enum_status_id, 1, :payphone_device_id) ")
    int createService(@Bind("hostname") String hostname, @Bind("call_duration") int call_duration,
    @Bind("origin_msisdn") String origin_msisdn, @Bind("destination_msisdn") String destination_msisdn,
    @Bind("destination_group") int destination_group, @Bind("tariff_id") int tariff_id,
    @Bind("session_id") int session_id, @Bind("enum_status_id") int enum_status_id,
    @Bind("payphone_device_id") int payphone_device_id);

    
    @SqlQuery("SELECT id from ongoing_service_detail_records where session_id =:session_id")
    int getServiceID(@Bind("session_id") int payphone_device_id);
    
    @SqlQuery("SELECT call_duration from ongoing_service_detail_records where id =:id")
    int getCallDuration(@Bind("id") int id);
    
    @SqlQuery("SELECT tariff_id from ongoing_service_detail_records where id =:id")
    int getTariffID(@Bind("id") int id);
    
    @SqlQuery("SELECT t.id, t.name, t.group_id, t.initial_duration, t.initial_cost, t.setup_cost, p.zone_id, " +
        " t.recurrent_cost, t.recurrent_duration, t.tariff_version_id, t.profile_id " +
        " FROM tariffs AS t JOIN zones AS z ON t.group_id = z.group_id JOIN prefixes AS p ON z.id = p.zone_id WHERE t.id = :id")
    @Mapper(TariffMapper.class)
    Tariff getTariffWithID(@Bind("id") int id);
    
    @SqlUpdate("UPDATE payphone_services SET balance = balance - :subtractor WHERE id = :id;")
    int debitPayphoneServiceBalance(@Bind("id") int id, @Bind("subtractor") double subtractor);

    @SqlUpdate("UPDATE payphone_services SET balance = balance + :rebalanceValue WHERE id = :id;")
    int rebalancePayphoneService(@Bind("id") int id, @Bind("rebalanceValue") double rebalanceValue);
    
    @SqlUpdate("UPDATE ongoing_service_detail_records SET call_answer_time = :call_answer_time,"
             + " start_time = :start_time, billed_duration = :billed_duration, "
             + "billed_amount = :billed_amount, initial_balance = :initial_balance WHERE id = :id;")
    int updateService(@Bind("id") int id, @Bind("call_answer_time") Date call_answer_time,
        @Bind("start_time") Date start_time, @Bind("billed_duration") int billed_duration,
        @Bind("billed_amount") double billed_amount, @Bind("initial_balance") double initial_balance);
    
    @SqlQuery("SELECT billed_amount FROM ongoing_service_detail_records WHERE id = :id")
    double getBilledAmount(@Bind("id") int id);
    
    @SqlUpdate("UPDATE ongoing_service_detail_records SET call_answer_time = :call_answer_time,"
             + " start_time = :start_time, billed_duration = :billed_duration, call_end_time = :call_end_time, "
             + "billed_amount = :billed_amount, initial_balance = :initial_balance, end_cause = :end_cause,"
            + " end_balance = :end_balance, call_duration = :call_duration WHERE id = :id;")
    int updateCallService(@Bind("id") int id, @Bind("call_answer_time") Date call_answer_time,
        @Bind("start_time") Date start_time, @Bind("billed_duration") int billed_duration,
        @Bind("billed_amount") double billed_amount, @Bind("initial_balance") double initial_balance,
        @Bind("call_end_time") Date call_end_time, @Bind("end_cause") String end_cause,
        @Bind("end_balance") double end_balance, @Bind("call_duration") int call_duration);

    @SqlQuery("SELECT payphone_device_id FROM ongoing_service_detail_records where id =:id")
    int getPayphoneID(@Bind("id") int id);
    
    @SqlQuery("SELECT balance from payphone_services where id = :id")
    double getServiceBalance(@Bind("id") int id);
    
    @SqlQuery("SELECT initial_balance from ongoing_service_detail_records where id = :id")
    double getInitServiceBalance(@Bind("id") int id);
    
    @SqlQuery("SELECT origin_msisdn, destination_msisdn, destination_group,"
            + " tariff_id, call_authorization_time, start_time, call_answer_time, call_end_time,"
            + " call_duration, billed_duration, billed_amount, initial_balance"
            + " from ongoing_service_detail_records where id =:id")
    @Mapper(EndServiceRequestMapper.class)
    EndServiceResponse getServiceResponse(@Bind("id") int id);

    /**
     *
     * @param contractId contractId
     * @param sim1MSISDN sim1MSISDN
     * @param sim1IMSI sim1IMSI
     * @param sim1ICCID sim1ICCID
     * @param sim2MSISDN sim2MSISDN
     * @param sim2IMSI sim2IMSI
     * @param sim2ICCID sim2ICCID
     * @param balance balance
     * @param username username
     * @param password password
     * @param status status
     * @param profileId profileId
     * @param preferredMSISDN preferredMSISDN
     * @param keepAliveInterval keepAliveInterval
     * @return
     */
    @SqlUpdate("INSERT INTO payphone_services (contract_id,sim1_msisdn,"
            + "sim1_imsi,sim1_iccid,sim2_msisdn,sim2_imsi,sim2_iccid,balance,"
            + "username,password,status,profile_id, preferred_msisdn, "
            + "keep_alive_interval) VALUES "
            + "(:contract_id,:sim1_msisdn,:sim1_imsi,:sim1_iccid,:sim2_msisdn"
            + ",:sim2_imsi,:sim2_iccid,:balance,:username,:password,:status,"
            + ":profile_id, :preferred_msisdn, :keep_alive_interval)")

    @GetGeneratedKeys
    int insertIntoServices(
            @Bind("contract_id") long contractId,
            @Bind("sim1_msisdn") String sim1MSISDN,
            @Bind("sim1_imsi") String sim1IMSI,
            @Bind("sim1_iccid") String sim1ICCID,
            @Bind("sim2_msisdn") String sim2MSISDN,
            @Bind("sim2_imsi") String sim2IMSI,
            @Bind("sim2_iccid") String sim2ICCID,
            @Bind("balance") double balance,
            @Bind("username") String username,
            @Bind("password") String password,
            @Bind("status") String status,
            @Bind("profile_id") long profileId,
            @Bind("preferred_msisdn") String preferredMSISDN,
            @Bind("keep_alive_interval") long keepAliveInterval
    );


}
