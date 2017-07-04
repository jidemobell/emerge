package telopay.timwe.com.telopay.telephony;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by timwe.tunji on 10/17/2016.
 */
public class DeviceInfo {
    private TelephonyManager telephonyManager;

    public DeviceInfo(Context context){
        this.telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    public String getIMEI(){
        return telephonyManager.getDeviceId();
    }

    public String getICCID(){
        return telephonyManager.getSimSerialNumber();
    }

    public String getIMSI(){
        return telephonyManager.getSubscriberId();
    }

    public String getMSISDN(){
        return  telephonyManager.getLine1Number();
    }
}
