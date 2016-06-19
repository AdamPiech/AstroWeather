package com.astroweather.adampiech.astroweather.model;

import java.io.Serializable;
import java.util.Date;

public class LocalizationData implements Serializable {

    private String country = null;
    private String city = null;

    private String longitude = null;
    private String latitude = null;

    private Date updateDate = null;

    public LocalizationData(String country, String city, String longitude, String latitude, Date updateDate) {
        this.country = country;
        this.city = city;
        this.longitude = longitude;
        this.latitude = latitude;
        this.updateDate = updateDate;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
