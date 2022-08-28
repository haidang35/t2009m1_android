package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactActivity extends AppCompatActivity {
    private static List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initData();
        ContactAdapter contactAdapter = new ContactAdapter(this, users);
        ListView lvContact  = findViewById(R.id.listContact);
        lvContact.setAdapter(contactAdapter);
    }

    public void initData() {
        Integer[] imageIds = {R.drawable.user_icon_1, R.drawable.user_icon_2,
                R.drawable.user_icon_3, R.drawable.user_icon_4, R.drawable.user_icon_5};
        for(int i=1; i <= 10; i++) {
            users.add(new User(imageIds[getRandomNumberUsingNextInt(0, imageIds.length - 1)], "User" + i, "03566666666"));
        }
    }

    public int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}