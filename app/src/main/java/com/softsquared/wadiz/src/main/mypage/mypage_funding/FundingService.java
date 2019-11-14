package com.softsquared.wadiz.src.main.mypage.mypage_funding;

import com.softsquared.wadiz.src.main.mypage.mypage_funding.interfaces.FundingActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.interfaces.FundingRetrofitInterface;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.models.FundingtResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class FundingService {
    private final FundingActivityView mFundingActivityView;

    FundingService(final FundingActivityView fundingActivityView) {
        this.mFundingActivityView = fundingActivityView;
    }

    void getTest(String token) {
        final FundingRetrofitInterface fundingRetrofitInterface = getRetrofit().create(FundingRetrofitInterface.class);
        fundingRetrofitInterface.getFunding(token).enqueue(new Callback<FundingtResponse>() {
            @Override
            public void onResponse(Call<FundingtResponse> call, Response<FundingtResponse> response) {
                final FundingtResponse fundingtResponse = response.body();
                if (fundingtResponse == null) {
                    mFundingActivityView.validateFailure(null);
                    return;
                }

                mFundingActivityView.validateSuccess(fundingtResponse.getResult());
            }

            @Override
            public void onFailure(Call<FundingtResponse> call, Throwable t) {
                mFundingActivityView.validateFailure(null);
            }
        });
    }
}
