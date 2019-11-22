package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PostReward {
    @SerializedName("rewardList")
    ArrayList<PostRewardList> rewardList;

    @SerializedName("veliName")
    int veilName ;

    @SerializedName("veilPrice")
    int veilPrice;

    public PostReward(ArrayList<PostRewardList> rewardList, int veilName, int veilPrice) {
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

    public int getVeilName() {
        return veilName;
    }

    public void setVeilName(int veilName) {
        this.veilName = veilName;
    }

    public int getVeilPrice() {
        return veilPrice;
    }

    public void setVeilPrice(int veilPrice) {
        this.veilPrice = veilPrice;
    }
}
