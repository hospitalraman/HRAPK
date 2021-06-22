package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Todaycases extends AppCompatActivity {


    private TextView txt_confirmed_today,txt_deaths_today,txt_recovered_today,txt_updated_today;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_todaycases);
        setContentView(R.layout.activity_todaycases);
        getSupportActionBar().setTitle("Hospital Raman");


        txt_confirmed_today = findViewById(R.id.txt_confirmed_today);
        txt_deaths_today = findViewById(R.id.txt_deaths_today);
        txt_recovered_today = findViewById(R.id.txt_recoverd_today);
        txt_updated_today = findViewById(R.id.update_txt);



        String confirmed = getIntent().getStringExtra("confirmed");
        String deaths = getIntent().getStringExtra("deaths");
        String recovered = getIntent().getStringExtra("recovered");
        String lastUpdated = getIntent().getStringExtra("lastUpdated");


        txt_recovered_today.setText(recovered);
        txt_deaths_today.setText(deaths);
        txt_confirmed_today.setText(confirmed);
        txt_updated_today.setText("Last Updated : "+lastUpdated);



    }
}