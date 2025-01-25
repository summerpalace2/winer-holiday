package com.example.once2.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.example.once2.model.json.Network;
import com.example.once2.model.json.RegisterJson;
import com.example.once2.Presenter.IMRegisterPresenter;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/1/20 19:35
 */
public class RegisterModel implements IMRegisterModel {
    private String mUrl="https://www.wanandroid.com/user/register";
    @Override
    public void sendPostRequest(String username, String password, String repassword, Handler handler) {
        HashMap<String,String> params=new HashMap<>();
        params.put("username",username);
        params.put("password",password);
        params.put("repassword",repassword);
        Network.sendPostRequest(mUrl,params,handler);
    }
    @Override
    public void doGson(String data, IMRegisterPresenter IMRegisterPresenter) {
        RegisterJson registerJson=new RegisterJson();
        registerJson = new Gson().fromJson(data, RegisterJson.class);
        IMRegisterPresenter.returnData(registerJson);
    }
    @Override
    public void callbackRegisterActivity(String username, String password, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("my_preference", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();//创建了一个文件，即通用，在login处理，必要的在那创建
        edit.putString("password",password);
        edit.putString("username",username);
        edit.apply();
    }
}
