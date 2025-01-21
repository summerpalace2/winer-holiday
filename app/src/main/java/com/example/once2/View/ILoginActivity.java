package com.example.once2.View;

import android.content.Context;

public interface ILoginActivity {
    void startRegisterActivity();//打开RegisterActivity活动
    void showLoginSuccess();//展示成功信息
    void showLoginError(String msg);//展示错误信息
    void showLoading();//展示进度条
    void hideLoading();//隐藏进度条
    void startHomeActivity();//打开HomeActivity活动//记住密码
    Context MYgetCOntext();//传递context
    void keepPassword(String username,String password);//将账号输入到ui界面上
}
