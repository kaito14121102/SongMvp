package com.example.minh.mvpsong.data.source;

import android.content.Context;

import com.example.minh.mvpsong.data.model.Song;
import com.example.minh.mvpsong.data.source.local.SongsLocalDataSource;

import java.util.List;

public class SongsRepository implements SongsDataSource {

    private SongsDataSource mSongsLocalDataResource;
    private static SongsRepository INSTANCE = null;
    private static Context mContext;
    private SongsRepository() {
        mSongsLocalDataResource = SongsLocalDataSource.getInstance(mContext);
    }
    public static SongsRepository getInstance(Context context) {
        if (INSTANCE == null) {
            mContext = context;
            INSTANCE = new SongsRepository();
        }
        return INSTANCE;
    }
    @Override
    public void getSongs(final LoadSongsCallback callback) {
        mSongsLocalDataResource.getSongs(new LoadSongsCallback() {
            @Override
            public void onSongsLoaded(List<Song> songList) {
                callback.onSongsLoaded(songList);
            }
        });
    }
}
