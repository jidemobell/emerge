package telopay.timwe.com.telopay;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;

import telopay.timwe.com.telopay.model.CallHistory;

public class CallDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String DIALOG_FRAGMENT = "dialog_fragment_tag";
    private ImageView imgViewEndSession, imgViewNewCall;
    private TextView txtDestinationMsisdn, txtCallDuration,txtAmountCharged,txtBalanceRemain;
    private double balance = 0;
    private String accountBlance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_details);
        getSupportActionBar().setTitle(R.string.call_summary);
        imgViewEndSession = (ImageView) findViewById(R.id.imgViewEndSession);
        imgViewNewCall = (ImageView) findViewById(R.id.imgViewNewCall);
        txtDestinationMsisdn = (TextView) findViewById(R.id.destinationMsisdn);
        txtCallDuration = (TextView) findViewById(R.id.callDuration);
        txtAmountCharged = (TextView)findViewById(R.id.txtAmountCharged);
        txtBalanceRemain = (TextView)findViewById(R.id.txtBalanceRemain);
        imgViewEndSession.setOnClickListener(this);
        imgViewNewCall.setOnClickListener(this);
        String timeLeft = getIntent().getStringExtra("timeLeft");
        String destinationMsisdn = getIntent().getStringExtra("destination_msisdn");
        String callDuration = getIntent().getStringExtra("totalDuration");
        String totalCallCost = getIntent().getStringExtra("totalCallCost");
        balance = getIntent().getDoubleExtra("callBalance",0);
        DecimalFormat df = new DecimalFormat("#.00");
        accountBlance = df.format(balance);
        txtCallDuration.setText(callDuration + " secs");
        txtDestinationMsisdn.setText(destinationMsisdn);
        txtAmountCharged.setText(df.format(Double.parseDouble(totalCallCost))+"Kz");
        txtBalanceRemain.setText(df.format(Double.parseDouble(accountBlance))+"Kz");


       
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        AdditionalCallDialogFragment dialogFragment = AdditionalCallDialogFragment.getInstance(df.format(Double.parseDouble(accountBlance)));
        dialogFragment.show(fragmentTransaction, DIALOG_FRAGMENT);
    }

    @Override
    public void onClick(View v) {
        if (v == imgViewEndSession) {
            Intent homeIntent = new Intent(this, HomeActivity.class);
            startActivity(homeIntent);
            finish();
        }

        if (v == imgViewNewCall) {
            Intent establishCallIntent = new Intent(this, EstablishCallActivity.class);
            establishCallIntent.putExtra("spendableAmount",String.valueOf(balance));
            startActivity(establishCallIntent);
            finish();
        }
    }
}
