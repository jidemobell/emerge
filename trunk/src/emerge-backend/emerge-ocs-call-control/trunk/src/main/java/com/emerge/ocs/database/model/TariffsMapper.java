/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.database.elastic.model.Tariffs;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author admin
 */
public class TariffsMapper implements ResultSetMapper<Tariffs>{
    public Tariffs map(int index, ResultSet r, StatementContext ctx) throws SQLException
  {
    Tariffs tariffs = new Tariffs();
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
    tariffs.setRecurrentDuration (r.getInt("recurrent_duration"));
    tariffs.setRealmId(r.getInt("realm_id"));
    tariffs.setAppMuser(r.getString("app_muser"));
    tariffs.setAppCuser(r.getString("app_cuser"));
    tariffs.setAppCdate(r.getDate("app_cdate"));
    tariffs.setAppMdate(r.getDate("app_mdate"));
    tariffs.setEnumStatusId(r.getInt("enum_status_id"));
    tariffs.setUniqueControl(r.getInt("unique_control"));
    tariffs.setVersion(r.getInt("version"));
    return tariffs;
  }
    
    
    
    
}

    

