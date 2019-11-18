package com.softsquared.wadiz.src.main.reward.reward_home.interfaces;

import com.softsquared.wadiz.src.main.reward.reward_home.models.BannerResponse;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryResponse;
import com.softsquared.wadiz.src.main.reward.reward_home.models.ItemResponse;
import com.softsquared.wadiz.src.main.reward.reward_home.models.SearchItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RewardHomeRetrofitInterface {
//    @GET("/test")
    @GET("/banner")
    Call<BannerResponse> getBanner();

    @GET("/category")
    Call<CategoryResponse> getCategory();

    @GET("/project")
    Call<ItemResponse> getItem(@Query("orderby") String order);

    @GET("/project/search")
    Call<SearchItemResponse> searchItem(@Query("word") String word);

}
