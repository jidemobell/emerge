package telopay.timwe.com.telopay.model;

/**
 * Created by timwe.tunji on 11/1/2016.
 */
public class LocationInformation {

    private String gsmCellId;
    private String gsmLocationAreaCode;
    private double gpsLat;
    private double gpsLong;


    public String getGsmCellId() {
        return gsmCellId;
    }

    public void setGsmCellId(String gsmCellId) {
        this.gsmCellId = gsmCellId;
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
