package com.example.czujnik5.Model;

import android.graphics.Color;


import com.example.czujnik5.ValueFormatter.MyAxisFormatterX;
import com.example.czujnik5.ValueFormatter.MyAxisFormatterY;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class ChartDesigner {
    ArrayList<Entry> temperatureData;
    ArrayList<String> mList;
    LineChart mChart;
    String mChar, mSign;

    public ChartDesigner(ArrayList<Entry> temperatureData, LineChart chart, ArrayList<String> list, String sign) {
        this.temperatureData = temperatureData;
        this.mChart = chart;
        this.mList = list;
        this.mSign = sign;
    }


    public void setData(String label) {
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setDrawBorders(true);
        LineDataSet dataSet = new LineDataSet(temperatureData, label);
        dataSet.setFillAlpha(110);
        dataSet.setLineWidth(2);
        dataSet.setColor(Color.YELLOW);
        dataSet.setCircleHoleColor(Color.GREEN);
        dataSet.setCircleColor(Color.BLUE);
        dataSet.setCircleRadius(3);
        dataSet.setValueTextSize(12);
        dataSet.setValueTextColor(Color.WHITE);
        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
        lineDataSets.add(dataSet);
        LineData data = new LineData(lineDataSets);
        // lEGEND
        Legend legend = mChart.getLegend();
        legend.setEnabled(true);
        legend.setTextColor(Color.WHITE);
        legend.setTextSize(12);
        legend.setForm(Legend.LegendForm.LINE);
        legend.setFormSize(15);
        //X AXIS
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setValueFormatter(new MyAxisFormatterX(mList));
        xAxis.setTextSize(12);
        xAxis.setTextColor(Color.WHITE);
        //Y Axis
        YAxis yAxis = mChart.getAxisLeft();
        yAxis.setValueFormatter(new MyAxisFormatterY(mSign));
        yAxis.setTextSize(12);
        yAxis.setTextColor(Color.WHITE);
        YAxis yAxis1=mChart.getAxisRight();
        yAxis1.setTextSize(12);
        yAxis1.setTextColor(Color.WHITE);
        //generate a chart
        mChart.invalidate();
        mChart.setData(data);
    }

}
