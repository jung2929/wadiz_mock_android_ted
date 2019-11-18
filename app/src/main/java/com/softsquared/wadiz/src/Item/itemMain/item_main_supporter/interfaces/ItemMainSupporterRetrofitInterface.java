package com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ItemMainSupporterRetrofitInterface {
//    @GET("/test")
    @GET("/project/{projectIdx}/supporter")
    Call<DefaultResponse> getSupporter(
            @Path("projectIdx") int projectidx,
            @Header("token") String token
    );
}
