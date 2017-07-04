package com.emerge.ocs.database.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.emerge.ocs.rest.model.Groups;
import com.emerge.ocs.rest.model.Tariff;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Yusuf
 */
public class TariffMapper implements ResultSetMapper<Tariff> {

    public Tariff map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        Tariff tariff = new Tariff();
        tariff.setInitialCost(r.getDouble("initial_cost"));
        tariff.setGroupId(r.getLong("group_id"));
        tariff.setId(r.getLong("id"));
        tariff.setInitialDuration(r.getLong("initial_duration"));
        tariff.setModulationTypeId(r.getLong("modulation_type_id"));
        tariff.setName(r.getString("name"));
        tariff.setProfileId(r.getLong("profile_id"));
        tariff.setRecurrentCost(r.getDouble("recurrent_cost"));
        tariff.setRecurrentDuration(r.getLong("recurrent_duration"));
        tariff.setSetupCost(r.getDouble("setup_cost"));
        tariff.setStatus(r.getBoolean("status"));
        tariff.setTariffVersionId(r.getLong("tariff_version_id"));
        return tariff;
    }
}
