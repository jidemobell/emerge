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
public class PayphoneDevice {
    
    private int id;
    private String imei1;
    private String imei2;   
    private String serialNo;
    private String mac;
    private String defaultLanguage;
    private String payphoneVersionId;
    private String preferredMsisdn;
    private Boolean silenceMode;
    private boolean sendErrorsToOcs;
    private String searchKey;
    private String deletedReason;
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

    public String getImei1() {
        return imei1;
    }

    public void setImei1(String imei1) {
        this.imei1 = imei1;
    }

    public String getImei2() {
        return imei2;
    }

    public void setImei2(String imei2) {
        this.imei2 = imei2;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getPayphoneVersionId() {
        return payphoneVersionId;
    }

    public void setPayphoneVersionId(String payphoneVersionId) {
        this.payphoneVersionId = payphoneVersionId;
    }

    public String getPreferredMsisdn() {
        return preferredMsisdn;
    }

    public void setPreferredMsisdn(String preferredMsisdn) {
        this.preferredMsisdn = preferredMsisdn;
    }

    public Boolean getSilenceMode() {
        return silenceMode;
    }

    public void setSilenceMode(Boolean silenceMode) {
        this.silenceMode = silenceMode;
    }

    public Boolean getSendErrorsToOcs() {
        return sendErrorsToOcs;
    }

    public void setSendErrorsToOcs(Boolean sendErrorsToOcs) {
        this.sendErrorsToOcs = sendErrorsToOcs;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getDeletedReason() {
        return deletedReason;
    }

    public void setDeletedReason(String deletedReason) {
        this.deletedReason = deletedReason;
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

       public java.util.Date getAppCdate() {
        return (Date) appCdate.clone();
    }

    public void setAppCdate(Date appCdate) {
        this.appCdate = (Date) appCdate.clone();
    }

    public java.util.Date getAppMdate() {
        return (Date) appMdate.clone();
    }

    public void setAppMdate(java.util.Date appMdate) {
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
