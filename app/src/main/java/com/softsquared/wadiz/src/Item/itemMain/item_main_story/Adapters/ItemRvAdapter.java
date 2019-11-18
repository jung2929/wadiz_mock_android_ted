package com.softsquared.wadiz.src.Item.itemMain.item_main_story.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softsquared.wadiz.R;
import com.softsquared.wadiz.src.Item.itemMain.item_main_story.models.ItemRewardlist;

import java.util.ArrayList;

public class ItemRvAdapter extends RecyclerView.Adapter<ItemRvAdapter.ViewHolder> {

    ArrayList<ItemRewardlist> mData = null;
    Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvMoney;
        TextView tvName;
        TextView tvContent;
        TextView tvDelivery_money;
        TextView tvDelivery_day;
        TextView tvLimited;
        TextView tvLimited_now;
        TextView tvTotal;

        ViewHolder(View itemView) {
            super(itemView);

            tvMoney = itemView.findViewById(R.id.item_main_list_tv_money);
            tvName = itemView.findViewById(R.id.item_main_list_tv_name);
            tvContent = itemView.findViewById(R.id.item_main_list_tv_content);
            tvDelivery_money = itemView.findViewById(R.id.item_main_list_tv_delivery_money);
            tvLimited = itemView.findViewById(R.id.item_main_list_tv_limited);
            tvLimited_now = itemView.findViewById(R.id.item_main_list_tv_limited_now);
            tvTotal = itemView.findViewById(R.id.item_main_list_tv_total);


            // 뷰 객체에 대한 참조. (hold strong reference)

        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    public ItemRvAdapter(ArrayList<ItemRewardlist> list, Context context) {
        mData = list;
        mContext = context;
    }


    @NonNull
    @Override
    public ItemRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_main_reward, parent, false);
        ItemRvAdapter.ViewHolder vh = new ItemRvAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRvAdapter.ViewHolder holder, int position) {

        holder.tvMoney.setText(mData.get(position).getRewardPrice());
        holder.tvName.setText(mData.get(position).getRewardName());
        holder.tvContent.setText(mData.get(position).getRewardInfo());
        holder.tvDelivery_money.setText(mData.get(position).getShipping());
        holder.tvLimited.setText(mData.get(position).getQuantity());
        holder.tvLimited_now.setText(mData.get(position).getRemaining());
        holder.tvTotal.setText(mData.get(position).getCompletion());

    }


    @Override
    public int getItemCount() {
        if (mData != null )
            return mData.size();
        else return 0;
    }
}