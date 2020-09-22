package com.example.czujnik5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.czujnik5.Adapter.TempDataAdapter;
import com.example.czujnik5.Model.TempData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Wykresy extends AppCompatActivity {
    ListView listView;
    List<TempData> temperatureList;
    private String url="http://stacjapogodowa2.cba.pl/history.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wykresy);
        listView=(ListView)findViewById(R.id.idListTemp1);
        temperatureList=new ArrayList<>();


    }

}
