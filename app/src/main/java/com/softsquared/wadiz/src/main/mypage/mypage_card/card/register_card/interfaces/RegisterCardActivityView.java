package com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.interfaces;

public interface RegisterCardActivityView {

    void validateSuccess(boolean success, int code, String message);

    void validateFailure(String message);
}
