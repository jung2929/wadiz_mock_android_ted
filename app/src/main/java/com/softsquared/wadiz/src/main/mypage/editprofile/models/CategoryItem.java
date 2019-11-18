package com.softsquared.wadiz.src.main.mypage.editprofile.models;

import com.google.gson.annotations.SerializedName;

public class CategoryItem {
    @SerializedName("categoryIdx")
    int categoryIdx;

    public CategoryItem(int categoryIdx) {
        this.categoryIdx = categoryIdx;
    }

    public int getCategoryIdx() {
        return categoryIdx;
    }
}
