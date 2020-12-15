package com.example.travelapp;

public class ModelHome {

    private String uid, Title, gridIcon, description, latitude, longitude, timings;

    public ModelHome() {
    }

    public ModelHome(String uid, String title, String gridIcon, String description, String latitude, String longitude, String timings) {
        this.uid = uid;
        Title = title;
        this.gridIcon = gridIcon;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timings = timings;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getGridIcon() {
        return gridIcon;
    }

    public void setGridIcon(String gridIcon) {
        this.gridIcon = gridIcon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }
}
