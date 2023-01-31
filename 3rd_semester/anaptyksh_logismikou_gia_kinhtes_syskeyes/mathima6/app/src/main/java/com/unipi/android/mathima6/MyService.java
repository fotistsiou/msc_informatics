package com.unipi.android.mathima6;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        MediaPlayer player = MediaPlayer.create(this, R.raw.ringtone);
        CountDownTimer countDownTimer = new CountDownTimer(4000, 4000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                player.start();
            }
        };
        countDownTimer.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}