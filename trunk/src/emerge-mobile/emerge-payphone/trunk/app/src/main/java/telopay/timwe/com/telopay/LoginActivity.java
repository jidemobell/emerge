package telopay.timwe.com.telopay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import telopay.timwe.com.telopay.helpers.APIConnector;
import telopay.timwe.com.telopay.helpers.PayphoneService;
import telopay.timwe.com.telopay.model.Application;
import telopay.timwe.com.telopay.model.ConfigData;
import telopay.timwe.com.telopay.model.Equipment;
import telopay.timwe.com.telopay.model.LocationInformation;
import telopay.timwe.com.telopay.model.PayPhone;
import telopay.timwe.com.telopay.model.PayphoneCredential;
import telopay.timwe.com.telopay.model.SIM;
import telopay.timwe.com.telopay.model.Status;
import telopay.timwe.com.telopay.model.Version;
import telopay.timwe.com.telopay.persistence.SessionResponseDB;
import telopay.timwe.com.telopay.request.AuthenticationRequest;
import telopay.timwe.com.telopay.response.SessionResponse;
import telopay.timwe.com.telopay.util.PrefrenceStorage;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnLogin;
    private EditText textUsername, textPassword;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        textUsername = (EditText) findViewById(R.id.textUsername);
        textPassword = (EditText) findViewById(R.id.textPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnLogin.setOnClickListener(this);

    }

    private void isLoading(boolean isLoading) {
        textPassword.setEnabled(!isLoading);
        textUsername.setEnabled(!isLoading);
        btnLogin.setEnabled(!isLoading);
        progressBar.setVisibility(isLoading ? View.VISIBLE : View.INVISIBLE);
    }

    private void authenticate(String userName, String password) {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        PayPhone payPhone = new PayPhone();
        payPhone.setPayphoneID("1");
        payPhone.setAccountID("2002");
        payPhone.setCustomerID("1002");
        payPhone.setCreationDate("1474969033364");
        payPhone.setBalance(223.98);
        payPhone.setModificationDate("1474969033364");

        PayphoneCredential credential = new PayphoneCredential();
        credential.setUsername(userName);
        credential.setPassword(password);
        payPhone.setCredentials(credential);

        ConfigData configData = new ConfigData();
        configData.setPreferredMSISDN("212235465576");
        configData.setKeepAliveInterval(44);
        configData.setSendErrorsToOCS(3);
        configData.setSilenceMode(true);
        configData.setCreditButtons(new String[]{});
        payPhone.setConfigData(configData);

        Equipment equipment = new Equipment();
        equipment.setImei1("d382dn238d923d");
        equipment.setImei2("3453545678674545");
        equipment.setMac("wufjedwusfbdufjas");
        equipment.setSerialNr("edguejwhduewf");
        payPhone.setEquipment(equipment);

        SIM sim1 = new SIM();
        sim1.setIccid("asjshd3uqw");
        sim1.setImsi("121224334341");
        sim1.setMsisdn("1234567890");
        payPhone.setSim1(sim1);

        SIM sim2 = new SIM();
        sim2.setImsi("1212243343");
        sim2.setIccid("asjkhk832ej2i");
        sim2.setMsisdn("329329847935");
        payPhone.setSim2(sim2);

        Application application = new Application();
        application.setName("Andriod SDK");

        Version version = new Version();
        version.setMajor(0);
        version.setMinor(1);
        version.setPatch(3);
        version.setStatus("ALLOWED");

        application.setVersion(version);
        payPhone.setApplication(application);

        Status status = new Status();
        status.setStatus("INACTIVE");
        status.setStatusDate("1474969033364");
        payPhone.setStatus(status);

        LocationInformation locationInformation = new LocationInformation();
        locationInformation.setGpsLat(0);
        locationInformation.setGpsLong(0);
        locationInformation.setGsmCellId("wdewwe");
        locationInformation.setGsmLocationAreaCode("34638232");
        authenticationRequest.setLocationInformation(locationInformation);
        authenticationRequest.setPayPhone(payPhone);
        PayphoneService payphoneInterface = APIConnector.getRetrofit().create(PayphoneService.class);
        Call<SessionResponse> call = payphoneInterface.authenticate("test", authenticationRequest);
        //Log.i("BODY", Util.getRequestString(call.request().body()));
        isLoading(true);
        call.enqueue(new Callback<SessionResponse>() {
            @Override
            public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    //APIConnector.accessToken = response.headers().get("accessToken");
                    Log.d("hreader token", response.headers().toString());
                    Log.i("Success", "Access Token:" + " " + response.body().getAccessToken());
                    PrefrenceStorage prefrenceStorage = new PrefrenceStorage(getApplicationContext());
                    prefrenceStorage.saveAccessToken(response.body().getAccessToken());
                    prefrenceStorage.saveSessionID(response.body().getSessionID());
                    SessionResponseDB.openSessionResponseDB(getApplicationContext());
                    SessionResponseDB.saveSessionResponse(response.body());
                    SessionResponseDB.closeSessionResponseDB();
                    Log.i("AccessToken","Token Saved in Preference Storage");
                    Intent securityPromptIntent = new Intent(LoginActivity.this, SecurityPinActivity.class);
                    startActivity(securityPromptIntent);
                    finish();
                } else {
                    Log.e("failed", "Request Failed...." + response.raw().toString());
                    Toast.makeText(getApplicationContext(), "Error:" + "Authentication Failed", Toast.LENGTH_SHORT).show();
                    isLoading(false);
                }
            }

            @Override
            public void onFailure(Call<SessionResponse> call, Throwable t) {
                isLoading(false);
                Toast.makeText(getApplicationContext(),
                        (t.getMessage() != null ? t.getMessage() :
                                "Error occurred completing request"), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v == btnLogin) {
            /*Intent securityPromptIntent = new Intent(LoginActivity.this,SecurityPinActivity.class);
            startActivity(securityPromptIntent);
            finish();*/
            authenticate(textUsername.getText().toString(), textPassword.getText().toString());

        }
    }
}
