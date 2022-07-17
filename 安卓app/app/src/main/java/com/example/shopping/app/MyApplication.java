package com.example.shopping.app;

import android.app.Application;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;


public class MyApplication extends Application {
    @Override
    public void onCreate()
    {
        super.onCreate();
        //初始化网络请求OKHttpUtils
        initOkhttpClient();


    }
    private void initOkhttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)//链接超时
                .readTimeout(10000L, TimeUnit.MILLISECONDS)//读取超时
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
