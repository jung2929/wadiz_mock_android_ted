package com.softsquared.wadiz.src.main.reward.reward_home.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchItemResponse {

    @SerializedName("isSuccess")
    private Boolean isSuccess;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("result")
    SearchItemList result;

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SearchItemList getResult() {
        return result;
    }

    public void setResult(SearchItemList result) {
        this.result = result;
    }
}
