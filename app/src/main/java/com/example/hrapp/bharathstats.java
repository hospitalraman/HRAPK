package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bharathstats extends AppCompatActivity {
    private TextView text_total,text_active,text_recovered,text_death,text_updated,text_today;
    private CardView card_today,card_district,card_state,card_tested;

    private RequestQueue requestQueue;
    private JSONObject response1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bharathstats);
        getSupportActionBar().setTitle("Hospital Raman");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        text_total = findViewById(R.id.india_total);
        text_active = findViewById(R.id.india_active);
        text_recovered = findViewById(R.id.india_recovered);
        text_death = findViewById(R.id.india_death);
        text_updated = findViewById(R.id.update_txt);


        card_today = findViewById(R.id.card_today);
        card_state = findViewById(R.id.state_wise_report);
        card_district = findViewById(R.id.district_wise_report);
        card_tested = findViewById(R.id.tested_card);

        requestQueue = Volley.newRequestQueue(this);

        parseJson();
        card_today.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bharathstats.this,Todaycases.class);
                try{
                    JSONArray array = response1.getJSONArray("statewise");
                    JSONObject object = array.getJSONObject(0);
                    intent.putExtra("confirmed",object.getString("deltaconfirmed"));
                    intent.putExtra("deaths",object.getString("deltadeaths"));
                    intent.putExtra("recovered",object.getString("deltarecovered"));
                    intent.putExtra("lastUpdated",object.getString("lastupdatedtime"));
                    //intent.putExtra("lastUpdated",object.getString("lastupdatedtime"));
                    startActivity(intent);
                }catch (JSONException e){
                    e.printStackTrace();
                }


            }
        });

        card_state.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bharathstats.this,statewiseReport.class);
                startActivity(intent);
            }
        });

        card_district.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bharathstats.this,selectState.class);
                startActivity(intent);
            }
        });

        card_tested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bharathstats.this,info_covid.class);
                startActivity(intent);
            }
        });


    }

    private void parseJson() {

        String url = "https://api.covid19india.org/data.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(JSONObject response) {
                response1 = response;
                try {
                    JSONArray array = response.getJSONArray("statewise");
                    JSONObject object = array.getJSONObject(0);
                    text_active.setText(object.getString("active"));
                    text_total.setText(object.getString("confirmed"));
                    text_recovered.setText(object.getString("recovered"));
                    text_death.setText(object.getString("deaths"));
                    //String lastupdate = "last Updated:" + object.getString("lastupdatedtime");
                    //text_updated.setText("last Updated"+object.getString("lastupdatedtime"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }

}