/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.database.elastic.model.Session;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;


/**
 *
 * @author admin
 */
public class SessionMapper implements ResultSetMapper<Session>{
    public Session map(int index, ResultSet r, StatementContext ctx) throws SQLException
  {
    Session session = new Session();
    session.setId(r.getInt("id"));
    session.setAccessToken(r.getString("access_token"));
    session.setPayphoneDeviceId(r.getInt("payphone_device_id"));
    session.setProfileId(r.getInt("profile_id"));
    session.setTotalCost(r.getInt("total_cost"));
    session.setTotalCallDuration(r.getFloat("total_call_duration"));
    session.setTotalBilledTime(r.getFloat("total_billed_time"));
    session.setTotalBilledAmount(r.getFloat("total_billed_amount"));
    session.setTotalServiceDuration(r.getFloat("total_service_duration"));
    session.setSessionDuration(r.getFloat("session_duration"));
    //session.setSessionBeginTime(r.getDate("session_begin_time"));
    //session.setSessionEndTime(r.getDate("session_end_time"));
    session.setEndCause(r.getInt("end_cause"));
    session.setRemainingCredit(r.getFloat("remaining_credit"));
    session.setNumberOfServices(r.getInt("number_of_services"));
    session.setPayphoneBalance(r.getFloat("payphone_balance"));
    session.setMaximumAmountToSpend(r.getFloat("maximum_amount_to_spend"));
    session.setSearchKey(r.getString("search_key"));
    session.setRealmId(r.getInt("realm_id"));
    session.setAppMuser(r.getString("app_muser"));
    session.setAppCuser(r.getString("app_cuser"));
    //session.setAppCdate(r.getDate("app_cdate"));
    //session.setAppMdate(r.getDate("app_mdate"));
    session.setEnumStatusId(r.getInt("enum_status_id"));
    session.setUniqueControl(r.getInt("unique_control"));
    session.setVersion(r.getInt("version"));
    

    return session;
  }
    
}
