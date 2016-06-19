package com.astroweather.adampiech.astroweather.util;

import android.os.AsyncTask;

import com.astroweather.adampiech.astroweather.model.Weather;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;

public class CorrectLocationDataTask extends AsyncTask<String, Void, Boolean> {

    @Override
    protected Boolean doInBackground(String... params) {
        Weather weather = null;
        String country = params[0];
        String city = params[1];

        try {
            JSONObject json = JSON.getJSON("https://query.yahooapis.com/v1/public/yql?q=select * from geo.places(1) where text= + city + , + country + ");
            weather = JSON.getFromJsonAllWeatherData(json);
        } catch (JSONException | ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
