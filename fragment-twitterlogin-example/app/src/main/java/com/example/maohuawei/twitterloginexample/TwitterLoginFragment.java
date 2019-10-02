package com.example.maohuawei.twitterloginexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class TwitterLoginFragment extends Fragment {


    private static final String TAG = "TwitterLoginFragment";

    private TwitterLoginButton login_twitter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_twitterlogin, container, false);

        login_twitter = view.findViewById(R.id.login_twitter);


        ;
        login_twitter.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {

                Log.e(TAG, "success: ");


                TwitterSession data = result.data;


                long userId = data.getUserId();
                String userName = data.getUserName();
                TwitterAuthToken authToken = data.getAuthToken();
                String token = authToken.token;
                String secret = authToken.secret;


                Log.e(TAG, "success: userId" + userId);
                Log.e(TAG, "success: userName" + userName);
                Log.e(TAG, "success: token" + token);
                Log.e(TAG, "success: secret " + secret);


            }

            @Override
            public void failure(TwitterException exception) {

                Log.e(TAG, "failure: ");

            }
        });
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        login_twitter.onActivityResult(requestCode, resultCode, data);
    }


}
