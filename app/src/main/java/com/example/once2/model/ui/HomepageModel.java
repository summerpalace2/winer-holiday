package com.example.once2.model.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;

import com.example.once2.Presenter.ui.HomePageContact;
import com.example.once2.model.Json.CloudJson;
import com.example.once2.model.Json.JokeJson;
import com.example.once2.model.Json.Network;
import com.example.once2.model.Json.Network2;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/5 19:48
 */
public class HomepageModel implements HomePageContact.Model   {
    private Context context;
    private String mUrl1="https://v3.alapi.cn/api/joke/random";
    private String mUrl2="https://v3.alapi.cn/api/tianqi";

    public HomepageModel(Context context) {
       this.context=context;
    }
    @Override
    public void sendPostRequest(String area,Handler handler) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("my_preference", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();//
        HashMap<String,String> map=new HashMap<>();
        map.put("token","lxkzdmt8vkjara7cnqtsex5j6supmk");
        try {
            String city= URLEncoder.encode(area,"UTF-8");
            edit.putString("city",city);//保存登录成功的账号，保存最近一次使用的密码
            edit.apply();//提交，这样不阻碍主线程
            map.put("city",sharedPreferences.getString("city",city));
            Network.sendPostRequest(mUrl2,map,handler);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendGetRequest(Handler handler) {
        HashMap<String,String> map=new HashMap<>();
        map.put("token","lxkzdmt8vkjara7cnqtsex5j6supmk");
        Network.sendPostRequest(mUrl1,map,handler);
    }

    @Override
    public void doGsonPostJoke(String data, HomePageContact.Presenter callback) {
        JokeJson jokeJson=new JokeJson();
        jokeJson=new Gson().fromJson(data, JokeJson.class);
        callback.returnDataPostJoke(jokeJson);
    }

    @Override
    public void doGsonPostCloud(String data, HomePageContact.Presenter callback) {
        CloudJson cloudJson=new CloudJson();
        cloudJson=new Gson().fromJson(data,CloudJson.class);
        callback.retrunDataPostCloud(cloudJson);
    }

    @Override
    public void startKeepWeather(Handler handler) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("my_preference", context.MODE_PRIVATE);
        HashMap<String,String> map=new HashMap<>();
        map.put("token","lxkzdmt8vkjara7cnqtsex5j6supmk");
        map.put("city",sharedPreferences.getString("city"," "));
        Network.sendPostRequest(mUrl2,map,handler);
    }


}
