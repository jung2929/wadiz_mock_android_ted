package com.softsquared.wadiz.src.main.mypage.mypage_like.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LikeResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    ArrayList<LikeItemlist> result;

    public ArrayList<LikeItemlist> getResult() {
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