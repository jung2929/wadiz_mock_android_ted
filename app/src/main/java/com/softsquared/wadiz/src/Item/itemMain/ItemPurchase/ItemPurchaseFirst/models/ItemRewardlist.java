package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.models;

import com.google.gson.annotations.SerializedName;

public class ItemRewardlist {
    @SerializedName("rewardIdx")
    int rewardIdx;
    @SerializedName("rewardPrice")
    String rewardPrice;
    @SerializedName("rewardName")
    String rewardName;
    @SerializedName("rewardInfo")
    String rewardInfo;
    @SerializedName("shipping")
    String shipping;
    @SerializedName("quantity")
    String quantity;
    @SerializedName("remaining")
    String remaining;
    @SerializedName("completion")
    String completion;

    public ItemRewardlist(int rewardIdx, String rewardPrice, String rewardName, String rewardInfo, String shipping, String quantity, String remaining, String completion) {
        this.rewardIdx = rewardIdx;
        this.rewardPrice = rewardPrice;
        this.rewardName = rewardName;
        this.rewardInfo = rewardInfo;
        this.shipping = shipping;
        this.quantity = quantity;
        this.remaining = remaining;
        this.completion = completion;
    }

    public int getRewardIdx() {
        return rewardIdx;
    }

    public void setRewardIdx(int rewardIdx) {
        this.rewardIdx = rewardIdx;
    }

    public String getRewardPrice() {
        return rewardPrice;
    }

    public void setRewardPrice(String rewardPrice) {
        this.rewardPrice = rewardPrice;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public String getRewardInfo() {
        return rewardInfo;
    }

    public void setRewardInfo(String rewardInfo) {
        this.rewardInfo = rewardInfo;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public String getCompletion() {
        return completion;
    }

    public void setCompletion(String completion) {
        this.completion = completion;
    }
}

