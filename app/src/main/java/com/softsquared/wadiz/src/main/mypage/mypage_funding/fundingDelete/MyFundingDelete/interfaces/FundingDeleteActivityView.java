package com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete.interfaces;

import com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete.models.FundingItemlist;

import java.util.ArrayList;

public interface FundingDeleteActivityView {

    void validateSuccess(int code, String text);

    void validateFailure(String message);
}
