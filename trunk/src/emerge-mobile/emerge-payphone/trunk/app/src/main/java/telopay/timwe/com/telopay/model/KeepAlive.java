package telopay.timwe.com.telopay.model;

/**
 * Created by timwe.tunji on 10/13/2016.
 */
public class KeepAlive {

    private PayPhone payPhone;
    private String gsmCellID;
    private String gsmLocationAreaCode;
    private double gpsLat;
    private double gpsLong;

    public PayPhone getPayPhone() {
        return payPhone;
    }

    public void setPayPhone(PayPhone payPhone) {
        this.payPhone = payPhone;
    }

    public String getGsmCellID() {
        return gsmCellID;
    }

    public void setGsmCellID(String gsmCellID) {
        this.gsmCellID = gsmCellID;
    }

    public String getGsmLocationAreaCode() {
        return gsmLocationAreaCode;
    }

    public void setGsmLocationAreaCode(String gsmLocationAreaCode) {
        this.gsmLocationAreaCode = gsmLocationAreaCode;
    }

    public double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(double gpsLat) {
        this.gpsLat = gpsLat;
    }

    public double getGpsLong() {
        return gpsLong;
    }

    public void setGpsLong(double gpsLong) {
        this.gpsLong = gpsLong;
    }
}
