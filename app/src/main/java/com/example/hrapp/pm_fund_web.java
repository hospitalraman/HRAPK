package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class pm_fund_web extends AppCompatActivity {
    WebView fund_pm;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm_fund_web);
        fund_pm = findViewById(R.id.pm_web);
        fund_pm.loadUrl("https://pmnrf.gov.in/en/");
        fund_pm.getSettings().setJavaScriptEnabled(true);
        fund_pm.setWebViewClient(new WebViewClient());
    }
}