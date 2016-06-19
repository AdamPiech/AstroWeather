package com.astroweather.adampiech.astroweather.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.astroweather.adampiech.astroweather.R;
import com.astroweather.adampiech.astroweather.util.AstroWeatherValues;
import com.astroweather.adampiech.astroweather.util.ImageResources;

import java.util.Calendar;

public class ActualWeatherFragment extends Fragment {

    private Calendar calendar = Calendar.getInstance();

    private TextView weatherDateTime;
    private TextView weatherLocalization;
    private TextView weatherLatiLong;
    private TextView weatherTemperature;
    private TextView weatherPressure;
    private TextView weatherDescription;
    private ImageButton imageWeather;

    private Handler timeHandler = new Handler();
    private Runnable timeRunnable = new Runnable() {
        public void run() {
            fillTime();
            calendar.add(Calendar.SECOND, 1);
            timeHandler.postDelayed(timeRunnable, 1000);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_actual_weather, container, false);
    }

    private void initTime() {
        weatherDateTime = (TextView) getActivity().findViewById(R.id.textWeatherDateTime);
    }

    private void fillTime() {
        if (weatherDateTime == null) {
            initTime();
        }
        weatherDateTime.setText(String.format("%02d", calendar.get(Calendar.YEAR)) + "." + String.format("%02d", calendar.get(Calendar.MONTH)) + "." + String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH)) + " " +
                String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY)) + ":" + String.format("%02d", calendar.get(Calendar.MINUTE)) + ":" + String.format("%02d", calendar.get(Calendar.SECOND)));
    }

    private void initFields() {
        weatherDateTime = (TextView) getActivity().findViewById(R.id.textWeatherDateTime);
        weatherLocalization = (TextView) getActivity().findViewById(R.id.textWeatherLocalization);
        weatherLatiLong = (TextView) getActivity().findViewById(R.id.textWeatherLatiLong);
        weatherTemperature = (TextView) getActivity().findViewById(R.id.textWeatherTemperature);
        weatherPressure = (TextView) getActivity().findViewById(R.id.textWeatherPressure);
        weatherDescription = (TextView) getActivity().findViewById(R.id.textWeatherDescription);
        imageWeather = (ImageButton) getActivity().findViewById(R.id.imageWeather);
    }

    private void fillFields() {
        weatherLocalization.setText(AstroWeatherValues.weather.getLocalizationData().getCountry() + ", " + AstroWeatherValues.weather.getLocalizationData().getCity());
        weatherLatiLong.setText(AstroWeatherValues.weather.getLocalizationData().getLatitude() + ", " + AstroWeatherValues.weather.getLocalizationData().getLongitude());
        weatherTemperature.setText(AstroWeatherValues.weather.getActualWeather().getTemperature() + AstroWeatherValues.weather.getUnits().getTemperature());
        weatherPressure.setText(AstroWeatherValues.weather.getActualWeather().getPressure() + AstroWeatherValues.weather.getUnits().getPressure());
        weatherDescription.setText(AstroWeatherValues.weather.getActualWeather().getDescription());
        imageWeather.setImageResource(ImageResources.getImageResource(AstroWeatherValues.weather.getActualWeather().getImageCode()));
    }

    @Override
    public void onResume() {
        super.onResume();
        timeRunnable.run();
        initFields();
        fillFields();
    }

    @Override
    public void onPause() {
        super.onPause();
        timeHandler.removeCallbacks(timeRunnable);
    }
}
