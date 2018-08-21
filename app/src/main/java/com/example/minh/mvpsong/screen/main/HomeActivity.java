package com.example.minh.mvpsong.screen.main;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.minh.mvpsong.R;
import com.example.minh.mvpsong.data.source.SongsRepository;
import com.example.minh.mvpsong.screen.songs.SongsFragment;
import com.example.minh.mvpsong.screen.songs.SongsPresenter;

public class HomeActivity extends AppCompatActivity {
    private ViewPager mPager;
    private TabLayout mTabLayout;
    private SongsPresenter mSongsPresenter;
    private SongsFragment mFragmentOne;
    private FragmentTwo mFragmentTwo;
    private FragmentManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        addControl();
    }

    private void init() {
        mFragmentOne = new SongsFragment();
        mFragmentTwo = new FragmentTwo();
        mSongsPresenter = new SongsPresenter(mFragmentOne, SongsRepository.getInstance(this));
    }

    private void addControl() {
        mPager = (ViewPager) findViewById(R.id.view_pager);
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mManager = getSupportFragmentManager();
        PagerAdapter adapter = new PagerAdapter(mManager, mFragmentOne, mFragmentTwo);
        mPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mPager);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setTabsFromPagerAdapter(adapter);
    }

}
