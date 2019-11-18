package com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory.models;

import com.google.gson.annotations.SerializedName;

public class ItemOpenlist {
    @SerializedName("thumnail")
    public String Image;

    @SerializedName("title")
    public String Name;

    @SerializedName("infoText")
    public String InfoText;

    @SerializedName("projectStory")
    public String Story;

    @SerializedName("makerName")
    public String Makername;

    @SerializedName("makerImg")
    public String Makerimg;

    public ItemOpenlist(String image, String name, String infoText, String story, String makername, String makerimg) {
        Image = image;
        Name = name;
        InfoText = infoText;
        Story = story;
        Makername = makername;
        Makerimg = makerimg;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInfoText() {
        return InfoText;
    }

    public void setInfoText(String infoText) {
        InfoText = infoText;
    }

    public String getStory() {
        return Story;
    }

    public void setStory(String story) {
        Story = story;
    }

    public String getMakername() {
        return Makername;
    }

    public void setMakername(String makername) {
        Makername = makername;
    }

    public String getMakerimg() {
        return Makerimg;
    }

    public void setMakerimg(String makerimg) {
        Makerimg = makerimg;
    }
}

