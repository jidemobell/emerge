///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.emerge.ocs.rest.test;
//
//import com.emerge.ocs.rest.model.Application;
//import com.emerge.ocs.rest.model.AuthenticationReq;
//import com.emerge.ocs.rest.model.ConfigData;
//import com.emerge.ocs.rest.model.CreditButton;
//import com.emerge.ocs.rest.model.Equipment;
//import com.emerge.ocs.rest.model.LocationInformation;
//import com.emerge.ocs.rest.model.LogReq;
//import com.emerge.ocs.rest.model.Payphone;
//import com.emerge.ocs.rest.model.PayphoneCredentials;
//import com.emerge.ocs.rest.model.SIM;
//import com.emerge.ocs.rest.model.StartServiceReq;
//import com.emerge.ocs.rest.model.Status;
//import com.emerge.ocs.rest.model.Version;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//
///**
// *
// * @author Adebowale
// */
//public class TestPreloadedModelProvider4 {
//    
//    private int payphoneID = 3;
//    private SIM sim1;
//    private SIM invalidSIM1;
//    private SIM sim2;
//    private SIM invalidSIM2;
//    private String customerID = "2002";
//    private String accountID = "3002";
//    private String contractID = "4002";
//    private Long profileID = 3l;
//    private Double balance = 1223.08;
//    private Status status;
//    private Date creationDate = new Date();
//    private Date modificationDate = new Date();
//    private PayphoneCredentials credentials;
//    private PayphoneCredentials invalidCredentials;
//    private ConfigData configData;
//    private CreditButton creditButton;
//    private Application application;
//    private Application invalidApplication;
//    private Version version;
//    private Version invalidVersion;
//    private Equipment equipment;
//    //private KeepAliveReq keepAliveReq;
//    private LogReq logReq;
//    private StartServiceReq startServiceReq;
//    private AuthenticationReq authenticationReq;
//    private AuthenticationReq invalidAuthenticationReq1;
//    private AuthenticationReq invalidAuthenticationReq2;
//    private AuthenticationReq invalidAuthenticationReq3;
//    private AuthenticationReq invalidAuthenticationReq4;
//    private LocationInformation locationInformation;
//    private Payphone payphone;
//    private Payphone invalidPayphone;
//    private Payphone invalidPayphone1;
//    private Payphone invalidPayphone2;
//    private Payphone invalidPayphone3;
//    private static TestPreloadedModelProvider4 instance;
//    
//    static {
//        instance = new TestPreloadedModelProvider4();
//    }
//
//    public TestPreloadedModelProvider4() {
//        initSim();
//        initEquipment();
//        initVersion();
//        initApplication();
//        initStatus();
//        initCreditButton();
//        initPayphoneCredentials();
//        initConfigData();
//        initPayphone();
//        initLocationInformation();
//        initAuthenticationReq();
//    }
//
//    private void initSim() {
//        sim1 = new SIM();
//        sim2 = new SIM();
//        sim1.setMSISDN("4567890");
//        sim1.setIMSI("224334341");
//        sim1.setICCID("ashd3uqw");
//        sim2.setMSISDN("29847935");
//        sim2.setIMSI("12243343");
//        sim2.setICCID("jkhk832ej2i");
//    }
//
//    private void initEquipment() {
//        equipment = new Equipment();
//        equipment.setIMEI1("2437t74y34");
//        equipment.setIMEI2("545678674545");
//        equipment.setMAC("dwusfbdufj");
//        equipment.setSerialNr("guejwhdue");
//    }
//
//    private void initVersion() {
//        version = new Version();
//        version.setMajor(1);
//        version.setMinor(1);
//        version.setPatch(3);
//        version.setStatus(Version.StatusEnum.ALLOWED);
//    }
//
//    private void initApplication() {
//        application = new Application();
//        application.setName("Andriod SDK");
//        application.setVersion(version);
//    }
//
//    private void initStatus() {
//        status = new Status();
//        status.setStatus(Status.StatusEnum.INACTIVE);
//        status.setStatusDate(new Date());
//    }
//
//    private void initCreditButton() {
//        creditButton = new CreditButton();
//        creditButton.setAmount(BigDecimal.ONE);
//        creditButton.setLabel("Button Label");
//    }
//
//    private void initPayphoneCredentials() {
//        credentials = new PayphoneCredentials();
//        credentials.setPassword("king");
//        credentials.setUsername("wecking3");
//    }
//
//    private void initConfigData() {
//        configData = new ConfigData();
//        configData.setKeepAliveInterval(1);
//        configData.setSendErrorsToOCS(0);
//        configData.setSilenceMode(Boolean.FALSE);
//        configData.setDefaultLanguage(ConfigData.DefaultLanguageEnum.PORTUGUESE);
//        configData.setCreditButtons(new ArrayList<CreditButton>());
//        configData.setPreferredMSISDN("4567890");
//    }
//
//    private void initPayphone() {
//        payphone = new Payphone();
//        payphone.setAccountID(accountID);
//        payphone.setPayphoneID(payphoneID);
//        payphone.setSIM1(sim1);
//        payphone.setSIM2(sim2);
//        payphone.setStatus(status);
//        payphone.setCredentials(credentials);
//        payphone.setCreationDate(creationDate);
//        payphone.setModificationDate(modificationDate);
//        payphone.setConfigData(configData);
//        payphone.setApplication(application);
//        payphone.setEquipment(equipment);
//    }
//
//    private void initLocationInformation() {
//        locationInformation = new LocationInformation();
//        locationInformation.setGpsLat(0);
//        locationInformation.setGpsLong(0);
//        locationInformation.setGsmCellId("ewwe");
//        locationInformation.setGsmLocationAreaCode("38232");
//    }
//
//    private void initAuthenticationReq() {
//        authenticationReq = new AuthenticationReq();
//        authenticationReq.setPayphone(payphone);
//        authenticationReq.setLocationInformation(locationInformation);
//    }
//    
//    public static TestPreloadedModelProvider4 SingleInstance() {
//        return instance;
//    }
//    
//    public AuthenticationReq getAuthenticationReq(){
//        return authenticationReq;
//    }
//}
