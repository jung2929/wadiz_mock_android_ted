package com.softsquared.wadiz.src.main.reward.reward_home;

import com.softsquared.wadiz.src.main.reward.reward_home.interfaces.RewardHomeRetrofitInterface;
import com.softsquared.wadiz.src.main.reward.reward_home.interfaces.RewardHomeView;
import com.softsquared.wadiz.src.main.reward.reward_home.models.BannerItemlist;
import com.softsquared.wadiz.src.main.reward.reward_home.models.BannerResponse;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryItemList;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryResponse;
import com.softsquared.wadiz.src.main.reward.reward_home.models.ItemResponse;
import com.softsquared.wadiz.src.main.reward.reward_home.models.Itemlist;
import com.softsquared.wadiz.src.main.reward.reward_home.models.SearchItemResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

public class RewardHomeService {
    private final RewardHomeView mRewardHomeView;

    RewardHomeService(final RewardHomeView rewardHomeView) {
        this.mRewardHomeView = rewardHomeView;
    }

    void getBanner() {
        final RewardHomeRetrofitInterface rewardHomeRetrofitInterface = getRetrofit().create(RewardHomeRetrofitInterface.class);
        rewardHomeRetrofitInterface.getBanner().enqueue(new Callback<BannerResponse>() {
            @Override
            public void onResponse(Call<BannerResponse> call, Response<BannerResponse> response) {

                final BannerResponse bannerResponse = response.body();
                if (bannerResponse == null) {
                    mRewardHomeView.validateBannerFailure(null);
                    return;
                }

                mRewardHomeView.validateBannerSuccess(bannerResponse.getResult());

            }

            @Override
            public void onFailure(Call<BannerResponse> call, Throwable t) {

                mRewardHomeView.validateBannerFailure(null);
            }

        });
    }

    void getCategory() {
        final RewardHomeRetrofitInterface rewardHomeRetrofitInterface = getRetrofit().create(RewardHomeRetrofitInterface.class);
        rewardHomeRetrofitInterface.getCategory().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                final CategoryResponse categoryResponse = response.body();
                if (categoryResponse == null) {
                    mRewardHomeView.validateCategoryFailure(null);
                    return;
                }
                mRewardHomeView.validateCategorySuccess(categoryResponse.getResult());

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                mRewardHomeView.validateCategoryFailure(null);
            }

        });

    }

    void getItem(String order) {
        final RewardHomeRetrofitInterface rewardHomeRetrofitInterface = getRetrofit().create(RewardHomeRetrofitInterface.class);
        rewardHomeRetrofitInterface.getItem(order).enqueue(new Callback<ItemResponse>() {
            @Override
            public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                final ItemResponse itemResponse = response.body();
                if (itemResponse == null) {
                    mRewardHomeView.validateItemFailure(null);
                    return;
                }
                mRewardHomeView.validateItemSuccess(itemResponse.getResult() == null ? new ArrayList<>() : itemResponse.getResult());

            }

            @Override
            public void onFailure(Call<ItemResponse> call, Throwable t) {
                mRewardHomeView.validateItemFailure(null);
            }

        });
    }
    void getSearch(String word) {
        final RewardHomeRetrofitInterface rewardHomeRetrofitInterface = getRetrofit().create(RewardHomeRetrofitInterface.class);
        rewardHomeRetrofitInterface.searchItem(word).enqueue(new Callback<SearchItemResponse>() {
            @Override
            public void onResponse(Call<SearchItemResponse> call, Response<SearchItemResponse> response) {
                final SearchItemResponse searchItemResponse = response.body();
                if (searchItemResponse == null) {
                    mRewardHomeView.validateItemFailure(null);
                    return;
                }
                mRewardHomeView.validateItemSuccess(searchItemResponse.getResult() == null ? new ArrayList<>() : searchItemResponse.getResult().getResult());

            }

            @Override
            public void onFailure(Call<SearchItemResponse> call, Throwable t) {
                mRewardHomeView.validateItemFailure(null);
            }

        });
    }


}
