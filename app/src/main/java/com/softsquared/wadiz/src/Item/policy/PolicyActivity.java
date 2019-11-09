package com.softsquared.wadiz.src.Item.policy;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.Item.ItemPurchaseFirst.PurchaseFirstActivity;
import com.softsquared.wadiz.src.Item.item_main_story.Item_main_storyFragment;
import com.softsquared.wadiz.src.Item.item_main_supporter.Item_main_supporterFragment;
import com.softsquared.wadiz.src.Item.policy.interfaces.MainActivityView;
import com.softsquared.wadiz.src.main.MainActivity;


public class PolicyActivity extends BaseActivity implements MainActivityView {

    Button mBtnBack, mBtnNext;
    CheckBox mCbFirst, mCbSecond, mCbThird;
    TextView mTvCompany, mTvCompany2, mTvPaymentDay, mTvRewardMore, mTvDeliveryMore;
    ImageButton mIbRewardMore, mIbRewardLess, mIbDeliveryMore, mIbDeliveryLess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        mBtnBack = findViewById(R.id.policy_btn_back);
        mBtnNext = findViewById(R.id.policy_btn_next);
        mCbFirst = findViewById(R.id.policy_cb_1);
        mCbSecond = findViewById(R.id.policy_cb_2);
        mCbThird = findViewById(R.id.policy_cb_3);
        mTvCompany = findViewById(R.id.policy_company);
        mTvCompany2 = findViewById(R.id.policy_company2);
        mIbRewardMore = findViewById(R.id.policy_ib_reward_more);
        mIbRewardLess = findViewById(R.id.policy_ib_reward_less);
        mIbDeliveryMore = findViewById(R.id.policy_ib_delivery_more);
        mIbDeliveryLess = findViewById(R.id.policy_ib_delivery_less);
        mTvPaymentDay = findViewById(R.id.policy_tv_paymentday);
        mTvRewardMore = findViewById(R.id.policy_tv_reward_more);
        mTvDeliveryMore = findViewById(R.id.policy_tv_delivery_more);

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mCbFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCbFirst.isChecked()) {
                    mCbFirst.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
                } else {
                    mCbFirst.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.lightgray));
                }
                if (mCbFirst.isChecked() && mCbSecond.isChecked() && mCbThird.isChecked()) {
                    mBtnNext.setEnabled(true);
                    mBtnNext.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.wadiz));
                } else {
                    mBtnNext.setEnabled(false);
                    mBtnNext.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightgray));
                }
            }
        });
        mCbSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCbSecond.isChecked()) {
                    mCbSecond.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
                } else {
                    mCbSecond.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.lightgray));
                }if (mCbFirst.isChecked() && mCbSecond.isChecked() && mCbThird.isChecked()) {
                    mBtnNext.setEnabled(true);
                    mBtnNext.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.wadiz));
                } else {
                    mBtnNext.setEnabled(false);
                    mBtnNext.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightgray));
                }
            }
        });
        mCbThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCbThird.isChecked()) {
                    mCbThird.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
                } else {
                    mCbThird.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.lightgray));
                } if (mCbFirst.isChecked() && mCbSecond.isChecked() && mCbThird.isChecked()) {
                    mBtnNext.setEnabled(true);
                    mBtnNext.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.wadiz));
                } else {
                    mBtnNext.setEnabled(false);
                    mBtnNext.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.lightgray));
                }
            }
        });



        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PurchaseFirstActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mIbRewardMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvRewardMore.setVisibility(View.VISIBLE);
                mIbRewardMore.setVisibility(View.GONE);
                mIbRewardLess.setVisibility(View.VISIBLE);
            }
        });
        mIbRewardLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvRewardMore.setVisibility(View.GONE);
                mIbRewardMore.setVisibility(View.VISIBLE);
                mIbRewardLess.setVisibility(View.GONE);
            }
        });
        mIbDeliveryMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvDeliveryMore.setVisibility(View.VISIBLE);
                mIbDeliveryMore.setVisibility(View.GONE);
                mIbDeliveryLess.setVisibility(View.VISIBLE);
            }
        });
        mIbDeliveryLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvDeliveryMore.setVisibility(View.GONE);
                mIbDeliveryMore.setVisibility(View.VISIBLE);
                mIbDeliveryLess.setVisibility(View.GONE);
            }
        });
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
