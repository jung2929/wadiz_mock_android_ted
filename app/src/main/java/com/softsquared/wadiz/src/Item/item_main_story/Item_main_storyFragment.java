package com.softsquared.wadiz.src.Item.item_main_story;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.Item.item_main_story.interfaces.MainActivityView;
import com.softsquared.wadiz.src.Item.item_main_story.models.Itemmainlist;
import com.softsquared.wadiz.src.Item.policy.PolicyActivity;
import com.softsquared.wadiz.src.common.RecyclerDecoration;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class Item_main_storyFragment extends BaseFragment implements MainActivityView {
    View view;
    ViewPager viewPager;
    ViewpagerAdapter pagerAdapter;
    TextView tvName, tvCategory, tvInfo, tvDay, tvPercent, tvMoney, tvSupporter, tvGoalmoney, tvStartday, tvFinishday, tvMain, tvSchedule, tvQna, tvDelivery, tvCompany_name;
    ImageView ivMainimage;
    CircleImageView ivCompany_image;
    ProgressBar pb;
    Button btnFunding, btnLike, btnMore, btnLess, btnCompany_homepage;
    RecyclerView rvItem;
    NestedScrollView scrollView;

    public Item_main_storyFragment() {

    }

    public static Item_main_storyFragment newInstance() {
        Item_main_storyFragment itemmainstoryFragment = new Item_main_storyFragment();
        return itemmainstoryFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_item_main_story, container, false);
        tvName = view.findViewById(R.id.item_main_tv_name);
        tvCategory = view.findViewById(R.id.item_main_tv_category);
        tvDay = view.findViewById(R.id.item_main_tv_info);
        tvPercent = view.findViewById(R.id.item_main_tv_name);
        tvMoney = view.findViewById(R.id.item_main_tv_name);
        tvSupporter = view.findViewById(R.id.item_main_tv_name);
        tvGoalmoney = view.findViewById(R.id.item_main_tv_name);
        tvStartday = view.findViewById(R.id.item_main_tv_name);
        tvFinishday = view.findViewById(R.id.item_main_tv_name);
        tvMain = view.findViewById(R.id.item_main_tv_name);
        tvSchedule = view.findViewById(R.id.item_main_tv_name);
        tvQna = view.findViewById(R.id.item_main_tv_name);
        tvDelivery = view.findViewById(R.id.item_main_tv_name);
        tvCompany_name = view.findViewById(R.id.item_main_tv_name);
        ivMainimage = view.findViewById(R.id.itme_main_iv_mainimage);
        ivCompany_image = view.findViewById(R.id.item_main_iv_companyimage);
        pb = view.findViewById(R.id.item_main_progress);
        btnFunding = view.findViewById(R.id.item_main_btn_funding);
        btnLike = view.findViewById(R.id.item_main_btn_like);
        btnMore = view.findViewById(R.id.item_main_btn_more);
        btnLess = view.findViewById(R.id.item_main_btn_less);
        btnCompany_homepage = view.findViewById(R.id.item_main_btn_company_homepage);
        scrollView = view.findViewById(R.id.item_main_sv);
        viewPager = view.findViewById(R.id.item_main_vp);

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

        ArrayList<Itemmainlist> itemmainlistArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            itemmainlistArrayList.add(new Itemmainlist("10,000", "이곳은 이름입니다@@@@@@@@@", "소프트스퀘어드", "0", "2019년 11월 31일", "200", "30", "30"));
        }

        //리사이클러 뷰 간 간격 조정
        RecyclerDecoration recyclerDecoration = new RecyclerDecoration(20);

        //아이템 리사이클러뷰 생성
        rvItem = view.findViewById(R.id.item_main_rv);
        rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemRvAdapter smallItemRvAdapter = new ItemRvAdapter(itemmainlistArrayList);
        rvItem.addItemDecoration(recyclerDecoration);
        rvItem.setAdapter(smallItemRvAdapter);

        //더보기 기능
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("클릭");
                tvMain.setMaxLines(100);
                btnMore.setVisibility(View.GONE);
                btnLess.setVisibility(View.VISIBLE);
            }
        });

        btnLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMain.setMaxLines(5);
                btnMore.setVisibility(View.VISIBLE);
                btnLess.setVisibility(View.GONE);
            }
        });

        btnFunding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PolicyActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public void scrollstart() {
        scrollToView(rvItem, scrollView, 0);
    }

    //스크롤뷰를 내리기 위한 클래스
    public static void scrollToView(View view, final NestedScrollView scrollView, int count) {
        if (view != null && view != scrollView) {
            count += view.getTop();
            scrollToView((View) view.getParent(), scrollView, count);
        } else if (scrollView != null) {
            final int finalCount = count;
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    scrollView.smoothScrollTo(0, finalCount);
                }
            }, 200);
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