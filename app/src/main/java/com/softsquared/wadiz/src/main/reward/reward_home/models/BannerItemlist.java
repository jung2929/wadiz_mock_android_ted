package com.softsquared.wadiz.src.main.reward.reward_home.models;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class BannerItemlist {
    @SerializedName("bannerImg")
    String Image;
    @SerializedName("bannerText")
    String Text;
    @SerializedName("bannerSub")
    String Sub;

    public BannerItemlist(String image, String text, String sub) {
        Image = image;
        Text = text;
        Sub = sub;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getSub() {
        return Sub;
    }

    public void setSub(String sub) {
        Sub = sub;
    }
}