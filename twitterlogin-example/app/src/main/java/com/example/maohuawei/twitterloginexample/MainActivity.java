package com.example.maohuawei.twitterloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    TwitterLoginButton login_twitter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_twitter = findViewById(R.id.login_twitter);


        login_twitter.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {


                TwitterSession data = result.data;
                long userId = data.getUserId();
                String userName = data.getUserName();
                TwitterAuthToken authToken = data.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;


                Log.e(TAG, "Thread: " + Thread.currentThread().getName());

                Log.e(TAG, "userName: " + userName);
                Log.e(TAG, "userId: " + userId);
                Log.e(TAG, "token: " + token);
                Log.e(TAG, "secret: " + secret);

            }

            @Override
            public void failure(TwitterException exception) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        login_twitter.onActivityResult(requestCode, resultCode, data);
    }
}
