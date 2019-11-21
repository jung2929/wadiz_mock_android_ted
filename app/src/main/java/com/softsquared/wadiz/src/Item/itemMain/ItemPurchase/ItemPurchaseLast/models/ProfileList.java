package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models;

import com.google.gson.annotations.SerializedName;
import com.softsquared.wadiz.src.main.mypage.models.InterestList;

import java.util.ArrayList;

public class ProfileList {
    @SerializedName("userName")
    String Name;

    @SerializedName("profileImg")
    String Img;

    @SerializedName("userInfo")
    String userInfo;

    @SerializedName("interestList")
    ArrayList<InterestList> interestList = new ArrayList<>();

    public String getUserInfo() {
        return userInfo;
    }


    public String getName() {
        return Name;
    }

    public String getImg() {
        return Img;
    }

    public ArrayList<InterestList> getInterestList() {
        return interestList;
    }
}
