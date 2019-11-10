package com.softsquared.wadiz.src.main.reward.reward_home.interfaces;

import com.softsquared.wadiz.src.main.reward.models.DefaultResponse;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CategoryRetrofitInterface {
//    @GET("/test")
    @GET("/category/")
    Call<CategoryResponse> getTest();

}
