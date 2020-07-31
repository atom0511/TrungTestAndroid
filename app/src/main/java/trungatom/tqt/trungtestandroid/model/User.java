package trungatom.tqt.trungtestandroid.model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class User {
    String email, password;
    Boolean rememberMe = false;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[A-Z])" +
                    "(?=.*[a-z])" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\s+$)" +
                    ".{6,}" +
                    "$");

    public User() {
    }

    public User(String email, String password, Boolean rememberMe) {
        this.email = email;
        this.password = password;
        this.rememberMe = rememberMe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public boolean isEmptyEmailValid() {
        String emailInput = getEmail().trim();
        return !TextUtils.isEmpty(emailInput);
    }

    public boolean isEmptyPasswordValid() {
        String passInput = password.trim();
        return !TextUtils.isEmpty(passInput);
    }

    public boolean isPaternEmailValid() {
        String emailInput = email.trim();
        return Patterns.EMAIL_ADDRESS.matcher(emailInput).matches();
    }

    public boolean isPaternPasswordValid() {
        String passInput = password.trim();
        return !PASSWORD_PATTERN.matcher(passInput).matches();
    }
}
