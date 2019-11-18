package com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FundingtResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    ArrayList<FundingItemlist> result;

    public ArrayList<FundingItemlist> getResult() {
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