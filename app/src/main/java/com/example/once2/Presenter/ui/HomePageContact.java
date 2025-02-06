package com.example.once2.Presenter.ui;

import android.content.Context;
import android.os.Handler;

import com.example.once2.model.Json.CloudJson;
import com.example.once2.model.Json.JokeJson;

import java.io.UnsupportedEncodingException;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/5 20:01
 */
public interface HomePageContact {
    public interface Presenter{
        public void getData(String area);//从视图获取信息
        public void startRequest();//执行命令// ，开启网络请求
        public void returnDataPostJoke(JokeJson jokeJson);
        public void retrunDataPostCloud(CloudJson cloudJson);
        public void startKeepWeather();//显示上一次用户查询的记录
    }
    public interface View{
        public void returnDataPostJoke(JokeJson jokeJson);//接受返回的数据，将信息传入到视图上
        public void retrunDataPostCloud(CloudJson cloudJson);//接受返回的数据，将信息传入到视图上
        Context MYgetCOntext();//传递context
    }
    public interface Model{
        public void sendPostRequest(String area,Handler handler);//启动网络请求
        public void sendGetRequest(Handler handler);//启动网络请求
        public void doGsonPostJoke(String data,HomePageContact.Presenter callback);
        public void doGsonPostCloud(String data,HomePageContact.Presenter callback);
        public void startKeepWeather(Handler handler);//显示上一次用户查询的记录

    }
}
