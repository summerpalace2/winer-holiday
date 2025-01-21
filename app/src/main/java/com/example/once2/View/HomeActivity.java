package com.example.once2.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.once2.R;
public class HomeActivity extends AppCompatActivity implements IHomeActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
    @Override
    public void startActivity(Context content) {
        //启动活动
        Intent intent= new Intent(content, HomeActivity.class);
        content.startActivity(intent);
    }
}
