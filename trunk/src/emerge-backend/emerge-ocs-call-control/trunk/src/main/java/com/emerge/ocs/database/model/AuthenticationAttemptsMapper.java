/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.database.elastic.model.AuthenticationAttempts;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author admin
 */
public class AuthenticationAttemptsMapper implements ResultSetMapper<AuthenticationAttempts>{
    public AuthenticationAttempts map(int index, ResultSet r, StatementContext ctx) throws SQLException
  {
    AuthenticationAttempts authenticationAttempts = new AuthenticationAttempts();
    
    authenticationAttempts.setId(r.getInt("realm_id"));
    authenticationAttempts.setUsername(r.getString("username"));
    authenticationAttempts.setSim1Imei(r.getString("sim1_imei"));
    authenticationAttempts.setSim1Msisdn(r.getString("sim1_msisdn"));
    authenticationAttempts.setSim1Imsi(r.getString("sim1_imsi"));
    authenticationAttempts.setSim1Iccid(r.getString("sim1_iccid"));
    authenticationAttempts.setSim2Imei(r.getString("sim2_imei"));
    authenticationAttempts.setSim2Msisdn(r.getString("sim2_msisdn"));
    authenticationAttempts.setSim2Imsi(r.getString("sim2_imsi"));
    authenticationAttempts.setSim2Iccid(r.getString("sim2_iccid"));
    authenticationAttempts.setGsmCellId(r.getString("gsm_cell_id"));
    authenticationAttempts.setGsmLocationAreaCode(r.getString("gsm_location_area_code"));
    authenticationAttempts.setPayphoneDeviceId(r.getString("payphone_device_id"));
    authenticationAttempts.setPayphoneVersion(r.getString("payphone_version"));
    authenticationAttempts.setSessionId(r.getInt("session_id"));
    authenticationAttempts.setHostname(r.getString("hostname"));
    authenticationAttempts.setOriginIpAddress(r.getString("origin_ip_address"));
    authenticationAttempts.setResultCode(r.getInt("result_code"));
    authenticationAttempts.setSearchKey(r.getString("search_key"));
    authenticationAttempts.setRealmId(r.getInt("realm_id"));
    authenticationAttempts.setAppMuser(r.getString("app_muser"));
    authenticationAttempts.setAppCuser(r.getString("app_cuser"));
    //authenticationAttempts.setAppCdate(r.getDate("app_cdate"));
    //authenticationAttempts.setAppMdate(r.getDate("app_mdate"));
    authenticationAttempts.setEnumStatusId(r.getInt("enum_status_id"));
    authenticationAttempts.setUniqueControl(r.getInt("unique_control"));
    authenticationAttempts.setVersion(r.getInt("version"));
    

    return authenticationAttempts;
  }
    
    
    
}
