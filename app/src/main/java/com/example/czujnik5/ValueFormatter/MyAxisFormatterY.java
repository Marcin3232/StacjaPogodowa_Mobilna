package com.example.czujnik5.ValueFormatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.ValueFormatter;

public class MyAxisFormatterY extends ValueFormatter {
String mSign;

    public MyAxisFormatterY(String mSign) {
        this.mSign = mSign;
    }

    @Override
    public String getAxisLabel(float value, AxisBase axis) {
        super.getAxisLabel(value, axis);
        return value+mSign;
    }
}
