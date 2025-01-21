package com.example.once2.Model;

import android.content.Context;
import android.os.Handler;

import com.example.once2.Presenter.RegisterPresenter1;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/1/20 19:35
 */
public interface IRegisterModel {
    void sendPostRequest(String username, String password, String repassword, Handler handler);//申请网络请求
    void doGson(String data, RegisterPresenter1 registerPresenter1);//实现解析Json数据在用实体类包装后返回数据给
    void callbackRegisterActivity(String username, String password, Context context);//通过返回的数据和Context创建sharereferences
}
