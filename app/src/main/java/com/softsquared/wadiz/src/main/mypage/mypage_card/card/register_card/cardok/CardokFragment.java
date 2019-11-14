package com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.cardok;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.RegisterCardActivity;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.cardok.interfaces.MainActivityView;


public class CardokFragment extends BaseFragment implements MainActivityView {
    View view;
    Button btnOk;
    public CardokFragment() {

    }

    public static CardokFragment newInstance() {
        CardokFragment cardokFragment = new CardokFragment();
        return cardokFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register_card_ok, container, false);
        btnOk = view.findViewById(R.id.register_card_ok_btn_ok);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((RegisterCardActivity)getActivity()).tryGetTest();
            }
        });

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