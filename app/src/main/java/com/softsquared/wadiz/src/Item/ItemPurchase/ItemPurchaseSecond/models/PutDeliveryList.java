package com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseSecond.models;

import com.google.gson.annotations.SerializedName;

public class PutDeliveryList {
    @SerializedName("userName")
    String Username;

    @SerializedName("phone")
    String phone;

    @SerializedName("address")
    String address;

    public PutDeliveryList(String username, String phone, String address) {
        Username = username;
        this.phone = phone;
        this.address = address;
    }

    public String getUsername() {
        return Username;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
