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

public class MoonFragment extends Fragment {

    public static int refreshTime = 15;
    public static double longitude = 1.1;
    public static double latitude = 2.2;

    private Calendar calendar = Calendar.getInstance();
    private DecimalFormat precision = new DecimalFormat("0");

    private TextView timeView;
    private TextView locationView;

    private TextView timeMoonriseView;
    private TextView timeWaneView;
    private TextView dateNewMoonView;
    private TextView timeFullMoonView;
    private TextView percentPhaseOfTheMoonView;
    private TextView dayOfTheMonthSynodicalView;

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
        return inflater.inflate(R.layout.activity_moon, container, false);
    }

    private void initTimeAndLocation() {
        timeView = (TextView) getActivity().findViewById(R.id.textMoonTime);
        locationView = (TextView) getActivity().findViewById(R.id.textMoonCoordinate);
    }

    private void initFields() {
        timeMoonriseView = (TextView) getActivity().findViewById(R.id.textTimeMoonrise);
        timeWaneView = (TextView) getActivity().findViewById(R.id.textTimeWane);
        dateNewMoonView = (TextView) getActivity().findViewById(R.id.textDateNewMoon);
        timeFullMoonView = (TextView) getActivity().findViewById(R.id.textTimeFullMoon);
        percentPhaseOfTheMoonView = (TextView) getActivity().findViewById(R.id.textPercentPhaseOfTheMoon);
        dayOfTheMonthSynodicalView = (TextView) getActivity().findViewById(R.id.textDayOfTheMonthSynodical);
    }

    private void fillTimeAndLocation() {
        if (timeView == null || locationView == null) {
            initTimeAndLocation();
        }
        timeView.setText(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
        locationView.setText(longitude + "   " + latitude);
    }

    private void fillFields() {
        if (timeMoonriseView == null || timeWaneView == null || dateNewMoonView == null || timeFullMoonView == null || percentPhaseOfTheMoonView == null || dayOfTheMonthSynodicalView == null) {
            initFields();
        }
        AstroDateTime astroDateTime = new AstroDateTime(
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND),
                calendar.get(Calendar.ZONE_OFFSET) / 60 * 60 * 1000, false);
        AstroCalculator astroCalculator = new AstroCalculator(astroDateTime, new AstroCalculator.Location(longitude, latitude));
        AstroCalculator.MoonInfo moonInfo = astroCalculator.getMoonInfo();

        timeMoonriseView.setText(moonInfo.getMoonrise().getHour() + ":" + moonInfo.getMoonrise().getMinute() + ":" + moonInfo.getMoonrise().getSecond());
        timeWaneView.setText(moonInfo.getMoonset().getHour() + ":" + moonInfo.getMoonset().getMinute() + ":" + moonInfo.getMoonset().getSecond());
        dateNewMoonView.setText(moonInfo.getNextNewMoon().getDay() + " - " + moonInfo.getNextNewMoon().getMonth() + " - " + moonInfo.getNextNewMoon().getYear());
        timeFullMoonView.setText(moonInfo.getNextFullMoon().getDay() + " - " + moonInfo.getNextFullMoon().getMonth() + " - " + moonInfo.getNextFullMoon().getYear());
        percentPhaseOfTheMoonView.setText(precision.format(moonInfo.getIllumination() * 100) + "%");
        dayOfTheMonthSynodicalView.setText(precision.format(moonInfo.getAge()));
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
