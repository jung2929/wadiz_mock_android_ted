package com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete;

import com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete.interfaces.FundingDeleteActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete.interfaces.FundingDeleteRetrofitInterface;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete.models.FundingtResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class FundingDeleteService {
    private final FundingDeleteActivityView mFundingDeleteActivityView;

    FundingDeleteService(final FundingDeleteActivityView fundingDeleteActivityView) {
        this.mFundingDeleteActivityView = fundingDeleteActivityView;
    }

    void deletePro(int projectIdx, String token) {
        final FundingDeleteRetrofitInterface fundingDeleteRetrofitInterface = getRetrofit().create(FundingDeleteRetrofitInterface.class);
        fundingDeleteRetrofitInterface.deletePro(projectIdx,token).enqueue(new Callback<FundingtResponse>() {
            @Override
            public void onResponse(Call<FundingtResponse> call, Response<FundingtResponse> response) {
                final FundingtResponse fundingtResponse = response.body();
                if (fundingtResponse == null) {
                    mFundingDeleteActivityView.validateFailure(null);
                    return;
                }

                mFundingDeleteActivityView.validateSuccess(fundingtResponse.getCode(), fundingtResponse.getMessage());
            }

            @Override
            public void onFailure(Call<FundingtResponse> call, Throwable t) {
                mFundingDeleteActivityView.validateFailure(null);
            }
        });
    }
}
