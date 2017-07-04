package telopay.timwe.com.telopay.persistence;

import android.content.Context;

import com.snappydb.DB;
import com.snappydb.DBFactory;
import com.snappydb.SnappydbException;

import java.util.ArrayList;
import java.util.List;

import telopay.timwe.com.telopay.model.CallHistory;

/**
 * Created by timwe.tunji on 11/15/2016.
 */

public class CallHistoryDB {

    private static DB snappyDB;
    private final static String DB_NAME = "CALL_HISTORY";
    private  static List <CallHistory>  callHistoryList =null;

    public static boolean opeHistoryDB(Context context){
        try{
            snappyDB = DBFactory.open(context,DB_NAME);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public static void addCallHistory(CallHistory callHistory){
        try{
            callHistoryList = getCallHistoryList();
            if(callHistoryList == null){
                callHistoryList = new ArrayList<>();
            }
            callHistoryList.add(callHistory);
            snappyDB.put("callHistoryList",callHistoryList);
        }
        catch(SnappydbException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<CallHistory> getCallHistoryList(){
        try{
            return  (ArrayList<CallHistory>) snappyDB.get("callHistoryList",ArrayList.class);
        }
        catch(SnappydbException e){
            return null;
        }
    }

    public static void closeDB(){
        try {
            snappyDB.close();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }
}
