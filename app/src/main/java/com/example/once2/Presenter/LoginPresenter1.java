package com.example.once2.Presenter;

import android.content.Context;

import com.example.once2.Model.Json.LoginJson;
/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/1/20 19:21
 */
public interface LoginPresenter1 {
    public void returnData(LoginJson loginJson);//返回Json数据实体类
    public void getData(String username,String password);//传递数据给Presenter
    public void keepPassword();
}
