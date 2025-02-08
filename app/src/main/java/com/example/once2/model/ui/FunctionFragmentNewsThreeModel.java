package com.example.once2.model.ui;

import android.content.Context;
import android.os.Handler;

import com.example.once2.Presenter.ui.FunctionFragmentNewsThreeContact;
import com.example.once2.Presenter.ui.FunctionFragmentNewsTwoContact;
import com.example.once2.model.Json.Network;
import com.example.once2.model.Json.NewsOne;
import com.example.once2.model.Json.NewsTwo;
import com.google.gson.Gson;

import java.util.HashMap;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/7 11:02
 */
public class FunctionFragmentNewsThreeModel implements FunctionFragmentNewsThreeContact.Model {
    private Context context;
    private String mUrl="https://v3.alapi.cn/api/new/hanfu";
    public FunctionFragmentNewsThreeModel(Context context) {
        this.context=context;
    }

    @Override
    public void startPost(Handler handler) {
        HashMap<String,String> map=new HashMap<>();
        map.put("token","lxkzdmt8vkjara7cnqtsex5j6supmk");
        Network.sendPostRequest(mUrl,map,handler);
    }

    @Override
    public void doGSon(String data, FunctionFragmentNewsThreeContact.Presenter callback) {
        NewsTwo newsTwo =new NewsTwo();
        newsTwo=new Gson().fromJson(data, NewsTwo.class);
        callback.returnDataPost(newsTwo);
    }
}
