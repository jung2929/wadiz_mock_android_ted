package com.softsquared.wadiz.src.main.mypage.mypage_funding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.common.RecyclerDecoration;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.Adapters.FundingItemRvAdapter;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.interfaces.FundingActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.models.FundingItemlist;

import java.util.ArrayList;


public class MypageFundingFragment extends BaseFragment implements FundingActivityView {
    View view;
    TextView tvNull;
    LinearLayout llNum;;
    RecyclerView rvItem;
    int mProjectIdx;
    ArrayList<FundingItemlist> fundingItemlistArrayList;
    public MypageFundingFragment() {

    }

    public static MypageFundingFragment newInstance() {
        MypageFundingFragment mypage_fundingFragment = new MypageFundingFragment();
        return mypage_fundingFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mypage_funding, container, false);
        tvNull = view.findViewById(R.id.mypage_funding_tv_null);
        rvItem = view.findViewById(R.id.mypage_funding_rv);
        llNum = view.findViewById(R.id.mypage_funding_ll_num);
        fundingItemlistArrayList = new ArrayList<>();

        tryGetTest();

        return view;

    }

    private void tryGetTest() {
        showProgressDialog();

        final FundingService fundingService = new FundingService(this);
        fundingService.getTest(SaveSharedPreference.getUserToken(getActivity()));
    }

    @Override
    public void validateSuccess(ArrayList<FundingItemlist> result) {
        hideProgressDialog();

        fundingItemlistArrayList = result;

        //리사이클러 뷰 간 간격 조정
        RecyclerDecoration recyclerDecoration = new RecyclerDecoration(20);

        //펀딩 내역이 있으면 리사이클러 뷰 보이도록 / 없으면 없습니다 표시
        if (fundingItemlistArrayList == null) {
            tvNull.setVisibility(View.VISIBLE);
            rvItem.setVisibility(View.GONE);
            llNum.setVisibility(View.GONE);
        } else {
            tvNull.setVisibility(View.GONE);
            rvItem.setVisibility(View.VISIBLE);
            llNum.setVisibility(View.VISIBLE);
            rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
            FundingItemRvAdapter fundingItemRvAdapter = new FundingItemRvAdapter(fundingItemlistArrayList, getActivity());
            rvItem.addItemDecoration(recyclerDecoration);
            rvItem.setAdapter(fundingItemRvAdapter);
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
