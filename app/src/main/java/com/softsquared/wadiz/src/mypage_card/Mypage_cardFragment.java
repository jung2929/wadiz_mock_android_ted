package com.softsquared.wadiz.src.mypage_card;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.mypage_card.interfaces.MainActivityView;


public class Mypage_cardFragment extends BaseFragment implements MainActivityView {
    View view;
    LinearLayout llRegister;
    Button btnregister;
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
        btnregister = view.findViewById(R.id.mypage_card_btn_register);

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