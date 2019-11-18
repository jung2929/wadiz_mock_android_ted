package com.softsquared.wadiz.src.main.reward.reward_open.models;

import com.google.gson.annotations.SerializedName;

public class Openlist {
    @SerializedName("thumnail")
    String Image;

    @SerializedName("title")
    String Name;

    @SerializedName("projectIdx")
    int ProjevtIdx;

    @SerializedName("makerName")
    String Company;

    @SerializedName("expected")
    String Month;

    public Openlist(String image, String name, int projevtIdx, String company, String month) {
        Image = image;
        Name = name;
        ProjevtIdx = projevtIdx;
        Company = company;
        Month = month;
    }

    public String getImage() {
        return Image;
    }

    public String getName() {
        return Name;
    }

    public int getProjevtIdx() {
        return ProjevtIdx;
    }

    public String getCompany() {
        return Company;
    }

    public String getMonth() {
        return Month;
    }
}
