package com.betterbet.betterbet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTextInputLayoutErrorEnabled(false);
        setCancelButtonListneners();
        setCreateAccountButtonListeners();

    }

    private void setTextInputLayoutErrorEnabled(boolean enabled) {
        TextInputLayout username = (TextInputLayout) findViewById(R.id.username);
        username.setErrorEnabled(true);
        TextInputLayout firstName = (TextInputLayout) findViewById(R.id.firstName);
        firstName.setErrorEnabled(true);
        TextInputLayout lastName = (TextInputLayout) findViewById(R.id.lastName);
        lastName.setErrorEnabled(true);
        TextInputLayout phoneNumber = (TextInputLayout) findViewById(R.id.phoneNumber);
        phoneNumber.setErrorEnabled(true);
        TextInputLayout email = (TextInputLayout) findViewById(R.id.email);
        email.setErrorEnabled(true);
        TextInputLayout password = (TextInputLayout) findViewById(R.id.password);
        password.setErrorEnabled(true);
        TextInputLayout confirmPassword = (TextInputLayout) findViewById(R.id.confirmPassword);
        confirmPassword.setErrorEnabled(true);
    }

    private void setCancelButtonListneners() {
        Button cancelBtn = (Button) findViewById(R.id.cancelBtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setCreateAccountButtonListeners() {
        Button createAccountBtn = (Button) findViewById(R.id.createAccountBtn);
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainIntent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(MainIntent);
            }
        });
    }

}
