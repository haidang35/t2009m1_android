package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_layout);

//        List<String> listItems = new ArrayList<>();
//        listItems.add("DEMO ITEM 1");
//        listItems.add("DEMO ITEM 2");
//        listItems.add("DEMO ITEM 3");
//
//        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_view_layout,listItems);
//        ListView listView = (ListView) findViewById(R.id.listViewDemo);
//        listView.setAdapter(adapter);

        //B1: Data source
        final String[] datas = {"SAMSUNG","LG","HTC","SONY","NOKIA","SAMSUNG",
                "LG","HTC","SONY","NOKIA","SAMSUNG","LG","HTC","SONY",
                "NOKIA","SAMSUNG","LG","HTC","SONY","NOKIA"};

        //B2: Adapter  anhth.na

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, datas);

        //B3: Listview
        ListView lvContact = findViewById(R.id.listViewDemo);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String data = datas[position];
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}