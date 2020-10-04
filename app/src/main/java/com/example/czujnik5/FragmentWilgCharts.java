package com.example.czujnik5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.czujnik5.Model.RequestDataToChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class FragmentWilgCharts extends Fragment {
    private LineChart mChart;
    Context context;
    String name, label, sign;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.wilg_chart_fragment, container, false);
        name = "wilgotnosc";
        label = "Wilgotność [%]";
        sign = "%";
        context = getActivity().getApplicationContext();
        final ArrayList<Entry> temperatureData = new ArrayList<Entry>();
        RequestDataToChart requestDataToChart = new RequestDataToChart(context, temperatureData, mChart, view, sign);
        requestDataToChart.getValues(context, name, label);
        return view;
    }


}
