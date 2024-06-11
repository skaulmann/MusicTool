package de.mt.metadaten;

import de.mt.restApi.DiscogsRequest;

public class MusicMetadatenHandler {

    private final String TITLE;
    private final String ARTIST;
    private final String YEAR;


    public MusicMetadatenHandler(String artist, String title, String year) {
        this.TITLE = title;
        this.ARTIST = artist;
        this.YEAR = year;
    }



    public void test(){
        getAllAlbumInfos();

    }


    public void getAllAlbumInfos(){
       MusicDatabaseQuerry querry = new DiscogsRequest();
       querry.getAllMetaData(new Album(ARTIST,TITLE,YEAR));

    }






}
