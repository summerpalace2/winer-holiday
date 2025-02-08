package com.example.once2.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.once2.R;

public class WelcomeActivity extends AppCompatActivity {
    private TextView mTextView;
    private CountDownTimer countDownTimer;
    private long timeLeftInMills=3000;//设置倒计时时长

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mTextView=findViewById(R.id.tv_countdown);
        startCountDown();
        // 设置状态栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(android.graphics.Color.TRANSPARENT);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
    }

    private void startCountDown() {
        countDownTimer =new CountDownTimer(timeLeftInMills,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMills=millisUntilFinished;
                int secondRemaining =(int)(millisUntilFinished/1000);
                mTextView.setText(secondRemaining+"s");
            }

            @Override
            public void onFinish() {
                Intent intent= new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if ((countDownTimer!=null)){
            countDownTimer.cancel();
        }
    }
}