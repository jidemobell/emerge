package telopay.timwe.com.telopay.request;

import telopay.timwe.com.telopay.model.LocationInformation;
import telopay.timwe.com.telopay.model.PayPhone;

/**
 * Created by timwe.tunji on 11/1/2016.
 */
public class AuthenticationRequest {



    private PayPhone payphone;
    private LocationInformation locationInformation;

    public PayPhone getPayPhone() {
        return payphone;
    }

    public void setPayPhone(PayPhone payPhone) {
        this.payphone = payPhone;
    }

    public LocationInformation getLocationInformation() {
        return locationInformation;
    }

    public void setLocationInformation(LocationInformation locationInformation) {
        this.locationInformation = locationInformation;
    }
}
