package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models;

import com.google.gson.annotations.SerializedName;

public class CardList {
    @SerializedName("card")
    String card;

    @SerializedName("registration")
    String registration;

    @SerializedName("cardName")
    String cardname;

    public CardList(String card, String registration, String cardname) {
        this.card = card;
        this.registration = registration;
        this.cardname = cardname;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname;
    }
}
