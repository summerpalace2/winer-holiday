package com.example.once2.presenter;

import com.example.once2.model.json.LoginJson;
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
}
