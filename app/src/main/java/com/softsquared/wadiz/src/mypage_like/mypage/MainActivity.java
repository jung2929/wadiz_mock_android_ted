package com.softsquared.wadiz.src.mypage_like.mypage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.mypage_like.mypage.interfaces.MainActivityView;
import com.softsquared.wadiz.src.reward.RewardFragment;


public class MainActivity extends BaseActivity implements MainActivityView {
    private TextView mTvHelloWorld;
    FrameLayout mFlContainer;
    Button mBtnReward, mBtnMypage;
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    Fragment mRewardFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlContainer = findViewById(R.id.main_fl_container);
        mBtnMypage = findViewById(R.id.main_btn_footer_mypage);
        mBtnReward = findViewById(R.id.main_btn_footer_reward);

        fragmentManager = getSupportFragmentManager();

        mRewardFragment = new RewardFragment();

        fragmentManager.beginTransaction().replace(R.id.main_fl_container, mRewardFragment).commitAllowingStateLoss();

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
