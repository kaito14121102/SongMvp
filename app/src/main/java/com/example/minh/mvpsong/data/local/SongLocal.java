package com.example.minh.mvpsong.data.local;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.example.minh.mvpsong.data.entity.Song;

import java.util.ArrayList;
import java.util.List;

public class SongLocal {
    private Context mContext;

    public SongLocal(Context mContext) {
        this.mContext = mContext;
    }

    public List<Song> getListMp3(){
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION
        };
        final String sortOrder = MediaStore.Audio.AudioColumns.TITLE + " COLLATE LOCALIZED ASC";
        List<Song> mp3Files = new ArrayList<>();

        Cursor cursor = null;
        try {
            Uri uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            cursor = mContext.getContentResolver().query(uri, projection, selection, null, sortOrder);
            if( cursor != null){
                cursor.moveToFirst();

                while( !cursor.isAfterLast() ){
                    String title = cursor.getString(0);
                    String artist = cursor.getString(1);
                    String path = cursor.getString(2);
                    String displayName  = cursor.getString(3);
                    String songDuration = cursor.getString(4);
                    cursor.moveToNext();
                    if(path != null && path.endsWith(".mp3")) {
                        mp3Files.add(new Song(title,artist,path,displayName,songDuration));
                    }
                }

            }

            // print to see list of mp3 files
            for( Song file : mp3Files) {
                Log.i("TAG", file.getTitle()+"/"+file.getArtist()+"/"+file.getPath()+"/"+file.getDisplayName()+"/"+file.getSongDuration());
            }

        } catch (Exception e) {
            Log.e("TAG", e.toString());
        }finally{
            if( cursor != null){
                cursor.close();
            }
        }
        return mp3Files;
    }
}
