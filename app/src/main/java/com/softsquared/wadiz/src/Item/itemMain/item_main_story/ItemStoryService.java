package com.softsquared.wadiz.src.Item.itemMain.item_main_story;

import com.softsquared.wadiz.src.Item.itemMain.item_main_story.interfaces.ItemStoryActivityView;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.interfaces.ItemStoryRetrofitInterface;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.DefaultResponse;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.ItemRewardResponse;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.ItemStoryResponse;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.LikedResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class ItemStoryService {
    private final ItemStoryActivityView mItemStoryActivityView;

    ItemStoryService(final ItemStoryActivityView itemStoryActivityView) {
        this.mItemStoryActivityView = itemStoryActivityView;
    }

    void getStory(int projectIdx, String token) {
        final ItemStoryRetrofitInterface itemStoryRetrofitInterface = getRetrofit().create(ItemStoryRetrofitInterface.class);
        itemStoryRetrofitInterface.getStory(projectIdx, token).enqueue(new Callback<ItemStoryResponse>() {
            @Override
            public void onResponse(Call<ItemStoryResponse> call, Response<ItemStoryResponse> response) {
                final ItemStoryResponse itemStoryResponse = response.body();
                if (itemStoryResponse == null) {
                    mItemStoryActivityView.validateStoryFailure(null);
                    return;
                }

                mItemStoryActivityView.validateStorySuccess(itemStoryResponse.getItem());
            }

            @Override
            public void onFailure(Call<ItemStoryResponse> call, Throwable t) {
                mItemStoryActivityView.validateStoryFailure(null);

            }
        });
    }

    void getReward(int projectIdx, String token) {
        final ItemStoryRetrofitInterface itemStoryRetrofitInterface = getRetrofit().create(ItemStoryRetrofitInterface.class);
        itemStoryRetrofitInterface.getReward(projectIdx, token).enqueue(new Callback<ItemRewardResponse>() {
            @Override
            public void onResponse(Call<ItemRewardResponse> call, Response<ItemRewardResponse> response) {
                final ItemRewardResponse itemRewardResponse = response.body();
                if (itemRewardResponse == null) {
                    mItemStoryActivityView.validateRewardFailure(null);
                    return;
                }

                mItemStoryActivityView.validateRewardSuccess(itemRewardResponse.getItem());
            }

            @Override
            public void onFailure(Call<ItemRewardResponse> call, Throwable t) {
                mItemStoryActivityView.validateRewardFailure(null);

            }
        });
    }

    void postLike(int projectIdx, String token) {
        final ItemStoryRetrofitInterface itemStoryRetrofitInterface = getRetrofit().create(ItemStoryRetrofitInterface.class);
        itemStoryRetrofitInterface.postLike(projectIdx, token).enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mItemStoryActivityView.validateLikeFailure(null);
                    return;
                }

                mItemStoryActivityView.validateLikeSuccess(defaultResponse.getCode());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mItemStoryActivityView.validateLikeFailure(null);
            }
        });
    }

    void getLiked(int projectIdx, String token) {
        final ItemStoryRetrofitInterface itemStoryRetrofitInterface = getRetrofit().create(ItemStoryRetrofitInterface.class);
        itemStoryRetrofitInterface.getLiked(projectIdx, token).enqueue(new Callback<LikedResponse>() {
            @Override
            public void onResponse(Call<LikedResponse> call, Response<LikedResponse> response) {
                final LikedResponse likedResponse = response.body();
                if (likedResponse == null) {
                    mItemStoryActivityView.validateLikedFailure(null);
                    System.out.println("좋아요 갯수 불러오기 배열 빔");

                    return;
                }

                mItemStoryActivityView.validateLikedSuccess(likedResponse.getLikedList(), likedResponse.getCode());
                System.out.println("좋아요 갯수 불러오기 성공");
            }

            @Override
            public void onFailure(Call<LikedResponse> call, Throwable t) {
                mItemStoryActivityView.validateLikedFailure(null);
                System.out.println("좋아요 갯수 불러오기 통신 실패" + t.getMessage());

            }
        });
    }

}
