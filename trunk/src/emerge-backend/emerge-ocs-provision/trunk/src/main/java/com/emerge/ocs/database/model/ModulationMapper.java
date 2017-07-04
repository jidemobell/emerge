/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.rest.model.Modulation;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Yusuf
 */
public class ModulationMapper implements ResultSetMapper<Modulation> {

    public Modulation map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        Modulation modulation = new Modulation();
   
        modulation.setDays(r.getString("days"));
        modulation.setEndTime(r.getInt("end_time"));
        modulation.setName(r.getString("name"));
        modulation.setId(r.getLong("id"));
        modulation.setModulationTypeId(r.getLong("modulation_type_id"));
        modulation.setProfileId(r.getLong("profile_id"));
        modulation.setTariffVersionId(r.getLong("tariff_version_id"));

        return modulation;
    }

}
