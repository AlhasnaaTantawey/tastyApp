package com.example.tasty;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Item {
    @SerializedName("name")
    @Expose
    String name;

    public OneItem getOneItem() {
        return oneItem;
    }

    public void setOneItem(OneItem oneItem) {
        this.oneItem = oneItem;
    }

    @SerializedName("type")
    @Expose
    String type;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<UserModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<UserModel> items) {
        this.items = items;
    }

    @SerializedName("items")
    @Expose
    ArrayList<UserModel> items;
    @SerializedName("item")
    @Expose
    OneItem oneItem;
}
