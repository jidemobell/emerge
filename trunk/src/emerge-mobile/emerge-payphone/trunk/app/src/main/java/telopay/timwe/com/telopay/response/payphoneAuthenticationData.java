package telopay.timwe.com.telopay.response;
import java.io.Serializable;

/**
 * Created by timwe.tunji on 10/11/2016.
 */
public class payphoneAuthenticationData implements Serializable {

    private String accessToken;
    private String sessionID;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
}
