package com.astroweather.adampiech.astroweather;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.astroweather.adampiech.astroweather.fragments.ActualWeatherFragment;
import com.astroweather.adampiech.astroweather.fragments.FutherWeatherFragment;
import com.astroweather.adampiech.astroweather.fragments.MoonFragment;
import com.astroweather.adampiech.astroweather.fragments.SunFragment;
import com.astroweather.adampiech.astroweather.fragments.WindFragment;

public class FragmentActivity extends FragmentStatePagerAdapter {

    private Configuration conf;
    private int numberOfFragments = 5;
    private String fragmentTitle[] = {"Sun Weather", "Moon Weather"};

    public FragmentActivity(FragmentManager fragmentManager, Configuration conf) {
        super(fragmentManager);
        this.conf = conf;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SunFragment();
            case 1:
                return new MoonFragment();
            case 2:
                return new ActualWeatherFragment();
            case 3:
                return new WindFragment();
            case 4:
                return new FutherWeatherFragment();
        }
        return null;
    }

    @Override
    public float getPageWidth(int position) {
        float nbPages;
        if (conf.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            nbPages = 2;
        } else {
            nbPages = 1;
        }
        return (1 / nbPages);
    }

    @Override
    public int getCount() {
        return numberOfFragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle[position];
    }
}
