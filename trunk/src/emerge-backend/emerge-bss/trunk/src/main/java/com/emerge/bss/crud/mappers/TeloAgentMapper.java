/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.crud.mappers;

import io.swagger.model.TeloAgents;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Kolade Arowolo
 */
public class TeloAgentMapper implements ResultSetMapper <TeloAgents> {
//    public static TeloAgents getTeloAgent(Map < String, Object > map) {
//    TeloAgents teloAgent = new TeloAgents();
//    teloAgent.setBalance(Double.parseDouble(map.get("balance").toString()));
//    teloAgent.setPrepaidServiceId(Long.parseLong(map.get("prepaid_service_id").toString()));
//    System.out.println(teloAgent);
//    return teloAgent;
//  }

    @Override
    public TeloAgents map(int i, ResultSet rs, StatementContext sc) throws SQLException {
         TeloAgents teloAgent = new TeloAgents();
         teloAgent.setBalance(rs.getDouble("balance"));
         teloAgent.setPrepaidServiceId(rs.getLong("prepaid_service_id"));
         return teloAgent;
    }
    
}
