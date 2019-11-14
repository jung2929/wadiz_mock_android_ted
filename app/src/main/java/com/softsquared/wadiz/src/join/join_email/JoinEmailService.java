package com.softsquared.wadiz.src.join.join_email;

import com.softsquared.wadiz.src.join.join_email.interfaces.JoinEmailView;
import com.softsquared.wadiz.src.join.join_email.interfaces.JoinEmailRetrofitInterface;
import com.softsquared.wadiz.src.join.join_email.models.EmailList;
import com.softsquared.wadiz.src.join.join_email.models.JoinEmailResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class JoinEmailService {
    private final JoinEmailView mJoinEmailView;
    JoinEmailFragment mJoinEmailFragment = new JoinEmailFragment();

    JoinEmailService(final JoinEmailView joinEmailView) {
        this.mJoinEmailView = joinEmailView;
    }

    void postJoin(EmailList emailList) {
        final JoinEmailRetrofitInterface joinEmailRetrofitInterface = getRetrofit().create(JoinEmailRetrofitInterface.class);
        joinEmailRetrofitInterface.postJoin(emailList).enqueue(new Callback<JoinEmailResponse>() {
            @Override
            public void onResponse(Call<JoinEmailResponse> call, Response<JoinEmailResponse> response) {
                final JoinEmailResponse joinEmailResponse = response.body();
                if (joinEmailResponse == null) {
                    mJoinEmailView.validateFailure(null);
                    return;
                }

                mJoinEmailView.validateSuccess(joinEmailResponse.getIsSuccess(), joinEmailResponse.getCode(), joinEmailResponse.getMessage());
            }

            @Override
            public void onFailure(Call<JoinEmailResponse> call, Throwable t) {
                mJoinEmailView.validateFailure(null);


            }
        });
    }
}
