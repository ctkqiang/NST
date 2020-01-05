package com.starlabbioscience.nst;
/*
 * 주의 와 메모리를위한 소프트웨어입니다. 그
 * 것은 나쁜 생각이지만 어쨌든 그것을하고,
 * 나는 상사가 아니에요 :)
 */

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

/**
 * @AUTHOR : JOHN MELODY ME
 * @COPYRIGHT : BRAINTECH SDN BHD || STARLABS BIOSCIENCE SDN BHD
 * @PROJECT: NST
 * @DATE_STARTED: 2 JANUARY 2020
 */

public class MUSICPLAYER extends AppCompatActivity {

    MediaPlayer A, M;
    Button ATTENTION, MEMORY;
    AlertDialog.Builder alertdialogbuilder;
    FirebaseAuth FIREBASEAUTH;

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public void onBackPressed(){
        //super.onBackPressed();
        alertdialogbuilder = new AlertDialog.Builder(this);
        alertdialogbuilder.setMessage("Sign Out?");
        alertdialogbuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FIREBASEAUTH.signOut();
                finish();
            }
        });
        alertdialogbuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alertDialog;
        alertDialog = alertdialogbuilder.create();
        alertDialog.show();
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

        FIREBASEAUTH = FirebaseAuth.getInstance();

        A = MediaPlayer.create(MUSICPLAYER.this, R.raw.attention);
        A.setAudioStreamType(AudioManager.STREAM_MUSIC);
        A.setVolume(0b1010000, 0b1010000);
        M = MediaPlayer.create(MUSICPLAYER.this, R.raw.memory);
        M.setAudioStreamType(AudioManager.STREAM_MUSIC);
        M.setVolume(0b1010000, 0b1010000);

        ATTENTION.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (A.isPlaying()) {
                    ATTENTION.setBackgroundResource(R.mipmap.atention);
                    A.pause();
                } else {
                    if (M.isPlaying()){
                        MEMORY.setBackgroundResource(R.mipmap.mmemory);
                        M.pause();
                    } else {
                        ATTENTION.setBackgroundResource(R.mipmap.attentionplay);
                        A.start();
                    }
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
                    if(A.isPlaying()){
                        ATTENTION.setBackgroundResource(R.mipmap.atention);
                        A.pause();
                    } else {
                        MEMORY.setBackgroundResource(R.mipmap.mmemory_playingime);
                        M.start();
                    }
                }
            }
        });
    }
}