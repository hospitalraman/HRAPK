package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class cm_fund_web extends AppCompatActivity {


    WebView cm_tamilnadu;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_fund_web);

        cm_tamilnadu = findViewById(R.id.cm_web);
        cm_tamilnadu.loadUrl("https://ereceipt.tn.gov.in/cmprf/Cmprf");
        cm_tamilnadu.getSettings().setJavaScriptEnabled(true);
        cm_tamilnadu.setWebViewClient(new WebViewClient());
    }


}