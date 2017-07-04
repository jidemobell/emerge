package telopay.timwe.com.telopay.locationservice;

import android.content.Context;
import android.location.LocationManager;

/**
 * Created by timwe.tunji on 10/19/2016.
 */
public class DeviceLocationManager {


        private static LocationManager instance;

        public static LocationManager getInstance(Context context){
            if(instance==null){
                instance = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
            }
            return instance;
        }

    }

