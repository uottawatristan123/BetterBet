package com.betterbet.betterbet;

import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        Button createAccountBtn = (Button) findViewById(R.id.addCreditCard);
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent CreditCardWelcomeIntent = new Intent(WelcomeActivity.this, CreditCardWelcomeActivity.class);
                startActivity(CreditCardWelcomeIntent);
            }
        });

        final TextView txtSignUp = (TextView) findViewById(R.id.notNow);

        txtSignUp.setOnTouchListener(new View.OnTouchListener() {
            private static final int MAX_CLICK_DURATION = 200;
            private long startClickTime;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                    if(clickDuration < MAX_CLICK_DURATION) {
                        Intent MainIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                        startActivity(MainIntent);
                    }
                    txtSignUp.setTextColor(Color.argb(100, 255, 0, 0));
                    return true;
                } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    startClickTime = Calendar.getInstance().getTimeInMillis();
                    txtSignUp.setTextColor(Color.argb(50, 255, 0, 0));
                    return true;
                }
                return false;
            }
        });
    }
}
