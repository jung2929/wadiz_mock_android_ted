package com.softsquared.wadiz.src.Item.itemMain.item_main_story.models;

import com.google.gson.annotations.SerializedName;

public class LikedList {

    @SerializedName("likeCnt")
    int likeCnt;

    @SerializedName("isLike")
    int isLike;

    public LikedList(int likeCnt, int isLike) {
        this.likeCnt = likeCnt;
        this.isLike = isLike;
    }

    public int getLikeCnt() {
        return likeCnt;
    }

    public void setLikeCnt(int likeCnt) {
        this.likeCnt = likeCnt;
    }

    public int getIsLike() {
        return isLike;
    }

    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }
}
