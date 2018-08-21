package com.example.minh.mvpsong.screen.songs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.minh.mvpsong.R;
import com.example.minh.mvpsong.data.model.Song;
import com.example.minh.mvpsong.screen.PlaySong.SongPlayActivity;
import com.example.minh.mvpsong.screen.songs.songsadapter.SongsClickItem;
import com.example.minh.mvpsong.screen.songs.songsadapter.SongsAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SongsFragment extends Fragment implements SongsContract.View,SongsClickItem{
    private RecyclerView mRecyclerView;
    private SongsAdapter mSongAdapter;
    private View view;
    private SongsContract.Presenter mShowPresenter;
    private List<Song> mListSong;

    public SongsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);
        init();
        return view;
    }

    private void init() {
        mRecyclerView = view.findViewById(R.id.recycle_view_song);
        mListSong = new ArrayList<>();
        mShowPresenter.loadSongs();
    }

    // Presenter trả về dữ liệu cho view
    @Override
    public void showSuccess(List<Song> songList) {
        mSongAdapter = new SongsAdapter(this,songList, getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mSongAdapter);
        mListSong = songList;
    }

    @Override
    public void showFail() {
        Toast.makeText(getActivity(), "Chua co du lieu", Toast.LENGTH_SHORT).show();
    }

    //Sự kiện click chuyển sang màn hình playsong
    @Override
    public void clickSong(int position) {
        Intent mIntent = new Intent(getActivity(), SongPlayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("song_list", (Serializable) mListSong);
        mIntent.putExtras(bundle);
        mIntent.putExtra("position",position);
        startActivity(mIntent);
    }


    @Override
    public void setPresenter(SongsContract.Presenter presenter) {
        mShowPresenter = presenter;
    }

}
