package telopay.timwe.com.telopay.model;

import retrofit2.Call;
import retrofit2.Callback;
import telopay.timwe.com.telopay.helpers.APIConnector;
import telopay.timwe.com.telopay.helpers.PayphoneService;
import telopay.timwe.com.telopay.response.ServiceResponse;


/**
 * Created by kamiye on 01/11/2016.
 */

public class TeloPaySession {

    private static TeloPaySession teloPaySession;

    public static TeloPaySession getInstance() {
        if (teloPaySession == null) {
            teloPaySession = new TeloPaySession();
        }
        return teloPaySession;
    }

    /**
     * Send end teloPaySession request to the OCS
     */
    public void end(Callback<ServiceResponse> callback) {
        PayphoneService payphoneInterface = APIConnector.getRetrofit().create(PayphoneService.class);
        Call<ServiceResponse> endSessionCall = payphoneInterface.endSession("accessToken", "sessionId");
        endSessionCall.enqueue(callback);
    }


}
