package com.example.czujnik5.Model;

import android.content.Context;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.czujnik5.Adapter.TempDataAdapter;
import com.example.czujnik5.Handler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class RequestDataToList {
    Context mContext;
    ListView listView;
    List<TempData> temperatureList;

    private String url = "http://stacjapogodowa2.cba.pl/history.php";

    public RequestDataToList(Context mContext, ListView listView, List<TempData> list) {
        this.mContext = mContext;
        this.listView = listView;
        this.temperatureList = list;
    }

    public void showList(Context context, String name, String chars) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray array = obj.getJSONArray("czujnik");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject aObj = array.getJSONObject(i);
                        TempData temp = new TempData(aObj.getString("TimeStamp"), aObj.getString(name) + chars);
                        temperatureList.add(temp);
                    }
                    TempDataAdapter adapter = new TempDataAdapter(temperatureList, context);
                    listView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
