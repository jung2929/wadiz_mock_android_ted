package com.softsquared.wadiz.src.category.models;

import com.google.gson.annotations.SerializedName;

public class CategoryNamelist {
    @SerializedName("category")
    String Name;

    public CategoryNamelist(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
