package telopay.timwe.com.telopay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Collections;
import telopay.timwe.com.telopay.adapter.PayphoneActivityListAdapter;
import telopay.timwe.com.telopay.model.CallHistory;
import telopay.timwe.com.telopay.persistence.CallHistoryDB;

public class PayphoneActivity extends AppCompatActivity {

    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payphone);
        getSupportActionBar().setTitle(getString(R.string.text_payphone_activity_title));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        listView = (ListView) findViewById(R.id.actlistView);
        CallHistoryDB.opeHistoryDB(this);
        ArrayList<CallHistory> callListArray = CallHistoryDB.getCallHistoryList();
        CallHistoryDB.closeDB();
        if(callListArray != null) {
            Log.i("CALL HISTORY LIST :", "" + callListArray.size());
        }
        else{
            callListArray = new ArrayList<>();
        }

        PayphoneActivityListAdapter adapter = new PayphoneActivityListAdapter(this,callListArray);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
