package com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.Adapters;

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
import com.softsquared.wadiz.src.Item.itemMain.ItemPurchase.ItemPurchaseSecond.models.RewardItemList;

import java.util.ArrayList;

public class RewardItemRvAdapter extends RecyclerView.Adapter<RewardItemRvAdapter.ViewHolder> {

    ArrayList<RewardItemList> mData = null;
    Context mContext;
    PurchaseFirstActivity mPurchaseFirstActivity;
    MainActivityView mMainActivityView;
    int mMoney = 0;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvInfo, tvRewardNum, tvMoney;

        ViewHolder(View view) {
            super(view);
            tvMoney = view.findViewById(R.id.reward_item_tv_reward_money);
            tvName = view.findViewById(R.id.reward_item_tv_reward_name);
            tvInfo = view.findViewById(R.id.reward_item_tv_reward_info);
            tvRewardNum = view.findViewById(R.id.reward_item_tv_reward_num);



        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public RewardItemRvAdapter(ArrayList<RewardItemList> list, MainActivityView mainActivityView) {
        mData = list;
        mMainActivityView = mainActivityView;
    }

    @NonNull
    @Override
    public RewardItemRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.reward_item, parent, false);
        RewardItemRvAdapter.ViewHolder vh = new RewardItemRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RewardItemRvAdapter.ViewHolder holder, int position) {

        holder.tvMoney.setText(mData.get(position).getMoney());
        holder.tvName.setText(mData.get(position).getName());
        holder.tvInfo.setText(mData.get(position).getRewardInfo());
        holder.tvRewardNum.setText(mData.get(position).getRewardNum());

    }


    @Override
    public int getItemCount() {
         if (mData != null) return  mData.size();
        else return 0;
    }

}