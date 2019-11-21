package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond;

import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.interfaces.PurchaseSecondActivityView;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.interfaces.PurchaseSecondRetrofitInterface;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.DefaultResponse;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.GetDeliveryResponse;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.MypageCardResponse;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.PostReward;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.PutDeliveryList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.PutDeliveryResponse;

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

    void getCard(String token) {
        final PurchaseSecondRetrofitInterface mypageCardRetrofitInterface = getRetrofit().create(PurchaseSecondRetrofitInterface.class);
        mypageCardRetrofitInterface.getPay(token).enqueue(new Callback<MypageCardResponse>() {
            @Override
            public void onResponse(Call<MypageCardResponse> call, Response<MypageCardResponse> response) {
                final MypageCardResponse mypageCardResponse = response.body();
                if (mypageCardResponse == null) {
                    mPurchaseSecondActivityView.validateCardFailure(null);
                    return;
                }

                mPurchaseSecondActivityView.validateCardSuccess(mypageCardResponse.getResult(), mypageCardResponse.getCode());
            }

            @Override
            public void onFailure(Call<MypageCardResponse> call, Throwable t) {
                mPurchaseSecondActivityView.validateCardFailure(null);
            }
        });
    }

    void postReward(String token, int projectidx, PostReward postReward) {
        final PurchaseSecondRetrofitInterface mypageCardRetrofitInterface = getRetrofit().create(PurchaseSecondRetrofitInterface.class);
        mypageCardRetrofitInterface.postReward(token, projectidx, postReward).enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mPurchaseSecondActivityView.validatePostRewardFailure(null);
                    return;
                }

                mPurchaseSecondActivityView.validatePostRewardSuccess(defaultResponse.getMessage(), defaultResponse.getCode());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mPurchaseSecondActivityView.validatePostRewardFailure(null);
            }
        });
    }
}
