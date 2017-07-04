/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.crud.mappers;

import io.swagger.model.ContractTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Kolade Arowolo
 */
public class ContractTemplateMapper implements ResultSetMapper<ContractTemplate> {

    @Override
    public ContractTemplate map(int i, ResultSet rs, StatementContext sc) throws SQLException {

        ContractTemplate ct = new ContractTemplate();
        ct.setContent(rs.getString("content"));
        ct.setContractTemplateId(rs.getLong("id"));
        ct.setCreatedBy(rs.getString("created_by"));
        ct.setName(rs.getString("name"));
        ct.setDescription(rs.getString("description"));
        ct.setContractType(ContractTemplate.ContractTypeEnum.valueOf(rs.getString("contract_type")));
        ct.setCreationDate(rs.getDate("db_cdate"));
        ct.setModificationDate(rs.getDate("db_mdate"));
//         
//        if(rs.getDate("db_mdate") != null){ct.setModificationDate(rs.getDate("db_mdate")); }
//        else{
//        ct.setModificationDate(null);
//        }
        return ct;
    }
}
