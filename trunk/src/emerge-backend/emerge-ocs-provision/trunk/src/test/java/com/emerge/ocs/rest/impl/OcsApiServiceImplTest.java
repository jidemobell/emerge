/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emerge.ocs.rest.impl;

import com.emerge.ocs.rest.api.NotFoundException;
import com.emerge.ocs.rest.model.Application;
import com.emerge.ocs.rest.model.ConfigData;
import com.emerge.ocs.rest.model.Equipment;
import com.emerge.ocs.rest.model.Groups;
import com.emerge.ocs.rest.model.Modulation;
import com.emerge.ocs.rest.model.PayphoneCredentials;
import com.emerge.ocs.rest.model.PayphoneDevice;
import com.emerge.ocs.rest.model.PayphoneService;
import com.emerge.ocs.rest.model.Prefix;
import com.emerge.ocs.rest.model.SIM;
import com.emerge.ocs.rest.model.SpecialDay;
import com.emerge.ocs.rest.model.Status;
import com.emerge.ocs.rest.model.Tariff;
import com.emerge.ocs.rest.model.TariffVersions;
import com.emerge.ocs.rest.model.TopUpRequest;
import com.emerge.ocs.rest.model.Version;
import com.emerge.ocs.rest.model.Zones;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kingsley
 */
public class OcsApiServiceImplTest {

    /**
     *
     */
    public OcsApiServiceImplTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

//    /**
//     * Test of createPayphoneService method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testCreatePayphoneService() {
//        try {
//            String umUserHash = "";
//            String umSessionID = "";
//            String umDomain = "";
//            PayphoneService payphoneService = new PayphoneService();
//            PayphoneDevice payphoneDevice = new PayphoneDevice();
//            ConfigData configData = new ConfigData();
//            Equipment equipment = new Equipment();
//            Status status = new Status();
//
//            SIM sim1 = new SIM();
//            SIM sim2 = new SIM();
//
//            sim1.setICCID("iccid1122");
//            sim1.setIMSI("imsi3344");
//            sim1.setMSISDN("08097654321");
//
//            sim2.setICCID("iccid3333");
//            sim2.setIMSI("imsi5555");
//            sim2.setMSISDN("08097766559");
//
//            equipment.setIMEI1("imei22334455");
//            equipment.setIMEI2("imei99887766");
//            equipment.setMAC("mac44332211");
//            equipment.setSerialNr("11223344");
//
//            status.setStatus(Status.StatusEnum.INACTIVE);
//            status.setStatusDate(getTodaysdate());
//
//            Application application = new Application();
//            Version version = new Version();
//            version.setMajor(1L);
//            version.setMinor(1L);
//            version.setPatch(0L);
//            application.setName("Payphone");
//            application.setVersion(version);
//            payphoneDevice.setApplication(application);
//            payphoneDevice.setCreationDate(getTodaysdate());
//            payphoneDevice.setModificationDate(getTodaysdate());
//            payphoneDevice.setEquipment(equipment);
//            payphoneDevice.setSim1(sim1);
//            payphoneDevice.setSim2(sim2);
//            payphoneDevice.setStatus(status);
//
//            PayphoneCredentials payphoneCredentials = new PayphoneCredentials();
//
//            payphoneCredentials.setPassword("password");
//            String username = UUID.randomUUID().toString().substring(0, 7);
//            payphoneCredentials.setUsername(username);
//            configData.setDefaultLanguage(
//                    ConfigData.DefaultLanguageEnum.PORTUGUESE);
//            configData.setKeepAliveInterval(300L);
//            configData.setPreferredMSISDN("08035638116");
//            configData.setSendErrorsToOCS(4000L);
//            configData.setSilenceMode(Boolean.TRUE);
//            payphoneService.setModificationDate(getTodaysdate());
//            payphoneService.setPayphoneDevice(payphoneDevice);
//            payphoneService.setPayphoneDevice(payphoneDevice);
//            payphoneService.setSim1(sim1);
//            payphoneService.setSim2(sim2);
//            payphoneService.setStatus(status);
//            payphoneService.setCreationDate(getTodaysdate());
//            payphoneService.setBalance(500.05d);
//            payphoneService.setContractId(554466L);
//            payphoneService.setProfileId(1L);
//            payphoneService.setConfigData(configData);
//            payphoneService.setCredentials(payphoneCredentials);
//
//            SecurityContext securityContext = null;
//            OcsApiServiceImpl instance = new OcsApiServiceImpl();
//            Response expResult = null;
//            Response result = instance.createPayphoneService(umUserHash,
//                    umSessionID, umDomain, payphoneService, securityContext);
//            assertEquals(201, result.getStatus());
//            assertEquals(true, result.hasEntity());
//        } catch (Exception ex) {
//
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//    }
//
//    
//    /**
//     * Test of editPayphoneServiceById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testEditPayphoneServiceById() {
//        
//        String access = "";
//        Long id = 1L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        SIM sim1 = new SIM();
//        SIM sim2 = new SIM();
//        Status status = new Status();
//        status.setStatus(Status.StatusEnum.DISABLED);
//
//        PayphoneService payphoneService = new PayphoneService();
//        PayphoneDevice payphoneDevice = new PayphoneDevice();
//        PayphoneCredentials payphoneCredentials = new PayphoneCredentials();
//        ConfigData configData = new ConfigData();
//        Equipment equipment = new Equipment();
//
//        sim1.setICCID("iccid11228");
//        sim1.setIMSI("imsi33443");
//        sim1.setMSISDN("080976543219");
//
//        sim2.setICCID("iccid3333");
//        sim2.setIMSI("imsi5555");
//        sim2.setMSISDN("08097766559");
//       
//            payphoneCredentials.setPassword("password");
//            String username = UUID.randomUUID().toString().substring(0, 7);
//            payphoneCredentials.setUsername(username);
//            status.setStatusDate(getTodaysdate());
//        configData.setDefaultLanguage(ConfigData.DefaultLanguageEnum.PORTUGUESE);
//        configData.setKeepAliveInterval(300L);
//        configData.setPreferredMSISDN("08035638116");
//        configData.setSendErrorsToOCS(4000L);
//        configData.setSilenceMode(Boolean.TRUE);
//        payphoneService.setModificationDate(getTodaysdate());
//        payphoneService.setPayphoneDevice(payphoneDevice);
//        payphoneService.setSim1(sim1);
//        payphoneService.setSim2(sim2);
//        payphoneService.setStatus(status);
//        payphoneService.setCreationDate(getTodaysdate());
//        payphoneService.setBalance(500.05d);
//        payphoneService.setContractId(554466L);
//        payphoneService.setProfileId(1L);
//        payphoneService.setConfigData(configData);
//        payphoneService.setCredentials(payphoneCredentials);
//
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.editPayphoneServiceById(access, id,
//                    umUserHash, umSessionID, umDomain, payphoneService,
//                    securityContext);
//        } catch (NotFoundException ex) {
//            
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//    /**
//     * Test of deletePayphoneServiceById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testDeletePayphoneServiceById() {
//        String access = "";
//        Long id = 20l;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.deletePayphoneServiceById(access, id, umUserHash,
//                    umSessionID, umDomain, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//
//    }
//
////
////    /**
////     * Test of search method, of class OcsApiServiceImpl.
////     */
////    @Test
////    public final void testSearch() {
////        System.out.println("search");
////        String umUserHash = "";
////        String umSessionID = "";
////        String umDomain = "";
////        Long offset = null;
////        Long limit = null;
////        Long payphoneServiceId = null;
////        Long customerId = null;
////        String username = "";
////        String imei = "";
////        String msisdn = "";
////        SecurityContext securityContext = null;
////        OcsApiServiceImpl instance = new OcsApiServiceImpl();
////        Response expResult = null;
////        Response result = null;
////        try {
////            result = instance.search(umUserHash, umSessionID, umDomain,
////                offset, limit, payphoneServiceId, customerId, username, imei,
////                msisdn, securityContext);
////        } catch (NotFoundException ex) {
////            Logger.getLogger(OcsApiServiceImplTest.class.getName())
////                .log(Level.SEVERE, null, ex);
////        }
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove default call to fail.
////        fail("The test case is a prototype.");
////    }
////
////    /**
////     * Test of searchCalls method, of class OcsApiServiceImpl.
////     */
////    @Test
////    public final void testSearchCalls() {
////        System.out.println("searchCalls");
////        String umUserHash = "";
////        String umSessionID = "";
////        String umDomain = "";
////        Long offset = null;
////        Long limit = null;
////        Long payphoneServiceId = null;
////        Long customerId = null;
////        String username = "";
////        String imei = "";
////        String destinationMsisdn = "";
////        String originMsisdn = "";
////        String iccid = "";
////        Long minDuration = null;
////        SecurityContext securityContext = null;
////        OcsApiServiceImpl instance = new OcsApiServiceImpl();
////        Response expResult = null;
////        Response result = null;
////        try {
////            result = instance.searchCalls(umUserHash, umSessionID,
////                umDomain, offset, limit, payphoneServiceId, customerId,
////                username, imei, destinationMsisdn, originMsisdn, iccid,
////                minDuration, securityContext);
////        } catch (NotFoundException ex) {
////            Logger.getLogger(OcsApiServiceImplTest.class.getName())
////                .log(Level.SEVERE, null, ex);
////        }
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove default call to fail.
////        fail("The test case is a prototype.");
////    }
////
//
//    /**
//     * Test of searchPayphoneService method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testSearchPayphoneService() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Long offset = 0L;
//        Long limit = 20L;
//        Long payphoneId = 23L;
//        Long customerId = 0L;
//        String username = "";
//        String serialNo = "";
//        String mac = "";
//        String imei = "";
//        String msisdn = "08097654321";
//        String iccid = "";
//        String imsi = "";
//        String status = "";
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.searchPayphoneService(umUserHash,
//                    umSessionID, umDomain, offset, limit, payphoneId, customerId,
//                    username, serialNo, mac, imei, msisdn, iccid, imsi, status,
//                    securityContext);
//        } catch (Exception ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//
//    }
////
//
//    /**
//     * Test of searchPayphoneServiceById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testSearchPayphoneServiceById() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        String access = "";
//        Long id = 23L;
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.searchPayphoneServiceById(umUserHash,
//                    umSessionID, umDomain, access, id, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//
//    }
//
//    /**
//     * Test of topupPayphoneServiceById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testTopupPayphoneServiceById() {
//
//        String access = "";
//        Long id = 20L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        TopUpRequest topUpRequest = new TopUpRequest();
//        topUpRequest.setAmount(40.50f);
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = instance.topupPayphoneServiceById(access,
//                id, umUserHash, umSessionID, umDomain, topUpRequest,
//                securityContext);
//
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//
//    }
//
//    @Test
//    public final void testCreateTariff() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Tariff tariffService = new Tariff();
//        tariffService.setGroupId(1L);
//        tariffService.setInitialCost(50.89d);
//        tariffService.setInitialDuration(400L);
//        tariffService.setModulationTypeId(1L);
//        tariffService.setName("Group JTest");
//        tariffService.setProfileId(1L);
//        tariffService.setRecurrentCost(40.88d);
//        tariffService.setRecurrentDuration(333l);
//        tariffService.setSetupCost(50.90d);
//        tariffService.setStatus(true);
//        tariffService.setTariffVersionId(1L);
//
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.createTariff(umUserHash, umSessionID,
//                    umDomain, tariffService, securityContext);
//            
//            assertEquals(201, result.getStatus());
//            assertEquals(true, result.hasEntity());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Test of createPrefix method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testCreatePrefix() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Prefix prefixService = null;
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.createPrefix(umUserHash, umSessionID,
//                    umDomain, prefixService, securityContext);
//
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of deleteGroupById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testDeleteGroupById() {
//        Long id = 25L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.deleteGroupById(id, umUserHash,
//                    umSessionID, umDomain, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of deletePrefixById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testDeletePrefixById() {
//        Long id = 1L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.deletePrefixById(id,
//                    umUserHash, umSessionID, umDomain, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of deleteZoneById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testDeleteZoneById() {
//        Long id = 1L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.deleteZoneById(id, umUserHash,
//                    umSessionID, umDomain, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of editPrefixById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testEditPrefixById() {
//        Long id = 104L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Prefix prefix = new Prefix();
//        prefix.setCountry("Nigeria1");
//        prefix.setDescription("Nigeria1 Prefix ");
//        prefix.setId(id);
//        prefix.setValue(234L);
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.editPrefixById(id, umUserHash,
//                    umSessionID, umDomain, prefix, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
////
//
//    /**
//     * Test of searchGroupById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testSearchGroupById() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Long id = 4L;
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.searchGroupById(umUserHash,
//                    umSessionID, umDomain, id, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of searchPrefixById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testSearchPrefixById() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Long id = 3L;
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.searchPrefixById(umUserHash,
//                    umSessionID, umDomain, id, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of searchZoneById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testSearchZoneById() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Long id = 5L;
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.searchZoneById(umUserHash, umSessionID,
//                    umDomain, id, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
////
//
//    /**
//     * Test of createGroup method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testCreateGroup() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Groups groupService = new Groups();
//        String description =UUID.randomUUID().toString();
//        groupService.setDescription(description);
//        groupService.setName("J2uniy Group");
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.createGroup(umUserHash, umSessionID,
//                    umDomain, groupService, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(201, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of createZone method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testCreateZone() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Zones zoneService = new Zones();
//        String description =UUID.randomUUID().toString();
//        zoneService.setDescription(description);
//        zoneService.setGroupId(3L);
//        zoneService.setName("Junit12 Zone");
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.createZone(umUserHash,
//                    umSessionID, umDomain, zoneService, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(201, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of editGroupById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testEditGroupById() {
//        Long id = 3L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Groups group = new Groups();
//        group.setDescription("New Groups");
//        group.setName("New Group name");
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.editGroupById(id, umUserHash, umSessionID,
//                    umDomain, group, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of editZoneById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testEditZoneById() {
//        Long id = 2L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Zones zone = new Zones();
//        zone.setDescription("Zone Edit22");
//        zone.setGroupId(3L);
//        zone.setName("ZoneEdit");
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.editZoneById(id, umUserHash,
//                    umSessionID, umDomain, zone, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of createTariffVersions method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testCreateTariffVersions() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        TariffVersions tariffVersionService = new TariffVersions();
//        tariffVersionService.setDescription("Junit TariffVersion");
//        tariffVersionService.setActivationDate(getTodaysdate());
//        tariffVersionService.setStatus("NEW");
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.createTariffVersions(umUserHash,
//                    umSessionID, umDomain, tariffVersionService, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//
//    /**
//     * Test of createModulation method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testCreateModulation() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Modulation modulation = new Modulation();
//        modulation.setDays("12345");
//        modulation.setDescription("Modulation Desc.");
//        modulation.setEndTime(3);
//        modulation.setModulationTypeId(1L);
//        modulation.setName("ModulationName");
//        modulation.setProfileId(1L);
//        modulation.setTariffVersionId(1L);
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.createModulation(umUserHash,
//                    umSessionID, umDomain, modulation, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(201, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of createSpecialDay method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testCreateSpecialDay() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        SpecialDay specialDayService = new SpecialDay();
//        specialDayService.setDay(23);
//        specialDayService.setDescription("PEAK");
//        specialDayService.setMonth(12);
//        specialDayService.setYear(2016);
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.createSpecialDay(umUserHash, umSessionID,
//                    umDomain, specialDayService, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//
//        assertEquals(201, result.getStatus());
//        assertEquals(true, result.hasEntity());
//
//        // TODO review the generated test code and remove default call to fail.
//    }
//
//    /**
//     * Test of deleteModulationById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testDeleteModulationById() {
//        Long id = 9L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.deleteModulationById(id,
//                    umUserHash, umSessionID, umDomain, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of deleteSpecialDayById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testDeleteSpecialDayById() {
//        Long id = 1L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.deleteSpecialDayById(id,
//                    umUserHash, umSessionID, umDomain, securityContext);
//        } catch (Exception ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
////
//
//    /**
//     * Test of editModulationById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testEditModulationById() {
//        Long id = 8L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Modulation modulation = new  Modulation();
//        modulation.setDays("2356");
//        modulation.setDescription("Updated Modulations");
//        modulation.setEndTime(5);
//        modulation.setId(id);
//        modulation.setModulationTypeId(1L);
//        modulation.setName("Modulation EditName");
//        modulation.setProfileId(1L);
//        modulation.setTariffVersionId(1L);
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.editModulationById(id, umUserHash,
//                    umSessionID, umDomain, modulation, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
////
//
//    /**
//     * Test of editSpecialDayById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testEditSpecialDayById() {
//        Long id = 1L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        SpecialDay specialDay = new SpecialDay();
//        specialDay.setDay(4);
//        specialDay.setDescription("Edit Special Day");
//        specialDay.setMonth(3);
//        specialDay.setYear(2016);
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.editSpecialDayById(id, umUserHash,
//                    umSessionID, umDomain, specialDay, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//
//    /**
//     * Test of searchModulationById method, of class OcsApiServiceImpl.
//     */
    @Test
    public final void testSearchModulationById() {
        String umUserHash = "";
        String umSessionID = "";
        String umDomain = "";
        Long id = 8L;
        SecurityContext securityContext = null;
        OcsApiServiceImpl instance = new OcsApiServiceImpl();
        Response expResult = null;
        Response result = null;
        try {
            result = instance.searchModulationById(umUserHash,
                    umSessionID, umDomain, id, securityContext);
        } catch (NotFoundException ex) {
            Logger.getLogger(OcsApiServiceImplTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        assertEquals(200, result.getStatus());
        assertEquals(true, result.hasEntity());

    }
//
    /**
     * Test of searchSpecialDayById method, of class OcsApiServiceImpl.
     */
    @Test
    public final void testSearchSpecialDayById() {
        String umUserHash = "";
        String umSessionID = "";
        String umDomain = "";
        Long id = 67L;
        SecurityContext securityContext = null;
        OcsApiServiceImpl instance = new OcsApiServiceImpl();
        Response expResult = null;
        Response result = null;
        try {
            result = instance.searchSpecialDayById(umUserHash,
                    umSessionID, umDomain, id, securityContext);
        } catch (NotFoundException ex) {
            Logger.getLogger(OcsApiServiceImplTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        assertEquals(200, result.getStatus());
        assertEquals(true, result.hasEntity());
    }
//
//    /**
//     * Test of deleteTariffById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testDeleteTariffById() {
//        Long id = 4L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.deleteTariffById(id, umUserHash,
//                    umSessionID, umDomain, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName()).
//                    log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }
//
//    /**
//     * Test of editTariffById method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testEditTariffById() {
//        Long id = 4L;
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        Tariff tariff = new Tariff();
//        tariff.setGroupId(id);
//        tariff.setInitialCost(650.765d);
//        tariff.setInitialDuration(669L);
//        tariff.setModulationTypeId(1L);
//        tariff.setName("Edit Tariff By Id");
//        tariff.setProfileId(1L);
//        tariff.setRecurrentCost(546.99d);
//        tariff.setRecurrentDuration(321L);
//        tariff.setSetupCost(54390.48d);
//        tariff.setStatus(Boolean.TRUE);
//        tariff.setTariffVersionId(1L);
//        tariff.setZoneId(2L);
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.editTariffById(id, umUserHash,
//                    umSessionID, umDomain, tariff, securityContext);
//        } catch (NotFoundException ex) {
//            Logger.getLogger(OcsApiServiceImplTest.class.getName()).
//                    log(Level.SEVERE, null, ex);
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }

    /**
     * Test of searchTariffById method, of class OcsApiServiceImpl.
     */
    @Test
    public final void testSearchTariffById() {
        String umUserHash = "";
        String umSessionID = "";
        String umDomain = "";
        Long id = 48L;
        SecurityContext securityContext = null;
        OcsApiServiceImpl instance = new OcsApiServiceImpl();
        Response expResult = null;
        Response result = null;
        try {
            result = instance.searchTariffById(umUserHash,
                    umSessionID, umDomain, id, securityContext);
        } catch (NotFoundException ex) {
            Logger.getLogger(OcsApiServiceImplTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        assertEquals(200, result.getStatus());
        assertEquals(true, result.hasEntity());
    }

    /**
     * Test of searchGroups method, of class OcsApiServiceImpl.
     */
    @Test
    public final void testSearchGroups() {
        String umUserHash = "";
        String umSessionID = "";
        String umDomain = "";
        Long offset = 0L;
        Long limit = 117L;
        String name = "";
        SecurityContext securityContext = null;
        OcsApiServiceImpl instance = new OcsApiServiceImpl();
        Response expResult = null;
        Response result = null;
        try {
            result = instance.searchGroups(umUserHash,
                    umSessionID, umDomain, offset, limit, name, securityContext);
        } catch (NotFoundException ex) {
            Logger.getLogger(OcsApiServiceImplTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        assertEquals(200, result.getStatus());
        assertEquals(true, result.hasEntity());
    }
//
    /**
     * Test of searchZones method, of class OcsApiServiceImpl.
     */
    @Test
    public final void testSearchZones() {
        String umUserHash = "";
        String umSessionID = "";
        String umDomain = "";
        Long offset = 0L;
        Long limit = 20L;
        Long groupId = 73L;
        String name = "";
        SecurityContext securityContext = null;
        OcsApiServiceImpl instance = new OcsApiServiceImpl();
        Response expResult = null;
        Response result = null;
        try {
            result = instance.searchZones(umUserHash, umSessionID,
                    umDomain, offset, limit, groupId, name, securityContext);
        } catch (NotFoundException ex) {
            Logger.getLogger(OcsApiServiceImplTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        assertEquals(200, result.getStatus());
        assertEquals(true, result.hasEntity());
    }
//
//
    /**
     * Test of searchPrefixes method, of class OcsApiServiceImpl.
     */
    @Test
    public final void testSearchPrefixes() {
        String umUserHash = "";
        String umSessionID = "";
        String umDomain = "";
        Long offset = 0L;
        Long limit = 20L;
        String name = "";
        SecurityContext securityContext = null;
        OcsApiServiceImpl instance = new OcsApiServiceImpl();
        Response expResult = null;
        Response result = null;
        try {
            result = instance.searchPrefixes(umUserHash, umSessionID,
                    umDomain, offset, limit, name, securityContext);
        } catch (NotFoundException ex) {
            Logger.getLogger(OcsApiServiceImplTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        assertEquals(200, result.getStatus());
        assertEquals(true, result.hasEntity());
    }
////
//
    /**
     * Test of searchTariffVersions method, of class OcsApiServiceImpl.
     */
    @Test
    public final void testSearchTariffVersions() {
        String umUserHash = "";
        String umSessionID = "";
        String umDomain = "";
        Long offset = 0L;
        Long limit = 20L;
        Long tariffVersionId = null;
        Long customerId = null;
        String name = "";
        SecurityContext securityContext = null;
        OcsApiServiceImpl instance = new OcsApiServiceImpl();
        Response expResult = null;
        Response result = null;
        try {
            result = instance.searchTariffVersions(umUserHash,
                    umSessionID, umDomain, offset, limit, tariffVersionId,
                    customerId, name, securityContext);
        } catch (NotFoundException ex) {
            Logger.getLogger(OcsApiServiceImplTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        assertEquals(200, result.getStatus());
        assertEquals(true, result.hasEntity());
    }

    /**
     * Test of searchTariffs method, of class OcsApiServiceImpl.
     */
    @Test
    public final void testSearchTariffs() {
        String umUserHash = "";
        String umSessionID = "";
        String umDomain = "";
        Long offset = 0L;
        Long limit = 20L;
        Long tariffVersionId = 38L;
        Long customerId = null;
        String name = "";
        SecurityContext securityContext = null;
        OcsApiServiceImpl instance = new OcsApiServiceImpl();
        Response expResult = null;
        Response result = null;
        try {
            result = instance.searchTariffs(umUserHash,
                    umSessionID, umDomain, offset, limit,
                    tariffVersionId, customerId, name, securityContext);
        } catch (NotFoundException ex) {
            Logger.getLogger(OcsApiServiceImplTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        assertEquals(200, result.getStatus());
        assertEquals(true, result.hasEntity());
    }

    /**
     * Test of searchModulations method, of class OcsApiServiceImpl.
     */
    @Test
    public final void testSearchModulations() {
        String umUserHash = "";
        String umSessionID = "";
        String umDomain = "";
        Long offset = 0L;
        Long limit = 20L;
        SecurityContext securityContext = null;
        OcsApiServiceImpl instance = new OcsApiServiceImpl();
        Response expResult = null;
        Response result = null;
        try {
            result = instance.searchModulations(umUserHash,
                    umSessionID, umDomain, offset, limit, securityContext);
        } catch (NotFoundException ex) {
            Logger.getLogger(OcsApiServiceImplTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        assertEquals(200, result.getStatus());
        assertEquals(true, result.hasEntity());
    }
//
    /**
     * Test of searchSpecialDays method, of class OcsApiServiceImpl.
     */
    @Test
    public final void testSearchSpecialDays() {
        String umUserHash = "";
        String umSessionID = "";
        String umDomain = "";
        Long offset = 0L;
        Long limit = 20L;
        SecurityContext securityContext = null;
        OcsApiServiceImpl instance = new OcsApiServiceImpl();
        Response expResult = null;
        Response result = null;
        try {
            result = instance.searchSpecialDays(umUserHash,
                    umSessionID, umDomain, offset, limit, securityContext);
        } catch (NotFoundException ex) {
            Logger.getLogger(OcsApiServiceImplTest.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(200, result.getStatus());
        assertEquals(true, result.hasEntity());
    }

    /**
     * Test of setBalancePayphoneServiceById method, of class OcsApiServiceImpl.
     */
    @Test
    public final void testSetBalancePayphoneServiceById() {
        String access = "";
        Long id = 100L;
        String umUserHash = "";
        String umSessionID = "";
        String umDomain = "";
        TopUpRequest topUpRequest = new TopUpRequest();
        topUpRequest.setAmount(100.88f);
        SecurityContext securityContext = null;
        OcsApiServiceImpl instance = new OcsApiServiceImpl();
        Response expResult = null;
        Response result = null;
        try {
            result = instance.setBalancePayphoneServiceById(access, id,
                    umUserHash, umSessionID, umDomain, topUpRequest,
                    securityContext);

            assertEquals(200, result.getStatus());
            assertEquals(true, result.hasEntity());
        } catch (NotFoundException ex) {
            Logger.getLogger(OcsApiServiceImplTest.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
//
//    /**
//     * Test of cloneTariffVersions method, of class OcsApiServiceImpl.
//     */
//    @Test
//    public final void testCloneTariffVersions() {
//        String umUserHash = "";
//        String umSessionID = "";
//        String umDomain = "";
//        TariffVersions cloneTariffVersionService = new TariffVersions();
//        cloneTariffVersionService.setDescription("New Colon Tariff");
//        cloneTariffVersionService.setId(2L);
//        SecurityContext securityContext = null;
//        OcsApiServiceImpl instance = new OcsApiServiceImpl();
//        Response expResult = null;
//        Response result = null;
//        try {
//            result = instance.cloneTariffVersions(
//                    umUserHash, umSessionID, umDomain,
//                    cloneTariffVersionService, securityContext);
//        } catch (NotFoundException ex) {
//        }
//        assertEquals(200, result.getStatus());
//        assertEquals(true, result.hasEntity());
//    }

    public final Date getTodaysdate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateFormat.format(date);
        return date;
    }
}
