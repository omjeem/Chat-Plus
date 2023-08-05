package com.example.chatplus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

public class PrivacyPolicy extends AppCompatActivity {

    WebView webView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
        getSupportActionBar().hide();
        webView = findViewById(R.id.webView);

        webView.loadUrl("https://www.app-privacy-policy.com/live.php?token=rxNIXERYaWn64Mvw5gDypiYVJ5u9RlXy");
    }
}