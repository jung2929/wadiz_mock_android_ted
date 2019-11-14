package com.softsquared.wadiz.src.main.mypage;

import com.softsquared.wadiz.src.main.mypage.interfaces.MypageActivityView;
import com.softsquared.wadiz.src.main.mypage.interfaces.MypageRetrofitInterface;
import com.softsquared.wadiz.src.main.mypage.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class MypageService {
    private final MypageActivityView mMypageActivityView;

    MypageService(final MypageActivityView mypageActivityView) {
        this.mMypageActivityView = mypageActivityView;
    }

    void getProfile(String token) {
        final MypageRetrofitInterface mypageRetrofitInterface = getRetrofit().create(MypageRetrofitInterface.class);
        mypageRetrofitInterface.getTest(token).enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mMypageActivityView.validateFailure(null);
                    System.out.println("마이페이지 배열 빔");

                    return;
                }

                mMypageActivityView.validateSuccess(defaultResponse.getMypageList());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mMypageActivityView.validateFailure(null);
                System.out.println("마이페이지 통신 실패");
            }
        });
    }
}
