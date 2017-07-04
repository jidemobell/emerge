package telopay.timwe.com.telopay;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import telopay.timwe.com.telopay.helpers.APIConnector;
import telopay.timwe.com.telopay.helpers.PayphoneService;
import telopay.timwe.com.telopay.helpers.Util;
import telopay.timwe.com.telopay.model.CallHistory;
import telopay.timwe.com.telopay.model.TeloPaySession;
import telopay.timwe.com.telopay.persistence.CallHistoryDB;
import telopay.timwe.com.telopay.request.EndServiceRequest;
import telopay.timwe.com.telopay.request.NotifyStartServiceRequest;
import telopay.timwe.com.telopay.response.ServiceResponse;
import telopay.timwe.com.telopay.response.StartServiceResponse;
import telopay.timwe.com.telopay.telephony.CallBroadcast;
import telopay.timwe.com.telopay.util.PrefrenceStorage;


public class CallInProgressActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int startDuration = 1000;

    private Button btnTerminateCall;
    private TextView txtDestMsisdn;
    private TextView txtDuration;
    private TextView txtTimeRemaining;
    private CallBroadcast callBroadcast;
    private static long maxDuration = 0;
    private static long totalDuration = 0;
    private String destinationMsisdn = "";
    private double tarrif;
    private double totalCallCost;
    private double callBalance;
    private double spendableAmount;
    private String serviceId;
    private int maxiMumDuration;
    private PrefrenceStorage prefrenceStorage;
    private String serviceStartTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_in_progress);
        getSupportActionBar().setTitle(getString(R.string.text_call_in_progress_screen_title));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);

        destinationMsisdn = getIntent().getStringExtra("destination_msisdn");
        maxiMumDuration = getIntent().getIntExtra("maxDuration", 0);
        tarrif = getIntent().getDoubleExtra("tarrif", 0);
        serviceId = getIntent().getStringExtra("serviceID");
        spendableAmount = Double.parseDouble(getIntent().getStringExtra("spendableAmount"));
        txtDestMsisdn = (TextView) findViewById(R.id.txtDestMsisdn);
        txtDuration = (TextView) findViewById(R.id.txtDuration);
        txtTimeRemaining = (TextView) findViewById(R.id.txtTimeRemaining);
        txtDestMsisdn.setText(destinationMsisdn);
        btnTerminateCall = (Button) findViewById(R.id.btnTerminateCall);
        btnTerminateCall.setOnClickListener(this);
        prefrenceStorage = new PrefrenceStorage(this);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        serviceStartTime = sdf.format(new Date());
        NotifyStartServiceRequest request = new NotifyStartServiceRequest();
        request.setPayphoneID("1");
        request.setCallAnswerTime(serviceStartTime);
        request.setServiceStartTime(serviceStartTime);
        notifyStartService(prefrenceStorage.getAccessToken(), prefrenceStorage.getSessionID(), serviceId, request);

    }

    private void notifyStartService(String accessToken, String sessionId, String serviceId, NotifyStartServiceRequest request) {
        PayphoneService payphoneInterface = APIConnector.getRetrofit().create(PayphoneService.class);
        Call<ServiceResponse> call = payphoneInterface.notifyStartService(accessToken, sessionId, serviceId, request);
        Log.i("NofityServiceRequest", Util.getRequestString(call.request().body()));
        call.enqueue(new Callback<ServiceResponse>() {
            @Override
            public void onResponse(Call<ServiceResponse> call, Response<ServiceResponse> response) {
                if (response.isSuccessful()) {
                    Log.i("NotifyService", response.body().getMessage());
                    setMaxDuration(maxiMumDuration * 1000);
                    beginCallTimer();
                } else {
                    Log.i("NotifyServiceError", response.raw().toString());
                    Toast.makeText(getApplicationContext(), "Error Notifying OCS", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ServiceResponse> call, Throwable t) {
                Log.e("NotifyServiceFailure", t.getMessage());
                Toast.makeText(getApplicationContext(), "Failure Notifying OCS", Toast.LENGTH_SHORT).show();
            }
        });
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

    @Override
    public void onClick(View v) {
        if (v == btnTerminateCall) {
            long timeLeft = (maxDuration / 1000) - totalDuration;
            totalCallCost = tarrif * totalDuration / 1000;
            Log.i("TOTAL COST:", "" + totalCallCost);
            Log.i("SPENDABLE:", "" + spendableAmount);
            callBalance = spendableAmount - totalCallCost;
            if (timeLeft > 1) {
                Intent callDetailIntent = new Intent(this, CallDetailsActivity.class);
                callDetailIntent.putExtra("timeLeft", String.valueOf(timeLeft));
                callDetailIntent.putExtra("destination_msisdn", destinationMsisdn);
                callDetailIntent.putExtra("totalDuration", String.valueOf(totalDuration));
                callDetailIntent.putExtra("totalCallCost", String.valueOf(totalCallCost));
                callDetailIntent.putExtra("callBalance", callBalance);
                DecimalFormat df = new DecimalFormat("#.00");
                String duration = totalDuration + "s";
                String amountSpent = df.format(totalCallCost)+"Kz";
                saveCallHistory(destinationMsisdn,amountSpent,duration);
                //endService(prefrenceStorage.getAccessToken(),prefrenceStorage.getSessionID(),serviceId,
                //           serviceStartTime,serviceStartTime,serviceStartTime,String.valueOf(totalDuration),"Call Ended");
                startActivity(callDetailIntent);
                finish();

            }
            else {
                DecimalFormat df = new DecimalFormat("#.00");
                String duration = totalDuration+ "s";
                String amountSpent = df.format(totalCallCost)+"Kz";
                saveCallHistory(destinationMsisdn,amountSpent,duration);
                Intent homeIntent = new Intent(this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }
    }

    private void endService(String accessToken, String sessionId,String serviceId,
                            String serviceStartTime,String callAnswerTime,
                            String serviceEndTime,String serviceDuration,String endCause){
        final EndServiceRequest request = new EndServiceRequest();
        request.setServiceStartTime(serviceStartTime);
        request.setCallAnswerTime(callAnswerTime);
        request.setEndCause(endCause);
        request.setServiceEndTime(serviceEndTime);
        request.setServiceDuration(serviceDuration);
        PayphoneService payphoneInterface = APIConnector.getRetrofit().create(PayphoneService.class);
        Call<ServiceResponse> call = payphoneInterface.endService(accessToken,sessionId,serviceId,request);
        call.enqueue(new Callback<ServiceResponse>() {
            @Override
            public void onResponse(Call<ServiceResponse> call, Response<ServiceResponse> response) {
                if(response.isSuccessful()){
                    Log.i("END SERVICE",response.body().getMessage());
                }
                else{
                    Log.i("END SERVICE","Error response from the server"+" "+response.code());
                }
            }

            @Override
            public void onFailure(Call<ServiceResponse> call, Throwable t) {
                Log.i("END SERVICE","Failure response from the OCS"+" "+t.getMessage());
            }
        });
    }

    private void saveCallHistory(String destinationMsisdn, String amountSpent,String duration){
        CallHistoryDB.opeHistoryDB(this);
        CallHistory callHistory = new CallHistory();
        callHistory.setCallCost(amountSpent);
        callHistory.setCallDuration(String.valueOf(duration));
        callHistory.setDialNumber(destinationMsisdn);
        CallHistoryDB.addCallHistory(callHistory);
        CallHistoryDB.closeDB();
    }

    private void setMaxDuration(int duration) {
        maxDuration = duration;
    }

    private void beginCallTimer() {
        final long maxDurationInSecs = maxDuration / 1000;
        new CountDownTimer(maxDuration, startDuration) {

            public void onTick(long millisUntilFinished) {
                totalDuration = maxDurationInSecs - (millisUntilFinished / startDuration);
                long timeLeft = (maxDuration / 1000) - totalDuration;
                txtDuration.setText(String.valueOf(totalDuration));
                txtTimeRemaining.setText(String.valueOf(timeLeft));
            }

            public void onFinish() {
                txtDuration.setText(String.valueOf(totalDuration));
                txtTimeRemaining.setText("0");
                  /*  DecimalFormat df = new DecimalFormat("#.00");
                    String duration = totalDuration+ "s";
                    String amountSpent = df.format(totalCallCost)+"Kz";
                    saveCallHistory(destinationMsisdn,amountSpent,duration);*/
                // TODO terminate call
                // TODO end session here
                TeloPaySession teloPaySessionObject = TeloPaySession.getInstance();
                teloPaySessionObject.end(new Callback<ServiceResponse>() {
                    @Override
                    public void onResponse(Call<ServiceResponse> call, Response<ServiceResponse> response) {
                        // TODO handle response here
                    }

                    @Override
                    public void onFailure(Call<ServiceResponse> call, Throwable t) {
                        // TODO handle error here
                    }
                });
                // TODO notify OCS of end session info
            }
        }.start();
    }

}
