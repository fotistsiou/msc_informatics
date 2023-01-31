package com.unipi.android.mathima6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    // Thread
    public void go1(View view) {
        // textView.setText("Hi");
        new Thread(new Runnable() {
            @Override
            public void run() {
                //textView.setText("Hi");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Hi");
                    }
                });
            }
        }).start();
    }

    // Timer
    public void go2(View view) {
        CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
            int countDown = 10;
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(String.valueOf(countDown));
                //textView.setText(String.valueOf(millisUntilFinished));
                countDown--;
            }

            @Override
            public void onFinish() {
                textView.setText("Finished!");
            }
        };
        countDownTimer.start();
    }

    // Custom Timer
    public void go3(View view) {
        new Thread(new Runnable() {
                @Override
                public void run() {
                    final int[] customCountDown = {10};
                    for (int i = 0; i <= 10; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(String.valueOf(customCountDown[0]));
                                customCountDown[0]--;
                            }
                        });
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("Finished!");
                        }
                    });
                }
        }).start();
    }

    // Notifications
    public void go4(View view) {
        NotificationChannel channel =
                new NotificationChannel("123", "Unipi Channel", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "123");
        builder.setContentTitle("Message from Unipi")
                .setContentText("You are having exams tomorrow!")
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true);
        notificationManager.notify(1,builder.build());
    }

    // Service
    public void go5(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }
}