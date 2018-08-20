package com.example.minh.mvpsong.screen.show;

import com.example.minh.mvpsong.data.entity.Song;

import java.util.List;

public interface ShowContract {
    void loadSong();
    public interface ShowCallBack{
        void showSuccess(List<Song> songList);
        void showFail();
    }
}
