package com.example.czujnik5;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.czujnik5.Model.RequestDataToChart;
import com.example.czujnik5.Model.RequestDataToList;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class FragmentTempCharts extends Fragment {
    Context context;
    private LineChart mChart;
    String name;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.temp_chart_fragment, container, false);
        name = "temperatura";
        context = getActivity().getApplicationContext();
        final ArrayList<Entry> temperatureData =new ArrayList<Entry>();
        mChart = view.findViewById(R.id.linearchart);
        RequestDataToChart requestDataToChart=new RequestDataToChart(context,temperatureData,mChart,view);
        requestDataToChart.getValues(context,name);

        return view;
    }

}
