package com.example.minh.mvpsong.screen.songs;

import android.content.Context;

import com.example.minh.mvpsong.data.model.Song;
import com.example.minh.mvpsong.data.source.SongsDataSource;
import com.example.minh.mvpsong.data.source.SongsRepository;

import java.util.ArrayList;
import java.util.List;

public class SongsPresenter implements SongsContract.Presenter {

    private SongsContract.View mView;
    private Context mContext;
    private SongsRepository mSongsRepository;


    public SongsPresenter(SongsContract.View mView, SongsRepository mSongsRepository) {
        this.mSongsRepository = mSongsRepository;
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void loadSongs() {
        mSongsRepository.getSongs(new SongsDataSource.LoadSongsCallback() {
            @Override
            public void onSongsLoaded(List<Song> songList) {
                List<Song> songToShow = new ArrayList<>();
                if (!songList.isEmpty()) {
                    mView.showSuccess(songList);
                } else mView.showFail();
            }
        });
    }

}
