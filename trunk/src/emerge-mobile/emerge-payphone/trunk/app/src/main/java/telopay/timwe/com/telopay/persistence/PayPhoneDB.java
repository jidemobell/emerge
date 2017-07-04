package telopay.timwe.com.telopay.persistence;

import android.content.Context;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import java.util.ArrayList;
import java.util.List;

import telopay.timwe.com.telopay.model.PayPhone;

/**
 * Created by timwe.tunji on 10/14/2016.
 */
public class PayPhoneDB {

    private static DB snappyDB;
    private static final String DB_NAME = "PAYPHONE_DB";

    public static boolean openPayPhoneDB(Context context) {
        try {
            snappyDB = DBFactory.open(context, DB_NAME);
            return true;
        } catch (SnappydbException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static PayPhone getPayPhone() {
        try {
            return (PayPhone) snappyDB.getObject("payphone", PayPhone.class);
        } catch (Exception e) {
            return null;
        }
    }

    public static void addPayPhone(PayPhone payPhone) {
        try {
            if (snappyDB.exists("payphone")) {
                snappyDB.del("payphone");
            }

            snappyDB.put("payphone", payPhone);
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }
}
