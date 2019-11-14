package com.softsquared.wadiz.src.main.mypage.mypage_card;

import com.softsquared.wadiz.src.main.mypage.mypage_card.interfaces.MypageCardActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_card.interfaces.MypageCardRetrofitInterface;
import com.softsquared.wadiz.src.main.mypage.mypage_card.models.MypageCardResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class MypageCardService {
    private final MypageCardActivityView mMypageCardActivityView;

    MypageCardService(final MypageCardActivityView mypageCardActivityView) {
        this.mMypageCardActivityView = mypageCardActivityView;
    }

    void getTest(String token) {
        final MypageCardRetrofitInterface mypageCardRetrofitInterface = getRetrofit().create(MypageCardRetrofitInterface.class);
        mypageCardRetrofitInterface.getPay(token).enqueue(new Callback<MypageCardResponse>() {
            @Override
            public void onResponse(Call<MypageCardResponse> call, Response<MypageCardResponse> response) {
                final MypageCardResponse mypageCardResponse = response.body();
                if (mypageCardResponse == null) {
                    mMypageCardActivityView.validateFailure(null);
                    return;
                }

                mMypageCardActivityView.validateSuccess(mypageCardResponse.getResult(), mypageCardResponse.getCode());
            }

            @Override
            public void onFailure(Call<MypageCardResponse> call, Throwable t) {
                mMypageCardActivityView.validateFailure(null);
            }
        });
    }
}
