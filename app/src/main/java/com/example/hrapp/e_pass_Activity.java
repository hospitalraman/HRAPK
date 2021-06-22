package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class e_pass_Activity extends AppCompatActivity {
    WebView epass;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epass);

        epass = findViewById(R.id.epass_web);
        epass.loadUrl("https://eregister.tnega.org/#/user/pass");
        epass.getSettings().setJavaScriptEnabled(true);
        epass.setWebViewClient(new WebViewClient());

    }
}