/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.database.elastic.model;


/**
 *
 * @author jide
 */
public class SessionDocument {

    public Tariffs getTariffs() {
        return tariffs;
    }

    public void setTariffs(Tariffs tariffs) {
        this.tariffs = tariffs;
    }
    
    private Tariffs tariffs;
    private Session session;
    private OngoingServiceInformation ongoingServiceInformation;
    private AuthenticationAttempts authenticationAttempts;

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }
    private String logType;

 
    

    public PayphoneDevice getPayphoneDevice() {
        return payphoneDevice;
    }

    public void setPayphoneDevice(PayphoneDevice payphoneDevice) {
        this.payphoneDevice = payphoneDevice;
    }
    private PayphoneDevice payphoneDevice;

  
    

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public OngoingServiceInformation getOngoingServiceInformation() {
        return ongoingServiceInformation;
    }

    public void setOngoingServiceInformation(OngoingServiceInformation ongoingServiceInformation) {
        this.ongoingServiceInformation = ongoingServiceInformation;
    }

    public AuthenticationAttempts getAuthenticationAttempts() {
        return authenticationAttempts;
    }

    public void setAuthenticationAttempts(AuthenticationAttempts authenticationAttempts) {
        this.authenticationAttempts = authenticationAttempts;
    }
    

}
