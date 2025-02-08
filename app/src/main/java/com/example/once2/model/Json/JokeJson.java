package com.example.once2.model.Json;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/5 21:08
 */
public class JokeJson {
    private DataDTO data;
    private String message;
    public DataDTO getData() {
        return data;
    }
    public void setData(DataDTO data) {
        this.data = data;
    }
    public String getMessage(){
        return message;
    }
    public static class DataDTO {
        private String content;
        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }
    }
}