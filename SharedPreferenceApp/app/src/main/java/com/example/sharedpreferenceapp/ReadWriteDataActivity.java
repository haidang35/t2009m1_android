package com.example.sharedpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteDataActivity extends AppCompatActivity {
    private EditText editText;
    private final String FILE_NAME = "my_text.txt";
    private final int READ_BLOCK_SIZE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_write_data);
        editText = findViewById(R.id.edit_text_main);
    }

    public void writeToFile(View view) {
            try {
                FileOutputStream fileOutputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.write(editText.getText().toString());
                outputStreamWriter.close();
                Toast.makeText(getBaseContext(), "File saved successfully", Toast.LENGTH_SHORT).show();
            }catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void readFile(View view) {
        try {
            FileInputStream fileInputStream = openFileInput(FILE_NAME);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            char[] inputBuffer = new char[READ_BLOCK_SIZE];
            String s = "";
            int charRead;
            while((charRead = inputStreamReader.read(inputBuffer)) > 0) {
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                s += readString;
            }
            inputStreamReader.close();
            editText.setText(s);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}