package com.betterbet.betterbet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import static java.lang.Double.parseDouble;

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
        setTextInputLayoutsTextChangedListeners();

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

    private void setTextInputLayoutsTextChangedListeners() {
        //username
        TextInputEditText usernameEdit = (TextInputEditText) findViewById(R.id.usernameEdit);
        final TextInputLayout username = (TextInputLayout) findViewById(R.id.username);
        usernameEdit.addTextChangedListener(new TextWatcher() {
           //Do not delete causes error (required)
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
           //Do not delete causes error (required)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().isEmpty()) {
                    username.setError("Username is required");
                }  else {
                    username.setError(null);
                }
            }
        });
        //First Name
        TextInputEditText firstNameEdit = (TextInputEditText) findViewById(R.id.firstNameEdit);
        final TextInputLayout firstName = (TextInputLayout) findViewById(R.id.firstName);
        firstNameEdit.addTextChangedListener(new TextWatcher() {
            //Do not delete causes error (required)
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //Do not delete causes error (required)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().isEmpty()) {
                    firstName.setError("First Name is required");
                }  else {
                    firstName.setError(null);
                }
            }
        });
        //Last Name
        TextInputEditText lastNameEdit = (TextInputEditText) findViewById(R.id.lastNameEdit);
        final TextInputLayout lastName = (TextInputLayout) findViewById(R.id.lastName);
        lastNameEdit.addTextChangedListener(new TextWatcher() {
            //Do not delete causes error (required)
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //Do not delete causes error (required)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().isEmpty()) {
                    lastName.setError("Last Name is required");
                }  else {
                    lastName.setError(null);
                }
            }
        });
        //Phone Number
        TextInputEditText phoneNumberEdit = (TextInputEditText) findViewById(R.id.phoneNumberEdit);
        final TextInputLayout phoneNumber = (TextInputLayout) findViewById(R.id.phoneNumber);
        lastNameEdit.addTextChangedListener(new TextWatcher() {
            //Do not delete causes error (required)
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //Do not delete causes error (required)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().isEmpty()) {
                    phoneNumber.setError("Phone Number is required");
                }  else {
                    phoneNumber.setError(null);
                }
            }
        });
        //Email
        TextInputEditText emailEdit = (TextInputEditText) findViewById(R.id.emailEdit);
        final TextInputLayout email = (TextInputLayout) findViewById(R.id.email);
        emailEdit.addTextChangedListener(new TextWatcher() {
            //Do not delete causes error (required)
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //Do not delete causes error (required)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().isEmpty()) {
                    email.setError("Email is required");
                } else if (!isValidEmail(s.toString())) {
                    email.setError("Invalid Email Format");
                } else {
                    email.setError(null);
                }
            }
        });


        //PhoneNumber
        TextInputEditText phoneEdit = (TextInputEditText) findViewById(R.id.phoneNumberEdit);
        final TextInputLayout phone = (TextInputLayout) findViewById(R.id.phoneNumber);
        phoneEdit.addTextChangedListener(new TextWatcher() {
            //Do not delete causes error (required)
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //Do not delete causes error (required)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().isEmpty()) {
                    phone.setError("Phone Number is required");
                } else if (!isValidPhoneNumber(s.toString())) {
                    phone.setError("Invalid Phone Number Format");
                } else {
                    phone.setError(null);
                }
            }
        });

        //password
        TextInputEditText passwordEdit = (TextInputEditText) findViewById(R.id.passwordEdit);
        final TextInputLayout password = (TextInputLayout) findViewById(R.id.password);
        passwordEdit.addTextChangedListener(new TextWatcher() {
            //Do not delete causes error (required)
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //Do not delete causes error (required)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().isEmpty()) {
                    password.setError("Password is required");
                } else {
                    password.setError(null);
                }
            }
        });

        //Confirm password
        TextInputEditText cPasswordEdit = (TextInputEditText) findViewById(R.id.confirmPasswordEdit);
        final TextInputLayout cPassword = (TextInputLayout) findViewById(R.id.confirmPassword);
        cPasswordEdit.addTextChangedListener(new TextWatcher() {
            //Do not delete causes error (required)
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //Do not delete causes error (required)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().isEmpty()) {
                    cPassword.setError("Confirm Password is required");
                } else {
                    cPassword.setError(null);
                }
            }
        });
    }

    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    private boolean isValidPhoneNumber(CharSequence target) {
        return !TextUtils.isEmpty(target) && Patterns.PHONE.matcher(target).matches();
    }

}
