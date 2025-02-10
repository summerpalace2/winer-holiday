package com.example.once2.Presenter;

import android.content.Context;
import android.os.Handler;

import com.example.once2.model.Json.RegisterJson;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/10 11:31
 */
public interface RegisterContact {
    public interface View{
        void onError(String MSg);//errorMsg传入错误信息
        void onSuccess();//展示成功信息
        String getUsername();//获取用户名
        String getPassword();//获取密码
        String getrePassword();//获取再次输入的密码
        void startActivity(Context content) ;//打开活动
        Context MygetContext();//传递context
    }
    public interface Presenter{
        void getData(String username,String password,String repassword);//传递数据给Presenter
        void returnData(RegisterJson registerJson);//返回Json数据实体类
    }
    public interface Model{
        void sendPostRequest(String username, String password, String repassword, Handler handler);//申请网络请求
        void doGson(String data, RegisterContact.Presenter callback);//实现解析Json数据在用实体类包装后返回数据给
        void callbackRegisterActivity(String username, String password, Context context);//通过返回的数据和Context创建sharereferences
    }
}
