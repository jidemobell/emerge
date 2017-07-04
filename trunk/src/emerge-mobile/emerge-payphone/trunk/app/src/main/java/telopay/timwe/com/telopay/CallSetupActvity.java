package telopay.timwe.com.telopay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CallSetupActvity extends AppCompatActivity implements View.OnClickListener {

    private Button btnProceedCall;
    private EditText editTextSpendableAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_setup_actvity);
        getSupportActionBar().setTitle(getString(R.string.text_call_setup_screen_header));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        btnProceedCall = (Button) findViewById(R.id.btnProceedCall);
        btnProceedCall.setOnClickListener(this);
        editTextSpendableAmount = (EditText) findViewById(R.id.editTextSpendableAmount);
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
        if (v == btnProceedCall) {
            if(!editTextSpendableAmount.getText().toString().equals("")) {
                Intent securityScreenIntent = new Intent(this, SecurityPinActivity.class);
                securityScreenIntent.putExtra("nextScreen", 2);
                securityScreenIntent.putExtra("spendableAmount",editTextSpendableAmount.getText().toString());
                startActivity(securityScreenIntent);
                finish();
            }
            else{
                Toast.makeText(this,"Enter Spendable Amount",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
