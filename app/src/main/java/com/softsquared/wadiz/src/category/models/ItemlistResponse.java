package com.softsquared.wadiz.src.category.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ItemlistResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<Itemlist> result = null;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ArrayList<Itemlist> getResult() {
        return result;
    }
}