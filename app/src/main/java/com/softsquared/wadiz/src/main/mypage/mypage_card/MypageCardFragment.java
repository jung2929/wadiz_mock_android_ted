package com.softsquared.wadiz.src.main.mypage.mypage_card;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.main.mypage.mypage_card.interfaces.MypageCardActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.RegisterCardActivity;
import com.softsquared.wadiz.src.main.mypage.mypage_card.models.CardList;

import java.util.ArrayList;


public class MypageCardFragment extends BaseFragment implements MypageCardActivityView {
    View view;
    LinearLayout llRegister, llCardnum;
    Button btnRegister, btnCarddelete;
    Intent getintent;
    TextView tvCardnum, mtvCardDay, mTvCardName;
    RelativeLayout rlCard;

    public MypageCardFragment() {

    }

    public static MypageCardFragment newInstance() {
        MypageCardFragment mypage_cardFragment = new MypageCardFragment();
        return mypage_cardFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mypage_card, container, false);
        llRegister = view.findViewById(R.id.mypage_card_ll_register);
        btnRegister = view.findViewById(R.id.mypage_card_btn_register);
        llCardnum = view.findViewById(R.id.mypage_card_ll_cardnum);
        tvCardnum = view.findViewById(R.id.mypage_card_tv_cardnum);
        btnCarddelete = view.findViewById(R.id.mypage_card_btn_delete);
        rlCard = view.findViewById(R.id.mypage_card_rl_card);
        mTvCardName = view.findViewById(R.id.mypage_card_tv_cardname);
        mtvCardDay = view.findViewById(R.id.mypage_card_tv_cardday);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RegisterCardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                getActivity().startActivityForResult(intent, 3000); //카드등록 리퀘스트코드 3000
            }
        });

        btnCarddelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }

    public void setCardvisible(int llhow, int rlhow, String text) {
        llRegister.setVisibility(llhow);
        rlCard.setVisibility(rlhow);
        tvCardnum.setText(text);
    }


    @Override
    public void onResume() {
        MainActivity mainActivity = new MainActivity();
        String cardnum = mainActivity.cardnum;
        System.out.println("프래그먼트 값 : " + cardnum);

        tryGetTest();


        super.onResume();
    }

    private void tryGetTest() {
        showProgressDialog();

        final MypageCardService mypageCardService = new MypageCardService(this);
        mypageCardService.getTest(SaveSharedPreference.getUserToken(getActivity()));
    }

    @Override
    public void validateSuccess(ArrayList<CardList> result, int code) {
        hideProgressDialog();


        if (code == 200) {
            llRegister.setVisibility(View.GONE);
            rlCard.setVisibility(View.VISIBLE);
            tvCardnum.setText(result.get(0).getCard());
            mTvCardName.setText(result.get(0).getCardname());
            mtvCardDay.setText(result.get(0).getRegistration());
            System.out.println(result.get(0).getCardname().substring(0, 2));
            if (result.get(0).getCardname() == "BC카드"){
                System.out.println(result.get(0).getCardname().substring(0, 2));
            rlCard.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.card_bc));}
            else if (result.get(0).getCardname() == "신한카드") {
                rlCard.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.card_shinhan));
            }
        } else {
            llRegister.setVisibility(View.VISIBLE);
            rlCard.setVisibility(View.GONE);
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