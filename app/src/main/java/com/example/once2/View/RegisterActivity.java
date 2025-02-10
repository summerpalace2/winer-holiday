package com.example.once2.View;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.once2.Presenter.RegisterContact;
import com.example.once2.Presenter.RegisterPresenter;
import com.example.once2.R;
import com.google.android.material.textfield.TextInputLayout;
public class RegisterActivity extends AppCompatActivity implements RegisterContact.View {
    private Button mBtnLogin;
    private EditText mEtUserName;
    private EditText mEtpassword1;
    private EditText mEtpassword2;
    private TextInputLayout mTextInputLayout1;
    private TextInputLayout mTextInputLayout2;
    private TextInputLayout mTextInputLayout3;
    private RegisterPresenter registerPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        //初始化RegisterPresenter
        registerPresenter=new RegisterPresenter(this);
         initView();
         initEvent();
        // 设置状态栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(android.graphics.Color.TRANSPARENT);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
    }
    private void initEvent() {
        mBtnLogin.setOnClickListener(v -> {
            registerPresenter.getData(getUsername(),getPassword(),getrePassword());
        });
    }
    private void initView()
    {//初始化UI控件
        mBtnLogin = findViewById(R.id.Button4);
        mEtUserName=findViewById(R.id.et_reg_username1);
        mEtpassword1=findViewById(R.id.et_reg_password11);
        mEtpassword2=findViewById(R.id.et_reg_password22);
        mTextInputLayout1=findViewById(R.id.et_reg_username);
        mTextInputLayout2=findViewById(R.id.et_login_password1);
        mTextInputLayout3=findViewById(R.id.et_reg_password2);
    }
    @Override
    public void onError(String msg){
        Toast.makeText( this,msg,Toast.LENGTH_SHORT).show();}
    @Override
    public void onSuccess(){
        Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
        Intent intent= new Intent();
        intent.putExtra("key1",getUsername());
        intent.putExtra("key2",getPassword());
        intent.putExtra("key3",getrePassword());
        setResult(RESULT_OK,intent);
        finish();}
    @Override
    public String getUsername() {return mEtUserName.getText().toString();}
    @Override
    public String getPassword(){return mEtpassword1.getText().toString();}
    @Override
    public String getrePassword(){return mEtpassword2.getText().toString();}
    @Override
    public  void startActivity(Context content) {
        //启动活动
        Intent intent= new Intent(content, RegisterActivity.class);
        content.startActivity(intent);
    }
    @Override
    public Context MygetContext() {
        return this;
    }
}