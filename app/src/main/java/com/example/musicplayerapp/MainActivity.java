package com.example.musicplayerapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button startButton, stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            startButton = findViewById(R.id.startButton);
            stopButton = findViewById(R.id.stopButton);
            txt = findViewById(R.id.textView);

            startButton.setOnClickListener(v1 -> {
                Intent serviceIntent = new Intent(getApplicationContext(), MyCustomService.class);
                startService(serviceIntent);
            });

            stopButton.setOnClickListener(v2 -> {
                Intent serviceIntent = new Intent(getApplicationContext(), MyCustomService.class);
                stopService(serviceIntent);
            });

            return insets;
        });
    }
}