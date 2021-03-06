package com.softsquared.wadiz.src.Item.itemMain.item_main_story.models;

import com.google.gson.annotations.SerializedName;

public class LikedResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    LikedList likedList;

    public LikedList getLikedList() {
        return likedList;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }
}