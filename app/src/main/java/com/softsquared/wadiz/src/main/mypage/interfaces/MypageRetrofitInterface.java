package com.softsquared.wadiz.src.main.mypage.interfaces;

import com.softsquared.wadiz.src.main.mypage.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MypageRetrofitInterface {
//    @GET("/test")
    @GET("/profile")
    Call<DefaultResponse> getTest(@Header("token") String token);

}
