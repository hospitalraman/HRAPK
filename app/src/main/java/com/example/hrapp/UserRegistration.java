package com.example.hrapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserRegistration extends AppCompatActivity {
    private EditText username;
    private EditText email;
    private EditText password;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String lat;
    String log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        //---------------------------------------------------
        Intent intent = getIntent();
        lat = intent.getStringExtra("latitude");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+lat);
        log = intent.getStringExtra("longitude");
        System.out.println("################################"+log);

        //--------------------------------------------------
        // for changing the bar color
        setStatusBarColor();
        firebaseAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.userName);
        email = findViewById(R.id.logemail);
        password = findViewById(R.id.epassword);
        Button register = findViewById(R.id.register_button);
        //Button login = findViewById(R.id.login_button);
        progressBar = findViewById(R.id.prograssbar_auth);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String userName = username.getText().toString();
                    String getEmail = email.getText().toString();
                    String getPassword = password.getText().toString();


                    if(TextUtils.isEmpty(userName)){
                        Toast.makeText(UserRegistration.this,"Please enter username!",Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(TextUtils.isEmpty(getEmail)){
                        Toast.makeText(UserRegistration.this,"Please enter email!",Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(TextUtils.isEmpty(getPassword)){
                        Toast.makeText(UserRegistration.this,"Please enter password!",Toast.LENGTH_LONG).show();
                        return;
                    }
                    progressBar.setVisibility(View.VISIBLE);
                    firebaseAuth.createUserWithEmailAndPassword(getEmail,getPassword)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Toast.makeText(UserRegistration.this,"user account created",Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);

                                    FirebaseUser user = firebaseAuth.getCurrentUser();


                                    if(user != null) {


                                        Intent intent = new Intent(UserRegistration.this, AfterSignin.class);
                                        rootNode = FirebaseDatabase.getInstance();
                                        reference = rootNode.getReference("users");

                                        //get all the values
                                        User_info info = new User_info(userName,getEmail,getPassword,lat,log);
                                        reference.child(user.getUid()).setValue(info);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        intent.putExtra("latitude_",lat);
                                        intent.putExtra("longitude_",log);
                                        //realTimeDatabase();
                                        startActivity(intent);
                                    }

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(UserRegistration.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.GONE);

                                }
                            });
            }
        });

        /*login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username.getText().toString();
                String getEmail = email.getText().toString();
                String getPassword = password.getText().toString();
                if(TextUtils.isEmpty(userName)){
                    Toast.makeText(UserRegistration.this,"Please enter username!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(getEmail)){
                    Toast.makeText(UserRegistration.this,"Please enter email!",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(getPassword)){
                    Toast.makeText(UserRegistration.this,"Please enter password!",Toast.LENGTH_LONG).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(getEmail,getPassword)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                //Toast.makeText(UserRegistration.this,"welcome User",Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                //String username = edit.getText().toString();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(UserRegistration.this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        });
            }
        });*/



    }


    private void setStatusBarColor() {
    }
}