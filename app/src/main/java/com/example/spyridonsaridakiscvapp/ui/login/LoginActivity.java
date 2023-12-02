package com.example.spyridonsaridakiscvapp.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spyridonsaridakiscvapp.MainActivity;
import com.example.spyridonsaridakiscvapp.R;
import com.example.spyridonsaridakiscvapp.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText dateEditText = binding.etDate;
        final EditText phoneEditText = binding.etPhone;
        final EditText companyEditText = binding.etCompany;
        final Button loginButton = binding.login;
        final ProgressBar loadingProgressBar = binding.loading;

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                if(loginFormState.isDataValid()){
                    loginButton.setEnabled(true);
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    dateEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    phoneEditText.setError(getString(loginFormState.getPasswordError()));
                }
                if(loginFormState.getCompanyError()!=null){
                    companyEditText.setError(getString(loginFormState.getCompanyError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    goToMain();
                }
                setResult(Activity.RESULT_OK);
                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(dateEditText.getText().toString(),
                        phoneEditText.getText().toString(),companyEditText.getText().toString());
            }
        };
        dateEditText.addTextChangedListener(afterTextChangedListener);
        phoneEditText.addTextChangedListener(afterTextChangedListener);
        companyEditText.addTextChangedListener(afterTextChangedListener);

        phoneEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(dateEditText.getText().toString(),
                            phoneEditText.getText().toString(),companyEditText.getText().toString());
                }
                return false;
            }
        });

        companyEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(dateEditText.getText().toString(),
                            phoneEditText.getText().toString(),companyEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(dateEditText.getText().toString(),
                        phoneEditText.getText().toString(),companyEditText.getText().toString());
            }
        });
    }

    private void goToMain() {
        Intent in = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        EditText etEmail = findViewById(R.id.etDate);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etCompany = findViewById(R.id.etCompany);
        String date = etEmail.getText().toString();
        String phone = etPhone.getText().toString();
        String company = etCompany.getText().toString();
        bundle.putString("DATE_KEY", date);
        bundle.putString("PHONE_KEY", phone);
        bundle.putString("COMPANY_KEY", company);
        in.putExtras(bundle);
        startActivity(in);
    }


    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}