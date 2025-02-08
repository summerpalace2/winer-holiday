package com.example.once2.View.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.once2.Presenter.ui.FunctionFragmentNewsOneContact;
import com.example.once2.Presenter.ui.FunctionFragmentNewsOnePresenter;
import com.example.once2.Presenter.ui.HomepagePresenter;
import com.example.once2.R;
import com.example.once2.adapter.NewsOneAdapter;
import com.example.once2.model.Json.NewsOne;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FunctionFragmentNewsOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FunctionFragmentNewsOne extends Fragment implements FunctionFragmentNewsOneContact.View ,NewsOneAdapter.OnItemClickListener{
    private RecyclerView mRecyclerView;
    private NewsOneAdapter mNewOneAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FunctionFragmentNewsOnePresenter functionFragmentNewsOnePresenter;


    public FunctionFragmentNewsOne() {
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
    public static FunctionFragmentNewsOne newInstance(String param1, String param2) {
        FunctionFragmentNewsOne fragment = new FunctionFragmentNewsOne();
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
        functionFragmentNewsOnePresenter=new FunctionFragmentNewsOnePresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_function_fragmentnewsone, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerView1);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        functionFragmentNewsOnePresenter.startPost();
        return view;
    }

    @Override
    public void returnData(NewsOne newsOne) {
        mNewOneAdapter=new NewsOneAdapter(getActivity());
        mRecyclerView.setAdapter(mNewOneAdapter);
        if (newsOne.getData()!=null) {
            mNewOneAdapter.setListData(newsOne.getData());
        }
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mNewOneAdapter.setOnItemClickListener(this);

    }

    @Override
    public Context MYgetCOntext() {
        return getActivity();
    }

    @Override
    public void onItemClick(NewsOne.dataBean dataBean) {
        Intent intent =new Intent(Intent.ACTION_VIEW);
        Log.d("www111", "onItemClick: "+dataBean.getPc_url());
        intent.setData(Uri.parse(dataBean.getPc_url()));
        startActivity(intent);

    }
}