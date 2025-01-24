package com.example.once2.presenter;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import com.example.once2.model.json.RegisterJson;
import com.example.once2.model.RegisterModel;
import com.example.once2.view.RegisterActivity;
import com.example.once2.view.IRegisterActivity;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/1/20 19:19
 */
public class RegisterPresenter implements IMRegisterPresenter {
    private IRegisterActivity registerView;
    private RegisterModel registerModel;
    private String username;
    private String password;
    private String repassword;
    private Myhandler handler=new Myhandler();
    public RegisterPresenter(RegisterActivity registerActivity) {
        this.registerView = registerActivity;
        registerModel = new RegisterModel();
    }
    @Override
    public void getData(String username, String password, String repassword) {
       this.username=username;
       this.password=password;
       this.repassword=repassword;
       registerModel.sendPostRequest(username,password,repassword,handler);
    }
    @Override
    public void returnData(RegisterJson registerJson) {
    if(registerJson.errorCode==0) {
        registerView.onSuccess();
        registerModel.callbackRegisterActivity(username,password,registerView.MygetContext());//生命周期
     }
    else {
        registerView.onError(registerJson.errorMsg);
    }
    }
public class Myhandler extends Handler{
   @Override
    public void handleMessage(@NonNull Message msg) {
       super.handleMessage(msg);
       String data=(String)msg.obj;
       if(msg.what==2) {
           registerModel.doGson(data,RegisterPresenter.this);
       }
   }
}
}
