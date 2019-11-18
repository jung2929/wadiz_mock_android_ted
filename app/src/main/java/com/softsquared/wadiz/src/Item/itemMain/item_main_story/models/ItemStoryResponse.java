package com.softsquared.wadiz.src.Item.itemMain.item_main_story.models;

import com.google.gson.annotations.SerializedName;

public class ItemStoryResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ItemStorylist item;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ItemStorylist getItem() {
        return item;
    }
}