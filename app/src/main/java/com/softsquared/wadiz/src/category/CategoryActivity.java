package com.softsquared.wadiz.src.category;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.Item.MainItem.ItemMainActivity;
import com.softsquared.wadiz.src.category.Adapters.BigItemRvAdapter;
import com.softsquared.wadiz.src.category.Adapters.CategoryRvAdapter;
import com.softsquared.wadiz.src.category.Adapters.SmallItemRvAdapter;
import com.softsquared.wadiz.src.category.interfaces.CategoryActivityView;
import com.softsquared.wadiz.src.category.models.CategoryNamelist;
import com.softsquared.wadiz.src.category.models.Itemlist;
import com.softsquared.wadiz.src.main.MainActivity;

import java.util.ArrayList;


public class CategoryActivity extends BaseActivity implements CategoryActivityView {

    ImageButton mIbBack, mIbHome, mIbMore;
    RecyclerView mRvCategoryName, mRvItem;
    ArrayList<CategoryNamelist> categoryNamelistArrayList;
    ImageView mIvMain;
    TextView mTvMianName;
    public int mCategoryIdx;
    EditText mEtCategory;
    Button  mBtnControl, mBtnOrder;
    ImageButton mIbCategoryShowlist;
    boolean showitemflag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mRvItem = findViewById(R.id.category_rv_item);
        mIbBack = findViewById(R.id.category_ib_back);
        mIbHome = findViewById(R.id.category_ib_home);
        mIbMore = findViewById(R.id.category_ib_more);
        mRvCategoryName = findViewById(R.id.category_rv_name);
        mIvMain = findViewById(R.id.category_iv_main);
        mTvMianName = findViewById(R.id.category_tv_main_name);
        mEtCategory = findViewById(R.id.category_et);
        mBtnControl = findViewById(R.id.category_btn_control);
        mBtnOrder = findViewById(R.id.category_btn_order);
        mIbCategoryShowlist = findViewById(R.id.category_ib_showlist);


        categoryNamelistArrayList = new ArrayList<>();

        Intent getintent = getIntent();
        mCategoryIdx = getintent.getIntExtra("categoryIdx", 999);

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


//        //카테고리 이름 선택 클릭 리스너
//        mRvCategoryName.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRvCategoryName, new ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                if (clickflag == false) {
//                    Drawable click = getApplicationContext().getResources().getDrawable(R.drawable.customborder_category_click);
//                    RelativeLayout rlCategory = view.findViewById(R.id.category_item_rl);
//                    rlCategory.setBackground(click);
//                    clickflag = true;
//                } else {
//                    Drawable nonclick = getApplicationContext().getResources().getDrawable(R.drawable.customborder_category_nonclick);
//                    rlCategory.setBackground(nonclick);
//                    clickflag = false;
//                }
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));


        // 아이템에 넣을 리스트 생성
        ArrayList<Itemlist> itemlistArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            itemlistArrayList.add(new Itemlist(R.drawable.banner0, "[맛있는건 퍼-먹자] 뜯는순간 완통 보장! 지중해 만능요리, 그릭후무스", "푸드", "얄라 (yalla)", "50", "200,000", "20"));
        }

        //아이템 리사이클러뷰 생성

        mRvItem.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        SmallItemRvAdapter smallItemRvAdapter = new SmallItemRvAdapter(itemlistArrayList);
        BigItemRvAdapter bigItemRvAdapter = new BigItemRvAdapter(itemlistArrayList);
        mRvItem.setAdapter(smallItemRvAdapter);

        showitemflag = true; //아이템 리스트 보여주는 방식 변경을 위한 플래그 (small리스트 사용시 true, big리스트 사용시 false)

        //버튼 클릭시 보여주기 방식 변경 (크게/작게)
        mIbCategoryShowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showitemflag) {
                    mRvItem.setAdapter(bigItemRvAdapter);
                    mIbCategoryShowlist.setImageResource(R.drawable.biglist);
                    showitemflag = false;
                } else {
                    mRvItem.setAdapter(smallItemRvAdapter);
                    mIbCategoryShowlist.setImageResource(R.drawable.smalllist);
                    showitemflag = true;
                }

            }
        });

        //리사이클러뷰 클릭 이벤트 구현
        mRvItem.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRvItem, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(), ItemMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
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
//리사이클러뷰 클릭 리스너 추가
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

    private void tryGetTest() {
        showProgressDialog();

        final CategoryService categoryService = new CategoryService(this);
        categoryService.getCategoryName();
    }

    @Override
    public void validateSuccess(ArrayList<CategoryNamelist> result) {
        hideProgressDialog();
        categoryNamelistArrayList = result;
        mRvCategoryName.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        CategoryRvAdapter categoryRvAdapter = new CategoryRvAdapter(getApplicationContext(), categoryNamelistArrayList);
        mRvCategoryName.setAdapter(categoryRvAdapter);
        Glide.with(getApplicationContext()).load(categoryNamelistArrayList.get(mCategoryIdx).getImage()).into(mIvMain);
        mTvMianName.setText(categoryNamelistArrayList.get(mCategoryIdx).getName());

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
