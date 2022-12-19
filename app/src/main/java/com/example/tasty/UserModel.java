package com.example.tasty;

import androidx.viewpager2.widget.ViewPager2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {
    @SerializedName("thumbnail_url")
    @Expose
    String thumbnail_url;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("id")
    @Expose
    Integer id;

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public UserModel(String thumbnail_url, String name) {
        this.thumbnail_url = thumbnail_url;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getImage() {
        return thumbnail_url;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "thumbnail_url='" + thumbnail_url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setImage(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }
}
