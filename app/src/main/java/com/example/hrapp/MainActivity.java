package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    CardView Emergency;
    CardView Account;
    CardView Bed_availibity;
    CardView globalview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        globalview = findViewById(R.id.globalview);
        Emergency = findViewById(R.id.Emergeny);
        Account = findViewById(R.id.Account);
        Bed_availibity = findViewById(R.id.Bed_availibity);


        globalview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,stats.class);
                startActivity(intent);
            }
        });

        Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,signhp.class);
                startActivity(intent);
            }
        });


    }
}