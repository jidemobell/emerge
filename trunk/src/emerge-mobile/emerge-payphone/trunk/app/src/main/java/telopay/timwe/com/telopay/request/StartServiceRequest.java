package telopay.timwe.com.telopay.request;

/**
 * Created by timwe.tunji on 11/3/2016.
 */
public class StartServiceRequest {

    private String originMsisdn;
    private String destinationMsisdn;
    private String serviceCredit;
   // private String id;
   // private String payphoneID;


    public String getOriginMsisdn() {
        return originMsisdn;
    }

    public void setOriginMsisdn(String originMsisdn) {
        this.originMsisdn = originMsisdn;
    }

    public String getDestinationMsisdn() {
        return destinationMsisdn;
    }

    public void setDestinationMsisdn(String destinationMsisdn) {
        this.destinationMsisdn = destinationMsisdn;
    }

    public String getServiceCredit() {
        return serviceCredit;
    }

    public void setServiceCredit(String serviceCredit) {
        this.serviceCredit = serviceCredit;
    }


}
