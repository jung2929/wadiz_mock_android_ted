package com.softsquared.wadiz.src.main.reward.reward_home;

import com.softsquared.wadiz.src.main.reward.reward_home.interfaces.RewardHomeRetrofitInterface;
import com.softsquared.wadiz.src.main.reward.reward_home.interfaces.RewardHomeView;
import com.softsquared.wadiz.src.main.reward.reward_home.models.BannerItemlist;
import com.softsquared.wadiz.src.main.reward.reward_home.models.BannerResponse;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryItemList;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryResponse;

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
                System.out.println("통신 실패 : ");
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
                    mRewardHomeView.validateBannerFailure(null);
                    return;
                }
                mRewardHomeView.validateCategorySuccess(categoryResponse.getResult());

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                mRewardHomeView.validateBannerFailure(null);
                System.out.println("통신 실패 : ");
            }

        });
    }
}
