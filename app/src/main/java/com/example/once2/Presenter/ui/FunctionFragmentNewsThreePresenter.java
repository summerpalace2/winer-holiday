package com.example.once2.Presenter.ui;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.once2.View.ui.FunctionFragmentNewsThree;
import com.example.once2.model.Json.NewsOne;
import com.example.once2.model.Json.NewsTwo;
import com.example.once2.model.ui.FunctionFragmentNewsThreeModel;
import com.example.once2.model.ui.FunctionFragmentNewsTwoModel;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/7 10:59
 */
public class FunctionFragmentNewsThreePresenter implements FunctionFragmentNewsThreeContact.Presenter{
    private MyHandler handler=new MyHandler();
    private FunctionFragmentNewsThreeContact.View functionFragmentNewsThreeView;
    private FunctionFragmentNewsThreeModel functionFragmentNewsThreeModel;
    public FunctionFragmentNewsThreePresenter(FunctionFragmentNewsThreeContact.View view){
        this.functionFragmentNewsThreeView=view;
        this.functionFragmentNewsThreeModel=new FunctionFragmentNewsThreeModel(functionFragmentNewsThreeView.MYgetCOntext());
    }
    @Override
    public void startPost() {
        functionFragmentNewsThreeModel.startPost(handler);
    }

    @Override
    public void returnDataPost(NewsTwo newsTwo) {functionFragmentNewsThreeView.returnData(newsTwo);}
    public class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String data = (String) msg.obj;
            Log.d("FunctionFragmentNewsOnedata","主线程收到消息"+data);
            if (msg.what==2){
                functionFragmentNewsThreeModel.doGSon(data, FunctionFragmentNewsThreePresenter.this);
            }

        }
    }
}
