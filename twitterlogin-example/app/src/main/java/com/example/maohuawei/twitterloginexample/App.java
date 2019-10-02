package com.example.maohuawei.twitterloginexample;

import android.app.Application;
import android.util.Log;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("R9XBPB9RHSk7lAqgulLQqwXm6", "HAb6pVMwZgb2FXVShBwm9WNZSNAaG4CpTlnu41fIvuztwjaiIe"))
                .debug(true)
                .build();
        Twitter.initialize(config);
        Twitter.initialize(this);


    }
}
