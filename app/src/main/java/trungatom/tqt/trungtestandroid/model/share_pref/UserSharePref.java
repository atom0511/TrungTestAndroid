package trungatom.tqt.trungtestandroid.model.share_pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import trungatom.tqt.trungtestandroid.model.User;

public class UserSharePref {
    private SharedPreferences sharedPreferences;
    private User user;
    private static final String KEY_EMAIL = "keyEmail";
    private static final String KEY_PASSWORD = "keyPassword";
    private static final String KEY_CHECKED = "keyChecked";

    public UserSharePref(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        user = new User();
    }

    public void saveEmailData(String email) {
        sharedPreferences.edit().putString(KEY_EMAIL, email).apply();
    }

    public void savePasswordData(String password) {
        sharedPreferences.edit().putString(KEY_PASSWORD, password).apply();
    }

    public void saveCheckedData(Boolean checked) {
        sharedPreferences.edit().putBoolean(KEY_CHECKED, checked).apply();
    }

    public String getEmailData() {
        return sharedPreferences.getString(KEY_EMAIL, "");
    }

    public String getPasswordData() {
        return sharedPreferences.getString(KEY_PASSWORD, "");
    }

    public Boolean getCheckedData() {
        return sharedPreferences.getBoolean(KEY_CHECKED, false);
    }
}
