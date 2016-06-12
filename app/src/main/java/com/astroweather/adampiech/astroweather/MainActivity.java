package com.astroweather.adampiech.astroweather;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.astroweather.adampiech.astroweather.util.AstroWeatherValues;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;

    private double longitude = AstroWeatherValues.longitude;
    private double latitude = AstroWeatherValues.latitude;
    private int refreshTime = AstroWeatherValues.refreshTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new FragmentActivity(getSupportFragmentManager(), getResources().getConfiguration());
        pager.setAdapter(pagerAdapter);

        if(isOnline(getApplicationContext())) {
            showWarningNoInternetConnection();
        }
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
            intent.putExtra(String.valueOf(R.string.longitude_value_name), longitude);
            intent.putExtra(String.valueOf(R.string.latitude_value_name), latitude);
            intent.putExtra(String.valueOf(R.string.refreshTime_value_name), refreshTime);
            startActivityForResult(intent, 1);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            latitude = data.getDoubleExtra(String.valueOf(R.string.latitude_value_name), AstroWeatherValues.latitude);
            longitude = data.getDoubleExtra(String.valueOf(R.string.longitude_value_name), AstroWeatherValues.longitude);
            refreshTime = data.getIntExtra(String.valueOf(R.string.refreshTime_value_name), AstroWeatherValues.refreshTime);

            AstroWeatherValues.latitude = latitude;
            AstroWeatherValues.longitude = longitude;
            AstroWeatherValues.refreshTime = refreshTime;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble(String.valueOf(R.string.latitude_value_name), latitude);
        outState.putDouble(String.valueOf(R.string.longitude_value_name), longitude);
        outState.putInt(String.valueOf(R.string.refreshTime_value_name), refreshTime);
        outState.remove("android:support:fragments");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
        longitude = savedInstanceState.getDouble(String.valueOf(R.string.longitude_value_name));
        latitude = savedInstanceState.getDouble(String.valueOf(R.string.latitude_value_name));
        refreshTime = savedInstanceState.getInt(String.valueOf(R.string.refreshTime_value_name));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void showWarningNoInternetConnection() {
        new AlertDialog.Builder(this)
                .setTitle("Brak połączenia z internetem!")
                .setMessage("Aplikacja działa w trybie offline!")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (true) {
                            Toast.makeText(getApplicationContext(), R.string.no_weather_data_info, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), R.string.outdated_weather_data_info, Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .show();
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
