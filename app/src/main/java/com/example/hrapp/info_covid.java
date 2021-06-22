package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class info_covid extends AppCompatActivity {

    private TextView total_sample,total_vaccinated,total_45_1stdose,total_45_2nddose,total60_1stdose,total60_2nddose,updatetime;

    private RequestQueue requestQueue;
    private JSONObject response1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_covid);

        total_sample = findViewById(R.id.total_sample_tested);
        total_vaccinated = findViewById(R.id.total_individual_vaccinated);
        total_45_1stdose = findViewById(R.id.over_45_Dose);
        total_45_2nddose =findViewById(R.id.over_45_2ndDose);
        total60_1stdose = findViewById(R.id.over_60_1stdose);
        total60_2nddose = findViewById(R.id.over_60_2nddose);
        updatetime = findViewById(R.id.txt_infodate);


        requestQueue = Volley.newRequestQueue(this);

        parseJson();


    }

    private void parseJson() {

        String url = "https://api.covid19india.org/data.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                response1 = response;
                try {
                    JSONArray array = response.getJSONArray("tested");
                    JSONObject object = array.getJSONObject(array.length()-1);
                    total_sample.setText(object.getString("totalsamplestested"));
                    total_vaccinated.setText(object.getString("totalindividualsvaccinated"));
                    total_45_1stdose.setText(object.getString("over45years1stdose"));
                    total_45_2nddose.setText(object.getString("over45years2nddose"));
                    total60_1stdose.setText(object.getString("over60years1stdose"));
                    total60_2nddose.setText(object.getString("over60years2nddose"));
                    String lastUptated = "last Updated:" +object.getString("updatetimestamp");
                    updatetime.setText(lastUptated);

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