package com.softsquared.wadiz.src.mypage_funding.mypage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.mypage_funding.mypage.interfaces.MainActivityView;
import com.softsquared.wadiz.src.reward.RewardFragment;
import com.softsquared.wadiz.src.reward_home.Reward_homeFragment;


public class Mypage_fundingFragment extends BaseFragment implements MainActivityView {
    View view;
    TextView tvNull;
    RecyclerView rvItem;

    public Mypage_fundingFragment() {

    }

    public static Mypage_fundingFragment newInstance() {
        Mypage_fundingFragment mypage_fundingFragment = new Mypage_fundingFragment();
        return mypage_fundingFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mypage_funding, container, false);
        tvNull = view.findViewById(R.id.mypage_funding_tv_null);
        rvItem = view.findViewById(R.id.mypage_funding_rv);

        return view;
    }

    private void tryGetTest() {
        showProgressDialog();

        final MainService mainService = new MainService(this);
        mainService.getTest();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    public void customOnClick(View view) {
        switch (view.getId()) {
//            case R.id.main_btn_hello_world:
//                tryGetTest();
//                break;
            default:
                break;
        }
    }
}
