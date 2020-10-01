package com.example.czujnik5.Model;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
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
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RequestDataToChart extends AppCompatActivity {
    Context mContext;
    ArrayList<Entry> temperatureData;
    LineChart mChart;
    View mView;


    private String url = "http://stacjapogodowa2.cba.pl/history.php";

    public RequestDataToChart(Context mContext, ArrayList<Entry> temperatureData, LineChart mChart,View view) {
        this.mContext = mContext;
        this.temperatureData = temperatureData;
        this.mChart = mChart;
        this.mView=view;

    }

    public void getValues(Context context, String name){
        mChart=mView.findViewById(R.id.linearchart);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray array = obj.getJSONArray("czujnik");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject aObj = array.getJSONObject(i);
                        float xName=Float.parseFloat(aObj.getString(name));
                        temperatureData.add(new Entry(i,xName));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();

                }
                mChart.setDragEnabled(true);
                mChart.setScaleEnabled(false);
                LineDataSet dataSet=new LineDataSet(temperatureData,"Label");
                dataSet.setFillAlpha(110);
                dataSet.setCircleColor(Color.RED);
                ArrayList<ILineDataSet> lineDataSets=new ArrayList<>();
                lineDataSets.add(dataSet);
                LineData data=new LineData(lineDataSets);
                mChart.setData(data);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {

        }; Handler.getInstance(context).addToRequestQueue(stringRequest);
    }
}