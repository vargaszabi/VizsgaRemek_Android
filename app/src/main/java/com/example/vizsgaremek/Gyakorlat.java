package com.example.vizsgaremek;


import java.util.List;

public class Gyakorlat {
    public String gyakorlat_id;
    public String name;
    public String media;
    public String description;

    public String getGyakorlat_id() {
        return gyakorlat_id;
    }

    public void setGyakorlat_id(String gyakorlat_id) {
        this.gyakorlat_id = gyakorlat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gyakorlat(String gyakorlat_id, String name, String media, String description) {
        this.gyakorlat_id = gyakorlat_id;
        this.name = name;
        this.media = media;
        this.description = description;
    }
    class GyakorlatListHelper{
        private List<Gyakorlat> gyakorlat;

        public List<Gyakorlat> getGyakorlat() {
            return gyakorlat;
        }
    }
}
