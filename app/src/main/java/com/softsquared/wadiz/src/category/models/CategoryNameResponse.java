package com.softsquared.wadiz.src.category.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoryNameResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    private ArrayList<CategoryNamelist> result = null;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ArrayList<CategoryNamelist> getResult() {
        return result;
    }
}