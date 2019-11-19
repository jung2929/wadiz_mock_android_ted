package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst;

import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.interfaces.PurchaseFirstActivityView;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.interfaces.PurchaseFirstRetrofitInterface;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class PruchaseFirstService {

    private final PurchaseFirstActivityView mPurchaseFirstActivityView;

    PruchaseFirstService(final PurchaseFirstActivityView purchaseFirstActivityView) {
        this.mPurchaseFirstActivityView = purchaseFirstActivityView;
    }

    void getReward(int projectIdx, String token) {
        final PurchaseFirstRetrofitInterface purchaseFirstRetrofitInterface = getRetrofit().create(PurchaseFirstRetrofitInterface.class);
        purchaseFirstRetrofitInterface.getReward(projectIdx, token).enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mPurchaseFirstActivityView.validateFailure(null);
                    return;
                }

                mPurchaseFirstActivityView.validateSuccess(defaultResponse.getItem());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mPurchaseFirstActivityView.validateFailure(null);
            }
        });
    }
}
