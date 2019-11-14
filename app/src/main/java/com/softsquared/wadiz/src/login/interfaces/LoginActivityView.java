package com.softsquared.wadiz.src.login.interfaces;

public interface LoginActivityView {

    void validateSuccess(String text, int code, String message);

    void validateFailure(String message);
}
