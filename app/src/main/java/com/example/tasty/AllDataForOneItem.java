package com.example.tasty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllDataForOneItem {
    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public List<Filling> getSections() {
        return sections;
    }

    public void setSections(List<Filling> sections) {
        this.sections = sections;
    }

    public String getYields() {
        return yields;
    }

    public void setYields(String yields) {
        this.yields = yields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<steps> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<steps> instructions) {
        this.instructions = instructions;
    }

    @SerializedName("thumbnail_url")
    @Expose
    String thumbnail_url;
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("yields")
    @Expose
    String yields;
    @SerializedName("instructions")
    @Expose
    ArrayList<steps> instructions;
    @SerializedName("sections")
    @Expose
    List<Filling> sections;
}
