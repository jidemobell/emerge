package telopay.timwe.com.telopay.helpers;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import telopay.timwe.com.telopay.request.AuthenticationRequest;
import telopay.timwe.com.telopay.request.EndServiceRequest;
import telopay.timwe.com.telopay.request.NotifyStartServiceRequest;
import telopay.timwe.com.telopay.request.StartServiceRequest;
import telopay.timwe.com.telopay.response.StartServiceResponse;
import telopay.timwe.com.telopay.response.ServiceResponse;
import telopay.timwe.com.telopay.response.SessionResponse;

/**
 * Created by timwe.tunji on 10/11/2016.
 */
public interface PayphoneService {

    @Headers("Content-Type:application/json")
    @POST("emerge-ocs-call-control/v1/call-control/payphones/authenticate")
    Call<SessionResponse> authenticate(@Header("Authorization") String authorization, @Body AuthenticationRequest authRequest);

    @Headers("Content-Type: application/json")
    @POST("emerge-ocs-call-control/v1/call-control/payphones/session")
    Call<SessionResponse> startSession(@Header("Authorization") String authorization, @Body AuthenticationRequest authRequest);

    @DELETE("/ocs/payphones/callcontrol/authenticate")
    Call<ServiceResponse> endSession(@Header("accessToken") String accessToken, @Header("sessionID") String sessionID);

    @PUT("ocs/v1/payphones/callcontrol/session")
    Call<ServiceResponse> resumeSession(@Header("accessToken") String accessToken, @Header("sessionId") String sessionID);

    @Headers("Content-Type:application/json")
    @POST("emerge-ocs-call-control/v1/call-control/payphones/session/{sessionID}/service")
    Call<StartServiceResponse> startService(@Header("accessToken") String accessToken,
                                            @Path("sessionID") String sessionId, @Body StartServiceRequest request);

    @Headers("Content-Type:application/json")
    @PUT("emerge-ocs-call-control/v1/call-control/payphones/session/{sessionID}/service/{serviceID}")
    Call<ServiceResponse> notifyStartService(@Header("accessToken") String accessToken,
                                             @Path("sessionID")String sessionId, @Path("serviceID")String serviceId,
                                             @Body NotifyStartServiceRequest notifyStartServiceRequest);

    @Headers("Content-Type:application/json")
    @DELETE("emerge-ocs-call-control/v1/call-control/payphones/session/{sessionID}/service/{serviceID}")
    Call<ServiceResponse> endService(@Header("accessToken")String accessToken,
                                     @Path("sessionID")String sessionId, @Path("serviceID")String serviceId,
                                     @Body EndServiceRequest endServiceRequest);


}
