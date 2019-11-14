package com.softsquared.wadiz.src.main;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.common.InavailableFragment;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.loginFragment.LoginFragment;
import com.softsquared.wadiz.src.main.interfaces.MainActivityView;
import com.softsquared.wadiz.src.main.mypage.MypageFragment;
import com.softsquared.wadiz.src.main.mypage.mypage_card.Mypage_cardFragment;
import com.softsquared.wadiz.src.main.reward.RewardFragment;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MainActivity extends BaseActivity implements MainActivityView {
    FrameLayout mFlContainer;
    public static Context mcontext;
    Button mBtnReward, mBtnMypage, mBtnInvestment, mBtnHome, mBtnMore;
    FragmentManager fragmentManager;
    Intent getintent;
    Fragment mMypageFragment, mRewardFragment, mLoginFragment, mInavailabeFragment, mCardFragment;
    public String cardnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlContainer = findViewById(R.id.main_fl_container);
        mBtnMypage = findViewById(R.id.main_btn_footer_mypage);
        mBtnReward = findViewById(R.id.main_btn_footer_reward);
        mBtnInvestment = findViewById(R.id.main_btn_footer_investment);
        mBtnHome = findViewById(R.id.main_btn_footer_home);
        mBtnMore = findViewById(R.id.main_btn_footer_more);

        mcontext = this;

        fragmentManager = getSupportFragmentManager();
        mCardFragment = new Mypage_cardFragment();

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

        mBtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentChange(3);
            }
        });
        mBtnInvestment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentChange(2);
            }
        });
        mBtnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentChange(4);
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        int request = requestCode & 0xffff;
//
//        // 프래그먼트에서 결과값을 받아야 한다면 아래와 같이...
//        Mypage_cardFragment mypage_cardFragment = (Mypage_cardFragment) getSupportFragmentManager().findFragmentById(R.id.main_fl_container);
//        mypage_cardFragment.onActivityResult(request, resultCode, data);


        System.out.println("액티비티리절트 호출 : " + request);

        if (resultCode == RESULT_OK) {
            System.out.println("액티비티리절트 이프문 진입");
            switch (request) {
                case 1000: //로그인
                    System.out.println("로그인 성공");
                    fragmentManager.beginTransaction().remove(mLoginFragment).commitAllowingStateLoss();
                    if (mMypageFragment == null)
                        fragmentManager.beginTransaction().add(R.id.main_fl_container, mMypageFragment).commitAllowingStateLoss();
                    else
                        fragmentManager.beginTransaction().replace(R.id.main_fl_container, mMypageFragment).commitAllowingStateLoss();
                    break;

                case 2000: //프로필 수정
                    break;

                case 3000: //카드등록
                    Mypage_cardFragment mypage_cardFragment = (Mypage_cardFragment) getSupportFragmentManager().findFragmentById(R.id.mypage_fl_container);
                    mypage_cardFragment.setCardvisible(View.GONE, View.VISIBLE, data.getStringExtra("cardnum"));
                    System.out.println("카드번호 : " + data.getStringExtra("cardnum"));
                    break;

            }
        }

    }

    public void onFragmentChange(int index) {
        if (index == 0) { //리워드 버튼 클릭
            if (mRewardFragment == null) {
                mRewardFragment = new RewardFragment();
                fragmentManager.beginTransaction().replace(R.id.main_fl_container, mRewardFragment).commitAllowingStateLoss();
            } else
                fragmentManager.beginTransaction().replace(R.id.main_fl_container, mRewardFragment).commitAllowingStateLoss();
            Drawable giftClick = getApplicationContext().getResources().getDrawable(R.drawable.gift_click);
            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, giftClick, null, null);
            mBtnReward.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            Drawable myNonclick = getApplicationContext().getResources().getDrawable(R.drawable.my_nonclick);
            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, myNonclick, null, null);
            mBtnMypage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable investNonclick = getApplicationContext().getResources().getDrawable(R.drawable.investment_nonclick);
            mBtnInvestment.setCompoundDrawablesWithIntrinsicBounds(null, investNonclick, null, null);
            mBtnInvestment.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable moreNonclick = getApplicationContext().getResources().getDrawable(R.drawable.more_nonclick);
            mBtnMore.setCompoundDrawablesWithIntrinsicBounds(null, moreNonclick, null, null);
            mBtnMore.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable homeNonclick = getApplicationContext().getResources().getDrawable(R.drawable.home_nonclick);
            mBtnHome.setCompoundDrawablesWithIntrinsicBounds(null, homeNonclick, null, null);
            mBtnHome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));

        } else if (index == 1) { //마이 버튼 클릭
            if (SaveSharedPreference.getUserToken(getApplicationContext()).length() == 0) {
                if (mLoginFragment == null) {
                    mLoginFragment = new LoginFragment();
                    fragmentManager.beginTransaction().replace(R.id.main_fl_container, mLoginFragment).commitAllowingStateLoss();
                } else {
                    fragmentManager.beginTransaction().replace(R.id.main_fl_container, mLoginFragment).commitAllowingStateLoss();
                }
            } else {
                if (mMypageFragment == null) {
                    mMypageFragment = new MypageFragment();
                    fragmentManager.beginTransaction().replace(R.id.main_fl_container, mMypageFragment).commitAllowingStateLoss();

                } else
                    fragmentManager.beginTransaction().replace(R.id.main_fl_container, mMypageFragment).commitAllowingStateLoss();
            }

            Drawable giftNoneclick = getApplicationContext().getResources().getDrawable(R.drawable.gift_nonclick);
            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, giftNoneclick, null, null);
            mBtnReward.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable myClick = getApplicationContext().getResources().getDrawable(R.drawable.my_click);
            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, myClick, null, null);
            mBtnMypage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            Drawable investNonclick = getApplicationContext().getResources().getDrawable(R.drawable.investment_nonclick);
            mBtnInvestment.setCompoundDrawablesWithIntrinsicBounds(null, investNonclick, null, null);
            mBtnInvestment.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable moreNonclick = getApplicationContext().getResources().getDrawable(R.drawable.more_nonclick);
            mBtnMore.setCompoundDrawablesWithIntrinsicBounds(null, moreNonclick, null, null);
            mBtnMore.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable homeNonclick = getApplicationContext().getResources().getDrawable(R.drawable.home_nonclick);
            mBtnHome.setCompoundDrawablesWithIntrinsicBounds(null, homeNonclick, null, null);
            mBtnHome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
        } else if (index == 2) { //투자 버튼 클릭
            if (mInavailabeFragment == null) {
                mInavailabeFragment = new InavailableFragment();
                fragmentManager.beginTransaction().replace(R.id.main_fl_container, mInavailabeFragment).commitAllowingStateLoss();
            } else {
                fragmentManager.beginTransaction().replace(R.id.main_fl_container, mInavailabeFragment).commitAllowingStateLoss();
            }
            Drawable giftNoneclick = getApplicationContext().getResources().getDrawable(R.drawable.gift_nonclick);
            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, giftNoneclick, null, null);
            mBtnReward.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable myNonclick = getApplicationContext().getResources().getDrawable(R.drawable.my_nonclick);
            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, myNonclick, null, null);
            mBtnMypage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable investClick = getApplicationContext().getResources().getDrawable(R.drawable.investment_click);
            mBtnInvestment.setCompoundDrawablesWithIntrinsicBounds(null, investClick, null, null);
            mBtnInvestment.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
            Drawable moreNonclick = getApplicationContext().getResources().getDrawable(R.drawable.more_nonclick);
            mBtnMore.setCompoundDrawablesWithIntrinsicBounds(null, moreNonclick, null, null);
            mBtnMore.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable homeNonclick = getApplicationContext().getResources().getDrawable(R.drawable.home_nonclick);
            mBtnHome.setCompoundDrawablesWithIntrinsicBounds(null, homeNonclick, null, null);
            mBtnHome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
        } else if (index == 3) { //홈 버튼 클릭
            if (mInavailabeFragment == null) {
                mInavailabeFragment = new InavailableFragment();
                fragmentManager.beginTransaction().replace(R.id.main_fl_container, mInavailabeFragment).commitAllowingStateLoss();
            } else {
                fragmentManager.beginTransaction().replace(R.id.main_fl_container, mInavailabeFragment).commitAllowingStateLoss();
            }
            Drawable giftNoneclick = getApplicationContext().getResources().getDrawable(R.drawable.gift_nonclick);
            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, giftNoneclick, null, null);
            mBtnReward.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable myNonclick = getApplicationContext().getResources().getDrawable(R.drawable.my_nonclick);
            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, myNonclick, null, null);
            mBtnMypage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable investNonclick = getApplicationContext().getResources().getDrawable(R.drawable.investment_nonclick);
            mBtnInvestment.setCompoundDrawablesWithIntrinsicBounds(null, investNonclick, null, null);
            mBtnInvestment.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable moreNonclick = getApplicationContext().getResources().getDrawable(R.drawable.more_nonclick);
            mBtnMore.setCompoundDrawablesWithIntrinsicBounds(null, moreNonclick, null, null);
            mBtnMore.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable homeClick = getApplicationContext().getResources().getDrawable(R.drawable.home_click);
            mBtnHome.setCompoundDrawablesWithIntrinsicBounds(null, homeClick, null, null);
            mBtnHome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        } else if (index == 4) { // 더보기 버튼 클릭
            if (mInavailabeFragment == null) {
                mInavailabeFragment = new InavailableFragment();
                fragmentManager.beginTransaction().replace(R.id.main_fl_container, mInavailabeFragment).commitAllowingStateLoss();
            } else {
                fragmentManager.beginTransaction().replace(R.id.main_fl_container, mInavailabeFragment).commitAllowingStateLoss();
            }
            Drawable giftNoneclick = getApplicationContext().getResources().getDrawable(R.drawable.gift_nonclick);
            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, giftNoneclick, null, null);
            mBtnReward.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable myNonclick = getApplicationContext().getResources().getDrawable(R.drawable.my_nonclick);
            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, myNonclick, null, null);
            mBtnMypage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable investNonclick = getApplicationContext().getResources().getDrawable(R.drawable.investment_nonclick);
            mBtnInvestment.setCompoundDrawablesWithIntrinsicBounds(null, investNonclick, null, null);
            mBtnInvestment.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable moreClick = getApplicationContext().getResources().getDrawable(R.drawable.more_click);
            mBtnMore.setCompoundDrawablesWithIntrinsicBounds(null, moreClick, null, null);
            mBtnMore.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
            Drawable homeNonclick = getApplicationContext().getResources().getDrawable(R.drawable.home_nonclick);
            mBtnHome.setCompoundDrawablesWithIntrinsicBounds(null, homeNonclick, null, null);
            mBtnHome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
        }
    }

    @Override
    protected void onResume() {
        getintent = getIntent();
        cardnum = getintent.getStringExtra("cardnum");
        System.out.println("메인액티비티 값 : " + cardnum);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SaveSharedPreference.clearUserToken(this);
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
