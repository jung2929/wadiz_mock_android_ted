package com.softsquared.wadiz.src.Item.itemMain.item_main_supporter;

import com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.interfaces.ItemMainSupporterActivityView;
import com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.interfaces.ItemMainSupporterRetrofitInterface;
import com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class ItemMainSupporterService {
    private final ItemMainSupporterActivityView mItemMainSupporterActivityView;

    ItemMainSupporterService(final ItemMainSupporterActivityView itemMainSupporterActivityView) {
        this.mItemMainSupporterActivityView = itemMainSupporterActivityView;
    }

    void getTest(int projectIdx, String token) {
        final ItemMainSupporterRetrofitInterface itemMainSupporterRetrofitInterface = getRetrofit().create(ItemMainSupporterRetrofitInterface.class);
        itemMainSupporterRetrofitInterface.getSupporter(projectIdx, token).enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mItemMainSupporterActivityView.validateFailure(null);
                    System.out.println("배열 빔");
                    return;
                }

                mItemMainSupporterActivityView.validateSuccess(defaultResponse.getResult());

            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mItemMainSupporterActivityView.validateFailure(null);
                System.out.println("통신 오류" + t.getMessage());
            }
        });
    }
}
