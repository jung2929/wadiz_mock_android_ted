package com.softsquared.wadiz.src.Item.itemMain;

import com.softsquared.wadiz.src.Item.itemMain.interfaces.ItemMainActivityView;
import com.softsquared.wadiz.src.Item.itemMain.interfaces.ItemMainRetrofitInterface;
import com.softsquared.wadiz.src.Item.itemMain.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class ItemMainService {
    private final ItemMainActivityView mItemMainActivityView;

    ItemMainService(final ItemMainActivityView itemMainActivityView) {
        this.mItemMainActivityView = itemMainActivityView;
    }

    void getTest(int projectIdx, String token) {
        final ItemMainRetrofitInterface itemMainRetrofitInterface = getRetrofit().create(ItemMainRetrofitInterface.class);
        itemMainRetrofitInterface.postLike(projectIdx, token).enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mItemMainActivityView.validateFailure(null);
                    return;
                }

                mItemMainActivityView.validateSuccess(defaultResponse.getCode());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mItemMainActivityView.validateFailure(null);
            }
        });
    }
}
