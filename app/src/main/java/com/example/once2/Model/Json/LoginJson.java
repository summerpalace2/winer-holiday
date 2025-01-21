package com.example.once2.Model.Json;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/1/20 17:14
 */
//返回数据实体类
public class LoginJson {
    public dataBean data;
    public Integer errorCode;
    public String errorMsg;
    public class dataBean{
        public String username;
        public String password;
    }
}
