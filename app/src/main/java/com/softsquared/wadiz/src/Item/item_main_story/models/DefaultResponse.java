package com.softsquared.wadiz.src.Item.item_main_story.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DefaultResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<Itemmainlist> item = null;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ArrayList<Itemmainlist> getItem() {
        return item;
    }
}