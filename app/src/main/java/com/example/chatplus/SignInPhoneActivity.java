package com.example.chatplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SignInPhoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_phone);
        getSupportActionBar().hide();
    }
}