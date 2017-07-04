/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.rest.model.SpecialDay;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Yusuf
 */
public class SpecialDayMapper  implements ResultSetMapper<SpecialDay>{
    public SpecialDay map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        SpecialDay specialDay = new SpecialDay();
        specialDay.setDescription(r.getString("description"));
        specialDay.setId(r.getLong("id"));
        specialDay.setDay(r.getInt("day"));
        specialDay.setMonth(r.getInt("month"));
        specialDay.setYear(r.getInt("year"));
        return specialDay;
    }

}
