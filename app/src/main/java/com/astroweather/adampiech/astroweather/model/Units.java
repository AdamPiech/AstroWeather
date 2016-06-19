package com.astroweather.adampiech.astroweather.model;

import java.io.Serializable;

public class Units implements Serializable {

    private String pressure = null;
    private String speed = null;
    private String temperature = null;
    private String distance = null;

    public Units(String pressure, String speed, String temperature, String distance) {
        this.pressure = pressure;
        this.speed = speed;
        this.temperature = temperature;
        this.distance = distance;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
