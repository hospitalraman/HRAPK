package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    CardView Emergency;
    CardView bio;
    CardView Bed_availibity;
    CardView globalview;
    CardView india_stats;
    CardView helpline;
    CardView vaccine_IN;
    CardView ePass;
    //TextView name;
    //Button logout;
    CardView fund;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hospital Raman");

        Toolbar toolbar = findViewById(R.id.toolbar_hp);
        //setSupportActionBar(toolbar);

        helpline = findViewById(R.id.helpline);
        globalview = findViewById(R.id.globalview);
        Emergency = findViewById(R.id.Emergeny);
        bio = findViewById(R.id.bio);
        Bed_availibity = findViewById(R.id.Bed_availibity);
        india_stats = findViewById(R.id.stats_india);
        vaccine_IN = findViewById(R.id.vaccine_india);
        ePass = findViewById(R.id.epass_card);
        //name = findViewById(R.id.nameuser);
        //logout = findViewById(R.id.logout_user);
        fund = findViewById(R.id.fund_india);





        /*GoogleSignInAccount googleSignInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(googleSignInAccount != null){
            name.setText(googleSignInAccount.getDisplayName());
        }*/

        /*logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this,"logout successfully",Toast.LENGTH_LONG).show();

            }
        });*/


        fund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,fund_care.class);
                startActivity(intent);
            }
        });

        ePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,e_pass_Activity.class);
                startActivity(intent);
            }
        });


        Bed_availibity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,bed_tamilnadu.class);
                startActivity(intent);
            }
        });


        vaccine_IN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,vaccine_india_covid.class);
                startActivity(intent);
            }
        });

        globalview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, stats.class);
                startActivity(intent);
            }
        });

        bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, user_bio.class);
                startActivity(intent);
            }
        });

        india_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, bharathstats.class);
                startActivity(intent);
            }
        });

        Emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, user_emergency.class);
                startActivity(intent);
            }
        });


        helpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,state_helpline_num.class);
                startActivity(intent);
            }
        });
    }

}