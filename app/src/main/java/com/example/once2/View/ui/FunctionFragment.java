package com.example.once2.View.ui;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.once2.R;
import com.example.once2.adapter.FragmentAdapter;
import com.example.once2.adapter.FragmentInterface;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FunctionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FunctionFragment extends Fragment {
    private ViewPager2 viewPager2;
    private TabLayout tabLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FunctionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FunctionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FunctionFragment newInstance(String param1, String param2) {
        FunctionFragment fragment = new FunctionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_function, container, false);
        tabLayout = view.findViewById(R.id.tablayout2);
        viewPager2 = view.findViewById(R.id.tab_viewpager2);
        ArrayList<FragmentInterface> fragmentList = new ArrayList<>();
        fragmentList.add(new FragmentInterface() {
            @Override
            public Fragment back() {return new FunctionFragmentNewsOne();}
        });
        fragmentList.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new FunctionFragmentNewsTwo();
            }
        });
        fragmentList.add(new FragmentInterface() {
            @Override
            public Fragment back() {
                return new FunctionFragmentNewsThree();
            }
        });
        FragmentAdapter adapter = new FragmentAdapter(requireActivity(), fragmentList);
        viewPager2.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position == 0) {
                    tab.setText("要闻");
                } else if (position == 1) {
                    tab.setText("娱乐");
                } else {
                    tab.setText("汉文化");
                }
            }
        }).attach();

        return view;
    }
}