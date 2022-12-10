package com.unipi.android.mathima3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText inputData;
    SharedPreferences preferences;
    String color = "yellow";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        inputData = findViewById(R.id.editTextTextPersonName2);
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        if (preferences.contains("myKey1") && !preferences.getString("myKey1", "No data yet...").isEmpty()) {
            color = preferences.getString("myKey1", "No data yet...");
        }
        getWindow().getDecorView().setBackgroundColor(Color.parseColor(color));
    }

    public void write(View view) {
        if (!inputData.getText().toString().isEmpty()) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("myKey1", inputData.getText().toString());
            editor.apply();
            color = preferences.getString("myKey1", "No data yet...");
            getWindow().getDecorView().setBackgroundColor(Color.parseColor(color));
            Toast.makeText(this, "Color saved!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You need to write some color first...", Toast.LENGTH_SHORT).show();
        }
    }
}