package com.softsquared.wadiz.src.login.interfaces;

import com.softsquared.wadiz.src.login.models.LoginList;
import com.softsquared.wadiz.src.login.models.LoginResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LoginRetrofitInterface {
    //    @GET("/test")
    @POST("/signin")
    Call<LoginResponse> postLogin(@Body LoginList loginList);
}
