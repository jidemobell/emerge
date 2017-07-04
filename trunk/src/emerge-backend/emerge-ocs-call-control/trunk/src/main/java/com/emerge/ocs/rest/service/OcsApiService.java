package com.emerge.ocs.rest.service;

import com.emerge.ocs.rest.api.NotFoundException;
import com.emerge.ocs.rest.model.AuthenticationReq;
import com.emerge.ocs.rest.model.EndServiceReq;
import com.emerge.ocs.rest.model.LogReq;
import com.emerge.ocs.rest.model.Payphone;
import com.emerge.ocs.rest.model.ServiceParams;
import com.emerge.ocs.rest.model.StartServiceRequest;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-13T16:14:55.325Z")
public abstract class OcsApiService {

    public abstract Response endService(EndServiceReq notifyServiceInformation,int sessionId,int serviceId,String accessToken,SecurityContext securityContext) throws NotFoundException;
    
    public abstract Response endsession(int sessionid, String accessToken, SecurityContext securityContext) throws NotFoundException;

    public abstract Response keepAlive(String accessToken, AuthenticationReq keepAliveReq, SecurityContext securityContext) throws NotFoundException;

    public abstract Response logevent(String accessToken, LogReq logReq, SecurityContext securityContext) throws NotFoundException;

    public abstract Response payphonelogin(int sessionid, String userid, String userpassword, SecurityContext securityContext) throws NotFoundException;

    public abstract Response login(AuthenticationReq payphoneInformation,String accessToken,SecurityContext securityContext, @Context HttpServletRequest requestContext) throws NotFoundException;


    public abstract Response logout(String accessToken, int sessionID, SecurityContext securityContext) throws NotFoundException;

    public abstract Response logServiceEvent(int sessionId,int serviceId,String accessToken,LogReq logRequest,SecurityContext securityContext) throws NotFoundException;

    public abstract Response logSessionEvent(int sessionid, String accessToken, LogReq logReq, SecurityContext securityContext) throws NotFoundException;

    public abstract Response notifyStartService(ServiceParams notifyServiceInformation,int sessionId,int serviceId,String accessToken,SecurityContext securityContext) throws NotFoundException;

    public abstract Response resumeSession(int sessionId,String accessToken,SecurityContext securityContext) throws NotFoundException;

    public abstract Response startService(int sessionId,String accessToken,StartServiceRequest startServiceRequest,SecurityContext securityContext) throws NotFoundException;

    public abstract Response startsession(Payphone startSessionReq, SecurityContext securityContext) throws NotFoundException;
}
