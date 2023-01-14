package com.unipi.android.mathima5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Sensors
    TextView textView2;
    SensorManager sensorManager;
    Sensor sensor1, sensor2;
    SensorEventListener gyroscopeListener, lightListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sensors
        textView2 = findViewById(R.id.textView2);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor1 = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensor2 = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        gyroscopeListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                textView2.setText(String.valueOf(sensorEvent.values[0]));
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        lightListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                textView2.setText(String.valueOf(sensorEvent.values[0]));
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
    }

    void showMessage(String title, String message){
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(true).show();
    }

    // Recognize
    // Open default speak recognizer android app
    public void go1(View view) {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Please say something");
        startActivityForResult(intent, 123);
    }

    // Recognize
    // Override onActivityResult method in order to handle the data of recognize
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check for requestCode (from go1 method) and resultCode (RESULT_OK = successful recognition)
        if (requestCode == 123 && resultCode == RESULT_OK) {
            // Collect recognize result in an ArrayList
            ArrayList<String> recognizeResult = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            // Show recognize result with use showMessage function
            showMessage("Recognize Speech", recognizeResult.toString());

            // Use recognize result in order to change background color
            if (recognizeResult.contains("red")) {
                getWindow().getDecorView().setBackgroundColor(Color.parseColor("red"));
            }

            // Use recognize result in order to redirect to "Settings" or "University Activity"
            if (recognizeResult.contains("settings")) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
            if (recognizeResult.contains("University")) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        }
    }

    // Sensor | Gyroscope
    public void go2(View view) {
        // Start listener
        sensorManager.registerListener(gyroscopeListener,sensor1,SensorManager.SENSOR_DELAY_NORMAL);
        // Stop listener
        // sensorManager.unregisterListener(gyroscopeListener);
    }
    // Sensor | Light
    public void go3(View view) {
        // Start listener
        sensorManager.registerListener(lightListener,sensor2,SensorManager.SENSOR_DELAY_NORMAL);
        // Stop listener
        // sensorManager.unregisterListener(lightListener);
    }
}