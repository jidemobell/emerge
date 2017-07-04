package telopay.timwe.com.telopay.model;

/**
 * Created by timwe.tunji on 10/24/2016.
 */
public class OngoingServiceRecord {

    private String sessionid;
    private String serviceId;
    private String accessToken;

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
