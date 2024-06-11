package de.mt.metadaten;

public class Song {

    private String NUMBER = "";
    private String NAME = "";
    private String DURATION = "";


    public Song(String number, String name, String duration) {
        this.NUMBER = number;
        this.NAME = name;
        this.DURATION = duration;
    }

    public Song(String number, String name) {
        this.NUMBER = number;
        this.NAME = name;
        this.DURATION = "";
    }

    public String getNUMBER() {
        return NUMBER;
    }

    public void setNUMBER(String NUMBER) {
        this.NUMBER = NUMBER;
    }

    public String getDURATION() {
        return DURATION;
    }

    public void setDURATION(String DURATION) {
        this.DURATION = DURATION;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public String toString() {
        return "Song{" +
                "NUMBER='" + NUMBER + '\'' +
                ", DURATION='" + DURATION + '\'' +
                ", NAME='" + NAME + '\'' +
                '}';
    }
}
