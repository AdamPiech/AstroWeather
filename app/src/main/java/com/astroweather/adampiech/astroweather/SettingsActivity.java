package com.astroweather.adampiech.astroweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class SettingsActivity extends AppCompatActivity {

    private EditText longitudeView;
    private EditText latitudeView;
    private EditText refreshRateView;

    private DecimalFormat precision = new DecimalFormat("0.000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        longitudeView = (EditText) findViewById(R.id.textLongitude);
        latitudeView = (EditText) findViewById(R.id.textLatitude);
        refreshRateView = (EditText) findViewById(R.id.textRefresh);

        longitudeView.setText(precision.format(getIntent().getDoubleExtra("longitude", AstroWeatherValues.longitude)));
        latitudeView.setText(precision.format(getIntent().getDoubleExtra("latitude", AstroWeatherValues.latitude)));
        refreshRateView.setText(String.format("%d", getIntent().getIntExtra("refreshTime", AstroWeatherValues.refreshTime)));
    }

    public void saveSettings(View view) {
        Intent intentResult = new Intent();
        intentResult.putExtra("longitude", Double.valueOf(longitudeView.getText().toString()));
        intentResult.putExtra("latitude", Double.valueOf(latitudeView.getText().toString()));
        intentResult.putExtra("refreshTime", Integer.valueOf(refreshRateView.getText().toString()));
        setResult(1, intentResult);
        finish();
    }
}
