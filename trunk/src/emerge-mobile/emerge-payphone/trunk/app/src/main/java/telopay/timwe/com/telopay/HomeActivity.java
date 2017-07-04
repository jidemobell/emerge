package telopay.timwe.com.telopay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.telecom.InCallService;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout lvMakeCall;
    private LinearLayout lvPayphoneActivity;
    private LinearLayout lvConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvMakeCall = (LinearLayout) findViewById(R.id.viewMakeCall);
        lvMakeCall.setOnClickListener(this);
        lvConfiguration = (LinearLayout) findViewById(R.id.viewConfiguration);
        lvConfiguration.setOnClickListener(this);
        lvPayphoneActivity = (LinearLayout) findViewById(R.id.viewPayphoneActivity);
        lvPayphoneActivity.setOnClickListener(this);
    }



    @Override
    public void onBackPressed() {

    }

    @Override
    public void onClick(View v) {
        if (v == lvMakeCall) {
            Intent callSetupIntent = new Intent(this, CallSetupActvity.class);
            startActivity(callSetupIntent);
        }
        if (v == lvConfiguration) {
            Intent configurationIntent = new Intent(this, ConfigurationActivity.class);
            startActivity(configurationIntent);
        }

        if (v == lvPayphoneActivity) {
            Intent phoneActivityIntent = new Intent(this, PayphoneActivity.class);
            startActivity(phoneActivityIntent);
        }
    }
}
