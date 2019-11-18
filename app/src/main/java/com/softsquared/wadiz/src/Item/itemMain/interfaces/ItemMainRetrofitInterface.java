package com.softsquared.wadiz.src.Item.itemMain.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ItemMainRetrofitInterface {
//    @GET("/test")

    @POST("/project/{projectIdx}/like")
    Call<DefaultResponse> postLike(
            @Path("projectIdx") int projectidx,
            @Header("token") String token
    );

}
