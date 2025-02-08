package com.example.once2.View.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.once2.Presenter.ui.FunctionFragmentNewsThreeContact;
import com.example.once2.Presenter.ui.FunctionFragmentNewsThreePresenter;
import com.example.once2.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FunctionFragmentNewsTwo#newInstance} factory method to
 * create an instance of this fragment.
 */


import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;

import com.example.once2.adapter.NewsTwoAdapter;
import com.example.once2.model.Json.NewsTwo;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FunctionFragmentNewsOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FunctionFragmentNewsThree extends Fragment implements FunctionFragmentNewsThreeContact.View , NewsTwoAdapter.OnItemClickListener{
    private RecyclerView mRecyclerView;
    private NewsTwoAdapter mNewThreeAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FunctionFragmentNewsThreePresenter functionFragmentNewsThreePresenter;

    public FunctionFragmentNewsThree() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FunctionFragmentnewsone.
     */
    // TODO: Rename and change types and number of parameters
    public static FunctionFragmentNewsThree newInstance(String param1, String param2) {
        FunctionFragmentNewsThree fragment = new FunctionFragmentNewsThree();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        functionFragmentNewsThreePresenter=new FunctionFragmentNewsThreePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_function_news_three, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView3);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        functionFragmentNewsThreePresenter.startPost();
        return view;
    }

    @Override
    public void returnData(NewsTwo newsTwo) {
        mNewThreeAdapter=new NewsTwoAdapter(FunctionFragmentNewsThree.this,getActivity());
        mRecyclerView.setAdapter(mNewThreeAdapter);
        if (newsTwo.getData()!=null) {
            mNewThreeAdapter.setListData(newsTwo.getData());
        }
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mNewThreeAdapter.setOnItemClickListener(this);
    }

    @Override
    public Context MYgetCOntext() {
        return getActivity();
    }

    @Override
    public void onItemClick(NewsTwo.dataBean dataBean) {
        Intent intent =new Intent(Intent.ACTION_VIEW);
        Log.d("www111", "onItemClick: "+dataBean.getUrl());
        intent.setData(Uri.parse(dataBean.getUrl()));
        startActivity(intent);
    }
}