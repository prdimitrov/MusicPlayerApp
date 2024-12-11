package com.example.musicplayerapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyCustomService extends Service {
    //MediaPlayer needed in order to play the music
    private MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //This will play the audio of default ringtone in the device
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);

        if (player == null) {
            // Handle the case where MediaPlayer creation failed
            Log.e("MyCustomService", "Failed to initialize MediaPlayer. Default ringtone not found.");
            stopSelf();
            return START_NOT_STICKY;
        }

        Log.d("MyCustomService", "MediaPlayer initialized successfully.");

        //Play the ringtone audio on loop (continuously)
        player.setLooping(true);
        player.start();

        Log.d("MyCustomService", "MediaPlayer started playing the ringtone.");

        //START_NOT_STICKY can be used for running services that
        //perform specific tasks and don't need to be running continuously!
//        return START_NOT_STICKY;
        Toast.makeText(this, "Playing ringtone...", Toast.LENGTH_SHORT).show();
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