package com.example.animationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation animation;
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animation_demo);
        TextView textView = findViewById(R.id.textViewDemo);
        textView.startAnimation(animation);
    }
}