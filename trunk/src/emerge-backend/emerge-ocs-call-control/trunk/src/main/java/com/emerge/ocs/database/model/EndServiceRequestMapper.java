/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.rest.model.EndServiceResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Kingsley
 */
public class EndServiceRequestMapper implements ResultSetMapper<EndServiceResponse>{
    public EndServiceResponse map(int index, ResultSet r, StatementContext ctx) throws SQLException
  {
    EndServiceResponse endServiceResponse = new EndServiceResponse();
        endServiceResponse.setOrigin(r.getString("origin_msisdn"));
        endServiceResponse.setDestination(r.getString("destination_msisdn"));
        endServiceResponse.setDestination_group(r.getString("destination_group"));
        endServiceResponse.setTariff_id(r.getInt("tariff_id"));
        endServiceResponse.setCall_authorization_time(r.getDate("call_authorization_time"));
        endServiceResponse.setStart_time(r.getDate("start_time"));
        endServiceResponse.setCall_answer_time(r.getDate("call_answer_time"));
        endServiceResponse.setCall_end_time(r.getDate("call_end_time"));
        endServiceResponse.setCall_duration(r.getInt("call_duration"));
        endServiceResponse.setBilled_duration(r.getInt("billed_duration"));
        endServiceResponse.setBilled_amount(r.getFloat("billed_amount"));
        endServiceResponse.setInitial_balance(r.getFloat("initial_balance"));

    return endServiceResponse;
  }
    
}
