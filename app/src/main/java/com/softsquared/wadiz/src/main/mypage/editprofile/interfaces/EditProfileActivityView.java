package com.softsquared.wadiz.src.main.mypage.editprofile.interfaces;

public interface EditProfileActivityView {

    void validateSuccess(int code, String message);

    void validateFailure(String message);
}
