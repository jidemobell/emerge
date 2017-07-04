/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.bss.crud;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.json.simple.JSONObject;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author akin
 */
public class EntityMapper implements ResultSetMapper<JSONObject> {

    @Override
    public JSONObject map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        ResultSetMetaData rsMetaData = r.getMetaData();
        int c = rsMetaData.getColumnCount();
        JSONObject json = new JSONObject();
        
        for (int i = 1; i <= c; i++) {
            String col = rsMetaData.getColumnName(i);
            String val = r.getString(i);
            json.put(col, val);
        }

        return json;
    }
}
