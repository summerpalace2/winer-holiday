package com.example.once2.Presenter.ui;

import android.content.Context;
import android.os.Handler;

import com.example.once2.model.Json.NewsOne;
import com.example.once2.model.Json.NewsTwo;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/7 11:21
 */
public interface FunctionFragmentNewsThreeContact {
    public interface Model{
        public void startPost(Handler handler);//启动网络请求
        public void doGSon(String data, FunctionFragmentNewsThreeContact.Presenter callback);//接受Presenter层的handler数据
    }
    public interface Presenter{
        public void startPost();//启动网络请求
        public void returnDataPost(NewsTwo newsTwo);//回调doGson
    }
    public interface View{
        public void returnData(NewsTwo newsTwo);//返回数据
        Context MYgetCOntext();//传递context
    }
}
