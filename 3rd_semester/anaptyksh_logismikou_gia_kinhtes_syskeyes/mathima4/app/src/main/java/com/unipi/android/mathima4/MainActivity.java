package com.unipi.android.mathima4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    // Firebase Realtime Database
    EditText inputData;
    TextView outputData;
    FirebaseDatabase database;
    DatabaseReference reference;

    // Audio Functionality | Use of custom class MyTSS
    MyTTS myTTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Firebase Realtime Database
        inputData = findViewById(R.id.editTextTextPersonName);
        outputData = findViewById(R.id.textView);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("message");

        // Audio Functionality
        myTTS = new MyTTS(this);
    }

    // Firebase Realtime Database | Write Method
    public void write(View view){
        if (!inputData.getText().toString().isEmpty()) {
            reference.setValue(inputData.getText().toString());
        } else {
            Toast.makeText(this, "Please write something first!", Toast.LENGTH_SHORT).show();
        }
    }

    // Firebase Realtime Database | Read Method with Event | addListenerForSingleValueEvent
    public void read(View view) {
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                outputData.setText(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                outputData.setText(error.getMessage());
            }
        });
    }

    // Firebase Realtime Database | Read Method without Event | addValueEventListener
    public void readAlways(View view) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Concatenate messages with use outputData values before and after create new message
                outputData.setText(outputData.getText().toString() + '\n' + snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                outputData.setText(error.getMessage());
            }
        });
    }

    // Audio Functionality | Speech Method with Event | addListenerForSingleValueEvent
    public void speech(View view) {
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                myTTS.speak(snapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                outputData.setText(error.getMessage());
            }
        });
    }
}