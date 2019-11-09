package com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.card1;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseFragment;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.Register_cardActivity;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.card1.interfaces.MainActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.register_card.card2.Card2Fragment;


public class Card1Fragment extends BaseFragment implements MainActivityView {
    View view;
    LinearLayout llRegister;
    Button btnNext;
    EditText etCardnum1,etCardnum2,etCardnum3,etCardnum4, etCardvalidity, etCardpassword, etBirth;
    public Card1Fragment() {

    }

    public static Card1Fragment newInstance() {
        Card1Fragment card1Fragment = new Card1Fragment();
        return card1Fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register_card_1, container, false);
        btnNext = view.findViewById(R.id.register_card1_btn_next);
        etCardnum1 = view.findViewById(R.id.register_card_et_cardnum1);
        etCardnum2 = view.findViewById(R.id.register_card_et_cardnum2);
        etCardnum3 = view.findViewById(R.id.register_card_et_cardnum3);
        etCardnum4 = view.findViewById(R.id.register_card_et_cardnum4);
        etCardvalidity = view.findViewById(R.id.register_card_et_validity);
        etCardpassword = view.findViewById(R.id.register_card_et_password);
        btnNext = view.findViewById(R.id.register_card1_btn_next);
        etBirth = view.findViewById(R.id.register_card_et_birth);

        etCardnum1.setNextFocusDownId(R.id.register_card_et_cardnum2);
        etCardnum2.setNextFocusDownId(R.id.register_card_et_cardnum3);
        etCardnum3.setNextFocusDownId(R.id.register_card_et_cardnum4);
        etCardnum4.setNextFocusDownId(R.id.register_card_et_validity);
        etCardvalidity.setNextFocusDownId(R.id.register_card_et_password);
        etCardpassword.setNextFocusDownId(R.id.register_card_et_birth);

        etBirth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (etCardnum1.getText().toString().replace(" ", "").equals("") || etCardnum1.toString() == null || etCardnum2.getText().toString().replace(" ", "").equals("") || etCardnum2.toString() == null || etCardnum3.getText().toString().replace(" ", "").equals("") || etCardnum3.toString() == null || etCardnum4.getText().toString().replace(" ", "").equals("") || etCardnum4.toString() == null || etCardvalidity.getText().toString().replace(" ", "").equals("") || etCardvalidity.toString() == null || etCardpassword.getText().toString().replace(" ", "").equals("") || etCardpassword.toString() == null || etBirth.getText().toString().replace(" ", "").equals("") || etBirth.toString() == null ) {
                    btnNext.setEnabled(false);
                    System.out.println("버튼비활성화!");
                } else if (etCardnum4.getText().toString().length() > 3){
                    btnNext.setEnabled(true);
                    btnNext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
                    btnNext.setTypeface(null, Typeface.BOLD);
                    System.out.println("버튼활성화!");
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Register_cardActivity)getActivity()).replaceFragment(Card2Fragment.newInstance());
                ((Register_cardActivity)getActivity()).putIntent("cardnum", etCardnum4.getText().toString());
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