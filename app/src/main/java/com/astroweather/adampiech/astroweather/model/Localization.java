package com.astroweather.adampiech.astroweather.model;

import java.io.Serializable;

public class Localization implements Serializable{

    private String country = null;
    private String city = null;

    public Localization(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}
