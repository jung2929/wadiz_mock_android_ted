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

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.reward.reward_open.Adapters.OpenItemRvAdapter;
import com.softsquared.wadiz.src.main.reward.reward_open.interfaces.RewardOpenActivityView;
import com.softsquared.wadiz.src.main.reward.reward_open.models.Openlist;

import java.util.ArrayList;


public class RewardOpenFragment extends BaseFragment implements RewardOpenActivityView {
    View view;
    ImageView mIvBanner;
    RecyclerView rvItem;
    ArrayList<Openlist> mOpenlistArrayList;

    public RewardOpenFragment() {

    }

    public static RewardOpenFragment newInstance() {
        RewardOpenFragment mainActivity = new RewardOpenFragment();
        return mainActivity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_reward_open, container, false);
        mIvBanner = view.findViewById(R.id.reward_open_iv_banner);
        rvItem = view.findViewById(R.id.reward_open_rv);

        // 아이템에 넣을 리스트 생성
        mOpenlistArrayList = new ArrayList<>();
        tryGetTest();
        return view;
    }

    private void tryGetTest() {
        showProgressDialog();

        final RewardOpenService rewardOpenService = new RewardOpenService(this);
        rewardOpenService.getTest();
    }

    @Override
    public void validateSuccess(ArrayList<Openlist> result) {
        hideProgressDialog();
        mOpenlistArrayList = result;
        //아이템 리사이클러뷰 생성
        rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
        OpenItemRvAdapter openItemRvAdapter = new OpenItemRvAdapter(mOpenlistArrayList, getActivity());
        rvItem.setAdapter(openItemRvAdapter);
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
