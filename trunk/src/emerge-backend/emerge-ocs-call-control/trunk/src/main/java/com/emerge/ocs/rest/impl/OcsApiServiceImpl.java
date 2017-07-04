package com.emerge.ocs.rest.impl;

import com.edeh.chigozie.elasticsearch.client.helper.ElasticSearchCRUD;
import com.edeh.chigozie.elasticsearch.client.helper.ElasticSearchClient;
import com.emerge.ocs.database.elastic.model.AuthenticationAttempts;
import com.emerge.ocs.database.elastic.model.OngoingServiceInformation;
import com.emerge.ocs.database.elastic.model.Session;
import com.emerge.ocs.database.elastic.model.SessionDocument;
import com.emerge.ocs.database.model.DatabaseDAO;

import com.emerge.ocs.rest.api.ApiResponseMessage;
import com.emerge.ocs.rest.api.NotFoundException;
import com.emerge.ocs.rest.model.AuthenticationReq;
import com.emerge.ocs.rest.model.ConfigData;
import com.emerge.ocs.rest.model.KeepAliveRsp;
import com.emerge.ocs.rest.model.LogReq;
import com.emerge.ocs.rest.model.Payphone;

import com.emerge.ocs.rest.model.PayphoneAuthenticationData;
import com.emerge.ocs.rest.model.PayphoneCredentials;
import com.emerge.ocs.rest.model.StartServiceRequest;
import com.emerge.ocs.rest.model.StartServiceResponse;
import com.emerge.ocs.rest.model.Tariff;
import com.emerge.ocs.database.elastic.model.Tariffs;
import com.emerge.ocs.rest.model.EndServiceReq;
import com.emerge.ocs.rest.model.EndServiceResponse;
import com.emerge.ocs.rest.model.ServiceParams;
import com.emerge.ocs.rest.service.OcsApiService;
import com.emerge.ocs.rest.util.JdbiHelper;
import com.emerge.ocs.rest.util.PrefixHelper;
import com.emerge.ocs.rest.util.Token;
import com.fasterxml.jackson.core.JsonProcessingException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import org.elasticsearch.client.RestClient;
import org.joda.time.DateTime;

@SuppressFBWarnings
@javax.annotation.Generated(value = "class io.swagger.codegen.languages."
    + "JavaJerseyServerCodegen", date = "2016-09-30T14:12:12.315Z")
public class OcsApiServiceImpl extends OcsApiService {

    @Override
    public Response endService(EndServiceReq notifyServiceInformation,
        int sessionId,int serviceId,String accessToken,
        SecurityContext securityContext) throws NotFoundException {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        if (!(validateService(sessionId,
            accessToken, serviceId))
            || notifyServiceInformation.getServiceStartTime() == null
            || notifyServiceInformation.getCallAnswerTime() == null
            || notifyServiceInformation.getServiceEndTime() == null
            || notifyServiceInformation.getServiceDuration() <= 0
            || notifyServiceInformation.getEndCause().length() <= 0) {
            return Response.status(400).entity(new ApiResponseMessage(400,
                "Invalide Access Token")).build();
        }
        double payphoneBalance = databaseDAO.getInitServiceBalance(serviceId);
        double actualCost = rebalanceCharges(notifyServiceInformation,
            serviceId);
        databaseDAO.updateCallService(serviceId, notifyServiceInformation
            .getCallAnswerTime(),
            notifyServiceInformation.getServiceStartTime(),
            notifyServiceInformation.getServiceDuration(),
            actualCost, payphoneBalance, notifyServiceInformation
                .getServiceEndTime(), notifyServiceInformation.getEndCause(),
            payphoneBalance - actualCost, notifyServiceInformation.getServiceDuration());
        //Log to histoty database 
        EndServiceResponse endServiceResponse = databaseDAO
            .getServiceResponse(serviceId);
        return Response.ok().entity(endServiceResponse).build();
    }

    @Override
    public Response endsession(int sessionid, String accessToken,
        SecurityContext securityContext) throws NotFoundException {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        if (!validateSession(sessionid, accessToken)) {
            return Response.status(400).entity(new ApiResponseMessage(400,
                "Invalide Session Or Access Token")).build();
        }
        int serviceDeleteResult = databaseDAO.deleteService(sessionid);
        int sessionDeleteResult = databaseDAO.deleteSession(sessionid);
        int authDeleteResult = databaseDAO.deleteAuthenticatonAttempt(
            sessionid);
        if (sessionDeleteResult > 0 || serviceDeleteResult > 0 
            || authDeleteResult > 0 ) {
            return Response.ok().entity(new ApiResponseMessage(200,
                "Session Ended!")).build();
        }
        
        return Response.ok().entity(new ApiResponseMessage(400, "error"))
            .build();
    }

    @Override
    public Response keepAlive(String accessToken,
      AuthenticationReq keepAliveReq, SecurityContext securityContext)
      throws NotFoundException {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        KeepAliveRsp keepAliveRsp = new KeepAliveRsp();
        int payphoneID = databaseDAO.getPayphoneID(keepAliveReq
            .getPayphone().getCredentials().getUsername(),
            keepAliveReq.getPayphone().getCredentials().getPassword());
        String isPayphoneValide = isVersionValid(keepAliveReq, payphoneID);
        switch (isPayphoneValide) {
        case OcsApiImpCons.ACTIVE:
            keepAliveRsp.setConfigData(databaseDAO.getConfig(payphoneID));
            keepAliveRsp.setStatusCode(200);
            keepAliveRsp.setMessage("Keep alive successful");
            //log location information to the history database
            break;
        case OcsApiImpCons.RECOMMENDED_UPDATE:
            keepAliveRsp.setConfigData(databaseDAO.getConfig(payphoneID));
            keepAliveRsp.setStatusCode(200);
            keepAliveRsp.setMessage(OcsApiImpCons.RECOMMENDED_UPDATE);
            //log location information to the history database
            break;
        default:
            keepAliveRsp.setConfigData(databaseDAO.getConfig(payphoneID));
            keepAliveRsp.setStatusCode(400);
            keepAliveRsp.setMessage(OcsApiImpCons.UNEXPECTED_ERROR);
            break;
        }

        return Response.status(keepAliveRsp.getStatusCode())
            .entity(keepAliveRsp).build();
    }

    @Override
    public Response logevent(String accessToken, LogReq logReq,
        SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        String validationMessage = "";
        try {
            validationMessage = Token.validateToken(accessToken);
        } catch (Exception e) {
            validationMessage = OcsApiImpCons.JWT_EXPIRED;
        }
        RestClient restClient = null;
        int responseCode = 400;
        Map logError = new HashMap<String, Object>();
        logError.put("logReq", logReq);
        logError.put("log_type", "Payphone device Error");
        if (validationMessage.equals(OcsApiImpCons.VALIDATED)
            || validationMessage.equals(OcsApiImpCons.JWT_EXPIRED)) {
            try {
                restClient
                    = ElasticSearchClient.getHTTPClient("192.168.41.150", 9200);
                if (!(ElasticSearchCRUD.createRecordWithObject(logError,
                    restClient, "ocs", "ongoing_session_detail_records")
                    == null)) {
                    responseCode = ElasticSearchCRUD.createRecordWithObject(
                        logError, restClient, "ocs",
                        "ongoing_session_detail_records").getStatusLine()
                        .getStatusCode();
                }
            } catch (UnknownHostException ex) {
            } catch (JsonProcessingException ex) {
            }
        }
        if (responseCode == 200 || responseCode == 201) {
            return Response.ok().entity(new ApiResponseMessage(200, "magic!"))
                .build();
        } else {
            return Response.status(400).entity(new ApiResponseMessage(200,
                "Error Reported!")).build();
        }
    }

    @Override
    public Response payphonelogin(int sessionid, String userid,
        final String userpassword, final SecurityContext securityContext)
        throws NotFoundException {

        return Response.status(400).entity(new ApiResponseMessage(400,
            "USER NOT AUTHENTICATED")).build();
    }

    @Override
    public Response login(AuthenticationReq payphoneInformation,
        final String accessToken, final SecurityContext securityContext,
        final @Context HttpServletRequest requestContext)
        throws NotFoundException {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        PayphoneAuthenticationData responseMessage
            = new PayphoneAuthenticationData();
        int payphoneID = databaseDAO.getPayphoneID(payphoneInformation
            .getPayphone().getCredentials().getUsername(),
            payphoneInformation.getPayphone().getCredentials().getPassword());
        if (!databaseDAO.isPayphonesExist(payphoneID)) {
            updatePayphone(payphoneInformation, payphoneID);
        } else if (!databaseDAO.isPayphonChanged(payphoneID,
            payphoneInformation.getPayphone().getEquipment().getIMEI1(),
            payphoneInformation.getPayphone().getEquipment().getSerialNr(),
            payphoneInformation.getPayphone().getEquipment().getMAC(),
            payphoneInformation.getPayphone().getEquipment().getIMEI2())) {
            //update payphone info
            databaseDAO.updatePayphoneDevice(payphoneID, payphoneInformation
                .getPayphone().getEquipment().getIMEI1(),
                payphoneInformation.getPayphone().getEquipment().getSerialNr(),
                payphoneInformation.getPayphone().getEquipment().getMAC(),
                payphoneInformation.getPayphone().getEquipment().getIMEI2());
        }
        String isPayphoneValide = isVersionValid(payphoneInformation,
            payphoneID);
        String validationMessage = "";
        try {
            validationMessage = Token.validateToken(accessToken);
        } catch (Exception e) {
            validationMessage = OcsApiImpCons.JWT_EXPIRED;
        }
        responseMessage = validationHandle(isPayphoneValide, validationMessage,
            responseMessage, payphoneInformation, requestContext);
        if (responseMessage.getCode().equals("200")) {
            return Response.ok().entity(responseMessage).build();
        } else {
            return Response.status(400).entity(responseMessage).build();
        }
    }

    @Override
    public Response logout(String accessToken, int sessionID,
        SecurityContext securityContext) throws NotFoundException {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        if (!validateSession(sessionID, accessToken)) {
            return Response.status(400).entity(new ApiResponseMessage(400,
                "Invalide Session Or Access Token")).build();
        }
        int logResult = logSessionEventToHistory(sessionID);
        if (logResult == 200 || logResult == 201) {
            databaseDAO.deleteSession(sessionID);
            databaseDAO.deleteService(sessionID);
            databaseDAO.deleteAuthenticatonAttempt(sessionID);
            return Response.ok().entity(new ApiResponseMessage(200,
                "Authentications Ended!")).build();
        }
        return Response.status(400).entity(new ApiResponseMessage(400,
            "Invilide Request")).build();
    }

    /**
     *
     * @param serviceParams
     * @param sessionId
     * @param serviceId
     * @param accessToken
     * @param securityContext
     * @return
     * @throws NotFoundException
     */
    @Override
    public Response notifyStartService(ServiceParams serviceParams,
        int sessionId,int serviceId,String accessToken,
        SecurityContext securityContext)throws NotFoundException {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        int payphoneServiceID = databaseDAO.getPayphoneServicID(sessionId);
        if ((!validateSession(sessionId, accessToken)
            || serviceParams.getCallAnswerTime() == null || serviceParams
                .getServiceStartTime() == null)
            || !databaseDAO.isPayphonesExist(payphoneServiceID)) {
            return Response.status(400).entity(new ApiResponseMessage(400,
                "Invalid Request")).build();
        }
		
        int callDurations = databaseDAO.getCallDuration(serviceId);
        int tariffID = databaseDAO.getTariffID(serviceId);
        com.emerge.ocs.database.model.Tariff tariff
            = databaseDAO.getTariffWithID(tariffID);
        double cost = getCallCost(tariff, callDurations);
        double balance = getPayphonebalance(payphoneServiceID);
        databaseDAO.debitPayphoneServiceBalance(payphoneServiceID,
            cost);
        //generate call details records and send to history db
        databaseDAO.updateService(serviceId, serviceParams.getCallAnswerTime(),
            serviceParams.getServiceStartTime(), callDurations, cost,
            balance);
        return Response.ok().entity(new ApiResponseMessage
                (200, "Start service notified!")).build();
    }

    @Override
    public Response resumeSession(int sessionId, String accessToken,
        SecurityContext securityContext) throws NotFoundException {
        // do some magic!
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        Response response;
        String validationMessage = "";
        try {
            validationMessage = Token.validateToken(Token.validateToken(
                accessToken));
        } catch (Exception e) {
            validationMessage = OcsApiImpCons.JWT_EXPIRED;
        }
        boolean isSessionExist = databaseDAO.isSessionExist(sessionId);
        if (validateSession(sessionId, accessToken)) {
            //return session resume msg
            response = Response.ok().entity(new ApiResponseMessage(200,
                "Session resumed")).build();
        } else if (isSessionExist && validationMessage.equals(
            OcsApiImpCons.JWT_EXPIRED)) {
            //update session details record and return resume msg

            databaseDAO.updateSession(accessToken, sessionId);
            response = Response.ok().entity(new ApiResponseMessage(200,
                "Session resumed")).build();
        } else {
            response = Response.status(401).entity(new ApiResponseMessage(401,
                OcsApiImpCons.UNEXPECTED_ERROR)).build();
        }
        return response;
    }

    @Override
    public Response startService(int sessionId, String accessToken,
        StartServiceRequest startServiceRequest,
        SecurityContext securityContext) throws NotFoundException {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        DateTime dt = new DateTime();  // current time
        int hours = dt.getHourOfDay();
        com.emerge.ocs.database.model.Tariff tariff
            = databaseDAO.getTariff(PrefixHelper
            .getPrefix(startServiceRequest.getDestinationMsisdn()),
                getDayOfTheWeek(), hours);
        int payphoneServiceID = databaseDAO.getPayphoneServicID(sessionId);
        int balance = databaseDAO.getPayphoneBalance(payphoneServiceID);
        if (!validateSession(sessionId, accessToken)) {
            return Response.status(400).entity(new ApiResponseMessage(400,
                "Invalide Access Token")).build();
        }
        if (validateCost(startServiceRequest, tariff)) {
            return Response.status(400).entity(new ApiResponseMessage(400,
                "Invalide Amount")).build();
        } else if (startServiceRequest.getOriginMsisdn().length() <= 5
            || startServiceRequest.getDestinationMsisdn().length() <= 5) {
            return Response.status(400).entity(new ApiResponseMessage(400,
                "Invalide Phone number")).build();
        }else if (balance < startServiceRequest.getServiceCredit()){
            return Response.status(400).entity(new ApiResponseMessage(400,
                "Invalide Amount")).build();
        }

        StartServiceResponse startServiceResponse = getStartServiceResponse(
            startServiceRequest, tariff, sessionId);
        return Response.ok().entity(startServiceResponse).build();
    }

    private String getHostname() {
        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
        }

        return hostname;
    }

    private PayphoneAuthenticationData persistSessions(
        final PayphoneAuthenticationData responseMessage,
        final AuthenticationReq payphoneInformation,
        final HttpServletRequest requestContext) {
        int sessionID;
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        int payphoneID = databaseDAO.getPayphoneID(payphoneInformation
            .getPayphone().getCredentials().getUsername(),
            payphoneInformation.getPayphone().getCredentials().getPassword());
        String generatedToken = getAccessToken(payphoneInformation.getPayphone()
            .getCredentials());
        ConfigData config = databaseDAO.getConfig(payphoneID);
        try {
            CreateSession(payphoneInformation, generatedToken, requestContext);
            sessionID = databaseDAO.getSessionID(payphoneID);
            getAuthenticationResponse(responseMessage, config,
                payphoneInformation, generatedToken, sessionID);
        } catch (Exception e) {
            if (e.getMessage().substring(42, 88).equals("duplicate "
                + "key value violates unique constraint")) {
                sessionID = databaseDAO.getSessionID(payphoneID);
                getAuthenticationResponse(responseMessage, config,
                    payphoneInformation, generatedToken, sessionID);
            } else {
                responseMessage.setMessage("Payphone Authentication Failed");
                responseMessage.setCode(OcsApiImpCons.ERROR_CODE);
            }
        }
        return responseMessage;
    }

    private void CreateSession(AuthenticationReq payphoneInformation,
        String generatedToken, HttpServletRequest requestContext) {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        int payphoneID = databaseDAO.getPayphoneID(payphoneInformation
            .getPayphone().getCredentials().getUsername(),
            payphoneInformation.getPayphone().getCredentials().getPassword());
        databaseDAO.Authenticate(payphoneInformation.getPayphone()
            .getCredentials().getUsername(),
            payphoneInformation.getPayphone().getEquipment().getIMEI1(),
            payphoneInformation.getPayphone().getSIM1().getMSISDN(),
            payphoneInformation.getPayphone().getSIM1().getIMSI(),
            payphoneInformation.getPayphone().getSIM1().getICCID(),
            payphoneInformation.getPayphone().getEquipment().getIMEI2(),
            payphoneInformation.getPayphone().getSIM2().getMSISDN(),
            payphoneInformation.getPayphone().getSIM2().getIMSI(),
            payphoneInformation.getPayphone().getSIM2().getICCID(),
            payphoneID,
            payphoneInformation.getPayphone().getApplication()
                .getVersion().toString(),
            generatedToken, payphoneInformation.getLocationInformation()
                .getGsmCellId(),
            payphoneInformation.getLocationInformation()
                .getGsmLocationAreaCode(),
            getHostname(), requestContext.getRemoteAddr());
    }

    private void getAuthenticationResponse(
        final PayphoneAuthenticationData responseMessage,
        final ConfigData config, AuthenticationReq payphoneInformation,
        final String generatedToken, int sessionID) {
        responseMessage.setMessage("Payphone Authenticated");
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        responseMessage.setCode("200");
        responseMessage.setConfigData(config);
        responseMessage.setSessionStartTime(new Date());
        responseMessage.setBalance(databaseDAO.getBalance(payphoneInformation
            .getPayphone().getCredentials().getUsername(),
            payphoneInformation.getPayphone().getCredentials().getPassword()));
        responseMessage.setAccessToken(generatedToken);
        responseMessage.setSessionID(sessionID);
    }

    private PayphoneAuthenticationData validationHandle(String isPayphoneValid,
        final String validationMessage,
        PayphoneAuthenticationData responseMessage,
        final AuthenticationReq payphoneInformation,
        final HttpServletRequest requestContext) {
        if (isPayphoneValid.equals(OcsApiImpCons.RECOMMENDED_UPDATE)
            || isPayphoneValid.equals(OcsApiImpCons.ACTIVE)
            && validationMessage.equals(OcsApiImpCons.VALIDATED)) {
            responseMessage = persistSessions(responseMessage,
                payphoneInformation, requestContext);
        } else if ((isPayphoneValid.equals(OcsApiImpCons.RECOMMENDED_UPDATE)
            || isPayphoneValid.equals(OcsApiImpCons.ACTIVE))
            && validationMessage.equals(OcsApiImpCons.JWT_EXPIRED)) {
            //Log session to history Database and delete session
            //from ongoing session details record
            responseMessage = persistSessions(responseMessage,
                payphoneInformation, requestContext);
        } else if (isPayphoneValid.equals(OcsApiImpCons.RECOMMENDED_UPDATE)
            || isPayphoneValid.equals(OcsApiImpCons.ACTIVE)) {
            responseMessage = persistSessions(responseMessage,
                payphoneInformation, requestContext);
        } else if (isPayphoneValid.equals(OcsApiImpCons.RECOMMENDED_UPDATE)) {
            responseMessage.setMessage(OcsApiImpCons.RECOMMENDED_UPDATE);
            responseMessage.setCode("200");
        } else {
            responseMessage.setMessage(OcsApiImpCons
                .PAYPHONE_AUTHENTICATION_FAILED);
            responseMessage.setCode(OcsApiImpCons.ERROR_CODE);
        }
        return responseMessage;
    }

    private void updatePayphone(AuthenticationReq payphoneInformation,
        int payphoneID) {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        databaseDAO.updatePayphone(payphoneInformation.getPayphone()
            .getEquipment().getIMEI1(),
            payphoneInformation.getPayphone().getEquipment().getIMEI2(),
            payphoneInformation.getPayphone().getEquipment().getSerialNr(),
            payphoneInformation.getPayphone().getEquipment().getMAC(), 1, 1,
            payphoneInformation.getPayphone().getConfigData()
                .getSilenceMode(), 1,
            payphoneInformation.getPayphone().getConfigData()
                .getSendErrorsToOCS(),
            payphoneID,
            payphoneInformation.getPayphone().getApplication().getVersion()
                .getMajor(),
            payphoneInformation.getPayphone().getApplication().getVersion()
                .getMinor(),
            payphoneInformation.getPayphone().getApplication().getVersion()
                .getPatch(),
            "ACTIVE");
    }

    /**
     *
     * @param startSessionReq
     * @param securityContext
     * @return
     * @throws NotFoundException
     */
    @Override
    public Response startsession(final Payphone startSessionReq,
        final SecurityContext securityContext) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    private String isVersionValid(final AuthenticationReq validationData,
        final int payphoneID) {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        String isValidated = "";
        int versionID = databaseDAO.getVersionID(payphoneID);
        boolean isVersionAllowed = databaseDAO.checkVersionExp(versionID,
            validationData.getPayphone().getApplication()
                .getVersion().getMajor(),
            validationData.getPayphone().getApplication()
                .getVersion().getMinor(),
            validationData.getPayphone().getApplication()
                .getVersion().getPatch());
        boolean isPayphoneValide = databaseDAO.isPayPhoneAuthenticated(
            validationData.getPayphone().getCredentials().getUsername(),
            validationData.getPayphone().getCredentials().getPassword(),
            validationData.getPayphone().getSIM1().getMSISDN(),
            validationData.getPayphone().getSIM1().getIMSI(),
            validationData.getPayphone().getSIM1().getICCID(),
            validationData.getPayphone().getSIM2().getMSISDN(),
            validationData.getPayphone().getSIM2().getIMSI(),
            validationData.getPayphone().getSIM2().getICCID());
        String status = databaseDAO.getVersionStatus(versionID,
            validationData.getPayphone().getApplication()
                .getVersion().getMajor(),
            validationData.getPayphone().getApplication()
                .getVersion().getMinor(),
            validationData.getPayphone().getApplication()
                .getVersion().getPatch());
        if (isPayphoneValide && status.equals(OcsApiImpCons.ACTIVE)
            && isVersionAllowed) {
            isValidated = OcsApiImpCons.ACTIVE;
        } else if (isPayphoneValide && status.equals(OcsApiImpCons
            .RECOMMENDED_UPDATE)
            && isVersionAllowed) {
            isValidated = OcsApiImpCons.RECOMMENDED_UPDATE;
        }

        return isValidated;
    }

    @Override
    public Response logServiceEvent(int sessionid, int serviceid,
        String accessToken, LogReq logReq,
        SecurityContext securityContext) throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response logSessionEvent(int sessionid, String accessToken,
        LogReq logReq, SecurityContext securityContext)
        throws NotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    private int logSessionEventToHistory(int sessionID) {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        RestClient restClient = null;
        Session session = databaseDAO.getSessionRecord(sessionID);
        AuthenticationAttempts authenticationAttempts
            = databaseDAO.getAuthenticationAttempt(sessionID);
        OngoingServiceInformation ongoingServiceInformation
            = databaseDAO.getServiceRecord(sessionID);
        Tariffs tariffs = databaseDAO.getTariffInfo(ongoingServiceInformation
            .getTariffId());
        SessionDocument sessionDocument = new SessionDocument();
        sessionDocument.setTariffs(tariffs);
        sessionDocument.setSession(session);
        sessionDocument.setAuthenticationAttempts(authenticationAttempts);
        sessionDocument.setPayphoneDevice(null);
        sessionDocument.setOngoingServiceInformation(ongoingServiceInformation);
//        sessionDocument.setLog_type("session_detail_record");
        int responseCode = 400;
        try {
            restClient
                = ElasticSearchClient.getHTTPClient("192.168.41.150", 9200);
            if (!(ElasticSearchCRUD.createRecordWithObject(sessionDocument,
                restClient, "ocs", "ongoing_session_detail_records") == null)) {
                responseCode = ElasticSearchCRUD.createRecordWithObject(
                    sessionDocument, restClient, "ocs",
                    "ongoing_session_detail_records")
                    .getStatusLine().getStatusCode();
            }
        } catch (UnknownHostException ex) {
        } catch (JsonProcessingException ex) {
        }
        return responseCode;
    }

    private boolean validateSession(int sessionid, String accessToken) {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        boolean isValid = false;
        boolean isSessionExist = databaseDAO.isSessionExist(sessionid);
        String validationMessage = "";
        try {
            validationMessage = Token.validateToken(accessToken);
        } catch (Exception e) {
            validationMessage = OcsApiImpCons.JWT_EXPIRED;
        }
        if (isSessionExist && validationMessage
            .equals(OcsApiImpCons.VALIDATED)) {
            isValid = true;
        } else if (isSessionExist && validationMessage
            .equals(OcsApiImpCons.JWT_EXPIRED)) {
            isValid = true;
        }
        return isValid;
    }

    private boolean validateService(final int sessionid, String accessToken,
        final int serviceID) {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        boolean isValid = false;
        boolean isSessionExist = databaseDAO.isServiceExist(serviceID,
            sessionid);
        String validationMessage = "";
        try {
            validationMessage = Token.validateToken(accessToken);
        } catch (Exception e) {
            validationMessage = OcsApiImpCons.JWT_EXPIRED;
        }
        if (isSessionExist && validationMessage.equals(
            OcsApiImpCons.VALIDATED)) {
            isValid = true;
        } else if (isSessionExist && validationMessage.equals(
            OcsApiImpCons.JWT_EXPIRED)) {
            isValid = true;
        }
        return isValid;
    }

    private String getAccessToken(PayphoneCredentials payphone) {
        Map<String, Object> payphoneObj = new HashMap<String, Object>();
        payphoneObj.put("payphone", payphone);
        String generatedToken = Token.getToken(
            (HashMap<String, Object>) payphoneObj);

        return generatedToken;
    }

    private boolean validateCost(StartServiceRequest startServiceRequest,
        com.emerge.ocs.database.model.Tariff tariff) {
        if (startServiceRequest.getServiceCredit() 
           < (tariff.getInitial_cost() + tariff.getSetup_cost())) {
           return true;
       }
        //Check for prefered msisdn and take neccessary actions

        return false;
    }

    private double getPayphonebalance(int payphoneID) {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        double balance = databaseDAO.getServiceBalance(payphoneID);
        return balance;
    }

    private int getCallDuration(StartServiceRequest startServiceRequest,
        final com.emerge.ocs.database.model.Tariff tariff) {
        double duration = (Math.floor((startServiceRequest.getServiceCredit()
            - (tariff.getSetup_cost()+ tariff.getInitial_cost()))
            / tariff.getRecurrent_cost())
            * tariff.getRecurrent_duration())
            + tariff.getInitial_duration();
        return (int) duration;
    }

    private int getDayOfTheWeek() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.DAY_OF_WEEK);
    }

    private int createService(com.emerge.ocs.database.model.Tariff tariff,
        StartServiceRequest startServiceRequest, int callduration,
        int sessionId) {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        int payphoneServiceID = databaseDAO.getPayphoneServicID(sessionId);
        return databaseDAO.createService(getHostname(), callduration,
            startServiceRequest.getOriginMsisdn(),
            startServiceRequest.getDestinationMsisdn(), tariff.getGroup_id(),
            tariff.getId(),
            sessionId, 1, payphoneServiceID);
    }

    private StartServiceResponse getStartServiceResponse(
        StartServiceRequest startServiceRequest,
        com.emerge.ocs.database.model.Tariff tariff, int sessionId) {
       final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        StartServiceResponse startServiceResponse = new StartServiceResponse();
        int callduration = getCallDuration(startServiceRequest, tariff);
        Tariff serviceTariff = new Tariff();
        int getServiceID = createService(tariff, startServiceRequest, callduration, sessionId);
//        int getServiceID = databaseDAO.getServiceID(sessionId);
        serviceTariff.setGroupId(tariff.getGroup_id());
        serviceTariff.setCost(startServiceRequest.getServiceCredit());
        serviceTariff.setId(tariff.getId());
        serviceTariff.setZoneId(tariff.getZoneID());
        startServiceResponse.setOriginMsisdn(startServiceRequest
            .getOriginMsisdn());
        startServiceResponse.serviceId(getServiceID);
        startServiceResponse.setServiceAuthorizedTime(new Date());
        startServiceResponse.setMaxServiceDuration(callduration);
        startServiceResponse.setTariff(serviceTariff);

        return startServiceResponse;
    }

    private double getCallCost(com.emerge.ocs.database.model.Tariff tariff,
        final int callDurations) {
        double calCost = (tariff.getSetup_cost() + tariff.getInitial_cost()
            + ((callDurations - tariff.getInitial_duration())
            / tariff.getRecurrent_duration())
            * tariff.getRecurrent_cost());
        calCost = calCost + tariff.getSetup_cost();
        return calCost ;
    }

    private double rebalanceCharges(EndServiceReq notifyServiceInformation,
        int serviceId) {
       final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        int tariffID = databaseDAO.getTariffID(serviceId);
        com.emerge.ocs.database.model.Tariff tariff
            = databaseDAO.getTariffWithID(tariffID);
        double billedAmount = databaseDAO.getBilledAmount(serviceId);
        int payphoneServiceID = databaseDAO.getPayphoneID(serviceId);
        double actualCost = getCallCost(tariff, notifyServiceInformation
            .getServiceDuration()); 

        databaseDAO.rebalancePayphoneService(payphoneServiceID,
            billedAmount - actualCost);
        return actualCost;
    }

    private double getInitialBalance(int serviceID) {
        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        int payphoneServiceID = databaseDAO.getPayphoneID(serviceID);
        return databaseDAO.getServiceBalance(payphoneServiceID);
    }
    
    
    public final long createPayphoneService(AuthenticationReq payphoneInformation)
            throws Exception {

        final DatabaseDAO databaseDAO;
        final JdbiHelper mJbdiHelper = new JdbiHelper();
        databaseDAO = mJbdiHelper.getDBI().onDemand(DatabaseDAO.class);
        
        long contractId =  payphoneInformation.getPayphone().getAccountID();
        String sim1MSISDN = payphoneInformation.getPayphone().getSIM1()
            .getMSISDN();
        String sim1IMSI = payphoneInformation.getPayphone().getSIM1()
            .getIMSI();
        String sim1ICCID = payphoneInformation.getPayphone().getSIM1()
            .getICCID();
        String sim2MSISDN = payphoneInformation.getPayphone().getSIM2()
            .getMSISDN();
        String sim2IMSI = payphoneInformation.getPayphone().getSIM2()
            .getIMSI();
        String sim2ICCID = payphoneInformation.getPayphone().getSIM2()
            .getICCID();
        double balance = 2343;
        String username = payphoneInformation.getPayphone().getCredentials()
            .getUsername();
        String password = payphoneInformation.getPayphone().getCredentials()
            .getPassword();

        long profileId = 1;
        String status = payphoneInformation.getPayphone().getStatus()
            .getStatus().toString().toUpperCase();

        long generatedId = databaseDAO.insertIntoServices(contractId,
                sim1MSISDN, sim1IMSI, sim1ICCID, sim2MSISDN, sim2IMSI,
                sim2ICCID, balance, username, password, status, profileId,
                payphoneInformation.getPayphone().getConfigData()
                    .getPreferredMSISDN(),
                payphoneInformation.getPayphone().getConfigData()
                    .getKeepAliveInterval()
        );
        
        return generatedId;
    }

}