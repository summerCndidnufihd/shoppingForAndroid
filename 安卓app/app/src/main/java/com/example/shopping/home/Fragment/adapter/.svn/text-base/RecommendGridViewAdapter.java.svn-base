package com.example.shopping.home.Fragment.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.shopping.R;
import com.example.shopping.home.Fragment.bean.ResultBeanData;
import com.example.shopping.utils.Constance;


import java.util.List;


public class RecommendGridViewAdapter extends BaseAdapter {
    private final Context mContext;
    private final List<ResultBeanData.ResultEntity.RecommendInfoEntity> recommend_info;

    public RecommendGridViewAdapter(Context mContext, List<ResultBeanData.ResultEntity.RecommendInfoEntity> data) {
        this.mContext = mContext;
        this.recommend_info = data;
    }

    @Override
    public int getCount() {
        return recommend_info.size();
    }

    @Override
    public Object getItem(int i) {
        return recommend_info.get(i);
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
        RecommendGridViewAdapter.ViewHolder holder;
        if(view == null){
            //将加载的单个按钮试图放入ViewHolder中,viewHolder加载ImageView、TextView
            view =View.inflate(mContext, R.layout.item_recommend_grid_view,null);
            holder = new ViewHolder();
            holder.iv_recommend = (ImageView) view.findViewById(R.id.iv_recommend);
            holder.tv_name = (TextView)view.findViewById(R.id.tv_name);
            holder.tv_price = (TextView)view.findViewById(R.id.tv_price);
            view.setTag(holder);//设置标签
        }else{
            holder = (RecommendGridViewAdapter.ViewHolder) view.getTag();//获取标签
        }

        //根据位置获取列表中的每一条信息
        ResultBeanData.ResultEntity.RecommendInfoEntity recommendInfoEntity = recommend_info.get(i);
        //设置图片
        Glide.with(mContext)
                .load(Constance.Base_URl_IMAGE+recommend_info.get(i).getFigure())
                .into(holder.iv_recommend);
        //设置商品信息名称
        holder.tv_name.setText(recommend_info.get(i).getName());
        //设置商品价格
        holder.tv_price.setText("￥"+recommend_info.get(i).getCover_price());
        return view;
    }


    class ViewHolder{
        ImageView iv_recommend;
        TextView tv_name;
        TextView tv_price;
    }
}
