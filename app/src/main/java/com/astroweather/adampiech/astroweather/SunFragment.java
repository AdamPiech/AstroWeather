package com.astroweather.adampiech.astroweather;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.astrocalculator.AstroCalculator;
import com.astrocalculator.AstroDateTime;

import java.text.DecimalFormat;
import java.util.Calendar;

public class SunFragment extends Fragment {

    public static int refreshTime = 15;
    public static double longitude = 1.1;
    public static double latitude = 2.2;

    private Calendar calendar = Calendar.getInstance();
    private DecimalFormat precision = new DecimalFormat("0.00");

    private TextView timeView;
    private TextView locationView;

    private TextView timeSunriseView;
    private TextView coordinateSunriseView;
    private TextView timeSunsetView;
    private TextView coordinateSunsetView;
    private TextView timeTwilightView;
    private TextView timeDawnView;

    private Handler infoHandler = new Handler();
    private Handler timeHandler = new Handler();
    private Runnable infoRunnable = new Runnable() {
        public void run() {
            fillFields();
            infoHandler.postDelayed(infoRunnable, refreshTime * 60 * 1000);
        }
    };
    private Runnable timeRunnable = new Runnable() {
        public void run() {
            fillTimeAndLocation();
            calendar.add(Calendar.SECOND, 1);
            timeHandler.postDelayed(timeRunnable, 1000);
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_sun, container, false);
    }

    private void initTimeAndLocation() {
        timeView = (TextView) getActivity().findViewById(R.id.textSunTime);
        locationView = (TextView) getActivity().findViewById(R.id.textSunCoordinate);
    }

    private void initFields() {
        timeSunriseView = (TextView) getActivity().findViewById(R.id.textTimeSunrise);
        coordinateSunriseView = (TextView) getActivity().findViewById(R.id.textCoordinateSunrise);
        timeSunsetView = (TextView) getActivity().findViewById(R.id.textTimeSunset);
        coordinateSunsetView = (TextView) getActivity().findViewById(R.id.textCoordinateSunset);
        timeTwilightView = (TextView) getActivity().findViewById(R.id.textTimeTwilight);
        timeDawnView = (TextView) getActivity().findViewById(R.id.textTimeDawn);
    }

    private void fillTimeAndLocation() {
        if (timeView == null || locationView == null) {
            initTimeAndLocation();
        }
        timeView.setText(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
        locationView.setText(longitude + "   " + latitude);
    }

    private void fillFields() {
        if (timeSunriseView == null || coordinateSunriseView == null || timeSunsetView == null || coordinateSunsetView == null || timeTwilightView == null || timeDawnView == null) {
            initFields();
        }
        AstroDateTime astroDateTime = new AstroDateTime(
            calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND),
            calendar.get(Calendar.ZONE_OFFSET) / 60 * 60 * 1000, false);
        AstroCalculator astroCalculator = new AstroCalculator(astroDateTime, new AstroCalculator.Location(longitude, latitude));
        AstroCalculator.SunInfo sunInfo = astroCalculator.getSunInfo();

        timeSunriseView.setText(sunInfo.getSunrise().getHour() + ":" + sunInfo.getSunrise().getMinute() + ":" + sunInfo.getSunrise().getSecond());
        coordinateSunriseView.setText(precision.format(sunInfo.getAzimuthRise()));
        timeSunsetView.setText(sunInfo.getSunset().getHour() + ":" + sunInfo.getSunset().getMinute() + ":" + sunInfo.getSunset().getSecond());
        coordinateSunsetView.setText(precision.format(sunInfo.getAzimuthSet()));
        timeTwilightView.setText(sunInfo.getTwilightEvening().getHour() + ":" + sunInfo.getTwilightEvening().getMinute() + ":" + sunInfo.getTwilightEvening().getSecond());
        timeDawnView.setText(sunInfo.getTwilightMorning().getHour() + ":" + sunInfo.getTwilightMorning().getMinute() + ":" + sunInfo.getTwilightMorning().getSecond());
    }

    @Override
    public void onResume() {
        super.onResume();
//        infoHandler.removeCallbacks(infoRunnable);
//        timeHandler.removeCallbacks(timeRunnable);
//        fillFields();
//        fillTimeAndLocation();
        infoRunnable.run();
        timeRunnable.run();
    }

    @Override
    public void onPause() {
        super.onPause();
        infoHandler.removeCallbacks(infoRunnable);
        timeHandler.removeCallbacks(timeRunnable);
    }

}
