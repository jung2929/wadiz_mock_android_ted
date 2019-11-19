package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PurchaseFirstRetrofitInterface {
    //    @GET("/test")
    @GET("/project/{projectIdx}/reward")
    Call<DefaultResponse> getReward(
            @Path("projectIdx") int projectidx,
            @Header("token") String token
    );
}
