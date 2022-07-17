package com.example.shopping.home.Fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.home.Fragment.bean.ResultBeanData;
import com.example.shopping.utils.Constance;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 频道适配器
 */
public class ChannelAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<ResultBeanData.ResultEntity.ChannelInfoEntity> channel_info;

    public ChannelAdapter(Context mContext, List<ResultBeanData.ResultEntity.ChannelInfoEntity> channel_info) {
        this.mContext = mContext;
        this.channel_info = channel_info;
    }


    @Override
    public int getCount() {
        return channel_info.size();//有多少条数据
    }

    @Override
    public Object getItem(int i) {
        return channel_info.get(i);//获取第几个按钮
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * 1.加载布局文件xml，将布局文件中的各个视图放入ViewHolder中；
     * 2.将具体信息显示到视图上。
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            //将加载的单个按钮试图放入ViewHolder中,viewHolder加载ImageView、TextView
            view =View.inflate(mContext, R.layout.item_channel,null);
            holder =new ViewHolder(view);
            holder.ivChannel = (ImageView) view.findViewById(R.id.iv_channel);
            holder.tvChannel = (TextView)view.findViewById(R.id.tv_channel);
            view.setTag(holder);//设置标签
        }else{
            holder = (ViewHolder) view.getTag();//获取标签
        }

        //获取按钮列表信息中的具体item信息
        ResultBeanData.ResultEntity.ChannelInfoEntity channelInfoEntity =channel_info.get(i);
        //设置按钮item的名称
        holder.tvChannel.setText(channelInfoEntity.getChannel_name());
        //设置按钮item的图标
        Glide.with(mContext)
                .load(Constance.Base_URl_IMAGE+channelInfoEntity.getImage())
                .into(holder.ivChannel);
        return view;
    }

    class ViewHolder {
        @Bind(R.id.iv_channel)
        ImageView ivChannel;
        @Bind(R.id.tv_channel)
        TextView tvChannel;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
