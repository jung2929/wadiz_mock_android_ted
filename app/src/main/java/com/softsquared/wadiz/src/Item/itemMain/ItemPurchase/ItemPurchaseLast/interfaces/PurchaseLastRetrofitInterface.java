package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.DefaultResponse;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.NotiList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.ProfileResponse;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.SupporterResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PurchaseLastRetrofitInterface {
    //    @GET("/test")
    @GET("/profile")
    Call<ProfileResponse> getProfile(@Header("token") String token);

    @GET("/project/{projectIdx}/supporter")
    Call<SupporterResponse> getSupporter(
            @Path("projectIdx") int projectidx,
            @Header("token") String token
    );

    @POST("/noti")
    Call<DefaultResponse> postNoti(
            @Header("token") String token,
            @Body NotiList notiList
            );
}
