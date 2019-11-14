package com.softsquared.wadiz.src.Item.item_main_story.interfaces;

import com.softsquared.wadiz.src.Item.item_main_story.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ItemStoryRetrofitInterface {
//    @GET("/test")
    @GET("/project/{projectidx}/basic")
    Call<DefaultResponse> getStory(
            @Path("projectidx") int projectidx,
            @Header("token") String token
    );

}
