package com.astroweather.adampiech.astroweather;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import android.os.Handler;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;

    private int refreshTime = 15;
    private double longitude = 1.1;
    private double latitude = 2.2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new FragmentActivity(getSupportFragmentManager(), getResources().getConfiguration());
        pager.setAdapter(pagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_main) {
            setContentView(R.layout.activity_main);
            return true;
        }
        if (id == R.id.action_settings) {
            setContentView(R.layout.activity_settings);
            ((EditText) findViewById(R.id.textRefresh)).setText(String.valueOf(refreshTime));
            ((EditText) findViewById(R.id.textLongitude)).setText(String.valueOf(longitude));
            ((EditText) findViewById(R.id.textLatitude)).setText(String.valueOf(latitude));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveSettings(View view) {
        refreshTime = Integer.parseInt(((EditText) findViewById(R.id.textRefresh)).getText().toString());
        longitude = Double.parseDouble(((EditText) findViewById(R.id.textLongitude)).getText().toString());
        latitude = Double.parseDouble(((EditText) findViewById(R.id.textLatitude)).getText().toString());
        sendDataOut();
    }

    private void sendDataOut () {
        SunFragment.refreshTime = refreshTime;
        SunFragment.longitude = longitude;
        SunFragment.latitude = latitude;
        MoonFragment.refreshTime = refreshTime;
        MoonFragment.longitude = longitude;
        MoonFragment.latitude = latitude;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
