package com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.main.mypage.MypageFragment;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete.interfaces.FundingDeleteActivityView;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete.models.FundingItemlist;

import java.util.ArrayList;


public class FundingDeleteActivity extends BaseActivity implements FundingDeleteActivityView {
    View view;
    Button mBtnCancel, mBtnOk;
    int mProjectIdx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfunding_delete);
        mBtnCancel = findViewById(R.id.myfunding_delete_btn_cancel);
        mBtnOk = findViewById(R.id.myfunding_delete_btn_ok);

        Intent getintent = getIntent();

        mProjectIdx = getintent.getIntExtra("projectIdx", 999);

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tryGetTest();
            }
        });

    }

    private void tryGetTest() {
        showProgressDialog();

        final FundingDeleteService fundingDeleteService = new FundingDeleteService(this);
        fundingDeleteService.deletePro(mProjectIdx, SaveSharedPreference.getUserToken(getApplicationContext()));
    }

    @Override
    public void validateSuccess(int code, String text) {
        hideProgressDialog();

        if (code == 200) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            ((MainActivity)MainActivity.mcontext).onFragmentChange(0);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);

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
