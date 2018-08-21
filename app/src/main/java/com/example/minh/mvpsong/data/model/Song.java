package com.example.minh.mvpsong.data.model;

import java.io.Serializable;

public class Song implements Serializable{
    private String mTitle;
    private String mArtist;
    private String mPath;
    private String mDisplayName;
    private String mSongDuration;
    private byte[] mImage;

    public Song() {
    }

    public Song(String title, String artist, String path, String displayName, String songDuration, byte[] image) {
        this.mTitle = title;
        this.mArtist = artist;
        this.mPath = path;
        this.mDisplayName = displayName;
        this.mSongDuration = songDuration;
        this.mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        this.mArtist = artist;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        this.mPath = path;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String displayName) {
        this.mDisplayName = displayName;
    }

    public byte[] getImage() {
        return mImage;
    }

    public void setImage(byte[] image) {
        this.mImage = image;
    }

    public String getSongDuration() {
        return mSongDuration;
    }

    public void setSongDuration(String songDuration) {
        this.mSongDuration = songDuration;
    }
}
