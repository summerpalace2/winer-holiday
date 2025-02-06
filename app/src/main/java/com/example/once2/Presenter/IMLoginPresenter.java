package com.example.once2.Presenter;

import com.example.once2.model.Json.LoginJson;
/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/1/20 19:21
 */
public interface IMLoginPresenter {
    public void returnData(LoginJson loginJson);//返回Json数据实体类
    public void getData(String username,String password);//传递数据给Presenter
    public void keepPassword();//获取从model层储存的数据
    public void getKeepPassword(String username,String password);//获取从View层返回的登陆成功的数据，以更新最新的保存密码;
    public void concelKeepPassword();//如果用户取消了记住密码，那么就改变shareferenc储存的值
    public String returnSelect();//返回勾选或者未勾选的信息
    public void containKeepPassword();//保存密码确认
}
