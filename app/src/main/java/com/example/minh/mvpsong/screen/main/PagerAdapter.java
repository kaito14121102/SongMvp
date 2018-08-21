package com.example.minh.mvpsong.screen.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.minh.mvpsong.screen.songs.SongsFragment;
import com.example.minh.mvpsong.ultil.Constant;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private FragmentTwo mFragmentTwo;
    private SongsFragment mFragmentOne;

    public PagerAdapter(FragmentManager fm, SongsFragment fragmentOne, FragmentTwo fragmentTwo) {
        super(fm);
        this.mFragmentOne = fragmentOne;
        this.mFragmentTwo = fragmentTwo;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case Constant.SONG_LIST:
                return mFragmentOne;
            default:
                return mFragmentTwo;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position) {
            case 0:
                title = Constant.FRAGMENT_SONG_LIST;
                break;
            case 1:
                title = Constant.FRAGMENT_SONG_PLAY;
                break;

        }
        return title;
    }
}
