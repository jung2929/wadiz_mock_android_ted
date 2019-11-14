package com.softsquared.wadiz.src.main.mypage.editprofile.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProfileEditList {
    @SerializedName("userinfo")
    String Userinfo;

    @SerializedName("categoryItems")
    ArrayList<CategoryItem> CategoryItem = null;

    public ProfileEditList(String userinfo, ArrayList<CategoryItem> categoryItem) {
        Userinfo = userinfo;
        CategoryItem = categoryItem;
    }

    public String getUserinfo() {
        return Userinfo;
    }

    public ArrayList<CategoryItem> getCategoryItem() {
        return CategoryItem;
    }
}