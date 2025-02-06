package com.example.once2.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.once2.R;
import com.example.once2.Presenter.LoginPresenter;
import com.example.once2.View.ui.HomeActivity;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity implements IMLoginActivity {
    private EditText mEditText1;
    private EditText mEditText2;
    private TextInputLayout mTextInputLayout1;
    private TextInputLayout mTextInputLayout2;
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private CheckBox mCheckBox;
    private Button mButton;
    private ProgressBar mProgressBar;//进度条
    private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 初始化Presenter;
        loginPresenter = new LoginPresenter(this);
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
                    loginPresenter.containKeepPassword();
                }
                if (!isChecked) {
                    loginPresenter.concelKeepPassword();
                }
            }
        });
        judgeCheckbox();//判段之前用户是否勾选checkbox
    }
    private void judgeCheckbox() {

        if(loginPresenter.returnSelect().equals("true")){
            mCheckBox.setChecked(true);//勾选checkbox
            loginPresenter.keepPassword();//记住密码
        }
    }
    private void initView() {
        //初始化UI组件
        mTextView1=findViewById(R.id.tv_login_title);
        mTextView2=findViewById(R.id.tv_login);
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
      loginPresenter.getKeepPassword(mEditText1.getText().toString(),mEditText2.getText().toString());
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
