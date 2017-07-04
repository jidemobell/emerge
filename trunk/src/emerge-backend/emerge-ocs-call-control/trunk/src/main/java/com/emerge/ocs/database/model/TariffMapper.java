/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;


/**
 *
 * @author jide
 */
public class TariffMapper implements ResultSetMapper<Tariff>{
    public Tariff map(int index, ResultSet r, StatementContext ctx) throws SQLException
  {
    Tariff tariff = new Tariff();
    tariff.setId(r.getInt("id"));
    tariff.setName(r.getString("name"));
    tariff.setGroup_id(r.getInt("group_id"));
    tariff.setInitial_duration(r.getInt("initial_duration"));
    tariff.setInitial_cost(r.getFloat("initial_cost"));
    tariff.setSetup_cost(r.getFloat("setup_cost"));
    tariff.setRecurrent_cost(r.getFloat("recurrent_cost"));
    tariff.setRecurrent_duration (r.getInt("recurrent_duration"));
    tariff.setZoneID(r.getInt("zone_id"));
    return tariff;
  }
    
    
    
    
}
