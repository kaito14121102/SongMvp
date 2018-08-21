package com.example.minh.mvpsong.screen.songs.songsadapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minh.mvpsong.R;
import com.example.minh.mvpsong.data.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    private SongsClickItem mClickSongItem;
    private List<Song> songList = new ArrayList<>();
    private Context context;

    public SongsAdapter(SongsClickItem mClickSongItem, List<Song> songList, Context context) {
        this.mClickSongItem = mClickSongItem;
        this.songList = songList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongsAdapter.ViewHolder holder, int position) {
        Song mSong = songList.get(position);
        holder.mName.setText(mSong.getTitle());
        if(mSong.getImage()!=null) {
            holder.mImageSong.setImageBitmap(BitmapFactory.decodeByteArray(mSong.getImage(), 0, mSong.getImage().length));
        }
    }


    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageSong;
        public TextView mName;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.text_name);
            mImageSong=itemView.findViewById(R.id.image_song_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mClickSongItem.clickSong(getPosition());
                }
            });
        }
    }
}
