package com.softsquared.wadiz.src.Item.itemOpen;

import com.softsquared.wadiz.src.Item.itemOpen.interfaces.ItemOpenActivityView;
import com.softsquared.wadiz.src.Item.itemOpen.interfaces.ItemOpenRetrofitInterface;
import com.softsquared.wadiz.src.Item.itemOpen.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class ItemOpenService {
    private final ItemOpenActivityView mItemOpenActivityView;

    ItemOpenService(final ItemOpenActivityView itemOpenActivityView) {
        this.mItemOpenActivityView = itemOpenActivityView;
    }

    void getTest() {
        final ItemOpenRetrofitInterface itemOpenRetrofitInterface = getRetrofit().create(ItemOpenRetrofitInterface.class);
        itemOpenRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mItemOpenActivityView.validateFailure(null);
                    return;
                }

                mItemOpenActivityView.validateSuccess(defaultResponse.getMessage());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mItemOpenActivityView.validateFailure(null);
            }
        });
    }
}
