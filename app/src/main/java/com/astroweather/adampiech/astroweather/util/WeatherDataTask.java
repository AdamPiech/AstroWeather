package com.astroweather.adampiech.astroweather.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import com.astroweather.adampiech.astroweather.model.Weather;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;

public class WeatherDataTask extends AsyncTask<String, Void, Weather> {

    @Override
    protected Weather doInBackground(String... params) {
        Weather weather = null;
        String units = params[0];
        String country = params[1];
        String city = params[2];

        try {
            JSONObject json = JSON.getJSON(AstroWeatherValues.WEATHER_URL[0] + units +
                    AstroWeatherValues.WEATHER_URL[1] + city + AstroWeatherValues.WEATHER_URL[2]
                    + country + AstroWeatherValues.WEATHER_URL[3]);
            weather = JSON.getFromJsonAllWeatherData(json);
        } catch (JSONException | ParseException e) {
            e.printStackTrace();
        }

        return weather;
    }

}
