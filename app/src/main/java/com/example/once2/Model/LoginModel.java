package com.example.once2.Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.example.once2.Model.Json.LoginJson;
import com.example.once2.Model.Json.Network;
import com.example.once2.Presenter.LoginPresenter1;
import com.google.gson.Gson;
import java.util.HashMap;
public class LoginModel implements ILoginModel {
    private String mUrl = "https://www.wanandroid.com/user/login";
    private Context context;

    public LoginModel(Context context) {
        this.context=context;
    }
    @Override
    public void doGson(String data, LoginPresenter1 callback) {
        LoginJson loginJson = new LoginJson();
        loginJson = new Gson().fromJson(data, LoginJson.class);
        callback.returnData(loginJson);
    }
    @Override
    public void sendPostRequest(String username,String password, Handler handler) {
    HashMap<String,String> params=new HashMap<>();
    params.put("username",username);
    params.put("password",password);
    Network.sendPostRequest(mUrl,params,handler);
    }
    @Override
    public String keepPassword() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("my_preference", context.MODE_PRIVATE);
       return sharedPreferences.getString("password"," ");
    }
    @Override
    public String keepUsername() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("my_preference", context.MODE_PRIVATE);
        return sharedPreferences.getString("username"," ");
    }
}


