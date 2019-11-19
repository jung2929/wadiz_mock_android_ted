package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models;

import java.io.Serializable;

public class RewardList {

    int rewardIdx;
    String name;
    int rewardNum;
    String info;
    String Money;

    public RewardList(int rewardIdx, String name, int rewardNum, String info, String money) {
        this.rewardIdx = rewardIdx;
        this.name = name;
        this.rewardNum = rewardNum;
        this.info = info;
        Money = money;
    }


    public int getRewardIdx() {
        return rewardIdx;
    }

    public void setRewardIdx(int rewardIdx) {
        this.rewardIdx = rewardIdx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRewardNum() {
        return rewardNum;
    }

    public void setRewardNum(int rewardNum) {
        this.rewardNum = rewardNum;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }
}
