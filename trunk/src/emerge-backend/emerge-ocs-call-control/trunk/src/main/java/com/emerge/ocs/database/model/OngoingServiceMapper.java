/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.database.elastic.model.OngoingServiceInformation;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author jide
 */
public class OngoingServiceMapper implements ResultSetMapper<OngoingServiceInformation>{
    public OngoingServiceInformation map(int index, ResultSet r, StatementContext ctx) throws SQLException
  {
    OngoingServiceInformation ongoingServiceInformation = new OngoingServiceInformation();
     ongoingServiceInformation.setId(r.getInt("id"));
        ongoingServiceInformation.setHostname(r.getString("hostname"));
        ongoingServiceInformation.setPayphoneDeviceId(r.getInt("payphone_device_id"));
        ongoingServiceInformation.setDestination(r.getString("destination_msisdn"));
        ongoingServiceInformation.setDestinationGroup(r.getString("destination_group"));
        ongoingServiceInformation.setTariffId(r.getInt("tariff_id"));
        //ongoingServiceInformation.setCallAuthorizationTime(r.getDate("call_authorization_time"));
        //ongoingServiceInformation.setStartTime(r.getDate("start_time"));
        //ongoingServiceInformation.setCallAnswerTime(r.getDate("call_answer_time"));
        //ongoingServiceInformation.setCallEndTime(r.getDate("call_end_time"));
        ongoingServiceInformation.setCallDuration(r.getInt("call_duration"));
        ongoingServiceInformation.setBilledDuration(r.getInt("billed_duration"));
        ongoingServiceInformation.setBilledAmount(r.getFloat("billed_amount"));
        ongoingServiceInformation.setInitialBalance(r.getFloat("initial_balance"));
        ongoingServiceInformation.setRealmId(r.getInt("realm_id"));
        ongoingServiceInformation.setAppMuser(r.getString("app_muser"));
        ongoingServiceInformation.setAppCuser(r.getString("app_cuser"));
        //ongoingServiceInformation.setAppCdate(r.getDate("app_cdate"));
        //ongoingServiceInformation.setAppMdate(r.getDate("app_mdate"));
        ongoingServiceInformation.setEnumStatusId(r.getInt("enum_status_id"));
        ongoingServiceInformation.setUniqueControl(r.getInt("unique_control"));
        ongoingServiceInformation.setVersion(r.getInt("version"));
        

    return ongoingServiceInformation;
  }
    
}
