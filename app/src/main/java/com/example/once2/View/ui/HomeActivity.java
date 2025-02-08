package com.example.once2.View.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager2.widget.ViewPager2;
import androidx.fragment.app.Fragment;
import com.example.once2.R;
import com.example.once2.adapter.FragmentAdapter;
import com.example.once2.adapter.FragmentInterface;
import com.example.once2.View.IMHomeActivity;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements IMHomeActivity {
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.tab_viewpager);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        ArrayList<FragmentInterface> fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new HomePageFragment();
            }
        });
        fragmentList.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new FunctionFragment();
            }
        });
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.homepage));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tool));
        FragmentAdapter adapter = new FragmentAdapter(this, fragmentList);
        viewPager2.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("主页");
                    tab.setIcon(R.drawable.homepage);
                } else if (position == 1) {
                    tab.setText("新闻中心");
                    tab.setIcon(R.drawable.tool);
                }

            }

        }).attach();

    }
    public void startActivity(Context content) {
        //启动活动
        Intent intent = new Intent(content, HomeActivity.class);
        content.startActivity(intent);
    }

}
