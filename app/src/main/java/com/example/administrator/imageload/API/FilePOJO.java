package com.example.administrator.imageload.API;

import com.google.gson.annotations.SerializedName;

public class FilePOJO {

    @SerializedName("title")
    String title;

    @SerializedName("id")
    String  id;

    @SerializedName("url")
    String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
