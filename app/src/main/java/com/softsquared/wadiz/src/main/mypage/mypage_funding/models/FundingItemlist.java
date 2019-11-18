package com.softsquared.wadiz.src.main.mypage.mypage_funding.models;

import com.google.gson.annotations.SerializedName;

public class FundingItemlist {
    @SerializedName("projectIdx")
    int projectIdx;
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

    public FundingItemlist(int projectIdx, String image, String name, String company, String category, String percent, String money, String day) {
        this.projectIdx = projectIdx;
        Image = image;
        Name = name;
        Company = company;
        Category = category;
        Percent = percent;
        Money = money;
        Day = day;
    }

    public int getProjectIdx() {
        return projectIdx;
    }

    public void setProjectIdx(int projectIdx) {
        this.projectIdx = projectIdx;
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
}
