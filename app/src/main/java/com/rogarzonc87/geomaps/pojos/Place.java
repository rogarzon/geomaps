package com.rogarzonc87.geomaps.pojos;

public class Place {
    private String title;
    private int image;
    private double lat;
    private double lon;

    public Place(String title, int image, double lat, double lon) {
        this.title = title;
        this.image = image;
        this.lat = lat;
        this.lon = lon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
