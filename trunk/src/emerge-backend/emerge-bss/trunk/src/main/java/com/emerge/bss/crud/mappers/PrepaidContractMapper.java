/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.crud.mappers;

import io.swagger.model.ContractPrepaid;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Kolade Arowolo
 */
public class PrepaidContractMapper implements ResultSetMapper<ContractPrepaid> {

    @Override
    public ContractPrepaid map(int i, ResultSet rs, StatementContext sc) throws SQLException {
         ContractPrepaid prepaidContract = new ContractPrepaid();
         prepaidContract.setContent(rs.getString("content"));
         prepaidContract.setContractId(rs.getLong("id"));
         prepaidContract.setCustomerId(rs.getLong("customer_id"));
         prepaidContract.setServicePrepaid(rs.getLong("prepaid_service_id"));
         prepaidContract.setServiceType(ContractPrepaid.ServiceTypeEnum.valueOf(rs.getString("service_type")));
         prepaidContract.setStartDate(rs.getDate("start_date"));
         prepaidContract.setStatus(ContractPrepaid.StatusEnum.valueOf(rs.getString("status")));
         prepaidContract.setStatusDate(rs.getDate("status_date"));
         return prepaidContract;
    }
    
}
