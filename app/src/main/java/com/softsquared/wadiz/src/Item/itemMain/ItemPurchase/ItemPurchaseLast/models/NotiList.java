package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models;

import com.google.gson.annotations.SerializedName;

public class NotiList {
    @SerializedName("title")
    String title;

    @SerializedName("contents")
    String contents;

    public NotiList(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
