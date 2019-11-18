package com.softsquared.wadiz.src.Item.itemMain.policy.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PolicyResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("isSuccess")
    private boolean isSuccess;

    @SerializedName("result")
    PolicyList result;

    public PolicyList getResult() {
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

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void setResult(PolicyList result) {
        this.result = result;
    }
}