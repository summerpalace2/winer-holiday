package com.example.once2.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.once2.Presenter.LoginPresenter;
import com.example.once2.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements ILoginActivity {
    private EditText mEditText1;
    private EditText mEditText2;
    private TextInputLayout mTextInputLayout1;
    private TextInputLayout mTextInputLayout2;
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private CheckBox mCheckBox;
    private Button mButton;
    private ProgressBar mProgressBar;
    private LoginPresenter loginPresenter;
    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 初始化Presenter;
        loginPresenter = new LoginPresenter(this);
        initView();
        initEvent();
    }
    private void initEvent() {
        // 设置按钮点击事件
        mButton.setOnClickListener(v -> {
            String username = mEditText1.getText().toString();
            String password = mEditText2.getText().toString();
            loginPresenter.getData(username, password);
        });
        mTextView2.setOnClickListener(v -> {startRegisterActivity();});
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    loginPresenter.keepPassword();
                }
            }
        });
    }
    private void initView() {
        //初始化UI组件
        mTextView1=findViewById(R.id.tv_login_title);
        mTextView2=findViewById(R.id.tv_login);
        mTextView3=findViewById(R.id.tv_login_forgetpassword);
        mEditText1 = findViewById(R.id.et_login_username1);
        mEditText2 = findViewById(R.id.et_login_password1);
        mTextInputLayout1=findViewById(R.id.et_login_username);
        mTextInputLayout2=findViewById(R.id.et_login_password);
        mButton = findViewById(R.id.button1);
        mProgressBar = findViewById(R.id.login_progressBar);
        mCheckBox=findViewById(R.id.ch_login_keeppassword);
    }
    @Override
    public void startRegisterActivity() {//跳转活动
        Toast.makeText(this,"跳转成功",Toast.LENGTH_SHORT).show();
        RegisterActivity registerActivity=new RegisterActivity();
        registerActivity.startActivity(this);
    }
    @Override
    public void showLoginSuccess() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPreferences = getSharedPreferences("my_preference", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();//创建了一个文件，即通用，在login处理，必要的在那创建
        edit.putString("password",mEditText2.getText().toString());
        edit.putString("username",mEditText1.getText().toString());
        edit.apply();
    }
    @Override
    public void showLoginError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }
    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }
    @Override
    public void startHomeActivity() {
        Toast.makeText(this,"跳转成功",Toast.LENGTH_SHORT).show();
        HomeActivity homeActivity=new HomeActivity();
        homeActivity.startActivity(this);
    }
    @Override
    public Context MYgetCOntext() {
        return this;
    }

    @Override
    public void keepPassword(String username,String password) {
    mEditText1.setText(username);
    mEditText2.setText(password);
    }
}
