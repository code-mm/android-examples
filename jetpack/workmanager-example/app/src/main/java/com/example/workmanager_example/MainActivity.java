package com.example.workmanager_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)

                // 不在电量不足时执行
                .setRequiresBatteryNotLow(false)
                // 在充电时执行
                .setRequiresCharging(true)
                // 不在存储容量不足时执行
                .setRequiresStorageNotLow(false)

                // 在待机状态下执行，需要 API 23
                // .setRequiresDeviceIdle(true)
                .build();

        //意味着这个任务只需执行一遍
        final OneTimeWorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(ExampleWorker.class)
                .setConstraints(constraints)
                .setInputData(new Data.Builder().putString("k", "Hello").build())
                .build();
        //将 WorkRequest 加入任务队列

        WorkManager.getInstance(this).enqueue(uploadWorkRequest);

        //获取LiveData 观察数据
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(uploadWorkRequest.getId()).observeForever(new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {

                String v = workInfo.getOutputData().getString("k");

                Log.e(TAG, "onChanged: " + v);
                if (v != null) {
                    Toast.makeText(MainActivity.this, "" + v, Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
