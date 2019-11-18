package com.softsquared.wadiz.src.login;

import com.softsquared.wadiz.src.login.interfaces.LoginActivityView;
import com.softsquared.wadiz.src.login.interfaces.LoginRetrofitInterface;
import com.softsquared.wadiz.src.login.models.LoginList;
import com.softsquared.wadiz.src.login.models.LoginResponse;
import com.softsquared.wadiz.src.login.models.SociaList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class LoginService {
    private final LoginActivityView mLoginActivityView;

    LoginService(final LoginActivityView loginActivityView) {
        this.mLoginActivityView = loginActivityView;
    }

    void postLogin(LoginList loginList) {
        final LoginRetrofitInterface loginRetrofitInterface = getRetrofit().create(LoginRetrofitInterface.class);
        loginRetrofitInterface.postLogin(loginList).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                final LoginResponse loginResponse = response.body();
                if (loginResponse == null) {
                    mLoginActivityView.validateLoginFailure(null);
                    return;
                }

                mLoginActivityView.validateLoginSuccess(loginResponse.getResult(), loginResponse.getCode(), loginResponse.getMessage());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mLoginActivityView.validateLoginFailure(null);
            }
        });
    }
    void postSocial(SociaList sociaList) {
        final LoginRetrofitInterface loginRetrofitInterface = getRetrofit().create(LoginRetrofitInterface.class);
        loginRetrofitInterface.postLogin(sociaList).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                final LoginResponse loginResponse = response.body();
                if (loginResponse == null) {
                    mLoginActivityView.validateLoginFailure(null);
                    return;
                }

                mLoginActivityView.validateLoginSuccess(loginResponse.getResult(), loginResponse.getCode(), loginResponse.getMessage());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mLoginActivityView.validateLoginFailure(null);
            }
        });
    }
}
