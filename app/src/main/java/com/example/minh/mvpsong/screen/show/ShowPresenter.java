package com.example.minh.mvpsong.screen.show;

import android.content.Context;

import com.example.minh.mvpsong.data.entity.Song;
import com.example.minh.mvpsong.data.local.SongLocal;

import java.util.ArrayList;
import java.util.List;

public class ShowPresenter implements ShowContract {

    private ShowCallBack mShowCallBack;
    private Context mContext;

    public ShowPresenter(Context context, ShowCallBack mShowCallBack) {
        this.mShowCallBack = mShowCallBack;
        this.mContext = context;
    }

    @Override
    public void loadSong() {
        SongLocal songLocal = new SongLocal(mContext);
        List<Song> songList = new ArrayList<>();
        songList = songLocal.getListMp3();
        if (songList.size() != 0) {
            mShowCallBack.showSuccess(songList);
        } else {
            mShowCallBack.showFail();
        }
    }

}
