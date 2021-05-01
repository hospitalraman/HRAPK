package com.example.hrapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class stats extends AppCompatActivity {

    TextView Tcases,Trecovered,Tcritical,Tactive,Ttotaldeath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Tcases = findViewById(R.id.totalcases);
        Trecovered = findViewById(R.id.recovered_case);
        Tcritical = findViewById(R.id.Critical);
        Tactive = findViewById(R.id.ACTIVE);
        Ttotaldeath = findViewById(R.id.TOTAL_DEATHS);


        fetchdata();
    }

    private void fetchdata() {
        String url = "https://corona.lmao.ninja/v2/all";

        StringRequest request
                = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(
                            String response)
                    {
                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());

                            Tcases.setText(jsonObject.getString("cases"));
                            Tactive.setText(jsonObject.getString("active"));
                            Tcritical.setText(jsonObject.getString("critical"));
                            Trecovered.setText(jsonObject.getString("recovered"));
                            Ttotaldeath.setText(jsonObject.getString("deaths"));

                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(stats.this,"no",Toast.LENGTH_SHORT).show();

                    }
                });

        RequestQueue requestQueue
                = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}