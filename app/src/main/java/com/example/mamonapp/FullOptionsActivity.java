package com.example.mamonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class FullOptionsActivity extends AppCompatActivity {

    TextView testText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_options);


        testText = (TextView)findViewById(R.id.textRes);

        Intent intent = getIntent();
        String str = intent.getStringExtra("textR");
        testText.setText(str);
    }
}