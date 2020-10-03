package com.example.czujnik5;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.czujnik5.Model.RequestDataToChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;


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
        RequestDataToChart requestDataToChart=new RequestDataToChart(context,temperatureData,mChart,view);
        requestDataToChart.getValues(context,name);
        return view;
    }

}
