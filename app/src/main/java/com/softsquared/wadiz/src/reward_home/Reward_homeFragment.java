package com.softsquared.wadiz.src.reward_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.reward_home.interfaces.MainActivityView;

import java.util.ArrayList;

public class Reward_homeFragment extends BaseFragment implements MainActivityView {
    View view;
    ViewPager viewPager;
    ViewpagerAdapter pagerAdapter;
    RecyclerView rvCategory, rvItem;
    EditText etSearch;
    Button btnControl, btnOrder;
    ImageButton ibShowlist;
    SmalllistAdapter smalllistAdapter;
    NestedScrollView nestedScrollView;


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
        nestedScrollView = view.findViewById(R.id.reward_home_sv);

        pagerAdapter = new ViewpagerAdapter(getActivity());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(pagerAdapter.view_count);

        //배너 무한스크롤 구현 (마지막에서 다시 처음으로)
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position < pagerAdapter.view_count)        //1번째 아이템에서 마지막 아이템으로 이동하면
                    viewPager.setCurrentItem(position + pagerAdapter.view_count, false); //이동 애니메이션을 제거 해야 한다
                else if (position >= pagerAdapter.view_count * 2)     //마지막 아이템에서 1번째 아이템으로 이동하면
                    viewPager.setCurrentItem(position - pagerAdapter.view_count, false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // 카테고리에 넣을 리스트 생성
        ArrayList<Category> categoryArrayList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            categoryArrayList.add(new Category(R.mipmap.ic_launcher_round, "카테고리" + i));
        }

        //카테고리 리사이클러뷰 생성
        rvCategory = view.findViewById(R.id.reward_home_rv_category);
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        CategoryRvAdapter categoryRvAdapter = new CategoryRvAdapter(categoryArrayList);
        rvCategory.setAdapter(categoryRvAdapter);

        // 아이템에 넣을 리스트 생성
        ArrayList<Itemlist> itemlistArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            itemlistArrayList.add(new Itemlist(R.drawable.banner0, "[맛있는건 퍼-먹자] 뜯는순간 완통 보장! 지중해 만능요리, 그릭후무스", "푸드" ,"얄라 (yalla)", "50", "200,000","20"));
        }
        //아이템 리사이클러뷰 생성
        rvItem = view.findViewById(R.id.reward_home_lv);
        smalllistAdapter = new SmalllistAdapter();
        rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemRvAdapter itemRvAdapter = new ItemRvAdapter(itemlistArrayList);
        rvItem.setAdapter(itemRvAdapter);


//        listView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                nestedScrollView.requestDisallowInterceptTouchEvent(true);
//                return false;
//            }
//        });

        return view;
    }
    public View mHeader;


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
