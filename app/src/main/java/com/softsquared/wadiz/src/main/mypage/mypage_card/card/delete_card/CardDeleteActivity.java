package com.softsquared.wadiz.src.main.mypage.mypage_card.card.delete_card;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.mypage.mypage_card.card.delete_card.interfaces.CardDeleteActivityView;


public class CardDeleteActivity extends BaseActivity implements CardDeleteActivityView {

    Button btnOk, btnCancel;


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carddelete);
        btnCancel = findViewById(R.id.delete_btn_cancel);
        btnOk = findViewById(R.id.delete_btn_ok);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryGetTest();
            }
        });
    }

    private void tryGetTest() {
        showProgressDialog();

        final CardDeleteService cardDeleteService = new CardDeleteService(this);
        cardDeleteService.getTest(SaveSharedPreference.getUserToken(getApplicationContext()));
    }

    @Override
    public void validateSuccess(String text) {
        hideProgressDialog();
        finish();
        System.out.println(text);
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
