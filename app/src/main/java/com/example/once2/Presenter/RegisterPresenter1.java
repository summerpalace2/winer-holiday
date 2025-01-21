package com.example.once2.Presenter;

import com.example.once2.Model.Json.RegisterJson;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/1/20 19:24
 */
public interface RegisterPresenter1 {
    void getData(String username,String password,String repassword);//传递数据给Presenter
    void returnData(RegisterJson registerJson);//返回Json数据实体类
}
