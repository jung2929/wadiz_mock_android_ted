package com.softsquared.wadiz.src.main.reward.reward_home.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchItemList {

    @SerializedName("projectResult")
    ArrayList<Itemlist> result;
    @SerializedName("cnt")
    private int cnt;

    public SearchItemList(ArrayList<Itemlist> result, int cnt) {
        this.result = result;
        this.cnt = cnt;
    }

    public ArrayList<Itemlist> getResult() {
        return result;
    }

    public void setResult(ArrayList<Itemlist> result) {
        this.result = result;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
