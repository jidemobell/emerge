/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.crud.mappers;

import io.swagger.model.ServicePrepaid;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Kolade Arowolo
 */
public class PrepaidServiceMapper implements ResultSetMapper<ServicePrepaid> {

    private ServicePrepaid prepaidService;
    @Override
    public ServicePrepaid map(int i, ResultSet rs, StatementContext sc) throws SQLException {
      prepaidService = new ServicePrepaid();
      prepaidService.setServicePrepaidId(rs.getLong("id"));
      prepaidService.setExternalProvisionId(rs.getString("external_provision_id"));
      prepaidService.setDeletedReason(rs.getString("deleted_reason"));
      prepaidService.setServiceType(ServicePrepaid.ServiceTypeEnum.valueOf(rs.getString("service_type")));
      prepaidService.setName(rs.getString("name"));
      prepaidService.setProductId(rs.getLong("product_id"));
      prepaidService.setIsLegacy(rs.getBoolean("is_legacy"));
      prepaidService.setStatus(ServicePrepaid.StatusEnum.valueOf(rs.getString("status")));
      return prepaidService;
    }
    
    public ServicePrepaid get() {
       return prepaidService;
    }
}