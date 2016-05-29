package com.astroweather.adampiech.astroweather;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;

    private double latitude = AstroWeatherValues.longitude;
    private double longitude = AstroWeatherValues.latitude;
    private int refreshTime = AstroWeatherValues.refreshTime;

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
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            intent.putExtra("longitude", longitude);
            intent.putExtra("latitude", latitude);
            intent.putExtra("refreshTime", refreshTime);
            Log.d("DUPA", "4");
            startActivityForResult(intent, 1);
            Log.d("DUPA", "5");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            latitude = data.getDoubleExtra("longitude", AstroWeatherValues.latitude);
            longitude = data.getDoubleExtra("latitude", AstroWeatherValues.longitude);
            refreshTime = data.getIntExtra("refreshTime", AstroWeatherValues.refreshTime);

            AstroWeatherValues.latitude = latitude;
            AstroWeatherValues.longitude = longitude;
            AstroWeatherValues.refreshTime = refreshTime;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("longitude", latitude);
        outState.putDouble("latitude", longitude);
        outState.putInt("refreshTime", refreshTime);
        outState.remove("android:support:fragments");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        latitude = savedInstanceState.getDouble("longitude");
        longitude = savedInstanceState.getDouble("latitude");
        refreshTime = savedInstanceState.getInt("refreshTime");
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
