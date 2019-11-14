package com.softsquared.wadiz.src.main.mypage.mypage_like;


import com.softsquared.wadiz.src.main.mypage.mypage_like.interfaces.LikeActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_like.interfaces.LikeRetrofitInterface;
import com.softsquared.wadiz.src.main.mypage.mypage_like.models.LikeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class LikeService {
    private final LikeActivityView mLikeActivityView;

    LikeService(final LikeActivityView likeActivityView) {
        this.mLikeActivityView = likeActivityView;
    }

    void getTest(String token) {
        final LikeRetrofitInterface likeRetrofitInterface = getRetrofit().create(LikeRetrofitInterface.class);
        likeRetrofitInterface.getLike(token).enqueue(new Callback<LikeResponse>() {
            @Override
            public void onResponse(Call<LikeResponse> call, Response<LikeResponse> response) {
                final LikeResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mLikeActivityView.validateFailure(null);
                    return;
                }

                mLikeActivityView.validateSuccess(defaultResponse.getResult());
            }

            @Override
            public void onFailure(Call<LikeResponse> call, Throwable t) {
                mLikeActivityView.validateFailure(null);
            }
        });
    }
}
