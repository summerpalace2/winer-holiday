package com.example.once2.Presenter.ui;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.once2.View.ui.FunctionFragmentNewsOne;
import com.example.once2.model.Json.NewsOne;
import com.example.once2.model.ui.FunctionFragmentNewsOneModel;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/7 10:59
 */
public class FunctionFragmentNewsOnePresenter implements FunctionFragmentNewsOneContact.Presenter{
    private MyHandler handler=new MyHandler();
    private FunctionFragmentNewsOneContact.View functionFragmentNewsOneView;
    private FunctionFragmentNewsOneModel functionFragmentNewsOneModel;
    public FunctionFragmentNewsOnePresenter(FunctionFragmentNewsOneContact.View view){
        this.functionFragmentNewsOneView=view;
        this.functionFragmentNewsOneModel=new FunctionFragmentNewsOneModel(functionFragmentNewsOneView.MYgetCOntext());
    }
    @Override
    public void startPost() {
        functionFragmentNewsOneModel.startPost(handler);
    }

    @Override
    public void returnDataPost(NewsOne newsOne) {
        functionFragmentNewsOneView.returnData(newsOne);
    }
    public class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            String data = (String) msg.obj;
            Log.d("FunctionFragmentNewsOnedata","主线程收到消息"+data);
            if (msg.what==2){
                functionFragmentNewsOneModel.doGSon(data,FunctionFragmentNewsOnePresenter.this);
            }

        }
    }
}
