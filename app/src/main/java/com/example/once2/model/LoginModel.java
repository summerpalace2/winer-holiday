package com.example.once2.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.example.once2.model.json.LoginJson;
import com.example.once2.model.json.Network;
import com.example.once2.presenter.IMLoginPresenter;
import com.google.gson.Gson;
import java.util.HashMap;
public class LoginModel implements IMLoginModel {
    private String mUrl = "https://www.wanandroid.com/user/login";
    private Context context;
    public LoginModel(Context context) {
        this.context=context;
    }
    @Override
    public void doGson(String data, IMLoginPresenter callback) {
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
    @Override
    public void updateKeepPassword(String username, String password) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("my_preference", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();//创建了一个文件，即通用，在login处理，注意shareferences只认名字不认context
        edit.putString("password",password);//保存登录成功的账号，保存最近一次使用的密码
        edit.putString("username",username);
        edit.apply();//提交，这样不阻碍主线程

    }
}


