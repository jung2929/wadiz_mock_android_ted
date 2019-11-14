package com.softsquared.wadiz.src.Item.item_main_story.models;

import com.google.gson.annotations.SerializedName;

public class Itemmainlist {
    @SerializedName("thumnail")
    public String Image;
//
//    @SerializedName("amount")
//    public String Money;

    @SerializedName("title")
    public String Name;

    @SerializedName("category")
    public String Category;

    @SerializedName("infoText")
    public String InfoText;

//    @SerializedName("remaining")
//    public String Day;
//
//    @SerializedName("achievement")
//    public String Percent;
//
//    @SerializedName("supporter")
//    public String Supporter;

    @SerializedName("projectStory")
    public String Story;

    public Itemmainlist(String image, String name, String category, String infoText, String story) {
        Image = image;
        Name = name;
        Category = category;
        InfoText = infoText;
        Story = story;
    }

    public String getImage() {
        return Image;
    }

    public String getName() {
        return Name;
    }

    public String getCategory() {
        return Category;
    }

    public String getInfoText() {
        return InfoText;
    }

    public String getStory() {
        return Story;
    }
}

