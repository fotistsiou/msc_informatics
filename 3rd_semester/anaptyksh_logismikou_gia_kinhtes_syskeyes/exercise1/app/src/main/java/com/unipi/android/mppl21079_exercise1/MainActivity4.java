package com.unipi.android.mppl21079_exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void act4_button1_click(View view) {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }

    public void act4_button2_click(View view) {
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }

    public void act4_button3_click(View view) {
        Intent intent = new Intent(this, MainActivity7.class);
        startActivity(intent);
    }

    public void act4_button4_click(View view) {
        Intent intent = new Intent(this, MainActivity8.class);
        startActivity(intent);
    }
}