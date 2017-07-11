package com.betterbet.betterbet;

import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_READ_CONTACTS = 0;

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    private EditText mPasswordView, mUserName;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTextInputLayoutErrorEnabled(false);

        // declaring obejct of EditText control
        mUserName = (EditText) findViewById(R.id.email_loginEdit);
        mPasswordView = (EditText) findViewById(R.id.password_loginEdit);

        final TextView txtSignUp = (TextView) findViewById(R.id.signUp);

        txtSignUp.setOnTouchListener(new View.OnTouchListener() {
            private static final int MAX_CLICK_DURATION = 200;
            private long startClickTime;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                    if(clickDuration < MAX_CLICK_DURATION) {
                        Intent RegistrationIntent = new Intent(LoginActivity.this, RegistrationActivity.class);
                        startActivity(RegistrationIntent);
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

        setCreateAccountButtonListeners();
    }

    private void setTextInputLayoutErrorEnabled(boolean enabled) {
        TextInputLayout email = (TextInputLayout) findViewById(R.id.email_login);
        email.setErrorEnabled(true);
        TextInputLayout password = (TextInputLayout) findViewById(R.id.password_login);
        password.setErrorEnabled(true);
    }

    private void setCreateAccountButtonListeners() {

        //Email
        final EditText email_loginEdit = (EditText) findViewById(R.id.email_loginEdit);
        final TextInputLayout email_login = (TextInputLayout) findViewById(R.id.email_login);
        email_loginEdit.addTextChangedListener(new TextWatcher() {
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
                    email_login.setError("Email is required");
                } else if (!isValidEmail(s.toString())) {
                    email_login.setError("Invalid Email Format");
                } else {
                    email_login.setError(null);
                }
            }
        });

        //password
        final EditText password_loginEdit = (EditText) findViewById(R.id.password_loginEdit);
        final TextInputLayout password_login = (TextInputLayout) findViewById(R.id.password_login);
        password_loginEdit.addTextChangedListener(new TextWatcher() {
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
                    password_login.setError("Password is required");
                } else {
                    password_login.setError(null);
                }
            }
        });


        //CreateAccountButton
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email_loginEdit.getText().toString().isEmpty())
                {
                    email_login.setError("Email is required");
                } else if(!isValidEmail(email_loginEdit.getText().toString()))
                {
                    email_login.setError("Invalid Email Format");
                }
                if(password_loginEdit.getText().toString().isEmpty())
                {
                    password_login.setError("Password is required");
                }
                if(email_login.getError()==null && password_login.getError()==null) {
                    String UserName = mUserName.getText().toString();
                    String Pwd = mPasswordView.getText().toString();
                    if(UserName.equalsIgnoreCase("Suraj@gmail.com") && Pwd.equals("Suraj@123")){
                        Intent MainIntent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(MainIntent);
                    }else
                    {
                        Toast.makeText(LoginActivity.this,"Sorry, Email/User Name or Password is incorrect.", Toast.LENGTH_LONG).show();
                    };
                }
            }
        });
    }

    private boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}