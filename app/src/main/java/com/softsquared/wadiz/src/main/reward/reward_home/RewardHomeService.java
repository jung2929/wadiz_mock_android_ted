package com.softsquared.wadiz.src.main.reward.reward_home;

import com.softsquared.wadiz.src.main.reward.reward_home.interfaces.BannerRetrofitInterface;
import com.softsquared.wadiz.src.main.reward.reward_home.interfaces.CategoryRetrofitInterface;
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
    ArrayList<BannerItemlist> mBannerItemlist;
    ArrayList<CategoryItemList> mCategoryItemlist;

    RewardHomeService(final RewardHomeView rewardHomeView) {
        this.mRewardHomeView = rewardHomeView;
    }

    void getBanner() {
        final BannerRetrofitInterface bannerRetrofitInterface = getRetrofit().create(BannerRetrofitInterface.class);
        bannerRetrofitInterface.getTest().enqueue(new Callback<BannerResponse>() {
            @Override
            public void onResponse(Call<BannerResponse> call, Response<BannerResponse> response) {
                final BannerResponse bannerResponse = response.body();
                if (bannerResponse == null) {
                    mRewardHomeView.validateFailure(null);
                    return;
                }

                mBannerItemlist = new ArrayList<>();
                for (int i = 0; i < bannerResponse.getResult().size(); i++) {
                    mBannerItemlist.add(new BannerItemlist(bannerResponse.getResult().get(i).getImage(), bannerResponse.getResult().get(i).getText(), bannerResponse.getResult().get(i).getSub()));
                }
                mRewardHomeView.validateSuccess(bannerResponse.getMessage());

            }

            @Override
            public void onFailure(Call<BannerResponse> call, Throwable t) {
                mRewardHomeView.validateFailure(null);
                System.out.println("통신 실패 : ");
            }

        });
    }

    void getCategory() {
        final CategoryRetrofitInterface bannerRetrofitInterface = getRetrofit().create(CategoryRetrofitInterface.class);
        bannerRetrofitInterface.getTest().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                final CategoryResponse categoryResponse = response.body();
                if (categoryResponse == null) {
                    mRewardHomeView.validateFailure(null);
                    return;
                }

                mCategoryItemlist = new ArrayList<>();
                for (int i = 0; i < categoryResponse.getResult().size(); i++) {

                    mCategoryItemlist.add(new CategoryItemList(categoryResponse.getResult().get(i).getImage(), categoryResponse.getResult().get(i).getName()));
                }
//                mRewardHomeView.validateSuccess(categoryResponse.getMessage());

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                mRewardHomeView.validateFailure(null);
                System.out.println("통신 실패 : ");
            }

        });
    }
}
