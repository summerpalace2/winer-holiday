package com.example.once2.model;

import android.os.Handler;

import com.example.once2.Presenter.IMLoginPresenter;


public interface IMLoginModel {                //接口可看作类，即把类作为变量
    void doGson(String data, IMLoginPresenter callback);//实现解析Json数据在用实体类包装后返回数据给callback
    void sendPostRequest(String username, String password, Handler handler);//申请网络请求
    String keepPassword();//返回密码
    String keepUsername();//返回账号
    void updateKeepPassword(String username,String password);//将Presenter层获取的数据传递给Model层处理
    void concelKeepPassword();//改变shareferences中的值false
    void containkeepPassword();//改变shareferences中的值为true
    String getSelect();//返回shareferences中select的值
}    //具有连续性要一起用，即传值时就要判断，这是不现实的，因此要分布运行，可以拆分为两部分即分别使用

