package com.emerge.ocs.rest.api;

import com.emerge.ocs.rest.factories.OcsApiServiceFactory;
import com.emerge.ocs.rest.model.Groups;
import com.emerge.ocs.rest.model.Modulation;
import com.emerge.ocs.rest.model.OngoingServiceInformation;
import com.emerge.ocs.rest.model.PayphoneDevice;
import com.emerge.ocs.rest.model.PayphoneService;
import com.emerge.ocs.rest.model.Prefix;
import com.emerge.ocs.rest.model.SpecialDay;
import com.emerge.ocs.rest.model.Status;
import com.emerge.ocs.rest.model.TopUpRequest;
import com.emerge.ocs.rest.model.TopupRsp;
import com.emerge.ocs.rest.service.OcsApiService;
import com.emerge.ocs.rest.model.Tariff;
import com.emerge.ocs.rest.model.TariffVersions;
import com.emerge.ocs.rest.model.Zones;

import io.swagger.annotations.ApiParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("v1/provision/")
@Consumes({"application/json"})
@Produces({"application/json"})
@io.swagger.annotations.Api(description = "the ocs API")
@javax.annotation.Generated(value
        = "class io.swagger.codegen.languages.JavaJerseyServerCodegen",
        date = "2016-10-21T16:15:52.666Z")
public class OcsApi {

    private final OcsApiService delegate = OcsApiServiceFactory.getOcsApi();

    @POST
    @Path("/payphone-services")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Creates a new Payphone Service in the OCS.",
            response = PayphoneService.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 201,
                message = "payphone created", response = PayphoneService.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error",
                response = PayphoneService.class)})
    public Response createPayphoneService(@ApiParam(
            value = "Userhash, as returned by the User Management system",
            required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user on the User Management system",
                    required = true) @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Payphone to create.",
                    required = true) PayphoneService payphoneService,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createPayphoneService(umUserHash,
                umSessionID, umDomain, payphoneService, securityContext);
    }

    @DELETE
    @Path("/payphone-services/{access}/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Deletes a payphone service based on payphone_id",
            response = void.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204,
                message = "payphone deleted", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = void.class)})
    public Response deletePayphoneServiceById(
            @ApiParam(value = "Qualifies the ID, specifying how it should be "
                    + "interpreted by the server.", required = true,
                    allowableValues = "msisdn, imsi, iccid, username")
            @PathParam("access") String access, @ApiParam(
                    value = "ID of payphone service to delete", required = true)
            @PathParam("id") Long id,
            @ApiParam(value = "Userhash,"
                    + " as returned by the User Management system.",
                    required = true)
            @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user.", required = true)
            @HeaderParam("umDomain") String umDomain,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deletePayphoneServiceById(access, id, umUserHash,
                umSessionID, umDomain, securityContext);
    }

    @PUT
    @Path("/payphone-services/{access}/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Edits payphone service information",
            response = PayphoneService.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204,
                message = "payphone update", response = PayphoneService.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = PayphoneService.class)})
    public Response editPayphoneServiceById(@ApiParam(
            value = "Qualifies the ID, specifying how it should be interpreted "
            + "by the server.", required = true,
            allowableValues = "msisdn, imei, imsi, iccid, serial_no,"
            + " mac, username") @PathParam("access") String access, @ApiParam(value = "ID of payphone service to edit",
            required = true) @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the User"
                    + " Management system.", required = true)
            @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user.", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Payphone information to edit",
                    required = true) PayphoneService payphone,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.editPayphoneServiceById(access, id,
                umUserHash, umSessionID, umDomain, payphone, securityContext);
    }

    @GET
    @Path("/payphone-devices/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Returns a Payphone Device",
            response = PayphoneDevice.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Payphones device", response = PayphoneDevice.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = PayphoneDevice.class)})
    public Response getPayphoneDeviceById(@ApiParam(
            value = "Userhash, as returned by the User Management system",
            required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Payphone Device ID", required = true)
            @PathParam("id") Long id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.getPayphoneDeviceById(umUserHash, umSessionID,
                umDomain, id, securityContext);
    }

    @GET
    @Path("/payphone-devices")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Returns a list of Payphone Devicess that match the search "
            + "criteria. If multiple criteria are specified, the result "
            + "will be a list of all payphones that match all the "
            + "criteria (logical AND)", response = PayphoneDevice.class,
            responseContainer = "List", tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Array of payphones that match the search criteria",
                response = PayphoneDevice.class, responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error",
                response = PayphoneDevice.class, responseContainer = "List")})
    public Response search(@ApiParam(value = "Userhash, as returned by the "
            + "User Management system", required = true)
            @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user",
                    required = true) @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Page offset",
                    defaultValue = "0") @DefaultValue("0")
            @QueryParam("offset") Long offset,
            @ApiParam(value = "Page limit", defaultValue = "20")
            @DefaultValue("20") @QueryParam("limit") Long limit,
            @ApiParam(value = "PayphoneService ID", defaultValue = "0")
            @DefaultValue("0") @QueryParam("payphone_service_id") Long payphoneServiceId,
            @ApiParam(value = "Customer ID", defaultValue = "0")
            @DefaultValue("0") @QueryParam("customer_id") Long customerId,
            @ApiParam(value = "Username") @QueryParam("username") String username,
            @ApiParam(value = "Equipment imei")
            @QueryParam("imei") String imei,
            @ApiParam(value = "SIM Card MSISDN")
            @QueryParam("msisdn") String msisdn,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.search(umUserHash, umSessionID, umDomain, offset, limit,
                payphoneServiceId, customerId, username, imei, msisdn,
                securityContext);
    }

    @GET
    @Path("/payphone-services/ongoing-services")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Returns a list of ongoing service records that match the "
            + "search criteria. If multiple criteria are specified, "
            + "the result will be a list of all calls that match all "
            + "the criteria (logical AND)",
            response = OngoingServiceInformation.class,
            responseContainer = "List", tags = {"Reporting",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Array of calls that match the search criteria",
                response = OngoingServiceInformation.class,
                responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error",
                response = OngoingServiceInformation.class,
                responseContainer = "List")})
    public Response searchCalls(@ApiParam(
            value = "Userhash, as returned by the User Management system.",
            required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user.",
                    required = true) @HeaderParam("umDomain") String umDomain, @ApiParam(value = "Page offset",
                    defaultValue = "0") @DefaultValue("0")
            @QueryParam("offset") Long offset, @ApiParam(
                    value = "Page limit", defaultValue = "20")
            @DefaultValue("20") @QueryParam("limit") Long limit,
            @ApiParam(value = "Payphone Service ID",
                    defaultValue = "0") @DefaultValue("0")
            @QueryParam("payphone_service_id") Long payphoneServiceId,
            @ApiParam(value = "Customer ID", defaultValue = "0")
            @DefaultValue("0") @QueryParam("customer_id") Long customerId,
            @ApiParam(value = "Username") @QueryParam("username") String username, @ApiParam(value = "Equipment imei")
            @QueryParam("imei") String imei,
            @ApiParam(value = "Origin MSISDN")
            @QueryParam("destination_msisdn") String destinationMsisdn,
            @ApiParam(value = "Origin MSISDN")
            @QueryParam("origin_msisdn") String originMsisdn,
            @ApiParam(value = "SIM Card ICCID")
            @QueryParam("iccid") String iccid,
            @ApiParam(value = "List calls that last more that"
                    + " <minDuration> seconds")
            @QueryParam("minDuration") Long minDuration,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchCalls(umUserHash, umSessionID,
                umDomain, offset, limit, payphoneServiceId,
                customerId, username, imei, destinationMsisdn, originMsisdn,
                iccid, minDuration, securityContext);
    }

    @GET
    @Path("/payphone-services")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Returns a list of Payphone Services that match the "
            + "search criteria. If multiple criteria are specified, the result will be a list of all payphones that match all the criteria (logical AND)", response = PayphoneService.class, responseContainer = "List", tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of payphones that match the search criteria", response = PayphoneService.class, responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 500, message = "Unexpected error", response = PayphoneService.class, responseContainer = "List")})
    public Response searchPayphoneService(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("umUserHash") String umUserHash, @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user", required = true) @HeaderParam("umDomain") String umDomain, @ApiParam(value = "Page offset", defaultValue = "0") @DefaultValue("0") @QueryParam("offset") Long offset, @ApiParam(value = "Page limit", defaultValue = "20") @DefaultValue("20") @QueryParam("limit") Long limit, @ApiParam(value = "Payphone ID", defaultValue = "0") @DefaultValue("0") @QueryParam("payphone_id") Long payphoneId, @ApiParam(value = "Customer ID", defaultValue = "0") @DefaultValue("0") @QueryParam("customer_id") Long customerId, @ApiParam(value = "Username") @QueryParam("username") String username, @ApiParam(value = "Equipment Serial Number") @QueryParam("serial_no") String serialNo, @ApiParam(value = "Equipment MAC Address") @QueryParam("mac") String mac, @ApiParam(value = "Equipment imei") @QueryParam("imei") String imei, @ApiParam(value = "SIM Card MSISDN") @QueryParam("msisdn") String msisdn, @ApiParam(value = "SIM Card ICCID") @QueryParam("iccid") String iccid, @ApiParam(value = "SIM Card IMSI") @QueryParam("imsi") String imsi ,@ApiParam(value = "Payphone status", allowableValues = "Active, Disabled, Deleted") @QueryParam("status") String status, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchPayphoneService(umUserHash, umSessionID, umDomain,
                offset, limit, payphoneId, customerId, username,
                serialNo, mac, imei, msisdn, iccid,imsi, status, securityContext);
    }

    @GET
    @Path("/payphone-services/{access}/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a Payphone"
            + " service based on ID", response = PayphoneService.class,
            tags = {})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "payphone information",
                response = PayphoneService.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = PayphoneService.class)})
    public Response searchPayphoneServiceById(@ApiParam(
            value = "Userhash, as returned by the User Management system.",
            required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user.",
                    required = true) @HeaderParam("umDomain") String umDomain,
            @ApiParam(
                    value = "Qualifies the ID, specifying how it"
                    + " should be interpreted by the "
                    + "server.",
                    required = true,
                    allowableValues = "msisdn, imsi, iccid, username")
            @PathParam("access") String access,
            @ApiParam(value = "Value of payphone service field to fetch",
                    required = true) @PathParam("id") Long id,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchPayphoneServiceById(umUserHash,
                umSessionID, umDomain, access, id, securityContext);
    }

    @PUT
    @Path("/payphone-services/{access}/{id}/topup")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Edits payphone information",
            response = TopupRsp.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Amount credited", response = TopupRsp.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = TopupRsp.class)})
    public Response topupPayphoneServiceById(
            @ApiParam(value = "Qualifies the ID, specifying how it should be "
                    + "interpreted by the server.", required = true,
                    allowableValues = "msisdn, imsi, iccid, username")
            @PathParam("access") String access, @ApiParam(value = "ID of "
                    + "payphone to fetch", required = true) @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the "
                    + "User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the"
                    + " user.", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "", required = true) TopUpRequest topUpRequest,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.topupPayphoneServiceById(access, id, umUserHash,
                umSessionID, umDomain, topUpRequest, securityContext);
    }

    @POST
    @Path("tariffs")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Creates a new"
            + " Tariff Service in the OCS.",
            response = Tariff.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "tariff created", response = Tariff.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = Tariff.class)})
    public Response createTariff(@ApiParam(
            value = "Userhash, as returned by the User Management system",
            required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") 
                    String umSessionID, @ApiParam(value = "Domain of the user on"
                            + " the User Management system", required = true)
                    @HeaderParam("umDomain") String umDomain, 
                    @ApiParam(value = "Tariff to create.", required = true)
                            Tariff tariffService, @Context SecurityContext securityContext)
            throws NotFoundException {

        return delegate.createTariff(umUserHash, umSessionID, umDomain, tariffService, securityContext);
    }

    @POST
    @Path("prefixes")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Creates a new Prefix in the OCS.", response = Prefix.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "prefix created", response = Prefix.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = Prefix.class)})
    public Response createPrefix(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("umUserHash") String umUserHash, @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user on the User Management system", required = true) @HeaderParam("umDomain") String umDomain, @ApiParam(value = "Prefix to create.", required = true) Prefix prefixService, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createPrefix(umUserHash, umSessionID, umDomain, prefixService, securityContext);
    }

    @GET
    @Path("zones/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a Zone based on ID", response = Zones.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "zone information", response = Zones.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = Zones.class)})
    public Response searchZoneById(@ApiParam(value = "Userhash, as returned by the User Management system.", required = true) @HeaderParam("umUserHash") String umUserHash, @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user.", required = true) @HeaderParam("umDomain") String umDomain, @ApiParam(value = "Value of zone field to fetch", required = true) @PathParam("id") Long id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchZoneById(umUserHash, umSessionID, umDomain, id, securityContext);
    }

    @PUT
    @Path("zones/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Edits Zone Information", response = void.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "zone update", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response editZoneById(@ApiParam(value = "ID of Prefix service to edit", required = true) @PathParam("id") Long id, @ApiParam(value = "Userhash, as returned by the User Management system.", required = true) @HeaderParam("umUserHash") String umUserHash, @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user.", required = true) @HeaderParam("umDomain") String umDomain, @ApiParam(value = "Zone information to edit", required = true) Zones zone, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.editZoneById(id, umUserHash, umSessionID, umDomain, zone, securityContext);
    }

    @PUT
    @Path("prefixes/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Edits Prefix Information", response = void.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "prefix update",
                response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = void.class)})
    public Response editPrefixById(@ApiParam(value = "ID of Prefix service to edit",
            required = true) @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user.", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Tax information to edit", required = true) Prefix payphone, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.editPrefixById(id, umUserHash, umSessionID, umDomain,
                payphone, securityContext);
    }

    @GET
    @Path("prefixes/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Returns a Prefix based on ID", response = Prefix.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "prefix information", response = Prefix.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = Prefix.class)})
    public Response searchPrefixById(@ApiParam(
            value = "Userhash, as returned by the User Management system.",
            required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user.",
                    required = true) @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Value of prefix field to fetch",
                    required = true) @PathParam("id") Long id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchPrefixById(umUserHash, umSessionID, umDomain, id,
                securityContext);
    }

    @PUT
    @Path("groups/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Edits Zone Information",
            response = void.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "group update",
                response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = void.class)})
    public Response editGroupById(@ApiParam(value = "ID of Group service to edit",
            required = true) @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user.", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Group information to edit", required = true) Groups group, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.editGroupById(id, umUserHash, umSessionID, umDomain, group, securityContext);
    }

    @DELETE
    @Path("zones/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Deletes a Zone based on zone id", response = void.class,
            tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "zone deleted", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = void.class)})
    public Response deleteZoneById(
            @ApiParam(value = "ID of zone to delete", required = true)
            @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user.",
                    required = true) @HeaderParam("umDomain") String umDomain, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteZoneById(id, umUserHash, umSessionID, umDomain, securityContext);
    }

    @DELETE
    @Path("prefixes/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Deletes a Prefix based on prefix id",
            response = void.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204,
                message = "prefix deleted", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = void.class)})
    public Response deletePrefixById(@ApiParam(value = "ID of payphone service "
            + "to delete", required = true) @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash, @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user.", required = true)
            @HeaderParam("umDomain") String umDomain,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deletePrefixById(id, umUserHash, umSessionID, umDomain, securityContext);
    }

    @DELETE
    @Path("groups/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Deletes a Zone based on zone id", response = void.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "group deleted", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class)})
    public Response deleteGroupById(@ApiParam(value = "ID of group to delete",
            required = true) @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user.", required = true)
            @HeaderParam("umDomain") String umDomain,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteGroupById(id, umUserHash, umSessionID, umDomain,
                securityContext);
    }

    @GET
    @Path("groups/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Returns a Group based on ID", response = Groups.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "group information", response = Groups.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = Groups.class)})
    public Response searchGroupById(
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user.", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Value of group field to fetch", required = true)
            @PathParam("id") Long id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchGroupById(umUserHash, umSessionID, umDomain, id,
                securityContext);
    }

    @POST
    @Path("zones")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Creates a new zone in the OCS.", response = Zones.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "zone created", response = Zones.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = Zones.class)})
    public Response createZone(@ApiParam(
            value = "Userhash, as returned by the User Management system",
            required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user on the User Management system", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Zone to create.", required = true) Zones zoneService, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createZone(umUserHash, umSessionID, umDomain, zoneService, securityContext);
    }

    @POST
    @Path("groups")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Creates a new group in the OCS.", response = Groups.class,
            tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "group created", response = Groups.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = Groups.class)})
    public Response createGroup(@ApiParam(
            value = "Userhash, as returned by the User Management system",
            required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user on "
                    + "the User Management system", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Group to create.", required = true) Groups groupService, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createGroup(umUserHash, umSessionID, umDomain,
                groupService, securityContext);
    }

    @POST
    @Path("tariff-versions")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Creates a new tariff version in the OCS.", response = TariffVersions.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Tariff version  created", response = TariffVersions.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = TariffVersions.class)})
    public Response createTariffVersions(@ApiParam(value = "Userhash, as returned by the User Management system", required = true) @HeaderParam("umUserHash") String umUserHash, @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user on the User Management system", required = true) @HeaderParam("umDomain") String umDomain, @ApiParam(value = "Tariff Version to create.", required = true) TariffVersions tariffVersionService, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createTariffVersions(umUserHash, umSessionID,
                umDomain, tariffVersionService, securityContext);
    }

    // new fields added 
    @POST
    @Path("special-days")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Creates a new "
            + "special day in the OCS.", response = SpecialDay.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 201, message = "Special Day"
                + " created", response = SpecialDay.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = SpecialDay.class)})
    public Response createSpecialDay(@ApiParam(value = "Userhash, as returned "
            + "by the User Management system", required = true) @HeaderParam("umUserHash") String umUserHash, @ApiParam(value = "SessionID on the User Management system",
            required = true) @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user on the User Management system",
                    required = true) @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Special Day to create.", required = true) SpecialDay specialDayService, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createSpecialDay(umUserHash, umSessionID, umDomain,
                specialDayService, securityContext);
    }

    @DELETE
    @Path("modulations/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Deletes a Modulation based on  id",
            response = void.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204,
                message = "Modulation deleted", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = void.class)})
    public Response deleteModulationById(@ApiParam(value = "ID of Modulation  to delete",
            required = true) @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user.", required = true) @HeaderParam("umDomain") String umDomain, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteModulationById(id, umUserHash, umSessionID, umDomain, securityContext);
    }

    @DELETE
    @Path("special-days/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Deletes a "
            + "Special Day based on  id", response = void.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "special day deleted",
                response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = void.class)})
    public Response deleteSpecialDayById(@ApiParam(value = "ID of Special Day  "
            + "to delete", required = true) @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user.", required = true)
            @HeaderParam("umDomain") String umDomain,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteSpecialDayById(id, umUserHash, umSessionID,
                umDomain, securityContext);
    }

    @PUT
    @Path("modulations/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Edits Modulation Information",
            response = void.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "modulation update",
                response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = void.class)})
    public Response editModulationById(@ApiParam(value = "ID of Modulation service to edit",
            required = true) @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user.", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Modulation Information to edit", required = true) Modulation specialDay, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.editModulationById(id, umUserHash, umSessionID,
                umDomain, specialDay, securityContext);
    }

    @PUT
    @Path("special-days/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Edits Special Day Information",
            response = void.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204, message = "special day update",
                response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = void.class)})
    public Response editSpecialDayById(@ApiParam(value = "ID of Special Day service to edit",
            required = true) @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user.", required = true) @HeaderParam("umDomain") String umDomain, @ApiParam(value = "Special Day Information to edit", required = true) SpecialDay specialDay, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.editSpecialDayById(id, umUserHash, umSessionID, umDomain, specialDay, securityContext);
    }

    @GET
    @Path("modulations/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a "
            + "Modulation based on ID", response = Modulation.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Modulation information", response = Modulation.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = Modulation.class)})
    public Response searchModulationById(@ApiParam(value = "Userhash, as returned by the User Management system.", required = true) @HeaderParam("umUserHash") String umUserHash, @ApiParam(value = "SessionID on the User Management system", required = true) @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user.", required = true) @HeaderParam("umDomain") String umDomain, @ApiParam(value = "Value of Modulation field to fetch", required = true) @PathParam("id") Long id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchModulationById(umUserHash, umSessionID, umDomain, id, securityContext);
    }

    @GET
    @Path("special-days/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a Group based on ID",
            response = SpecialDay.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "special day information",
                response = SpecialDay.class),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = SpecialDay.class)})
    public Response searchSpecialDayById(
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID, @ApiParam(value = "Domain of the user.",
                    required = true) @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Value of special day field to fetch", required = true)
            @PathParam("id") Long id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchSpecialDayById(umUserHash, umSessionID, umDomain,
                id, securityContext);
    }

    @POST
    @Path("modulations")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Creates a new modulation in the OCS.",
            response = Modulation.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 201, message = "Modulation created", response = Modulation.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = Modulation.class)})
    public Response createModulation(
            @ApiParam(value = "Userhash, as returned by the User Management system",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user on the User Management system",
                    required = true) @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Modulation to create.", required = true) Modulation modulation,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.createModulation(umUserHash, umSessionID, umDomain, modulation, securityContext);
    }

    @PUT
    @Path("tariffs/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Edits Tariff Information", response = void.class,
            tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204,
                message = "Tariff update", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = void.class)})
    public Response editTariffById(@ApiParam(value = "ID of Tariff service to "
            + "edit", required = true) @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user.", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Tariff Information to edit", required = true) Tariff tariff, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.editTariffById(id, umUserHash, umSessionID, umDomain,
                tariff, securityContext);
    }

    @DELETE
    @Path("tariffs/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Deletes a Tariff based on  id",
            response = void.class, tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 204,
                message = "Tariff deleted", response = void.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = void.class)})
    public Response deleteTariffById(@ApiParam(value = "ID of Tariff  to delete",
            required = true) @PathParam("id") Long id,
            @ApiParam(value = "Userhash, as returned by the User Management system.",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user.", required = true)
            @HeaderParam("umDomain") String umDomain,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.deleteTariffById(id, umUserHash, umSessionID,
                umDomain, securityContext);
    }

    @GET
    @Path("tariffs/{id}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Returns a Tariff based on ID", response = Tariff.class, tags = {})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Tariff information", response = Tariff.class),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = Tariff.class)})
    public Response searchTariffById(@ApiParam(value = "Userhash, as returned "
            + "by the User Management system.", required = true)
            @HeaderParam("umUserHash") String umUserHash, @ApiParam(value = "SessionID"
                    + " on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID, @ApiParam(
                    value = "Domain of the user.", required = true)
            @HeaderParam("umDomain") String umDomain, @ApiParam(
                    value = "Value of Modulation field to fetch", required = true)
            @PathParam("id") Long id, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchTariffById(umUserHash, umSessionID, umDomain,
                id, securityContext);
    }

    @GET
    @Path("groups")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a list of"
            + " Groups that match the search criteria. If multiple criteria are"
            + " specified, the result will be a list of all groups that match "
            + "all the criteria (logical AND)", response = Groups.class,
            responseContainer = "List", tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of "
                + "groups that match the search criteria",
                response = Groups.class, responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = Groups.class,
                responseContainer = "List")})
    public Response searchGroups(@ApiParam(value = "Userhash, as returned"
            + " by the User Management system", required = true)
            @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user",
                    required = true) @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Page offset",
                    defaultValue = "0") @DefaultValue("0")
            @QueryParam("offset") Long offset,
            @ApiParam(value = "Page limit", defaultValue = "20")
            @DefaultValue("20") @QueryParam("limit") Long limit,
            @ApiParam(value = "Group Name") @QueryParam("name") String name,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchGroups(umUserHash, umSessionID, umDomain,
                offset, limit, name, securityContext);
    }

    @GET
    @Path("zones")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a list of Zones that match the search criteria. If multiple criteria are specified, the result will be a list of all tariff versions that match all the criteria (logical AND)", response = Zones.class, responseContainer = "List", tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of "
                + "Zones that match the search criteria",
                response = Zones.class, responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = Zones.class, responseContainer = "List")})
    public Response searchZones(@ApiParam(value = "Userhash, as returned by the User Management"
            + " system", required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Page offset", defaultValue = "0")
            @DefaultValue("0") @QueryParam("offset") Long offset,
            @ApiParam(value = "Page limit", defaultValue = "20")
            @DefaultValue("20") @QueryParam("limit") Long limit,
            @ApiParam(value = "Group ID", defaultValue = "0")
            @DefaultValue("0") @QueryParam("group_id") Long groupId,
            @ApiParam(value = "Zone name") @QueryParam("name") String name,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchZones(umUserHash, umSessionID, umDomain, offset,
                limit, groupId, name, securityContext);
    }

    @GET
    @Path("prefixes")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Returns a list of Prefix that match the search criteria. "
            + "If multiple criteria are specified, the result will be a "
            + "list of all Prefixes that match all the criteria (logical AND)",
            response = Prefix.class, responseContainer = "List", tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Array of prefixes that match the search criteria",
                response = Prefix.class, responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = Prefix.class, responseContainer = "List")})
    public Response searchPrefixes(@ApiParam(value = "Userhash, as returned by"
            + " the User Management system", required = true)
            @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user",
                    required = true) @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Page offset",
                    defaultValue = "0") @DefaultValue("0")
            @QueryParam("offset") Long offset,
            @ApiParam(value = "Page limit", defaultValue = "20")
            @DefaultValue("20") @QueryParam("limit") Long limit,
            @ApiParam(value = "Country") @QueryParam("country") String country, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchPrefixes(umUserHash, umSessionID, umDomain,
                offset, limit, country, securityContext);
    }

    @GET
    @Path("tariff-versions")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a list of "
            + "Tariff Versions that match the search criteria. "
            + "If multiple criteria are specified, the result will be a list "
            + "of all tariff versions that match all the criteria (logical AND)",
            response = TariffVersions.class, responseContainer = "List",
            tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of tariff "
                + "versions that match the search criteria",
                response = TariffVersions.class, responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = TariffVersions.class, responseContainer = "List")})
    public Response searchTariffVersions(
            @ApiParam(value = "Userhash, as returned by the User Management system",
                    required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user", required = true) @HeaderParam("umDomain") String umDomain, @ApiParam(value = "Page offset", defaultValue = "0")
            @DefaultValue("0") @QueryParam("offset") Long offset,
            @ApiParam(value = "Page limit", defaultValue = "20")
            @DefaultValue("20") @QueryParam("limit") Long limit,
            @ApiParam(value = "Tariff Version ID", defaultValue = "0")
            @DefaultValue("0") @QueryParam("tariff_version_id") Long tariffVersionId,
            @ApiParam(value = "Customer ID", defaultValue = "0")
            @DefaultValue("0") @QueryParam("customer_id") Long customerId,
            @ApiParam(value = "Username") @QueryParam("username") String username,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchTariffVersions(umUserHash, umSessionID, umDomain, offset,
                limit, tariffVersionId, customerId, username, securityContext);
    }

    @GET
    @Path("tariffs")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a list"
            + " of Tariff Versions that match the search criteria. "
            + "If multiple criteria are specified, the result will be a list of"
            + " all tariff versions that match all the criteria (logical AND)",
            response = TariffVersions.class, responseContainer = "List", tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array"
                + " of tariff versions that match the search criteria",
                response = TariffVersions.class, responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = TariffVersions.class,
                responseContainer = "List")})
    public Response searchTariffs(@ApiParam(
            value = "Userhash, as returned by the User Management system",
            required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system", required = true)
            @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Page offset", defaultValue = "0")
            @DefaultValue("0") @QueryParam("offset") Long offset,
            @ApiParam(value = "Page limit", defaultValue = "20")
            @DefaultValue("20") @QueryParam("limit") Long limit,
            @ApiParam(value = "Tariff Version ID", defaultValue = "0")
            @DefaultValue("0") @QueryParam("tariff_version_id") Long tariffVersionId,
            @ApiParam(value = "Customer ID",
                    defaultValue = "0") @DefaultValue("0")
            @QueryParam("customer_id") Long customerId,
            @ApiParam(value = "Username") @QueryParam("username") String username,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchTariffs(umUserHash, umSessionID, umDomain, offset,
                limit, tariffVersionId, customerId, username, securityContext);
    }

    @GET
    @Path("special-days")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a list of "
            + "Special Days that match the search criteria. If multiple criteria are specified, "
            + "the result will be a list of all tariff versions that match all the criteria (logical AND)",
            response = TariffVersions.class, responseContainer = "List", tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200, message = "Array of Special "
                + "Days that match the search criteria",
                response = SpecialDay.class, responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error",
                response = SpecialDay.class, responseContainer = "List")})
    public Response searchSpecialDays(@ApiParam(
            value = "Userhash, as returned by the User Management system",
            required = true) @HeaderParam("umUserHash") String umUserHash,
            @ApiParam(value = "SessionID on the User Management system",
                    required = true) @HeaderParam("umSessionID") String umSessionID,
            @ApiParam(value = "Domain of the user",
                    required = true) @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Page offset", defaultValue = "0")
            @DefaultValue("0") @QueryParam("offset") Long offset,
            @ApiParam(value = "Page limit", defaultValue = "20") @DefaultValue("20")
            @QueryParam("limit") Long limit, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchSpecialDays(umUserHash, umSessionID, umDomain,
                offset, limit, securityContext);
    }

    @GET
    @Path("modulations")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "",
            notes = "Returns a list of Modulations that match the search criteria. "
            + "If multiple criteria are specified, the result will be a"
            + " list of all modulations that "
            + "match all the criteria (logical AND)",
            response = Modulation.class, responseContainer = "List",
            tags = {"Provision",})
    @io.swagger.annotations.ApiResponses(value = {
        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Array of modulations that match the search criteria",
                response = Modulation.class, responseContainer = "List"),

        @io.swagger.annotations.ApiResponse(code = 200,
                message = "Unexpected error", response = Modulation.class,
                responseContainer = "List")})
    public Response searchModulations(@ApiParam(value = "Userhash, as returned "
            + "by the User Management system", required = true)
            @HeaderParam("umUserHash") String umUserHash, @ApiParam(
                    value = "SessionID on the User Management system",
                    required = true)
            @HeaderParam("umSessionID") String umSessionID, @ApiParam(
                    value = "Domain of the user", required = true)
            @HeaderParam("umDomain") String umDomain,
            @ApiParam(value = "Page offset", defaultValue = "0")
            @DefaultValue("0")
            @QueryParam("offset") Long offset,
            @ApiParam(value = "Page limit", defaultValue = "20")
            @DefaultValue("20")
            @QueryParam("limit") Long limit, @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.searchModulations(umUserHash, umSessionID,
                umDomain, offset, limit, securityContext);
    }
    
    
    @PUT
    @Path("payphone-services/{access}/{id}/set-balance")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Edits payphone information", response = TopupRsp.class, tags={ "Provision", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Set Balance Amount", response = TopupRsp.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = TopupRsp.class) })
    public Response setBalancePayphoneServiceById(@ApiParam(value = "Qualifies the ID, specifying how it should be interpreted by the server.",required=true, allowableValues="msisdn, imsi, iccid, username") @PathParam("access") String access
,@ApiParam(value = "ID of payphone to fetch",required=true) @PathParam("id") Long id
,@ApiParam(value = "Userhash, as returned by the User Management system." ,required=true)@HeaderParam("umUserHash") String umUserHash
,@ApiParam(value = "SessionID on the User Management system" ,required=true)@HeaderParam("umSessionID") String umSessionID
,@ApiParam(value = "Domain of the user." ,required=true)@HeaderParam("umDomain") String umDomain
,@ApiParam(value = "" ,required=true) TopUpRequest topUpRequest
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.setBalancePayphoneServiceById(access,id,umUserHash,umSessionID,umDomain,topUpRequest,securityContext);
    }
    
    
    
    @POST
    @Path("clone-tariff-versions")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Creates a new tariff version in the OCS.", response = TariffVersions.class, tags={ "Provision", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Tariff version  created", response = TariffVersions.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = TariffVersions.class) })
    public Response cloneTariffVersions(@ApiParam(value = "Userhash, as returned by the User Management system" ,required=true)@HeaderParam("umUserHash") String umUserHash
,@ApiParam(value = "SessionID on the User Management system" ,required=true)@HeaderParam("umSessionID") String umSessionID
,@ApiParam(value = "Domain of the user on the User Management system" ,required=true)@HeaderParam("umDomain") String umDomain
,@ApiParam(value = "Tariff Version to clone." ,required=true) TariffVersions cloneTariffVersionService
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.cloneTariffVersions(umUserHash,umSessionID,umDomain,cloneTariffVersionService,securityContext);
    }
    
    @GET
    @Path("tariff-versions/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Returns a Tariff Version based on ID", response = TariffVersions.class, tags={  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Tariff version information", response = TariffVersions.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = TariffVersions.class) })
    public Response searchTariffVersionsById(@ApiParam(value = "Userhash, as returned by the User Management system." ,required=true)@HeaderParam("umUserHash") String umUserHash
,@ApiParam(value = "SessionID on the User Management system" ,required=true)@HeaderParam("umSessionID") String umSessionID
,@ApiParam(value = "Domain of the user." ,required=true)@HeaderParam("umDomain") String umDomain
,@ApiParam(value = "Value of Tariff versions  field to fetch",required=true) @PathParam("id") Long id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.searchTariffVersionsById(umUserHash,umSessionID,umDomain,id,securityContext);
    }
    
    @PUT
    @Path("payphone-services/{id}/status")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Disable a payphone service based on payphone_id", response = void.class, tags={ "Provision", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "payphone disable", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = void.class) })
    public Response disablePayphoneServiceById(@ApiParam(value = "ID of payphone service to disable",required=true) @PathParam("id") Long id
,@ApiParam(value = "Userhash, as returned by the User Management system." ,required=true)@HeaderParam("umUserHash") String umUserHash
,@ApiParam(value = "SessionID on the User Management system" ,required=true)@HeaderParam("umSessionID") String umSessionID
,@ApiParam(value = "Domain of the user." ,required=true)@HeaderParam("umDomain") String umDomain
,@ApiParam(value = "" ,required=true) Status payphoneStatus
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.disablePayphoneServiceById(id,umUserHash,umSessionID,umDomain,payphoneStatus,securityContext);
    }

}
