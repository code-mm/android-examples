package com.example.apk_communication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MyReceiver receiver = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.apk_communication.MyReceiver");
        registerReceiver(receiver, intentFilter);

        ComponentName componetName = new ComponentName(
                //这个是另外一个应用程序的包名
                "com.example.app2",
                //这个参数是要启动的Activity
                "com.example.app2.MainActivity");
        Intent intent = new Intent();

        intent.setComponent(componetName);
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(receiver);
    }
}
