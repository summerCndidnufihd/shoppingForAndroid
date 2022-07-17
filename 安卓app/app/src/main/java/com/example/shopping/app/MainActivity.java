package com.example.shopping.app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.shopping.Cart.CartFragment;
import com.example.shopping.R;
import com.example.shopping.base.BaseFragment;
import com.example.shopping.community.Fragment.CommunityFragment;
import com.example.shopping.home.Fragment.HomeFragment;
import com.example.shopping.type.fragment.TypeFragment;
import com.example.shopping.user.fragment.UserFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    //声明列表
    ArrayList<BaseFragment> fragments;
    //定义所处fragment的位置
    int position;
    //定义上一次的fragment
    BaseFragment tempFragment;


    //View注入
    @Bind(R.id.frameLayout)
    FrameLayout frameLayout;
//    @Bind(R.id.rg_main)
//    RadioGroup rgMain;
    RadioGroup radioGroup;
    @Bind(R.id.rb_home)
    RadioButton rbHome;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Butterknife和当前的Activity绑定
        ButterKnife.bind(this);

        //********* 1. 初始化fragment，添加到数组
        initFragment();

        //********* 2. 对RadioGroup按钮设置监听
        radioGroup= (RadioGroup)findViewById(R.id.rg_main);
        radioGroup.setOnCheckedChangeListener(this);

        //********* 3. 默认进入app显示首页Activity
//        radioGroup.check(R.id.rb_home);//无法默认显示，不显示首页内容
        //进入app直接切换首页fragment
        BaseFragment baseFragment = getFragment(0);//获取切换fragment
        switchFragment(tempFragment, baseFragment);//切换fragment
    }

    /**
     * 讲所有fragment子类装入数组列表
     */
    private void initFragment() {
        fragments= new ArrayList<>();
        //顺序不能乱，后面position要用到索引
        fragments.add(new HomeFragment());
        fragments.add(new TypeFragment());
        fragments.add(new CommunityFragment());
        fragments.add(new CartFragment());
        fragments.add(new UserFragment());
    }
    /**
     * 获取fragments中的每一个Fragment，取索引
     */
    private BaseFragment getFragment(int position){
        if (fragments != null && fragments.size() > 0) {
            BaseFragment baseFragment = fragments.get(position);//position表示索引,从数组中获取
            return baseFragment;
        }
        return null;
    }

    /**
     * 切换Fragment*************
     */
    private void switchFragment(Fragment fromFragment, BaseFragment
            nextFragment) {
        if (tempFragment != nextFragment) {
            tempFragment = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction =
                        getSupportFragmentManager().beginTransaction();
                //判断 nextFragment 是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前 Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    //隐藏当前 Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        } }

    /**
     * 给radioGroup绑定点击事件，根据position的值获取数组中的fragment
     * @param radioGroup
     * @param i
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.rb_home://主页
                position = 0;
                break;
//            case R.id.rb_type://分类
//                position = 1;
//                break;
            case R.id.rb_community:
                position = 2;
                break;
            case R.id.rb_cart:
                position = 3;
                break;
            case R.id.rb_user:
                position = 4;
                break;
        }
        BaseFragment baseFragment = getFragment(position);//获取切换fragment
        switchFragment(tempFragment, baseFragment);//切换fragment
    }
}