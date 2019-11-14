package com.softsquared.wadiz.src.login.models;

import com.google.gson.annotations.SerializedName;

public class LoginList {
    @SerializedName("email")
    String Email;
    @SerializedName("pw")
    String Pw;

    public LoginList(String email, String pw) {
        Email = email;
        Pw = pw;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPw() {
        return Pw;
    }

    public void setPw(String pw) {
        Pw = pw;
    }
}
