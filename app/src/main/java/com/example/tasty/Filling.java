package com.example.tasty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Filling {
    public ArrayList<UserModelForFilling> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<UserModelForFilling> components) {
        this.components = components;
    }

    @SerializedName("components")
    @Expose
    ArrayList<UserModelForFilling> components;
}
