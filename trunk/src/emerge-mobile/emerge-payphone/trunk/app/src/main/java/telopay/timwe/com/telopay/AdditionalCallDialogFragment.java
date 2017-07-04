package telopay.timwe.com.telopay;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import telopay.timwe.com.telopay.model.TeloPaySession;
import telopay.timwe.com.telopay.response.ServiceResponse;

/**
 * Created by kamiye on 27/10/2016.
 */

public class AdditionalCallDialogFragment extends DialogFragment {

    private static final String TIME_LEFT = "input_fragment";

    public static AdditionalCallDialogFragment getInstance(String secsLeft) {
        AdditionalCallDialogFragment dialogFragment = new AdditionalCallDialogFragment();

        Bundle bundle = new Bundle();
        bundle.putString(TIME_LEFT, secsLeft);
        dialogFragment.setArguments(bundle);
        return dialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String timeLeft = getArguments().getString(TIME_LEFT);
        String message = getString(R.string.text_make_another_call_prompt, timeLeft);
        builder.setMessage(message)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dismiss();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // TODO notify end of session here
                        notifyEndOfSession();
                        launchPayphoneActivity();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    private void notifyEndOfSession() {
        TeloPaySession sessionObject = TeloPaySession.getInstance();
        sessionObject.end(new Callback<ServiceResponse>() {
            @Override
            public void onResponse(Call<ServiceResponse> call, Response<ServiceResponse> response) {
                // TODO handle response here
            }

            @Override
            public void onFailure(Call<ServiceResponse> call, Throwable t) {
                // TODO handle response here
            }
        });
    }

    private void launchPayphoneActivity() {
        Intent intent = new Intent (getContext(), PayphoneActivity.class);
        startActivity(intent);
    }
}
