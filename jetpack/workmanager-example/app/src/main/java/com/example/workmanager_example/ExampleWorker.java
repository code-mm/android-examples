package com.example.workmanager_example;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ExampleWorker extends Worker {

    private static final String TAG = "ExampleWorker";

    public ExampleWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        String k = getInputData().getString("k");

        Log.e(TAG, "doWork: " + k);

        for (int i = 0; i <= 5; i++) {
            SystemClock.sleep(1000);
            Log.e(TAG, "doWork: " + i);
        }

        return Result.success(new Data.Builder().putString("k", "World ").build());
    }
}