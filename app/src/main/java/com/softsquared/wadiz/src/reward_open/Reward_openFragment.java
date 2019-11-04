package com.softsquared.wadiz.src.reward_open;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.reward_open.interfaces.MainActivityView;

import java.util.ArrayList;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;


public class Reward_openFragment extends BaseFragment implements MainActivityView {
    View view;
    ViewPager viewPager;
    ViewpagerAdapter pagerAdapter;

    public Reward_openFragment() {

    }

    public static Reward_openFragment newInstance() {
        Reward_openFragment mainActivity = new Reward_openFragment();
        return mainActivity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reward_open, container, false);

        viewPager = view.findViewById(R.id.reward_open_vp);
        pagerAdapter = new ViewpagerAdapter();
        viewPager.setAdapter(pagerAdapter);

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
