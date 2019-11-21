package com.softsquared.wadiz.src.main.mypage.editprofile.interfaces;

import com.softsquared.wadiz.src.main.mypage.editprofile.models.ProfileImgResponse;
import com.softsquared.wadiz.src.main.mypage.editprofile.models.ProfileResponse;
import com.softsquared.wadiz.src.main.mypage.editprofile.models.ProfileEditList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.PATCH;

public interface EditProfileRetrofitInterface {
//    @GET("/test")
    @PATCH("/profile")
    Call<ProfileResponse> patchEditProfile(@Header("token")String token, @Body ProfileEditList profileEditList);

    @FormUrlEncoded
    @PATCH("/profile/img")
    Call<ProfileImgResponse> patchEditProfileImg(@Header("token")String token, @Field("profileImg") String img);

}
