package com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.models;

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
    SupporterResult result;

    public SupporterResult getResult() {
        return result;
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