package com.softsquared.wadiz.src.main.mypage.interfaces;

import com.softsquared.wadiz.src.main.mypage.models.MypageList;

public interface MypageActivityView {

    void validateSuccess(MypageList mypageList);

    void validateFailure(String message);
}
