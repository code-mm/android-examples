package com.example.apk_communication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {


        Log.e(TAG, "onReceive: ");
        int res = intent.getIntExtra("res", 0);

        Log.e(TAG, res + "");

    }
}
