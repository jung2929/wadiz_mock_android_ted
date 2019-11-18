package com.softsquared.wadiz.src.Item.itemMain.item_main_story.models;

import com.google.gson.annotations.SerializedName;

public class ItemStorylist {
    @SerializedName("thumnail")
    public String Image;

    @SerializedName("title")
    public String Name;

    @SerializedName("category")
    public String Category;

    @SerializedName("infoText")
    public String InfoText;

    @SerializedName("projectStory")
    public String Story;

    @SerializedName("supprterCnt")
    public String Supporter;

    @SerializedName("goal")
    public String goal;

    @SerializedName("term")
    public String term;

    @SerializedName("makerName")
    public String makerName;

    @SerializedName("makerImg")
    public String makerImg;

    @SerializedName("facebook")
    public String facebook;

    @SerializedName("instagram")
    public String instagram;

    public ItemStorylist(String image, String name, String category, String infoText, String story, String supporter, String goal, String term, String makerName, String makerImg, String facebook, String instagram) {
        Image = image;
        Name = name;
        Category = category;
        InfoText = infoText;
        Story = story;
        Supporter = supporter;
        this.goal = goal;
        this.term = term;
        this.makerName = makerName;
        this.makerImg = makerImg;
        this.facebook = facebook;
        this.instagram = instagram;
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

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
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

    public String getSupporter() {
        return Supporter;
    }

    public void setSupporter(String supporter) {
        Supporter = supporter;
    }

    public String getMakerName() {
        return makerName;
    }

    public void setMakerName(String makerName) {
        this.makerName = makerName;
    }

    public String getMakerImg() {
        return makerImg;
    }

    public void setMakerImg(String makerImg) {
        this.makerImg = makerImg;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}

