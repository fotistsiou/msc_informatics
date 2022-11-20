package com.unipi.android.mathima2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // textView2
        // Select "textView2" control.
        // Create "intent" object of this activity with info from "intent" object of previous activity.
        // Define dataReceived variable and assign value from "mykey1" indexer of "intent" of previous activity.
        // Set textView2 text with value from "mykey1" indexer.
        textView2 = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String dataReceived = intent.getStringExtra("mykey1");
        textView2.setText(dataReceived);
    }
}