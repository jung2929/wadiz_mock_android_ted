package com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseFirst.models;

public class PurchaseItemlist {
    public String Money;
    public String RewardName;
    public String Info;
    public String DeliveryMoney;
    public String DeliveryDay;

    public PurchaseItemlist(String money, String rewardName, String info, String deliveryMoney, String deliveryDay) {
        Money = money;
        RewardName = rewardName;
        Info = info;
        DeliveryMoney = deliveryMoney;
        DeliveryDay = deliveryDay;
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

    public String getDeliveryDay() {
        return DeliveryDay;
    }

    public void setDeliveryDay(String deliveryDay) {
        DeliveryDay = deliveryDay;
    }
}
