package com.example.hrapp;

import androidx.annotation.IntegerRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.data.model.User;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Random;

public class self_assess extends AppCompatActivity {
    private TextView question, question_num;
    private TextView option1, option2;
    FusedLocationProviderClient fusedLocationProviderClient;
    String latitude, longitude;
    int PERMISSION = 44;
    int count = 0;
    private ArrayList<userAsses_activity> quizModalArrayList;
    int currentScore = 0, currentPos = 0, quesAttempted = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_assess);
        // LOCATION ACCESS
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        question = findViewById(R.id.questions);
        //question_num = findViewById(R.id.Question_num);
        option1 = findViewById(R.id.option_yes);
        option2 = findViewById(R.id.option_no);
        quizModalArrayList = new ArrayList<>();
        //random = new Random();
        getQuizQuestion(quizModalArrayList);
        //currentPos = random.nextInt(quizModalArrayList.size());
        setDataToView(currentPos);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (quizModalArrayList.get(currentPos).getAnswer().trim().toUpperCase().equals(option1.getText().toString().trim().toUpperCase())) {
                    currentScore++;
                }


                if (currentPos < 5) {
                    currentPos++;

                }
                //quesAttempted++;

                setDataToView(currentPos);


            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //quesAttempted++;
                if (currentPos < 5) {
                    currentPos++;

                }
                setDataToView(currentPos);
            }
        });

    }

    private void showBottonSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(self_assess.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bio_bottom_sheet, (LinearLayout) findViewById(R.id.bottom_layout));
        TextView score = bottomSheetView.findViewById(R.id.score);
        Button asses_result = bottomSheetView.findViewById(R.id.asess_result_button);
        score.setText("YOU HAVE " + currentScore + " SYMPTOMS");
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        asses_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentScore == 1 || currentScore == 0) {
                    bottomSheetDialog.dismiss();
                    Intent intent = new Intent(self_assess.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                    if (firebaseAuth.getCurrentUser() != null) {
                        bottomSheetDialog.dismiss();

                        Intent intent = new Intent(self_assess.this, AfterSignin.class);
                        userLocationDatabase();
                        intent.putExtra("latitude", latitude);
                        intent.putExtra("longitude", longitude);
                        startActivity(intent);

                    } else {
                        //location of an user----------------
                        //--------------------------------------
                        bottomSheetDialog.dismiss();
                        Intent intent = new Intent(self_assess.this, UserRegistration.class);
                        userLocationDatabase();
                        intent.putExtra("latitude", latitude);
                        intent.putExtra("longitude", longitude);
                        startActivity(intent);

                    }
                }
            }

        });


    }

    //-----------------------------LOCATION PART----------------------------------------------------------------
    //check if the location are given
    private void userLocationDatabase() {

        if (checkPermission()) {
            if (isLocationEnabled()) {
                //getting a last location from FusedLocationClient
                fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Location location = task.getResult();
                        if (location == null) {
                            requestNewLocationData();
                        } else {
                            double a = location.getLatitude();
                            double b = location.getLongitude();
                            latitude = Double.toString(a);
                            longitude = Double.toString(b);
                            System.out.println("11111111111111111111111111111111111111111111111111111111111111111 " + latitude);
                            //longitude = location.getLongitude() + " ";
                            System.out.println("22222222222222222222222222222222222222222222222222222222222222222222 " + longitude);
                        }
                    }


                });

            } else {
                Toast.makeText(this, "Please turn on" + "your location....", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }

        } else {
            requestPermissions();

        }
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION);
    }

    private void requestNewLocationData() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5);
        //locationRequest.setInterval(30*1000);
        //locationRequest.setFastestInterval(5*1000);
        locationRequest.setFastestInterval(0);
        locationRequest.setNumUpdates(1);
        //LocationSettingsRequest.Builder builder =  new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());


    }

    private final LocationCallback locationCallback = new LocationCallback() {

        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location lastlocation =  locationResult.getLastLocation();
            double a = lastlocation.getLongitude();
            double b = lastlocation.getLatitude();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+latitude);
            longitude = Double.toString(a);

            latitude = Double.toString(b);
            //longitude = lastlocation.getLongitude()+"";
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+longitude);

        }
    };

    //method to check if the location is enabled
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return  locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

    }

    private boolean checkPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISSION){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){



                userLocationDatabase();
            }
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(checkPermission()){
            userLocationDatabase();
        }
    }

    //---------------------------------------------------------------------------------------------------------
    private void setDataToView(int currentPos){

        //question_num.setText("Questions Attempted :"+quesAttempted + "/5");

        if(currentPos == 5){
            showBottonSheet();

        }else{
            //for (int i = 0;i<quizModalArrayList.toArray().length;i++){
              //  question.setText(quizModalArrayList.get(i).getQustion());
            //}

            question.setText(quizModalArrayList.get(currentPos).getQustion());
            option1.setText(quizModalArrayList.get(currentPos).getOption1());
            option2.setText(quizModalArrayList.get(currentPos).getOption2());

        }



    }
    private void getQuizQuestion(ArrayList<userAsses_activity> quizModalArrayList) {
        quizModalArrayList.add(new userAsses_activity("Do you have breathing problems?","YES","NO","YES"));
        quizModalArrayList.add(new userAsses_activity("Do you have chest pain/pressure?","YES","NO","YES"));
        quizModalArrayList.add(new userAsses_activity("Do you suffering from fever,sore throat or dry dough?","YES","NO","YES"));
        quizModalArrayList.add(new userAsses_activity("Did you noticed loss of taste/smell in your routine?","YES","NO","YES"));
        quizModalArrayList.add(new userAsses_activity("Do you have a Runny nose/Congestion?","YES","NO","YES"));



    }
}
