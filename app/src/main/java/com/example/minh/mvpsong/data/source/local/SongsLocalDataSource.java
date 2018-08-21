package com.example.minh.mvpsong.data.source.local;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import com.example.minh.mvpsong.data.model.Song;
import com.example.minh.mvpsong.data.source.SongsDataSource;

import java.util.ArrayList;
import java.util.List;

public class SongsLocalDataSource implements SongsDataSource {
    private static Context mContext;
    private static SongsLocalDataSource INSTANCE = null;
    private MediaMetadataRetriever metaRetriver = new MediaMetadataRetriever();

    private SongsLocalDataSource() {
    }

    public static SongsDataSource getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new SongsLocalDataSource();
            mContext = context;
        }
        return INSTANCE;
    }

    @Override
    public void getSongs(LoadSongsCallback callback) {
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION
        };
        final String sortOrder = MediaStore.Audio.AudioColumns.TITLE + " COLLATE LOCALIZED ASC";
        List<Song> songs = new ArrayList<>();

        Cursor cursor = null;
        try {
            Uri uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            cursor = mContext.getContentResolver().query(uri, projection, selection, null, sortOrder);
            if (cursor != null) {
                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {
                    String title = cursor.getString(0);
                    String artist = cursor.getString(1);
                    String path = cursor.getString(2);
                    String displayName = cursor.getString(3);
                    String songDuration = cursor.getString(4);
                    metaRetriver.setDataSource(path);
                    byte[] mImage = metaRetriver.getEmbeddedPicture();
                    cursor.moveToNext();
                    if (path != null && path.endsWith(".mp3")) {
                        songs.add(new Song(title, artist, path, displayName, songDuration, mImage));
                    }
                }
                if(!songs.isEmpty()){
                    callback.onSongsLoaded(songs);
                }

            }

            // print to see list of mp3 files
            for (Song file : songs) {
                Log.i("TAG", file.getTitle() + "/" + file.getArtist() + "/" + file.getPath() + "/" + file.getDisplayName() + "/" + file.getSongDuration());
            }

        } catch (Exception e) {
            Log.e("TAG", e.toString());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

    }



}
