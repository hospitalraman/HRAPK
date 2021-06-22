package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.ui.auth.data.model.CountryInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLDecoder;

public class country_cases extends AppCompatActivity {
    private RecyclerView recyclerView_country_;
    private RequestQueue requestQueue;
    private CountryData[] countryData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_cases);

        recyclerView_country_ = findViewById(R.id.recycler_countryView);
        recyclerView_country_.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = Volley.newRequestQueue(this);
        parseJson();

    }

    private void parseJson() {

        String url = "https://coronavirus-19-api.herokuapp.com/countries";


        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

             try{
                 GsonBuilder gsonBuilder = new GsonBuilder();
                 Gson gson = gsonBuilder.create();

                 countryData = gson.fromJson(String.valueOf(response),CountryData[].class);
                 recyclerView_country_.setAdapter(new country_adapter(countryData));

             }catch (Exception e){
                 e.printStackTrace();
             }

            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
        );
        requestQueue.add(arrayRequest);

    }
}