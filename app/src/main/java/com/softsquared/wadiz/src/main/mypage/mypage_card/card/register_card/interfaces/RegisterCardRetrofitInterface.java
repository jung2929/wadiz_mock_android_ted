package com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.interfaces;

import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.models.RegisterCardList;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.models.RegisterCardResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RegisterCardRetrofitInterface {
    //    @GET("/test")
    @PUT("/pay")
    Call<RegisterCardResponse> putCard(
            @Header("token") String token,
            @Body RegisterCardList registerCardList
    );

}
