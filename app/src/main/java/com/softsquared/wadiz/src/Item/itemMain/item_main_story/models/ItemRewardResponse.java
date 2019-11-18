package com.softsquared.wadiz.src.Item.itemMain.item_main_story.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ItemRewardResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<ItemRewardlist> item;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ArrayList<ItemRewardlist> getItem() {
        return item;
    }
}