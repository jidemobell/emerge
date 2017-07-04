package telopay.timwe.com.telopay;

import android.app.Application;
import android.content.Context;
import android.telecom.Call;
import android.telecom.InCallService;
import android.util.Log;

import java.util.List;

/**
 * Created by timwe.tunji on 10/6/2016.
 */
public class TeloPayApplication extends Application{

   private static Context context;

    public void onCreate(){
        super.onCreate();
        TeloPayApplication.context = getApplicationContext();
    }

    public static Context getAppContext(){
        return TeloPayApplication.context;
    }



}
