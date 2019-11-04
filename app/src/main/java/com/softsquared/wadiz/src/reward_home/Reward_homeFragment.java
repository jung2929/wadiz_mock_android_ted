package com.softsquared.wadiz.src.reward_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.reward_home.interfaces.MainActivityView;

public class Reward_homeFragment extends BaseFragment implements MainActivityView {
    private TextView mTvHelloWorld;
    View view;

    public Reward_homeFragment() {

    }

    public static Reward_homeFragment newInstance() {
        Reward_homeFragment mainActivity = new Reward_homeFragment();
        return mainActivity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reward_home,container, false);
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
        mTvHelloWorld.setText(text);
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
