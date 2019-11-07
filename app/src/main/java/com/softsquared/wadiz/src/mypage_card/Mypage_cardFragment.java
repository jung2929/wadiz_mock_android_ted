package com.softsquared.wadiz.src.mypage_card;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.mypage_card.interfaces.MainActivityView;
import com.softsquared.wadiz.src.register_card.Register_cardActivity;


public class Mypage_cardFragment extends BaseFragment implements MainActivityView {
    View view;
    LinearLayout llRegister, llCardnum;
    Button btnRegister,btnCarddelete;
    Intent getintent;
    TextView tvCardnum;

    public Mypage_cardFragment() {

    }

    public static Mypage_cardFragment newInstance() {
        Mypage_cardFragment mypage_cardFragment = new Mypage_cardFragment();
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
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Register_cardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        btnCarddelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }


    @Override
    public void onResume() {
        MainActivity mainActivity = new MainActivity();
        String cardnum = mainActivity.cardnum;
        System.out.println("프래그먼트 값 : " + cardnum);

        if (cardnum != null) {
            llRegister.setVisibility(View.GONE);
            llCardnum.setVisibility(View.VISIBLE);
            tvCardnum.setText(cardnum);

        }

        super.onResume();
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