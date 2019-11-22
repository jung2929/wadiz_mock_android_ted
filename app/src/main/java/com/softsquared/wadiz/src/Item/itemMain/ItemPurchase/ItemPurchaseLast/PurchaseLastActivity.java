package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.interfaces.PurchaseLastActivityView;
import com.softsquared.wadiz.src.Item.itemMain.ItemMainActivity;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.NotiList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.ProfileList;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseLast.models.SupporterResult;
import com.softsquared.wadiz.src.common.SaveSharedPreference;
import com.softsquared.wadiz.src.main.MainActivity;


public class PurchaseLastActivity extends BaseActivity implements PurchaseLastActivityView {

    ImageButton mIbBack, mIbHome;
    Button mBtnMypageFunding;
    TextView mTvName, mTvNum, mTvTitle;
    int mProjectIdx;
    NotiList mNotiList = new NotiList(null, null);
    String mProjectName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_last);

        mTvName = findViewById(R.id.purchase_last_name);
        mIbBack = findViewById(R.id.purchase_last_ib_back);
        mIbHome = findViewById(R.id.purchase_last_ib_home);
        mTvTitle= findViewById(R.id.purchase_first_tv_name);
        mBtnMypageFunding = findViewById(R.id.purchase_last_btn_mypage_funding);
        mTvNum = findViewById(R.id.purchase_last_tv_number);

        Intent getintent = getIntent();
        mProjectIdx = getintent.getIntExtra("projectidx", 999);
        mProjectName = getintent.getStringExtra("projectname");
        mTvTitle.setText(mProjectName);
        mNotiList.setTitle("구매 성공");
        mNotiList.setContents( mProjectName + "구매 완료!");

        tryGetTest();

        mIbBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ItemMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        mIbHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        mBtnMypageFunding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ((MainActivity) MainActivity.mcontext).onFragmentChange(1);
                startActivity(intent);
            }
        });

    }


    private void tryGetTest() {
        showProgressDialog();

        final PurchaseLastService purchaseLastService = new PurchaseLastService(this);
        purchaseLastService.getProfile(SaveSharedPreference.getUserToken(getApplicationContext()));
        purchaseLastService.getSupporter(mProjectIdx, SaveSharedPreference.getUserToken(getApplicationContext()));
        purchaseLastService.postNoti(SaveSharedPreference.getUserToken(getApplicationContext()), mNotiList);
    }

    @Override
    public void validateProfileSuccess(ProfileList result) {
        hideProgressDialog();
        mTvName.setText(result.getName());
    }

    @Override
    public void validateFailure(@Nullable String message) {
        hideProgressDialog();
        showCustomToast(message == null || message.isEmpty() ? getString(R.string.network_error) : message);
    }

    @Override
    public void validateSupporterSuccess(SupporterResult result) {
        hideProgressDialog();
        mTvNum.setText(Integer.toString(result.getCnt()));
    }

    @Override
    public void validateNotiSuccess(String message) {
        hideProgressDialog();
        System.out.println(message);
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
