package com.unipi.android.mathima2_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        password = findViewById(R.id.editTextTextPersonName);
    }

    public void check_pass(View view){
        if (password.getText().toString().equals("1234")) {
            Intent intent = new Intent(this,MainActivity2.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Wrong Password!", Toast.LENGTH_LONG).show();
        }
    }
}