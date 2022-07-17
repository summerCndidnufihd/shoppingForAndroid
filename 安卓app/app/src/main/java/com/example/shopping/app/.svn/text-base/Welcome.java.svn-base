package com.example.shopping.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.shopping.R;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //2秒钟进入主页面
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                //在主线程中执行，启动主页面
                startActivity(new Intent(Welcome.this, MainActivity.class));
                //关闭欢迎页面
                finish();
            }
        },2000);
    }
}