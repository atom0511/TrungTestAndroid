package trungatom.tqt.trungtestandroid;

public interface LoginCallBacks {
     void onLoginSuccessful(String message);
     void onFailure(String message);
     void onPatternEmailValid(String message);
     void onPatternPassValid(String message);
     void onEmptyPassValid(String message);
     void onEmptyEmailValid(String message);
     void onLogoutSuccessful(String message);
}
