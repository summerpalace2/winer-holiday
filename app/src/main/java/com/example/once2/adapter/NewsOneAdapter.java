package com.example.once2.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.once2.R;
import com.example.once2.View.ui.FunctionFragmentNewsOne;
import com.example.once2.model.Json.NewsOne;

import java.util.ArrayList;
import java.util.List;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/7 12:00
 */
public class NewsOneAdapter extends RecyclerView.Adapter<NewsOneAdapter.ViewHolder> {
    private FunctionFragmentNewsOne functionFragmentNewsOne;
    private List<NewsOne.dataBean> mData=new ArrayList<>();
    private Context context;
    public NewsOneAdapter(Context context){

        this.context=context;
    }
    public void setListData(List<NewsOne.dataBean> list){
        this.mData =list;
        Log.d("NewsOne","list"+list);
        notifyDataSetChanged();
    }
    // 定义点击事件的接口
    public interface OnItemClickListener {
        void onItemClick(NewsOne.dataBean dataBean);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    @NonNull
    @Override
    public NewsOneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsOneAdapter.ViewHolder holder, int position) {
        NewsOne.dataBean dataBean = mData.get(position);
        holder.mTextView1.setText(dataBean.getTitle());
        holder.mTextView3.setText(dataBean.getTime());
        Glide.with(context).load(dataBean.getImgsrc()).error(R.drawable.app).into(holder.mImageView);
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(dataBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView1;;
        TextView mTextView3;
        ImageView mImageView;
        public ViewHolder(@NonNull View itemVIew){
            super(itemVIew);
            mTextView1=itemVIew.findViewById(R.id.tv_title);
            mTextView3=itemVIew.findViewById(R.id.tv_time);
            mImageView=itemVIew.findViewById(R.id.im_photo);
        }
    }
}
