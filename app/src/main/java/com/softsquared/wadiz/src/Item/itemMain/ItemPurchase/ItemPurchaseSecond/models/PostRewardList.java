package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models;

import com.google.gson.annotations.SerializedName;

public class PostRewardList {
    @SerializedName("rewardIdx")
    int rewardIdx;

    @SerializedName("quantity")
    int quantity;

    public PostRewardList(int rewardIdx, int quantity) {
        this.rewardIdx = rewardIdx;
        this.quantity = quantity;
    }

    public int getRewardIdx() {
        return rewardIdx;
    }

    public void setRewardIdx(int rewardIdx) {
        this.rewardIdx = rewardIdx;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
