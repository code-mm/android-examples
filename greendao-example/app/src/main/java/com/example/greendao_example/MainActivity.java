package com.example.greendao_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "mta-db");
        daoSession = new DaoMaster(devOpenHelper.getWritableDb()).newSession();


        User user = new User();

        user.setName("ms1");
        user.setAge(12);
        user.setSex("man");
        user.setCity("sxlffx");

        daoSession.getUserDao().insert(user);

    }
}
