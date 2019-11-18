package com.softsquared.wadiz.src.main.mypage.editprofile.interfaces;

import com.softsquared.wadiz.src.main.mypage.editprofile.models.DefaultResponse;
import com.softsquared.wadiz.src.main.mypage.editprofile.models.ProfileEditList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EditProfileRetrofitInterface {
//    @GET("/test")
    @PATCH("/profile")
    Call<DefaultResponse> patchEditProfile(@Header("token")String token, @Body ProfileEditList profileEditList);

}
