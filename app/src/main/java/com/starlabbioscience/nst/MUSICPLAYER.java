package com.starlabbioscience.nst;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

/**
 * @AUTHOR : JOHN MELODY ME
 * @COPYRIGHT : BRAINTECH SDN BHD || STARLABS BIOSCIENCE SDN BHD
 * @PROJECT: NST
 * @DATE_STARTED: 2 JANUARY 2020
 */

public class MUSICPLAYER extends AppCompatActivity {

    MediaPlayer A, M;
    Button ATTENTION, MEMORY;

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onPause(){
        super.onPause();
        A.stop();
        M.stop();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ATTENTION = findViewById(R.id.Attention);
        MEMORY = findViewById(R.id.Memory);

        A = MediaPlayer.create(MUSICPLAYER.this, R.raw.somethingsomething);
        A.setAudioStreamType(AudioManager.STREAM_MUSIC);
        A.setVolume(0b1010000, 0b1010000);
        M = MediaPlayer.create(MUSICPLAYER.this, R.raw.temporary);
        M.setAudioStreamType(AudioManager.STREAM_MUSIC);
        M.setVolume(0b1010000, 0b1010000);

        ATTENTION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A.isPlaying()) {
                    ATTENTION.setBackgroundResource(R.mipmap.atention);
                    A.pause();
                } else {
                    ATTENTION.setBackgroundResource(R.mipmap.attentionplay);
                    A.start();
                }
            }
        });

        MEMORY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (M.isPlaying()){
                    MEMORY.setBackgroundResource(R.mipmap.mmemory);
                    M.pause();
                } else {
                    MEMORY.setBackgroundResource(R.mipmap.mmemory_playingime);
                    M.start();

                }
            }
        });
    }
}