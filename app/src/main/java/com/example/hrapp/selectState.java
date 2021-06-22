package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class selectState extends AppCompatActivity {


    private RecyclerView districtrecyclerView;
    private RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_state);

        districtrecyclerView = findViewById(R.id.recycler_tamilnadu);
        districtrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = Volley.newRequestQueue(this);
        parseJson();


    }
    private void parseJson() {

        String url = "https://api.covid19india.org/state_district_wise.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,url,null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONObject state =  response.getJSONObject("Tamil Nadu");
                    JSONObject districtData = state.getJSONObject("districtData");
                    //GsonBuilder gsonBuilder = new GsonBuilder();
                    //Gson gson = gsonBuilder.create();
                    JSONArray keys = districtData.names();
                    int length = keys.length();

                    String[] district_tn = new String[length];
                    String[] cases_tn = new  String[length];
                    String[] active_tn = new String[length];
                    String[] recovered_tn = new String[length];
                    for(int i = 0; i < length; i++){
                        district_tn[i] = keys.getString(i);
                        cases_tn[i] = districtData.getJSONObject(district_tn[i]).getString("confirmed");
                        active_tn[i] = districtData.getJSONObject(district_tn[i]).getString("active");
                        recovered_tn[i] = districtData.getJSONObject(district_tn[i]).getString("recovered");

                    }


                    //tndata = gson.fromJson(String.valueOf(state), TnData[].class);
                    districtrecyclerView.setAdapter(new tnadapter(district_tn,cases_tn,active_tn,recovered_tn));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        }
        );
        requestQueue.add(request);


    }


}