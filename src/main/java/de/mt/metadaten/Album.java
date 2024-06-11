package de.mt.metadaten;

import java.util.ArrayList;
import java.util.List;

public class Album {


    private String ARTIST = "";
    private String ALBUM = "";
    private String YEAR = "";
    private List<Song> SONGS = new ArrayList<>();


    private String Land = "";
    private String Genres = "";
    private String Label = "";


    public Album(String artist, String album, String year) {
        this.ARTIST = artist;
        this.ALBUM = album;
        this.YEAR = year;
    }

    public String getArtist() {
        return ARTIST;
    }

    public String getAlbum() {
        return ALBUM;
    }

    public String getYear() {
        return YEAR;
    }

    public List<Song> getSongs() {
        return SONGS;
    }

    @Override
    public String toString() {
        return "Album{" +
                "ARTIST='" + ARTIST + '\'' +
                ", ALBUM='" + ALBUM + '\'' +
                ", YEAR='" + YEAR + '\'' +
                ", SONGS=" + SONGS +
                '}';
    }
}
