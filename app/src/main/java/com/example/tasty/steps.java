package com.example.tasty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class steps {
    @SerializedName("display_text")
    @Expose
    String display_text;

    public String getDisplay_text() {
        return display_text;
    }

    public void setDisplay_text(String display_text) {
        this.display_text = display_text;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @SerializedName("position")
    @Expose
    String position;
}
