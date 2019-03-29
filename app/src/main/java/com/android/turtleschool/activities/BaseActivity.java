package com.android.turtleschool.activities;

import android.graphics.Color;
import android.os.Bundle;

import com.android.turtleschool.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        float[] hsv = new float[3];
        Color.colorToHSV(getResources().getColor(R.color.colorGreen), hsv);
        hsv[2] *= 0.8f; // value component
        getWindow().setStatusBarColor(Color.HSVToColor(hsv));
    }
}
