/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.database.elastic.model.PayphoneDevice;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;


/**
 *
 * @author jide
 */
class PayphoneDeviceMapper implements ResultSetMapper<PayphoneDevice> {

    /**
     *
     * @param index index
     * @param r r
     * @param ctx ctx
     * @return map
     * @throws SQLException DB EXCEPTION
     */
    @Override
    public final PayphoneDevice map(final int index, final ResultSet r,
            final StatementContext ctx) throws SQLException {

    PayphoneDevice payphoneDevice = new PayphoneDevice();
    payphoneDevice.setId(r.getInt("id"));
    payphoneDevice.setImei1(r.getString("imei1"));
    payphoneDevice.setImei2(r.getString("imei2"));
    payphoneDevice.setSerialNo(r.getString("serial_no"));
    payphoneDevice.setMac(r.getString("mac"));
    payphoneDevice.setDefaultLanguage(r.getString("default_language"));
    payphoneDevice.setPayphoneVersionId(r.getString("payphone_version_id"));
    payphoneDevice.setPreferredMsisdn(r.getString("preferred_msisdn"));
    payphoneDevice.setSilenceMode(r.getBoolean("silence_mode"));
    payphoneDevice.setSendErrorsToOcs(r.getBoolean("send_errors_to_ocs"));
    payphoneDevice.setSearchKey(r.getString("search_key"));
    payphoneDevice.setRealmId(r.getInt("realm_id"));
    payphoneDevice.setAppMuser(r.getString("app_muser"));
    payphoneDevice.setAppCuser(r.getString("app_cuser"));
    payphoneDevice.setAppCdate(r.getDate("app_cdate"));
    payphoneDevice.setAppMdate(r.getDate("app_mdate"));
    payphoneDevice.setEnumStatusId(r.getInt("enum_status_id"));
    payphoneDevice.setUniqueControl(r.getInt("unique_control"));
    payphoneDevice.setVersion(r.getInt("version"));

    return payphoneDevice;
  }
}
