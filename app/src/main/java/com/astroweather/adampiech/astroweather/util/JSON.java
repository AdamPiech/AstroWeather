package com.astroweather.adampiech.astroweather.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JSON {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static Weather parseWeather(JSONObject weatherJSON) throws JSONException, ParseException {
        JSONObject cloudsInfo = weatherJSON.getJSONObject("clouds");
        JSONObject basicInfo = weatherJSON.getJSONObject("main");
        JSONObject windInfo = weatherJSON.getJSONObject("wind");
        JSONArray weatherInfo = weatherJSON.getJSONArray("weather");
        Date date = simpleDateFormat.parse(weatherJSON.getString("dt_txt"));
        float temperature = (float) basicInfo.getDouble("temp");
        float humidity = (float) basicInfo.getDouble("humidity");
        float pressure = (float) basicInfo.getDouble("pressure");
        float windSpeed = (float) windInfo.getDouble("speed");
        float windDirection = (float) windInfo.getDouble("deg");
        float clouds = cloudsInfo.getInt("all");
        String iconCode = ((JSONObject) weatherInfo.get(0)).getString("icon") + ".png";
        return new Weather(null, null, null, null, null, null, null, null, null, null, null);
    }

    public static JSONObject getJSON(String url) throws JSONException {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer content = new StringBuffer();
            String line = "";

            while ((line = buffer.readLine()) != null) {
                content.append(line);
            }

            inputStream.close();
            connection.disconnect();
            return new JSONObject(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}


