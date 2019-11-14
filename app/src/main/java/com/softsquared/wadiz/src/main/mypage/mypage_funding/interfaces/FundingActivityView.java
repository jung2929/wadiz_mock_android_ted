package com.softsquared.wadiz.src.main.mypage.mypage_funding.interfaces;

import com.softsquared.wadiz.src.main.mypage.mypage_funding.models.FundingItemlist;

import java.util.ArrayList;

public interface FundingActivityView {

    void validateSuccess(ArrayList<FundingItemlist> result);

    void validateFailure(String message);
}
