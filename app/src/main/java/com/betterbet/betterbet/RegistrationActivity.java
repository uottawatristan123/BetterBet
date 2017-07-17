package com.betterbet.betterbet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);
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
        //username
        final TextInputEditText usernameEdit = (TextInputEditText) findViewById(R.id.usernameEdit);
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
        final TextInputEditText firstNameEdit = (TextInputEditText) findViewById(R.id.firstNameEdit);
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
        final TextInputEditText lastNameEdit = (TextInputEditText) findViewById(R.id.lastNameEdit);
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
        //Email
        final TextInputEditText emailEdit = (TextInputEditText) findViewById(R.id.emailEdit);
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
        final TextInputEditText phoneEdit = (TextInputEditText) findViewById(R.id.phoneNumberEdit);
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
        final TextInputEditText passwordEdit = (TextInputEditText) findViewById(R.id.passwordEdit);
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
        final TextInputEditText cPasswordEdit = (TextInputEditText) findViewById(R.id.confirmPasswordEdit);
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

        //CreateAccountButton
        Button createAccountBtn = (Button) findViewById(R.id.createAccountBtn);
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usernameEdit.getText().toString().isEmpty())
                {
                    username.setError("Username is required");
                }

                if(firstNameEdit.getText().toString().isEmpty())
                {
                    firstName.setError("First Name is required");
                }
                if(lastNameEdit.getText().toString().isEmpty())
                {
                    lastName.setError("Last Name is required");
                }
                if(emailEdit.getText().toString().isEmpty())
                {
                    email.setError("Email is required");
                } else if(!isValidEmail(emailEdit.getText().toString()))
                {
                    email.setError("Invalid Email Format");
                }
                if(phoneEdit.getText().toString().isEmpty())
                {
                    phone.setError("Phone number is required");
                } else if(!isValidPhoneNumber(phoneEdit.getText().toString()))
                {
                    phone.setError("Invalid Phone Number Format");
                }
                if(passwordEdit.getText().toString().isEmpty())
                {
                    password.setError("Password is required");
                }
                if(cPasswordEdit.getText().toString().isEmpty())
                {
                    cPassword.setError("Confirm Password is required");
                }

                if(username.getError()==null && firstName.getError()== null && lastName.getError()==null && email.getError()==null
                        && phone.getError()==null && password.getError()==null && cPassword.getError()==null) {
                    Toast.makeText(RegistrationActivity.this,"Hello "+ firstNameEdit.getText().toString() + ", your account has been created.",Toast.LENGTH_LONG).show();

                    Intent WelcomeIntent = new Intent(RegistrationActivity.this, WelcomeActivity.class);
                    startActivity(WelcomeIntent);
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
