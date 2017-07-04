/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

import org.jdbi.v3.sqlobject.SqlUpdate;

/**
 *
 * @author kingsley
 */


public interface Payphone {
    @SqlUpdate("create table something (id int primary key, name varchar(100))")
  void createSomethingTable();
  
  
}
