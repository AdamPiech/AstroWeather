package com.astroweather.adampiech.astroweather.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astroweather.adampiech.astroweather.R;
import com.astroweather.adampiech.astroweather.util.AstroWeatherValues;

public class WindFragment extends Fragment {

    private TextView windForce;
    private TextView windDirection;
    private TextView humidity;
    private TextView visibility;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_wind, container, false);
    }

    private void initFields() {
        windForce = (TextView) getActivity().findViewById(R.id.textWindForce);
        windDirection = (TextView) getActivity().findViewById(R.id.textWindDirection);
        humidity = (TextView) getActivity().findViewById(R.id.textHumidity);
        visibility = (TextView) getActivity().findViewById(R.id.textVisibility);
    }

    private void fillFields() {
        windForce.setText(AstroWeatherValues.weather.getWind().getWindForce() + AstroWeatherValues.weather.getUnits().getSpeed());
        windDirection.setText(AstroWeatherValues.weather.getWind().getWindDirection());
        humidity.setText(AstroWeatherValues.weather.getWind().getHumidity() + "%");
        visibility.setText(AstroWeatherValues.weather.getWind().getVisibility() + AstroWeatherValues.weather.getUnits().getDistance());
    }

    @Override
    public void onResume() {
        super.onResume();
        initFields();
        fillFields();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
