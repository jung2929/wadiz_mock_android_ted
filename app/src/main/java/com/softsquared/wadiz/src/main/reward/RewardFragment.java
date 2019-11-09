package com.softsquared.wadiz.src.main.reward;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.reward.interfaces.MainActivityView;

import java.util.ArrayList;

public class RewardFragment extends BaseFragment implements MainActivityView {
    View view;
    TabLayout tabLayout;
    ArrayList<String> tabNames = new ArrayList<>();
    ViewPager viewPager;
    FragmentActivity myContext;

    public RewardFragment() {

    }

    public static RewardFragment newInstance() {
        RewardFragment rewardFragment = new RewardFragment();
        return rewardFragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reward, container, false);
        tabLayout = view.findViewById(R.id.reward_tab);
        viewPager = view.findViewById(R.id.reward_vp);
        loadTabName();
        setTabLayout();
        setViewPager();
        return view;
    }

    @TargetApi(Build.VERSION_CODES.N)
    private void setTabLayout() {
        tabNames.stream().forEach(name -> tabLayout.addTab(tabLayout.newTab().setText(name)));
    }

    private void loadTabName() {
        tabNames.add("리워드 홈");
        tabNames.add("오픈예정");
        tabNames.add("글로벌");
        tabNames.add("수요조사");
    }

    @Override
    public void onStop() {
        super.onStop();
        tabNames.clear();
    }

    private void setViewPager() {

        FragmentAdapter adapter = new FragmentAdapter(myContext.getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        myContext = (FragmentActivity) context;
        super.onAttach(context);
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
