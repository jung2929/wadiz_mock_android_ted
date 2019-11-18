package com.softsquared.wadiz.src.login.models;

import com.google.gson.annotations.SerializedName;

public class SociaList {
    @SerializedName("fbt")
    String fbt;

    public SociaList(String fbt) {
        this.fbt = fbt;
    }

    public String getFbt() {
        return fbt;
    }

    public void setFbt(String fbt) {
        this.fbt = fbt;
    }
}
