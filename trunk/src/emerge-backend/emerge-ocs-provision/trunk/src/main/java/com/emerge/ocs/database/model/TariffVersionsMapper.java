/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import com.emerge.ocs.rest.model.SpecialDay;
import com.emerge.ocs.rest.model.TariffVersions;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author Yusuf
 */
public class TariffVersionsMapper implements ResultSetMapper<TariffVersions>{
    public TariffVersions map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        TariffVersions tariffVersions = new TariffVersions();
        tariffVersions.setDescription(r.getString("description"));
        tariffVersions.setId(r.getLong("id"));
        tariffVersions.setActivationDate(r.getDate("activation_date"));
        tariffVersions.setStatus(r.getString("status"));
        return tariffVersions;
    }
}
