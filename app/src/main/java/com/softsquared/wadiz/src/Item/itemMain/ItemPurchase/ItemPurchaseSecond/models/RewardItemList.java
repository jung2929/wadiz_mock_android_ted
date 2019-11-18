package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models;

public class RewardItemList {
    String Name;
    String RewardNum;
    String RewardInfo;
    String Money;

    public RewardItemList(String name, String rewardNum, String rewardInfo, String money) {
        Name = name;
        RewardNum = rewardNum;
        RewardInfo = rewardInfo;
        Money = money;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRewardNum() {
        return RewardNum;
    }

    public void setRewardNum(String rewardNum) {
        RewardNum = rewardNum;
    }

    public String getRewardInfo() {
        return RewardInfo;
    }

    public void setRewardInfo(String rewardInfo) {
        RewardInfo = rewardInfo;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }
}
