package com.astroweather.adampiech.astroweather.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.astroweather.adampiech.astroweather.R;
import com.astroweather.adampiech.astroweather.util.AstroWeatherValues;
import com.astroweather.adampiech.astroweather.util.ImageResources;

public class FutherWeatherFragment extends Fragment {

    private TextView weatherFutherDay1;
    private ImageButton weatherFutherImg1;
    private TextView weatherFutherTemp1;

    private TextView weatherFutherDay2;
    private ImageButton weatherFutherImg2;
    private TextView weatherFutherTemp2;

    private TextView weatherFutherDay3;
    private ImageButton weatherFutherImg3;
    private TextView weatherFutherTemp3;

    private TextView weatherFutherDay4;
    private ImageButton weatherFutherImg4;
    private TextView weatherFutherTemp4;

    private TextView weatherFutherDay5;
    private ImageButton weatherFutherImg5;
    private TextView weatherFutherTemp5;

    private TextView weatherFutherDay6;
    private ImageButton weatherFutherImg6;
    private TextView weatherFutherTemp6;

    private TextView weatherFutherDay7;
    private ImageButton weatherFutherImg7;
    private TextView weatherFutherTemp7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_futher_weather, container, false);
    }

    private void initFields() {
        weatherFutherDay1 = (TextView) getActivity().findViewById(R.id.textWeatherFutherDay1);
        weatherFutherImg1 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutherImg1);
        weatherFutherTemp1 = (TextView) getActivity().findViewById(R.id.textWeatherFutherTemp1);

        weatherFutherDay2 = (TextView) getActivity().findViewById(R.id.textWeatherFutherDay2);
        weatherFutherImg2 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutherImg2);
        weatherFutherTemp2 = (TextView) getActivity().findViewById(R.id.textWeatherFutherTemp2);

        weatherFutherDay3 = (TextView) getActivity().findViewById(R.id.textWeatherFutherDay3);
        weatherFutherImg3 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutherImg3);
        weatherFutherTemp3 = (TextView) getActivity().findViewById(R.id.textWeatherFutherTemp3);

        weatherFutherDay4 = (TextView) getActivity().findViewById(R.id.textWeatherFutherDay4);
        weatherFutherImg4 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutherImg4);
        weatherFutherTemp4 = (TextView) getActivity().findViewById(R.id.textWeatherFutherTemp4);

        weatherFutherDay5 = (TextView) getActivity().findViewById(R.id.textWeatherFutherDay5);
        weatherFutherImg5 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutherImg5);
        weatherFutherTemp5 = (TextView) getActivity().findViewById(R.id.textWeatherFutherTemp5);

        weatherFutherDay6 = (TextView) getActivity().findViewById(R.id.textWeatherFutherDay6);
        weatherFutherImg6 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutherImg6);
        weatherFutherTemp6 = (TextView) getActivity().findViewById(R.id.textWeatherFutherTemp6);

        weatherFutherDay7 = (TextView) getActivity().findViewById(R.id.textWeatherFutherDay7);
        weatherFutherImg7 = (ImageButton) getActivity().findViewById(R.id.textWeatherFutherImg7);
        weatherFutherTemp7 = (TextView) getActivity().findViewById(R.id.textWeatherFutherTemp7);
    }

    private void fillFields() {

        weatherFutherDay1.setText(AstroWeatherValues.weather.getFutherWeathers().get(0).getDay());
        weatherFutherImg1.setImageResource(ImageResources.getImageResource(AstroWeatherValues.weather.getFutherWeathers().get(0).getImageCode()));
        weatherFutherTemp1.setText(AstroWeatherValues.weather.getFutherWeathers().get(0).getMinTemperature() + " - " +
                AstroWeatherValues.weather.getFutherWeathers().get(0).getMaxTemperature() + AstroWeatherValues.weather.getUnits().getTemperature());

        weatherFutherDay2.setText(AstroWeatherValues.weather.getFutherWeathers().get(1).getDay());
        weatherFutherImg2.setImageResource(ImageResources.getImageResource(AstroWeatherValues.weather.getFutherWeathers().get(1).getImageCode()));
        weatherFutherTemp2.setText(AstroWeatherValues.weather.getFutherWeathers().get(1).getMinTemperature() + " - " +
                AstroWeatherValues.weather.getFutherWeathers().get(1).getMaxTemperature() + AstroWeatherValues.weather.getUnits().getTemperature());

        weatherFutherDay3.setText(AstroWeatherValues.weather.getFutherWeathers().get(2).getDay());
        weatherFutherImg3.setImageResource(ImageResources.getImageResource(AstroWeatherValues.weather.getFutherWeathers().get(2).getImageCode()));
        weatherFutherTemp3.setText(AstroWeatherValues.weather.getFutherWeathers().get(2).getMinTemperature() + " - " +
                AstroWeatherValues.weather.getFutherWeathers().get(2).getMaxTemperature() + AstroWeatherValues.weather.getUnits().getTemperature());

        weatherFutherDay4.setText(AstroWeatherValues.weather.getFutherWeathers().get(3).getDay());
        weatherFutherImg4.setImageResource(ImageResources.getImageResource(AstroWeatherValues.weather.getFutherWeathers().get(3).getImageCode()));
        weatherFutherTemp4.setText(AstroWeatherValues.weather.getFutherWeathers().get(3).getMinTemperature() + " - " +
                AstroWeatherValues.weather.getFutherWeathers().get(3).getMaxTemperature() + AstroWeatherValues.weather.getUnits().getTemperature());

        weatherFutherDay5.setText(AstroWeatherValues.weather.getFutherWeathers().get(4).getDay());
        weatherFutherImg5.setImageResource(ImageResources.getImageResource(AstroWeatherValues.weather.getFutherWeathers().get(4).getImageCode()));
        weatherFutherTemp5.setText(AstroWeatherValues.weather.getFutherWeathers().get(4).getMinTemperature() + " - " +
                AstroWeatherValues.weather.getFutherWeathers().get(4).getMaxTemperature() + AstroWeatherValues.weather.getUnits().getTemperature());

        weatherFutherDay6.setText(AstroWeatherValues.weather.getFutherWeathers().get(5).getDay());
        weatherFutherImg6.setImageResource(ImageResources.getImageResource(AstroWeatherValues.weather.getFutherWeathers().get(5).getImageCode()));
        weatherFutherTemp6.setText(AstroWeatherValues.weather.getFutherWeathers().get(5).getMinTemperature() + " - " +
                AstroWeatherValues.weather.getFutherWeathers().get(5).getMaxTemperature() + AstroWeatherValues.weather.getUnits().getTemperature());

        weatherFutherDay7.setText(AstroWeatherValues.weather.getFutherWeathers().get(6).getDay());
        weatherFutherImg7.setImageResource(ImageResources.getImageResource(AstroWeatherValues.weather.getFutherWeathers().get(6).getImageCode()));
        weatherFutherTemp7.setText(AstroWeatherValues.weather.getFutherWeathers().get(6).getMinTemperature() + " - " +
                AstroWeatherValues.weather.getFutherWeathers().get(6).getMaxTemperature() + AstroWeatherValues.weather.getUnits().getTemperature());

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
