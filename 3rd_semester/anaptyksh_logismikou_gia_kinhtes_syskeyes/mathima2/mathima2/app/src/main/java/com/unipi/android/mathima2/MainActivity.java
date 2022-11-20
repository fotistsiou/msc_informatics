package com.unipi.android.mathima2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // textView
        // Select "textView" control and set the text to "Hello Unipi"
        textView = findViewById(R.id.textView);
        textView.setText("Hello Unipi!");

        // editText
        editText = findViewById(R.id.editTextTextPersonName);

        // button
        // 1st method onClick event
        button = findViewById(R.id.button);
        // onClick with "Anonymous Object"
        button.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textView.setText("Button clicked!");
                }
            }
        );
        // onClick with "Lambda Expression"
        // button.setOnClickListener(view -> textView.setText("Button clicked!"));
    }

    // button2
    // 2nd method onClick event
    // Add "go1" onClick event from attributes layout of activity_main.xml
    // View = mother "class" of all "UI Controls"
    // "View view" parameter = whatever event from UI Control
    public void go2(View view){
        // Toast = pop up message
        Toast.makeText(this, "Students of Informatics!", Toast.LENGTH_LONG).show();
    }

    // button3
    public void go3(View view){
        // Give the text from "editText" control to "textView" control
        textView.setText(editText.getText().toString());
    }

    // button4
    public void go4(View view){
        // An Intent provides a facility for performing late runtime binding between the code in different applications.
        // Its most significant use is in the launching of activities, where it can be thought of as the glue between activities.
        // It is basically a passive data structure holding an abstract description of an action to be performed.
        Intent intent = new Intent(this,MainActivity2.class);
        // Sent data step 1
        String dataToSent = editText.getText().toString();
        // Sent data step 2
        intent.putExtra("mykey1", dataToSent);
        // Open the activity of "intent" object, which contain all info of this activity.
        startActivity(intent);
    }

    // button5
    // Give dangerous permissions, which has defined on AndroidManifest.xml
    public void permission(View view){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);
        } else {
            Toast.makeText(this, "You already have this permission..!", Toast.LENGTH_SHORT).show();
        }
    }
}