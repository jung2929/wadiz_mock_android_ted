package com.softsquared.wadiz.src.main;

import android.content.Context;
import android.content.Intent;
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
import com.softsquared.wadiz.src.main.interfaces.MainActivityView;
import com.softsquared.wadiz.src.mypage.MypageFragment;
import com.softsquared.wadiz.src.reward.RewardFragment;


public class MainActivity extends BaseActivity implements MainActivityView {
    FrameLayout mFlContainer;
    public static Context mcontext;
    Button mBtnReward, mBtnMypage;
    FragmentManager fragmentManager;
    Intent getintent;
    Fragment mMypageFragment, mRewardFragment, mLoginFragment;
    public String cardnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlContainer = findViewById(R.id.main_fl_container);
        mBtnMypage = findViewById(R.id.main_btn_footer_mypage);
        mBtnReward = findViewById(R.id.main_btn_footer_reward);
        mcontext = this;

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
                fragmentManager.beginTransaction().add(R.id.main_fl_container,mRewardFragment).commitAllowingStateLoss();
                fragmentManager.beginTransaction().show(mRewardFragment).commitAllowingStateLoss();

            } else {
                fragmentManager.beginTransaction().show(mRewardFragment).commitAllowingStateLoss();
                fragmentManager.beginTransaction().hide(mMypageFragment).commitAllowingStateLoss();
            }
            mBtnReward.setTypeface(null, Typeface.BOLD);
            Drawable img_click = getApplicationContext().getResources().getDrawable(R.drawable.gift_click);
            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, img_click,null,null);
            mBtnMypage.setTypeface(null,Typeface.NORMAL);
            Drawable img_nonclick = getApplicationContext().getResources().getDrawable(R.drawable.user);
            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, img_nonclick,null,null);

        } else if (index==1) { //마이페이지
            if (mMypageFragment == null) {
                mMypageFragment = new MypageFragment();
                fragmentManager.beginTransaction().add(R.id.main_fl_container,mMypageFragment).commitAllowingStateLoss();
                fragmentManager.beginTransaction().show(mMypageFragment).commitAllowingStateLoss();

            } else {
                fragmentManager.beginTransaction().show(mMypageFragment).commitAllowingStateLoss();
                fragmentManager.beginTransaction().hide(mRewardFragment).commitAllowingStateLoss();
            }
            mBtnMypage.setTypeface(null, Typeface.BOLD);
            Drawable img_click = getApplicationContext().getResources().getDrawable(R.drawable.user_click);
            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, img_click,null,null);
            mBtnReward.setTypeface(null,Typeface.NORMAL);
            Drawable img_nonclick = getApplicationContext().getResources().getDrawable(R.drawable.gift);
            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, img_nonclick,null,null);
        }
    }

    @Override
    protected void onResume() {
        getintent = getIntent();
        cardnum = getintent.getStringExtra("cardnum");
        System.out.println("메인액티비티 값 : "+cardnum);
        super.onResume();
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
