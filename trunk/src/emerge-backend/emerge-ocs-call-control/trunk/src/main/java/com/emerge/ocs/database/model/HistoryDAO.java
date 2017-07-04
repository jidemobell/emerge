/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 *
 * @author jide
 */


public interface HistoryDAO {
    

    @SqlUpdate("INSERT INTO records (id, "
            + "elastic_index,"
            + " elastic_type, "
            + "log_type, "
            + "data, "
            + "created_at, "
            + "host)"
            + " VALUES ("
            + "ocs,"
            + "ongoing_session_records "
            + "session_detail_records"
            + " :data, "
            + "NOW(), "
            + "hostname)")
    int insertHistorySession(@Bind("data") Object data
    );

}
