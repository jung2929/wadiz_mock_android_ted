package com.softsquared.wadiz.src.main.mypage.mypage_card.card.delete_card;

import com.softsquared.wadiz.src.main.mypage.mypage_card.card.delete_card.interfaces.CardDeleteActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.delete_card.interfaces.CardDeleteRetrofitInterface;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.delete_card.models.CardDeleteResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class CardDeleteService {
    private final CardDeleteActivityView mCardDeleteActivityView;

    CardDeleteService(final CardDeleteActivityView cardDeleteActivityView) {
        this.mCardDeleteActivityView = cardDeleteActivityView;
    }

    void getTest(String token) {
        final CardDeleteRetrofitInterface cardDeleteRetrofitInterface = getRetrofit().create(CardDeleteRetrofitInterface.class);
        cardDeleteRetrofitInterface.getTest(token).enqueue(new Callback<CardDeleteResponse>() {
            @Override
            public void onResponse(Call<CardDeleteResponse> call, Response<CardDeleteResponse> response) {
                final CardDeleteResponse cardDeleteResponse = response.body();
                if (cardDeleteResponse == null) {
                    mCardDeleteActivityView.validateFailure(null);
                    System.out.println("리스폰스 배열 에러");
                    return;
                }

                mCardDeleteActivityView.validateSuccess(cardDeleteResponse.getMessage());
            }

            @Override
            public void onFailure(Call<CardDeleteResponse> call, Throwable t) {
                mCardDeleteActivityView.validateFailure(null);
                System.out.println(t.toString());
            }
        });
    }
}
