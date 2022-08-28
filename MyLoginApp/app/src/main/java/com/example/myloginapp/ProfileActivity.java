package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private TextView username;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String textUsername = extras.getString("username");
            String textPassword = extras.getString("password");
            username.setText(textUsername);
            password.setText(textPassword);
        }
    }
}