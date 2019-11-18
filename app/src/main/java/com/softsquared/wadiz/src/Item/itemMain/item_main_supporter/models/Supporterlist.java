package com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.models;

import com.google.gson.annotations.SerializedName;

public class Supporterlist {
    @SerializedName("profileImg")
    public String Image;

    @SerializedName("veilName")
    public String Name;

    @SerializedName("veilPrice")
    public String Money;

    @SerializedName("userIdx")
    public int userIdx;

    public Supporterlist(String image, String name, String money, int userIdx) {
        Image = image;
        Name = name;
        Money = money;
        this.userIdx = userIdx;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }

    public int getUserIdx() {
        return userIdx;
    }

    public void setUserIdx(int userIdx) {
        this.userIdx = userIdx;
    }
}
