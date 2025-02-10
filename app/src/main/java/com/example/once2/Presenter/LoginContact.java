package com.example.once2.Presenter;

import android.content.Context;
import android.os.Handler;

import com.example.once2.model.Json.LoginJson;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/10 11:22
 */
public interface LoginContact {
    public interface View{
        void startRegisterActivity();//打开RegisterActivity活动
        void showLoginSuccess();//展示成功信息
        void showLoginError(String msg);//展示错误信息
        void showLoading();//展示进度条
        void hideLoading();//隐藏进度条
        void startHomeActivity();//打开HomeActivity活动//记住密码
        Context MYgetCOntext();//传递context
        void keepPassword(String username,String password);//将账号输入到ui界面上
    }
    public interface Presenter{
        public void returnData(LoginJson loginJson);//返回Json数据实体类
        public void getData(String username,String password);//传递数据给Presenter
        public void keepPassword();//获取从model层储存的数据
        public void getKeepPassword(String username,String password);//获取从View层返回的登陆成功的数据，以更新最新的保存密码;
        public String returnSelect();//返回勾选或者未勾选的信息
        public void containKeepPassword(String select);//保存密码确认
    }
    public interface Model{
        //接口可看作类，即把类作为变量
        void doGson(String data, LoginContact.Presenter callback);//实现解析Json数据在用实体类包装后返回数据给callback
        void sendPostRequest(String username, String password, Handler handler);//申请网络请求
        String keepPassword();//返回密码
        String keepUsername();//返回账号
        void updateKeepPassword(String username,String password);//将Presenter层获取的数据传递给Model层处
        void containkeepPassword(String select);//改变shareferences中的值
        String getSelect();//返回shareferences中select的值
    }
}
