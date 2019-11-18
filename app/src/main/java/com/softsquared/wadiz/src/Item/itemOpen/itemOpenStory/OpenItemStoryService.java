package com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory;

import com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory.interfaces.OpenItemStoryActivityView;
import com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory.interfaces.OpenItemStoryRetrofitInterface;
import com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory.models.DefaultResponse;
import com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory.models.ItemOpenlist;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class OpenItemStoryService {
    private final OpenItemStoryActivityView mOpenItemStoryActivityView;

    OpenItemStoryService(final OpenItemStoryActivityView openItemStoryActivityView) {
        this.mOpenItemStoryActivityView = openItemStoryActivityView;
    }

    void getTest(int projectIdx, String token) {
        final OpenItemStoryRetrofitInterface openItemStoryRetrofitInterface = getRetrofit().create(OpenItemStoryRetrofitInterface.class);
        openItemStoryRetrofitInterface.getStory(projectIdx, token).enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mOpenItemStoryActivityView.validateFailure(null);
                    return;
                }

                mOpenItemStoryActivityView.validateSuccess(defaultResponse.getItem() == null ? new ItemOpenlist(null, null, null, null, null, null) : defaultResponse.getItem());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mOpenItemStoryActivityView.validateFailure(null);
                System.out.println("스토리 통신 실패" + t.getMessage());
            }
        });
    }
}
