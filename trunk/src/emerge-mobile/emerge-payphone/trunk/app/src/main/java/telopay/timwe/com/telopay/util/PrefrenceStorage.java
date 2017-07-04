package telopay.timwe.com.telopay.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by timwe.tunji on 11/15/2016.
 */

public class PrefrenceStorage {

    Context context;
    SharedPreferences preferences;
    private final static String PREFERENCE_NAME = "TeloPay";

    public PrefrenceStorage(Context context){
        this.context = context;
    }

    public void saveAccessToken(String accessToken){
        preferences = context.getApplicationContext().getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor= preferences.edit();
        prefEditor.putString("accessToken",accessToken);
        prefEditor.commit();
    }

    public String getAccessToken(){
        preferences = context.getApplicationContext().getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        return preferences.getString("accessToken","");
    }

    public void saveSessionID(String sessionId){
        preferences = context.getApplicationContext().getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor= preferences.edit();
        prefEditor.putString("sessionId",sessionId);
        prefEditor.commit();
    }

    public String getSessionID(){
        preferences = context.getApplicationContext().getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        return preferences.getString("sessionId","");

    }
}
