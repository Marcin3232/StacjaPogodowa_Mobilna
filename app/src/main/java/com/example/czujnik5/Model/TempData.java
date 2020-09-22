package com.example.czujnik5.Model;

public class TempData {

    String Time, Temperature;

    public TempData(String time, String temperature) {
        Time = time;
        Temperature = temperature;
    }

    public String getTime() {
        return Time;
    }

    public String getTemperature() {
        return Temperature;
    }

}
