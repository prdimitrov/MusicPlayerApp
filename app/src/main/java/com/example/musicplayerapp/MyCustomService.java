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

        //Play the ringtone audio on loop (continously)
        player.setLooping(true);

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
