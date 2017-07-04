/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.model;

/**
 *
 * @author Kingsley
 */
public class Tariff {
    
    private int id;
    private String  name;
    private int group_id;
    private int modulation_types_id;
    private int initial_duration;
    private double   initial_cost;
    private double    setup_cost;
    private double recurrent_cost;
    private int recurrent_duration;
    private int zone_id;

    public int getId() {
        return id;
    }
    
    public void setZoneID(int zone_id) {
        this.zone_id = zone_id;
    }

    public int getZoneID() {
        return zone_id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Integer getModulation_types_id() {
        return modulation_types_id;
    }

    public void setModulation_types_id(Integer modulation_types_id) {
        this.modulation_types_id = modulation_types_id;
    }

    public int getInitial_duration() {
        return initial_duration;
    }

    public void setInitial_duration(Integer initial_duration) {
        this.initial_duration = initial_duration;
    }

    public double getInitial_cost() {
        return initial_cost;
    }

    public void setInitial_cost(Float initial_cost) {
        this.initial_cost = initial_cost;
    }

    public double getSetup_cost() {
        return setup_cost;
    }

    public void setSetup_cost(Float setup_cost) {
        this.setup_cost = setup_cost;
    }

    public double getRecurrent_cost() {
        return recurrent_cost;
    }

    public void setRecurrent_cost(Float recurrent_cost) {
        this.recurrent_cost = recurrent_cost;
    }

    public Integer getRecurrent_duration() {
        return recurrent_duration;
    }

    public void setRecurrent_duration(Integer recurrent_duration) {
        this.recurrent_duration = recurrent_duration;
    }
    
}
