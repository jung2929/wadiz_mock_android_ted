package com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card;

import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.interfaces.RegisterCardActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.interfaces.RegisterCardRetrofitInterface;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.models.RegisterCardList;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.models.RegisterCardResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class RegisterCardService {
    private final RegisterCardActivityView mRegisterCardActivityView;

    RegisterCardService(final RegisterCardActivityView registerCardActivityView) {
        this.mRegisterCardActivityView = registerCardActivityView;
    }

    void getTest(String token, RegisterCardList registerCardList) {
        final RegisterCardRetrofitInterface registerCardRetrofitInterface = getRetrofit().create(RegisterCardRetrofitInterface.class);
        registerCardRetrofitInterface.putCard(token, registerCardList).enqueue(new Callback<RegisterCardResponse>() {
            @Override
            public void onResponse(Call<RegisterCardResponse> call, Response<RegisterCardResponse> response) {
                final RegisterCardResponse registerCardResponse = response.body();
                if (registerCardResponse == null) {
                    mRegisterCardActivityView.validateFailure(null);
                    return;
                }

                mRegisterCardActivityView.validateSuccess(registerCardResponse.getIsSuccess(), registerCardResponse.getCode(), registerCardResponse.getMessage());
            }

            @Override
            public void onFailure(Call<RegisterCardResponse> call, Throwable t) {
                mRegisterCardActivityView.validateFailure(null);
            }
        });
    }
}
