package com.example.once2.presenter;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;

import com.example.once2.model.json.LoginJson;
import com.example.once2.model.LoginModel;
import com.example.once2.view.IMLoginActivity;
public class LoginPresenter implements IMLoginPresenter
{
    private IMLoginActivity loginView;
    private LoginModel loginModel;
    private String username;
    private String password;
    private MyHandler handler=new MyHandler();
    public LoginPresenter(IMLoginActivity view) {
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

    @Override
    public void getKeepPassword(String username, String password) {
        loginModel.updateKeepPassword(username,password);
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

