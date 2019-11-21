package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.Adapters.PurchaseItemRvAdapter;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.interfaces.PurchaseFirstActivityView;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.models.PurchaseItemlist;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.models.RewardList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.PurchaseSecondActivity;
import com.softsquared.wadiz.src.common.RecyclerDecoration;
import com.softsquared.wadiz.src.common.SaveSharedPreference;

import java.util.ArrayList;


public class PurchaseFirstActivity extends BaseActivity implements PurchaseFirstActivityView {

    TextView mTvName, mTvLastName;
    public TextView mTvLastMoney;
    Button mBtnNext;
    RecyclerView mRv;
    EditText mEtSponsor;
    CheckBox mCbNameOpen, mCbMoneyOpen;
    ArrayList<PurchaseItemlist> mPurchaseItemlistArrayList;
    int mProjectIdx;
    int mMoney, mDelivery, mRewardName, mRewardInfo;
    ImageButton mIbBack;
    ArrayList<RewardList> mRewardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_first);
        mIbBack = findViewById(R.id.purchase_first_ib_back);
        mTvName = findViewById(R.id.purchase_first_tv_name);
        mTvLastMoney = findViewById(R.id.purchase_first_tv_lastmoney);
        mTvLastName = findViewById(R.id.purchase_first_tv_lastname);
        mBtnNext = findViewById(R.id.purchase_first_btn_next);
        mEtSponsor = findViewById(R.id.purchase_first_et_sponsor);
        mCbNameOpen = findViewById(R.id.purchase_first_cb_name_open);
        mCbMoneyOpen = findViewById(R.id.purchase_first_cb_money_open);
        mRv = findViewById(R.id.purchase_first_rv);
        mRewardList = new ArrayList<>();

        mPurchaseItemlistArrayList = new ArrayList<>();

        Intent getintent = getIntent();
        mProjectIdx = getintent.getIntExtra("projectidx", 999);
        mTvName.setText(getintent.getStringExtra("name"));
        mTvLastName.setText(getintent.getStringExtra("name") + "에");

        tryGetTest();

        mIbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PurchaseSecondActivity.class);
                intent.putExtra("name", getintent.getStringExtra("name"));
                intent.putExtra("money", mMoney);
                intent.putExtra("delivery", mDelivery);
                intent.putExtra("sponsor", mEtSponsor.getText().toString());
                intent.putExtra("veilName", mCbNameOpen.isChecked());
                intent.putExtra("veilPrice", mCbMoneyOpen.isChecked());
                intent.putExtra("rewardList", mRewardList);
                intent.putExtra("projectidx", mProjectIdx);

                startActivity(intent);
            }
        });


    }


    private void tryGetTest() {
        showProgressDialog();

        final PruchaseFirstService pruchaseFirstService = new PruchaseFirstService(this);
        pruchaseFirstService.getReward(mProjectIdx, SaveSharedPreference.getUserToken(getApplicationContext()));
    }

    @Override
    public void validateSuccess(ArrayList<PurchaseItemlist> result) {
        hideProgressDialog();

        mPurchaseItemlistArrayList = result;

        //리사이클러 뷰 간 간격 조정
        RecyclerDecoration recyclerDecoration = new RecyclerDecoration(20);

        mRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        PurchaseItemRvAdapter purchaseItemRvAdapter = new PurchaseItemRvAdapter(mPurchaseItemlistArrayList, this);
        mRv.addItemDecoration(recyclerDecoration);
        mRv.setAdapter(purchaseItemRvAdapter);


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

    @Override
    public void addTotalMoney(int totalMoney) {
        mMoney = totalMoney;
        mTvLastMoney.setText(String.format("%,d", mMoney));
    }

    @Override
    public void addDeliveryMoney(int deliveryMoney) {
        if (deliveryMoney < 0) {
            mDelivery = 0;
        } else {
            mDelivery = deliveryMoney;
        }
    }

    @Override
    public void addItemList(ArrayList<RewardList> rewardList, int positionAdpater) {
        mRewardList = rewardList;

    }
}
