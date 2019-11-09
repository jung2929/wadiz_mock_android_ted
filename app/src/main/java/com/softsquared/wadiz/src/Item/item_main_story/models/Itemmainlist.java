package com.softsquared.wadiz.src.Item.item_main_story.models;

public class Itemmainlist {
    public String Money;
    public String Name;
    public String Content;
    public String Delivery_money;
    public String Delivery_day;
    public String Limited;
    public String Limited_now;
    public String Total;

    public Itemmainlist(String money, String name, String content, String delivery_money, String delivery_day, String limited, String limited_now, String total) {
        Money = money;
        Name = name;
        Content = content;
        Delivery_money = delivery_money;
        Delivery_day = delivery_day;
        Limited = limited;
        Limited_now = limited_now;
        Total = total;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDelivery_money() {
        return Delivery_money;
    }

    public void setDelivery_money(String delivery_money) {
        Delivery_money = delivery_money;
    }

    public String getDelivery_day() {
        return Delivery_day;
    }

    public void setDelivery_day(String delivery_day) {
        Delivery_day = delivery_day;
    }

    public String getLimited() {
        return Limited;
    }

    public void setLimited(String limited) {
        Limited = limited;
    }

    public String getLimited_now() {
        return Limited_now;
    }

    public void setLimited_now(String limited_now) {
        Limited_now = limited_now;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }
}

