package com.softsquared.wadiz.src.main.mypage.editprofile.models;

import com.google.gson.annotations.SerializedName;

public class CategoryItem {
    @SerializedName("categoryIdx")
    String categoryIdx;

    public CategoryItem(String categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    public String getCategoryIdx() {
        return categoryIdx;
    }
}
