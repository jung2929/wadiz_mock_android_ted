package com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.models;

import com.google.gson.annotations.SerializedName;

import retrofit2.SkipCallbackExecutor;

public class RegisterCardList {
    @SerializedName("card")
    String card;

    @SerializedName("birth")
    String birth;

    public RegisterCardList(String card, String birth) {
        this.card = card;
        this.birth = birth;
    }

    public String getCard() {
        return card;
    }

    public String getBirth() {
        return birth;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
