package com.emerge.ocs.rest.api;


import com.emerge.ocs.rest.factories.OcsApiServiceFactory;
import com.emerge.ocs.rest.model.AuthenticationReq;
import com.emerge.ocs.rest.model.EndServiceReq;
import com.emerge.ocs.rest.model.EndServiceResponse;
import com.emerge.ocs.rest.model.EndSessionRsp;
import com.emerge.ocs.rest.model.KeepAliveRsp;
import com.emerge.ocs.rest.model.LogReq;
import com.emerge.ocs.rest.model.Payphone;
import com.emerge.ocs.rest.model.PayphoneAuthenticationData;
import com.emerge.ocs.rest.model.ServiceParams;
import com.emerge.ocs.rest.model.StartServiceRequest;
import com.emerge.ocs.rest.model.StartServiceResponse;
import com.emerge.ocs.rest.service.OcsApiService;
import io.swagger.annotations.ApiParam;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/v1/call-control")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the ocs API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-13T16:14:55.325Z")
public class OcsApi  {
   private final OcsApiService delegate = OcsApiServiceFactory.getOcsApi();

    @DELETE
    @Path("/payphones/session/{session_id}/service/{service_id}")
       @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Ends the service within the specified Session", response = EndServiceResponse.class, tags={ "Call control", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "service ended", response = EndServiceResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = EndServiceResponse.class) })
    public Response endService(@ApiParam(value = "Payphone information" ,required=true) EndServiceReq notifyServiceInformation
,@ApiParam(value = "ID of session to resume on the OCS.",required=true) @PathParam("session_id") int sessionId
,@ApiParam(value = "ID of the service",required=true) @PathParam("service_id") int serviceId
,@ApiParam(value = "accessToken, as returned by the OCS." ,required=true)@HeaderParam("accessToken") String accessToken
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.endService(notifyServiceInformation,sessionId,serviceId,accessToken,securityContext);
    }
    
    @DELETE
    @Path("/payphones/session/{sessionid}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @io.swagger.annotations.ApiOperation(value = "", notes = "Ends the specified session", response = EndSessionRsp.class, tags = {"Call control",})
    @io.swagger.annotations.ApiResponses(value = {
    @io.swagger.annotations.ApiResponse(code = 200, message = "Session ended on the OCS", response = EndSessionRsp.class),
    @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = EndSessionRsp.class)})
    public Response endsession(
            @ApiParam(value = "ID of session to end", required = true) @PathParam("sessionid") int sessionid, 
            @ApiParam(value = "accessToken, as returned by the OCS.", required = true) @HeaderParam("accessToken") String accessToken,
            @Context SecurityContext securityContext)
            throws NotFoundException {
        return delegate.endsession(sessionid, accessToken, securityContext);
    }

    @POST
    @Path("/event/keepalive")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Periodic keep alive. Periodicity is configured in StartSession message; may be reconfigured in the response", response = KeepAliveRsp.class, tags={ "Event", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Keep alive response", response = KeepAliveRsp.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = KeepAliveRsp.class) })
    public Response keepAlive(@ApiParam(value = "access_token, as returned by the OCS." ,required=true)@HeaderParam("access_token") String accessToken
,@ApiParam(value = "Keep alive information" ,required=true) AuthenticationReq keepAliveRequest
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.keepAlive(accessToken,keepAliveRequest,securityContext);
    }
    
    @POST
    @Path("/event/log")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Log call unrelated events", response = void.class, tags={ "Event", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Session ended on the OCS", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response logevent(@ApiParam(value = "AccessToken, as returned by the OCS." ,required=true)@HeaderParam("accessToken") String accessToken
,@ApiParam(value = "Event information" ,required=true) LogReq logReq
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.logevent(accessToken,logReq,securityContext);
    }
    
    @POST
    @Path("/payphones/session/{sessionid}/id/{userid}/password/{userpassword}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    
    @io.swagger.annotations.ApiOperation(value = "", notes = "Authenticate on Payphone in OCS", response = Payphone.class, tags = {"Payphone",})
        @io.swagger.annotations.ApiResponses(value = {
    @io.swagger.annotations.ApiResponse(code = 200, message = "Authentication accepted", response = Payphone.class),
    @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = Payphone.class)})
    public Response payphonelogin(
            @ApiParam(value = "ID of the session", required = true) @PathParam("sessionid") int sessionid,
            @ApiParam(value = "Payphone User ID", required = true) @PathParam("userid") String userid, 
            @ApiParam(value = "Payphone User Password", required = true) @PathParam("userpassword") String userpassword, 
            @Context SecurityContext securityContext) throws NotFoundException {
        return delegate.payphonelogin(sessionid, userid, userpassword, securityContext);
    }

    
    @POST
    @Path("/payphones/authenticate")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Authenticate on the OCS", response = PayphoneAuthenticationData.class, tags={ "Authentication", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Authentication accepted", response = PayphoneAuthenticationData.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = PayphoneAuthenticationData.class) })
    public Response login(@ApiParam(value = "Payphone information" ,required=true) AuthenticationReq payphoneInformation
,@ApiParam(value = "Access token, as provided by OCS" ,required=true)@HeaderParam("accessToken") String accessToken
,@Context SecurityContext securityContext, @Context HttpServletRequest requestContext)
    throws NotFoundException {
        return delegate.login(payphoneInformation,accessToken,securityContext, requestContext);
    }
    @DELETE
    @Path("/payphones/authenticate/{session_id}")
        @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "End authentication on the OCS", response = void.class, tags={ "Authentication", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Logout done", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response logout(@ApiParam(value = "Access token, as provided by OCS" ,required=true)@HeaderParam("accessToken") String accessToken
,@ApiParam(value = "ID of session to resume on the OCS.",required=true) @PathParam("session_id") int sessionId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.logout(accessToken,sessionId,securityContext);
    }
    @POST
    @Path("/payphones/session/{sessionid}/service/{serviceid}/log")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Log service related event", response = void.class, tags={ "Call control", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Start service notified", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response logserviceevent(@ApiParam(value = "ID of the session",required=true) @PathParam("sessionid") int sessionid
,@ApiParam(value = "ID of the service",required=true) @PathParam("serviceid") int serviceid
,@ApiParam(value = "accessToken, as returned by the OCS." ,required=true)@HeaderParam("accessToken") String accessToken
,@ApiParam(value = "Service information. Not necessary when resuming the current service" ) LogReq logReq
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.logServiceEvent(sessionid,serviceid,accessToken,logReq,securityContext);
    }
    @POST
    @Path("/payphones/session/{sessionid}/log")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Log session related event", response = void.class, tags={ "Call control", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Session resumed", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response logsessionevent(@ApiParam(value = "ID of the session",required=true) @PathParam("sessionid") int sessionid
,@ApiParam(value = "accessToken, as returned by the OCS." ,required=true)@HeaderParam("accessToken") String accessToken
,@ApiParam(value = "Error log information" ,required=true) LogReq logReq
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.logSessionEvent(sessionid,accessToken,logReq,securityContext);
    }
    
    @PUT
    @Path("/payphones/session/{session_id}/service/{service_id}")
     @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Notifies the OCS that the service has effectively started; Resumes the current service when connectivity is lost and recovered", response = void.class, tags={ "Call control", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Start service notified", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response notifyStartService(@ApiParam(value = "Payphone information" ,required=true) ServiceParams notifyServiceInformation
,@ApiParam(value = "ID of session to resume on the OCS.",required=true) @PathParam("session_id") int sessionId
,@ApiParam(value = "ID of the service",required=true) @PathParam("service_id") int serviceId
,@ApiParam(value = "access_token, as returned by the OCS." ,required=true)@HeaderParam("accessToken") String accessToken
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.notifyStartService(notifyServiceInformation,sessionId,serviceId,accessToken,securityContext);
    }  
    
    @PUT
    @Path("/payphones/session/{session_id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Resume session on the OCS. Used when the payphone looses and recovers connection.", response = void.class, tags={ "Call control", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Session resumed", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = void.class) })
    public Response resumeSession(@ApiParam(value = "ID of session to resume on the OCS.",required=true) @PathParam("session_id") int sessionId
,@ApiParam(value = "accessToken, as returned by the OCS." ,required=true)@HeaderParam("accessToken") String accessToken
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.resumeSession(sessionId,accessToken,securityContext);
    }
    
    
    
  @POST
    @Path("/payphones/session/{session_id}/service")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Request authorization to start a new service within the current Session", response = StartServiceResponse.class, tags={ "Call control", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "New service created", response = StartServiceResponse.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = StartServiceResponse.class) })
    public Response startService(@ApiParam(value = "ID of the session to create the service in",required=true) @PathParam("session_id") int sessionId
,@ApiParam(value = "accessToken, as returned by the OCS." ,required=true)@HeaderParam("accessToken") String accessToken
,@ApiParam(value = "Service information" ,required=true) StartServiceRequest startServiceRequest
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.startService(sessionId,accessToken,startServiceRequest,securityContext);
    }   
    
   @POST
    @Path("/payphones/session")
   @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "Authenticate on the OCS", response = PayphoneAuthenticationData.class, tags={ "Authentication", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Authentication accepted", response = PayphoneAuthenticationData.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = PayphoneAuthenticationData.class) })
    public Response startsession(@ApiParam(value = "Payphone information" ,required=true) AuthenticationReq payphoneInformation
,@ApiParam(value = "Access token, as provided by OCS" ,required=true)@HeaderParam("accessToken") String accessToken
,@Context SecurityContext securityContext, @Context HttpServletRequest requestContext)
    throws NotFoundException {
        return delegate.login(payphoneInformation,accessToken,securityContext, requestContext);
    }
    
}