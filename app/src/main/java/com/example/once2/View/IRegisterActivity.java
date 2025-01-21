package com.example.once2.View;

import android.content.Context;

public interface IRegisterActivity {
    void onError(String MSg);//errorMsg传入错误信息
    void onSuccess();//展示成功信息
    String getUsername();//获取用户名
    String getPassword();//获取密码
    String getrePassword();//获取再次输入的密码
    void startActivity(Context content) ;//打开活动
    Context MygetContext();//传递context
}
