package com.softsquared.wadiz.src.item_main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.item_main.interfaces.MainActivityView;
import com.softsquared.wadiz.src.item_main_story.Item_main_storyFragment;
import com.softsquared.wadiz.src.item_main_supporter.Item_main_supporterFragment;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.mypage.MypageFragment;
import com.softsquared.wadiz.src.reward.RewardFragment;


public class Item_mainActivity extends BaseActivity implements MainActivityView {
    public static Context mcontext;
    ImageButton ibBack, ibHome, ibLike;
    TextView tvTitleName;
    Button btnStory, btnReward, btnSupporter, btnFunding;
    Fragment storyFragment, supporterFragment;
    FragmentManager fragmentManager;
    NestedScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_main);
        ibBack = findViewById(R.id.item_main_ib_back);
        ibHome = findViewById(R.id.item_main_ib_home);
        tvTitleName = findViewById(R.id.item_main_tv_title_name);
        btnStory = findViewById(R.id.item_main_btn_story);
        btnReward = findViewById(R.id.item_main_btn_reward);
        btnSupporter = findViewById(R.id.item_main_btn_supporter);
        ibLike = findViewById(R.id.item_main_ib_like);
        btnFunding = findViewById(R.id.item_main_footer_btn_funding);


        storyFragment = new Item_main_storyFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.item_main_container, storyFragment).commitAllowingStateLoss();

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) MainActivity.mcontext).onFragmentChange(0);
                finish();
            }
        });

        Item_main_storyFragment fragment = (Item_main_storyFragment) fragmentManager.findFragmentById(R.id.item_main_container);

        btnStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentChange(0);
            }
        });

        btnSupporter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentChange(1);
            }
        });
    }

    public void onFragmentChange(int index) {
        if (index == 0) { //상품설명 + 리워드
            if (storyFragment == null) {
                storyFragment = new Item_main_storyFragment();
                fragmentManager.beginTransaction().replace(R.id.item_main_container, storyFragment).commitAllowingStateLoss();

            } else {
                fragmentManager.beginTransaction().replace(R.id.item_main_container, storyFragment).commitAllowingStateLoss();
            }

            Drawable img_click = getApplicationContext().getResources().getDrawable(R.drawable.customborder_mypage_click);
            btnStory.setBackground(img_click);
            Drawable img_nonclick = getApplicationContext().getResources().getDrawable(R.drawable.customborder_mypage_nonclick);
            btnSupporter.setBackground(img_nonclick);
            btnReward.setBackground(img_nonclick);

        } else if (index == 1) { //서포터
            if (supporterFragment == null) {
                supporterFragment = new Item_main_supporterFragment();
                fragmentManager.beginTransaction().replace(R.id.item_main_container, supporterFragment).commitAllowingStateLoss();
            } else {
                fragmentManager.beginTransaction().replace(R.id.item_main_container, supporterFragment).commitAllowingStateLoss();
            }
            Drawable img_click = getApplicationContext().getResources().getDrawable(R.drawable.customborder_mypage_click);
            btnSupporter.setBackground(img_click);
            Drawable img_nonclick = getApplicationContext().getResources().getDrawable(R.drawable.customborder_mypage_nonclick);
            btnReward.setBackground(img_nonclick);
            btnStory.setBackground(img_nonclick);
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
