package com.example.once2.Presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;

import com.example.once2.Model.Json.LoginJson;
import com.example.once2.Model.LoginModel;
import com.example.once2.View.ILoginActivity;
public class LoginPresenter implements LoginPresenter1
{
    private ILoginActivity loginView;
    private LoginModel loginModel;
    private String username;
    private String password;
    private MyHandler handler=new MyHandler();
    public LoginPresenter(ILoginActivity view) {
        this.loginView = view;
        this.loginModel = new LoginModel(loginView.MYgetCOntext()); // 可以通过依赖注入解耦
    }
    @Override
    public void returnData(LoginJson loginJson) {
        loginView.showLoading();
    if(loginJson.errorCode==0) {
        loginView.showLoginSuccess();
        loginView.startHomeActivity();
     }
    else {
        loginView.showLoginError(loginJson.errorMsg);
        loginView.hideLoading();
    }
    }
    @Override
    public void getData(String username, String password) {
       this.username=username;
       this.password=password;
       loginModel.sendPostRequest(username,password,handler);
    }
    @Override
    public void keepPassword() {
      loginView.keepPassword(loginModel.keepUsername(),loginModel.keepPassword());
    }
    public class MyHandler extends Handler {
   @Override
    public void handleMessage(@NonNull Message msg) {
     super.handleMessage(msg);
     String data = (String) msg.obj;
     if(msg.what==2) {
       loginModel.doGson(data,LoginPresenter.this);
      }
     }
    }
}

