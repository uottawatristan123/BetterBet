package com.betterbet.betterbet;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.braintreepayments.cardform.utils.CardType;
import com.braintreepayments.cardform.view.CardForm;
import com.braintreepayments.cardform.view.SupportedCardTypesView;

public class CreditCardWelcomeActivity extends AppCompatActivity {

    private static final CardType[] SUPPORTED_CARD_TYPES = { CardType.VISA, CardType.MASTERCARD, CardType.AMEX };

    private SupportedCardTypesView mSupportedCardTypesView;

    protected CardForm mCardForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_welcome);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_white_24dp);


        mSupportedCardTypesView = (SupportedCardTypesView) findViewById(R.id.supported_card_types);
        mSupportedCardTypesView.setSupportedCardTypes(SUPPORTED_CARD_TYPES);

        CardForm cardForm = (CardForm) findViewById(R.id.card_form);
        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .actionLabel("Purchase")
                .setup(this);

        setTextInputLayoutErrorEnabled(true);
        setCancelButtonListneners();
        setCreateAccountButtonListeners();
    }

    private void setTextInputLayoutErrorEnabled(boolean enabled) {
        TextInputLayout firstName = (TextInputLayout) findViewById(R.id.firstName_tl);
        firstName.setErrorEnabled(true);
        TextInputLayout lastName = (TextInputLayout) findViewById(R.id.lastname_tl);
        lastName.setErrorEnabled(true);
        TextInputLayout phoneNumber = (TextInputLayout) findViewById(R.id.aptsuite_tl);
        phoneNumber.setErrorEnabled(true);
        TextInputLayout email = (TextInputLayout) findViewById(R.id.address_tl);
        email.setErrorEnabled(true);
        TextInputLayout password = (TextInputLayout) findViewById(R.id.city_tl);
        password.setErrorEnabled(true);
        TextInputLayout confirmPassword = (TextInputLayout) findViewById(R.id.postalcode_tl);
        confirmPassword.setErrorEnabled(true);
    }

    private void setCancelButtonListneners() {
        Button cancelBtn = (Button) findViewById(R.id.cancelCreditCard);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setCreateAccountButtonListeners() {
        //First Name
        final EditText firstNameEdit = (EditText) findViewById(R.id.firstname_e);
        final TextInputLayout firstName = (TextInputLayout) findViewById(R.id.firstName_tl);
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
        final EditText lastNameEdit = (EditText) findViewById(R.id.lastname_e);
        final TextInputLayout lastName = (TextInputLayout) findViewById(R.id.lastname_tl);
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


        //Address
        final EditText phoneEdit = (EditText) findViewById(R.id.address);
        final TextInputLayout phone = (TextInputLayout) findViewById(R.id.address_tl);
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
                    phone.setError("Address is required");
                }  else {
                    phone.setError(null);
                }
            }
        });

        //city
        final EditText passwordEdit = (EditText) findViewById(R.id.city);
        final TextInputLayout password = (TextInputLayout) findViewById(R.id.city_tl);
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
                    password.setError("City is required");
                } else {
                    password.setError(null);
                }
            }
        });

        //Postal Code
        final EditText cPasswordEdit = (EditText) findViewById(R.id.postalcode);
        final TextInputLayout cPassword = (TextInputLayout) findViewById(R.id.postalcode_tl);
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
                    cPassword.setError("Postal Code is required");
                } else {
                    cPassword.setError(null);
                }
            }
        });

        //submitCreditCard
        Button createAccountBtn = (Button) findViewById(R.id.submitCreditCard);
        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstNameEdit.getText().toString().isEmpty())
                {
                    firstName.setError("First Name is required");
                }
                if(lastNameEdit.getText().toString().isEmpty())
                {
                    lastName.setError("Last Name is required");
                }
                if(phoneEdit.getText().toString().isEmpty())
                {
                    phone.setError("Address is required");
                }
                if(passwordEdit.getText().toString().isEmpty())
                {
                    password.setError("City is required");
                }
                if(cPasswordEdit.getText().toString().isEmpty())
                {
                    cPassword.setError("Postal Code is required");
                }

                if(firstName.getError()== null && lastName.getError()==null
                        && phone.getError()==null && password.getError()==null && cPassword.getError()==null) {
                    Intent MainIntent = new Intent(CreditCardWelcomeActivity.this, MainActivity.class);
                    startActivity(MainIntent);
                }
            }
        });
    }
}
