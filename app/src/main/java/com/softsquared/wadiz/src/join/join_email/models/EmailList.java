package com.softsquared.wadiz.src.join.join_email.models;

import com.google.gson.annotations.SerializedName;

public class EmailList {
    @SerializedName("email")
    String Email;
    @SerializedName("name")
    String Name;
    @SerializedName("pw")
    String Pw;
    @SerializedName("repw")
    String Repw;

    public EmailList(String email, String name, String pw, String repw) {
        Email = email;
        Name = name;
        Pw = pw;
        Repw = repw;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPw() {
        return Pw;
    }

    public void setPw(String pw) {
        Pw = pw;
    }

    public String getRepw() {
        return Repw;
    }

    public void setRepw(String repw) {
        Repw = repw;
    }
}
