package com.softsquared.wadiz.src.Item.ItemPurchase.ItemPurchaseFirst.Adapters;

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
import com.softsquared.wadiz.src.Item.item_main_story.models.Itemmainlist;

import java.util.ArrayList;

public class PurchaseItemRvAdapter extends RecyclerView.Adapter<PurchaseItemRvAdapter.ViewHolder> {

    ArrayList<Itemmainlist> mData = null;
    Context mContext;

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

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cb.isChecked()){
                        cb.setChecked(false);
                        llMain.setBackgroundResource(R.drawable.customborder_rounded_nonfocus);
                        llChecked.setVisibility(View.GONE);

                    } else  {
                        cb.setChecked(true);
                        llMain.setBackgroundResource(R.drawable.customborder_rounded_reward_click);
                        llChecked.setVisibility(View.VISIBLE);
                    }
                }
            });


            // 뷰 객체에 대한 참조. (hold strong reference)
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public PurchaseItemRvAdapter(ArrayList<Itemmainlist> list) {
        mData = list;
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
        holder.tvRewardName.setText(mData.get(position).Name);
        holder.tvRewardInfo.setText(mData.get(position).Content);
        holder.tvDeliveryMoney.setText(mData.get(position).Delivery_money);
        holder.tvDeliveryDay.setText(mData.get(position).Delivery_day);


    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
}