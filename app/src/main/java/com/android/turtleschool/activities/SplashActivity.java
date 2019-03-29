package com.android.turtleschool.activities;

import android.content.Intent;
import android.os.Bundle;

import com.android.turtleschool.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            finish();
        }).start();
    }
}
