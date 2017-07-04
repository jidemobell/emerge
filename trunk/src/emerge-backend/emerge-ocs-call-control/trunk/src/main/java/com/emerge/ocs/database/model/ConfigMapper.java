/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.rest.model.ConfigData;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author kingsley
 */
public class ConfigMapper implements ResultSetMapper<ConfigData> {
    public ConfigData map(int index, ResultSet r, StatementContext ctx) throws SQLException
  {
    ConfigData configData = new ConfigData();
    configData.setSilenceMode(r.getBoolean("silence_mode"));
    configData.setSendErrorsToOCS(r.getInt("send_errors_to_ocs"));
    configData.setPreferredMSISDN(r.getString("preferred_msisdn"));
    configData.setDefaultLanguage(ConfigData.DefaultLanguageEnum.PORTUGUESE);
//    configData.setKeepAliveInterval(r.getInt("keep_alive_interval"));
    return configData;
  }

}
