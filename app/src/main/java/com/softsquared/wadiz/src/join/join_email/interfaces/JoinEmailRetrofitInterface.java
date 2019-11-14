package com.softsquared.wadiz.src.join.join_email.interfaces;

import com.softsquared.wadiz.src.join.join_email.models.EmailList;
import com.softsquared.wadiz.src.join.join_email.models.JoinEmailResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface JoinEmailRetrofitInterface {
//    @GET("/test")
    @POST("/signup")
    Call<JoinEmailResponse> postJoin(@Body EmailList emailList);

}
