package com.example.user.geotask;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.user.geotask.screen.baseContainerActivity.BaseContainerActivity;

/**
 * Created by User on 16.07.2017.
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, BaseContainerActivity.class);
        startActivity(intent);
        finish();
    }
}
