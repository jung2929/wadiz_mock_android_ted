package com.softsquared.wadiz.src.Item.itemMain.policy.models;

import com.google.gson.annotations.SerializedName;

public class PolicyList {
    @SerializedName("makerName")
    String makerName;

    @SerializedName("rewardDate")
    String rewardDate;

    @SerializedName("deliveryDate")
    String deliveryDate;

    public PolicyList(String makerName, String rewardDate, String deliveryDate) {
        this.makerName = makerName;
        this.rewardDate = rewardDate;
        this.deliveryDate = deliveryDate;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public String getRewardDate() {
        return rewardDate;
    }

    public void setRewardDate(String rewardDate) {
        this.rewardDate = rewardDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
