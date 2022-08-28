package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private EditText username;
    private EditText password;
    private Button buttonLogin;
    private String textUsername;
    private String textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.btn_login);
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textUsername = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                textPassword = s.toString();
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(textUsername);
                if(textUsername.length() > 0 && textPassword.length() > 0) {
                    Intent intent = new Intent(MainActivity.this, NewFeedActivity.class);
                    intent.putExtra("username", textUsername);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Username or password invalid", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}