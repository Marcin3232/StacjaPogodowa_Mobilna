package com.example.czujnik5.ValueFormatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;

public class MyAxisFormatterX extends ValueFormatter {
    ArrayList<String> mList;

    public MyAxisFormatterX(ArrayList<String> list) {
        this.mList = list;
    }

    @Override
    public String getAxisLabel(float value, AxisBase axis) {
        super.getAxisLabel(value, axis);
        return mList.get((int)value);
    }
}
