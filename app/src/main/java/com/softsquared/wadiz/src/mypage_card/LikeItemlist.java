package com.softsquared.wadiz.src.mypage_card;

public class LikeItemlist {
    int Image;
    String Name;
    String Company;
    String Category;
    String Percent;
    String Money;
    String Day;

    public LikeItemlist(int image, String name, String company, String category, String percent, String money, String day) {
        Image = image;
        Name = name;
        this.Company = company;
        Category = category;
        this.Percent = percent;
        this.Money = money;
        this.Day = day;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
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
