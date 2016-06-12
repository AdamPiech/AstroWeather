package com.astroweather.adampiech.astroweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.astroweather.adampiech.astroweather.util.AstroWeatherValues;

import java.text.DecimalFormat;

public class SettingsActivity extends AppCompatActivity {

    private EditText longitudeView;
    private EditText latitudeView;
    private EditText refreshRateView;

    Spinner degreesList;
    Spinner localizationList;

    private DecimalFormat precision = new DecimalFormat("0.000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        longitudeView = (EditText) findViewById(R.id.textLongitude);
        latitudeView = (EditText) findViewById(R.id.textLatitude);
        refreshRateView = (EditText) findViewById(R.id.textRefresh);

        longitudeView.setText(precision.format(getIntent().getDoubleExtra(String.valueOf(R.string.longitude_value_name), AstroWeatherValues.longitude)).replace(",", "."));
        latitudeView.setText(precision.format(getIntent().getDoubleExtra(String.valueOf(R.string.latitude_value_name), AstroWeatherValues.latitude)).replace(",", "."));
        refreshRateView.setText(String.format("%d", getIntent().getIntExtra(String.valueOf(R.string.refreshTime_value_name), AstroWeatherValues.refreshTime)));

        degreesList = (Spinner) findViewById(R.id.spinnerDegrees);
        ArrayAdapter<CharSequence> degreesAdapter = ArrayAdapter.createFromResource(this,
                R.array.degrees, android.R.layout.simple_spinner_item);
        degreesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        degreesList.setAdapter(degreesAdapter);

        localizationList = (Spinner) findViewById(R.id.spinnerLocalization);
        ArrayAdapter<CharSequence> localizationAdapter = ArrayAdapter.createFromResource(this,
                R.array.localizations, android.R.layout.simple_spinner_item);
        localizationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        localizationList.setAdapter(localizationAdapter);
    }

    public void saveSettings(View view) {
        Intent intentResult = new Intent();
        intentResult.putExtra(String.valueOf(R.string.longitude_value_name), Double.valueOf(longitudeView.getText().toString().replace(",", ".")));
        intentResult.putExtra(String.valueOf(R.string.latitude_value_name), Double.valueOf(latitudeView.getText().toString().replace(",", ".")));
        intentResult.putExtra(String.valueOf(R.string.refreshTime_value_name), Integer.valueOf(refreshRateView.getText().toString().replace(",", ".")));
        setResult(1, intentResult);
        finish();
    }
}
