package trungatom.tqt.trungtestandroid.view;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import trungatom.tqt.trungtestandroid.LoginCallBacks;
import trungatom.tqt.trungtestandroid.R;
import trungatom.tqt.trungtestandroid.databinding.ActivityMainBinding;
import trungatom.tqt.trungtestandroid.model.User;
import trungatom.tqt.trungtestandroid.model.share_pref.UserSharePref;
import trungatom.tqt.trungtestandroid.viewmodel.LoginViewModel;
import trungatom.tqt.trungtestandroid.viewmodel.LoginViewModelFactory;

public class MainActivity extends AppCompatActivity implements LoginCallBacks {

    private UserSharePref userSharePref;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userSharePref = new UserSharePref(this);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(ViewModelProviders.of(this,
                new LoginViewModelFactory(this, userSharePref)).get(LoginViewModel.class));
        user = new User();
        user.setEmail(userSharePref.getEmailData());
        user.setPassword(userSharePref.getPasswordData());
        user.setRememberMe(userSharePref.getCheckedData());
        binding.setModel(user);
    }

    @Override
    public void onLoginSuccessful(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPatternEmailValid(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPatternPassValid(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyPassValid(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEmptyEmailValid(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLogoutSuccessful(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
