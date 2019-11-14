package com.softsquared.wadiz.src.Item.item_main_story.models;

import com.google.gson.annotations.SerializedName;

public class Itemmainlist {
    @SerializedName("thumnail")
    public String Image;

    @SerializedName("amount")
    public String Money;

    @SerializedName("title")
    public String Name;

    @SerializedName("category")
    public String Category;

    @SerializedName("infoText")
    public String InfoText;

    @SerializedName("remaining")
    public String Day;

    @SerializedName("achievement")
    public String Percent;

    @SerializedName("supporter")
    public String Supporter;

    @SerializedName("projectStory")
    public String Story;

    public Itemmainlist(String image, String money, String name, String category, String infoText, String day, String percent, String supporter, String story) {
        Image = image;
        Money = money;
        Name = name;
        Category = category;
        InfoText = infoText;
        Day = day;
        Percent = percent;
        Supporter = supporter;
        Story = story;
    }

    public String getImage() {
        return Image;
    }

    public String getMoney() {
        return Money;
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

    public String getDay() {
        return Day;
    }

    public String getPercent() {
        return Percent;
    }

    public String getSupporter() {
        return Supporter;
    }

    public String getStory() {
        return Story;
    }
}

