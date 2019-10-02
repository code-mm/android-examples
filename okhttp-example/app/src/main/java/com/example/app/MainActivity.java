package com.example.app;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.utils.OkHttpUtils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // 基本使用

        // example1();

        // 工具类

        OkHttpUtils.getInstance().getClient().newCall(new Request.Builder().url("http://www.baidu.com/").build()).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {



            }
        });




    }

    private void example1() {

        // 创建okhttp 客户端
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();


        okHttpClient.newCall(new Request.Builder().url("http://www.baidu/com").post(RequestBody.create("".getBytes())).build());


        // 请求Call
        final Call call = okHttpClient.newCall(new Request.Builder().url("http://www.baidu.com/").get().build());


        new Thread(new Runnable() {
            @Override
            public void run() {

                // 同步请求
                try {
                    Response execute = call.execute();

                    int code = execute.code();

                    String string = execute.body().string();


                    Log.e(TAG, "run: code " + code);
                    Log.e(TAG, "run: body " + string);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


        // 异步请求
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//
//                if (response.isSuccessful()) {
//
//
//                    Log.e(TAG, "onResponse: " + response.code());
//
//                    Log.e(TAG, "onResponse: " + response.body().string());
//
//
//                }
//
//
//            }
//        });
    }
}
