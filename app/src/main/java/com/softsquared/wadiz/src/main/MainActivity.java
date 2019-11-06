package com.softsquared.wadiz.src.main;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.loginFragment.LoginFragment;
import com.softsquared.wadiz.src.main.interfaces.MainActivityView;
import com.softsquared.wadiz.src.mypage.MypageFragment;
import com.softsquared.wadiz.src.reward.RewardFragment;


public class MainActivity extends BaseActivity implements MainActivityView {
    FrameLayout mFlContainer;
    Button mBtnReward, mBtnMypage;
    FragmentManager fragmentManager;
    Fragment mMypageFragment, mRewardFragment, mLoginFragment;

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

        mBtnReward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onFragmentChange(0);
            }
        });

        mBtnMypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentChange(1);
            }
        });


    }
    public void onFragmentChange(int index) {
        if (index == 0) { //홈화면
            if (mRewardFragment == null) {
                mRewardFragment = new RewardFragment();
                fragmentManager.beginTransaction().add(R.id.main_fl_container,mRewardFragment).commit();
                fragmentManager.beginTransaction().show(mRewardFragment).commit();

            } else {
                fragmentManager.beginTransaction().show(mRewardFragment).commit();
                fragmentManager.beginTransaction().hide(mLoginFragment).commit();
            }
            mBtnReward.setTypeface(null, Typeface.BOLD);
            Drawable img_click = getApplicationContext().getResources().getDrawable(R.drawable.gift_click);
            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, img_click,null,null);
            mBtnMypage.setTypeface(null,Typeface.NORMAL);
            Drawable img_nonclick = getApplicationContext().getResources().getDrawable(R.drawable.user);
            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, img_nonclick,null,null);

        } else if (index==1) { //마이페이지
            if (mLoginFragment == null) {
                mLoginFragment = new LoginFragment();
                fragmentManager.beginTransaction().add(R.id.main_fl_container,mLoginFragment).commit();
                fragmentManager.beginTransaction().show(mLoginFragment).commit();

            } else {
                fragmentManager.beginTransaction().show(mLoginFragment).commit();
                fragmentManager.beginTransaction().hide(mRewardFragment).commit();
            }
            mBtnMypage.setTypeface(null, Typeface.BOLD);
            Drawable img_click = getApplicationContext().getResources().getDrawable(R.drawable.user_click);
            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, img_click,null,null);
            mBtnReward.setTypeface(null,Typeface.NORMAL);
            Drawable img_nonclick = getApplicationContext().getResources().getDrawable(R.drawable.gift);
            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, img_nonclick,null,null);
        }
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
