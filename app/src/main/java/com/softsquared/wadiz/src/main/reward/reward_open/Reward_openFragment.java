package com.softsquared.wadiz.src.main.reward.reward_open;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.reward.reward_open.interfaces.MainActivityView;

import java.util.ArrayList;


public class Reward_openFragment extends BaseFragment implements MainActivityView {
    View view;
    ImageView mIvBanner;
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
        mIvBanner = view.findViewById(R.id.reward_open_iv_banner);

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
