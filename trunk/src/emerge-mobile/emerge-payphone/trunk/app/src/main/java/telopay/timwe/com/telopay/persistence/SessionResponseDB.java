package telopay.timwe.com.telopay.persistence;

import android.content.Context;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import telopay.timwe.com.telopay.model.PayPhone;
import telopay.timwe.com.telopay.response.SessionResponse;

/**
 * Created by timwe.tunji on 11/15/2016.
 */

public class SessionResponseDB {

    private static DB snappyDB;
    private static final String DB_NAME = "SESSION_RESPONSE_DB";

    public static boolean openSessionResponseDB(Context context) {
        try {
            snappyDB = DBFactory.open(context, DB_NAME);
            return true;
        } catch (SnappydbException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static SessionResponse getSessionResponse() {
        try {
            return (SessionResponse) snappyDB.getObject("sessionResponse", SessionResponse.class);
        } catch (Exception e) {
            return null;
        }
    }

    public static void saveSessionResponse(SessionResponse sessionResponse) {
        try {
            if (snappyDB.exists("sessionResponse")) {
                snappyDB.del("sessionResponse");
            }

            snappyDB.put("sessionResponse", sessionResponse);
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }

    public static void closeSessionResponseDB() {
        try {
            snappyDB.close();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }
}
