package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.PurchaseFirstActivity;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.interfaces.MainActivityView;
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseFirst.models.PurchaseItemlist;

import java.util.ArrayList;

public class PurchaseItemRvAdapter extends RecyclerView.Adapter<PurchaseItemRvAdapter.ViewHolder> {

    ArrayList<PurchaseItemlist> mData = null;
    Context mContext;
    PurchaseFirstActivity mPurchaseFirstActivity;
    MainActivityView mMainActivityView;
    int mMoney = 0;

    public class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox cb;
        TextView tvMoney, tvRewardName, tvRewardInfo, tvDeliveryMoney, tvDeliveryDay;
        LinearLayout llChecked, llMain;
        ImageButton ibMinus, ibPlus;
        EditText etNumber;

        ViewHolder(View view) {
            super(view);
            llMain = view.findViewById(R.id.reward_select_ll_main);
            cb = view.findViewById(R.id.reward_select_cb);
            tvMoney = view.findViewById(R.id.reward_select_tv_money);
            tvRewardName = view.findViewById(R.id.reward_select_tv_reawrd_name);
            tvRewardInfo = view.findViewById(R.id.reward_select_tv_info);
            tvDeliveryMoney = view.findViewById(R.id.reward_select_tv_delivery_money);
            tvDeliveryDay = view.findViewById(R.id.reward_select_tv_delivery_day);
            llChecked = view.findViewById(R.id.reward_select_ll_checked);
            ibMinus = view.findViewById(R.id.reward_select_ib_minus);
            ibPlus = view.findViewById(R.id.reward_select_ib_plus);
            etNumber = view.findViewById(R.id.reward_select_et_number);

            ibPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            ibMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


            // 뷰 객체에 대한 참조. (hold strong reference)
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public PurchaseItemRvAdapter(ArrayList<PurchaseItemlist> list, MainActivityView mainActivityView) {
        mData = list;
        mMainActivityView = mainActivityView;
    }

    @NonNull
    @Override
    public PurchaseItemRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.reward_select, parent, false);
        PurchaseItemRvAdapter.ViewHolder vh = new PurchaseItemRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PurchaseItemRvAdapter.ViewHolder holder, int position) {

        holder.tvMoney.setText(mData.get(position).Money);
        holder.tvRewardName.setText(mData.get(position).RewardName);
        holder.tvRewardInfo.setText(mData.get(position).Info);
        holder.tvDeliveryMoney.setText(mData.get(position).DeliveryMoney);

        int idx = (mData.get(position).getMoney()).indexOf("원");
        int money = Integer.parseInt(mData.get(position).getMoney().substring(0,idx).replace(",",""));


        holder.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("현재 클릭한 돈 : " + mMoney);
                if (holder.cb.isChecked()) {
                    holder.cb.setChecked(false);
                    holder.llMain.setBackgroundResource(R.drawable.customborder_rounded_nonfocus);
                    holder.llChecked.setVisibility(View.GONE);
                    int quantity = Integer.parseInt(holder.etNumber.getText().toString());
                    mMoney -= (money*quantity);
                    holder.etNumber.setText("1");
                    mMainActivityView.addPrice(mMoney);

                } else {
                    holder.cb.setChecked(true);
                    holder.llMain.setBackgroundResource(R.drawable.customborder_rounded_reward_click);
                    holder.llChecked.setVisibility(View.VISIBLE);
                    mMoney += money;
                    mMainActivityView.addPrice(mMoney);
                }
            }

        });

        holder.ibPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(holder.etNumber.getText().toString());
                num ++;
                holder.etNumber.setText(Integer.toString(num));
                mMoney += money;
                mMainActivityView.addPrice(mMoney);
            }
        });

        holder.ibMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(holder.etNumber.getText().toString());
                num --;
                if (num == 1) {
                    holder.ibMinus.setEnabled(false);
                }
                holder.etNumber.setText(Integer.toString(num));
                mMoney -= money;
                mMainActivityView.addPrice(mMoney);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
}