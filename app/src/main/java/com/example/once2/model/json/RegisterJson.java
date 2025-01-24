package com.example.once2.model.json;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/1/20 19:26
 */
//数据实体类
public class RegisterJson {
    public dataBean data;
    public Integer errorCode;
    public String errorMsg;
    public class dataBean {
        public String username;
        public String password;
        public String repassword;
    }
}
