package com.astroweather.adampiech.astroweather.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Weather implements Serializable {

    private LocalizationData localizationData = null;
    private ActualWeather actualWeather = null;
    private Wind wind = null;
    private List<FutherWeather> futherWeathers = new ArrayList<>(7);

    private Units units = null;

    public Weather(LocalizationData localizationData, ActualWeather actualWeather, Wind wind, List<FutherWeather> futherWeathers, Units units) {
        this.localizationData = localizationData;
        this.actualWeather = actualWeather;
        this.wind = wind;
        this.futherWeathers = futherWeathers;
        this.units = units;
    }

    public LocalizationData getLocalizationData() {
        return localizationData;
    }

    public void setLocalizationData(LocalizationData localizationData) {
        this.localizationData = localizationData;
    }

    public ActualWeather getActualWeather() {
        return actualWeather;
    }

    public void setActualWeather(ActualWeather actualWeather) {
        this.actualWeather = actualWeather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public List<FutherWeather> getFutherWeathers() {
        return futherWeathers;
    }

    public void setFutherWeathers(List<FutherWeather> futherWeathers) {
        this.futherWeathers = futherWeathers;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }
}
