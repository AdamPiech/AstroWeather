package com.astroweather.adampiech.astroweather.model;

import java.io.Serializable;
import java.util.Date;

public class FutherWeather implements Serializable {

    private String minTemperature = null;
    private String maxTemperature = null;

    private String day = null;

    private String imageCode = null;

    public FutherWeather(String minTemperature, String maxTemperature, String day, String imageCode) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.day = day;
        this.imageCode = imageCode;
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }
}
