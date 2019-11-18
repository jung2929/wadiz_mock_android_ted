package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.models;

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
    private ArrayList<PurchaseItemlist> item;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }

    public ArrayList<PurchaseItemlist> getItem() {
        return item;
    }
}