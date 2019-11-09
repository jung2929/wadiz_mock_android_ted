package com.softsquared.wadiz.src.Item.item_main_supporter.models;

public class Supporterlist {
    public int Image;
    public String Name;
    public String Money;

    public Supporterlist(int image, String name, String money) {
        Image = image;
        Name = name;
        Money = money;
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

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }
}
