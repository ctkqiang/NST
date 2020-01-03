package com.starlabbioscience.nst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * @AUTHOR : JOHN MELODY ME
 * @COPYRIGHT : BRAINTECH SDN BHD || STARLABS BIOSCIENCE SDN BHD
 * @PROJECT: NST
 * @DATE_STARTED: 2 JANUARY 2020
 */

public class FLASH extends AppCompatActivity {

    Handler HANDLER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        HANDLER = new Handler();

        HANDLER.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent TOMAIN;
                TOMAIN = new Intent(FLASH.this, MUSICPLAYER.class);
                startActivity(TOMAIN);
            }
        }, 4010);
    }
}
