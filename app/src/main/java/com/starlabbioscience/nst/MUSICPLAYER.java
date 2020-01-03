package com.starlabbioscience.nst;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
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

    MediaPlayer NST;
    Button ATTENTION, MEMORY;

    @Override
    public void onStart(){
        super.onStart();
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
                NST = MediaPlayer.create(MUSICPLAYER.this, R.raw.gta);
                NST.setAudioStreamType(AudioManager.STREAM_MUSIC);
                NST.setVolume(0b1010000, 0b1010000);
                NST.setLooping(false);
                if (NST.isPlaying()){
                    NST.pause();
                    ATTENTION.setBackgroundResource(R.mipmap.atention);
                    ATTENTION.setBackgroundResource(R.mipmap.attentionplay);
                } else {
                    NST.start();
                    ATTENTION.setBackgroundResource(R.mipmap.attentionplay);
                    ATTENTION.setBackgroundResource(R.mipmap.atention);
                }
                break;

            case R.id.Memory:
                NST = MediaPlayer.create(MUSICPLAYER.this, R.raw.gta);
                NST.setAudioStreamType(AudioManager.STREAM_MUSIC);
                NST.setVolume(0b1010000, 0b1010000);
                NST.setLooping(false);
                if (NST.isPlaying()){
                    NST.pause();
                    MEMORY.setBackgroundResource(R.mipmap.mmemory);
                    MEMORY.setBackgroundResource(R.mipmap.mmemory_playingime);
                } else {
                    NST.start();
                    MEMORY.setBackgroundResource(R.mipmap.mmemory_playingime);
                    for (int loop = 0b0; loop < 0b101; loop++){
                        System.out.println("---");
                    }
                    MEMORY.setBackgroundResource(R.mipmap.mmemory_playingime);
                    MEMORY.setBackgroundResource(R.mipmap.mmemory);

                }
                break;
        }
    }
}