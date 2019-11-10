package com.softsquared.wadiz.src.category;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.category.Adapters.CategoryRvAdapter;
import com.softsquared.wadiz.src.category.categoryFragment.AllCategoryFragment;
import com.softsquared.wadiz.src.category.interfaces.CategoryActivityView;
import com.softsquared.wadiz.src.category.models.CategoryNamelist;
import com.softsquared.wadiz.src.main.MainActivity;

import java.util.ArrayList;


public class CategoryActivity extends BaseActivity implements CategoryActivityView {

    ImageButton mIbBack, mIbHome, mIbMore;
    RecyclerView mRvCategoryName;
    FrameLayout mFlContainer;
    ArrayList<CategoryNamelist> categoryNamelistArrayList;
    FragmentManager mFragmentManager;
    Fragment mAllCategoryFragment;
    CategoryService mCategoryService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mIbBack = findViewById(R.id.category_ib_back);
        mIbHome = findViewById(R.id.category_ib_home);
        mRvCategoryName = findViewById(R.id.category_rv);
        mFlContainer = findViewById(R.id.category_fl_container);

        tryGetTest();

        mIbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mIbHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) MainActivity.mcontext).onFragmentChange(0);
                finish();
            }
        });

        mAllCategoryFragment = new AllCategoryFragment();
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.category_fl_container, mAllCategoryFragment).commitAllowingStateLoss();
    }

//    public void onFragmentChange(int index) {
//        if (index == 0) { //리워드 버튼 클릭
//            if (mRewardFragment == null) {
//                mRewardFragment = new RewardFragment();
//                fragmentManager.beginTransaction().add(R.id.main_fl_container, mRewardFragment).commitAllowingStateLoss();
//            } else {
//                if (mMypageFragment != null)
//                    fragmentManager.beginTransaction().hide(mMypageFragment).commitAllowingStateLoss();
//                if (mInavailabeFragment != null)
//                    fragmentManager.beginTransaction().hide(mInavailabeFragment).commitAllowingStateLoss();
//                if (mRewardFragment != null)
//                    fragmentManager.beginTransaction().show(mRewardFragment).commitAllowingStateLoss();
//            }
//            Drawable giftClick = getApplicationContext().getResources().getDrawable(R.drawable.gift_click);
//            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, giftClick, null, null);
//            mBtnReward.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
//            Drawable myNonclick = getApplicationContext().getResources().getDrawable(R.drawable.my_nonclick);
//            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, myNonclick, null, null);
//            mBtnMypage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable investNonclick = getApplicationContext().getResources().getDrawable(R.drawable.investment_nonclick);
//            mBtnInvestment.setCompoundDrawablesWithIntrinsicBounds(null, investNonclick, null, null);
//            mBtnInvestment.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable moreNonclick = getApplicationContext().getResources().getDrawable(R.drawable.more_nonclick);
//            mBtnMore.setCompoundDrawablesWithIntrinsicBounds(null, moreNonclick, null, null);
//            mBtnMore.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable homeNonclick = getApplicationContext().getResources().getDrawable(R.drawable.home_nonclick);
//            mBtnHome.setCompoundDrawablesWithIntrinsicBounds(null, homeNonclick, null, null);
//            mBtnHome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//
//        } else if (index == 1) { //마이 버튼 클릭
//            if (mMypageFragment == null) {
//                mMypageFragment = new MypageFragment();
//                fragmentManager.beginTransaction().add(R.id.main_fl_container, mMypageFragment).commitAllowingStateLoss();
//            } else {
//                if (mRewardFragment != null)
//                    fragmentManager.beginTransaction().hide(mRewardFragment).commitAllowingStateLoss();
//                if (mInavailabeFragment != null)
//                    fragmentManager.beginTransaction().hide(mInavailabeFragment).commitAllowingStateLoss();
//                if (mMypageFragment != null)
//                    fragmentManager.beginTransaction().show(mMypageFragment).commitAllowingStateLoss();
//            }
//            Drawable giftNoneclick = getApplicationContext().getResources().getDrawable(R.drawable.gift_nonclick);
//            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, giftNoneclick, null, null);
//            mBtnReward.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable myClick = getApplicationContext().getResources().getDrawable(R.drawable.my_click);
//            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, myClick, null, null);
//            mBtnMypage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
//            Drawable investNonclick = getApplicationContext().getResources().getDrawable(R.drawable.investment_nonclick);
//            mBtnInvestment.setCompoundDrawablesWithIntrinsicBounds(null, investNonclick, null, null);
//            mBtnInvestment.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable moreNonclick = getApplicationContext().getResources().getDrawable(R.drawable.more_nonclick);
//            mBtnMore.setCompoundDrawablesWithIntrinsicBounds(null, moreNonclick, null, null);
//            mBtnMore.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable homeNonclick = getApplicationContext().getResources().getDrawable(R.drawable.home_nonclick);
//            mBtnHome.setCompoundDrawablesWithIntrinsicBounds(null, homeNonclick, null, null);
//            mBtnHome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//        } else if (index == 2) { //투자 버튼 클릭
//            if (mInavailabeFragment == null) {
//                mInavailabeFragment = new InavailableFragment();
//                fragmentManager.beginTransaction().add(R.id.main_fl_container, mInavailabeFragment).commitAllowingStateLoss();
//            } else {
//                if (mMypageFragment != null)
//                    fragmentManager.beginTransaction().hide(mMypageFragment).commitAllowingStateLoss();
//                if (mRewardFragment != null)
//                    fragmentManager.beginTransaction().hide(mRewardFragment).commitAllowingStateLoss();
//                if (mInavailabeFragment != null)
//                    fragmentManager.beginTransaction().show(mInavailabeFragment).commitAllowingStateLoss();
//            }
//            Drawable giftNoneclick = getApplicationContext().getResources().getDrawable(R.drawable.gift_nonclick);
//            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, giftNoneclick, null, null);
//            mBtnReward.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable myNonclick = getApplicationContext().getResources().getDrawable(R.drawable.my_nonclick);
//            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, myNonclick, null, null);
//            mBtnMypage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable investClick = getApplicationContext().getResources().getDrawable(R.drawable.investment_click);
//            mBtnInvestment.setCompoundDrawablesWithIntrinsicBounds(null, investClick, null, null);
//            mBtnInvestment.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
//            Drawable moreNonclick = getApplicationContext().getResources().getDrawable(R.drawable.more_nonclick);
//            mBtnMore.setCompoundDrawablesWithIntrinsicBounds(null, moreNonclick, null, null);
//            mBtnMore.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable homeNonclick = getApplicationContext().getResources().getDrawable(R.drawable.home_nonclick);
//            mBtnHome.setCompoundDrawablesWithIntrinsicBounds(null, homeNonclick, null, null);
//            mBtnHome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//        } else if (index == 3) { //홈 버튼 클릭
//            if (mInavailabeFragment == null) {
//                mInavailabeFragment = new InavailableFragment();
//                fragmentManager.beginTransaction().add(R.id.main_fl_container, mInavailabeFragment).commitAllowingStateLoss();
//            } else {
//                if (mMypageFragment != null)
//                    fragmentManager.beginTransaction().hide(mMypageFragment).commitAllowingStateLoss();
//                if (mRewardFragment != null)
//                    fragmentManager.beginTransaction().hide(mRewardFragment).commitAllowingStateLoss();
//                if (mInavailabeFragment != null)
//                    fragmentManager.beginTransaction().show(mInavailabeFragment).commitAllowingStateLoss();
//            }
//            Drawable giftNoneclick = getApplicationContext().getResources().getDrawable(R.drawable.gift_nonclick);
//            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, giftNoneclick, null, null);
//            mBtnReward.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable myNonclick = getApplicationContext().getResources().getDrawable(R.drawable.my_nonclick);
//            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, myNonclick, null, null);
//            mBtnMypage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable investNonclick = getApplicationContext().getResources().getDrawable(R.drawable.investment_nonclick);
//            mBtnInvestment.setCompoundDrawablesWithIntrinsicBounds(null, investNonclick, null, null);
//            mBtnInvestment.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable moreNonclick = getApplicationContext().getResources().getDrawable(R.drawable.more_nonclick);
//            mBtnMore.setCompoundDrawablesWithIntrinsicBounds(null, moreNonclick, null, null);
//            mBtnMore.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable homeClick = getApplicationContext().getResources().getDrawable(R.drawable.home_click);
//            mBtnHome.setCompoundDrawablesWithIntrinsicBounds(null, homeClick, null, null);
//            mBtnHome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
//        } else if (index == 4) { // 더보기 버튼 클릭
//            if (mMypageFragment != null)
//                fragmentManager.beginTransaction().hide(mMypageFragment).commitAllowingStateLoss();
//            if (mRewardFragment != null)
//                fragmentManager.beginTransaction().hide(mRewardFragment).commitAllowingStateLoss();
//            if (mInavailabeFragment == null) {
//                mInavailabeFragment = new InavailableFragment();
//                fragmentManager.beginTransaction().add(R.id.main_fl_container, mInavailabeFragment).commitAllowingStateLoss();
//            } else {
//                if (mMypageFragment != null)
//                    fragmentManager.beginTransaction().hide(mMypageFragment).commitAllowingStateLoss();
//                if (mRewardFragment != null)
//                    fragmentManager.beginTransaction().hide(mRewardFragment).commitAllowingStateLoss();
//                if (mInavailabeFragment != null)
//                    fragmentManager.beginTransaction().show(mInavailabeFragment).commitAllowingStateLoss();
//            }
//            Drawable giftNoneclick = getApplicationContext().getResources().getDrawable(R.drawable.gift_nonclick);
//            mBtnReward.setCompoundDrawablesWithIntrinsicBounds(null, giftNoneclick, null, null);
//            mBtnReward.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable myNonclick = getApplicationContext().getResources().getDrawable(R.drawable.my_nonclick);
//            mBtnMypage.setCompoundDrawablesWithIntrinsicBounds(null, myNonclick, null, null);
//            mBtnMypage.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable investNonclick = getApplicationContext().getResources().getDrawable(R.drawable.investment_nonclick);
//            mBtnInvestment.setCompoundDrawablesWithIntrinsicBounds(null, investNonclick, null, null);
//            mBtnInvestment.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable moreClick = getApplicationContext().getResources().getDrawable(R.drawable.more_click);
//            mBtnMore.setCompoundDrawablesWithIntrinsicBounds(null, moreClick, null, null);
//            mBtnMore.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//            Drawable homeNonclick = getApplicationContext().getResources().getDrawable(R.drawable.home_nonclick);
//            mBtnHome.setCompoundDrawablesWithIntrinsicBounds(null, homeNonclick, null, null);
//            mBtnHome.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
//        }
//    }


    private void tryGetTest() {
        showProgressDialog();

        final CategoryService categoryService = new CategoryService(this);
        categoryService.getCategoryName();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
        categoryNamelistArrayList = new ArrayList<>();
        categoryNamelistArrayList.addAll(mCategoryService.mCategoryNamelist);
        mRvCategoryName.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        CategoryRvAdapter categoryRvAdapter = new CategoryRvAdapter(getApplicationContext(), categoryNamelistArrayList);
        mRvCategoryName.setAdapter(categoryRvAdapter);
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
