package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AfterSignin extends AppCompatActivity {
    TextView name_user;
    TextView user_id;
    Button logout_user;
    TextView lat_;
    TextView log_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_signin);
        lat_ = findViewById(R.id.userlat_id);
        log_ = findViewById(R.id.userlong_id);
        name_user = findViewById(R.id.user_name);
        user_id = findViewById(R.id.user_id);
        logout_user = findViewById(R.id.logout_user);
        FirebaseAuth firebaseAuth;

        Intent intent = getIntent();
        String str = intent.getStringExtra("latitude_");
        String str2 = intent.getStringExtra("longitude_");
        lat_.setText(str);
        log_.setText(str2);
        logout_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(AfterSignin.this,"logout successfully",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AfterSignin.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}

