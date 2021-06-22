package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class fund_care extends AppCompatActivity {
    CardView pm_fund_india;
    CardView cm_fund_tamilnadu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_care);

        pm_fund_india = findViewById(R.id.PM_fund);
        cm_fund_tamilnadu = findViewById(R.id.CM_fund);


        pm_fund_india.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fund_care.this,pm_fund_web.class);
                startActivity(intent);
            }
        });

        cm_fund_tamilnadu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fund_care.this,cm_fund_web.class);
                startActivity(intent);
            }
        });
    }
}