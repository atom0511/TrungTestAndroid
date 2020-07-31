package trungatom.tqt.trungtestandroid.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;

import androidx.lifecycle.ViewModel;

import trungatom.tqt.trungtestandroid.LoginCallBacks;
import trungatom.tqt.trungtestandroid.model.User;
import trungatom.tqt.trungtestandroid.model.share_pref.UserSharePref;

public class LoginViewModel extends ViewModel {
    private static final String TAG = "tttt";
    private User user;
    private LoginCallBacks loginCallBacks;
    private UserSharePref userSharePref;
    private Boolean flag = true;

    public LoginViewModel() {
    }

    public LoginViewModel(LoginCallBacks loginCallBacks, UserSharePref userSharePref) {
        this.loginCallBacks = loginCallBacks;
        this.user = new User();
        this.userSharePref = userSharePref;
    }

    public User getmUser() {
        return user;
    }

    public void setmUser(User mUser) {
        this.user = mUser;
    }

    public LoginCallBacks getLoginCallBacks() {
        return loginCallBacks;
    }

    public void setLoginCallBacks(LoginCallBacks loginCallBacks) {
        this.loginCallBacks = loginCallBacks;
    }

    String strEmail;

    public TextWatcher emailTextWatcher() {
        user.setEmail(userSharePref.getEmailData());
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                strEmail = s.toString();
                user.setEmail(s.toString());
                userSharePref.saveEmailData(s.toString());
                if (userSharePref.getCheckedData() == false) {
                    userSharePref.saveEmailData("");
                }
            }
        };
    }

    String strPass;
    int count = 0;

    public TextWatcher passwordTextWatcher() {
        if (count == 0) {
            user.setPassword(userSharePref.getPasswordData());
            count = 1;
        }
        user.setRememberMe(userSharePref.getCheckedData());
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                strPass = s.toString();
                user.setPassword(s.toString());
                userSharePref.savePasswordData(s.toString());
                if (userSharePref.getCheckedData() == false) {
                    userSharePref.savePasswordData("");
                }
            }
        };
    }

    public void onCheckBoxClickedClick() {
        passwordTextWatcher();
        if (user.getRememberMe() == false) {
            user.setRememberMe(true);
            userSharePref.savePasswordData(strPass);
            userSharePref.saveEmailData(strEmail);
        } else {
            user.setRememberMe(false);
            userSharePref.savePasswordData("");
            userSharePref.saveEmailData("");
        }
        userSharePref.saveCheckedData(user.getRememberMe());
    }

    public void onLoginButtonClick() {
        if (!user.isEmptyEmailValid()) {
            loginCallBacks.onEmptyEmailValid("Email field can't be empty");
        } else if (!user.isEmptyPasswordValid()) {
            loginCallBacks.onEmptyPassValid("Password field can't be empty");
        } else if (!user.isPaternEmailValid()) {
            loginCallBacks.onPatternEmailValid("Please enter a valid email adress");
        } else if (!user.isPaternPasswordValid()) {
            loginCallBacks.onPatternPassValid("Password too weak");
        } else {
            loginCallBacks.onLoginSuccessful("Login Successful");
        }
    }

    public void onLogoutButtonClick() {
        loginCallBacks.onLogoutSuccessful("Logout Successful");
    }
}
