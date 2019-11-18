package com.softsquared.wadiz.src.main.mypage.editprofile;

import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.mypage.editprofile.interfaces.EditProfileActivityView;
import com.softsquared.wadiz.src.main.mypage.editprofile.interfaces.EditProfileRetrofitInterface;
import com.softsquared.wadiz.src.main.mypage.editprofile.models.DefaultResponse;
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

    void getTest(String token, ProfileEditList profileEditList) {
        final EditProfileRetrofitInterface editProfileRetrofitInterface = getRetrofit().create(EditProfileRetrofitInterface.class);
        editProfileRetrofitInterface.patchEditProfile(token, profileEditList).enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body();
                if (defaultResponse == null) {
                    mEditProfileActivityView.validateFailure(null);
                    System.out.println("프로필 수정 배열 빔");
                    return;
                }

                mEditProfileActivityView.validateSuccess(defaultResponse.getCode(), defaultResponse.getMessage());
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                mEditProfileActivityView.validateFailure(null);
                System.out.println("프로필 수정 통신 실패 " + t.getMessage());
            }
        });
    }
}
