/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.rest.model.Prefix;
import com.emerge.ocs.rest.model.Zones;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Yusuf
 */
public class PrefixMapper  implements ResultSetMapper<Prefix> {
    public Prefix map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        Prefix prefix = new Prefix();
        prefix.setDescription(r.getString("description"));
        prefix.setId(r.getLong("id"));
        prefix.setCountry(r.getString("country"));
        prefix.setValue(r.getLong("value"));
        return prefix;
    }
    
}
