package com.softsquared.wadiz.src.Item.itemMain.policy;

import com.softsquared.wadiz.src.Item.itemMain.policy.interfaces.PolicyActivityView;
import com.softsquared.wadiz.src.Item.itemMain.policy.interfaces.PolicyRetrofitInterface;
import com.softsquared.wadiz.src.Item.itemMain.policy.models.PolicyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.wadiz.src.ApplicationClass.getRetrofit;

class PolicyService {
    private final PolicyActivityView mPolicyActivityView;

    PolicyService(final PolicyActivityView policyActivityView) {
        this.mPolicyActivityView = policyActivityView;
    }

    void getTest(int projectIdx, String token) {

        final PolicyRetrofitInterface policyRetrofitInterface = getRetrofit().create(PolicyRetrofitInterface.class);
        policyRetrofitInterface.getPolicy(projectIdx,token).enqueue(new Callback<PolicyResponse>() {
            @Override
            public void onResponse(Call<PolicyResponse> call, Response<PolicyResponse> response) {
                final PolicyResponse policyResponse = response.body();
                if (policyResponse == null) {
                    mPolicyActivityView.validateFailure(null);
                    return;
                }

                mPolicyActivityView.validateSuccess(policyResponse.getResult(), policyResponse.getMessage());
            }

            @Override
            public void onFailure(Call<PolicyResponse> call, Throwable t) {
                mPolicyActivityView.validateFailure(null);
            }
        });
    }
}
