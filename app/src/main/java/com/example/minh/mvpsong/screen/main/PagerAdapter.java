package com.example.minh.mvpsong.screen.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.minh.mvpsong.screen.show.FragmentOne;
import com.example.minh.mvpsong.ultil.Constant;

public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case Constant.SONG_LIST:
                frag = new FragmentOne();
                break;
            case Constant.SONG_PLAY:
                frag = new FragmentTwo();
                break;
        }
        return frag;
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
