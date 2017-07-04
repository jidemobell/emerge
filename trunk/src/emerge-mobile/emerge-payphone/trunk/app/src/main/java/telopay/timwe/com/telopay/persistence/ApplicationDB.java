package telopay.timwe.com.telopay.persistence;

import android.content.Context;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import telopay.timwe.com.telopay.model.Application;
import telopay.timwe.com.telopay.model.PayPhone;

/**
 * Created by timwe.tunji on 10/14/2016.
 */
public class ApplicationDB {

    private static DB snappyDB;
    private static final String DB_NAME = "APPLICATION_DB";

    public static boolean openApplicationDB(Context context){
      try
      {
          snappyDB = DBFactory.open(context, DB_NAME);
          return true;
      }
      catch(Exception e)
      {
          return false;
      }
    }

    public static Application getApplication(){
        try
        {
            return (Application)snappyDB.getObject("payphone_app",Application.class);
        }
        catch (Exception e)
        {
            return  null;
        }
    }

    public static void addApplication(Application application){
        try {
            if(snappyDB.exists("payphone_app")) {
                snappyDB.del("payphone_app");
            }
            snappyDB.put("payphone_app", PayPhone.class);
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }
}
