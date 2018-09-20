package com.example.rany.moviescrapdemo.model;

public class Movie {
    private String title;
    private String thumbnail;
    private String subTitle;
    private String duration;
    private String url;

    public Movie(String title, String thumbnail, String subTitle, String duration, String url) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.subTitle = subTitle;
        this.duration = duration;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
