package com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseFirst;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.BaseActivity;
import com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseFirst.Adapters.PurchaseItemRvAdapter;
import com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseFirst.interfaces.MainActivityView;
import com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseFirst.models.PurchaseItemlist;
import com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseSecond.PurchaseSecondActivity;
import com.softsquared.wadiz.src.Item.item_main_story.models.Itemmainlist;
import com.softsquared.wadiz.src.common.RecyclerDecoration;
import com.softsquared.wadiz.src.main.reward.reward_home.Reward_homeFragment;

import java.util.ArrayList;


public class PurchaseFirstActivity extends BaseActivity implements MainActivityView {

    TextView mTvName, mTvLastName, mTvLastMoney;
    Button mBtnNext;
    RecyclerView mRv;
    EditText mEtSponsor;
    CheckBox mCbNameOpen, mCbMoneyOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_first);

        mTvName =findViewById(R.id.purchase_first_tv_name);
        mTvLastMoney =findViewById(R.id.purchase_first_tv_lastmoney);
        mTvLastName =findViewById(R.id.purchase_first_tv_lastname);
        mBtnNext= findViewById(R.id.purchase_first_btn_next);
        mEtSponsor = findViewById(R.id.purchase_first_et_sponsor);
        mCbNameOpen =findViewById(R.id.purchase_first_cb_name_open);
        mCbMoneyOpen = findViewById(R.id.purchase_first_cb_money_open);
        mRv = findViewById(R.id.purchase_first_rv);

        ArrayList<PurchaseItemlist> purchaseItemlistArrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            purchaseItemlistArrayList.add(new PurchaseItemlist("10,000", "이곳은 이름입니다@@@@@@@@@", "소프트스퀘어드", "0", "2019년 11월 31일"));
        }

        //리사이클러 뷰 간 간격 조정
        RecyclerDecoration recyclerDecoration = new RecyclerDecoration(20);

        mRv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        PurchaseItemRvAdapter purchaseItemRvAdapter = new PurchaseItemRvAdapter(purchaseItemlistArrayList);
        mRv.addItemDecoration(recyclerDecoration);
        mRv.setAdapter(purchaseItemRvAdapter);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PurchaseSecondActivity.class);
                startActivity(intent);
            }
        });
    }


    //리사이클러뷰 클릭 리스너 추가
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private Reward_homeFragment.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final Reward_homeFragment.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
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
