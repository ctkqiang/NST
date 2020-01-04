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


    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.Attention:
                A = MediaPlayer.create(MUSICPLAYER.this, R.raw.gta);
                A.setAudioStreamType(AudioManager.STREAM_MUSIC);
                A.setVolume(0b1010000, 0b1010000);
                A.setLooping(false);
                if (A.isPlaying()){
                    A.pause();
                    A.stop();
                    A.release();
                    ATTENTION.setBackgroundResource(R.mipmap.atention);
                } else {
                    A.start();
                    ATTENTION.setBackgroundResource(R.mipmap.attentionplay);
                }

                if (!A.isPlaying()){
                    ATTENTION.setBackgroundResource(R.mipmap.atention);
                } else {
                    System.out.println("NOPE");
                }
                break;

            case R.id.Memory:
                M = MediaPlayer.create(MUSICPLAYER.this, R.raw.gta);
                M.setAudioStreamType(AudioManager.STREAM_MUSIC);
                M.setVolume(0b1010000, 0b1010000);
                M.setLooping(false);
                if (M.isPlaying()){
                    M.pause();
                    MEMORY.setBackgroundResource(R.mipmap.mmemory);
                } else {
                    M.start();
                    MEMORY.setBackgroundResource(R.mipmap.mmemory_playingime);
                }
                break;
        }
    }
}