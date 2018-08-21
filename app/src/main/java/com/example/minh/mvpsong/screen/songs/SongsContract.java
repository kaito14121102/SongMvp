package com.example.minh.mvpsong.screen.songs;

import com.example.minh.mvpsong.BaseView;
import com.example.minh.mvpsong.data.model.Song;

import java.util.List;

public interface SongsContract {

    interface View extends BaseView<Presenter>{
        void showSuccess(List<Song> songList);
        void showFail();
    }

    interface Presenter{
        void loadSongs();
    }
}
