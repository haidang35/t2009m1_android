package com.example.sharedpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class DemoPreActivity extends AppCompatActivity{
    private EditText edName, edAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_pre);

        edName = findViewById(R.id.edit_text_name);
        edAge= findViewById(R.id.edit_text_age);
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sh = getSharedPreferences("MySharedPre", MODE_PRIVATE);
        String s1 = sh.getString("name", "");
        int a = sh.getInt("age", 0);

        edName.setText(s1);
        edAge.setText(String.valueOf(a));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPre", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        myEdit.putString("name", edName.getText().toString());
        myEdit.putInt("age", Integer.parseInt(edAge.getText().toString()));
        myEdit.apply();
    }
}