package com.unipi.android.mathima1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // "onCreate" method override
    // "onCreate" method in Android is like as "onLoad" method in C#
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // super = We refer to the mother class.
        // super.onCreate(savedInstanceState) = inherit functionality from mother method and extend it
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // "onCreate" method override
    @Override
    protected void onPause() {
        super.onPause();
    }

    // Activity Lifecycle
    // https://stuff.mit.edu/afs/sipb/project/android/docs/images/activity_lifecycle.png
}