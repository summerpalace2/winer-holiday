package com.example.once2.View.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TabLayout tabLayout = findViewById(R.id.tablayout);
        ViewPager2 vp2=findViewById(R.id.tab_viewpager);
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
        fragmentList.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new PersonalFragment();
            }
        });
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.homepage));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tool));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.personal));
        FragmentAdapter adapter=new FragmentAdapter(this,fragmentList);
        vp2.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, vp2, new TabLayoutMediator.TabConfigurationStrategy()
        {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position)
            {
                if (position == 0) {
                    tab.setText("主页");
                    tab.setIcon(R.drawable.homepage);
                }
                else if (position==1) {
                    tab.setText("功能");
                    tab.setIcon(R.drawable.tool);
                }
                else {
                    tab.setText("个人中心");
                    tab.setIcon(R.drawable.personal);
                }
            }

        }).attach();

hideToolTipText(tabLayout.newTab());
    }
    private void hideToolTipText(TabLayout.Tab tab) {
        // 取消长按事件
        View tabView = tab.view;
        tabView.setLongClickable(false);

        // API 26 以上设置空文本
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            tabView.setTooltipText("");
        }
    }
    @Override
    public void startActivity(Context content) {
        //启动活动
        Intent intent = new Intent(content, HomeActivity.class);
        content.startActivity(intent);
    }

}
