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
public class OngoingServiceInformation {
    
    private Integer tariffId;

  
    private String hostname;
        private Date callAuthorizationTime;
        private Date startTime;
        private Date callAnswerTime;
        private Integer id;
        private String destination;
        private String destinationGroup;
        private Date callEndTime;
        private Integer callDuration;
        private Integer billedDuration;
        private Float billedAmount;
        private Float  initialBalance;
        private Integer realmId;
        private String appMuser;
        private String appCuser;
        private Date appCdate;
        private Date appMdate;
        private Integer enumStatusId;
        private Integer uniqueControl;
        private Integer version;
        
        
        
        
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPayphoneDeviceId() {
        return payphoneDeviceId;
    }

    public void setPayphoneDeviceId(Integer payphoneDeviceId) {
        this.payphoneDeviceId = payphoneDeviceId;
    }
        private Integer payphoneDeviceId;
        
        
    
  
       
        
      public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getTariffId() {
        return tariffId;
    }

    public void setTariffId(Integer tariffId) {
        this.tariffId = tariffId;
    }

    public Date getCallAuthorizationTime() {
        return (Date) callAuthorizationTime.clone();
    }

    public void setCallAuthorizationTime(Date callAuthorizationTime) {
        this.callAuthorizationTime = (Date) callAuthorizationTime.clone();
    }

    public Date getStartTime() {
        return (Date) startTime.clone();
    }

    public void setStartTime(Date startTime) {
        this.startTime = (Date) startTime.clone();
    }

    public Date getCallAnswerTime() {
        return (Date) callAnswerTime.clone();
    }

    public void setCallAnswerTime(Date callAnswerTime) {
        this.callAnswerTime = (Date) callAnswerTime.clone();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestinationGroup() {
        return destinationGroup;
    }

    public void setDestinationGroup(String destinationGroup) {
        this.destinationGroup = destinationGroup;
    }

    public Date getCallEndTime() {
        return (Date) callEndTime.clone();
    }

    public void setCallEndTime(Date callEndTime) {
        this.callEndTime = (Date) callEndTime.clone();
    }

    public Integer getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(Integer callDuration) {
        this.callDuration = callDuration;
    }

    public Integer getBilledDuration() {
        return billedDuration;
    }

    public void setBilledDuration(Integer billedDuration) {
        this.billedDuration = billedDuration;
    }

    public Float getBilledAmount() {
        return billedAmount;
    }

    public void setBilledAmount(Float billedAmount) {
        this.billedAmount = billedAmount;
    }

    public Float getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Float initialBalance) {
        this.initialBalance = initialBalance;
    }

    public Integer getRealmId() {
        return realmId;
    }

    public void setRealmId(Integer realmId) {
        this.realmId = realmId;
    }

    public String getAppMuser() {
        return appMuser;
    }

    public void setAppMuser(String appMuser) {
        this.appMuser = appMuser;
    }

    public String getAppCuser() {
        return appCuser;
    }

    public void setAppCuser(String appCuser) {
        this.appCuser = appCuser;
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
