package com.astroweather.adampiech.astroweather;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentActivity extends FragmentStatePagerAdapter {

    private Configuration conf;
    private int numberOfFragments = 2;
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
        }
        return null;
    }

    @Override
    public float getPageWidth(int position) {
        float nbPages;
        if(conf.orientation == Configuration.ORIENTATION_LANDSCAPE) {
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
