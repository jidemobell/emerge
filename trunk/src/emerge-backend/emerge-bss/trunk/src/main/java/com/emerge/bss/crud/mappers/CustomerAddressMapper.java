/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.crud.mappers;

import io.swagger.model.CustomerAddress;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author akin
 */
public class CustomerAddressMapper implements ResultSetMapper<CustomerAddress> {

    @Override
    public CustomerAddress map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        CustomerAddress cu = new CustomerAddress();
        cu.setAddress(r.getString("address"));
        cu.setAddressName(r.getString("address_name"));
        cu.setCustomerId(r.getLong("customer_id"));
        cu.setEmail(r.getString("email"));
        cu.setFaxNumber(r.getString("fax_number"));
        cu.setTelephoneNumber(r.getString("telephone_number"));
        cu.setId(r.getLong("id"));
        

        return cu;
    }

}
