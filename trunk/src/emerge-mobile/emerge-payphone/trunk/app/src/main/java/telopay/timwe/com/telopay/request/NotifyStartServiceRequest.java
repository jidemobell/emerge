package telopay.timwe.com.telopay.request;

/**
 * Created by timwe.tunji on 11/15/2016.
 */

public class NotifyStartServiceRequest {

    private String payphoneID;
    private String callAnswerTime;
    private String serviceStartTime;

    public String getPayphoneID() {
        return payphoneID;
    }

    public void setPayphoneID(String payphoneID) {
        this.payphoneID = payphoneID;
    }

    public String getCallAnswerTime() {
        return callAnswerTime;
    }

    public void setCallAnswerTime(String callAnswerTime) {
        this.callAnswerTime = callAnswerTime;
    }

    public String getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(String serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }
}
