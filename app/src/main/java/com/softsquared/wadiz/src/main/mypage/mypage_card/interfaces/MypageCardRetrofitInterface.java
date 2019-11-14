package com.softsquared.wadiz.src.main.mypage.mypage_card.interfaces;

import com.softsquared.wadiz.src.main.mypage.mypage_card.models.MypageCardResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MypageCardRetrofitInterface {
//    @GET("/test")
    @GET("/pay")
    Call<MypageCardResponse> getPay(@Header("token") String token);

}
