package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class user_emergency extends AppCompatActivity {

    Button buttonCall, buttonloc;
    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_emergency);
        getSupportActionBar().setTitle("Hospital Raman");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonCall = findViewById(R.id.emergency_call);
        textView2 = findViewById(R.id.locating_hospital);
        textView1 = findViewById(R.id.calling_emergency);

        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:04222301393"));
                startActivity(intent);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:04222301393"));
                startActivity(intent);
            }
        });


        buttonloc = findViewById(R.id.location_hospital);


        buttonloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:10.9952,76.9703"));
                startActivity(intent);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:10.9952,76.9703"));
                startActivity(intent);
            }
        });
    }
}