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
public class AuthenticationAttempts {

    /**
     *
     */
    private Integer id;
    /**
     *
     */
    private String username;
    /**
     *
     */
    private String sim1Imei;
    /**
     *
     */
    private String sim1Msisdn;
    /**
     *
     */
    private String sim1Imsi;
    /**
     *
     */
    private String sim1Iccid;
    /**
     *
     */
    private String sim2Imei;
    /**
     *
     */
    private String sim2Msisdn;
    /**
     *
     */
    private String sim2Imsi;
    /**
     *
     */
    private String sim2Iccid;
    private String gsmCellId;
    private String gsmLocationAreaCode;
    private String payphoneDeviceId;
    private String payphoneVersion;
    private Integer sessionId;
    private String hostname;
    private String originIpAddress;
    private Integer resultCode;
    private String searchKey;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSim1Imei() {
        return sim1Imei;
    }

    public void setSim1Imei(String sim1Imei) {
        this.sim1Imei = sim1Imei;
    }

    public String getSim1Msisdn() {
        return sim1Msisdn;
    }

    public void setSim1Msisdn(String sim1Msisdn) {
        this.sim1Msisdn = sim1Msisdn;
    }

    public String getSim1Imsi() {
        return sim1Imsi;
    }

    public void setSim1Imsi(String sim1Imsi) {
        this.sim1Imsi = sim1Imsi;
    }

    public String getSim1Iccid() {
        return sim1Iccid;
    }

    public void setSim1Iccid(String sim1Iccid) {
        this.sim1Iccid = sim1Iccid;
    }

    public String getSim2Imei() {
        return sim2Imei;
    }

    public void setSim2Imei(String sim2Imei) {
        this.sim2Imei = sim2Imei;
    }

    public String getSim2Msisdn() {
        return sim2Msisdn;
    }

    public void setSim2Msisdn(String sim2Msisdn) {
        this.sim2Msisdn = sim2Msisdn;
    }

    public String getSim2Imsi() {
        return sim2Imsi;
    }

    public void setSim2Imsi(String sim2Imsi) {
        this.sim2Imsi = sim2Imsi;
    }

    public String getSim2Iccid() {
        return sim2Iccid;
    }

    public void setSim2Iccid(String sim2Iccid) {
        this.sim2Iccid = sim2Iccid;
    }

    public String getGsmCellId() {
        return gsmCellId;
    }

    public void setGsmCellId(String gsmCellId) {
        this.gsmCellId = gsmCellId;
    }

    public String getGsmLocationAreaCode() {
        return gsmLocationAreaCode;
    }

    public void setGsmLocationAreaCode(String gsmLocationAreaCode) {
        this.gsmLocationAreaCode = gsmLocationAreaCode;
    }

    public String getPayphoneDeviceId() {
        return payphoneDeviceId;
    }

    public void setPayphoneDeviceId(String payphoneDeviceId) {
        this.payphoneDeviceId = payphoneDeviceId;
    }

    public String getPayphoneVersion() {
        return payphoneVersion;
    }

    public void setPayphoneVersion(String payphoneVersion) {
        this.payphoneVersion = payphoneVersion;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getOriginIpAddress() {
        return originIpAddress;
    }

    public void setOriginIpAddress(String originIpAddress) {
        this.originIpAddress = originIpAddress;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
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
