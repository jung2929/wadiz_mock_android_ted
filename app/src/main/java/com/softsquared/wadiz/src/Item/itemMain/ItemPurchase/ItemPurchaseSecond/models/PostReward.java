package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PostReward {
    @SerializedName("rewardList")
    ArrayList<PostRewardList> rewardList;

    @SerializedName("veliName")
    boolean veilName ;

    @SerializedName("veilPrice")
    boolean veilPrice;

    public PostReward(ArrayList<PostRewardList> rewardList, boolean veilName, boolean veilPrice) {
        this.rewardList = rewardList;
        this.veilName = veilName;
        this.veilPrice = veilPrice;
    }

    public ArrayList<PostRewardList> getRewardList() {
        return rewardList;
    }

    public void setRewardList(ArrayList<PostRewardList> rewardList) {
        this.rewardList = rewardList;
    }

    public boolean isVeilName() {
        return veilName;
    }

    public void setVeilName(boolean veilName) {
        this.veilName = veilName;
    }

    public boolean isVeilPrice() {
        return veilPrice;
    }

    public void setVeilPrice(boolean veilPrice) {
        this.veilPrice = veilPrice;
    }
}
