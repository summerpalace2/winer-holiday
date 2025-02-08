package com.example.once2.model.Json;

import java.util.List;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/7 23:23
 */
public class NewsTwo {
    private List<NewsTwo.dataBean> data;
    private String message;

    public List<NewsTwo.dataBean> getData() {
        return data;
    }

    public void setData(List<NewsTwo.dataBean> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class dataBean{
        private String title;
        private String desc;
        private String url;
        private String ctime;
        private String imgsrc;
        private String pc_url;

        public String getPc_url() {
            return pc_url;
        }

        public void setPc_url(String pc_url) {
            this.pc_url = pc_url;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String Ctime) {
            this.ctime = Ctime;
        }
    }
}
