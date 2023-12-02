package com.example.spyridonsaridakiscvapp.ui.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.util.Log;
import android.util.Patterns;
import android.widget.Toast;

import com.example.spyridonsaridakiscvapp.data.LoginRepository;
import com.example.spyridonsaridakiscvapp.data.Result;
import com.example.spyridonsaridakiscvapp.data.model.LoggedInUser;
import com.example.spyridonsaridakiscvapp.R;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    public void login(String username, String password,String company) {
        // can be launched in a separate asynchronous job
        Result<LoggedInUser> result = loginRepository.login(username, password);

        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    public void loginDataChanged(String date, String password,String company) {
        if (!isUserNameValid(date)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_date, null,null));
        }
        if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null,R.string.invalid_phone,null));
        }
        if(!isCompanyValid(company)){
            loginFormState.setValue(new LoginFormState(null,null,R.string.invalid_company));
        }else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        String currentDate = dateFormat.format(new Date());
        if (date.equals("")) {
                return false;
        }else if (date.equals(currentDate.toString())) {
                return true;
        } else {
                return false;
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 10;
    }

    private boolean isCompanyValid(String company){
        if (company.equals("")){
            return false;
        }
        return true;
    }
}