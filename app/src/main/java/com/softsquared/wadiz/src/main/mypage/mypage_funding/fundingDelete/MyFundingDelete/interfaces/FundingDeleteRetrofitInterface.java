package com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete.interfaces;

import com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete.models.FundingtResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface FundingDeleteRetrofitInterface {
//    @GET("/test")
    @DELETE ("/project/{projectIdx}")
    Call<FundingtResponse> deletePro(
            @Path("projectIdx") int projectIdx,
            @Header("token") String token);


}
