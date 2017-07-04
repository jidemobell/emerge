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
//import com.emerge.ocs.rest.model.EndServiceReq;
//import com.emerge.ocs.rest.model.EndSessionRsp;
//import com.emerge.ocs.rest.model.Equipment;
//import com.emerge.ocs.rest.model.LocationInformation;
//import com.emerge.ocs.rest.model.LogReq;
//import com.emerge.ocs.rest.model.Payphone;
//import com.emerge.ocs.rest.model.PayphoneCredentials;
//import com.emerge.ocs.rest.model.SIM;
//import com.emerge.ocs.rest.model.ServiceParams;
//import com.emerge.ocs.rest.model.StartServiceRequest;
//import java.util.ArrayList;
//import com.emerge.ocs.rest.model.Status;
//import com.emerge.ocs.rest.model.Version;
//import java.math.BigDecimal;
//import java.util.Date;
//import java.util.UUID;
//
///**
// *
// * @author kingsley
// */
//public class TestPreloadedModelProvider {
//
//    private final int payphoneID;
//    private SIM sim1;
//    private SIM invalidSIM1;
//    private SIM sim2;
//    private SIM invalidSIM2;
//    private final String customerID;
//    private final long accountID;
//    private final String contractID;
//    private final Long profileID;
//    private final Double balance;
//    private final double serviceCredit;
//    private final String originMsisdn;
//    private final String destinationMsisdn;
//    private Status status;
//    private final Date creationDate;
//    private final Date modificationDate;
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
//    //private KeepAliveReq keepAliveReq;
//    private LogReq logReq;
//    private AuthenticationReq authenticationReq;
//    private AuthenticationReq authenticationReq2;
//    private AuthenticationReq invalidAuthenticationReq1;
//    private AuthenticationReq invalidAuthenticationReq2;
//    private AuthenticationReq invalidAuthenticationReq3;
//    private AuthenticationReq invalidAuthenticationReq4;
//    private LocationInformation locationInformation;
//    private Payphone payphone;
//    private Payphone payphone2;
//    private Payphone invalidPayphone;
//    private Payphone invalidPayphone1;
//    private Payphone invalidPayphone2;
//    private Payphone invalidPayphone3;
//    private StartServiceRequest startServiceRequest;
//    private StartServiceRequest invalidStartServiceRequest1;
//    private StartServiceRequest invalidStartServiceRequest2;
//    private StartServiceRequest invalidStartServiceRequest3;
//    private ServiceParams serviceParams;
//    private ServiceParams invalidServiceParams1;
//    private ServiceParams invalidServiceParams2;
//    private ServiceParams invalidServiceParams3;
//    private EndServiceReq endServiceReq;
//    private EndSessionRsp endSessionReq;
//    private static TestPreloadedModelProvider instance;
//
//    static {
//        instance = new TestPreloadedModelProvider();
//    }
//
//    public TestPreloadedModelProvider() {
//        this.modificationDate = new Date();
//        this.creationDate = new Date();
//        this.destinationMsisdn = "+2348034609060";
//        this.originMsisdn = "1234567890";
//        this.serviceCredit = 300;
//        this.balance = 223.98;
//        this.contractID = "3002";
//        this.profileID = 1L;
//        this.accountID = 2002;
//        this.customerID = "1002";
//        this.payphoneID = 1;
//        initSim();
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
//        initInvalidSim1();
//        initInvalidSim2();
//        initConfigData();
//        initPayphone();
//        initPayphone2();
//        initInvalidPayphone();
//        initInvalidPayphone1();
//        initInvalidPayphone2();
//        initInvalidPayphone3();
//        initLocationInformation();
//        initLogReq();
//        initStartServiceRequest();
//        initInvalidStartServiceRequest1();
//        initInvalidStartServiceRequest2();
//        initInvalidStartServiceRequest3();
//        initServiceParams();
//        initInvalidServiceParams1();
//        initInvalidServiceParams2();
//        initInvalidServiceParams3();
//        initEndServiceReq();
//        initEndSessionReq();
//        initAuthenticationReq();
//    }
//    
//    private void initAuthenticationReq(){
//        authenticationReq = new AuthenticationReq();
//        authenticationReq.setPayphone(payphone);
//        authenticationReq.setLocationInformation(locationInformation);
//    }
//    
//    private void initStartServiceRequest(){
//        startServiceRequest = new StartServiceRequest();
//        startServiceRequest.setServiceCredit(serviceCredit);
//        startServiceRequest.setOriginMsisdn(originMsisdn);
//        startServiceRequest.setPayphoneID(payphoneID);
//        startServiceRequest.setDestinationMsisdn(destinationMsisdn);
//        startServiceRequest.setId(1);
//    }
//    
//    private void initInvalidStartServiceRequest1(){
//        invalidStartServiceRequest1 = new StartServiceRequest();
//        invalidStartServiceRequest1.setServiceCredit(0);
//        invalidStartServiceRequest1.setOriginMsisdn(originMsisdn);
//        invalidStartServiceRequest1.setPayphoneID(payphoneID);
//        invalidStartServiceRequest1.setDestinationMsisdn(destinationMsisdn);
//        invalidStartServiceRequest1.setId(1);
//    }
//    
//    private void initInvalidStartServiceRequest2(){
//        invalidStartServiceRequest2 = new StartServiceRequest();
//        invalidStartServiceRequest2.setServiceCredit(serviceCredit);
//        invalidStartServiceRequest2.setOriginMsisdn(originMsisdn);
//        invalidStartServiceRequest2.setPayphoneID(payphoneID);
//        invalidStartServiceRequest2.setDestinationMsisdn("225533");
//        invalidStartServiceRequest2.setId(1);
//    }
//    
//    private void initInvalidStartServiceRequest3(){
//        invalidStartServiceRequest3 = new StartServiceRequest();
//        invalidStartServiceRequest3.setServiceCredit(4000);
//        invalidStartServiceRequest3.setOriginMsisdn(originMsisdn);
//        invalidStartServiceRequest3.setPayphoneID(payphoneID);
//        invalidStartServiceRequest3.setDestinationMsisdn(destinationMsisdn);
//        invalidStartServiceRequest3.setId(1);
//    }
//    
//    private void initCreditButton(){
//        creditButton = new CreditButton();
//        creditButton.setAmount(BigDecimal.ONE);
//        creditButton.setLabel("Button Label");
//    }
//    
//    private void initLogReq(){
//        logReq = new LogReq();
//        logReq.setErrorCode("400");
//        logReq.setErrorDescription("Service not available");
//    }
//        
//    private void initConfigData() {
//        configData = new ConfigData();
//        configData.setKeepAliveInterval(1);
//        configData.setSendErrorsToOCS(0);
//        configData.setSilenceMode(Boolean.FALSE);
//        configData.setDefaultLanguage(ConfigData.DefaultLanguageEnum.PORTUGUESE);
//        configData.setCreditButtons(new ArrayList<CreditButton>());
//        configData.setPreferredMSISDN("1234567890");
//    }
//    
//    private void initStatus(){
//        status = new Status();
//        status.setStatus(Status.StatusEnum.ACTIVE);
//        status.setStatusDate(new Date());
//    }
//    
//    private void initApplication(){
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
//    private void initPayphoneCredentials(){
//        credentials = new PayphoneCredentials();
//        credentials.setPassword("come");
//        credentials.setUsername("wecking1");
//    }
//    
//    private void initInvalidCredentials(){
//        invalidCredentials = new PayphoneCredentials();
//        invalidCredentials.setUsername("invalid");
//        invalidCredentials.setPassword("password");
//    }
//
//    private void initVersion(){
//        version = new Version();
//        version.setMajor(0);
//        version.setMinor(1);
//        version.setPatch(3);
//     }
//    
//    private void initInvalidVersion(){
//        invalidVersion = new Version();
//        invalidVersion.setMajor(1);
//        invalidVersion.setMinor(1);
//        invalidVersion.setPatch(3);;
//    }
//
//    private void initEquipment() {
//        equipment = new Equipment();
//        equipment.setIMEI1("fhfkwenkdfwenbwskjfw");
//        equipment.setIMEI2("JSBKVMBKFWeEFK");
//        equipment.setMAC("dgegregwafewerrgergdd");
//        equipment.setSerialNr("sdgwrwewrteegrehsddsd");
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
//    private void initSim() {
//        sim1 = new SIM();
//        sim2 = new SIM();
//        sim1.setMSISDN("213453675432");
//        sim1.setIMSI("1234564232");
//        sim1.setICCID("asjshd443uqw");
//        sim2.setMSISDN("3293259847935");
//        sim2.setIMSI("12122436343");
//        sim2.setICCID("asjkhk8f32ej2i");
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
//        invalidSIM2.setMSISDN("ewesdsf");
//        invalidSIM2.setIMSI("123");
//        invalidSIM2.setICCID("1");
//    }
//    
//    private void initLocationInformation(){
//        locationInformation = new LocationInformation();
//        locationInformation.setGpsLat(0);
//        locationInformation.setGpsLong(0);
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
//    private void initServiceParams(){
//        serviceParams = new ServiceParams();
//        serviceParams.setPayphoneID(payphoneID);
//    }
//    
//    private void initInvalidServiceParams1(){
//        invalidServiceParams1 = new ServiceParams();
//        invalidServiceParams1.setPayphoneID(payphoneID);
//    }
//    
//    private void initInvalidServiceParams2(){
//        invalidServiceParams2 = new ServiceParams();
//        invalidServiceParams2.setPayphoneID(payphoneID);
//    }
//    
//    private void initInvalidServiceParams3(){
//        invalidServiceParams3 = new ServiceParams();
//        invalidServiceParams3.setPayphoneID(payphoneID);
//    }
//    
//    private void initEndServiceReq(){
//        endServiceReq = new EndServiceReq();
//        endServiceReq.setEndCause("Call ended");
//        endServiceReq.setServiceDuration(60);
//        endServiceReq.setServiceEndTime(new Date());
//    }
//    
//    private void initEndSessionReq(){
//        endSessionReq = new EndSessionRsp();
//        endSessionReq.setNumberOfServices(BigDecimal.valueOf(2));
//        endSessionReq.setEndCause("Session Ended");
//        endSessionReq.setTotalBilledAmount(BigDecimal.valueOf(150));
//        endSessionReq.setTotalServiceDuration(BigDecimal.valueOf(55));
//        endSessionReq.setTotalBilledDuration(BigDecimal.valueOf(50));
//        endSessionReq.setSessionDuration(BigDecimal.valueOf(100));
//        endSessionReq.setRemainingCredit(11990f);
//        endSessionReq.setPayphoneBalance(99999999f);
//    }
//
//    public static TestPreloadedModelProvider SingleInstance() {
//        return instance;
//    }
//
//    public Payphone getPayphone() {
//        return payphone;
//    }
//    
//    public StartServiceRequest getStartServiceReq(){
//        return startServiceRequest;
//    }
//    
//    public StartServiceRequest getStartServiceRequest(){
//        return startServiceRequest;
//    }
//    
//    public StartServiceRequest getInvalidStartServiceRequest1(){
//        return invalidStartServiceRequest1;
//    }
//    
//    public StartServiceRequest getInvalidStartServiceRequest2(){
//        return invalidStartServiceRequest2;
//    }
//    
//    public StartServiceRequest getInvalidStartServiceRequest3(){
//        return invalidStartServiceRequest3;
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
//    
//    public ServiceParams getServiceParams(){
//        return serviceParams;
//    }
//    
//    public ServiceParams getInvalidServiceParams1(){
//        return invalidServiceParams1;
//    }
//    
//    public ServiceParams getInvalidServiceParams2(){
//        return invalidServiceParams2;
//    }
//    
//    public ServiceParams getInvalidServiceParams3(){
//        return invalidServiceParams3;
//    }
//    
//    public EndServiceReq getEndServiceReq(){
//        return endServiceReq;
//    }
//    
//    public EndSessionRsp getEndSessionReq(){
//        return endSessionReq;
//    }
//    
//    public LogReq getLogReq(){
//        return logReq;
//    }
//}