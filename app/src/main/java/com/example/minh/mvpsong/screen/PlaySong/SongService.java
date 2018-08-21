package com.example.minh.mvpsong.screen.PlaySong;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.minh.mvpsong.data.model.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongService extends Service {
    private List<Song> mSongList;
    private int mPosition;
    public MediaPlayer mMediaPlayer;


    @Override
    public void onCreate() {
        super.onCreate();
        mMediaPlayer = new MediaPlayer();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mSongList = new ArrayList<>();
        Bundle bundle = intent.getExtras();
        mSongList = (List<Song>) bundle.getSerializable("song_list");
        mPosition = intent.getIntExtra("position", 0);
        playSong(mPosition);

        return super.onStartCommand(intent, flags, startId);
    }
    public class MyBinder extends Binder {
        public SongService getInstance() {
            return SongService.this;
        }
    }

    public void playSong(int positon) {
        try {
            if (mMediaPlayer != null) {
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.reset();
                    mMediaPlayer.setDataSource(mSongList.get(positon).getPath());
                    mMediaPlayer.start();
                } else {
                    mMediaPlayer.setDataSource(mSongList.get(positon).getPath());
                    mMediaPlayer.prepare();
                    mMediaPlayer.start();
                }
            }
        }catch (IOException e){
            Log.e("TAG", e.toString());
        }
    }

}
