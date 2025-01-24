package com.example.once2.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/1/24 17:03
 */
public class FragmentAdapter extends FragmentStateAdapter {
    private final ArrayList<FragmentInterface> fragments;
    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity, ArrayList<FragmentInterface> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }
    @NonNull
    @Override //从提供的Fragment数据源中拿数据
    public Fragment createFragment(int position) {
        return fragments.get(position).back();
    }
    @Override
    //返回Fragment的个数
    public int getItemCount() {
        return fragments.size();
    }
}
