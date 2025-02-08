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
import com.example.once2.View.ui.FunctionFragmentNewsThree;
import com.example.once2.model.Json.NewsTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * description ： TODO:类的作用
 * author : summer_palace2
 * email : 2992203079qq.com
 * date : 2025/2/7 12:00
 */
public class NewsTwoAdapter extends RecyclerView.Adapter<NewsTwoAdapter.ViewHolder> {
    private FunctionFragmentNewsThree functionFragmentNewsThree;
    private List<NewsTwo.dataBean> mData=new ArrayList<>();
    private Context context;
    public NewsTwoAdapter(FunctionFragmentNewsThree functionFragmentNewsThree, Context context){
        this.functionFragmentNewsThree=new FunctionFragmentNewsThree();
        this.context=context;
    }
    public void setListData(List<NewsTwo.dataBean> list){
        this.mData =list;
        Log.d("NewsTwo","list"+list);
        notifyDataSetChanged();
    }
    // 定义点击事件的接口
    public interface OnItemClickListener {
        void onItemClick(NewsTwo.dataBean dataBean);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    @NonNull
    @Override
    public NewsTwoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsTwoAdapter.ViewHolder holder, int position) {
        NewsTwo.dataBean dataBean = mData.get(position);
        holder.mTextView1.setText(dataBean.getTitle());
        holder.mTextView2.setText(dataBean.getDesc());
        holder.mTextView3.setText(dataBean.getCtime());
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
        TextView mTextView1;
        TextView mTextView2;
        TextView mTextView3;
        ImageView mImageView;
        public ViewHolder(@NonNull View itemVIew){
            super(itemVIew);
            mTextView1=itemVIew.findViewById(R.id.tv_title2);
            mTextView2=itemVIew.findViewById(R.id.tv_content);
            mTextView3=itemVIew.findViewById(R.id.tv_time2);
            mImageView=itemVIew.findViewById(R.id.im_photo2);
        }
    }
}
