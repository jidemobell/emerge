package com.emerge.ocs.rest.service;

import com.emerge.ocs.rest.api.NotFoundException;
import com.emerge.ocs.rest.model.Groups;
import com.emerge.ocs.rest.model.Modulation;
import com.emerge.ocs.rest.model.PayphoneService;
import com.emerge.ocs.rest.model.Prefix;
import com.emerge.ocs.rest.model.SpecialDay;
import com.emerge.ocs.rest.model.Status;
import com.emerge.ocs.rest.model.TopUpRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.emerge.ocs.rest.model.Tariff;
import com.emerge.ocs.rest.model.TariffVersions;
import com.emerge.ocs.rest.model.Zones;

@javax.annotation.Generated(
        value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen",
        date = "2016-10-21T16:15:52.666Z")
public abstract class OcsApiService {

    public abstract Response createGroup(String umUserHash, String umSessionID,
            String umDomain,
            Groups groupService, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response createModulation(
            String umUserHash, String umSessionID, String umDomain,
            Modulation modulation, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response createPayphoneService(
            String umUserHash, String umSessionID, String umDomain,
            PayphoneService payphoneService, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response createZone(
            String umUserHash, String umSessionID, String umDomain,
            Zones zoneService, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response deletePayphoneServiceById(
            String access, Long id, String umUserHash, String umSessionID,
            String umDomain, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response editPayphoneServiceById(String access, Long id,
            String umUserHash, String umSessionID, String umDomain,
            PayphoneService payphone, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response getPayphoneDeviceById(String umUserHash,
            String umSessionID, String umDomain, Long id,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response search(String umUserHash, String umSessionID,
            String umDomain, Long offset, Long limit, Long payphoneServiceId,
            Long customerId, String username, String IMEI, String msisdn,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchCalls(String umUserHash, String umSessionID,
            String umDomain, Long offset, Long limit, Long payphoneServiceId,
            Long customerId, String username, String IMEI,
            String destinationMsisdn, String originMsisdn, String iccid,
            Long minDuration, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response searchPayphoneService(String umUserHash,
            String umSessionID, String umDomain, Long offset, Long limit,
            Long payphoneId, Long customerId, String username, String serialNo,
            String mac, String IMEI, String msisdn, String iccid, String imsi,
            String status,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchPayphoneServiceById(String umUserHash,
            String umSessionID, String umDomain, String access, Long id,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response topupPayphoneServiceById(String access, Long id,
            String umUserHash, String umSessionID, String umDomain,
            TopUpRequest topUpRequest, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response createTariff(String umUserHash,
            String umSessionID, String umDomain, Tariff tariffService,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response createPrefix(String umUserHash, String umSessionID,
            String umDomain, Prefix prefixService,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteGroupById(Long id, String umUserHash,
            String umSessionID, String umDomain,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response deletePrefixById(Long id, String umUserHash,
            String umSessionID, String umDomain,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteZoneById(Long id, String umUserHash,
            String umSessionID, String umDomain,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response editGroupById(Long id, String umUserHash,
            String umSessionID, String umDomain, Groups group,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response editPrefixById(Long id,
            String umUserHash, String umSessionID, String umDomain,
            Prefix payphone, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response editZoneById(Long id, String umUserHash,
            String umSessionID, String umDomain, Zones zone,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchGroupById(String umUserHash,
            String umSessionID, String umDomain, Long id,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchPrefixById(String umUserHash,
            String umSessionID, String umDomain, Long id,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchZoneById(String umUserHash,
            String umSessionID, String umDomain, Long id,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response createTariffVersions(String umUserHash,
            String umSessionID, String umDomain,
            TariffVersions tariffVersionService,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response createSpecialDay(String umUserHash,
            String umSessionID, String umDomain,
            SpecialDay specialDayService,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteModulationById(Long id,
            String umUserHash, String umSessionID,
            String umDomain, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response deleteSpecialDayById(Long id,
            String umUserHash, String umSessionID, String umDomain,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response editModulationById(Long id,
            String umUserHash, String umSessionID, String umDomain,
            Modulation specialDay, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response editSpecialDayById(Long id,
            String umUserHash, String umSessionID, String umDomain,
            SpecialDay specialDay, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response searchModulationById(String umUserHash,
            String umSessionID, String umDomain, Long id,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchSpecialDayById(String umUserHash,
            String umSessionID, String umDomain, Long id,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response deleteTariffById(Long id,
            String umUserHash, String umSessionID, String umDomain,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response editTariffById(Long id, String umUserHash,
            String umSessionID, String umDomain, Tariff tariff,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchTariffById(String umUserHash,
            String umSessionID, String umDomain, Long id,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchGroups(String umUserHash, String umSessionID,
            String umDomain, Long offset, Long limit, String name,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchZones(String umUserHash, String umSessionID,
            String umDomain, Long offset, Long limit, Long groupId, String name,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchPrefixes(String umUserHash,
            String umSessionID,
            String umDomain,
            Long offset, Long limit, String country,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchTariffVersions(String umUserHash,
            String umSessionID,
            String umDomain, Long offset, Long limit, Long tariffVersionId,
            Long customerId, String username,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchTariffs(String umUserHash, String umSessionID,
            String umDomain, Long offset, Long limit, Long tariffVersionId,
            Long customerId, String username, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response searchModulations(String umUserHash,
            String umSessionID, String umDomain, Long offset, Long limit,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchSpecialDays(String umUserHash,
            String umSessionID, String umDomain, Long offset,
            Long limit, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response setBalancePayphoneServiceById(String access,
            Long id, String umUserHash, String umSessionID, String umDomain,
            TopUpRequest topUpRequest, SecurityContext securityContext)
            throws NotFoundException;

    public abstract Response cloneTariffVersions(String umUserHash,
            String umSessionID, String umDomain,
            TariffVersions cloneTariffVersionService,
            SecurityContext securityContext) throws NotFoundException;

    public abstract Response searchTariffVersionsById(String umUserHash,
            String umSessionID, String umDomain, Long id,
            SecurityContext securityContext) throws NotFoundException;
    
public abstract Response disablePayphoneServiceById(Long id,String umUserHash,
        String umSessionID,String umDomain,Status payphoneStatus,
        SecurityContext securityContext) throws NotFoundException;
}
