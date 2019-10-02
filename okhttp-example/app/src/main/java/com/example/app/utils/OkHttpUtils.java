package com.example.app.utils;

// 单例

import com.example.app.interceptor.LogInterceptor;

import java.lang.reflect.Field;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class OkHttpUtils {

    private static final OkHttpUtils okhttpUtils = new OkHttpUtils();

    private OkHttpUtils() {
    }

    private OkHttpClient client;

    public static OkHttpUtils getInstance() {
        return okhttpUtils;
    }

    public synchronized OkHttpClient getClient() {
        if (client == null) {
            synchronized (OkHttpUtils.class) {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();


                builder.connectTimeout(5, TimeUnit.SECONDS);
                builder.readTimeout(5, TimeUnit.SECONDS);
                builder.writeTimeout(5, TimeUnit.SECONDS);

                // 添加拦截器
                builder.addInterceptor(new LogInterceptor());

                client = builder.build();
            }
        }
        return client;
    }
}
