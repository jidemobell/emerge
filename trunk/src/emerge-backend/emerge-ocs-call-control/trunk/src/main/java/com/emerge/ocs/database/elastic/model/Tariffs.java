/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.elastic.model;



import java.util.Date;

/**
 *
 * @author jide
 */
public class Tariffs {
    
    private Integer id;
    private String  name;
    private Boolean status;
    private String searchKey;
    private Integer groupId;
    private Integer modulationTypeId;
    private Integer initialDuration;
    private Float   initialCost;
    private Float    setupCost;
    private Float recurrentCost;
    private Integer recurrentDuration;
    private Integer realmId;
    private String appCuser;
    private String appMuser;
    private Date appCdate;
    private Date appMdate;
    private Integer enumStatusId;
    private Integer uniqueControl;
    private Integer version;
    
    

    public Integer getId() {
        return id;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getModulationTypeId() {
        return modulationTypeId;
    }

    public void setModulationTypeId(Integer modulationTypeId) {
        this.modulationTypeId = modulationTypeId;
    }

    public Integer getInitialDuration() {
        return initialDuration;
    }

    public void setInitialDuration(Integer initialDuration) {
        this.initialDuration = initialDuration;
    }

    public Float getInitialCost() {
        return initialCost;
    }

    public void setInitialCost(Float initialCost) {
        this.initialCost = initialCost;
    }

    public Float getSetupCost() {
        return setupCost;
    }

    public void setSetupCost(Float setupCost) {
        this.setupCost = setupCost;
    }

    public Float getRecurrentCost() {
        return recurrentCost;
    }

    public void setRecurrentCost(Float recurrentCost) {
        this.recurrentCost = recurrentCost;
    }

    public Integer getRecurrentDuration() {
        return recurrentDuration;
    }

    public void setRecurrentDuration(Integer recurrentDuration) {
        this.recurrentDuration = recurrentDuration;
    }

    public Integer getRealmId() {
        return realmId;
    }

    public void setRealmId(Integer realmId) {
        this.realmId = realmId;
    }

    public String getAppCuser() {
        return appCuser;
    }

    public void setAppCuser(String appCuser) {
        this.appCuser = appCuser;
    }

    public String getAppMuser() {
        return appMuser;
    }

    public void setAppMuser(String appMuser) {
        this.appMuser = appMuser;
    }
    public Date getAppCdate() {
        return (Date) appCdate.clone();
    }

    public void setAppCdate(Date appCdate) {
        this.appCdate = (Date) appCdate.clone();
    }

    public Date getAppMdate() {
        return (Date) appMdate.clone();
    }

    public void setAppMdate(Date appMdate) {
        this.appMdate = (Date) appMdate.clone();
    }

    public Integer getEnumStatusId() {
        return enumStatusId;
    }

    public void setEnumStatusId(Integer enumStatusId) {
        this.enumStatusId = enumStatusId;
    }

    public Integer getUniqueControl() {
        return uniqueControl;
    }

    public void setUniqueControl(Integer uniqueControl) {
        this.uniqueControl = uniqueControl;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
    
    
    
    
    
   
    
    
}
