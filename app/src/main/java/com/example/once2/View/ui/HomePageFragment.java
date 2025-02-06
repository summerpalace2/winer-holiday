package com.example.once2.View.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;


import com.example.once2.Presenter.ui.HomePageContact;
import com.example.once2.Presenter.ui.HomepagePresenter;
import com.example.once2.R;
import com.example.once2.model.Json.CloudJson;
import com.example.once2.model.Json.JokeJson;

import java.io.UnsupportedEncodingException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePageFragment extends Fragment implements HomePageContact.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Toolbar mToolbar;
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private TextView mTextView4;
    private TextView mTextView5;
    private EditText mEditText;
    private Button mButton;
    private ImageButton mImageButton;
    private ImageView mImageView;
    private HomepagePresenter homepagePresenter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomePageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomePageFragment newInstance(String param1, String param2) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        homepagePresenter=new HomepagePresenter(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null && getActivity().getWindow() != null) {
            // 设置状态栏颜色
            getActivity().getWindow().setStatusBarColor(Color.parseColor("#E0F7FA"));

            // 设置状态栏图标颜色（浅色背景用黑色图标）
            //getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =inflater.inflate(R.layout.fragment_home_page, container, false);
         initView(view);
         initEvent();
        homepagePresenter.startRequest();
        judgeKeep();//判断用户之前有没有搜索
        return view;
    }

    private void judgeKeep() {
        SharedPreferences sharedPreferences = MYgetCOntext().getSharedPreferences("my_preference", MYgetCOntext().MODE_PRIVATE);
        if (!sharedPreferences.getString("city", " ").equals(" ")){
            homepagePresenter.startKeepWeather();
        }
    }

    private void initView(View view) {
        mToolbar=view.findViewById(R.id.my_toolbar);
        mTextView1=view.findViewById(R.id.tv_text);
        mTextView2=view.findViewById(R.id.tv_area);
        mTextView3=view.findViewById(R.id.tv_temperature);
        mTextView4=view.findViewById(R.id.tv_weather);
        mTextView5=view.findViewById(R.id.tv_temperatures);
        mEditText=view.findViewById(R.id.ed_region);
        mButton=view.findViewById(R.id.button);
        mImageButton=view.findViewById(R.id.ib_cloud);
        mImageView=view.findViewById(R.id.im_weather);
    }
    private void initEvent(){
        mButton.setOnClickListener(v -> {
            String area=mEditText.getText().toString();
            homepagePresenter.getData(area);
        });
    }
    private int getImgResOfWeather(String weather_code){
        int result=0;
        switch (weather_code){
            case "qing": result=R.drawable.qing; break;
            case "yin": result=R.drawable.yin; break;
            case "yun": result=R.drawable.cloud; break;
            case "wu": result=R.drawable.wu; break;
            case "bingbao": result=R.drawable.bingbao; break;
            case "yu": result=R.drawable.yu; break;
            case "dayu": result=R.drawable.dayu; break;
            case "lei": result=R.drawable.lei; break;
            case "shachen": result=R.drawable.shachen; break;
            case "xue": result=R.drawable.xue; break;
        }
        return result;
    }

    @Override
    public void returnDataPostJoke(JokeJson jokeJson) {
        mTextView1.setText("每日笑话:"+jokeJson.getData().getContent());
    }

    @Override
    public void retrunDataPostCloud(CloudJson cloudJson) {
        mTextView2.setText(cloudJson.getData().getCity());
        mTextView3.setText(cloudJson.getData().getTemp()+"℃");
        mTextView4.setText(cloudJson.getData().getWeather());
        mTextView5.setText(cloudJson.getData().getMin_temp()+"~"+cloudJson.getData().getMax_temp()+"℃");
        mImageView.setImageResource(getImgResOfWeather(cloudJson.getData().getWeather_code()));
    }

    @Override
    public Context MYgetCOntext() {
        return getActivity();
    }
}