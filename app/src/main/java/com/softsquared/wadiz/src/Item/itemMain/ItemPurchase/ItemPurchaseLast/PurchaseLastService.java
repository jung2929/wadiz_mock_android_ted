package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast;

import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.interfaces.PurchaseLastActivityView;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.interfaces.PurchaseLastRetrofitInterface;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.DefaultResponse;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.NotiList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.ProfileResponse;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.SupporterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class PurchaseLastService {
    private final PurchaseLastActivityView mPurchaseLastActivityView;

    PurchaseLastService(final PurchaseLastActivityView purchaseLastActivityView) {
        this.mPurchaseLastActivityView = purchaseLastActivityView;
    }

    void getProfile(String token) {
        final PurchaseLastRetrofitInterface purchaseLastRetrofitInterface = getRetrofit().create(PurchaseLastRetrofitInterface.class);
        purchaseLastRetrofitInterface.getProfile(token).enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                final ProfileResponse profileResponse = response.body();
                if (profileResponse == null) {
                    mPurchaseLastActivityView.validateFailure(null);
                    return;
                }

                mPurchaseLastActivityView.validateProfileSuccess(profileResponse.getProfileList());
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                mPurchaseLastActivityView.validateFailure(null);
            }
        });
    }

    void getSupporter(int projectIdx, String token) {
        final PurchaseLastRetrofitInterface purchaseLastRetrofitInterface = getRetrofit().create(PurchaseLastRetrofitInterface.class);
        purchaseLastRetrofitInterface.getSupporter(projectIdx, token).enqueue(new Callback<SupporterResponse>() {
            @Override
            public void onResponse(Call<SupporterResponse> call, Response<SupporterResponse> response) {
                final SupporterResponse supporterResponse = response.body();
                if (supporterResponse == null) {
                    mPurchaseLastActivityView.validateFailure(null);
                    System.out.println("배열 빔");
                    return;
                }

                mPurchaseLastActivityView.validateSupporterSuccess(supporterResponse.getResult());

            }

            @Override
            public void onFailure(Call<SupporterResponse> call, Throwable t) {
                mPurchaseLastActivityView.validateFailure(null);
                System.out.println("통신 오류" + t.getMessage());
            }
        });
    }

    void postNoti(String token, NotiList notiList) {
        final PurchaseLastRetrofitInterface purchaseLastRetrofitInterface = getRetrofit().create(PurchaseLastRetrofitInterface.class);
        purchaseLastRetrofitInterface.postNoti(token, notiList).enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mPurchaseLastActivityView.validateFailure(null);
                    System.out.println("배열 빔");
                    return;
                }

                mPurchaseLastActivityView.validateNotiSuccess(defaultResponse.getMessage());

            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mPurchaseLastActivityView.validateFailure(null);
                System.out.println("통신 오류" + t.getMessage());
            }
        });
    }
}
