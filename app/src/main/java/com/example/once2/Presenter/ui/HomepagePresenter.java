package com.example.once2.Presenter.ui;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.once2.Presenter.LoginPresenter;
import com.example.once2.model.Json.CloudJson;
import com.example.once2.model.Json.JokeJson;
import com.example.once2.model.ui.HomepageModel;

import java.io.UnsupportedEncodingException;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/5 19:47
 */
public class HomepagePresenter implements HomePageContact.Presenter{
    private MyHandler1 handler1=new MyHandler1();
    private MyHandler2 handler2=new MyHandler2();
    private HomePageContact.View homePageView;
    private HomepageModel homepageModel;
    public HomepagePresenter(HomePageContact.View view){
        this.homePageView=view;
        this.homepageModel=new HomepageModel(homePageView.MYgetCOntext());
    }
    @Override
    public void getData(String area)  {
        homepageModel.sendPostRequest(area,handler2);
    }

    @Override
    public void startRequest() {
      homepageModel.sendGetRequest(handler1);
    }

    @Override
    public void returnDataPostJoke(JokeJson jokeJson){
        homePageView.returnDataPostJoke(jokeJson);
    }

    @Override
    public void retrunDataPostCloud(CloudJson cloudJson) {
        homePageView.retrunDataPostCloud(cloudJson);
    }

    @Override
    public void startKeepWeather() {
        homepageModel.startKeepWeather(handler2);
    }


    public class MyHandler1 extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String data = (String) msg.obj;
            Log.d("Homepagedata","主线程收到消息"+data);
            if (msg.what==2){
                homepageModel.doGsonPostJoke(data,HomepagePresenter.this);
            }

        }
    }
    public class MyHandler2 extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String data = (String) msg.obj;
            Log.d("Homepagedata","主线程收到消息"+data);
            if (msg.what==2){
                homepageModel.doGsonPostCloud(data,HomepagePresenter.this);
            }

        }
    }
}
