# Twitter 登陆集成 #



----------

## 地址

[https://github.com/twitter/twitter-kit-android/wiki](https://github.com/twitter/twitter-kit-android/wiki)



## Demo地址

[https://github.com/m-maohuawei/TwitterLoginExample](https://github.com/m-maohuawei/TwitterLoginExample)


## 效果


![](https://i.imgur.com/tHN9co4.gif)


## 集成过程


### 添加依赖



        implementation 'com.twitter.sdk.android:twitter-core:3.1.1'


## 初始化

        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                //自己的 CONSUMERKEY  CONSUMERSECRET
                .twitterAuthConfig(new TwitterAuthConfig("R9XBPB9RHSk7lAqgulLQqwXm6", "HAb6pVMwZgb2FXVShBwm9WNZSNAaG4CpTlnu41fIvuztwjaiIe"))
                .debug(true)
                .build();
        Twitter.initialize(config);
        Twitter.initialize(this);


## 添加权限


    <uses-permission android:name="android.permission.INTERNET" />



## 布局文件


    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context=".MainActivity">
    
    
        <com.twitter.sdk.android.core.identity.TwitterLoginButton
            android:id="@+id/login_twitter"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    
    
        <TextView
            android:id="@+id/tv_username"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    
        <TextView
            android:id="@+id/tv_userid"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    
    
        <TextView
            android:id="@+id/tv_token"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    
        <TextView
            android:id="@+id/tv_secret"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />
    
    
    </LinearLayout>



## 代码文件

    
    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.util.Log;
    import android.widget.TextView;
    
    import com.twitter.sdk.android.core.Callback;
    import com.twitter.sdk.android.core.Result;
    import com.twitter.sdk.android.core.TwitterAuthToken;
    import com.twitter.sdk.android.core.TwitterException;
    import com.twitter.sdk.android.core.TwitterSession;
    import com.twitter.sdk.android.core.identity.TwitterLoginButton;
    
    public class MainActivity extends AppCompatActivity {
    
    
        private static final String TAG = "MainActivity";
        TwitterLoginButton login_twitter;
        private TextView tv_username;
        private TextView tv_userid;
        private TextView tv_token;
        private TextView tv_secret;
    
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
    
            login_twitter = findViewById(R.id.login_twitter);
            tv_username = findViewById(R.id.tv_username);
            tv_userid = findViewById(R.id.tv_userid);
            tv_token = findViewById(R.id.tv_token);
            tv_secret = findViewById(R.id.tv_secret);
    
    
            login_twitter.setCallback(new Callback<TwitterSession>() {
                @Override
                public void success(Result<TwitterSession> result) {
    
    
                    /**********************************************************************
                     *
                     * 获取Token 方式一
                     *
                     ***********************************************************************/
    //                TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
    //                TwitterAuthToken authToken = session.getAuthToken();
    //                String token = authToken.token;
    //                String secret = authToken.secret;
    //
    //                Log.e(TAG, "token: " + token);
    //                Log.e(TAG, "secret: " + secret);
    
    
                    /**********************************************************************
                     *
                     * 获取Token 方式二
                     *
                     ***********************************************************************/
    
                    TwitterSession data = result.data;
                    long userId = data.getUserId();
                    String userName = data.getUserName();
                    TwitterAuthToken authToken = data.getAuthToken();
                    String token = authToken.token;
                    String secret = authToken.secret;
    
                    tv_userid.setText("userId :" + userId);
                    tv_username.setText("userName :" + userName);
                    tv_token.setText("token :" + token);
                    tv_secret.setText("secret :" + secret);
    
    
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
    
    
## 可以获取的数据


- 用户名
- 用户ID
- Token
- secret




    
    

