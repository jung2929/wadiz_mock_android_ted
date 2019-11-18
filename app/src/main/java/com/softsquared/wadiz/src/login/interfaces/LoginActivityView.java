package com.softsquared.wadiz.src.login.interfaces;

public interface LoginActivityView {

    void validateLoginSuccess(String text, int code, String message);

    void validateLoginFailure(String message);

    void validateSocialSuccess(String text, int code, String message, String result);

    void validateSocialFailure(String message);

}
