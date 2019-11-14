package com.softsquared.wadiz.src.main.mypage.mypage_like.models;

import com.google.gson.annotations.SerializedName;

public class LikeItemlist {
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

    public LikeItemlist(String image, String name, String company, String category, String percent, String money, String day) {
        Image = image;
        Name = name;
        this.Company = company;
        Category = category;
        this.Percent = percent;
        this.Money = money;
        this.Day = day;
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
        this.Company = company;
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
        this.Percent = percent;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        this.Money = money;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        this.Day = day;
    }
}
