package telopay.timwe.com.telopay.response;

import telopay.timwe.com.telopay.model.Tarrif;

/**
 * Created by timwe.tunji on 11/7/2016.
 */
public class StartServiceResponse {

    private String serviceId;
    private String serviceAuthorizedTime;
    private String originMsisdn;
    private int maxServiceDuration;
    private Tarrif tariff;

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceAuthorizedTime() {
        return serviceAuthorizedTime;
    }

    public void setServiceAuthorizedTime(String serviceAuthorizedTime) {
        this.serviceAuthorizedTime = serviceAuthorizedTime;
    }

    public String getOriginMsisdn() {
        return originMsisdn;
    }

    public void setOriginMsisdn(String originMsisdn) {
        this.originMsisdn = originMsisdn;
    }

    public int getMaxServiceDuration() {
        return maxServiceDuration;
    }

    public void setMaxServiceDuration(int maxServiceDuration) {
        this.maxServiceDuration = maxServiceDuration;
    }

    public Tarrif getTariff() {
        return tariff;
    }

    public void setTariff(Tarrif tariff) {
        this.tariff = tariff;
    }
}
