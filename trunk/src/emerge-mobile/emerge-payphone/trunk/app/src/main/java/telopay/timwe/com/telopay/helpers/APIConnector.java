package telopay.timwe.com.telopay.helpers;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import telopay.timwe.com.telopay.model.Application;
import telopay.timwe.com.telopay.model.ConfigData;
import telopay.timwe.com.telopay.model.Equipment;
import telopay.timwe.com.telopay.model.LocationInformation;
import telopay.timwe.com.telopay.model.PayPhone;
import telopay.timwe.com.telopay.model.PayphoneCredential;
import telopay.timwe.com.telopay.model.SIM;
import telopay.timwe.com.telopay.model.Status;
import telopay.timwe.com.telopay.model.Version;
import telopay.timwe.com.telopay.request.AuthenticationRequest;
import telopay.timwe.com.telopay.request.StartServiceRequest;
import telopay.timwe.com.telopay.response.ServiceResponse;
import telopay.timwe.com.telopay.response.SessionResponse;
import telopay.timwe.com.telopay.response.StartServiceResponse;

/**
 * Created by timwe.tunji on 10/11/2016.
 */
public class APIConnector {

    //private static final String API_URL = "http://192.168.0.6:8080/";
    private static final String API_URL = "https://emerge-dev.timwe.com/";

    //public static String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3RpbXdlLmVtZXJnZS5jb20vIiwicGF5cGhvbmUiOnsidXNlcm5hbWUiOiJ3ZWNraW5nIiwicGFzc3dvcmQiOiJraW5nIn0sImV4cCI6MTQ3ODE3NDUsImlhdCI6MTQ3ODE3MDV9.lsbThJyc2n1OBLGIJ04Th9o4iYRIlSfjAaL30Vo-2H4";

    //private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    @NonNull
    public static Retrofit getRetrofit() {
    /*    httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("accessToken", accessToken)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();*/
        return new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_URL)
                //.client(client)
                .build();
    }

    public void resumeSession(String sessionId, String accessToken) {
        accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL3RpbXdlLmVtZXJnZS5jb20vIiwicGF5cGhvbmUiOnsidXNlcm5hbWUiOiJ3ZWNraW5nIiwicGFzc3dvcmQiOiJraW5nIn0sImV4cCI6MTQ3ODE3NDUsImlhdCI6MTQ3ODE3MDV9.lsbThJyc2n1OBLGIJ04Th9o4iYRIlSfjAaL30Vo-2H4";
        sessionId = "1";
        PayphoneService payphoneInterface = APIConnector.getRetrofit().create(PayphoneService.class);
        Call<ServiceResponse> call = payphoneInterface.resumeSession(accessToken, sessionId);
        call.enqueue(new Callback<ServiceResponse>() {
            @Override
            public void onResponse(Call<ServiceResponse> call, Response<ServiceResponse> response) {
                Log.i("TelopaySession", response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ServiceResponse> call, Throwable t) {
                Log.e("TelopaySession", t.getMessage());
            }
        });
    }




    private void startSession(String userName, String password) throws Exception {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        PayPhone payPhone = new PayPhone();
        payPhone.setPayphoneID("4");
        payPhone.setAccountID("23372334edew");
        payPhone.setCustomerID("Johnson");
        payPhone.setCreationDate("1474969033364");
        payPhone.setBalance(12.12);
        payPhone.setModificationDate("1474969033364");

        PayphoneCredential credential = new PayphoneCredential();
        credential.setUsername("wecking");
        credential.setPassword("king");
        payPhone.setCredentials(credential);

        ConfigData configData = new ConfigData();
        configData.setPreferredMSISDN("212235465576");
        configData.setKeepAliveInterval(44);
        configData.setSendErrorsToOCS(3);
        configData.setSilenceMode(true);
        configData.setCreditButtons(new String[]{});
        payPhone.setConfigData(configData);

        Equipment equipment = new Equipment();
        equipment.setImei1("123244");
        equipment.setImei2("3453545678674545");
        equipment.setMac("qwe21qwed243535qqqw");
        equipment.setSerialNr("qw2ew3dewe");
        payPhone.setEquipment(equipment);

        SIM sim1 = new SIM();
        sim1.setIccid("asjshd3uqwabe2");
        sim1.setImsi("121224334341123244");
        sim1.setMsisdn("0377462842");
        payPhone.setSim1(sim1);

        SIM sim2 = new SIM();
        sim2.setImsi("121224334341123244");
        sim2.setIccid("asjkhk832ej2iweh8912q3");
        sim2.setMsisdn("3293298479357832");
        payPhone.setSim2(sim2);

        Application application = new Application();
        application.setName("Andriod SDK");

        Version version = new Version();
        version.setMajor(5);
        version.setMinor(5);
        version.setPatch(8);
        version.setStatus("ALLOWED");

        application.setVersion(version);
        payPhone.setApplication(application);

        Status status = new Status();
        status.setStatus("ACTIVE");
        status.setStatusDate("1474969033364");
        payPhone.setStatus(status);

        LocationInformation locationInformation = new LocationInformation();
        locationInformation.setGpsLat(235445);
        locationInformation.setGpsLong(3455675);
        locationInformation.setGsmCellId("wdewwe");
        locationInformation.setGsmLocationAreaCode("34638232");
        authenticationRequest.setLocationInformation(locationInformation);
        authenticationRequest.setPayPhone(payPhone);
        PayphoneService payphoneInterface = APIConnector.getRetrofit().create(PayphoneService.class);
        Call<SessionResponse> call = payphoneInterface.authenticate("test", authenticationRequest);
        // Log.i("BODY", Util.getRequestString(call.request().body()));
        call.enqueue(new Callback<SessionResponse>() {
            @Override
            public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
                if (response.isSuccessful()) {
                    Log.i("Success", "Access Token:" + " " + response.body().getAccessToken());
                  /*  Toast.makeText(getApplicationContext(),"Token:"+response.body().getAccessToken(),Toast.LENGTH_SHORT).show();
                    Intent securityPromptIntent = new Intent(LoginActivity.this,SecurityPinActivity.class);
                    startActivity(securityPromptIntent);
                    finish();*/
                } else {
                    Log.e("failed", "Request Failed...." + response.raw().toString());
                    // Toast.makeText(getApplicationContext(),"Error:"+"Authentication Failed",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SessionResponse> call, Throwable t) {
                Log.d("Error", t.toString());
            }
        });
    }



}
