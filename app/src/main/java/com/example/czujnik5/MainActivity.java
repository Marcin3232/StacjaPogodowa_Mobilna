package com.example.czujnik5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.czujnik5.TopBar.BaseActivity;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends BaseActivity {
    private TextView temp;
    private TextView wilg;
    private TextView cis;
    private Button button;
    private RequestQueue mQueue;
    private androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String name = "Czujnik";
        setToolbar(name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        temp = (TextView) findViewById(R.id.textView4);
        wilg = (TextView) findViewById((R.id.textView6));
        cis = (TextView) findViewById((R.id.textView5));
        button = (Button) findViewById((R.id.button));
        mQueue = Volley.newRequestQueue(this);
        jsonParse();
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                jsonParse();
            }
        });
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }


    private void jsonParse() {
        String url = "http://stacjapogodowa2.cba.pl/pobierz.php";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override

                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jobj = response.getJSONObject("czujnik");
                            //  JSONArray jsonArray = response.getJSONArray("czujnik");
                            for (int i = 0; i < jobj.length(); i++) {
                                // JSONObject obj = jobj.getJSONObject(i);
                                int temperatura = jobj.getInt("temperatura");
                                int cisnienie = jobj.getInt("cisnienie");
                                int wilgotnosc = jobj.getInt("wilgotnosc");
                                temp.setText(String.valueOf(temperatura) + " °C");
                                cis.setText(String.valueOf(cisnienie) + " hPa");
                                wilg.setText(String.valueOf(wilgotnosc) + " %");
                            }
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
        mQueue.add(request);
    }

    @Override
    public void onBackPressed() {
        finish();
        startActivity(new Intent(this, Main2Activity.class));

    }
}
