package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.DefaultResponse;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.GetDeliveryResponse;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.MypageCardResponse;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.PostReward;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.PutDeliveryList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.PutDeliveryResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PurchaseSecondRetrofitInterface {
    //    @GET("/test")
    @GET("/delivery")
    Call<GetDeliveryResponse> getDelivery(@Header("token") String token);

    @PUT("/delivery")
    Call<PutDeliveryResponse> putDelivery(@Header("token") String token, @Body PutDeliveryList putDeliveryList);

    @GET("/pay")
    Call<MypageCardResponse> getPay(@Header("token") String token);

    @POST("/project/{projectIdx}/reward")
    Call<DefaultResponse> postReward(
            @Header("token") String token,
            @Path("projectIdx") int projectidx,
            @Body PostReward postReward
            );

}
