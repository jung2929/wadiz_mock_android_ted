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
import com.softsquared.wadiz.src.main.mypage.RecyclerDecoration;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.interfaces.MainActivityView;

import java.util.ArrayList;


public class Mypage_fundingFragment extends BaseFragment implements MainActivityView {
    View view;
    TextView tvNull, tvNum;
    LinearLayout llNum;;
    RecyclerView rvItem;
    ArrayList<FundingItemlist> fundingItemlistArrayList;
    public Mypage_fundingFragment() {

    }

    public static Mypage_fundingFragment newInstance() {
        Mypage_fundingFragment mypage_fundingFragment = new Mypage_fundingFragment();
        return mypage_fundingFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mypage_funding, container, false);
        tvNull = view.findViewById(R.id.mypage_funding_tv_null);
        rvItem = view.findViewById(R.id.mypage_funding_rv);
        llNum = view.findViewById(R.id.mypage_funding_ll_num);
        tvNum = view.findViewById(R.id.mypage_funding_tv_num);

        fundingItemlistArrayList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            fundingItemlistArrayList.add(new FundingItemlist(R.drawable.banner0+i, "이제 '당'백질 바말고 진짜 단백질바 드세요! 고단백 고셤유질 [솔진담백]", "푸드" ,"얄라 (yalla)", "50", "200,000","20"));
        }
        //리사이클러 뷰 간 간격 조정
        RecyclerDecoration recyclerDecoration = new RecyclerDecoration(20);

        //펀딩 내역이 있으면 리사이클러 뷰 보이도록 / 없으면 없습니다 표시
        if (fundingItemlistArrayList.isEmpty()) {
            tvNull.setVisibility(View.VISIBLE);
            rvItem.setVisibility(View.GONE);
            llNum.setVisibility(View.GONE);
        } else {
            tvNull.setVisibility(View.GONE);
            rvItem.setVisibility(View.VISIBLE);
            llNum.setVisibility(View.VISIBLE);
            tvNum.setText(Integer.toString(fundingItemlistArrayList.size()));
            System.out.println(Integer.toString(fundingItemlistArrayList.size()));
            rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
            FundingItemRvAdapter fundingItemRvAdapter = new FundingItemRvAdapter(fundingItemlistArrayList);
            rvItem.addItemDecoration(recyclerDecoration);
            rvItem.setAdapter(fundingItemRvAdapter);
        }
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
