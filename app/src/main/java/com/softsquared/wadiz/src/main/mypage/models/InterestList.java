package com.softsquared.wadiz.src.main.mypage.models;

import com.google.gson.annotations.SerializedName;

public class InterestList {

    @SerializedName("category")
    String interest;

    public InterestList(String interest) {
        this.interest = interest;
    }

    public String getInterest() {
        return interest;
    }
}
