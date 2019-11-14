package com.softsquared.wadiz.src.main.reward.reward_home.models;

import com.google.gson.annotations.SerializedName;

public class Itemlist {
    @SerializedName("thumnail")
    String Image;

    @SerializedName("title")
    String Name;

    @SerializedName("makerName")
    String Company;

    @SerializedName("category")
    String Category;

    @SerializedName("achievement")
    String Percent;

    @SerializedName("amount")
    String Money;

    @SerializedName("remaining")
    String Day;

    @SerializedName("projectIdx")
    int ProjectIdx;

    public Itemlist(String image, String name, String company, String category, String percent, String money, String day, int projectIdx) {
        Image = image;
        Name = name;
        Company = company;
        Category = category;
        Percent = percent;
        Money = money;
        Day = day;
        ProjectIdx = projectIdx;
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

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getPercent() {
        return Percent;
    }

    public void setPercent(String percent) {
        Percent = percent;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public int getProjectIdx() {
        return ProjectIdx;
    }

    public void setProjectIdx(int projectIdx) {
        ProjectIdx = projectIdx;
    }
}
