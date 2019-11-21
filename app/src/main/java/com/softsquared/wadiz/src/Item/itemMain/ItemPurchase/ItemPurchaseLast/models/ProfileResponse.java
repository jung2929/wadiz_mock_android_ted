package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models;

import com.google.gson.annotations.SerializedName;

public class ProfileResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    ProfileList profileList = new ProfileList();

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ProfileList getProfileList() {
        return profileList;
    }
}