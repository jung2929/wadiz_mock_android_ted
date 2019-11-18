package com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory.interfaces;

import com.softsquared.wadiz.src.Item.itemOpen.itemOpenStory.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface OpenItemStoryRetrofitInterface {
//    @GET("/test")
    @GET("/project/{projectidx}/unopened")
    Call<DefaultResponse> getStory(
            @Path("projectidx") int projectidx,
            @Header("token") String token
    );

}
