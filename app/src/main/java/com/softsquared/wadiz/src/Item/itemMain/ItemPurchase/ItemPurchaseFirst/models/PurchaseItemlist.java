package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.models;

import com.google.gson.annotations.SerializedName;

public class PurchaseItemlist {
    @SerializedName("rewardPrice")
    public String Money;

    @SerializedName("rewardName")
    public String RewardName;

    @SerializedName("rewardInfo")
    public String Info;

    @SerializedName("shipping")
    public String DeliveryMoney;


    public PurchaseItemlist(String money, String rewardName, String info, String deliveryMoney) {
        Money = money;
        RewardName = rewardName;
        Info = info;
        DeliveryMoney = deliveryMoney;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }

    public String getRewardName() {
        return RewardName;
    }

    public void setRewardName(String rewardName) {
        RewardName = rewardName;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String getDeliveryMoney() {
        return DeliveryMoney;
    }

    public void setDeliveryMoney(String deliveryMoney) {
        DeliveryMoney = deliveryMoney;
    }

}
