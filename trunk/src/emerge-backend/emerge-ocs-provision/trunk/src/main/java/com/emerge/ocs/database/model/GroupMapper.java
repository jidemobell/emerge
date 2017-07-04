/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;


import com.emerge.ocs.rest.model.Groups;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Yusuf
 */
public class GroupMapper implements ResultSetMapper<Groups> {

    public Groups map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        Groups groups = new Groups();
        groups.setDescription(r.getString("description"));
        groups.setId(r.getLong("id"));
        groups.setName(r.getString("name"));
        return groups;
    }

}
