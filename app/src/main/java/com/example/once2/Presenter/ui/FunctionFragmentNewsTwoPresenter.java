package com.example.once2.Presenter.ui;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.once2.model.Json.NewsOne;
import com.example.once2.model.ui.FunctionFragmentNewsOneModel;
import com.example.once2.model.ui.FunctionFragmentNewsTwoModel;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/7 10:59
 */
public class FunctionFragmentNewsTwoPresenter implements FunctionFragmentNewsTwoContact.Presenter{
    private MyHandler handler=new MyHandler();
    private FunctionFragmentNewsTwoContact.View functionFragmentNewsTwoView;
    private FunctionFragmentNewsTwoModel functionFragmentNewsTwoModel;
    public FunctionFragmentNewsTwoPresenter(FunctionFragmentNewsTwoContact.View view){
        this.functionFragmentNewsTwoView=view;
        this.functionFragmentNewsTwoModel=new FunctionFragmentNewsTwoModel(functionFragmentNewsTwoView.MYgetCOntext());
    }
    @Override
    public void startPost() {
        functionFragmentNewsTwoModel.startPost(handler);
    }

    @Override
    public void returnDataPost(NewsOne newsOne) {
        functionFragmentNewsTwoView.returnData(newsOne);
    }
    public class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String data = (String) msg.obj;
            Log.d("FunctionFragmentNewsOnedata","主线程收到消息"+data);
            if (msg.what==2){
                functionFragmentNewsTwoModel.doGSon(data, FunctionFragmentNewsTwoPresenter.this);
            }

        }
    }
}
