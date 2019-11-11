package com.softsquared.wadiz.src.main.reward.reward_home.interfaces;

import com.softsquared.wadiz.src.main.reward.reward_home.models.BannerResponse;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RewardHomeRetrofitInterface {
//    @GET("/test")
    @GET("/banner")
    Call<BannerResponse> getBanner();

    @GET("/category/")
    Call<CategoryResponse> getCategory();
//
//    @GET("/test/{number}")
//    Call<BannerItemlist> getTestPathAndQuery(
//            @Path("number") int number,
//            @Query("content") final String content
//    );
//
//    @POST("/test")
//    Call<BannerItemlist> postTest(@Body RequestBody params);
}
