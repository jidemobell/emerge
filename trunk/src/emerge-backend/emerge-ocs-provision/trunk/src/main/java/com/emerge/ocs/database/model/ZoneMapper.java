/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;


import com.emerge.ocs.rest.model.Groups;
import com.emerge.ocs.rest.model.Zones;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Yusuf
 */
public class ZoneMapper implements ResultSetMapper<Zones> {
      public Zones map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        Zones zones = new Zones();
        zones.setDescription(r.getString("description"));
        zones.setId(r.getLong("id"));
        zones.setName(r.getString("name"));
        zones.setGroupId(r.getLong("group_id"));
        return zones;
    }
}
