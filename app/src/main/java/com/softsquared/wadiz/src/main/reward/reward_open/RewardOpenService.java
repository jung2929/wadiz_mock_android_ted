package com.softsquared.wadiz.src.main.reward.reward_open;

import com.softsquared.wadiz.src.main.reward.reward_open.interfaces.RewardOpenActivityView;
import com.softsquared.wadiz.src.main.reward.reward_open.interfaces.RewardOpenRetrofitInterface;
import com.softsquared.wadiz.src.main.reward.reward_open.models.RewardOpenResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class RewardOpenService {
    private final RewardOpenActivityView mRewardOpenActivityView;

    RewardOpenService(final RewardOpenActivityView rewardOpenActivityView) {
        this.mRewardOpenActivityView = rewardOpenActivityView;
    }

    void getTest() {
        final RewardOpenRetrofitInterface rewardOpenRetrofitInterface = getRetrofit().create(RewardOpenRetrofitInterface.class);
        rewardOpenRetrofitInterface.getTest().enqueue(new Callback<RewardOpenResponse>() {
            @Override
            public void onResponse(Call<RewardOpenResponse> call, Response<RewardOpenResponse> response) {
                final RewardOpenResponse rewardOpenResponse = response.body();
                if (rewardOpenResponse == null) {
                    mRewardOpenActivityView.validateFailure(null);
                    return;
                }

                mRewardOpenActivityView.validateSuccess(rewardOpenResponse.getResult());
            }

            @Override
            public void onFailure(Call<RewardOpenResponse> call, Throwable t) {
                mRewardOpenActivityView.validateFailure(null);
            }
        });
    }
}
