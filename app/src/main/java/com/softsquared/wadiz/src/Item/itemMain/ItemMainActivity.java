package com.softsquared.wadiz.src.Item.itemMain;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.PurchaseFirstActivity;
import com.softsquared.wadiz.src.Item.itemMain.interfaces.ItemMainActivityView;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.ItemStoryFragment;
import com.softsquared.wadiz.src.Item.itemMain.item_main_supporter.ItemMainSupporterFragment;
import com.softsquared.wadiz.src.Item.itemMain.policy.PolicyActivity;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.MainActivity;


public class ItemMainActivity extends BaseActivity implements ItemMainActivityView {
    public static Context mcontext;
    ImageButton ibBack, ibHome, ibLike;
    public TextView tvTitleName;
    Button btnStory, btnReward, btnSupporter, btnFunding;
    Fragment storyFragment, supporterFragment;
    FragmentManager fragmentManager;
    public int mProjectIdx;
    NestedScrollView scrollView;
    public String mMoney, mDay, mPercent, mTitle;
    boolean isLike;

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

        Intent getintent = getIntent();
        mProjectIdx = getintent.getIntExtra("projectIdx", 999);
        mDay = getintent.getStringExtra("day");
        mPercent = getintent.getStringExtra("percent");
        mMoney = getintent.getStringExtra("money");

        storyFragment = new ItemStoryFragment();
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

        ItemStoryFragment fragment = (ItemStoryFragment) fragmentManager.findFragmentById(R.id.item_main_container);

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

        btnFunding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), PolicyActivity.class);
                intent.putExtra("projectidx", mProjectIdx);
                intent.putExtra("name", mTitle);
                startActivity(intent);

            }
        });
        isLike = false;
        ibLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryGetTest();
            }
        });
    }

    public void onFragmentChange(int index) {
        if (index == 0) { //상품설명 + 리워드
            if (storyFragment == null) {
                storyFragment = new ItemStoryFragment();
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
                supporterFragment = new ItemMainSupporterFragment();
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

        final ItemMainService itemMainService = new ItemMainService(this);
        itemMainService.getTest(mProjectIdx, SaveSharedPreference.getUserToken(getApplicationContext()));
    }

    @Override
    public void validateSuccess(int code) {
        hideProgressDialog();
        if (code == 201){
            Toast.makeText(getApplicationContext(), "좋아하는 프로젝트에서 제외 되었습니다.",Toast.LENGTH_SHORT).show();
        } else  if (code == 200) {
            Toast.makeText(getApplicationContext(), "좋아하는 프로젝트 저장 완료!\n마이메뉴 > 좋아한 에서 확인 할 수 있습니다.",Toast.LENGTH_SHORT).show();
        }
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
