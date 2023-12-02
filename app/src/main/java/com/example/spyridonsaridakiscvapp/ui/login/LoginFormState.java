package com.example.spyridonsaridakiscvapp.ui.login;

import androidx.annotation.Nullable;

/**
 * Data validation state of the login form.
 */
class LoginFormState {
    @Nullable
    private Integer usernameError;
    @Nullable
    private Integer passwordError;

    @Nullable
    private Integer companyError;

    private boolean isDataValid;

    LoginFormState(@Nullable Integer usernameError, @Nullable Integer passwordError,@Nullable Integer companyError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.companyError = companyError;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid) {
        this.usernameError = null;
        this.passwordError = null;
        this.companyError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    Integer getUsernameError() {
        return usernameError;
    }

    @Nullable
    Integer getPasswordError() {
        return passwordError;
    }

    @Nullable
    Integer getCompanyError(){return companyError;}

    boolean isDataValid() {
        return isDataValid;
    }
}