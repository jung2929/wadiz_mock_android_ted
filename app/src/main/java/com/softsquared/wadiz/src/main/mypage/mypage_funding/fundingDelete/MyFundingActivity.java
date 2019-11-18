package com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.main.MainActivity;
import com.softsquared.wadiz.src.main.mypage.mypage_funding.fundingDelete.MyFundingDelete.FundingDeleteActivity;


public class MyFundingActivity extends BaseActivity  {

    TextView mTvName, mTvName2, mTvCategory, mTvCompany;
    ImageButton mIbBack, mIbHome;
    Button mBtnCancel;
    int mProjectIdx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfunding);

        Intent getintent = getIntent();
        mTvName = findViewById(R.id.myfunding_name);
        mTvName2 = findViewById(R.id.myfunding_name2);
        mTvCategory = findViewById(R.id.myfunding_category);
        mTvCompany = findViewById(R.id.myfunding_tv_company);
        mIbBack = findViewById(R.id.myfunding_ib_back);
        mIbHome = findViewById(R.id.myfunding_ib_home);
        mBtnCancel =findViewById(R.id.myfunding_btn_cancel);


        mTvName.setText(getintent.getStringExtra("name"));
        mTvName2.setText(getintent.getStringExtra("name"));
        mTvCategory.setText(getintent.getStringExtra("category"));
        mTvCompany.setText(getintent.getStringExtra("company"));
        mProjectIdx = getintent.getIntExtra("projectIdx", 999);

        mIbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mIbHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) MainActivity.mcontext).onFragmentChange(0);
                finish();
            }
        });

        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FundingDeleteActivity.class);
                intent.putExtra("projectIdx", mProjectIdx);
                startActivity(intent);
            }
        });

    }


}
