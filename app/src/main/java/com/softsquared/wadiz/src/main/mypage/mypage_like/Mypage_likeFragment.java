package com.softsquared.wadiz.src.main.mypage.mypage_like;

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
import com.softsquared.wadiz.src.main.mypage.mypage_like.interfaces.MainActivityView;

import java.util.ArrayList;


public class Mypage_likeFragment extends BaseFragment implements MainActivityView {
    View view;
    TextView tvNull, tvNum;
    LinearLayout llNum;
    RecyclerView rvItem;
    ArrayList<LikeItemlist> likeItemlistArrayList;
    public Mypage_likeFragment() {

    }

    public static Mypage_likeFragment newInstance() {
        Mypage_likeFragment mypage_likeFragment = new Mypage_likeFragment();
        return mypage_likeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mypage_like, container, false);
        tvNull = view.findViewById(R.id.mypage_like_tv_null);
        rvItem = view.findViewById(R.id.mypage_like_rv);
        llNum = view.findViewById(R.id.mypage_like_ll_num);
        tvNum = view.findViewById(R.id.mypage_like_tv_num);

        likeItemlistArrayList = new ArrayList<>();

        RecyclerDecoration recyclerDecoration = new RecyclerDecoration(20);

        //좋아요 내역이 있으면 리사이클러 뷰 보이도록 / 없으면 없습니다 표시
        for (int i = 0; i < 6; i++) {
            likeItemlistArrayList.add(new LikeItemlist(R.drawable.banner0+i, "[맛있는건 퍼-먹자] 뜯는순간 완통 보장! 지중해 만능요리, 그릭후무스", "푸드" ,"얄라 (yalla)", "50", "200,000","20"));
        }

        if (likeItemlistArrayList.isEmpty()) {
            tvNull.setVisibility(View.VISIBLE);
            rvItem.setVisibility(View.GONE);
            llNum.setVisibility(View.GONE);
        } else {
            tvNull.setVisibility(View.GONE);
            rvItem.setVisibility(View.VISIBLE);
            llNum.setVisibility(View.VISIBLE);
            tvNum.setText(Integer.toString(likeItemlistArrayList.size()));
            rvItem.setLayoutManager(new LinearLayoutManager(getActivity()));
            LikeItemRvAdapter likeItemRvAdapter = new LikeItemRvAdapter(likeItemlistArrayList);
            rvItem.addItemDecoration(recyclerDecoration);
            rvItem.setAdapter(likeItemRvAdapter);
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
