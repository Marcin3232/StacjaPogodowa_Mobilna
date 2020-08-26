package com.example.czujnik5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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



public class MainActivity extends AppCompatActivity {
    private TextView temp;
    private TextView wilg;
    private TextView cis;
    private Button button;

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp=(TextView) findViewById(R.id.textView4);
        wilg=(TextView)findViewById((R.id.textView5));
        cis=(TextView)findViewById((R.id.textView6));
        button=(Button)findViewById((R.id.button));
        ImageButton wstecz=findViewById(R.id.imageButton);

        mQueue = Volley.newRequestQueue(this);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                jsonParse();

            }
        });
        wstecz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Main2Activity.class);
                v.getContext().startActivity(intent);}
        });
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
                                int wilgotnosc=jobj.getInt("wilgotnosc");
                                temp.setText(String.valueOf(temperatura));
                                cis.setText(String.valueOf(cisnienie));
                                wilg.setText(String.valueOf(wilgotnosc));
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
}
