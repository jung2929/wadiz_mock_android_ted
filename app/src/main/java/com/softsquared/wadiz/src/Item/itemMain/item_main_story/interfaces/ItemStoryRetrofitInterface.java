package com.softsquared.wadiz.src.Item.itemMain.item_main_story.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.DefaultResponse;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.ItemRewardResponse;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.ItemStoryResponse;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.LikedResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ItemStoryRetrofitInterface {
//    @GET("/test")
    @GET("/project/{projectidx}/basic")
    Call<ItemStoryResponse> getStory(
            @Path("projectidx") int projectidx,
            @Header("token") String token
    );

    @GET("/project/{projectIdx}/reward")
    Call<ItemRewardResponse> getReward(
            @Path("projectIdx") int projectidx,
            @Header("token") String token
    );

    @POST("/project/{projectIdx}/like")
    Call<DefaultResponse> postLike(
            @Path("projectIdx") int projectidx,
            @Header("token") String token
    );

    @GET("/project/{projectIdx}/isLiked")
    Call<LikedResponse> getLiked (
        @Path("projectIdx") int projectidx,
        @Header("token") String token
    );

}
