package com.example.shopping.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 基类：
 * 首页：HomeFragment
 * 分类：TypeFragment
 * 发现：CommunityFragment
 * 购物车：ShoppingCartFragment
 * 用户中心：UserFragemnt
 * 等都要继承BaseFragment
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return initView();
    }

    /**
     * 抽象方法：不能有方法实体，由孩子类去实现不同的效果（body）
     * @return
     */
    public abstract View initView() ;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 初始化数据
     */
    public void initData(){}

}
