package com.softsquared.wadiz.src.Item.item_main_story;

import com.softsquared.wadiz.src.Item.item_main_story.interfaces.ItemStoryActivityView;
import com.softsquared.wadiz.src.Item.item_main_story.interfaces.ItemStoryRetrofitInterface;
import com.softsquared.wadiz.src.Item.item_main_story.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class ItemStoryService {
    private final ItemStoryActivityView mItemStoryActivityView;

    ItemStoryService(final ItemStoryActivityView itemStoryActivityView) {
        this.mItemStoryActivityView = itemStoryActivityView;
    }

    void getTest(int projectIdx, String token) {
        final ItemStoryRetrofitInterface itemStoryRetrofitInterface = getRetrofit().create(ItemStoryRetrofitInterface.class);
        itemStoryRetrofitInterface.getStory(projectIdx, token).enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mItemStoryActivityView.validateFailure(null);
                    System.out.println("스토리 배열 빔");

                    return;
                }

                mItemStoryActivityView.validateSuccess(defaultResponse.getItem());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mItemStoryActivityView.validateFailure(null);
                System.out.println("스토리 통신 실패" + t.getMessage());
            }
        });
    }
}
