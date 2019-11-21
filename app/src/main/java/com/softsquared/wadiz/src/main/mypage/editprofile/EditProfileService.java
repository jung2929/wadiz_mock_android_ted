package com.softsquared.wadiz.src.main.mypage.editprofile;

import com.softsquared.wadiz.src.main.mypage.editprofile.interfaces.EditProfileActivityView;
import com.softsquared.wadiz.src.main.mypage.editprofile.interfaces.EditProfileRetrofitInterface;
import com.softsquared.wadiz.src.main.mypage.editprofile.models.ProfileImgResponse;
import com.softsquared.wadiz.src.main.mypage.editprofile.models.ProfileResponse;
import com.softsquared.wadiz.src.main.mypage.editprofile.models.ProfileEditList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class EditProfileService {
    private final EditProfileActivityView mEditProfileActivityView;

    EditProfileService(final EditProfileActivityView editProfileActivityView) {
        this.mEditProfileActivityView = editProfileActivityView;
    }

    void patchProfile(String token, ProfileEditList profileEditList) {
        final EditProfileRetrofitInterface editProfileRetrofitInterface = getRetrofit().create(EditProfileRetrofitInterface.class);
        editProfileRetrofitInterface.patchEditProfile(token, profileEditList).enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                final ProfileResponse profileResponse = response.body();
                if (profileResponse == null) {
                    mEditProfileActivityView.validateFailure(null);
                    return;
                }

                mEditProfileActivityView.validateSuccess(profileResponse.getCode(), profileResponse.getMessage());
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                mEditProfileActivityView.validateFailure(null);
            }
        });
    }

    void patchProfileImg(String token, String img) {
        final EditProfileRetrofitInterface editProfileRetrofitInterface = getRetrofit().create(EditProfileRetrofitInterface.class);
        editProfileRetrofitInterface.patchEditProfileImg(token, img).enqueue(new Callback<ProfileImgResponse>() {
            @Override
            public void onResponse(Call<ProfileImgResponse> call, Response<ProfileImgResponse> response) {
                final ProfileImgResponse profileImgResponse = response.body();
                if (profileImgResponse == null) {
                    mEditProfileActivityView.validateFailure(null);
                    System.out.println("프로필 수정 배열 빔");
                    return;
                }

                mEditProfileActivityView.validateSuccess(profileImgResponse.getCode(), profileImgResponse.getMessage());
            }

            @Override
            public void onFailure(Call<ProfileImgResponse> call, Throwable t) {
                mEditProfileActivityView.validateFailure(null);
                System.out.println("프로필 수정 통신 실패 " + t.getMessage());
            }
        });
    }
}
