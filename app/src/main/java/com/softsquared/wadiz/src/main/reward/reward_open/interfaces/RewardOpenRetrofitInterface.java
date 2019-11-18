package com.softsquared.wadiz.src.main.reward.reward_open.interfaces;

import com.softsquared.wadiz.src.main.reward.reward_open.models.RewardOpenResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RewardOpenRetrofitInterface {
//    @GET("/test")
    @GET("/project/unopened")
    Call<RewardOpenResponse> getTest();

}
