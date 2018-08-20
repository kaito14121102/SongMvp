package com.example.minh.mvpsong.data.entity;

public class Song {
    private String title;
    private String artist;
    private String path;
    private String displayName;
    private String songDuration;

    public Song() {
    }

    public Song(String title, String artist, String path, String displayName, String songDuration) {
        this.title = title;
        this.artist = artist;
        this.path = path;
        this.displayName = displayName;
        this.songDuration = songDuration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }
}
