package com.softsquared.wadiz.src.Item.itemMain.policy.interfaces;

import com.softsquared.wadiz.src.Item.itemMain.policy.models.PolicyResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PolicyRetrofitInterface {
//    @GET("/test")
    @GET("/project/{projectIdx}/policy")
    Call<PolicyResponse> getPolicy(
            @Path("projectIdx") int projectIdx,
            @Header("token") String token
    );

}
