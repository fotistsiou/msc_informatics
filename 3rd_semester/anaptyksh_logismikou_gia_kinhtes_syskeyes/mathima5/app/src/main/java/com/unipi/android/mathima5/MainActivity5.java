package com.unipi.android.mathima5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {
    EditText recipient_number, text_message;
    SmsManager smsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        recipient_number = findViewById(R.id.editTextTextPersonName);
        text_message = findViewById(R.id.editTextTextMultiLine);
        smsManager = SmsManager.getDefault();
    }

    public void go4(View view) {
        if (!recipient_number.getText().toString().isEmpty() && !text_message.getText().toString().isEmpty()) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 123);
            } else {
                smsManager.sendTextMessage(recipient_number.getText().toString(), null,
                        text_message.getText().toString(), null, null);
                Toast.makeText(this, "Message is sent", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter all required data...!", Toast.LENGTH_SHORT).show();
        }
    }
}