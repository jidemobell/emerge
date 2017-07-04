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
public class Session {

    private String accessToken;
    private Integer payphoneDeviceId;
    private Integer profileId;
    private String origin;
    private float totalCost;
    private float totalCallDuration;
    private float totalBilledTime;
    private float totalBilledAmount;
    private float totalServiceDuration;
    private float sessionDuration;
    private Date sessionBeginTime;
    private Date sessionEndTime;
    private Integer endCause;
    private float remainingCredit;
    private Integer numberOfServices;
    private float payphoneBalance;
    private float maximumAmountToSpend;
    private String searchKey;
    private Integer realmId;
    private String appCuser;
    private String appMuser;
    private Date appCdate;
    private Date appMdate;
    private Integer enumStatusId;
    private Integer uniqueControl;
    private Integer version;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getPayphoneDeviceId() {
        return payphoneDeviceId;
    }

    public void setPayphoneDeviceId(Integer payphoneDeviceId) {
        this.payphoneDeviceId = payphoneDeviceId;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public float getTotalCallDuration() {
        return totalCallDuration;
    }

    public void setTotalCallDuration(float totalCallDuration) {
        this.totalCallDuration = totalCallDuration;
    }

    public float getTotalBilledTime() {
        return totalBilledTime;
    }

    public void setTotalBilledTime(float totalBilledTime) {
        this.totalBilledTime = totalBilledTime;
    }

    public float getTotalBilledAmount() {
        return totalBilledAmount;
    }

    public void setTotalBilledAmount(float totalBilledAmount) {
        this.totalBilledAmount = totalBilledAmount;
    }

    public float getTotalServiceDuration() {
        return totalServiceDuration;
    }

    public void setTotalServiceDuration(float totalServiceDuration) {
        this.totalServiceDuration = totalServiceDuration;
    }

    public float getSessionDuration() {
        return sessionDuration;
    }

    public void setSessionDuration(float sessionDuration) {
        this.sessionDuration = sessionDuration;
    }

    public Date getSessionBeginTime() {
        return (Date) sessionBeginTime.clone();
    }

    public void setSessionBeginTime(Date sessionBeginTime) {
        this.sessionBeginTime = (Date) sessionBeginTime.clone();
    }

    public Date getSessionEndTime() {
        return (Date) sessionEndTime.clone();
    }

    public void setSessionEndTime(Date sessionEndTime) {
        this.sessionEndTime = (Date) sessionEndTime.clone();
    }

    public Integer getEndCause() {
        return endCause;
    }

    public void setEndCause(Integer endCause) {
        this.endCause = endCause;
    }

    public float getRemainingCredit() {
        return remainingCredit;
    }

    public void setRemainingCredit(float remainingCredit) {
        this.remainingCredit = remainingCredit;
    }

    public Integer getNumberOfServices() {
        return numberOfServices;
    }

    public void setNumberOfServices(Integer numberOfServices) {
        this.numberOfServices = numberOfServices;
    }

    public float getPayphoneBalance() {
        return payphoneBalance;
    }

    public void setPayphoneBalance(float payphoneBalance) {
        this.payphoneBalance = payphoneBalance;
    }

    public float getMaximumAmountToSpend() {
        return maximumAmountToSpend;
    }

    public void setMaximumAmountToSpend(float maximumAmountToSpend) {
        this.maximumAmountToSpend = maximumAmountToSpend;
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
