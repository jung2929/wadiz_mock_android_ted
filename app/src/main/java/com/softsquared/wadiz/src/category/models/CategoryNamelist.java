package com.softsquared.wadiz.src.category.models;

import com.google.gson.annotations.SerializedName;

public class CategoryNamelist {
    @SerializedName("category")
    String Name;

    @SerializedName("categoryImg")
    String Image;

    public CategoryNamelist(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
