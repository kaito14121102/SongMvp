package com.example.minh.mvpsong.data.source;

import com.example.minh.mvpsong.data.model.Song;

import java.util.List;

public interface SongsDataSource {


    interface LoadSongsCallback {
        void onSongsLoaded(List<Song> songList);
    }



    void getSongs(LoadSongsCallback callback);

}
