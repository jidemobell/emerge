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
//import com.emerge.ocs.rest.model.Equipment;;
//import com.emerge.ocs.rest.model.LocationInformation;
//import com.emerge.ocs.rest.model.Payphone;
//import com.emerge.ocs.rest.model.PayphoneCredentials;
//import com.emerge.ocs.rest.model.SIM;
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
//public class TestPreloadedModelProvider2 {
//    private int payphoneID = 4;
//    private SIM sim1;
//    private SIM invalidSIM1;
//    private SIM sim2;
//    private SIM invalidSIM2;
//    private String customerID = "Johnson";
//    private String accountID = "23372334edew";
//    private String contractID = "k002";
//    private Double balance = 12.12;
//    private Long profileID = 2l;
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
//    private Equipment equipment2;
//    private Payphone payphone;
//    private Payphone payphone2;
//    private Payphone invalidPayphone;
//    private Payphone invalidPayphone1;
//    private Payphone invalidPayphone2;
//    private Payphone invalidPayphone3;
//    private LocationInformation locationInformation;
//    private AuthenticationReq authenticationReq;
//    private AuthenticationReq authenticationReq2;
//    private AuthenticationReq invalidAuthenticationReq1;
//    private AuthenticationReq invalidAuthenticationReq2;
//    private AuthenticationReq invalidAuthenticationReq3;
//    private AuthenticationReq invalidAuthenticationReq4;
//    private static TestPreloadedModelProvider2 instance;
//
//    static {
//        instance = new TestPreloadedModelProvider2();
//    }
//
//    public TestPreloadedModelProvider2() {
//        initSim();
//        initInvalidSim1();
//        initInvalidSim2();
//        initEquipment();
//        initEquipment2();
//        initVersion();
//        initInvalidVersion();
//        initApplication();
//        initInvalidApplication();
//        initStatus();
//        initCreditButton();
//        initPayphoneCredentials();
//        initInvalidCredentials();
//        initConfigData();
//        initPayphone();
//        initPayphone2();
//        initInvalidPayphone();
//        initInvalidPayphone1();
//        initInvalidPayphone2();
//        initInvalidPayphone3();
//        initLocationInformation();
//        initAuthenticationReq();
//        initAuthenticationReq2();
//        initInvalidAuthenticationReq1();
//        initInvalidAuthenticationReq2();
//        initInvalidAuthenticationReq3();
//        initInvalidAuthenticationReq4();
//    }
//
//    private void initSim() {
//        sim1 = new SIM();
//        sim2 = new SIM();
//        sim1.setMSISDN("0377462842");
//        sim1.setIMSI("121224334341123244");
//        sim1.setICCID("asjshd3uqwabe2");
//        sim2.setMSISDN("3293298479357832");
//        sim2.setIMSI("121224334341123244");
//        sim2.setICCID("asjkhk832ej2iweh8912q3");
//    }
//    
//    private void initInvalidSim1(){
//        invalidSIM1 = new SIM();
//        invalidSIM1.setMSISDN("ewesdsf");
//        invalidSIM1.setIMSI("123");
//        invalidSIM1.setICCID("1");
//    }
//    
//    private void initInvalidSim2(){
//        invalidSIM2 = new SIM();
//        invalidSIM2.setMSISDN("esdsf");
//        invalidSIM2.setIMSI("3");
//        invalidSIM2.setICCID("1");
//    }
//
//    private void initEquipment() {
//        equipment = new Equipment();
//        equipment.setIMEI1("123244");
//        equipment.setIMEI2("3453545678674545");
//        equipment.setMAC("qwe21qwed243535qqqw");
//        equipment.setSerialNr("qw2ew3dewe");
//    }
//    
//    private void initEquipment2(){
//        equipment2 = new Equipment();
//        equipment2.setIMEI1("274y34");
//        equipment2.setIMEI2("3678674545");
//        equipment2.setMAC("wufjbdufjas");
//        equipment2.setSerialNr("ejwhduewf");
//    }
//
//    private void initVersion() {
//        version = new Version();
//        version.setMajor(5);
//        version.setMinor(5);
//        version.setPatch(8);
//        version.setStatus(Version.StatusEnum.ALLOWED);
//    }
//    
//    private void initInvalidVersion(){
//        invalidVersion = new Version();
//        invalidVersion.setMajor(1);
//        invalidVersion.setMinor(1);
//        invalidVersion.setPatch(3);
//        invalidVersion.setStatus(Version.StatusEnum.NOTALLOWED);
//    }
//
//    private void initApplication() {
//        application = new Application();
//        application.setName("Andriod SDK");
//        application.setVersion(version);
//    }
//    
//    private void initInvalidApplication(){
//        invalidApplication = new Application();
//        invalidApplication.setName("Andriod SDK");
//        invalidApplication.setVersion(invalidVersion);
//    }
//
//    private void initStatus() {
//        status = new Status();
//        status.setStatus(Status.StatusEnum.ACTIVE);
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
//        credentials.setUsername("wecking");
//    }
//    
//    private void initInvalidCredentials(){
//        invalidCredentials = new PayphoneCredentials();
//        invalidCredentials.setUsername("invalid");
//        invalidCredentials.setPassword("password");
//    }
//
//    private void initConfigData() {
//        configData = new ConfigData();
//        configData.setKeepAliveInterval(44);
//        configData.setSendErrorsToOCS(3);
//        configData.setSilenceMode(Boolean.FALSE);
//        configData.setCreditButtons(new ArrayList<CreditButton>());
//        configData.setPreferredMSISDN("212235465576");
//    }
//    
//    private void initLocationInformation(){
//        locationInformation = new LocationInformation();
//        locationInformation.setGpsLat(235445);
//        locationInformation.setGpsLong(3455675);
//        locationInformation.setGsmCellId("wdewwe");
//        locationInformation.setGsmLocationAreaCode("34638232");
//    }
//    
//    private void initPayphone(){
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
//        payphone.setBalance(balance);
//        payphone.setApplication(application);
//        payphone.setEquipment(equipment);
//    }
//    
//    private void initPayphone2(){
//        payphone2 = new Payphone();
//        payphone2.setAccountID(accountID);
//        payphone2.setPayphoneID(payphoneID);
//        payphone2.setSIM1(sim1);
//        payphone2.setSIM2(sim2);
//        payphone2.setStatus(status);
//        payphone2.setCredentials(credentials);
//        payphone2.setCreationDate(creationDate);
//        payphone2.setModificationDate(modificationDate);
//        payphone2.setConfigData(configData);
//        payphone2.setApplication(application);
//        payphone2.setEquipment(equipment2);
//    }
//    
//    //Payphone with invalid username and password
//    private void initInvalidPayphone(){
//        invalidPayphone = new Payphone();
//        invalidPayphone.setCredentials(invalidCredentials);
//        invalidPayphone.setAccountID(accountID);
//        invalidPayphone.setPayphoneID(payphoneID);
//        invalidPayphone.setSIM1(sim1);
//        invalidPayphone.setSIM2(sim2);
//        invalidPayphone.setStatus(status);
//        invalidPayphone.setCreationDate(creationDate);
//        invalidPayphone.setModificationDate(modificationDate);
//        invalidPayphone.setConfigData(configData);
//        invalidPayphone.setApplication(application);
//        invalidPayphone.setEquipment(equipment);       
//    }
//    
//    private void initInvalidPayphone1(){
//        invalidPayphone1 = new Payphone();
//        invalidPayphone1.setCredentials(credentials);
//        invalidPayphone1.setAccountID(accountID);
//        invalidPayphone1.setPayphoneID(payphoneID);
//        invalidPayphone1.setSIM1(invalidSIM1);
//        invalidPayphone1.setSIM2(sim2);
//        invalidPayphone1.setStatus(status);
//        invalidPayphone1.setCreationDate(creationDate);
//        invalidPayphone1.setModificationDate(modificationDate);
//        invalidPayphone1.setConfigData(configData);
//        invalidPayphone1.setApplication(application);
//        invalidPayphone1.setEquipment(equipment);       
//    }
//    
//    private void initInvalidPayphone2(){
//        invalidPayphone2 = new Payphone();
//        invalidPayphone2.setCredentials(credentials);
//        invalidPayphone2.setAccountID(accountID);
//        invalidPayphone2.setPayphoneID(payphoneID);
//        invalidPayphone2.setSIM1(sim1);
//        invalidPayphone2.setSIM2(invalidSIM2);
//        invalidPayphone2.setStatus(status);
//        invalidPayphone2.setCreationDate(creationDate);
//        invalidPayphone2.setModificationDate(modificationDate);
//        invalidPayphone2.setConfigData(configData);
//        invalidPayphone2.setApplication(application);
//        invalidPayphone2.setEquipment(equipment);       
//    }
//    
//    private void initInvalidPayphone3(){
//        invalidPayphone3 = new Payphone();
//        invalidPayphone3.setCredentials(credentials);
//        invalidPayphone3.setAccountID(accountID);
//        invalidPayphone3.setPayphoneID(payphoneID);
//        invalidPayphone3.setSIM1(sim1);
//        invalidPayphone3.setSIM2(sim2);
//        invalidPayphone3.setStatus(status);
//        invalidPayphone3.setCreationDate(creationDate);
//        invalidPayphone3.setModificationDate(modificationDate);
//        invalidPayphone3.setConfigData(configData);
//        invalidPayphone3.setApplication(invalidApplication);
//        invalidPayphone3.setEquipment(equipment);       
//    }
//    
//    private void initAuthenticationReq(){
//        authenticationReq = new AuthenticationReq();
//        authenticationReq.setPayphone(payphone);
//        authenticationReq.setLocationInformation(locationInformation);
//    }
//    
//    private void initAuthenticationReq2(){
//        authenticationReq2 = new AuthenticationReq();
//        authenticationReq2.setPayphone(payphone2);
//        authenticationReq2.setLocationInformation(locationInformation);
//    }
//    
//    private void initInvalidAuthenticationReq1(){
//        invalidAuthenticationReq1 = new AuthenticationReq();
//        invalidAuthenticationReq1.setPayphone(invalidPayphone);
//        invalidAuthenticationReq1.setLocationInformation(locationInformation);
//    }
//    
//    private void initInvalidAuthenticationReq2(){
//        invalidAuthenticationReq2 = new AuthenticationReq();
//        invalidAuthenticationReq2.setPayphone(invalidPayphone1);
//        invalidAuthenticationReq2.setLocationInformation(locationInformation);
//    }
//    
//    private void initInvalidAuthenticationReq3(){
//        invalidAuthenticationReq3 = new AuthenticationReq();
//        invalidAuthenticationReq3.setPayphone(invalidPayphone2);
//        invalidAuthenticationReq3.setLocationInformation(locationInformation);
//    }
//    
//    private void initInvalidAuthenticationReq4(){
//        invalidAuthenticationReq4 = new AuthenticationReq();
//        invalidAuthenticationReq4.setPayphone(invalidPayphone3);
//        invalidAuthenticationReq4.setLocationInformation(locationInformation);
//    }
//    
//    public static TestPreloadedModelProvider2 SingleInstance(){
//        return instance;
//    }
//    
//    public LocationInformation getLocationInformation(){
//        return locationInformation;
//    }
//    
//    public AuthenticationReq getAuthenticationReq(){
//        return authenticationReq;
//    }
//    
//    public AuthenticationReq getAuthenticationReq2(){
//        return authenticationReq2;
//    }
//    
//    public AuthenticationReq getInvalidAuthenticationReq1(){
//        return invalidAuthenticationReq1;
//    }
//    
//    public AuthenticationReq getInvalidAuthenticationReq2(){
//        return invalidAuthenticationReq2;
//    }
//    
//    public AuthenticationReq getInvalidAuthenticationReq3(){
//        return invalidAuthenticationReq3;
//    }
//    
//    public AuthenticationReq getInvalidAuthenticationReq4(){
//        return invalidAuthenticationReq4;
//    }
//}
