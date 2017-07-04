/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

/**
 *
 * @author admin
 */
import com.emerge.ocs.database.elastic.model.OngoingServiceInformation;
import com.emerge.ocs.database.elastic.model.ServiceAndTariff;
import com.emerge.ocs.database.elastic.model.Tariffs;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

class ServiceAndTariffMapper implements ResultSetMapper<ServiceAndTariff> {

    public ServiceAndTariff map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        final ServiceAndTariff serviceAndTariff = new ServiceAndTariff();
        final OngoingServiceInformation ongoingServiceInformation = new OngoingServiceInformation();
        final Tariffs tariff = new Tariffs();
        initServiceInfo(ongoingServiceInformation, r);
        initTariffInfo(tariff, r);
        serviceAndTariff.setOngoingServiceInformation(ongoingServiceInformation);
        serviceAndTariff.setTariff(tariff);
        return serviceAndTariff;
    }

    private void initTariffInfo(Tariffs tariffs, ResultSet r) throws SQLException {
        tariffs.setId(r.getInt("id"));
        tariffs.setName(r.getString("name"));
        tariffs.setStatus(r.getBoolean("status"));
        tariffs.setSearchKey(r.getString("search_key"));
        tariffs.setGroupId(r.getInt("group_id"));
        tariffs.setModulationTypeId(r.getInt("modulation_type_id"));
        tariffs.setInitialDuration(r.getInt("initial_duration"));
        tariffs.setInitialCost(r.getFloat("initial_cost"));
        tariffs.setSetupCost(r.getFloat("setup_cost"));
        tariffs.setRecurrentCost(r.getFloat("recurrent_cost"));
        tariffs.setRecurrentDuration(r.getInt("recurrent_duration"));
        tariffs.setRealmId(r.getInt("realm_id"));
        tariffs.setAppMuser(r.getString("app_muser"));
        tariffs.setAppCuser(r.getString("app_cuser"));
        tariffs.setAppCdate(r.getDate("app_cdate"));
        tariffs.setAppMdate(r.getDate("app_mdate"));
        tariffs.setEnumStatusId(r.getInt("enum_status_id"));
        tariffs.setUniqueControl(r.getInt("unique_control"));
        tariffs.setVersion(r.getInt("version"));

    }

    private void initServiceInfo(OngoingServiceInformation ongoingServiceInformation, ResultSet r) throws SQLException {
        ongoingServiceInformation.setId(r.getInt("id"));
        ongoingServiceInformation.setHostname(r.getString("hostname"));
        ongoingServiceInformation.setPayphoneDeviceId(r.getInt("payphone_device_id"));

        ongoingServiceInformation.setDestination(r.getString("destination"));
        ongoingServiceInformation.setDestinationGroup(r.getString("destination_group"));
        ongoingServiceInformation.setTariffId(r.getInt("tariff_id"));
        ongoingServiceInformation.setCallAuthorizationTime(r.getDate("call_authorization_time"));
        ongoingServiceInformation.setStartTime(r.getDate("start_time"));
        ongoingServiceInformation.setCallAnswerTime(r.getDate("call_answer_time"));
        ongoingServiceInformation.setCallEndTime(r.getDate("call_end_time"));
        ongoingServiceInformation.setCallDuration(r.getInt("call_duration"));
        ongoingServiceInformation.setBilledDuration(r.getInt("billed_duration"));
        ongoingServiceInformation.setBilledAmount(r.getFloat("billed_amount"));
        ongoingServiceInformation.setInitialBalance(r.getFloat("initial_balance"));
        ongoingServiceInformation.setRealmId(r.getInt("realm_id"));
        ongoingServiceInformation.setAppMuser(r.getString("app_muser"));
        ongoingServiceInformation.setAppCuser(r.getString("app_cuser"));
        ongoingServiceInformation.setAppCdate(r.getDate("app_cdate"));
        ongoingServiceInformation.setAppMdate(r.getDate("app_mdate"));
        ongoingServiceInformation.setEnumStatusId(r.getInt("enum_status_id"));
        ongoingServiceInformation.setUniqueControl(r.getInt("unique_control"));
        ongoingServiceInformation.setVersion(r.getInt("version"));

    }

}
