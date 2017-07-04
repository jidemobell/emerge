package telopay.timwe.com.telopay;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecurityPinActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnProceed;
    private int nextScreen;
    private String spendableAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(getString(R.string.text_security_screen_title));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setContentView(R.layout.activity_security_pin);
        nextScreen = getIntent().getIntExtra("nextScreen",1);
        spendableAmount = getIntent().getStringExtra("spendableAmount");
        btnProceed = (Button) findViewById(R.id.btnProceed);
        btnProceed.setOnClickListener(this);
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
       if(v == btnProceed){
           switch (nextScreen){
               case 1:
                   Intent homeIntent = new Intent(this,HomeActivity.class);
                   startActivity(homeIntent);
                   finish();
                   break;

               case 2:

                   Intent establishCallIntent = new Intent(this,EstablishCallActivity.class);
                   establishCallIntent.putExtra("spendableAmount",spendableAmount);
                   startActivity(establishCallIntent);
                   finish();
                   break;
           }

       }
    }



    /*final PinEntryEditText pinEntry = (PinEntryEditText) findViewById(R.id.txt_pin_entry);
    if (pinEntry != null) {
        pinEntry.setOnPinEnteredListener(new PinEntryEditText.OnPinEnteredListener() {
            @Override
            public void onPinEntered(CharSequence str) {
                if (str.toString().equals("1234")) {
                    Toast.makeText(AnimatedEditTextWidgetsActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AnimatedEditTextWidgetsActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
                    pinEntry.setText(null);
                }
            }
        });
    }*/
}
