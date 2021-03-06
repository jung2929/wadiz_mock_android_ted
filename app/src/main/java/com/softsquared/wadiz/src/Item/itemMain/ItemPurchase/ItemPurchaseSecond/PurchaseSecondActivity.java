package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.Item.itemMain.ItemMainActivity;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.models.RewardList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.PurchaseLastActivity;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.Adapters.RewardItemRvAdapter;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.interfaces.PurchaseSecondActivityView;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.CardList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.GetDeliveryList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.PostReward;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.PostRewardList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.PutDeliveryList;
import com.softsquared.wadiz.src.common.SaveSharedPreference;

import java.util.ArrayList;


public class PurchaseSecondActivity extends BaseActivity implements PurchaseSecondActivityView {

    Button mBtnOk;
    Button mBtnAddress;
    Button mBtnLastestDelivery;
    ImageButton mIbBack;
    RecyclerView mRv;
    TextView mTvMoney, mTvDeliveryMoney, mTvRewardName, mTvRewardInfo, mResultMoney, mTvSponsor, mTvSponsor2, mTvMoney2, mTvDeliveryMoney2, mTvCardName, mTvCardNum, mTvCardDay;
    LinearLayout mLlLastestAdderss, mLlNewAddress;
    CheckBox mCbLastestAddress, mCbNewAddress, mCbAgreeAll, mCbAgree1, mCbAgree2;
    TextView mTvTitle;
    EditText mEtDeliveryName, mEtDeliveryPhoneNumber, mEtDeliveryAddress;
    boolean mLastestFlag;
    PutDeliveryList mPutDeliveryList = new PutDeliveryList(null, null, null);
    ArrayList<RewardList> mRewardLists = new ArrayList<>();
    ArrayList<PostRewardList> mPostRewardLists = new ArrayList<>();
    PostReward mPostRewards = new PostReward(mPostRewardLists, 0,0);
    int mProjectIdx;
    String mProjectName;
    int mVeilName, mVeilPrice;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), ItemMainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_second);
        mBtnOk = findViewById(R.id.purchase_second_btn_ok);
        mBtnAddress = findViewById(R.id.purchase_second_btn_address);
        mBtnLastestDelivery = findViewById(R.id.purchase_second_btn_lastest_delivery);
        mLlLastestAdderss = findViewById(R.id.purchase_second_ll_lastest_address);
        mLlNewAddress = findViewById(R.id.purchase_second_ll_new_address);
        mCbLastestAddress = findViewById(R.id.purchase_second_cb_lastest_address);
        mCbNewAddress = findViewById(R.id.purchase_second_cb_new_address);
        mEtDeliveryName = findViewById(R.id.purchase_second_et_delivery_name);
        mEtDeliveryPhoneNumber = findViewById(R.id.purchase_second_et_delivery_phonenumber);
        mEtDeliveryAddress = findViewById(R.id.purchase_second_et_delivery_address);
        mCbAgree1 = findViewById(R.id.purchase_second_cb_agree1);
        mCbAgree2 = findViewById(R.id.purchase_second_cb_agree2);
        mCbAgreeAll = findViewById(R.id.purchase_second_cb_all_agree);
        mIbBack = findViewById(R.id.purchase_second_ib_back);
        mTvTitle = findViewById(R.id.purchase_second_tv_name);
        mTvMoney2 = findViewById(R.id.purchase_second_tv_reward_money2);
        mResultMoney = findViewById(R.id.purchase_second_tv_reward_result_money);
        mTvDeliveryMoney = findViewById(R.id.purchase_second_tv_reward_delivery_money2);
        mTvDeliveryMoney2 = findViewById(R.id.purchase_second_tv_reward_delivery_money);
        mTvSponsor = findViewById(R.id.purchase_second_tv_reward_sponsor);
        mTvSponsor2 = findViewById(R.id.purchase_second_tv_reward_sponsor2);
        mTvCardName = findViewById(R.id.purchase_second_tv_card_name);
        mTvCardNum = findViewById(R.id.purchase_second_tv_card_num);
        mTvCardDay = findViewById(R.id.purchase_second_tv_card_day);
        mRv = findViewById(R.id.purchase_second_rv);


        Intent getintent = getIntent();
        mProjectName = getintent.getStringExtra("name");
        mTvTitle.setText(getintent.getStringExtra("name"));
        mTvMoney2.setText(String.format("%,d", getintent.getIntExtra("money", 0)));
        mTvDeliveryMoney2.setText(String.format("%,d", getintent.getIntExtra("delivery", 0)));
        mTvDeliveryMoney.setText(String.format("%,d", getintent.getIntExtra("delivery", 0)));
        mTvSponsor.setText(getintent.getStringExtra("sponsor"));
        mTvSponsor2.setText(getintent.getStringExtra("sponsor"));
        mResultMoney.setText(String.format("%,d", (getintent.getIntExtra("money", 0) + getintent.getIntExtra("delivery", 0))));
        mRewardLists = (ArrayList<RewardList>) getIntent().getSerializableExtra("rewardList");
        mProjectIdx = getintent.getIntExtra("projectidx", 999);
        if (getintent.getBooleanExtra("veilName", false)) {
            mVeilName = 1;
        } else {
            mVeilName = 0;
        }
        if (getintent.getBooleanExtra("veilPrice", false)) {
            mVeilPrice = 1;
        } else {
            mVeilPrice = 0;
        }
        mPostRewards.setVeilName(mVeilName);
        mPostRewards.setVeilPrice(mVeilPrice);
        System.out.println(mVeilName);
        System.out.println(mVeilPrice);

        for (int i = 0; i < mRewardLists.size(); i++) {
            mPostRewardLists.add(new PostRewardList(mRewardLists.get(i).getRewardIdx() + 1, mRewardLists.get(i).getRewardNum()));
            System.out.println("리워드 리스트 : " + mPostRewardLists.get(i).getRewardIdx() + mPostRewardLists.get(i).getQuantity());
        }


        tryGetCard();


        mRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RewardItemRvAdapter rewardItemRvAdapter = new RewardItemRvAdapter(mRewardLists, this);
        mRv.setAdapter(rewardItemRvAdapter);

        mLastestFlag = false; // 최근배송지 목록 열었는지 확인 플래그

        mIbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ItemMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPutDeliveryList.setUsername(mEtDeliveryName.getText().toString());
                mPutDeliveryList.setPhone(mEtDeliveryPhoneNumber.getText().toString());
                mPutDeliveryList.setAddress(mEtDeliveryAddress.getText().toString());
                tryPostReward();
                if (mEtDeliveryName.getText().toString() != null) {
                    tryPutDelivery();
                }

            }
        });


        mBtnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mBtnLastestDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLastestFlag == false) {
                    mLastestFlag = true;
                    mLlLastestAdderss.setVisibility(View.VISIBLE);
                    tryGetDelivery();
                    Drawable less = getApplicationContext().getResources().getDrawable(R.drawable.policy_less);
                    mBtnLastestDelivery.setCompoundDrawablesWithIntrinsicBounds(less, null, null, null);

                } else {
                    mLastestFlag = false;
                    mLlLastestAdderss.setVisibility(View.GONE);
                    Drawable more = getApplicationContext().getResources().getDrawable(R.drawable.policy_more);
                    mBtnLastestDelivery.setCompoundDrawablesWithIntrinsicBounds(more, null, null, null);

                }
            }
        });

        mCbLastestAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCbLastestAddress.isChecked()) {
                    mLlNewAddress.setVisibility(View.GONE);
                    mCbNewAddress.setChecked(false);
                }
            }
        });
        mCbNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCbNewAddress.isChecked()) {
                    mLlNewAddress.setVisibility(View.VISIBLE);
                    mCbLastestAddress.setChecked(false);
                }
            }
        });

        mCbAgreeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCbAgreeAll.isChecked()) {
                    mCbAgree1.setChecked(true);
                    mCbAgree2.setChecked(true);
                    mBtnOk.setEnabled(true);
                } else {
                    mCbAgree1.setChecked(false);
                    mCbAgree2.setChecked(false);
                    mBtnOk.setEnabled(false);
                }
            }
        });

        mCbAgree1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCbAgree1.isChecked() & mCbAgree2.isChecked()) {
                    mCbAgreeAll.setChecked(true);
                    mBtnOk.setEnabled(true);
                } else {
                    mCbAgreeAll.setChecked(false);
                    mBtnOk.setEnabled(false);
                }
            }
        });
        mCbAgree2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCbAgree1.isChecked() & mCbAgree2.isChecked()) {
                    mCbAgreeAll.setChecked(true);
                    mBtnOk.setEnabled(true);
                } else {
                    mCbAgreeAll.setChecked(false);
                    mBtnOk.setEnabled(false);
                }
            }
        });


    }


    private void tryGetDelivery() {
        showProgressDialog();

        final PurchaseSecondService purchaseSecondService = new PurchaseSecondService(this);
        purchaseSecondService.getDelivery(SaveSharedPreference.getUserToken(getApplicationContext()));
    }

    private void tryPutDelivery() {
        showProgressDialog();

        final PurchaseSecondService purchaseSecondService = new PurchaseSecondService(this);
        purchaseSecondService.putDelivery(SaveSharedPreference.getUserToken(getApplicationContext()), mPutDeliveryList);
    }


    private void tryGetCard() {
        showProgressDialog();

        final PurchaseSecondService purchaseSecondService = new PurchaseSecondService(this);
        purchaseSecondService.getCard(SaveSharedPreference.getUserToken(getApplicationContext()));
    }


    private void tryPostReward() {
        showProgressDialog();

        final PurchaseSecondService purchaseSecondService = new PurchaseSecondService(this);
        purchaseSecondService.postReward(SaveSharedPreference.getUserToken(getApplicationContext()), mProjectIdx, mPostRewards);
    }


    @Override
    public void validateGetSuccess(ArrayList<GetDeliveryList> result, int code) {
        hideProgressDialog();

        if (code == 200) {
            String string = "최근배송지\n" + result.get(0).getName() + " " + result.get(0).getPhone() + "\n\n" + result.get(0).getAddress();
            mCbLastestAddress.setText(string);
        } else {
            System.out.println("최근 배송지 : " + code);
            mCbLastestAddress.setText("최근 배송지가 없습니다");
        }

    }

    @Override
    public void validateGetFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void validatePutSuccess(int code) {
        hideProgressDialog();
        if (code == 200) {

            System.out.println("배송 목록 저장 성공");

        } else {
            System.out.println("배송 목록 저장 실패 : " + code);

        }

    }

    @Override
    public void validatePutFailure(String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void validateCardSuccess(ArrayList<CardList> result, int code) {
        hideProgressDialog();
        mTvCardNum.setText(result.get(0).getCard());
        mTvCardDay.setText(result.get(0).getRegistration());
        mTvCardName.setText(result.get(0).getCardname());

    }

    @Override
    public void validateCardFailure(String message) {
        hideProgressDialog();

    }

    @Override
    public void validatePostRewardSuccess(String message, int code) {
        hideProgressDialog();
        if (code == 200) {

            System.out.println("리워드 구매 성공");
            Intent intent = new Intent(getApplicationContext(), PurchaseLastActivity.class);
            intent.putExtra("projectidx", mProjectIdx);
            intent.putExtra("projectname", mProjectName);
            startActivity(intent);


        } else {
            System.out.println("리워드 구매 실패 : " + message);

        }
    }

    @Override
    public void validatePostRewardFailure(String message) {
        hideProgressDialog();

    }
}
