package com.example.travelapp;

public class ModelHome {

    private String uid, Title, gridIcon;

    public ModelHome() {
    }

    public ModelHome(String uid, String title, String gridIcon) {
        this.uid = uid;
        Title = title;
        this.gridIcon = gridIcon;
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
}
