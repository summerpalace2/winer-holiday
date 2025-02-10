package com.example.once2.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.example.once2.Presenter.LoginContact;
import com.example.once2.model.Json.LoginJson;
import com.example.once2.model.Json.Network;
import com.google.gson.Gson;
import java.util.HashMap;
public class LoginModel implements LoginContact.Model {
    private String mUrl = "https://www.wanandroid.com/user/login";
    private Context context;
    public LoginModel(Context context) {
        this.context=context;
    }
    @Override
    public void doGson(String data, LoginContact.Presenter callback) {
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
       return sharedPreferences.getString("password","");
    }
    @Override
    public String keepUsername() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("my_preference", context.MODE_PRIVATE);
        return sharedPreferences.getString("username","");
    }
    @Override
    public void updateKeepPassword(String username, String password) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("my_preference", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();//
        edit.putString("password",password);//保存登录成功的账号，保存最近一次使用的密码
        edit.putString("username",username);
        edit.apply();//提交，这样不阻碍主线程
    }
    @Override
    public void containkeepPassword(String select) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("my_preference", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();//
        edit.putString("select",select);//改变select对应的值
        edit.apply();//提交，这样不阻碍主线程
    }
    @Override
    public String getSelect() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("my_preference", context.MODE_PRIVATE);
        return sharedPreferences.getString("select"," ");
    }
}


