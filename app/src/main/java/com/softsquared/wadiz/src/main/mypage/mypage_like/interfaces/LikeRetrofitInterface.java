package com.softsquared.wadiz.src.main.mypage.mypage_like.interfaces;

import com.softsquared.wadiz.src.main.mypage.mypage_like.models.LikeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface LikeRetrofitInterface {
//    @GET("/test")
    @GET("/profile/like")
    Call<LikeResponse> getLike(@Header("token") String token);

}
