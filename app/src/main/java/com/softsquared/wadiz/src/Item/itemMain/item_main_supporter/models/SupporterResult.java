package com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SupporterResult {
    @SerializedName("supportResult")
    ArrayList<Supporterlist> result;

    @SerializedName("cnt")
    int cnt;

    public SupporterResult(ArrayList<Supporterlist> result, int cnt) {
        this.result = result;
        this.cnt = cnt;
    }

    public ArrayList<Supporterlist> getResult() {
        return result;
    }

    public int getCnt() {
        return cnt;
    }

    public void setResult(ArrayList<Supporterlist> result) {
        this.result = result;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
