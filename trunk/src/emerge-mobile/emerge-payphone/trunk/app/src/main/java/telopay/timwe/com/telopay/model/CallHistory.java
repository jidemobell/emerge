package telopay.timwe.com.telopay.model;

/**
 * Created by timwe.tunji on 11/10/2016.
 */
public class CallHistory {

    private String dialNumber;
    private String callCost;
    private String callDuration;

    public String getDialNumber() {
        return dialNumber;
    }

    public void setDialNumber(String dialNumber) {
        this.dialNumber = dialNumber;
    }

    public String getCallCost() {
        return callCost;
    }

    public void setCallCost(String callCost) {
        this.callCost = callCost;
    }

    public String getCallDuration() {
        return callDuration;
    }

    public void setCallDuration(String callDuration) {
        this.callDuration = callDuration;
    }
}
