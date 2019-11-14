package com.softsquared.wadiz.src.main.mypage.mypage_funding.interfaces;

import com.softsquared.wadiz.src.main.mypage.mypage_funding.models.FundingtResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FundingRetrofitInterface {
//    @GET("/test")
    @GET("/profile/reward")
    Call<FundingtResponse> getFunding(@Header("token") String token);

}
