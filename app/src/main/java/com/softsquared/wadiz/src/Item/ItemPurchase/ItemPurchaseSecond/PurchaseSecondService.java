package com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseSecond;

import com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseSecond.interfaces.PurchaseSecondActivityView;
import com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseSecond.interfaces.PurchaseSecondRetrofitInterface;
import com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseSecond.models.GetDeliveryResponse;
import com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseSecond.models.PutDeliveryList;
import com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseSecond.models.PutDeliveryResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class PurchaseSecondService {
    private final PurchaseSecondActivityView mPurchaseSecondActivityView;

    PurchaseSecondService(final PurchaseSecondActivityView purchaseSecondActivityView) {
        this.mPurchaseSecondActivityView = purchaseSecondActivityView;
    }

    void getDelivery(String token) {
        final PurchaseSecondRetrofitInterface purchaseSecondRetrofitInterface = getRetrofit().create(PurchaseSecondRetrofitInterface.class);
        purchaseSecondRetrofitInterface.getDelivery(token).enqueue(new Callback<GetDeliveryResponse>() {
            @Override
            public void onResponse(Call<GetDeliveryResponse> call, Response<GetDeliveryResponse> response) {
                final GetDeliveryResponse getDeliveryResponse = response.body();
                if (getDeliveryResponse == null) {
                    mPurchaseSecondActivityView.validateGetFailure(null);
                    return;
                }

                mPurchaseSecondActivityView.validateGetSuccess(getDeliveryResponse.getResult(), getDeliveryResponse.getCode());
            }

            @Override
            public void onFailure(Call<GetDeliveryResponse> call, Throwable t) {
                mPurchaseSecondActivityView.validateGetFailure(null);
            }
        });
    }
    void putDelivery(String token, PutDeliveryList putDeliveryList) {
        final PurchaseSecondRetrofitInterface purchaseSecondRetrofitInterface = getRetrofit().create(PurchaseSecondRetrofitInterface.class);
        purchaseSecondRetrofitInterface.putDelivery(token, putDeliveryList).enqueue(new Callback<PutDeliveryResponse>() {
            @Override
            public void onResponse(Call<PutDeliveryResponse> call, Response<PutDeliveryResponse> response) {
                final PutDeliveryResponse putDeliveryResponse = response.body();
                if (putDeliveryResponse == null) {
                    mPurchaseSecondActivityView.validatePutFailure(null);
                    return;
                }

                mPurchaseSecondActivityView.validatePutSuccess(putDeliveryResponse.getCode());
            }

            @Override
            public void onFailure(Call<PutDeliveryResponse> call, Throwable t) {
                mPurchaseSecondActivityView.validatePutFailure(null);
            }
        });
    }
}
