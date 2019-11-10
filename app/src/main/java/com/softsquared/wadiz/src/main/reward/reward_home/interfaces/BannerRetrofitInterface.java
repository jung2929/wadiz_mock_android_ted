package com.softsquared.wadiz.src.main.reward.reward_home.interfaces;

import com.softsquared.wadiz.src.main.reward.reward_home.models.BannerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BannerRetrofitInterface {
//    @GET("/test")
    @GET("/banner")
    Call<BannerResponse> getTest();
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
