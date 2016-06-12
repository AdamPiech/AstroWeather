package com.astroweather.adampiech.astroweather.util;

public class Weather {

    //Weather
    private String date = null;
    private String country = null;
    private String city = null;
    private String latitude = null;
    private String temperature = null;
    private String pressure = null;
    private String description = null;

    //Wind
    private String windForce = null;
    private String windDirection = null;
    private String humidity = null;
    private String visibility = null;

    public Weather(String city, String country, String date, String description, String humidity, String latitude, String pressure, String temperature, String visibility, String windDirection, String windForce) {
        this.city = city;
        this.country = country;
        this.date = date;
        this.description = description;
        this.humidity = humidity;
        this.latitude = latitude;
        this.pressure = pressure;
        this.temperature = temperature;
        this.visibility = visibility;
        this.windDirection = windDirection;
        this.windForce = windForce;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindForce() {
        return windForce;
    }

    public void setWindForce(String windForce) {
        this.windForce = windForce;
    }


}
