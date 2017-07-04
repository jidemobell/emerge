package telopay.timwe.com.telopay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import telopay.timwe.com.telopay.helpers.APIConnector;
import telopay.timwe.com.telopay.helpers.PayphoneService;
import telopay.timwe.com.telopay.helpers.Util;
import telopay.timwe.com.telopay.request.StartServiceRequest;
import telopay.timwe.com.telopay.response.StartServiceResponse;
import telopay.timwe.com.telopay.util.PrefrenceStorage;

public class EstablishCallActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnProceed;
    private String spendableAmount;
    private PrefrenceStorage prefrenceStorage;
    private EditText txtDialNumber;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_establish_call);
        getSupportActionBar().setTitle(getString(R.string.text_call_establish_screen_header));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        spendableAmount = getIntent().getStringExtra("spendableAmount");
        txtDialNumber = (EditText) findViewById(R.id.txtDialNumber);
        btnProceed = (Button) findViewById(R.id.btnProceedCall);
        btnProceed.setOnClickListener(this);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        prefrenceStorage = new PrefrenceStorage(this);
    }

    private void isLoading(boolean isLoading) {
        btnProceed.setEnabled(!isLoading);
        progressBar.setVisibility(isLoading ? View.VISIBLE : View.INVISIBLE);
    }

    public void startService(String accessToken, String sessionId, String originMSISDN, String destinationMSISDN, final String serviceCredit) {

        StartServiceRequest startServiceRequest = new StartServiceRequest();
        //startServiceRequest.setId("1");
        //startServiceRequest.setPayphoneID("1");
        startServiceRequest.setDestinationMsisdn(destinationMSISDN);
        startServiceRequest.setOriginMsisdn(originMSISDN);
        startServiceRequest.setServiceCredit(serviceCredit);
        PayphoneService payphoneInterface = APIConnector.getRetrofit().create(PayphoneService.class);
        Call<StartServiceResponse> call = payphoneInterface.startService(accessToken,sessionId,startServiceRequest);
        isLoading(true);
        Log.i("AccessToken",accessToken);
        Log.i("Session ID",sessionId);
        Log.i("Request", Util.getRequestString(call.request().body()));
        call.enqueue(new Callback<StartServiceResponse>() {
            @Override
            public void onResponse(Call<StartServiceResponse> call, Response<StartServiceResponse> response) {
                if(response.isSuccessful()) {
                    Log.i("Tarrif",""+response.body().getTariff().getCost());
                    Log.i("Max Duration",""+response.body().getMaxServiceDuration());
                    Log.i("Start Service Success", "Response:" + " " + response.body().getTariff().getCost());
                    Intent callInProgressIntent = new Intent(EstablishCallActivity.this, CallInProgressActivity.class);
                    callInProgressIntent.putExtra("destination_msisdn", txtDialNumber.getText().toString());
                    callInProgressIntent.putExtra("maxDuration",response.body().getMaxServiceDuration());
                    callInProgressIntent.putExtra("tarrif",response.body().getTariff().getCost());
                    callInProgressIntent.putExtra("spendableAmount",serviceCredit);
                    callInProgressIntent.putExtra("serviceID",response.body().getServiceId());
                    startActivity(callInProgressIntent);
                    finish();
                }
                else
                {
                    isLoading(false);
                    Log.e("StartService",response.raw().toString());
                    Toast.makeText(EstablishCallActivity.this,"Service Error,Unable to Start Service",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<StartServiceResponse> call, Throwable t) {
                isLoading(false);
                Toast.makeText(EstablishCallActivity.this,"Service Failure,"+t.getMessage(),Toast.LENGTH_LONG).show();
                Log.e("Start Service Error", t.getMessage());
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
        if (v == btnProceed) {
            if (!txtDialNumber.getText().toString().isEmpty()) {
                startService(prefrenceStorage.getAccessToken(), prefrenceStorage.getSessionID(), "1234567890","+2348034609060", spendableAmount);
            }
        }
    }
}
