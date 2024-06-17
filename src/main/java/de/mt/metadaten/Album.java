package de.mt.metadaten;

import de.mt.metadaten.annotations.AlbumMember;

import java.util.*;

public class Album {


    private String Artist;
    private String Album;
    private String Year;

    private String Country;
    private String Genres;
    private String Label;

    private List<Song> Songs = new ArrayList<>();


    public Album(String artist, String album, String year) {
        this.Artist = artist;
        this.Album = album;
        this.Year = year;
    }



    public String getArtist() {
        return Artist;
    }

    @AlbumMember(field="artist")
    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getAlbum() {
        return Album;
    }

    @AlbumMember(field="album")
    public void setAlbum(String album) {
        Album = album;
    }

    public String getYear() {
        return Year;
    }

    @AlbumMember(field="year")
    public void setYear(String year) {
        Year = year;
    }

    public String getCountry() {
        return Country;
    }

    @AlbumMember(field="country")
    public void setCountry(String country) {
        Country = country;
    }

    public String getGenres() {
        return Genres;
    }

    @AlbumMember(field="genre")
    public void setGenres(String genres) {
        Genres = genres;
    }

    public String getLabel() {
        return Label;
    }

    @AlbumMember(field="label")
    public void setLabel(String label) {
        Label = label;
    }

    public List<Song> getSongs() {
        return Songs;
    }

    public void addSong(Song song) {
        Songs.add(song);
        sortSongs();
    }



    @Override
    public String toString() {
        return "Album{" +
                "ARTIST='" + Artist + '\'' +
                ", ALBUM='" + Album + '\'' +
                ", YEAR='" + Year + '\'' +
                ", SONGS=" + Songs +
                '}';
    }

    private void sortSongs() {
        Collections.sort(Songs, (song1, song2) -> {
            int song1Number, song2Number;
            try{
                song1Number = Integer.parseInt(song1.getNUMBER());
            }catch (NumberFormatException ex){
                System.err.println(song1.getNUMBER() + "Is not a number");
                song1Number = 0;
            }
            try{
                song2Number = Integer.parseInt(song2.getNUMBER());
            }catch (NumberFormatException ex) {
                System.out.println(song2.getNUMBER() + "is not a number");
                song2Number = 0;
            }
            return song1Number - song2Number;
        });
    }

}
