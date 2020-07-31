package trungatom.tqt.trungtestandroid.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import trungatom.tqt.trungtestandroid.LoginCallBacks;
import trungatom.tqt.trungtestandroid.model.share_pref.UserSharePref;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private LoginCallBacks loginCallBacks;
    private UserSharePref userSharePref;
    public LoginViewModelFactory(LoginCallBacks loginCallBacks, UserSharePref userSharePref) {
        this.loginCallBacks = loginCallBacks;
        this.userSharePref = userSharePref;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(loginCallBacks, userSharePref);
    }
}
