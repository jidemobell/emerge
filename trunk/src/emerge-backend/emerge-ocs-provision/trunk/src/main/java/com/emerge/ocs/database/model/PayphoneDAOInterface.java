/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.rest.model.PayphoneService;
import java.util.Date;
import org.jdbi.v3.sqlobject.BindBean;
import org.jdbi.v3.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Transaction;

/**
 *
 * @author Yusuf
 */
public interface PayphoneDAOInterface {

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

    @SqlUpdate("INSERT INTO tariff_versions (description,activation_date) "
            + "VALUES (:description,:activation_date)")
    @Transaction
    @GetGeneratedKeys
    int insertIntoTariffVersions(
            @Bind("description") String description,
            @Bind("activation_date") Date activation_date
    );

    /**
     *
     * @param id
     * @return
     */

    @SqlUpdate("UPDATE payphone_services SET enum_status_id=2 WHERE id= :id")
    int deleteById(@Bind("id") long id);

    @SqlUpdate("UPDATE payphone_services SET "
            + " payhoneService.preferred_msisdn=:preferred_msisdn,"
            + "payhoneService.keep_alive_interval= :keep_alive_interval"
            + " where id = :payhoneService.id")
    int updateById(@BindBean("payhoneService") PayphoneService payphoneService);

    @SqlUpdate("UPDATE payphone_services SET password = :password "
            + " WHERE id = :id")
    int updatePayphonePassword(@Bind("id") int id,
            @Bind("password") String password);

    @SqlUpdate("UPDATE payphone_services SET username = :username ,"
            + " password = :password ," + "  sim1_msisdn = :sim1_msisdn ,"
            + " sim1_imsi = :sim1_imsi , sim2_msisdn = :sim2_msisdn , "
            + "sim2_imsi = :sim2_imsi ," + " balance = :balance , "
            + "sim1_iccid = :sim1_iccid , contract_id = :contract_id ,"
            + "sim2_iccid = :sim2_iccid , status_date = :status_date ,"
            + "preferred_msisdn = :preferred_msisdn, "
            + " status = :status , keep_alive_interval = :keep_alive_interval  WHERE id = :id ")

    int updatePayphoneById(@Bind("id") Long id,
            @Bind("username") String username,
            @Bind("password") String password,
            @Bind("sim1_msisdn") String sim1MSISDN,
            @Bind("sim1_imsi") String sim1IMSI,
            @Bind("sim2_msisdn") String sim2MSISDN,
            @Bind("sim2_imsi") String sim2IMSI,
            @Bind("balance") double sim1Balance,
            @Bind("sim1_iccid") String sim1ICCID,
            @Bind("contract_id") double contractId,
            @Bind("status") String status,
            @Bind("status_date") Date statusDate,
            @Bind("sim2_iccid") String sim2ICCID,
            @Bind("preferred_msisdn") String preferredMsisdn,
            @Bind("keep_alive_interval") long keepAliveInterval
    );

    @SqlUpdate("UPDATE payphone_services SET enum_status_id = 2 WHERE id = :id")
    int deletePayphoneById(@Bind("id") Long id);

    @SqlQuery("SELECT imei,msisdn,imsi,iccid,serialNbr,mac,username "
            + "FROM services WHERE id = :id")
    String searchById(@Bind("id") String id);

    @SqlQuery("SELECT password "
            + " FROM payphone_services WHERE id = :id")
    public String searchPasswordById(@Bind("id") long id);

    @SqlQuery("SELECT id  FROM tariff_versions where status = 'ACTIVE' ")
    int search();

    @SqlQuery("SELECT imei,msisdn,imsi,iccid,serialNbr,mac,username "
            + "FROM services where id = :id")
    String search(@Bind("offset") Long offset, @Bind("limit") Long limit,
            @Bind("payphoneId") String payphoneId,
            @Bind("customerId") String customerId,
            @Bind("accountId") String accountId,
            @Bind("username") String username,
            @Bind("serialNbr") String serialNbr,
            @Bind("mac") String mac,
            @Bind("IMEI") String imei,
            @Bind("msisdn") String msisdn,
            @Bind("iccid") String iccid,
            @Bind("status") String status);

    @SqlUpdate("UPDATE payphone_services SET balance = balance + :amountToCredit"
            + "  WHERE id = :id")
    int topUpPayphoneById(@Bind("id") long id,
            @Bind("amountToCredit") double amountToCredit);

    @SqlUpdate("UPDATE payphone_services "
            + "SET balance = :amountToCredit  WHERE id = :id")
    int setBalancePayphoneById(@Bind("id") long id,
            @Bind("amountToCredit") double amountToCredit);
    
    @SqlUpdate("UPDATE payphone_services SET status = :status WHERE id = :id")
    int disablePayphoneById(
             @Bind("id") Long id,
             @Bind("status") String status);

    void close();

}
