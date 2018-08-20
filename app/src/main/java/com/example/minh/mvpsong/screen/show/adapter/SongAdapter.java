package com.example.minh.mvpsong.screen.show.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minh.mvpsong.R;
import com.example.minh.mvpsong.data.entity.Song;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {


    private List<Song> songList = new ArrayList<>();
    private Context context;

    public SongAdapter(List<Song> songList, Context context) {
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
    public void onBindViewHolder(@NonNull SongAdapter.ViewHolder holder, int position) {
        Song mSong = songList.get(position);
//        Picasso.with(context).load(sanPham.getAnh()).placeholder(R.drawable.load)
//                .error(R.drawable.error)
//                .into(holder.imgOk);
        holder.name.setText(mSong.getTitle());
    }


    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgOk;
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_name);
            //imgOk=itemView.findViewById(R.id.imgOk);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }
    }
}
