package com.starlabbioscience.nst;

/*
 * 주의 와 메모리를위한 소프트웨어입니다. 그
 * 것은 나쁜 생각이지만 어쨌든 그것을하고,
 * 나는 상사가 아니에요 :)
 */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * @AUTHOR : JOHN MELODY ME
 * @COPYRIGHT : BRAINTECH SDN BHD || STARLABS BIOSCIENCE SDN BHD
 * @PROJECT: NST
 * @DATE_STARTED: 2 JANUARY 2020
 */

public class AUTHENTICATION extends AppCompatActivity {

    EditText email, password;
    Button login, register;
    FirebaseAuth FIREBASEAUTH;

    private void INIT(){
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        FIREBASEAUTH = FirebaseAuth.getInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        INIT();
    }

    public void Authentication(View whateverView){
        String EMAIL, PASSWORD, ERR_EMAIL, ERR_PASSW, ERR_PASSLENGTH;
        EMAIL = email
                .getText()
                .toString();
        PASSWORD = password
                .getText()
                .toString();
        ERR_EMAIL = "PLEASE ENTER EMAIL";
        ERR_PASSW = "PLEASE ENTER PASSWORD";
        ERR_PASSLENGTH = "PLEASE ENTER A STRONG PASSWORD";

        switch (whateverView.getId()){
            case R.id.login:


                if (TextUtils.isEmpty(EMAIL)){
                    email.setError(ERR_EMAIL);
                }  else {
                    System.out.println("EMAIL ENTERED");
                }

                if (TextUtils.isEmpty(PASSWORD)){
                    password.setError(ERR_PASSW);
                } else {
                    System.out.println("PASSWORD ENTERED");
                }

                if (password.length() <= 0b110){
                    password.setError(ERR_PASSLENGTH);
                } else {
                    System.out.println("PASSWORD IS STRONG");
                }

                FIREBASEAUTH.signInWithEmailAndPassword(EMAIL, PASSWORD)
                        .addOnCompleteListener(AUTHENTICATION.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> LOGIN) {
                                Intent TOMUSICPLAYER;
                                if (LOGIN.isSuccessful()){
                                    FirebaseUser USER = FIREBASEAUTH.getCurrentUser();
                                    Toast.makeText(getApplicationContext(), "Welcome Back " + USER + "!",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                    TOMUSICPLAYER = new Intent(AUTHENTICATION.this, MUSICPLAYER.class);
                                    startActivity(TOMUSICPLAYER);
                                } else {
                                    Toast.makeText(getApplicationContext(), "Login Failed",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                }
                            }
                        });
                break;

            case R.id.register:
                if (TextUtils.isEmpty(EMAIL)){
                    email.setError(ERR_EMAIL);
                }  else {
                    System.out.println("EMAIL ENTERED");
                }

                if (TextUtils.isEmpty(PASSWORD)){
                    password.setError(ERR_PASSW);
                } else {
                    System.out.println("PASSWORD ENTERED");
                }

                if (password.length() <= 0b110){
                    password.setError(ERR_PASSLENGTH);
                } else {
                    System.out.println("PASSWORD IS STRONG");
                }

                FIREBASEAUTH.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                        .addOnCompleteListener(AUTHENTICATION.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> REGISTER) {
                                Intent TOMUSICPLAYER;
                                if (REGISTER.isSuccessful()){
                                    FirebaseUser USER = FIREBASEAUTH.getCurrentUser();
                                    Toast.makeText(getApplicationContext(), USER + "REGISTERED",
                                            Toast.LENGTH_SHORT)
                                            .show();
                                    TOMUSICPLAYER = new Intent(AUTHENTICATION.this, MUSICPLAYER.class);
                                    startActivity(TOMUSICPLAYER);
                                }
                            }
                        });

        }


    }
}
