package com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.card2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.Register_cardActivity;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.card2.interfaces.MainActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.card3.Card3Fragment;


public class Card2Fragment extends BaseFragment implements MainActivityView {
    View view;
    EditText etPassword;
    Button btnNext;
    public Card2Fragment() {

    }

    public static Card2Fragment newInstance() {
        Card2Fragment card2Fragment = new Card2Fragment();
        return card2Fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register_card_2, container, false);
        btnNext = view.findViewById(R.id.register_card2_btn_next);
        etPassword = view.findViewById(R.id.register_card2_et_password);

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etPassword.getText().toString().replace(" ", "").equals("") || etPassword.toString() == null || etPassword.getText().toString().length() < 6 ) {
                    btnNext.setEnabled(false);
                    System.out.println("버튼비활성화!");
                } else  {
                    btnNext.setEnabled(true);
                    btnNext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
                    btnNext.setTypeface(null, Typeface.BOLD);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Register_cardActivity)getActivity()).replaceFragment(Card3Fragment.newInstance());
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