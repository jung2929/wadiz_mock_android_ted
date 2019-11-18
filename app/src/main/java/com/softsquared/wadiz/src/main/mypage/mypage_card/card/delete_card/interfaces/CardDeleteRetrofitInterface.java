package com.softsquared.wadiz.src.main.mypage.mypage_card.card.delete_card.interfaces;

import com.softsquared.wadiz.src.main.mypage.mypage_card.card.delete_card.models.CardDeleteResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CardDeleteRetrofitInterface {
//    @GET("/test")
    @DELETE("/pay")
    Call<CardDeleteResponse> getTest(@Header("token") String token);

}
