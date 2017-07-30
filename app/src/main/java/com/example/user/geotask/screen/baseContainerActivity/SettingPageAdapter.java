package com.example.user.geotask.screen.baseContainerActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.geotask.screen.beginningPathFragment.BeginningPathPageFragment;
import com.example.user.geotask.screen.endRoadFragment.EndRoadPageFragment;

/**
 * Created by User on 17.07.2017.
 */

public class SettingPageAdapter extends FragmentPagerAdapter {
    public static int totalPage = 2;

    public SettingPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = new Fragment();
        switch (position) {
            case 0:
                f = BeginningPathPageFragment.newInstance("","");
                break;
            case 1:
                f = EndRoadPageFragment.newInstance("","");
                break;

        }
        return f;
    }

    @Override
    public int getCount() {
        return totalPage;
    }
}
