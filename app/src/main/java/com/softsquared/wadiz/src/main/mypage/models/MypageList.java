package com.softsquared.wadiz.src.main.mypage.models;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MypageList {
    @SerializedName("userName")
    String Name;

    @SerializedName("profileImg")
    String Img;

    @SerializedName("InterestList")
    ArrayList<InterestList> interestList = new ArrayList<>();

    public String getName() {
        return Name;
    }

    public String getImg() {
        return Img;
    }

    public ArrayList<InterestList> getInterestList() {
        return interestList;
    }
}
