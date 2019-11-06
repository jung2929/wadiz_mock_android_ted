package com.softsquared.wadiz.src.reward_open;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.reward_home.BigItemRvAdapter;
import com.softsquared.wadiz.src.reward_home.Itemlist;
import com.softsquared.wadiz.src.reward_home.SmallItemRvAdapter;
import com.softsquared.wadiz.src.reward_open.interfaces.MainActivityView;

import java.util.ArrayList;


public class Reward_openFragment extends BaseFragment implements MainActivityView {
    View view;
    ViewPager viewPager;
    ViewpagerAdapter pagerAdapter;
    RecyclerView rvItem;

    public Reward_openFragment() {

    }

    public static Reward_openFragment newInstance() {
        Reward_openFragment mainActivity = new Reward_openFragment();
        return mainActivity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reward_open, container, false);
        viewPager = view.findViewById(R.id.reward_open_vp);
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
                if(position < pagerAdapter.view_count)        //1번째 아이템에서 마지막 아이템으로 이동하면
                    viewPager.setCurrentItem(position+pagerAdapter.view_count, false); //이동 애니메이션을 제거 해야 한다
                else if(position >= pagerAdapter.view_count*2)     //마지막 아이템에서 1번째 아이템으로 이동하면
                    viewPager.setCurrentItem(position - pagerAdapter.view_count, false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // 아이템에 넣을 리스트 생성
        ArrayList<Openlist> openlistArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            openlistArrayList.add(new Openlist(R.drawable.banner0+i, "예쁜건 기본 편리함은 덤!", "블랑쉐나인" ,"11"));
        }

        //아이템 리사이클러뷰 생성
        rvItem = view.findViewById(R.id.reward_open_rv);
        rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        OpenItemRvAdapter openItemRvAdapter = new OpenItemRvAdapter(openlistArrayList);
        rvItem.setAdapter(openItemRvAdapter);

        return view;
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
