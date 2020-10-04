package com.example.czujnik5.Model;


import android.content.Context;

import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.czujnik5.Handler;
import com.example.czujnik5.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class RequestDataToChart extends AppCompatActivity {
    Context mContext;
    ArrayList<Entry> temperatureData;
    LineChart mChart;
    View mView;
    String mSign;
    ArrayList<String> timeList;


    private String url = "http://stacjapogodowa2.cba.pl/history.php";

    public RequestDataToChart(Context mContext, ArrayList<Entry> temperatureData, LineChart mChart, View view, String sign) {
        this.mContext = mContext;
        this.temperatureData = temperatureData;
        this.mChart = mChart;
        this.mView = view;
        this.mSign = sign;


    }

    public void getValues(Context context, String name, String label) {
        mChart = mView.findViewById(R.id.linearchart);
        timeList = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray array = obj.getJSONArray("czujnik");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject aObj = array.getJSONObject(i);
                        float yName = Float.parseFloat(aObj.getString(name));
                        String datatime = aObj.getString("TimeStamp");
                        timeList.add(i, datatime);
                        temperatureData.add(new Entry(i, yName));

                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                }
                ChartDesigner chartDesigner = new ChartDesigner(temperatureData, mChart, timeList, mSign);
                chartDesigner.setData(label);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

        };
        Handler.getInstance(context).addToRequestQueue(stringRequest);

    }
}
