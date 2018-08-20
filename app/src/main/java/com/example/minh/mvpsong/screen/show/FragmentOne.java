package com.example.minh.mvpsong.screen.show;

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
import com.example.minh.mvpsong.data.entity.Song;
import com.example.minh.mvpsong.screen.show.adapter.SongAdapter;

import java.util.List;

public class FragmentOne extends Fragment implements ShowContract.ShowCallBack {
    private RecyclerView mRecyclerView;
    private SongAdapter mSongAdapter;
    private View view;
    private ShowPresenter mShowPresenter;

    public FragmentOne() {
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
        mShowPresenter = new ShowPresenter(getActivity(), this);
        mShowPresenter.loadSong();
    }


    @Override
    public void showSuccess(List<Song> songList) {
        mSongAdapter = new SongAdapter(songList, getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mSongAdapter);
    }

    @Override
    public void showFail() {
        Toast.makeText(getActivity(), "Chua co du lieu", Toast.LENGTH_SHORT).show();
    }
}
