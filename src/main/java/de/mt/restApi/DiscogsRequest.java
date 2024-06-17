package de.mt.restApi;

import de.mt.metadaten.Album;
import de.mt.metadaten.annotations.AlbumMember;
import de.mt.uti.Util;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DiscogsRequest extends MusicDatabaseQuerry {


    private final String API_KEY = "PBizhwAtDEDfIjKfoAFIIVaTlqxsmnaUpAaFRPJD";
    private final String URL_START = "https://api.discogs.com/";
    private final String URL_SEARCH = "database/search?q=";


    public void testCall(String artist, String title, String year) {
        String url = createUrl(artist, title, year);
        System.out.println(url);
        HttpGet request = new HttpGet(url);
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            String responseBody = client.execute(request, new BasicResponseHandler());
            JSONObject json = new JSONObject(responseBody);
            JSONArray results = json.getJSONArray("results");
            JSONObject album = results.getJSONObject(0);
            String albumUrl = album.getString("resource_url");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void getAllMetaData(Album album) {
        JSONObject albumJson = getAlbumJson(getAlbumURL(album.getArtist(), album.getAlbum(), album.getYear()));
        insertAllAlbumMetaDataByJson(album, albumJson);




        super.getAllMetaData(album);
    }

    private static void insertAllAlbumMetaDataByJson(Album album, JSONObject albumJson) {
        for (String jsonKey : albumJson.keySet()) {
            Object jsonValue = albumJson.get(jsonKey);
            String jsonValueString;
            if (jsonValue instanceof Double || jsonValue instanceof Integer || jsonValue instanceof String ) {
                jsonValueString = String.valueOf(jsonValue);
                if (Util.isString(jsonValueString)) {
                    Class<Album> albumClass = Album.class;
                    for (Method m : albumClass.getMethods()) {
                        AlbumMember albumMemberAnnotation = m.getAnnotation(AlbumMember.class);
                        if (albumMemberAnnotation != null) {
                            if (albumMemberAnnotation.field().equals(jsonKey)) {
                                try {
                                    m.invoke(album, jsonValueString);
                                } catch (IllegalAccessException | InvocationTargetException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                }
            }
        }
        //ToDo Label und Genres muss noch hinzugefüt werden. Ist aber ein weiteres Objekt
        //if(Util.isString(albumJson.getString("")))
    }

    protected String getAlbumURL(String artist, String title, String year) {
        String url = createUrl(artist, title, year);
        System.out.println(url);
        HttpGet request = new HttpGet(url);
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            String responseBody = client.execute(request, new BasicResponseHandler());
            JSONObject json = new JSONObject(responseBody);
            JSONArray results = json.getJSONArray("results");
            JSONObject album = results.getJSONObject(0);
            return album.getString("resource_url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    protected JSONObject getAlbumJson(String url) {
        HttpGet request = new HttpGet(url);
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            String responseBody = client.execute(request, new BasicResponseHandler());
            JSONObject json = new JSONObject(responseBody);
            return json;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private String cleanQuerryParameter(String par) {
        String returnValue = par.replaceAll(" ", "+");
        return returnValue;
    }

    private String createUrl(String artist, String title, String year) {
        String url = URL_START + URL_SEARCH;
        if (!title.isEmpty()) {
            title = cleanQuerryParameter(title);
            url += "&title=" + title;
        }
        if (!artist.isEmpty()) {
            artist = cleanQuerryParameter(artist);
            url += "&artist=" + artist;
        }
        if (year.length() == 4 && year.matches("\\d")) {
            url += "&year=" + year;
        }
        url += "&token=" + API_KEY;
        return url;
    }
}
