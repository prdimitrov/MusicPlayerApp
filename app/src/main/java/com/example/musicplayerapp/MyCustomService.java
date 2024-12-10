package com.example.musicplayerapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MyCustomService extends Service {
    //MediaPlayer needed in order to play the music
    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //This will play the audio of default ringtone in the device
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        //Play the ringtone audio on loop (continuously)
        player.setLooping(true);

        //START_NOT_STICKY can be used for running services that
        //perform specific tasks and don't need to be running continuously!
//        return START_NOT_STICKY;
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        player.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}