package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class user_bio extends AppCompatActivity {
    CardView vaccine_bio,self_assess_bio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_bio);

        vaccine_bio = findViewById(R.id.vaccine_card);
        self_assess_bio = findViewById(R.id.self_asses_card);


        vaccine_bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_bio.this,vaccine_india_covid.class);
                startActivity(intent);
            }
        });


        self_assess_bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_bio.this,self_assess.class);
                startActivity(intent);
            }
        });



    }
}