package com.softsquared.wadiz.src.reward_open;

public class Openlist {
    int Image;
    String Name;
    String Company;
    String Month;

    public Openlist(int image, String name, String company, String month) {
        Image = image;
        Name = name;
        Company = company;
        Month = month;
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
        Company = company;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }
}
