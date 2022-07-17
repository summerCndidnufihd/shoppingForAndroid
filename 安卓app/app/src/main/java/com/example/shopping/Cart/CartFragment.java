package com.example.shopping.Cart;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.shopping.base.BaseFragment;


/**
 * 主页面
 */
public class CartFragment extends BaseFragment {

    private TextView textView;

    @Override
    public View initView() {
//        Log(TAG,"社区页面初始化！");
        //初始化页面
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initData() {
//        super.initData();
        textView.setText("主页");
    }
}
