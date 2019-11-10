package com.softsquared.wadiz.src.main.reward.reward_home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.Item.MainItem.ItemMainActivity;
import com.softsquared.wadiz.src.main.reward.reward_home.Adapters.BigItemRvAdapter;
import com.softsquared.wadiz.src.main.reward.reward_home.Adapters.CategoryRvAdapter;
import com.softsquared.wadiz.src.main.reward.reward_home.Adapters.SmallItemRvAdapter;
import com.softsquared.wadiz.src.main.reward.reward_home.Adapters.ViewpagerAdapter;
import com.softsquared.wadiz.src.main.reward.reward_home.interfaces.RewardHomeView;
import com.softsquared.wadiz.src.main.reward.reward_home.models.BannerItemlist;
import com.softsquared.wadiz.src.main.reward.reward_home.models.BannerResponse;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryItemList;
import com.softsquared.wadiz.src.main.reward.reward_home.models.CategoryResponse;
import com.softsquared.wadiz.src.main.reward.reward_home.models.Itemlist;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Reward_homeFragment extends BaseFragment implements RewardHomeView {
    View view;
    ViewPager viewPager;
    ViewpagerAdapter pagerAdapter;
    RecyclerView rvCategory, rvItem;
    EditText etSearch;
    Button btnControl, btnOrder;
    ImageButton ibShowlist;
    boolean showitemflag;
    ArrayList<BannerItemlist> mBannerItemlist;
    BannerResponse mBannerResponse;
    ArrayList<CategoryItemList> mCategoryItemlist;
    CategoryResponse mCategoryResponse;
    ProgressBar mPb;
    RewardHomeService rewardHomeService;
    int mCurrentPage;


    public Reward_homeFragment() {

    }

    public static Reward_homeFragment newInstance() {
        Reward_homeFragment mainActivity = new Reward_homeFragment();
        return mainActivity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reward_home, container, false);
        viewPager = view.findViewById(R.id.reward_home_vp);
        rvCategory = view.findViewById(R.id.reward_home_rv_category);
        etSearch = view.findViewById(R.id.reward_home_et);
        btnControl = view.findViewById(R.id.reward_home_control);
        btnOrder = view.findViewById(R.id.reward_home_order);
        ibShowlist = view.findViewById(R.id.reward_home_showlist);
        mPb = view.findViewById(R.id.reward_home_pb);
        mBannerResponse = new BannerResponse();
        mCategoryResponse = new CategoryResponse();

        tryGetTest();




        // 아이템에 넣을 리스트 생성
        ArrayList<Itemlist> itemlistArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            itemlistArrayList.add(new Itemlist(R.drawable.banner0, "[맛있는건 퍼-먹자] 뜯는순간 완통 보장! 지중해 만능요리, 그릭후무스", "푸드", "얄라 (yalla)", "50", "200,000", "20"));
        }

        //아이템 리사이클러뷰 생성
        rvItem = view.findViewById(R.id.reward_home_lv);
        rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        SmallItemRvAdapter smallItemRvAdapter = new SmallItemRvAdapter(itemlistArrayList);
        BigItemRvAdapter bigItemRvAdapter = new BigItemRvAdapter(itemlistArrayList);
        rvItem.setAdapter(smallItemRvAdapter);

        showitemflag = true; //아이템 리스트 보여주는 방식 변경을 위한 플래그 (small리스트 사용시 true, big리스트 사용시 false)

        //버튼 클릭시 보여주기 방식 변경 (크게/작게)
        ibShowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showitemflag) {
                    rvItem.setAdapter(bigItemRvAdapter);
                    ibShowlist.setImageResource(R.drawable.biglist);
                    showitemflag = false;
                } else {
                    rvItem.setAdapter(smallItemRvAdapter);
                    ibShowlist.setImageResource(R.drawable.smalllist);
                    showitemflag = true;
                }

            }
        });

        //리사이클러뷰 클릭 이벤트 구현
        rvItem.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), rvItem, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getActivity(), ItemMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;
    }

    //리사이클러뷰 클릭 리스너 추가
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private Reward_homeFragment.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final Reward_homeFragment.ClickListener clickListener) {
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

        rewardHomeService = new RewardHomeService(this);
        rewardHomeService.getBanner();
        rewardHomeService.getCategory();
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();


        //배너 리스트 생성
        mBannerItemlist = new ArrayList<>();
        mBannerItemlist.addAll(rewardHomeService.mBannerItemlist);
        pagerAdapter = new ViewpagerAdapter(getActivity(), mBannerItemlist);
        pagerAdapter.view_count = mBannerItemlist.size();
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(pagerAdapter.view_count);

//       자동스크롤 잘안됨;
//        mCurrentPage = 0;
//        final Handler handler = new Handler();
//        final Runnable Update = new Runnable() {
//            public void run() {
//                if (mCurrentPage == pagerAdapter.view_count-1) {
//                    mCurrentPage = 0;
//                }
//                viewPager.setCurrentItem(mCurrentPage++, true);
//            }
//        };
//
//        Timer timer = new Timer(); // This will create a new Thread
//
//        timer.schedule(new TimerTask() { // task to be scheduled
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, 500, 3000);

        //배너 무한스크롤 구현 (마지막에서 다시 처음으로)
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int Count = pagerAdapter.view_count;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mPb.setProgress((100 / pagerAdapter.view_count) * position);
                if (position < pagerAdapter.view_count) {       //1번째 아이템에서 마지막 아이템으로 이동하면
                    viewPager.setCurrentItem(position + pagerAdapter.view_count, false); //이동 애니메이션을 제거 해야 한다
                    mPb.setProgress((100 / pagerAdapter.view_count) * pagerAdapter.view_count);
                } else if (position >= pagerAdapter.view_count * 2) {   //마지막 아이템에서 1번째 아이템으로 이동하면
                    viewPager.setCurrentItem(position - pagerAdapter.view_count, false);
                    mPb.setProgress((100 / pagerAdapter.view_count) * 1);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mCategoryItemlist = new ArrayList<>();
        mCategoryItemlist.addAll(rewardHomeService.mCategoryItemlist);

        //카테고리 리사이클러뷰 생성
        rvCategory = view.findViewById(R.id.reward_home_rv_category);
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        CategoryRvAdapter categoryRvAdapter = new CategoryRvAdapter(getContext(),mCategoryItemlist);
        rvCategory.setAdapter(categoryRvAdapter);


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
