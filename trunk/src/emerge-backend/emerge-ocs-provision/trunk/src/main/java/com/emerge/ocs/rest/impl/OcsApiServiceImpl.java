package com.emerge.ocs.rest.impl;

import com.emerge.ocs.database.history.HDBResource;
import com.emerge.ocs.database.history.model.OngoingServiceInformationDAO;
import com.emerge.ocs.database.model.PayphoneDAO;
import com.emerge.ocs.database.model.PayphoneGroupDAO;
import com.emerge.ocs.database.model.PayphoneGroupDAOSub;
import com.emerge.ocs.rest.api.ApiResponseMessage;
import com.emerge.ocs.rest.api.NotFoundException;
import com.emerge.ocs.rest.model.Groups;
import com.emerge.ocs.rest.model.Modulation;
import com.emerge.ocs.rest.model.PayphoneDevice;

import com.emerge.ocs.rest.model.Prefix;
import com.emerge.ocs.rest.model.Tariff;
import com.emerge.ocs.rest.model.PayphoneService;
import com.emerge.ocs.rest.model.SpecialDay;
import com.emerge.ocs.rest.model.TariffVersions;

import com.emerge.ocs.rest.model.TopUpRequest;
import com.emerge.ocs.rest.model.TopupRsp;
import com.emerge.ocs.rest.model.Zones;
import com.emerge.ocs.rest.service.OcsApiService;
import java.net.UnknownHostException;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import org.elasticsearch.index.IndexNotFoundException;
import org.json.simple.JSONObject;

/**
 *
 * @author goodson
 */
@javax.annotation.Generated(value
        = "class io.swagger.codegen.languages.JavaJerseyServerCodegen",
        date = "2016-10-18T16:03:25.845Z")

public class OcsApiServiceImpl extends OcsApiService {

    private PayphoneDAO payphones;
    private PayphoneGroupDAO payphoneGroupDAO;

    /**
     *
     *
     */
    public OcsApiServiceImpl() {
        payphones = new PayphoneDAO();
        payphoneGroupDAO = new PayphoneGroupDAOSub();
    }

    /**
     *
     * @param umUserHash The umUserHash
     * @param umSessionID The umSessionID
     * @param umDomain The umDomain
     * @param payphoneService The payphoneService
     * @param securityContext The securityContext
     * @return HTTP Response
     * @throws NotFoundException Exception
     */
    @Override
    public final Response createPayphoneService(final String umUserHash,
            final String umSessionID, final String umDomain,
            final PayphoneService payphoneService,
            final SecurityContext securityContext) throws NotFoundException {
        try {

            if (payphoneService.getCredentials().getUsername().isEmpty()) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Username is empty")).build();
            }
            if (!payphoneService.getCredentials().getUsername()
                    .matches("^[a-zA-Z0-9_]+$")) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Username contains space or special characters")
                        ).build();
            }
            if (payphoneService.getSim1().getMSISDN().isEmpty()) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "SIM1 MSISDN is empty")).build();
            }

            if (!payphoneService.getSim1().getMSISDN().matches("^[0-9+]+$")) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "SIM1 MSISDN contains Alphabet or "
                                + " special character")).build();
            }
            if (payphoneService.getSim1().getIMSI().isEmpty()) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "SIM1 MSISDN is empty")).build();
            }
            if (payphoneService.getSim1().getICCID().isEmpty()) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "SIM1 ICCID is empty")).build();
            }
            if (payphoneService.getProfileId() == 0
                    || payphoneService.getProfileId().toString().isEmpty()) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Profile ID value is not set")).build();
            }
            if (payphoneService.getConfigData().getKeepAliveInterval().
                    toString().isEmpty()) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Keep Alive value is not set")).build();
            }
            if (!payphoneService.getConfigData().getKeepAliveInterval().
                    toString().matches("^[0-9]+$")) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Keep Alive value contains special "
                                + "characters")).build();
            }
            if (!payphoneService.getConfigData().getPreferredMSISDN()
                    .matches("^[0-9+]+$")) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Preffered MSISDN contains alphabets or special"
                                + " characters")).build();
            }
//            HDBResource.put(payphoneService, "payphone_services", "create");
            PayphoneService payphoneServiceResponse
                    = payphones.createServices(payphoneService);
            if (payphoneServiceResponse.getId() > 0) {
                return Response.status(Response.Status.CREATED)
                        .entity(payphoneServiceResponse).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    /**
     *
     * @param access The access
     * @param id The id
     * @param umUserHash The umUserHash
     * @param umSessionID The umSessionID
     * @param umDomain The umDomain
     * @param securityContext The securityContext
     * @return HTTP Response
     * @throws NotFoundException Exception
     */
    @Override
    public final Response deletePayphoneServiceById(final String access,
            final Long id, final String umUserHash, final String umSessionID,
            final String umDomain, final SecurityContext securityContext)
            throws NotFoundException {
        int response = payphones.deletePayphoneById(
                access, id, umUserHash, umSessionID, umDomain);
        if (response == 1) {
            return Response.ok().entity(
                    new ApiResponseMessage(ApiResponseMessage.OK,
                            "Payphone deleted")).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "unexpected error")).build();
        }
    }

    /**
     *
     * @param access The access
     * @param id The id
     * @param umUserHash The umUserHash
     * @param umSessionID The umSessionID
     * @param umDomain The umDomain
     * @param payphoneService The payphoneService
     * @param securityContext The securityContext
     * @return HTTP Response
     * @throws NotFoundException Exception
     */
    @Override
    public final Response editPayphoneServiceById(final String access,
            final Long id, final String umUserHash, final String umSessionID,
            final String umDomain, final PayphoneService payphoneService,
            final SecurityContext securityContext) throws NotFoundException {
        try {

            if (!payphoneService.getSim1().getMSISDN().matches("^[0-9+]+$")) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "SIM1 MSISDN contains Alphabet or "
                                + " special character")).build();
            }


            if (payphoneService.getSim2().getMSISDN().length() < 1) {

                payphoneService.getSim2().getMSISDN();
               
            } 
                if (!payphoneService.getSim2().getMSISDN().matches("^[0-9+]+$")
                        && payphoneService.getSim2().getMSISDN().length() != 0) {
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                    "SIM2 MSISDN contains Alphabet or "
                                    + " special character")).build();
                    
                }
                if (payphoneService.getSim2().getMSISDN().length() < 1){
                        payphoneService.getSim2().setMSISDN(null);
                    }

            
            if (!payphoneService.getConfigData().getPreferredMSISDN()
                    .matches("^[0-9+]+$")) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Preffered MSISDN contains alphabets or special"
                                + " characters")).build();
            }
            int response = payphones.updatePayphoneById(access, id, umUserHash,
                    umSessionID, umDomain, payphoneService);
            if (response == 1) {
                return Response.ok().entity(payphoneService).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "unexpected error")).build();
        }
    }

    /**
     *
     * @param umUserHash The umUserHash
     * @param umSessionID The umSessionID
     * @param umDomain The umDomain
     * @param id The id
     * @param securityContext The securityContext
     * @return HTTP Response
     * @throws NotFoundException Exception
     */
    @Override
    public final Response getPayphoneDeviceById(final String umUserHash,
            final String umSessionID, final String umDomain, final Long id,
            final SecurityContext securityContext) throws NotFoundException {
        return Response.status(Response.Status.NOT_IMPLEMENTED)
                .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                        "Not Implemented")).build();
    }

    /**
     *
     * @param umUserHash The umUserHash
     * @param umSessionID The umSessionID
     * @param umDomain The umDomain
     * @param offset The offset
     * @param limit The limit
     * @param payphoneServiceId The payphoneServiceId
     * @param customerId The customerId
     * @param username The username
     * @param imei The imei
     * @param msisdn The msisdn
     * @param securityContext The securityContext
     * @return HTTP Response
     * @throws NotFoundException Exception
     */
    @Override
    public final Response search(final String umUserHash,
            final String umSessionID, final String umDomain,
            final Long offset, final Long limit, final Long payphoneServiceId,
            final Long customerId, final String username, final String imei,
            final String msisdn, final SecurityContext securityContext)
            throws NotFoundException {

        return Response.status(Response.Status.NOT_IMPLEMENTED)
                .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                        "Not Implemented")).build();
    }

    /**
     *
     * @param umUserHash The umUserHash
     * @param umSessionID The umSessionID
     * @param umDomain The umDomain
     * @param offset The offset
     * @param limit The limit
     * @param payphoneServiceId The payphoneServiceId
     * @param customerId The customerId
     * @param username The username
     * @param imei The imei
     * @param destinationMsisdn The destinationMsisdn
     * @param originMsisdn The originMsisdn
     * @param iccid The iccid
     * @param minDuration The minDuration
     * @param securityContext The securityContext
     * @return HTTP Response
     * @throws NotFoundException Exception
     */
    @Override
    public final Response searchCalls(final String umUserHash,
            final String umSessionID, final String umDomain, final Long offset,
            final Long limit, final Long payphoneServiceId,
            final Long customerId,
            final String username, final String imei,
            final String destinationMsisdn, final String originMsisdn,
            final String iccid, final Long minDuration,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            Map<String, Object> onGoingServiceRecords
                    = new OngoingServiceInformationDAO()
                    .find(offset, limit, payphoneServiceId, customerId,
                            username, imei, destinationMsisdn,
                            originMsisdn, iccid, minDuration);
            return Response.ok().entity(onGoingServiceRecords).build();
        } catch (UnknownHostException | IndexNotFoundException ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    /**
     *
     * @param umUserHash The umUserHash
     * @param umSessionID The umSessionID
     * @param umDomain The umDomain
     * @param offset The offset
     * @param limit The limit
     * @param payphoneId The payphoneId
     * @param customerId The customerId
     * @param username The username
     * @param serialNo The serialNo
     * @param mac The mac
     * @param imei The imei
     * @param msisdn The msisdn
     * @param iccid The iccid
     * @param imsi The imsi
     * @param status The status
     * @param securityContext The securityContext
     * @return HTTP Response
     * @throws NotFoundException NotFoundException
     */
    @Override
    public final Response searchPayphoneService(final String umUserHash,
            final String umSessionID, final String umDomain, final Long offset,
            final Long limit, final Long payphoneId, final Long customerId,
            final String username, final String serialNo, final String mac,
            final String imei, final String msisdn, final String iccid,
            final String imsi,
            final String status, final SecurityContext securityContext)
            throws NotFoundException {
        try {
            JSONObject o = payphones
                    .searchPayphoneService(umUserHash, umSessionID, umDomain,
                            offset, limit, payphoneId, customerId, username,
                            serialNo, mac, imei, msisdn, iccid, imsi, status);
            return Response.ok().entity(o).build();
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    /**
     *
     * @param umUserHash The umUserHash
     * @param umSessionID The umSessionID
     * @param umDomain The umDomain
     * @param access The access
     * @param id The id
     * @param securityContext The securityContext
     * @return HTTP Response
     * @throws NotFoundException
     */
    @Override
    public final Response searchPayphoneServiceById(final String umUserHash,
            final String umSessionID, final String umDomain,
            final String access, final Long id,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            PayphoneService payphone = payphones.searchPayphoneById(umUserHash,
                    umSessionID, umDomain, access, id);
            if (payphone.getId() > 0) {
                return Response.ok().entity(payphone).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponseMessage(
                                ApiResponseMessage.INFO, "NOT FOUND")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(
                            ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    /**
     *
     * @param access The access
     * @param id The id
     * @param umUserHash The umUserHash
     * @param umSessionID The umSessionID
     * @param umDomain The umDomain
     * @param topUpRequest The topUpRequest
     * @param securityContext The securityContext
     * @return HTTP Response
     */
    @Override
    public final Response topupPayphoneServiceById(String access,
            final Long id, final String umUserHash, final String umSessionID,
            final String umDomain, final TopUpRequest topUpRequest,
            final SecurityContext securityContext) {
        try {

            if (!topUpRequest.getAmount().toString().matches("^[0-9.]+$")) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Amount contains  special characters")
                        ).build();
            }
            float amount = topUpRequest.getAmount();
            TopupRsp topupRsp = payphones.topUpPayPhonebyId(access, id,
                    umUserHash, umSessionID, umDomain, amount);
            return Response.ok().entity(topupRsp).build();
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName()).log(
                    Level.SEVERE, null, ex);
            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "unexpected error")).build();
        }
    }

    @Override
    public final Response createTariff(final String umUserHash,
            final String umSessionID, final String umDomain,
            final Tariff tariffService, final SecurityContext securityContext)
            throws NotFoundException {
        try {
            if (tariffService.getName().isEmpty()
                    || tariffService.getName() == null) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Name is empty or Null")).build();
            }
            if (tariffService.getInitialCost() == 0.0f) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Initail Cost is empty")).build();
            }
            if (tariffService.getSetupCost() == 0.0f) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Setup cost field is empty")).build();
            }
            if (tariffService.getRecurrentCost() == 0.0f) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Recurrent cost field is empty")).build();
            }
            if (!tariffService.getInitialCost().toString().matches("^[0-9.]+$")) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Initail Cost contains special Character"
                        )).build();
            }
            if (!tariffService.getSetupCost().toString().matches("^[0-9.]+$")) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Setup cost contains alphabets or "
                                + "special character")).build();
            }

            if (!tariffService.getRecurrentCost().toString().matches("^[0-9.]+$")) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Recurrent cost contains "
                                + "alphabets or special characters")
                        ).build();
            }

            if (tariffService.getProfileId() == 0L) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Profile Id field is empty")).build();
            }
            if (tariffService.getRecurrentDuration() == 0L) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Recurrent Duration field is empty"))
                        .build();
            }
            if (tariffService.getModulationTypeId() == 0L) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Modulation Type Id field is empty"))
                        .build();
            }
            if (tariffService.getGroupId() == 0L) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Group Id field is empty")).build();
            }
            if (tariffService.getInitialDuration() == 0.0f) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Initial duration field is empty"))
                        .build();
            }
            Tariff tariff = payphoneGroupDAO.createTariff(tariffService);
            if (tariff.getId() > 0) {
                return Response.status(Response.Status.CREATED)
                        .entity(tariff).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    /**
     *
     * @param umUserHash umUserHash
     * @param umSessionID umSessionID
     * @param umDomain umDomain
     * @param prefixService prefixService
     * @param securityContext securityContext
     * @return HTTP Response
     * @throws NotFoundException Exception
     */
    /**
     *
     * @param umUserHash umUserHash
     * @param umSessionID umSessionID
     * @param umDomain umDomain
     * @param prefixService prefixService
     * @param securityContext securityContext
     * @return HTTP Response
     * @throws NotFoundException Exception
     */
    @Override
    public final Response createPrefix(final String umUserHash,
            final String umSessionID,
            final String umDomain,
            final Prefix prefixService,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (prefixService.getCountry() == null
                    || prefixService.getCountry().isEmpty()) {

                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Zone Country is empty")).build();
            }
            if (prefixService.getValue() == 0.0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Prefix Value is empty")).build();
            }
            Prefix prefix = payphoneGroupDAO.createPrefixes(prefixService);
            if (prefix.getId() > 0) {
                return Response.status(Response.Status.CREATED)
                        .entity(prefix).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {
            if (e.getMessage().substring(132, 145).equals("already exist")) {
                return Response.status(409)
                        .entity(new ApiResponseMessage(409,
                                "Prefixes Already Exist")).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Internal Server Error")).build();
            }
        }
    }

    /**
     *
     * @param id id
     * @param umUserHash umUserHash
     * @param umSessionID umSessionID
     * @param umDomain umDomain
     * @param securityContext securityContext
     * @return
     * @throws NotFoundException Exception
     */
    /**
     *
     * @param id id
     * @param umUserHash umUserHash
     * @param umSessionID umSessionID
     * @param umDomain umDomain
     * @param securityContext securityContext
     * @return
     * @throws NotFoundException Exception
     */
    @Override
    public final Response deleteGroupById(final Long id,
            final String umUserHash,
            final String umSessionID, final String umDomain,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (id == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Group Id can not be empty")).build();
            }
            // Groups groupId = payphoneGroupDAO.searchGroupById(null, null, null, id);
            int response = payphoneGroupDAO.deleteGroupById(id,
                    umUserHash, umSessionID, umDomain);
            if (response > 0) {
                /* Groups group = new Groups();
                group.setId(id);
                group.set
                HDBResource.put(group, "groups", "delete");*/
                //   Groups groupId = payphoneGroupDAO.searchGroupById(null, null, null, id);
                // HDBResource.put(groupId, "groups", "delete");
                return Response.ok().entity(new ApiResponseMessage(
                        ApiResponseMessage.OK, "Group Deleted !")).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response deletePrefixById(
            final Long id, final String umUserHash, final String umSessionID,
            final String umDomain, final SecurityContext securityContext)
            throws NotFoundException {
        try {

            int response = payphoneGroupDAO.deletePrefixById(id,
                    umUserHash, umSessionID, umDomain);
            if (response > 0) {
                //        Prefix prefix = 
                //              payphoneGroupDAO.searchPrefixById(null, null, null, id);

//                HDBResource.put(prefix, "prefixes", "delete");
                return Response.ok().entity(new ApiResponseMessage(
                        ApiResponseMessage.OK, "Prefix Deleted !")).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response deleteZoneById(final Long id, final String umUserHash,
            final String umSessionID, final String umDomain,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (id == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Zone Id can not be empty")).build();
            }
            int response = payphoneGroupDAO.deleteZoneById(id,
                    umUserHash, umSessionID, umDomain);
            if (response > 0) {
                //     Zones zone = payphoneGroupDAO
                //           .searchZoneById(null, null, null, id);

//                HDBResource.put(zone, "zones", "delete");
                return Response.ok().entity(new ApiResponseMessage(
                        ApiResponseMessage.OK, "Zone Deleted !")).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response editPrefixById(final Long id,
            final String umUserHash, final String umSessionID,
            final String umDomain, final Prefix prefix,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            int response = payphoneGroupDAO.updatePrefixById(id, umUserHash,
                    umSessionID, umDomain, prefix);
            if (response == 1) {
                return Response.ok().entity(prefix).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Unexpected error")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Unexpected error")).build();
        }
    }

    @Override
    public final Response searchGroupById(final String umUserHash,
            final String umSessionID, final String umDomain, final Long id,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            Groups group = payphoneGroupDAO.searchGroupById(umUserHash,
                    umSessionID, umDomain, id);
            if (group.getId() > 0) {
                return Response.ok().entity(group).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponseMessage(
                                ApiResponseMessage.INFO, "NOT FOUND")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(
                            ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response searchPrefixById(final String umUserHash,
            final String umSessionID, final String umDomain, final Long id,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            Prefix prefix = payphoneGroupDAO.searchPrefixById(umUserHash,
                    umSessionID, umDomain, id);
            if (prefix.getId() > 0) {
                return Response.ok().entity(prefix).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponseMessage(
                                ApiResponseMessage.INFO, "NOT FOUND")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(
                            ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response searchZoneById(final String umUserHash,
            final String umSessionID, final String umDomain, final Long id,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (id == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Zone Description is empty")).build();
            }
            Zones zone = payphoneGroupDAO.searchZoneById(umUserHash,
                    umSessionID, umDomain, id);
            if (zone.getId() > 0) {
                return Response.ok().entity(zone).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponseMessage(
                                ApiResponseMessage.INFO, "NOT FOUND")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(
                            ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response createGroup(final String umUserHash,
            final String umSessionID,
            final String umDomain,
            final Groups groupService,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (groupService.getDescription() == null
                    || groupService.getDescription().isEmpty()) {

                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Group Description is empty")).build();
            }
            if (groupService.getName() == null
                    || groupService.getName().isEmpty()) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Group Name is empty")).build();
            }
            Groups groups = payphoneGroupDAO.createGroups(groupService);
            if (groups.getId() > 0) {
//                HDBResource.put(groupService, "groups", "create");
                return Response.status(Response.Status.CREATED)
                        .entity(groups).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override

    public final Response createZone(final String umUserHash,
            final String umSessionID, final String umDomain,
            final Zones zoneService,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (zoneService.getDescription() == null
                    || zoneService.getDescription().isEmpty()) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(409,
                                "Zone Description is empty")).build();
            }
            if (zoneService.getName() == null
                    || zoneService.getName().isEmpty()) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Zone Name is empty")).build();
            }
            Zones zones = payphoneGroupDAO.createZone(zoneService);
            if (zones.getId() > 0) {
//                HDBResource.put(zoneService, "zones", "create");
                return Response.status(Response.Status.CREATED)
                        .entity(zones).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {
            if (e.getMessage().substring(129, 142).equals("already exist")) {
                return Response.status(409)
                        .entity(new ApiResponseMessage(409,
                                "Zone Already Exist")).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Internal Server Error")).build();
            }
        }
    }

    @Override
    public final Response editGroupById(final Long id,
            final String umUserHash, final String umSessionID,
            final String umDomain, final Groups group,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            int response = payphoneGroupDAO.updateGroupById(id, umUserHash,
                    umSessionID, umDomain, group);
            if (response == 1) {
                return Response.ok().entity(group).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "unexpected error")).build();
        }
    }

    @Override
    public final Response editZoneById(final Long id, final String umUserHash,
            final String umSessionID, final String umDomain, final Zones zone,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (zone.getDescription() == null
                    || zone.getDescription().isEmpty()) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Zone Description is empty")).build();
            }
            if (zone.getName().isEmpty()) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Zone Name is empty")).build();
            }
            int response = payphoneGroupDAO.updateZoneById(id, umUserHash,
                    umSessionID, umDomain, zone);
            if (response == 1) {
                return Response.ok().entity(zone).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "unexpected error")).build();
        }
    }

    @Override
    public final Response createTariffVersions(final String umUserHash,
            final String umSessionID, final String umDomain,
            final TariffVersions tariffVersionService,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (tariffVersionService.getActivationDate() == null) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Activation Date is empty")).build();
            }
            if (tariffVersionService.getDescription() == null
                    || tariffVersionService.getDescription().isEmpty()) {

                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Version Description is empty")).build();
            }
            TariffVersions tariffVersionServiceResponse
                    = payphones.createTariffVersions(tariffVersionService);
//            HDBResource.put(tariffVersionService, "tariff_versions", "create");
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
        return Response.ok().entity(new ApiResponseMessage(
                ApiResponseMessage.OK, "Tariff Version created!")).build();
    }

    @Override
    public final Response createModulation(final String umUserHash,
            final String umSessionID,
            final String umDomain,
            final Modulation modulation,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (modulation.getDays() == null) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Modulation days field is empty")).build();
            }
            if (modulation.getEndTime() == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Modulation end time  field is empty")).build();
            }
            if (modulation.getModulationTypeId() == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Modulation Type Id field is empty")).build();
            }
            if (modulation.getProfileId() == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                " Profile Id is empty")).build();
            }
            Modulation modulations = payphoneGroupDAO.
                    createModulation(modulation);

            if (modulations.getId() > 0) {
//                HDBResource.put(modulations, "modulations", "create");
                return Response.status(Response.Status.CREATED)
                        .entity(modulations).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response createSpecialDay(final String umUserHash,
            final String umSessionID,
            final String umDomain,
            final SpecialDay specialDayService,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (specialDayService.getDescription() == null
                    || specialDayService.getDescription().isEmpty()) {

                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Special Day Description is empty")).build();
            }
            if (specialDayService.getDay() == null) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Special Day day field is empty")).build();
            }
            if (specialDayService.getMonth() == null) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Special Day month field is empty")).build();
            }
            if (specialDayService.getYear() == null) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Special Day year field is empty")).build();
            }
            SpecialDay specialDay = payphoneGroupDAO.
                    createSpecialDay(specialDayService);
            if (specialDay.getId() > 0) {
//                HDBResource.put(specialDayService, "special_days", "create");
                return Response.status(Response.Status.CREATED)
                        .entity(specialDayService).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response deleteModulationById(final Long id,
            final String umUserHash, String umSessionID,
            final String umDomain,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (id == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Modulation Id can not be empty")).build();
            }
            //     Modulation modulations = payphoneGroupDAO.searchModulationById(null, null, null, id);
            int response = payphoneGroupDAO.deleteModulationById(id,
                    umUserHash, umSessionID, umDomain);
            if (response > 0) {

//                HDBResource.put(modulations, "modulations", "delete");
                return Response.ok().entity(new ApiResponseMessage(
                        ApiResponseMessage.OK, "Modulation Deleted !")).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response deleteSpecialDayById(final Long id,
            final String umUserHash,
            final String umSessionID,
            final String umDomain,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (id == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Special Day Id can not be empty")).build();
            }
            int response = payphoneGroupDAO.deleteSpecialDayById(id,
                    umUserHash, umSessionID, umDomain);
            if (response > 0) {
                //       SpecialDay specialDays = payphoneGroupDAO.
                //             searchSpecialDayById(null, null, null, id);
//                HDBResource.put(specialDays, "special_days", "delete");
                return Response.ok().entity(new ApiResponseMessage(
                        ApiResponseMessage.OK,
                        "Special day Deleted !")).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response editModulationById(final Long id,
            final String umUserHash, final String umSessionID,
            final String umDomain, final Modulation modulation,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (modulation.getDays() == null) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Modulation days is empty")).build();
            }

            if (modulation.getModulationTypeId() == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Modulation type id  is empty")).build();
            }

            if (modulation.getProfileId() == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Profile id  is empty")).build();
            }

            int response = payphoneGroupDAO.updateModulationById(id, umUserHash,
                    umSessionID, umDomain, modulation);
            if (response == 1) {
                return Response.ok().entity(modulation).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "unexpected error")).build();
        }
    }

    @Override
    public final Response editSpecialDayById(final Long id,
            final String umUserHash, final String umSessionID,
            final String umDomain, final SpecialDay specialDay,
            final SecurityContext securityContext) throws NotFoundException {
        try {

            if (specialDay.getDescription() == null
                    || specialDay.getDescription().isEmpty()) {

                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Special Day Description is empty")).build();
            }
            if (specialDay.getDay() == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Special Day day is empty")).build();
            }
            if (specialDay.getYear() == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Special Day year is empty")).build();
            }
            int response = payphoneGroupDAO.updateSpecialDayById(id, umUserHash,
                    umSessionID, umDomain, specialDay);
            if (response == 1) {
                return Response.ok().entity(specialDay).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "unexpected error")).build();
        }
    }

    @Override
    public final Response searchModulationById(final String umUserHash,
            final String umSessionID,
            final String umDomain, final Long id,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (id == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Modulation is empty")).build();
            }
            Modulation modulation = payphoneGroupDAO.searchModulationById(
                    umUserHash,
                    umSessionID, umDomain, id);
            if (modulation.getId() > 0) {
                return Response.ok().entity(modulation).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponseMessage(
                                ApiResponseMessage.INFO, "NOT FOUND")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(
                            ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response searchSpecialDayById(final String umUserHash,
            final String umSessionID, final String umDomain,
            final Long id,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (id == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Special Day Description is empty")).build();
            }
            SpecialDay specialDay = payphoneGroupDAO.
                    searchSpecialDayById(umUserHash,
                            umSessionID, umDomain, id);
            if (specialDay.getId() > 0) {
                return Response.ok().entity(specialDay).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponseMessage(
                                ApiResponseMessage.INFO, "NOT FOUND")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(
                            ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response deleteTariffById(final Long id,
            final String umUserHash,
            final String umSessionID,
            final String umDomain,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (id == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Id can not be empty")).build();
            }

            int response = payphoneGroupDAO.deleteTariffById(id,
                    umUserHash, umSessionID, umDomain);
            if (response > 0) {

                return Response.ok().entity(new ApiResponseMessage(
                        ApiResponseMessage.OK,
                        "Tariff Deleted !")).build();
            } else {
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response editTariffById(final Long id,
            final String umUserHash,
            final String umSessionID,
            final String umDomain,
            final Tariff tariff,
            final SecurityContext securityContext) throws NotFoundException {
        try {

            if (tariff.getInitialCost() == 0.0) {

                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Cost is empty")).build();
            }
            if (tariff.getGroupId() == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Group Id  is empty")).build();
            }

            if (tariff.getInitialDuration() == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Initialization  is empty")).build();
            }

            if (tariff.getModulationTypeId() == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Modulation Type is empty")).build();
            }
            int response = payphoneGroupDAO.updateTariffById(id, umUserHash,
                    umSessionID, umDomain, tariff);
            if (response == 1) {
                return Response.ok().entity(tariff).build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "unexpected error")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "unexpected error")).build();
        }
    }

    @Override
    public final Response searchTariffById(final String umUserHash,
            final String umSessionID,
            final String umDomain,
            final Long id, final SecurityContext securityContext)
            throws NotFoundException {
        try {
            if (id == 0) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Id field is empty ")).build();
            }
            Tariff tariff = payphoneGroupDAO.
                    searchTariffById(umUserHash,
                            umSessionID, umDomain, id);
            if (tariff.getId() > 0) {
                return Response.ok().entity(tariff).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponseMessage(
                                ApiResponseMessage.INFO, "NOT FOUND")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(
                            ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response searchGroups(final String umUserHash,
            final String umSessionID,
            final String umDomain, final Long offset,
            final Long limit, final String name,
            final SecurityContext securityContext)
            throws NotFoundException {

        try {
            JSONObject o = payphoneGroupDAO
                    .searchGroups(umUserHash, umSessionID, umDomain,
                            offset, limit, name);
            return Response.ok().entity(o).build();
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response searchZones(final String umUserHash,
            final String umSessionID,
            final String umDomain, final Long offset, final Long limit,
            final Long groupId, final String name,
            final SecurityContext securityContext) throws NotFoundException {

        try {
            JSONObject o = payphoneGroupDAO
                    .searchZones(umUserHash, umSessionID, umDomain,
                            offset, limit, name);
            return Response.ok().entity(o).build();
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }

    }

    @Override
    public final Response searchPrefixes(final String umUserHash,
            final String umSessionID,
            final String umDomain, final Long offset, final Long limit,
            final String name,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            JSONObject o = payphoneGroupDAO
                    .searchPrefix(umUserHash, umSessionID, umDomain,
                            offset, limit, name);
            return Response.ok().entity(o).build();
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response searchTariffVersions(final String umUserHash,
            final String umSessionID,
            final String umDomain, final Long offset, final Long limit,
            final Long tariffVersionId,
            Long customerId, String name,
            SecurityContext securityContext) throws NotFoundException {
        try {
            JSONObject o = payphoneGroupDAO
                    .searchTariffVersions(umUserHash, umSessionID, umDomain,
                            offset, limit, name);
            return Response.ok().entity(o).build();
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }

    }

    /**
     *
     * @param umUserHash umUserHash
     * @param umSessionID umSessionID
     * @param umDomain umDomain
     * @param offset offset
     * @param limit limit
     * @param tariffVersionId tariffVersionId
     * @param customerId customerId
     * @param name name
     * @param securityContext securityContext
     * @return Response
     * @throws NotFoundException Exception
     */
    @Override
    public final Response searchTariffs(final String umUserHash,
            final String umSessionID,
            final String umDomain, final Long offset, final Long limit,
            final Long tariffVersionId,
            final Long customerId, final String name,
            final SecurityContext securityContext)
            throws NotFoundException {
        try {
            JSONObject o = payphoneGroupDAO
                    .searchTariffs(umUserHash, umSessionID, umDomain,
                            offset, limit, name);
            return Response.ok().entity(o).build();
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }

    }

    @Override
    public final Response searchModulations(final String umUserHash,
            final String umSessionID, final String umDomain,
            final Long offset, final Long limit,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            JSONObject o = payphoneGroupDAO
                    .searchModulations(umUserHash, umSessionID, umDomain,
                            offset, limit);
            return Response.ok().entity(o).build();
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response searchSpecialDays(final String umUserHash,
            final String umSessionID, final String umDomain,
            final Long offset, final Long limit,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            JSONObject o = payphoneGroupDAO
                    .searchSpecialDays(umUserHash, umSessionID, umDomain,
                            offset, limit);
            return Response.ok().entity(o).build();
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);

            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

    @Override
    public final Response setBalancePayphoneServiceById(final String access,
            final Long id, final String umUserHash, final String umSessionID,
            final String umDomain, final TopUpRequest topUpRequest,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (!topUpRequest.getAmount().toString().matches("^[0-9.]+$")) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Amount contains  special characters")
                        ).build();
            }
            if (topUpRequest.getAmount() == 0.0f) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Amount can not be set to zero balance")
                        ).build();
            }
            float amount = topUpRequest.getAmount();

            TopupRsp topupRsp = payphones.setBalancePayPhonebyId(access, id,
                    umUserHash, umSessionID, umDomain, amount);

            // Generate TDR here
//            HDBResource.put(topupRsp, "payphone_service_balances",
//                    "set_balance");
            return Response.ok().entity(topupRsp).build();
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName()).log(
                    Level.SEVERE, null, ex);

            return Response.status(Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "unexpected error")).build();
        }
    }

    @Override
    public final Response cloneTariffVersions(final String umUserHash,
            final String umSessionID,
            final String umDomain,
            final TariffVersions cloneTariffVersionService,
            final SecurityContext securityContext) throws NotFoundException {
        try {
            if (cloneTariffVersionService.getDescription() == null
                    || cloneTariffVersionService.getDescription().isEmpty()) {

                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Version Description is empty")).build();
            }
            if (cloneTariffVersionService.getId() == 0L) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                                "Tariff Id is empty")).build();
            }
            TariffVersions cloneTariffVersionServiceResponse
                    = payphoneGroupDAO.cloneTariffVersion(
                            cloneTariffVersionService);
            if (cloneTariffVersionServiceResponse.getId() > 0) {

            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
        return Response.ok().entity(new ApiResponseMessage(
                ApiResponseMessage.OK, "Clone Tariff Version created!")).build();

    }

    @Override
    public Response searchTariffVersionsById(String umUserHash,
            String umSessionID, String umDomain, Long id,
            SecurityContext securityContext) throws NotFoundException {
        try {
            TariffVersions tariffVersions = payphoneGroupDAO.searchTariffVersionsById(umUserHash,
                    umSessionID, umDomain, id);
            if (tariffVersions.getId() > 0) {
                return Response.ok().entity(tariffVersions).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ApiResponseMessage(
                                ApiResponseMessage.INFO, "NOT FOUND")).build();
            }
        } catch (Exception ex) {
            Logger.getLogger(OcsApiServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(
                            ApiResponseMessage.ERROR,
                            "Internal Server Error")).build();
        }
    }

//    @Override
//    public final Response disablePayphoneServiceById(final Long id, 
//            final String umUserHash,
//            final String umSessionID, final String umDomain,
//           final SecurityContext securityContext) throws NotFoundException {
//        
//         if (id == 0) {
//                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                        .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
//                                " Payphone ID can not be empty")).build();
//            }
//        int response = payphones.disablePayphoneServiceById(id, umUserHash, 
//                umSessionID, umDomain);
//        if (response == 1) {
//            return Response.ok().entity(
//                    new ApiResponseMessage(ApiResponseMessage.OK,
//                            "Payphone disabled")).build();
//        } else {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
//                            "unexpected error")).build();
//        }
//    }
    @Override
    public Response disablePayphoneServiceById(final Long id,
            final String umUserHash,
            final String umSessionID, final String umDomain,
            final com.emerge.ocs.rest.model.Status payphoneStatus,
            final SecurityContext securityContext) throws NotFoundException {

        if (id == 0) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            " Payphone ID can not be empty")).build();
        }
        if (payphoneStatus.getStatus().toString().isEmpty()) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            " Payphone Satatus can not be empty")).build();
        }
        int response = payphones.disablePayphoneServiceById(id, umUserHash,
                umSessionID, umDomain, payphoneStatus);
        if (response == 1) {
            return Response.ok().entity(
                    new ApiResponseMessage(ApiResponseMessage.OK,
                            "Payphone Service updated to " + payphoneStatus.
                            getStatus())).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(new ApiResponseMessage(ApiResponseMessage.ERROR,
                            "unexpected error")).build();
        }
    }
}
