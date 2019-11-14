package com.softsquared.wadiz.src.main.mypage.mypage_card.interfaces;

import com.softsquared.wadiz.src.main.mypage.mypage_card.models.CardList;

import java.util.ArrayList;

public interface MypageCardActivityView {

    void validateSuccess(ArrayList<CardList> result, int code);

    void validateFailure(String message);
}
