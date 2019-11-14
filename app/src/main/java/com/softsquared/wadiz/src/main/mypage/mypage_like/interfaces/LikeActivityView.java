package com.softsquared.wadiz.src.main.mypage.mypage_like.interfaces;

import com.softsquared.wadiz.src.main.mypage.mypage_like.models.LikeItemlist;

import java.util.ArrayList;

public interface LikeActivityView {

    void validateSuccess(ArrayList<LikeItemlist> result);

    void validateFailure(String message);
}
